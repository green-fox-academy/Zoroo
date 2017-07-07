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
    geographicInfoGame.playGeographicGame(game);
//    geographicInfoGame.setRandomCountry();
//    geographicInfoGame.setQuestionText(game);
//    geographicInfoGame.setRightAnswer(game);
//    geographicInfoGame.setPossibleAnswersListForGeographic(game);
//    geographicInfoGame.setIndexOfTheRightAnswerInThePossibleAnswers();
    return "index";
  }
}
