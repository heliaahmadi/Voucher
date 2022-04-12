package com.helia.voucher.repository;

import com.helia.voucher.domain.Definition;
import com.helia.voucher.domain.DefinitionProduct;
import com.helia.voucher.domain.Voucher;
import com.helia.voucher.domain.dto.PurchaseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DefinitionProductRepository extends JpaRepository<DefinitionProduct, Long> {

    List<DefinitionProduct> findAllByDefinition(Definition definition);

    DefinitionProduct findFirstByProductId(Long productId);

}
