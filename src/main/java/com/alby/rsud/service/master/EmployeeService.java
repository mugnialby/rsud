package com.alby.rsud.service.master;

import com.alby.rsud.dto.master.employee.request.EmployeeAddRequest;
import com.alby.rsud.dto.master.employee.request.EmployeeUpdateRequest;
import com.alby.rsud.dto.master.employee.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    List<EmployeeResponse> findAll();

    Boolean submit(EmployeeAddRequest request);

    EmployeeResponse findById(Long id);

    Boolean update(EmployeeUpdateRequest request);

    Boolean delete(Long id);
}
