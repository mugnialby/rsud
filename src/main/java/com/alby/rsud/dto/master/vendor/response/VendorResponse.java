package com.alby.rsud.dto.master.vendor.response;

import com.alby.rsud.entity.master.Bank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendorResponse {

    private Long id;

    private String vendorName;

    private Bank bank;

    private String bankAccountNumber;

    private String createdBy;

    private String createdAt;

    private String modifiedBy;

    private String modifiedAt;
}
