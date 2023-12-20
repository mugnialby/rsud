package com.alby.rsud.controller.master;

import com.alby.rsud.dto.master.contract.request.ContractAddRequest;
import com.alby.rsud.dto.master.contract.request.ContractUpdateRequest;
import com.alby.rsud.service.master.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/master/")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @GetMapping("contracts")
    public String findAll(Model model) {
        model.addAttribute("contracts", contractService.findAll());
        return "master/contracts/contracts";
    }

    @GetMapping("contracts/add")
    public String add(Model model) {
        model.addAttribute("request", new ContractAddRequest());
        return "master/contracts/add_contract";
    }

    @PostMapping("contracts/submit")
    public String submit(@ModelAttribute("request") ContractAddRequest request) {
        Boolean valid = contractService.submit(request);
        if (valid) {
            return "redirect:/master/contracts";
        } else {
            return null;
        }
    }

    @GetMapping("contracts/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("contract", contractService.findById(id));
        return "master/contracts/edit_contract";
    }

    @PostMapping("contracts/update/{id}")
    public String update(
            @PathVariable Long id,
            @ModelAttribute("request") ContractUpdateRequest request,
            Model model
    ) {
        request.setId(id);
        if (contractService.update(request)) {
            return "redirect:/master/contracts";
        } else {
            return null;
        }
    }

    @GetMapping("contracts/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (contractService.delete(id)) {
            return "redirect:/master/contracts";
        } else {
            return null;
        }
    }
}
