package com.ryangavin.compulsive.api.vendor.btc;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/10/17
 */
@Configuration
public class BtcClientConfig {

    @Bean
    public BtcClient btcClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(BtcClient.class, "https://chain.api.btc.com/v3");
    }

}
