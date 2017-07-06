package com.greenfox.zoroo.model;


import java.util.concurrent.atomic.AtomicInteger;

public class Game {

  private static final AtomicInteger gameRunningCounter = new AtomicInteger(0);

  private int gameId;
  private UserProfile userProfile;
  private Question question;
  private int totalQuestionsInThisGame;
  private int levelOfHardness;
  private int numberOfAllTheAnswerPossibilities;
  private int thisQuestionsNumber;
  private int rightAnswersSoFar;
  private int wrongAnswersSoFar;
  private int percentageOfRightAnswersInThisGame;

  public Game() {
    gameId = gameRunningCounter.incrementAndGet();
  }

  public int getGameId() {
    return gameId;
  }

  public UserProfile getUserProfile() {
    return userProfile;
  }

  public void setUserProfile(UserProfile userProfile) {
    this.userProfile = userProfile;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  public int getTotalQuestionsInThisGame() {
    return totalQuestionsInThisGame;
  }

  public void setTotalQuestionsInThisGame(int totalQuestionsInThisGame) {
    this.totalQuestionsInThisGame = totalQuestionsInThisGame;
  }

  public int getLevelOfHardness() {
    return levelOfHardness;
  }

  public void setLevelOfHardness(int levelOfHardness) {
    this.levelOfHardness = levelOfHardness;
  }

  public int getNumberOfAllTheAnswerPossibilities() {
    return numberOfAllTheAnswerPossibilities;
  }

  public void setNumberOfAllTheAnswerPossibilities(int numberOfAllTheAnswerPossibilities) {
    this.numberOfAllTheAnswerPossibilities = numberOfAllTheAnswerPossibilities;
  }

  public int getThisQuestionsNumber() {
    return thisQuestionsNumber;
  }

  public void setThisQuestionsNumber(int thisQuestionsNumber) {
    this.thisQuestionsNumber = thisQuestionsNumber;
  }

  public int getRightAnswersSoFar() {
    return rightAnswersSoFar;
  }

  public void setRightAnswersSoFar(int rightAnswersSoFar) {
    this.rightAnswersSoFar = rightAnswersSoFar;
  }

  public int getWrongAnswersSoFar() {
    return wrongAnswersSoFar;
  }

  public void setWrongAnswersSoFar(int wrongAnswersSoFar) {
    this.wrongAnswersSoFar = wrongAnswersSoFar;
  }

  public int getPercentageOfRightAnswersInThisGame() {
    return percentageOfRightAnswersInThisGame;
  }

  public void setPercentageOfRightAnswersInThisGame(int percentageOfRightAnswersInThisGame) {
    this.percentageOfRightAnswersInThisGame = percentageOfRightAnswersInThisGame;
  }
}