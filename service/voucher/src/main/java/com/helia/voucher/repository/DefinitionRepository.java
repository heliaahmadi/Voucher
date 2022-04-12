package com.helia.voucher.repository;

import com.helia.voucher.domain.Definition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefinitionRepository extends JpaRepository<Definition, Long>{

}
