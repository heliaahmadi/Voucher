package com.helia.voucher.repository;

import com.helia.voucher.domain.Consumption;
import com.helia.voucher.domain.Definition;
import com.helia.voucher.domain.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {

    Consumption findFirstByVoucherAndUserId(Voucher voucher, Integer userId);

}
