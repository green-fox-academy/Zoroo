package com.greenfox.zoroo.model;


import java.util.concurrent.atomic.AtomicInteger;

public class Game {

  private static final AtomicInteger gameRunningCounter = new AtomicInteger(0);

  private int gameId;
  private int userId;
  private Question question;
  private int totalQuestionsInThisGame;
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

  public int getTotalQuestionsInThisGame() {
    return totalQuestionsInThisGame;
  }

  public void setTotalQuestionsInThisGame(int totalQuestionsInThisGame) {
    this.totalQuestionsInThisGame = totalQuestionsInThisGame;
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