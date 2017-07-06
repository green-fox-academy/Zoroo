package com.greenfox.zoroo.model;


import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Question {

  private String question;
  private DataType questionType;
  private DataType answerType;
  private List<String> possibleAnswers;
  private int goodIndex;

  public Question() {

  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
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

  public int getGoodIndex() {
    return goodIndex;
  }

  public void setGoodIndex(
          int goodIndex) {
    this.goodIndex = goodIndex;
  }
}


