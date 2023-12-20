package com.alby.rsud.controller.medsupport;

import com.alby.rsud.dto.medsupport.request.MedSupportAddRequest;
import com.alby.rsud.dto.medsupport.request.MedSupportUpdateRequest;
import com.alby.rsud.service.master.ContractService;
import com.alby.rsud.service.master.EmployeeService;
import com.alby.rsud.service.medsupport.MedSupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MedSupportController {

    private final MedSupportService medSupportService;

    private final ContractService contractService;

    private final EmployeeService employeeService;

    @GetMapping("medSupports")
    public String findAll(Model model) {
        model.addAttribute("medSupports", medSupportService.findAll());
        return "medSupports/medSupports";
    }

    @GetMapping("medSupports/add")
    public String add(Model model) {
        model.addAttribute("request", new MedSupportAddRequest());
        model.addAttribute("contracts", contractService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        return "medSupports/add_medSupport";
    }

    @PostMapping("medSupports/submit")
    public String submit(@ModelAttribute("request") MedSupportAddRequest request) {
        Boolean valid = medSupportService.submit(request);
        if (valid) {
            return "redirect:/medSupports";
        } else {
            return null;
        }
    }

    @GetMapping("medSupports/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("medSupport", medSupportService.findById(id));
        model.addAttribute("contracts", contractService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        return "medSupports/edit_medSupport";
    }

    @PostMapping("medSupports/update/{id}")
    public String update(
            @PathVariable Long id,
            @ModelAttribute("request") MedSupportUpdateRequest request,
            Model model
    ) {
        request.setId(id);
        if (medSupportService.update(request)) {
            return "redirect:/medSupports";
        } else {
            return null;
        }
    }

    @GetMapping("medSupports/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (medSupportService.delete(id)) {
            return "redirect:/medSupports";
        } else {
            return null;
        }
    }
}
