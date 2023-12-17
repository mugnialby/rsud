package com.alby.rsud.dto.master.vendor.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendorUpdateRequest {
    private Long id;

    private String vendorName;

    private String createdBy;

    private String modifiedBy;
}
