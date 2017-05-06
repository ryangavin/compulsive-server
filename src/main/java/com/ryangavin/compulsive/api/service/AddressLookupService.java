package com.ryangavin.compulsive.api.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/6/17
 */
@Service
public class AddressLookupService {

    public BigDecimal getValueForAddress(String crypto, String address, String fiat) {
        return BigDecimal.ZERO;
    }

}
