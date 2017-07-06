package com.greenfox.zoroo.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
@Data
public class LoginFormDto {

  @NotBlank
  private String username;
  @NotBlank
  private String password;

}
