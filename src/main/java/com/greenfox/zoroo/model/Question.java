package com.greenfox.zoroo.model;


import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Question {

  private String questionText;
  private DataType questionType;
  private DataType answerType;
  private List<String> possibleAnswers;
  private int indexOfTheRightAnswerInThePossibleAnswers;

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

  public int getIndexOfTheRightAnswerInThePossibleAnswers() {
    return indexOfTheRightAnswerInThePossibleAnswers;
  }

  public void setIndexOfTheRightAnswerInThePossibleAnswers(
          int indexOfTheRightAnswerInThePossibleAnswers) {
    this.indexOfTheRightAnswerInThePossibleAnswers = indexOfTheRightAnswerInThePossibleAnswers;
  }
}


