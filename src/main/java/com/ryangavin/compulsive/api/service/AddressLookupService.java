package com.ryangavin.compulsive.api.service;

import com.ryangavin.compulsive.api.address.AddressService;
import com.ryangavin.compulsive.api.address.AddressServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * TODO add so much error checking
 *
 * Looks up the current value of an address
 *
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/6/17
 */
@Service
public class AddressLookupService {

    private final AddressServiceRegistry addressServiceRegistry;

    private final PriceService priceService;

    @Autowired
    public AddressLookupService(AddressServiceRegistry addressServiceRegistry, PriceService priceService) {
        this.addressServiceRegistry = addressServiceRegistry;
        this.priceService = priceService;
    }

    public BigDecimal getValueForAddress(String crypto, String address, String fiat) {
        AddressService service = addressServiceRegistry.getServiceForCrypto(crypto);
        if (service != null) {
            BigDecimal balance = service.getBalance(address);

            if (balance != null) {
                BigDecimal price = priceService.getPricing().get(crypto).get(fiat);

                return balance.multiply(price);
            }
        }

        return BigDecimal.ZERO;
    }

}
