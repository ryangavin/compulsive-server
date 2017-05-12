package com.ryangavin.compulsive.api.vendor.btc.domain;

import lombok.Data;

/**
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/12/17
 */
@Data
public class BtcResponse<T> {
    private Integer err_no;
    private T data;
}
