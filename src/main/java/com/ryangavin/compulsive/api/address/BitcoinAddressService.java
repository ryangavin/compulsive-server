package com.ryangavin.compulsive.api.address;

import com.ryangavin.compulsive.api.vendor.btc.BtcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/6/17
 */
@Service
public class BitcoinAddressService extends AbstractAddressService {

    private final BtcClient btcClient;

    @Autowired
    public BitcoinAddressService(AddressServiceRegistry addressServiceRegistry, BtcClient btcClient) {
        super(addressServiceRegistry);
        this.btcClient = btcClient;
    }

    @Override
    public String getCrypto() {
        return "BTC";
    }

    @Override
    public BigDecimal getBalance(String address) {
        return btcClient.getAddressInfo(address).getData().getBalance()
                .setScale(16, BigDecimal.ROUND_HALF_UP)
                .divide(BigDecimal.valueOf(100000000), BigDecimal.ROUND_HALF_UP);
    }
}
