package com.alby.rsud.controller.master;

import com.alby.rsud.dto.master.bank.request.BankAddRequest;
import com.alby.rsud.dto.master.bank.request.BankUpdateRequest;
import com.alby.rsud.service.master.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/master/")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @GetMapping("banks")
    public String findAll(Model model) {
        model.addAttribute("banks", bankService.findAll());
        return "master/banks/banks";
    }

    @GetMapping("banks/add")
    public String add(Model model) {
        model.addAttribute("request", new BankAddRequest());
        return "master/banks/add_bank";
    }

    @PostMapping("banks/submit")
    public String submit(@ModelAttribute("request") BankAddRequest request) {
        Boolean valid = bankService.submit(request);
        if (valid) {
            return "redirect:/master/banks";
        } else {
            return null;
        }
    }

    @GetMapping("banks/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("bank", bankService.findById(id));
        return "master/banks/edit_bank";
    }

    @PostMapping("banks/update/{id}")
    public String updateBank(
            @PathVariable Long id,
            @ModelAttribute("request") BankUpdateRequest request,
            Model model
    ) {
        request.setId(id);
        if (bankService.update(request)) {
            return "redirect:/master/banks";
        } else {
            return null;
        }
    }

    @GetMapping("banks/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (bankService.delete(id)) {
            return "redirect:/master/banks";
        } else {
            return null;
        }
    }
}
