package com.greenfox.zoroo.model;


public enum GameType {
  MATHTIMETABLE("MATHTIMETABLE"), MATHADDING("MATHADDING"), MATHDIVIDE("MATHDIVIDE"), MATHDEDUCT("MATHDEDUCT"), GEOGRAPHY("GEOGRAPHY");

  private final String gameTypeName;

  GameType(String gameTypeName) {
    this.gameTypeName = gameTypeName;
  }

  @Override
  public String toString() {
    return gameTypeName;
  }
}
