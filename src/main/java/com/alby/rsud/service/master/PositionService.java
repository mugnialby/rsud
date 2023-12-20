package com.alby.rsud.service.master;

import com.alby.rsud.dto.master.bank.request.BankAddRequest;
import com.alby.rsud.dto.master.bank.request.BankUpdateRequest;
import com.alby.rsud.dto.master.bank.response.BankResponse;
import com.alby.rsud.dto.master.position.request.PositionAddRequest;
import com.alby.rsud.dto.master.position.request.PositionUpdateRequest;
import com.alby.rsud.dto.master.position.response.PositionResponse;

import java.util.List;

public interface PositionService {

    List<PositionResponse> findAll();

    Boolean submit(PositionAddRequest request);

    PositionResponse findById(Long id);

    Boolean update(PositionUpdateRequest request);

    Boolean delete(Long id);
}
