package com.ua.tagency.controller;

import com.ua.tagency.dto.RegisterDto;
import com.ua.tagency.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BaseController {

    private final PersonService personService;

    @Autowired
    public BaseController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("registerModel", new RegisterDto());
        return "register";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/admin")
    public String showAdmin() {
        return "admin";
    }
    @PostMapping("/register")
    public String createUser(@ModelAttribute("registerModel") @Valid RegisterDto registerDto, BindingResult result) {
        if(result.hasErrors()) {
            return "register";
        }
        personService.register(registerDto);
        return "redirect:/login";
    }
}
