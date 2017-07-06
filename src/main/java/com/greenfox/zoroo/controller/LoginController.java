package com.greenfox.zoroo.controller;

import com.greenfox.zoroo.model.dto.LoginFormDto;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

  @GetMapping(value = {"/login", "/login/"})
  public String showLoginPage(Model model, LoginFormDto loginFormDto) {
    model.addAttribute("loginFormDto", loginFormDto);
    return "login";
  }

  @PostMapping(value = {"/login", "/login/"})
  public String processLoginForm(@Valid LoginFormDto loginFormDto) {

    System.out.println("Username: " + loginFormDto.getUsername() + ", Password: " + loginFormDto.getPassword());
    return "main";
  }
}
