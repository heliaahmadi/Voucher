package com.helia.voucher.constant;

import com.helia.voucher.domain.dto.Result;

public class VoucherNotExistException extends VoucherException {
    public VoucherNotExistException() {
        super(ResultStatuses.VOUCHER_NOT_EXIST);
    }
}
