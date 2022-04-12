package com.helia.voucher.constant;

public class TimePassedException extends VoucherException {
    public TimePassedException() {
        super(ResultStatuses.THE_TIME_IS_PASSED);
    }
}
