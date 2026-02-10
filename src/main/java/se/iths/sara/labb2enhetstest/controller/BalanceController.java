package se.iths.sara.labb2enhetstest.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.iths.sara.labb2enhetstest.service.ATMService;

@Controller
public class BalanceController {
    ATMService atmService;

    public BalanceController(ATMService atmService) {
        this.atmService = atmService;
    }

    @GetMapping("/balance")
    public String balance(Model model) {
        model.addAttribute("balance", atmService.getBalance());
        return "balance";
    }
}
