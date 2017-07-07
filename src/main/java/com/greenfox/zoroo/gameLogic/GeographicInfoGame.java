package com.greenfox.zoroo.gameLogic;


import com.greenfox.zoroo.Repository.GeographicInfoRepo;
import com.greenfox.zoroo.model.Game;
import com.greenfox.zoroo.model.GeographicInfo;
import java.util.List;
import java.util.Random;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeographicInfoGame {


  private String rightAnswer;
  private String questionText;
  private List<String> possibleAnswers;
  private int indexOfTheRightAnswerInThePossibleAnswers;
  @Min(1)
  @Max(10)
  private int levelOfHardness;
  private int amountOfPossibleAnswers;

  @Autowired
  GeographicInfoRepo geographicInfoRepo;
  @Autowired
  GeographicInfo geographicInfo;

  @Autowired
  MathGame mathGame;

  private int getRandomNumber(int maxValue) {
    Random r = new Random();
    return r.nextInt(maxValue);
  }
  public void setRandomCountry() {
    int randomNumber = getRandomNumber(10);
    String country = geographicInfoRepo.findAll().get(randomNumber).getCountry();
    System.out.println(randomNumber);
    geographicInfo.setCountry(country);
  }

  public void setQuestionText(Game game) {
    switch (game.getGameType()) {
      case GEOGRAPHY:
        setRandomCountry();
        this.questionText = "What is the capital of " + geographicInfo.getCountry() + "?";
        System.out.println(questionText);
        break;
    }
  }
}
