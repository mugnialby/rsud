package com.alby.rsud.dto.master.contract.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractAddResponse {
    private Long id;

    private String name;

    private String createdBy;

    private String createdAt;
}
