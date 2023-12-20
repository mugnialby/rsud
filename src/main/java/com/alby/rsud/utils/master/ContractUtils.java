package com.alby.rsud.utils.master;

import com.alby.rsud.dto.master.contract.request.ContractAddRequest;
import com.alby.rsud.dto.master.contract.request.ContractUpdateRequest;
import com.alby.rsud.dto.master.contract.response.ContractResponse;
import com.alby.rsud.dto.master.position.request.PositionAddRequest;
import com.alby.rsud.dto.master.position.request.PositionUpdateRequest;
import com.alby.rsud.dto.master.position.response.PositionResponse;
import com.alby.rsud.entity.master.Contract;
import com.alby.rsud.entity.master.Position;

import java.util.ArrayList;
import java.util.List;

public class ContractUtils {

    private static final String DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm:ss";
    public static List<ContractResponse> mapContractsToContractsResponse(List<Contract> contracts) {
        List<ContractResponse> contractResponse = new ArrayList<>();

        for (Contract contract : contracts) {
            contractResponse.add(ContractResponse.builder()
                    .id(contract.getId())
                    .name(contract.getName())
                    .createdBy(contract.getCreatedBy())
//                    .createdAt(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
//                            .format(vendor.getCreatedAt()))
//                    .modifiedBy(vendor.getModifiedBy())
//                            .modifiedAt(null != vendor.getModifiedAt()
//                                    ? DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
//                                        .format(vendor.getModifiedAt()) : null)
                    .build());
        }

        return contractResponse;
    }

    public static Contract mapContractAddRequestToContract(ContractAddRequest request) {
        return Contract.builder()
                .name(request.getName())
                .build();
    }

    public static ContractResponse mapContractToContractResponse(Contract contract) {
        return ContractResponse.builder()
                .id(contract.getId())
                .name(contract.getName())
//                .createdBy(vendor.getCreatedBy())
//                .createdAt(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
//                        .format(vendor.getCreatedAt()))
                .build();
    }

    public static Contract mapContractUpdateRequestToContract(ContractUpdateRequest request) {
        return Contract.builder()
                .id(request.getId())
                .name(request.getName())
                .build();
    }
}
