package com.alby.rsud.dto.master.bank.request;

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
public class BankUpdateRequest {
    private Long id;

    @NotBlank
    @Length(max = 128)
    private String name;

    private String createdBy;

    private String modifiedBy;
}
