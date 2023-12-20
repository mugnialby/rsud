package com.alby.rsud.dto.master.vendor.response;

import com.alby.rsud.entity.master.Bank;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendorAddResponse {
    private Long id;

    private String vendorName;

    private Bank bank;

    private String bankAccountNumber;

    private String createdBy;

    private String createdAt;
}
