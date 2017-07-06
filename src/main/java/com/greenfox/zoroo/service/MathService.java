package com.greenfox.zoroo.service;


import com.greenfox.zoroo.gameLogic.MathGame;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MathService {

  @Autowired
  MathGame mathGame;

  private List<String> possibleAnswers;
  private int rightAnswerIndex;


  public void timeTableGame(int gameLevel, int amountOfPossibleAnswers) {
    mathGame.playTimeTableGame(gameLevel, amountOfPossibleAnswers);
    possibleAnswers = mathGame.getPossibleAnswers();
    rightAnswerIndex = mathGame.getIndexOfTheRightAnswerInThePossibleAnswers();
  }
}
