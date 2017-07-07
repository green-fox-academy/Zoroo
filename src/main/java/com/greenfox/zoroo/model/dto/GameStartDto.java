package com.greenfox.zoroo.model.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameStartDto {

  private List<String> categories = new ArrayList<>(Arrays.asList("MATHADDING", "MATHDIVIDE", "MATHTIMETABLE", "MATHDEDUCT", "GEOGRAPHY"));
  private List<String> difficulties = new ArrayList<>(Arrays.asList("Easy", "Medium", "Challenge"));
  private List<String> possibilities = new ArrayList<>(Arrays.asList("4", "5", "6", "7", "8", "9", "10"));
}
