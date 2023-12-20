package com.alby.rsud.utils.master;

import com.alby.rsud.dto.master.employee.request.EmployeeAddRequest;
import com.alby.rsud.dto.master.employee.request.EmployeeUpdateRequest;
import com.alby.rsud.dto.master.employee.response.EmployeeResponse;
import com.alby.rsud.entity.master.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUtils {

    private static final String DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm:ss";

    public static List<EmployeeResponse> mapEmployeeToEmployeeResponse(List<Employee> employees) {
        List<EmployeeResponse> employeeResponse = new ArrayList<>();

        for (Employee employee : employees) {
            employeeResponse.add(EmployeeResponse.builder()
                    .id(employee.getId())
                    .employeeName(employee.getEmployeeName())
                    .nik(employee.getNik())
                    .position(employee.getPosition())
                    .createdBy(employee.getCreatedBy())
//                    .createdAt(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
//                            .format(vendor.getCreatedAt()))
//                    .modifiedBy(vendor.getModifiedBy())
//                            .modifiedAt(null != vendor.getModifiedAt()
//                                    ? DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
//                                        .format(vendor.getModifiedAt()) : null)
                    .build());
        }

        return employeeResponse;
    }

    public static Employee mapEmployeeAddRequestToEmployee(EmployeeAddRequest request) {
        return Employee.builder()
                .employeeName(request.getEmployeeName())
                .nik(request.getNik())
                .position(request.getPosition())
                .build();
    }

    public static EmployeeResponse mapEmployeeToEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .employeeName(employee.getEmployeeName())
                .nik(employee.getNik())
                .position(employee.getPosition())
//                .createdBy(vendor.getCreatedBy())
//                .createdAt(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)
//                        .format(vendor.getCreatedAt()))
                .build();
    }

    public static Employee mapEmployeeUpdateRequestToEmployee(EmployeeUpdateRequest request) {
        return Employee.builder()
                .id(request.getId())
                .employeeName(request.getEmployeeName())
                .nik(request.getNik())
                .position(request.getPosition())
                .build();
    }
}
