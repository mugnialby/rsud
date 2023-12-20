package com.alby.rsud.serviceimpl.master;

import com.alby.rsud.dto.master.employee.request.EmployeeAddRequest;
import com.alby.rsud.dto.master.employee.request.EmployeeUpdateRequest;
import com.alby.rsud.dto.master.employee.response.EmployeeResponse;
import com.alby.rsud.entity.master.Employee;
import com.alby.rsud.repository.master.EmployeeRepository;
import com.alby.rsud.service.master.EmployeeService;
import com.alby.rsud.utils.master.EmployeeUtils;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final Validator validator;

    @Override
    public List<EmployeeResponse> findAll() {
        return EmployeeUtils.mapEmployeeToEmployeeResponse(employeeRepository.findAll());
    }

    @Override
    public Boolean submit(EmployeeAddRequest request) {
        validator.validate(request);

        Employee employee = EmployeeUtils.mapEmployeeAddRequestToEmployee(request);
        employeeRepository.save(employee);

        return null != employee.getId();
    }

    @Override
    public EmployeeResponse findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(EmployeeUtils::mapEmployeeToEmployeeResponse).orElse(null);
    }

    @Override
    public Boolean update(EmployeeUpdateRequest request) {
        validator.validate(request);
        employeeRepository.save(EmployeeUtils.mapEmployeeUpdateRequestToEmployee(request));
        return true;
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.delete(employee.get());
            return true;
        }

        return false;
    }
}
