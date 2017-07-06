package com.greenfox.zoroo.controller;

import com.greenfox.zoroo.model.Question;
import com.greenfox.zoroo.model.UserProfile;
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
