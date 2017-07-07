package com.greenfox.zoroo.controller;

import com.greenfox.zoroo.gameLogic.GeographicInfoGame;
import com.greenfox.zoroo.model.Game;
import com.greenfox.zoroo.model.GameType;
import com.greenfox.zoroo.model.Question;
import com.greenfox.zoroo.model.dto.GameDto;
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

  @Autowired
  public GameController(GameService gameService,
      GeographicInfoGame geographicInfoGame) {
    this.gameService = gameService;
    this.geographicInfoGame = geographicInfoGame;
  }

  @PostMapping(value = {"/game", "/game/"})
  public ModelAndView startNewGame(ModelAndView modelAndView) {
    GameDto gameDto =
        GameDto.builder()
            .userId(1L)
            .gameType(GameType.MATHADDING)
            .levelOfHardness(1)
            .numberOfAllTheAnswerPossibilities(4)
            .build();

    Game newGame = gameService.createNewGame(gameDto);

    modelAndView.setViewName("redirect:/question");
    modelAndView.addObject(gameDto);
    return modelAndView;
  }

  @GetMapping(value = "/question")
  public String getQuestionPage(Model model) {
    UserProfileDto user = new UserProfileDto(1L, "Pistike");
    Question question = new Question();

    question.setQuestionText("18 + 24 = ?");
    question.setGoodAnswerIndex(1);
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

  @GetMapping(value = {"/geographic","/geographic/"})
  public String startGeographyGame() {
    Game game = new Game();
    game.setGameType(GameType.GEOGRAPHY);
    geographicInfoGame.setRandomCountry();
    geographicInfoGame.setQuestionText(game);
    geographicInfoGame.setRightAnswer(game);
    geographicInfoGame.setPossibleAnswersListForGeographic(game);
    geographicInfoGame.setIndexOfTheRightAnswerInThePossibleAnswers();
    return "index";
  }
}
