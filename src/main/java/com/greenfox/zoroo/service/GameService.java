package com.greenfox.zoroo.service;


import com.greenfox.zoroo.gameLogic.MathGame;
import com.greenfox.zoroo.model.DataType;
import com.greenfox.zoroo.model.Game;
import com.greenfox.zoroo.model.GameDTO;
import com.greenfox.zoroo.model.Question;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class GameService {

  @Autowired
  Game game;

  @Autowired
  MathGame mathGame;

  List<Game> allGames;


  public void createNewGame(GameDTO gameDTO) {
    Game game = new Game();
    game.setUserId(gameDTO.getUserId());
    game.setLevelOfHardness(gameDTO.getLevelOfHardness());
    game.setNumberOfAllTheAnswerPossibilities(gameDTO.getNumberOfAllTheAnswerPossibilities());
    game.setTotalQuestionsInThisGame(10);
    game.setGameType(gameDTO.getGameType());
    allGames.add(game);
  }

  private Game getGameById (int gameId){
    Game gameToReturn = null;
    for (Game game: allGames) {
      if (gameId == game.getGameId())
        gameToReturn = game;
    }
    return gameToReturn;
  }

  public Game playOneRound(int gameId) {
    game = getGameById(gameId);
    switch (game.getGameType()){
      case MATHTIMETABLE:
        return playMathTimeTableGame(game);
    }
    return game;
  }

  private Game playMathTimeTableGame(Game game){
    mathGame.playTimeTableGame(game);
    Question question = new Question();
    question.setAnswerType(DataType.TEXT);
    question.setQuestionType(DataType.TEXT);
    question.setQuestion(mathGame.getQuestion());
    question.setIndexOfTheRightAnswerInThePossibleAnswers(mathGame.getIndexOfTheRightAnswerInThePossibleAnswers());
    question.setPossibleAnswers(mathGame.getPossibleAnswers());
    game.setQuestion(question);
    return game;
  }
}
