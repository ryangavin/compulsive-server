package com.ryangavin.compulsive.api.address;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/6/17
 */
@Service
public class AddressServiceRegistry {

    private Map<String, AddressService> registry;

    public void register(String crypto, AddressService service) {
        registry.putIfAbsent(crypto, service);
    }

    public AddressService getServiceForCrypto(String crypto) {
        return registry.get(crypto);
    }

}
