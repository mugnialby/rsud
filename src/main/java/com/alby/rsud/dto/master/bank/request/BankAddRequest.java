package com.alby.rsud.dto.master.bank.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAddRequest {

    @NotBlank
    @Length(max = 128)
    private String name;

//    @NotBlank
//    @Length(max = 100)
    private String createdBy;

//    @Length(max = 100)
    private String modifiedBy;
}
