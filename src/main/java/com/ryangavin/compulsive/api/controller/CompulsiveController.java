package com.ryangavin.compulsive.api.controller;

import com.ryangavin.compulsive.api.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/2/17
 */
@RequestMapping("/")
@RestController
public class CompulsiveController {

    private final PriceService priceService;

    @Autowired
    public CompulsiveController(PriceService priceService) {
        this.priceService = priceService;
    }

    @RequestMapping("pricing")
    public Map<String, Map<String, BigDecimal>> getTotalPricingInfo() {
        return priceService.getPricing();
    }

    @RequestMapping("walletValue/{crypto}/{wallet}/{fiat}")
    public BigDecimal getValueOfWallet(@PathVariable String crypto,
                                       @PathVariable String wallet,
                                       @PathVariable String fiat) {
        return BigDecimal.ZERO;
    }

}
