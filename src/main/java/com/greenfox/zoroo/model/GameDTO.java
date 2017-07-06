package com.greenfox.zoroo.model;


public class GameDTO {

  private int levelOfHardness;
  private int numberOfAllTheAnswerPossibilities;

  public GameDTO() {
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
}
