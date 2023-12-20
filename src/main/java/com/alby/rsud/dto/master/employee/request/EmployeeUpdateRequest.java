package com.alby.rsud.dto.master.employee.request;

import com.alby.rsud.entity.master.Position;
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
public class EmployeeUpdateRequest {
    private Long id;

    @NotBlank
    @Length(max = 128)
    private String employeeName;

    @NotBlank
    @Length(max = 128)
    private String nik;

    private Position position;

    private String createdBy;

    private String modifiedBy;
}
