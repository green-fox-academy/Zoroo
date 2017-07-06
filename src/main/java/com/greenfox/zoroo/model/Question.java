package com.greenfox.zoroo.model;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Question {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int userId;
  @NotNull
  private String question;
  @NotNull
  private DataType questionType;
  @NotNull
  private String answer;
  @NotNull
  private DataType answerType;
  @NotNull
  private List<String> possibleAnswers;
  @NotNull
  private int indexOfTheRightAnswerInThePossibleAnswers;

  public Question() {
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
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

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
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


