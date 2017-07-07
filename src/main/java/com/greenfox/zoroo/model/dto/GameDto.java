package com.greenfox.zoroo.model.dto;


import com.greenfox.zoroo.model.GameType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDto {

  private Long userId;
  private int levelOfHardness;
  private int numberOfAllTheAnswerPossibilities;
  private GameType gameType;
}
