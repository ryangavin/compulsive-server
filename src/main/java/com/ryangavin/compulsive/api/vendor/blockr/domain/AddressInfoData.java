package com.ryangavin.compulsive.api.vendor.blockr.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @link http://btc.blockr.io/api/v1/address/info/{{address}}
 *
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/10/17
 */
@Data
public class AddressInfoData {
    private String address;
    private Boolean is_unknown;
    private BigDecimal balance;
    private Boolean is_valid;

    // TODO add the rest of the response
}
