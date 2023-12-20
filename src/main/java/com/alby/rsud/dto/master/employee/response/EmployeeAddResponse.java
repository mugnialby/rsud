package com.alby.rsud.dto.master.employee.response;

import com.alby.rsud.entity.master.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAddResponse {
    private Long id;

    private String employeeName;

    private String nik;

    private Position position;

    private String createdBy;

    private String createdAt;
}
