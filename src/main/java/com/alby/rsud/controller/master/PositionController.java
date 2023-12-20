package com.alby.rsud.controller.master;

import com.alby.rsud.dto.master.bank.request.BankAddRequest;
import com.alby.rsud.dto.master.bank.request.BankUpdateRequest;
import com.alby.rsud.dto.master.position.request.PositionAddRequest;
import com.alby.rsud.dto.master.position.request.PositionUpdateRequest;
import com.alby.rsud.service.master.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/master/")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @GetMapping("positions")
    public String findAll(Model model) {
        model.addAttribute("positions", positionService.findAll());
        return "master/positions/positions";
    }

    @GetMapping("positions/add")
    public String add(Model model) {
        model.addAttribute("request", new PositionAddRequest());
        return "master/positions/add_position";
    }

    @PostMapping("positions/submit")
    public String submit(@ModelAttribute("request") PositionAddRequest request) {
        Boolean valid = positionService.submit(request);
        if (valid) {
            return "redirect:/master/positions";
        } else {
            return null;
        }
    }

    @GetMapping("positions/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("position", positionService.findById(id));
        return "master/positions/edit_position";
    }

    @PostMapping("positions/update/{id}")
    public String updatePositions(
            @PathVariable Long id,
            @ModelAttribute("request") PositionUpdateRequest request,
            Model model
    ) {
        request.setId(id);
        if (positionService.update(request)) {
            return "redirect:/master/positions";
        } else {
            return null;
        }
    }

    @GetMapping("positions/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (positionService.delete(id)) {
            return "redirect:/master/positions";
        } else {
            return null;
        }
    }
}
