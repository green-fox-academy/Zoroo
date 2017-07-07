package com.greenfox.zoroo.gameLogic;


import com.greenfox.zoroo.model.DataType;
import com.greenfox.zoroo.model.Game;
import com.greenfox.zoroo.model.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.stereotype.Component;

@Component
public class MathGame {

  private int firstNumber;
  private int secondNumber;
  private int firstNumberMaxValue;
  private int secondNumberMaxValue;
  private int rightAnswer;
  private String questionText;
  private List<String> possibleAnswers;
  private int indexOfTheRightAnswerInThePossibleAnswers;
  @Min(1)
  @Max(10)
  private int levelOfHardness;
  private int amountOfPossibleAnswers;


  public String getQuestionText() {
    return questionText;
  }

  public void setLevelOfHardness(int levelOfHardness) {
    this.levelOfHardness = levelOfHardness;
  }

  public void setAmountOfPossibleAnswers(int amountOfPossibleAnswers) {
    this.amountOfPossibleAnswers = amountOfPossibleAnswers;
  }

  public List<String> getPossibleAnswers() {
    return possibleAnswers;
  }

  public int getIndexOfTheRightAnswerInThePossibleAnswers() {
    return indexOfTheRightAnswerInThePossibleAnswers;
  }

  private int getRandomNumber(int maxValue) {
    Random r = new Random();
    return r.nextInt(maxValue - 1) + 1;
  }

  private void setRandomFirstAndSecondNumbers() {
    firstNumber = getRandomNumber(firstNumberMaxValue);
    secondNumber = getRandomNumber(secondNumberMaxValue);
  }

  private void setTimeTableMaxNumberValues() {
    switch (levelOfHardness) {
      case 1:
        firstNumberMaxValue = 5;
        secondNumberMaxValue = 10;
        break;
      case 2:
        firstNumberMaxValue = 10;
        secondNumberMaxValue = 10;
        break;
      case 3:
        firstNumberMaxValue = 5;
        secondNumberMaxValue = 20;
        break;
      case 4:
        firstNumberMaxValue = 10;
        secondNumberMaxValue = 20;
        break;
      case 5:
        firstNumberMaxValue = 5;
        secondNumberMaxValue = 30;
        break;
      case 6:
        firstNumberMaxValue = 10;
        secondNumberMaxValue = 30;
        break;
      case 7:
        firstNumberMaxValue = 15;
        secondNumberMaxValue = 20;
        break;
      case 8:
        firstNumberMaxValue = 15;
        secondNumberMaxValue = 30;
        break;
      case 9:
        firstNumberMaxValue = 20;
        secondNumberMaxValue = 30;
        break;
      case 10:
        firstNumberMaxValue = 30;
        secondNumberMaxValue = 30;
        break;
    }
  }

  public void playTimeTableGame(Game game) {
    this.levelOfHardness = game.getLevelOfHardness();
    this.amountOfPossibleAnswers = game.getNumberOfAllTheAnswerPossibilities();
    setTimeTableMaxNumberValues();
    setRandomFirstAndSecondNumbers();
    setRightAnswer(game);
    setQuestionText(game);
    setPossibleAnswersListForTimeTable(game);
    setIndexOfTheRightAnswerInThePossibleAnswers();
    game.setQuestion(setTheQuestionsForThisGame());


  }

  private Question setTheQuestionsForThisGame() {
    Question question = new Question();
    question.setAnswerType(DataType.TEXT);
    question.setQuestionType(DataType.TEXT);
    question.setQuestionText(questionText);
    question.setGoodIndex(
            indexOfTheRightAnswerInThePossibleAnswers);
    question.setPossibleAnswers(possibleAnswers);
    return question;
  }


  private void setQuestionText(Game game) {
    switch (game.getGameType()) {
      case MATHTIMETABLE:
        questionText = "How much is " + firstNumber + " * " + secondNumber + "?";
        break;
      case MATHADDING:
        questionText = "How much is " + firstNumber + " + " + secondNumber + "?";
        break;
    }
  }

  private void setRightAnswer(Game game) {
    switch (game.getGameType()) {
      case MATHTIMETABLE:
        rightAnswer = firstNumber * secondNumber;
        break;
      case MATHADDING:
        rightAnswer = firstNumber + secondNumber;
        break;
    }


  }


  private void setPossibleAnswersListForTimeTable(Game game) {
    possibleAnswers = new ArrayList<>();
    possibleAnswers.add(String.valueOf(rightAnswer));
    String otherAnswer = "";
    while (possibleAnswers.size() < amountOfPossibleAnswers) {
      setRandomFirstAndSecondNumbers();
      switch (game.getGameType()){
        case MATHTIMETABLE:
          otherAnswer = String.valueOf(firstNumber * secondNumber);
          break;
        case MATHADDING:
          otherAnswer = String.valueOf(firstNumber + secondNumber);
          break;
      }
      if (!possibleAnswers.contains(otherAnswer)) {
        possibleAnswers.add(otherAnswer);
      }
    }
    Collections.shuffle(possibleAnswers);
  }

  private void setIndexOfTheRightAnswerInThePossibleAnswers() {
    indexOfTheRightAnswerInThePossibleAnswers = possibleAnswers
            .indexOf(String.valueOf(rightAnswer));
  }
}
