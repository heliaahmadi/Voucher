package com.helia.voucher.constant;

public class AlreadyConsumedException extends VoucherException {
    public AlreadyConsumedException() {
        super(ResultStatuses.ALREADY_CONSUMED);
    }
}
