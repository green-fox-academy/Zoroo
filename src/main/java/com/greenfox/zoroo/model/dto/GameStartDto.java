package com.greenfox.zoroo.model.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameStartDto {

  private List<String> categories = new ArrayList<>(Arrays.asList("math_game", "quiz_game"));
  private List<Integer> difficulties = initializeDifficulties();

  private List<Integer> initializeDifficulties() {
    difficulties = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      difficulties.add(i);
    }
    return difficulties;
  }
}
