package com.alby.rsud.repository.master;

import com.alby.rsud.entity.master.Bank;
import com.alby.rsud.entity.master.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
}
