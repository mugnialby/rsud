package com.alby.rsud.serviceimpl.master;

import com.alby.rsud.dto.master.contract.request.ContractAddRequest;
import com.alby.rsud.dto.master.contract.request.ContractUpdateRequest;
import com.alby.rsud.dto.master.contract.response.ContractResponse;
import com.alby.rsud.dto.master.position.request.PositionAddRequest;
import com.alby.rsud.dto.master.position.request.PositionUpdateRequest;
import com.alby.rsud.dto.master.position.response.PositionResponse;
import com.alby.rsud.entity.master.Contract;
import com.alby.rsud.entity.master.Position;
import com.alby.rsud.repository.master.ContractRepository;
import com.alby.rsud.repository.master.PositionRepository;
import com.alby.rsud.service.master.ContractService;
import com.alby.rsud.service.master.PositionService;
import com.alby.rsud.utils.master.ContractUtils;
import com.alby.rsud.utils.master.PositionUtils;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    private final Validator validator;

    @Override
    public List<ContractResponse> findAll() {
        return ContractUtils.mapContractsToContractsResponse(contractRepository.findAll());
    }

    @Override
    public Boolean submit(ContractAddRequest request) {
        validator.validate(request);

        Contract contract = ContractUtils.mapContractAddRequestToContract(request);
        contractRepository.save(contract);

        return null != contract.getId();
    }

    @Override
    public ContractResponse findById(Long id) {
        Optional<Contract> contract = contractRepository.findById(id);
        return contract.map(ContractUtils::mapContractToContractResponse).orElse(null);
    }

    @Override
    public Boolean update(ContractUpdateRequest request) {
        validator.validate(request);
        contractRepository.save(ContractUtils.mapContractUpdateRequestToContract(request));
        return true;
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Contract> contract = contractRepository.findById(id);
        if (contract.isPresent()) {
            contractRepository.delete(contract.get());
            return true;
        }

        return false;
    }
}
