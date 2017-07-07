package com.greenfox.zoroo.controller;

import com.greenfox.zoroo.gameLogic.GeographicInfoGame;
import com.greenfox.zoroo.model.Game;
import com.greenfox.zoroo.model.GameType;
import com.greenfox.zoroo.model.Question;
import com.greenfox.zoroo.model.dto.UserProfileDto;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @Autowired
  GeographicInfoGame geographicInfoGame;

  @GetMapping(value = "/")
  public String getIndexPage() {
    Game game = new Game();
    game.setGameType(GameType.GEOGRAPHY);
    geographicInfoGame.setRandomCountry();
    geographicInfoGame.setQuestionText(game);
    geographicInfoGame.setRightAnswer(game);
    geographicInfoGame.setPossibleAnswersList(game);
    geographicInfoGame.setIndexOfTheRightAnswerInThePossibleAnswers();
    return "index";
  }

  @GetMapping(value = "/question")
  public String getQuestionPage(Model model) {
    UserProfileDto user = new UserProfileDto(1L, "Pistike");
    Question question = new Question();

    question.setQuestionText("18 + 24 = ?");
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
