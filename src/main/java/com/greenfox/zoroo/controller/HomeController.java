package com.greenfox.zoroo.controller;

import com.greenfox.zoroo.model.Question;
import com.greenfox.zoroo.model.dto.UserProfileDto;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping(value = "/")
  public String getIndexPage() {
    return "index";
  }
}
