package com.alby.rsud.dto.master.contract.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractResponse {

    private Long id;

    private String name;

    private String createdBy;

    private String createdAt;

    private String modifiedBy;

    private String modifiedAt;
}
