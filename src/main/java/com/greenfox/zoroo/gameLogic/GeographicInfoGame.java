package com.greenfox.zoroo.gameLogic;


import com.greenfox.zoroo.Repository.GeographicInfoRepo;
import com.greenfox.zoroo.model.DataType;
import com.greenfox.zoroo.model.Game;
import com.greenfox.zoroo.model.GeographicInfo;
import com.greenfox.zoroo.model.Question;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeographicInfoGame {


  private String rightAnswer;
  private String questionText;
  private List<String> possibleAnswers;
  private int indexOfTheRightAnswerInThePossibleAnswers;
  @Min(1)
  @Max(10)
  private int levelOfHardness;
  private int amountOfPossibleAnswers;

  @Autowired
  GeographicInfoRepo geographicInfoRepo;
  @Autowired
  GeographicInfo geographicInfo;

  @Autowired
  MathGame mathGame;

  public void playGeographicGame(Game game) {
    this.levelOfHardness = game.getLevelOfHardness();
    this.amountOfPossibleAnswers = game.getNumberOfAllTheAnswerPossibilities();
    setRightAnswer(game);

    setQuestionText(game);
    setPossibleAnswersListForGeographic(game);
    setIndexOfTheRightAnswerInThePossibleAnswers();
    game.setQuestion(setTheQuestionsForThisGame());
  }

  private Question setTheQuestionsForThisGame() {
    Question question = new Question();
    question.setAnswerType(DataType.TEXT);
    question.setQuestionType(DataType.TEXT);
    question.setQuestionText(questionText);
    question.setGoodAnswerIndex(
        indexOfTheRightAnswerInThePossibleAnswers);
    question.setPossibleAnswers(possibleAnswers);
    return question;
  }

  private int getRandomNumber(int maxValue) {
    Random r = new Random();
    return r.nextInt(maxValue);
  }

  public void setRandomCountry() {
    int randomNumber = getRandomNumber(10);
    String country = geographicInfoRepo.findAll().get(randomNumber).getCountry();
    geographicInfo.setCountry(country);
    geographicInfo.setCapital(geographicInfoRepo.findAll().get(randomNumber).getCapital());
  }

  public void setQuestionText(Game game) {
    switch (game.getGameType()) {
      case GEOGRAPHY:
        setRandomCountry();
        this.questionText = "What is the capital of " + geographicInfo.getCountry() + "?";
        break;
    }
  }

  public void setRightAnswer(Game game) {
    switch (game.getGameType()) {
      case GEOGRAPHY:
        rightAnswer = geographicInfo.getCapital();
        break;
    }
  }

  public void setPossibleAnswersListForGeographic(Game game) {
    possibleAnswers = new ArrayList<>();
    possibleAnswers.add(rightAnswer);
    String otherAnswer = "";
    while (possibleAnswers.size() < amountOfPossibleAnswers) {
      switch (game.getGameType()) {
        case GEOGRAPHY:
          int randomNumber = getRandomNumber(10);
          otherAnswer = geographicInfoRepo.findAll().get(randomNumber).getCapital();
          break;
      }
      if (!possibleAnswers.contains(otherAnswer)) {
        possibleAnswers.add(otherAnswer);
      }
    }
    Collections.shuffle(possibleAnswers);
    for (String item : possibleAnswers) {
      System.out.println(item + possibleAnswers.size());
    }
  }

  public void setIndexOfTheRightAnswerInThePossibleAnswers() {
    indexOfTheRightAnswerInThePossibleAnswers = possibleAnswers
        .indexOf(rightAnswer);
  }
}
