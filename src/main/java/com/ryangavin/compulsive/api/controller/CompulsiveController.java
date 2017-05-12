package com.ryangavin.compulsive.api.controller;

import com.ryangavin.compulsive.api.service.PriceService;
import com.ryangavin.compulsive.api.service.AddressLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/2/17
 */
@RequestMapping("/")
@RestController
public class CompulsiveController {

    private final PriceService priceService;
    private final AddressLookupService addressService;

    @Autowired
    public CompulsiveController(PriceService priceService,
                                AddressLookupService addressService) {
        this.priceService = priceService;
        this.addressService = addressService;
    }

    @RequestMapping("pricing")
    public Map<String, Map<String, BigDecimal>> getTotalPricingInfo() {
        return priceService.getPricing();
    }

    @RequestMapping("value/{crypto}/{address}/{fiat}")
    public @ResponseBody BigDecimal getValueOfAddress(@PathVariable String crypto,
                                                      @PathVariable String address,
                                                      @PathVariable String fiat) {
        return addressService.getValueForAddress(crypto, address, fiat);
    }

}
