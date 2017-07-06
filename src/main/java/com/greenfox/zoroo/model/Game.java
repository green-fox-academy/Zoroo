package com.greenfox.zoroo.model;


import java.util.concurrent.atomic.AtomicInteger;

public class Game {

  private static final AtomicInteger gameRunningCounter = new AtomicInteger(0);

  private int gameId;
  private int userId;
  private Question question;
  private GameType gameType;
  private int totalQuestionsInThisGame;
  private int levelOfHardness;
  private int numberOfAllTheAnswerPossibilities;
  private int thisQuestionsNumber;
  private int rightAnswersSoFar;
  private int wrongAnswersSoFar;
  private int percentageOfRightAnswersInThisGame;

  public Game() {
    gameId = gameRunningCounter.incrementAndGet();
    totalQuestionsInThisGame = 10;
  }

  public int getGameId() {
    return gameId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  public GameType getGameType() {
    return gameType;
  }

  public void setGameType(GameType gameType) {
    this.gameType = gameType;
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