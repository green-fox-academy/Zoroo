package com.greenfox.zoroo.model;


import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Question {

  private String questionText;
  private DataType questionType;
  private DataType answerType;
  private List<String> possibleAnswers;
  private int goodAnswerIndex;
  private int userAnswerIndex;
  private boolean isUserAnswerRight;
  private int thisQuestionPointValue;

  public Question() {

  }

  public String getQuestionText() {
    return questionText;
  }

  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  public DataType getQuestionType() {
    return questionType;
  }

  public void setQuestionType(DataType questionType) {
    this.questionType = questionType;
  }

  public DataType getAnswerType() {
    return answerType;
  }

  public void setAnswerType(DataType answerType) {
    this.answerType = answerType;
  }

  public List<String> getPossibleAnswers() {
    return possibleAnswers;
  }

  public void setPossibleAnswers(List<String> possibleAnswers) {
    this.possibleAnswers = possibleAnswers;
  }

  public int getGoodAnswerIndex() {
    return goodAnswerIndex;
  }

  public void setGoodAnswerIndex(
          int goodAnswerIndex) {
    this.goodAnswerIndex = goodAnswerIndex;
  }

  public int getUserAnswerIndex() {
    return userAnswerIndex;
  }

  public void setUserAnswerIndex(int userAnswerIndex) {
    this.userAnswerIndex = userAnswerIndex;
  }

  public boolean isUserAnswerRight() {
    return isUserAnswerRight;
  }

  public void setUserAnswerRight(boolean userAnswerRight) {
    isUserAnswerRight = userAnswerRight;
  }

  public int getThisQuestionPointValue() {
    return thisQuestionPointValue;
  }

  public void setThisQuestionPointValue(int thisQuestionPointValue) {
    this.thisQuestionPointValue = thisQuestionPointValue;
  }
}


