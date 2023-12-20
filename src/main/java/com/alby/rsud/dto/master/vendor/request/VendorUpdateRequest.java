package com.alby.rsud.dto.master.vendor.request;

import com.alby.rsud.entity.master.Bank;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendorUpdateRequest {
    private Long id;

    @NotBlank
    @Length(max = 128)
    private String vendorName;

    private Bank bank;

    @NotBlank
    @Length(max = 36)
    private String bankAccountNumber;

    private String createdBy;

    private String modifiedBy;
}
