package com.greenfox.zoroo.controller;

import com.greenfox.zoroo.model.Question;
import com.greenfox.zoroo.model.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class HomeController {
  final String[] categories = {"Zászlók", "Főváros", "Matek", "Nevezetességek", "Java"};
  final String[] difficulties = {"Easy", "Medium", "Challenge"};


  @GetMapping(value = "/")
  public String getIndexPage() {
    return "index";
  }

  @GetMapping(value = "/main")
  public String getMenuPage(Model model) {
    UserProfile user = new UserProfile("Pistike");

    model.addAttribute("user", user);
    model.addAttribute("categories", Arrays.asList(categories));
    model.addAttribute("difficulties", Arrays.asList(difficulties));

    return "main";
  }

  @GetMapping(value = "/question")
  public String getQuestionPage(Model model) {
    UserProfile user = new UserProfile("Pistike");
    Question question = new Question();

    question.setQuestion("18 + 24 = ?");
    question.setGoodIndex(1);
    ArrayList<String> answers = new ArrayList<>();
    answers.add("42");
    answers.add("38");
    answers.add("15");
    answers.add("-6");
    question.setPossibleAnswers(answers);

    model.addAttribute("user", user);
    model.addAttribute("question", question);
    return "question";
  }
}
