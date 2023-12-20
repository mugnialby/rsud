package com.alby.rsud.service.master;

import com.alby.rsud.dto.master.bank.request.BankAddRequest;
import com.alby.rsud.dto.master.bank.request.BankUpdateRequest;
import com.alby.rsud.dto.master.bank.response.BankResponse;

import java.util.List;

public interface BankService {

    List<BankResponse> findAll();

    Boolean submit(BankAddRequest request);

    BankResponse findById(Long id);

    Boolean update(BankUpdateRequest request);

    Boolean delete(Long id);
}
