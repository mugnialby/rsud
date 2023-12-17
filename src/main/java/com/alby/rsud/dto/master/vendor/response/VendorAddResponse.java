package com.alby.rsud.dto.master.vendor.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendorAddResponse {
    private Long id;

    private String vendorName;

    private String createdBy;

    private String createdAt;
}
