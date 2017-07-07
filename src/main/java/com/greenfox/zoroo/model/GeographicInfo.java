package com.greenfox.zoroo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class GeographicInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String country;
  private String capital;
  private String language;
  private String continent;
  @Column(name = "famous_person")
  private String famousPerson;
  private String landmark;
  private String flag;

  public GeographicInfo() {

  }

  public GeographicInfo(String country, String capital, String language, String continent, String famousPerson,
      String landmark, String flag) {
    this.country = country;
    this.capital = capital;
    this.language = language;
    this.continent = continent;
    this.famousPerson = famousPerson;
    this.landmark = landmark;
    this.flag = flag;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCapital() {
    return capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }

  public String getFamousPerson() {
    return famousPerson;
  }

  public void setFamousPerson(String famousPerson) {
    this.famousPerson = famousPerson;
  }

  public String getLandmark() {
    return landmark;
  }

  public void setLandmark(String landmark) {
    this.landmark = landmark;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }
}
