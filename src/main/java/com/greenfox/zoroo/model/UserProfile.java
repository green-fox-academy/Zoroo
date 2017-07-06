package com.greenfox.zoroo.model;


public class UserProfile {


  private int userId;

  public String getUserName() {
    return userName;
  }

  private String userName;
  private String userPassword;
  private int goodAnswers;
  private int badAnswers;
  private int totalNumberOfQuestionsAnswered;
  private int precentage;

  public UserProfile(String username) {
    userName = username;
  }
}
