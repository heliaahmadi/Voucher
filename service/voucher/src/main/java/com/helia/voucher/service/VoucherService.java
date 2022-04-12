package com.helia.voucher.service;

import com.helia.voucher.constant.*;
import com.helia.voucher.domain.Consumption;
import com.helia.voucher.domain.Definition;
import com.helia.voucher.domain.DefinitionProduct;
import com.helia.voucher.domain.Voucher;
import com.helia.voucher.domain.dto.PurchaseDTO;
import com.helia.voucher.domain.dto.Result;
import com.helia.voucher.domain.dto.ValidatedDTO;
import com.helia.voucher.domain.dto.ValidationDTO;
import com.helia.voucher.repository.ConsumptionRepository;
import com.helia.voucher.repository.DefinitionProductRepository;
import com.helia.voucher.repository.DefinitionRepository;
import com.helia.voucher.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private ConsumptionRepository consumptionRepository;

    @Autowired
    private DefinitionProductRepository definitionProductRepository;


    public Result validate(ValidationDTO validationDTO) throws VoucherException {


        Voucher voucher = voucherRepository.findFirstByText(validationDTO.getVoucher());
        if (voucher == null)
            throw new VoucherNotExistException();

        Consumption alreadyExistConsumption = consumptionRepository.findFirstByVoucherAndUserId(voucher, validationDTO.getUserId());
        if (alreadyExistConsumption != null)
            throw new AlreadyConsumedException();


        Definition definition = voucher.getDefinition();

        Date now = new Date();
        if (definition.getStartTime() != null && now.before(definition.getStartTime()))
            throw new NotStartedYetException();

        if (definition.getEndTime() != null && now.after(definition.getEndTime()))
            throw new TimePassedException();


        List<PurchaseDTO> cart = validationDTO.getCart();
        int overall = 0;
        int contain = 0;
        for (PurchaseDTO purchaseDTO : cart) {
            DefinitionProduct definitionProduct = definitionProductRepository.findFirstByProductId(purchaseDTO.getProductId());

            overall+= purchaseDTO.getPrice();
            if (definitionProduct!=null) {

                contain+=purchaseDTO.getPrice();

            }

        }

        int discount=0;
        if(definition.getType()==Definition.Type.RAW && contain>=definition.getAmount()){
            discount= definition.getAmount();
        } else if (definition.getType()==Definition.Type.PERCENTAGE){
            discount= contain * definition.getAmount()/100;
        }

        int payable=overall-discount;


        ValidatedDTO result = new ValidatedDTO();
        result.setCode(ResultStatuses.OK.getCode());
        result.setDescription(ResultStatuses.OK.getDescription());
        result.setPrice(overall);
        result.setDiscount(discount);
        result.setPayable(payable);


        return result;


}

    public Result consume(ValidationDTO validationDTO) throws VoucherException {
        ValidatedDTO validatedDTO = (ValidatedDTO) validate(validationDTO);

        Voucher voucher = voucherRepository.findFirstByText(validationDTO.getVoucher());

        Consumption consumption = new Consumption();
        consumption.setUserId(validationDTO.getUserId());
        consumption.setVoucher(voucher);
        consumptionRepository.save(consumption);

        return validatedDTO;
    }
}