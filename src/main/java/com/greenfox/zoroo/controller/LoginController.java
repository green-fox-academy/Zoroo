package com.greenfox.zoroo.controller;

import com.greenfox.zoroo.Repository.UserRepo;
import com.greenfox.zoroo.model.dto.LoginFormDto;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

  @Autowired
  UserRepo userRepo;

  @GetMapping(value = {"/login", "/login/"})
  public String showLoginPage(Model model, LoginFormDto loginFormDto) {
    model.addAttribute("loginFormDto", loginFormDto);
    return "login";
  }

  @PostMapping(value = {"/login", "/login/"})
  public String processLoginForm(@Valid LoginFormDto loginFormDto, Model model) {
    boolean usernameExist = userRepo.existsByUsername(loginFormDto.getUsername());
    boolean passwordExist = userRepo.existsByPassword(loginFormDto.getPassword());
    if (usernameExist && passwordExist) {
      System.out.println(
          "Username: " + loginFormDto.getUsername() + ", Password: " + loginFormDto.getPassword()
              + userRepo.findByUsername(loginFormDto.getUsername()).getUsername());
      return "redirect:/main";
    } else {
      model.addAttribute("error", "Username or Password are not correct!");
      return "login";
    }
  }
}
