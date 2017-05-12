package com.ryangavin.compulsive.api.service;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Connects to the CryptoCompare API websocket and listens for realtime pricing data
 *
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/2/17
 */
@Slf4j
@Component
public class PriceService  {

    // Subscriptions
    // TODO make this configurable in the yml
    private String[] subscriptions = {"5~CCCAGG~BTC~USD", "5~CCCAGG~ETH~USD"};

    // Map of Crypto currencies to a Map of Fiat currencies to Values
    @Getter
    private Map<String, Map<String, BigDecimal>> pricing = new HashMap<>();

    // Socket.io socket
    private Socket socket;

    @Data
    static class CryptoCompareResponse {
        private Integer messageType;
        private String subscriptionType;
        private String crypto;
        private String fiat;
        private Integer flag;
        private BigDecimal price;

        static CryptoCompareResponse unpack(String message) {
            String[] split = message.split("~");

            CryptoCompareResponse response = new CryptoCompareResponse();
            response.setMessageType(Integer.parseInt(split[0]));

            if (split.length >= 5) {
                response.setSubscriptionType(split[1]);
                response.setCrypto(split[2]);
                response.setFiat(split[3]);
                response.setFlag(Integer.parseInt(split[4]));
                response.setPrice(BigDecimal.valueOf(Double.parseDouble(split[5])));
            }
            return response;
        }
    }

    private void updatePricing(CryptoCompareResponse response) {
        log.debug("Current {} price in {}: {}", response.getCrypto(), response.getFiat(), response.getPrice());
        pricing.putIfAbsent(response.getCrypto(), new HashMap<>());
        Map<String, BigDecimal> fiatToCrypto = pricing.get(response.getCrypto());
        fiatToCrypto.put(response.getFiat(), response.getPrice());
    }

    @PostConstruct
    public void init() throws Exception {
        socket = IO.socket("https://streamer.cryptocompare.com/");

        socket
            .on(Socket.EVENT_CONNECT, args -> {
                Map<String, Object> eventArgs = new HashMap<>();

                eventArgs.put("subs", Arrays.asList(subscriptions));

                socket.emit("SubAdd", eventArgs);
            })
            .on("m", args -> Stream.of(args).forEach(arg -> {
                // Log the raw message for debug
                log.trace("Raw message: "+arg);

                CryptoCompareResponse response = CryptoCompareResponse.unpack((String) arg);
                if (response.getMessageType() == 5 && (response.getFlag() == 1 || response.getFlag() == 2)) {
                    updatePricing(response);
                }
            }))
            .on(Socket.EVENT_DISCONNECT, args -> log.info("Received disconnect event"));

        socket.connect();
    }
}
