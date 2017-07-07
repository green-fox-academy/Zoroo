package com.greenfox.zoroo.controller;

import com.greenfox.zoroo.Repository.UserRepo;
import com.greenfox.zoroo.gameLogic.GeographicInfoGame;
import com.greenfox.zoroo.model.Game;
import com.greenfox.zoroo.model.GameType;
import com.greenfox.zoroo.model.Question;
import com.greenfox.zoroo.model.UserProfile;
import com.greenfox.zoroo.model.dto.GameDto;
import com.greenfox.zoroo.model.dto.GameStartDto;
import com.greenfox.zoroo.model.dto.UserProfileDto;
import com.greenfox.zoroo.service.GameService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {

  private final GameService gameService;
  private final GeographicInfoGame geographicInfoGame;
  private final UserRepo userRepo;

  @Autowired
  public GameController(
      GameService gameService,
      GeographicInfoGame geographicInfoGame,
      UserRepo userRepo) {
    this.gameService = gameService;
    this.geographicInfoGame = geographicInfoGame;
    this.userRepo = userRepo;
  }

  @PostMapping(value = "/question")
  public String getQuestionPage(GameDto game, Model model) {

    gameService.createNewGame(game);

    Question question = new Question();

    question.setQuestionText("18 + 24 = ?");
    question.setGoodAnswerIndex(1);
    ArrayList<String> answers = new ArrayList<>();
    answers.add("42");
    answers.add("38");
    answers.add("15");
    answers.add("-6");
    question.setPossibleAnswers(answers);

    model.addAttribute("user", userRepo.findOne(game.getUserId()).getUsername());
    model.addAttribute("question", question);
    return "question";
  }

  @GetMapping(value = {"/geographic", "/geographic/"})
  public String startGeographyGame() {
    Game game = new Game();
    game.setGameType("GEOGRAPHY");
    geographicInfoGame.setRandomCountry();
    geographicInfoGame.setQuestionText(game);
    geographicInfoGame.setRightAnswer(game);
    geographicInfoGame.setPossibleAnswersListForGeographic(game);
    geographicInfoGame.setIndexOfTheRightAnswerInThePossibleAnswers();
    return "index";
  }
}
