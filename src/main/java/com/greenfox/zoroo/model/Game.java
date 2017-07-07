package com.greenfox.zoroo.model;


import java.util.concurrent.atomic.AtomicInteger;
import lombok.Data;

@Data
public class Game {

  private static final AtomicInteger gameRunningCounter = new AtomicInteger(0);

  private int gameId;
  private Long userId;
  private String userName;
  private Question question;
  private String gameType;
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
}