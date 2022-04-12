package com.helia.voucher.repository;

import com.helia.voucher.domain.Definition;
import com.helia.voucher.domain.DefinitionUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DefinitionUserRepository extends JpaRepository<DefinitionUser, Long> {

    List<DefinitionUser> findAllByDefinition(Definition definition);
}
