package com.ryangavin.compulsive.api.address;

/**
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/6/17
 */
public abstract class AbstractAddressService implements AddressService {

    public AbstractAddressService(AddressServiceRegistry addressServiceRegistry) {
        addressServiceRegistry.register(getCrypto(), this);
    }

}
