package com.greenfox.zoroo.service;


import com.greenfox.zoroo.gameLogic.MathGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MathService {

  @Autowired
  MathGame mathGame;


  public void timeTableGame(int gameLevel, int amountOfPossibleAnswers){

    mathGame.playTimeTableGame(gameLevel, amountOfPossibleAnswers);

  }

}
