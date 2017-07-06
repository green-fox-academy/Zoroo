package com.greenfox.zoroo.model;


public enum DataType {
  PICTURE("PICTURE"), TEXT("TEXT");

  private final String dataTypeName;

  DataType(String dataTypeName) {
    this.dataTypeName = dataTypeName;
  }

  @Override
  public String toString() {
    return dataTypeName;
  }
  }
