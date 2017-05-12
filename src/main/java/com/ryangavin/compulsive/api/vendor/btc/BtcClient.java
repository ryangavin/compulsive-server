package com.ryangavin.compulsive.api.vendor.btc;

import com.ryangavin.compulsive.api.vendor.blockr.domain.AddressInfoData;
import com.ryangavin.compulsive.api.vendor.btc.domain.BtcResponse;
import feign.Param;
import feign.RequestLine;

/**
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/12/17
 */
public interface BtcClient {
    @RequestLine("GET /address/{address}")
    BtcResponse<AddressInfoData> getAddressInfo(@Param("address") String address);
}
