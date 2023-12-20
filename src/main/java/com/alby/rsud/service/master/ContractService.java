package com.alby.rsud.service.master;

import com.alby.rsud.dto.master.contract.request.ContractAddRequest;
import com.alby.rsud.dto.master.contract.request.ContractUpdateRequest;
import com.alby.rsud.dto.master.contract.response.ContractResponse;

import java.util.List;

public interface ContractService {

    List<ContractResponse> findAll();

    Boolean submit(ContractAddRequest request);

    ContractResponse findById(Long id);

    Boolean update(ContractUpdateRequest request);

    Boolean delete(Long id);
}
