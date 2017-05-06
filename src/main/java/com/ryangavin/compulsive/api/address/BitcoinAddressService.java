package com.ryangavin.compulsive.api.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/6/17
 */
@Service
public class BitcoinAddressService extends AbstractAddressService {

    @Autowired
    public BitcoinAddressService(AddressServiceRegistry addressServiceRegistry) {
        super(addressServiceRegistry);
    }

    @Override
    public String getCrypto() {
        return "BTC";
    }

    @Override
    public BigDecimal getBalance(String address) {
        return null;
    }
}
