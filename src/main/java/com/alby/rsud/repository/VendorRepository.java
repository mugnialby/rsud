package com.alby.rsud.repository;

import com.alby.rsud.entity.master.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
