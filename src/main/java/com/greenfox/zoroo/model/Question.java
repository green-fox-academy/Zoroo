package com.greenfox.zoroo.model;


import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Question {

  private String questionText;
  private DataType questionType;
  private DataType answerType;
  private List<String> possibleAnswers;
  private int goodAnswerIndex;
  private int userAnswerIndex;
  private boolean isUserAnswerRight;
  private int thisQuestionPointValue;
}


