package com.greenfox.zoroo.model;


public class GameDTO {

  private int userId;
  private int levelOfHardness;
  private int numberOfAllTheAnswerPossibilities;
  private GameType gameType;

  public GameDTO() {
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
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

  public GameType getGameType() {
    return gameType;
  }

  public void setGameType(GameType gameType) {
    this.gameType = gameType;
  }
}
