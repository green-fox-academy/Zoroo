package com.greenfox.zoroo.controller;

import com.greenfox.zoroo.Repository.GeographicInfoRepo;
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

  @Autowired
  GeographicInfoRepo geographicInfoRepo;

  @GetMapping(value = {"/login", "/login/"})
  public String getLoginPage(Model model, LoginFormDto loginFormDto) {
    model.addAttribute("loginFormDto", loginFormDto);
    model.addAttribute("error", "Nem én voltam");
    return "login";
  }

  @PostMapping(value = {"/login", "/login/"})
  public String processLoginForm(@Valid LoginFormDto loginFormDto, Model model) {
    boolean usernameExist = userRepo.existsByUsername(loginFormDto.getUsername());
    boolean passwordExist = userRepo.existsByPassword(loginFormDto.getPassword());
    if (usernameExist && passwordExist) {
      System.out.println(
          "Username: " + loginFormDto.getUsername() + ", Password: " + loginFormDto.getPassword());
      System.out.println(geographicInfoRepo.findAll().get(0).getCountry());
      return "redirect:/main";
    } else {
      model.addAttribute("error", "Username or Password are not correct!");
      return "login";
    }
  }

  @GetMapping(value = {"/register", "/register/"})
  public String getRegisterPage(Model model, LoginFormDto loginFormDto) {
    model.addAttribute("loginDto", loginFormDto);
    return "register";
  }
}
