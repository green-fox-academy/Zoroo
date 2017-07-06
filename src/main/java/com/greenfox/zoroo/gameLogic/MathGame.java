package com.greenfox.zoroo.gameLogic;


import java.util.ArrayList;
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
  private List<String> possibleAnswers;
  private int indexOfTheRightAnswerInThePossibleAnswers;
  @Min(1)
  @Max(10)
  private int levelOfHardness;
  private int amountOfPossibleAnswers;


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
      case 2:
        firstNumberMaxValue = 10;
        secondNumberMaxValue = 10;
      case 3:
        firstNumberMaxValue = 5;
        secondNumberMaxValue = 20;
      case 4:
        firstNumberMaxValue = 10;
        secondNumberMaxValue = 20;
      case 5:
        firstNumberMaxValue = 5;
        secondNumberMaxValue = 30;
      case 6:
        firstNumberMaxValue = 10;
        secondNumberMaxValue = 30;
      case 7:
        firstNumberMaxValue = 15;
        secondNumberMaxValue = 20;
      case 8:
        firstNumberMaxValue = 15;
        secondNumberMaxValue = 30;
      case 9:
        firstNumberMaxValue = 20;
        secondNumberMaxValue = 30;
      case 10:
        firstNumberMaxValue = 30;
        secondNumberMaxValue = 30;
    }
  }

  public void playTimeTableGame(int levelOfHardness, int amountOfPossibleAnswers) {
    this.levelOfHardness = levelOfHardness;
    this.amountOfPossibleAnswers = amountOfPossibleAnswers;
    setTimeTableMaxNumberValues();
    setRandomFirstAndSecondNumbers();
    rightAnswer = firstNumber * secondNumber;
    setPossibleAnswersListForTimeTable();


  }

  private void setPossibleAnswersListForTimeTable() {
    possibleAnswers = new ArrayList<>();
    possibleAnswers.add(String.valueOf(rightAnswer));
    while (possibleAnswers.size() < amountOfPossibleAnswers) {
      String wrongAnswer = String.valueOf(firstNumber * secondNumber);
      possibleAnswers.add(wrongAnswer);
    }
  }
}




