package com.helia.voucher.constant;

import com.helia.voucher.domain.dto.Result;

public class VoucherException extends Exception {

    private Result result;

    protected VoucherException(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }
}
