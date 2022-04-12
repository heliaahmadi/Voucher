package com.helia.voucher.controller;

import com.helia.voucher.constant.VoucherException;
import com.helia.voucher.domain.Definition;
import com.helia.voucher.domain.Voucher;
import com.helia.voucher.domain.dto.Result;
import com.helia.voucher.domain.dto.ValidatedDTO;
import com.helia.voucher.domain.dto.ValidationDTO;
import com.helia.voucher.service.VoucherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@AllArgsConstructor
@RestController
public class VoucherController {

    private VoucherService voucherService;


    @GetMapping("/bogus")
    public Definition bogus() {
        return null;
    }

    @PostMapping("/validate")
    public Result validate(@RequestBody ValidationDTO validationDTO) {
        try {
            return voucherService.validate(validationDTO);
        } catch (VoucherException e) {
            return e.getResult();
        }
    }


    @PostMapping("/consume")
    public Result consume(@RequestBody ValidationDTO validationDTO){
        try {
            return voucherService.consume(validationDTO);
        } catch (VoucherException e) {
            return e.getResult();
        }
    }

}
