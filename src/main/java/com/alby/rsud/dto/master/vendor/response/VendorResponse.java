package com.alby.rsud.dto.master.vendor.response;

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

    private String createdBy;

    private String createdAt;

    private String modifiedBy;

    private String modifiedAt;
}
