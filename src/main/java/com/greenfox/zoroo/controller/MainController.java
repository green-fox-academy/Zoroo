package com.greenfox.zoroo.controller;

import com.greenfox.zoroo.model.NavLink;
import com.greenfox.zoroo.model.dto.GameStartDto;
import com.greenfox.zoroo.model.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

@Controller
public class MainController {

  @ModelAttribute
  public void addAttributes(Model model) {
    ArrayList<NavLink> links = new ArrayList<>();
    links.add(new NavLink("/main", "Játék"));
    links.add(new NavLink("/statistics", "Statisztika"));
    links.add(new NavLink("/logout", "Kijelentkezés"));
    model.addAttribute("nav", links);
  }

  @GetMapping(value = {"/main", "/main/"})
  public String getMainPage(Model model) {
    model.addAttribute("user", new UserDto("Jancsi"));
    model.addAttribute("game", new GameStartDto());
    return "main";
  }

  @GetMapping(value ="/statistics")
  public String getStatistics(Model model) {
    model.addAttribute("user", new UserDto("Jancsi"));
    return "statistics";
  }

}
