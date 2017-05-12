package com.ryangavin.compulsive.api.vendor.blockr;

import com.ryangavin.compulsive.api.vendor.blockr.domain.AddressInfoData;
import com.ryangavin.compulsive.api.vendor.blockr.domain.BlockrResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * TODO refactor this into another project and open source it
 *
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/10/17
 */
public interface BlockrClient {

    @RequestLine("GET /address/info/{address}")
    @Headers("Accept: application/json; User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36")
    BlockrResponse<AddressInfoData> getAddressInfo(@Param("address") String address);

}
