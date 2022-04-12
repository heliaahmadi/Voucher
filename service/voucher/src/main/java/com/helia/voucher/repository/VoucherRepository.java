package com.helia.voucher.repository;

import com.helia.voucher.domain.Definition;
import com.helia.voucher.domain.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {

    List<Voucher> findAllByDefinition(Definition definition);
    Voucher findFirstByText(String text);


}