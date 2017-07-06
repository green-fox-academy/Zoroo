package com.greenfox.zoroo.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  @Setter(AccessLevel.NONE)
  private String username;
}
