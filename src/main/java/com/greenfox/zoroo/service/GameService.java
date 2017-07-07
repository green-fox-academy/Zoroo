package com.greenfox.zoroo.service;


import com.greenfox.zoroo.Repository.UserRepo;
import com.greenfox.zoroo.gameLogic.GeographicInfoGame;
import com.greenfox.zoroo.gameLogic.MathGame;
import com.greenfox.zoroo.model.Game;
import com.greenfox.zoroo.model.dto.GameDto;
import com.greenfox.zoroo.model.GameType;
import com.greenfox.zoroo.model.UserProfile;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  @Autowired
  UserRepo userRepo;

  Game game;

  @Autowired
  MathGame mathGame;

  @Autowired
  GeographicInfoGame geographicInfoGame;

  List<Game> allGames;


  public Game createNewGame(GameDto gameDto) {
    Game game = new Game();
    game.setUserId(gameDto.getUserId());
    game.setUserName(userRepo.findOne(gameDto.getUserId()).getUsername());
    game.setLevelOfHardness(gameDto.getLevelOfHardness());
    game.setNumberOfAllTheAnswerPossibilities(gameDto.getNumberOfAllTheAnswerPossibilities());
    game.setGameType(gameDto.getGameType());
    allGames.add(game);
    return game;
  }

  private Game getGameById(int gameId) {
    Game gameToReturn = null;
    for (Game game : allGames) {
      if (gameId == game.getGameId()) {
        gameToReturn = game;
      }
    }
    return gameToReturn;
  }

  public Game analizeOneRound(Game game, int indexOfUserAnswer){
    int rightAnswerIndex = game.getQuestion().getGoodAnswerIndex();
    if (indexOfUserAnswer == rightAnswerIndex){
      game.getQuestion().setUserAnswerRight(true);
      int pointsForThisQuestion = game.getLevelOfHardness() * game.getNumberOfAllTheAnswerPossibilities();
      game.getQuestion().setThisQuestionPointValue(pointsForThisQuestion);
      game.setRightAnswersSoFar(game.getRightAnswersSoFar() + 1);
    }else {
      game.getQuestion().setUserAnswerRight(false);
      game.getQuestion().setThisQuestionPointValue(0);
      game.setWrongAnswersSoFar(game.getWrongAnswersSoFar() + 1);
    }
    return game;
  }

  public Game playOneRound(Game game) {
    game = getGameById(game.getGameId());
    game.getQuestion().setUserAnswerRight(false);
    if (game.getThisQuestionsNumber() == 10) {
      gameIsOver(game);
    }
    game.setThisQuestionsNumber(game.getThisQuestionsNumber() + 1);
    if (game.getGameType().equals(GameType.GEOGRAPHY)) {
      game = playGeographyGame(game);
    } else {
      game = playMathGame(game);
    }
    return game;
  }

  private Game playMathGame(Game game) {
    mathGame.playMathGame(game);
    return game;
  }

  private Game playGeographyGame(Game game) {
    geographicInfoGame.playGeographicGame(game);
    return game;
  }

  private void gameIsOver(Game game) {
    endOfTheGameUpdateUserProfile(game);
  }

  private void endOfTheGameUpdateUserProfile(Game game) {
    UserProfile userProfileToUpdate = userRepo.findOne(game.getUserId());
    userProfileToUpdate
            .setBadAnswers(userProfileToUpdate.getBadAnswers() + game.getWrongAnswersSoFar());
    userProfileToUpdate
            .setGoodAnswers(userProfileToUpdate.getGoodAnswers() + game.getRightAnswersSoFar());
    userProfileToUpdate.setTotalNumberOfQuestionsAnswered(
            userProfileToUpdate.getTotalNumberOfQuestionsAnswered() + game
                    .getThisQuestionsNumber());
    userRepo.save(userProfileToUpdate);
  }

  public List<UserProfile> topPlayersList(){
    return userRepo.findTop10ByOrderByGoodAnswersDesc();
  }
}
