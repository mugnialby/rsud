package com.alby.rsud.controller.master;

import com.alby.rsud.dto.master.employee.request.EmployeeAddRequest;
import com.alby.rsud.dto.master.employee.request.EmployeeUpdateRequest;
import com.alby.rsud.service.master.EmployeeService;
import com.alby.rsud.service.master.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/master/")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    private final PositionService positionService;

    @GetMapping("employees")
    public String findAll(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "master/employees/employees";
    }

    @GetMapping("employees/add")
    public String add(Model model) {
        model.addAttribute("request", new EmployeeAddRequest());
        model.addAttribute("positions", positionService.findAll());
        return "master/employees/add_employee";
    }

    @PostMapping("employees/submit")
    public String submit(@ModelAttribute("request") EmployeeAddRequest request) {
        Boolean valid = employeeService.submit(request);
        if (valid) {
            return "redirect:/master/employees";
        } else {
            return null;
        }
    }

    @GetMapping("employees/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("positions", positionService.findAll());
        return "master/employees/edit_employee";
    }

    @PostMapping("employees/update/{id}")
    public String updateBank(
            @PathVariable Long id,
            @ModelAttribute("request") EmployeeUpdateRequest request,
            Model model
    ) {
        request.setId(id);
        if (employeeService.update(request)) {
            return "redirect:/master/employees";
        } else {
            return null;
        }
    }

    @GetMapping("employees/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (employeeService.delete(id)) {
            return "redirect:/master/employees";
        } else {
            return null;
        }
    }
}
