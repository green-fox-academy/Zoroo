package com.greenfox.zoroo.controller;

import com.greenfox.zoroo.model.dto.GameStartDto;
import com.greenfox.zoroo.model.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping(value = {"/main", "/main/"})
  public String showMainPage(Model model) {
    model.addAttribute("user", new UserDto("Jancsi"));
    model.addAttribute("game", new GameStartDto());
    return "main";
  }
}
