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
  private int geoType;

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
    int randomIndex = getRandomNumber(10);
    String country = geographicInfoRepo.findAll().get(randomIndex).getCountry();
    geographicInfo.setCountry(country);
    geographicInfo.setCapital(geographicInfoRepo.findAll().get(randomIndex).getCapital());
    geographicInfo.setLanguage(geographicInfoRepo.findAll().get(randomIndex).getLanguage());
    geographicInfo.setContinent(geographicInfoRepo.findAll().get(randomIndex).getContinent());
    geographicInfo.setFamousPerson(geographicInfoRepo.findAll().get(randomIndex).getFamousPerson());
    geographicInfo.setLandmark(geographicInfoRepo.findAll().get(randomIndex).getLandmark());
    geographicInfo.setFlag(geographicInfoRepo.findAll().get(randomIndex).getFlag());
  }

  public void setQuestionText(Game game) {

    setRandomCountry();
    this.geoType = getRandomNumber(2);
    System.out.println(geoType);
    switch (geoType) {
      case 0:
        this.questionText = "What is the capital of " + geographicInfo.getCountry() + "?";
        break;
      case 1:
        this.questionText = "Who is the famous person of " + geographicInfo.getCountry() + "?";
        break;
    }
    System.out.println(questionText);
  }

  public void setRightAnswer(Game game) {
    switch (geoType) {
      case 0:
        rightAnswer = geographicInfo.getCapital();
        break;
      case 1:
        rightAnswer = geographicInfo.getFamousPerson();
        break;
    }
    System.out.println(rightAnswer);
  }

  public void setPossibleAnswersListForGeographic(Game game) {
    possibleAnswers = new ArrayList<>();
    possibleAnswers.add(rightAnswer);
    String otherAnswer = "";
    while (possibleAnswers.size() < amountOfPossibleAnswers) {
      int randomNumber = getRandomNumber(10);
      switch (geoType) {
        case 0:
          otherAnswer = geographicInfoRepo.findAll().get(randomNumber).getCapital();
          break;
        case 1:
          otherAnswer = geographicInfoRepo.findAll().get(randomNumber).getFamousPerson();
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
