package com.alby.rsud.dto.master.employee.request;

import com.alby.rsud.entity.master.Position;
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
public class EmployeeAddRequest {

    @NotBlank
    @Length(max = 128)
    private String employeeName;

    @NotBlank
    @Length(max = 128)
    private String nik;

    private Position position;

//    @NotBlank
//    @Length(max = 100)
    private String createdBy;

//    @Length(max = 100)
    private String modifiedBy;
}
