package com.alby.rsud.controller.master;

import com.alby.rsud.dto.master.vendor.request.VendorAddRequest;
import com.alby.rsud.dto.master.vendor.request.VendorUpdateRequest;
import com.alby.rsud.service.master.BankService;
import com.alby.rsud.service.master.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/master/")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;

    private final BankService bankService;

    @GetMapping("vendors")
    public String findAll(Model model) {
        model.addAttribute("vendors", vendorService.findAll());
        return "master/vendors/vendors";
    }

    @GetMapping("vendors/add")
    public String add(Model model) {
        model.addAttribute("request", new VendorAddRequest());
        model.addAttribute("banks", bankService.findAll());
        return "master/vendors/add_vendor";
    }

    @PostMapping("vendors/submit")
    public String submit(@ModelAttribute("request") VendorAddRequest request) {
        Boolean valid = vendorService.submit(request);
        if (valid) {
            return "redirect:/master/vendors";
        } else {
            return null;
        }
    }

    @GetMapping("vendors/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("vendor", vendorService.findById(id));
        model.addAttribute("banks", bankService.findAll());
        return "master/vendors/edit_vendor";
    }

    @PostMapping("vendors/update/{id}")
    public String updateVendor(
            @PathVariable Long id,
            @ModelAttribute("request")VendorUpdateRequest request,
            Model model
    ) {
        request.setId(id);
        if (vendorService.update(request)) {
            return "redirect:/master/vendors";
        } else {
            return null;
        }
    }

    @GetMapping("vendors/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (vendorService.delete(id)) {
            return "redirect:/master/vendors";
        } else {
            return null;
        }
    }
}
