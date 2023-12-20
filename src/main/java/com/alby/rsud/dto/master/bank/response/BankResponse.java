package com.alby.rsud.dto.master.bank.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankResponse {

    private Long id;

    private String name;

    private String createdBy;

    private String createdAt;

    private String modifiedBy;

    private String modifiedAt;
}
