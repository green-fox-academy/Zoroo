package com.greenfox.zoroo.service;


import com.greenfox.zoroo.gameLogic.MathGame;
import org.springframework.beans.factory.annotation.Autowired;

public class MathService {

  @Autowired
  MathGame mathGame;


  public void timeTableGame(int gameLevel){

    mathGame.playTimeTableGame(gameLevel);

  }

}
