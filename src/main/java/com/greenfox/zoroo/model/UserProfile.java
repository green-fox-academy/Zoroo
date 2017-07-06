package com.greenfox.zoroo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class UserProfile {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long userId;

  public String getUserName() {
    return userName;
  }

  @NotNull
  private String userName;
  @NotNull
  private String userPassword;
  private int goodAnswers;
  private int badAnswers;
  @Transient
  private int totalNumberOfQuestionsAnswered;
  @Transient
  private float precentage;

  public UserProfile(String username) {
    userId = 0;
    userName = username;
  }

  public long getUserId() {
    return userId;
  }
}
