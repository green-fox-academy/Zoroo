package com.greenfox.zoroo.controller;

import com.greenfox.zoroo.Repository.UserRepo;
import com.greenfox.zoroo.model.NavLink;
import com.greenfox.zoroo.model.UserProfile;
import com.greenfox.zoroo.model.dto.GameStartDto;
import com.greenfox.zoroo.model.dto.UserDto;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MainController {

  private final GameStartDto gameStartDto;
  private final UserRepo userRepo;

  @Autowired
  public MainController(GameStartDto gameStartDto, UserRepo userRepo) {
    this.gameStartDto = gameStartDto;
    this.userRepo = userRepo;
  }

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
    UserProfile loggedInUser = userRepo.findOne(1L);

    model.addAttribute("user",
        UserDto.builder()
            .userId(loggedInUser.getId())
            .username(loggedInUser.getUsername())
            .build());

    model.addAttribute("game", gameStartDto);
    return "main";
  }

  @GetMapping(value = "/statistics")
  public String getStatistics(Model model) {
    model.addAttribute("user", UserDto.builder().username("Jancsi").userId(1L).build());
    return "statistics";
  }

}
