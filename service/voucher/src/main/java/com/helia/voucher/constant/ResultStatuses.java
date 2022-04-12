package com.helia.voucher.constant;

import com.helia.voucher.domain.dto.Result;

public interface ResultStatuses {

    public static final Result OK = new Result(0, "valid");
    public static final Result VOUCHER_NOT_EXIST = new Result(-11, "invalid voucher");
    public static final Result ALREADY_CONSUMED = new Result(-12, "you consumed the voucher");
    public static final Result NOT_STARTED_YET = new Result(-13 ,"now<startTime");
    public static final Result THE_TIME_IS_PASSED = new Result(-14 ,"now>endTime");
}
