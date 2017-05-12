package com.ryangavin.compulsive.api.vendor.blockr;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/10/17
 */
@Configuration
public class BlockrClientConfig {

    @Bean
    public BlockrClient blockrClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(BlockrClient.class, "http://btc.blockr.io/api/v1");
    }

}
