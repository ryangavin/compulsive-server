package com.ryangavin.compulsive.api.address;

import java.math.BigDecimal;

/**
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/6/17
 */
public interface AddressService {

    /**
     * @return String representing the currency
     */
    String getCrypto();

    /**
     * Get the amount of crypto in this address
     * @return The amount of crypto at this address
     */
    BigDecimal getBalance(String address);

}
