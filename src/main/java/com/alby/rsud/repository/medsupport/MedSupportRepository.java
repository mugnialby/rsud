package com.alby.rsud.repository.medsupport;

import com.alby.rsud.entity.medsupport.MedSupportHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedSupportRepository extends JpaRepository<MedSupportHeader, Long> {
}
