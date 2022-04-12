package com.helia.voucher.constant;

public class NotStartedYetException extends VoucherException {
    public NotStartedYetException() {
        super(ResultStatuses.NOT_STARTED_YET);
    }
}
