package com.alby.rsud.repository.master;

import com.alby.rsud.entity.master.Bank;
import com.alby.rsud.entity.master.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
}
