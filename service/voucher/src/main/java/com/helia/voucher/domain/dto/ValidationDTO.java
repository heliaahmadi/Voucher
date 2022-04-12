package com.helia.voucher.domain.dto;

import java.util.List;

public class ValidationDTO {

    private List<PurchaseDTO> cart;
    private Integer userId;
    private String voucher;

    public List<PurchaseDTO> getCart() {
        return cart;
    }

    public void setCart(List<PurchaseDTO> cart) {
        this.cart = cart;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }
}
