package com.ryangavin.compulsive.api.vendor.blockr.domain;

import lombok.Data;

/**
 * @author Ryan Gavin (rgavin@mediamorph.com)
 *         Created on 5/10/17
 */
@Data
public abstract class BlockrResponse <T> {
    private String status;
    private T data;
    private Integer code;
    private String message;
}
