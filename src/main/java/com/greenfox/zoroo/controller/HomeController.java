package com.greenfox.zoroo.controller;

import com.greenfox.zoroo.gameLogic.GeographicInfoGame;
import com.greenfox.zoroo.model.Game;
import com.greenfox.zoroo.model.GameType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @Autowired
  GeographicInfoGame geographicInfoGame;
  @GetMapping(value = "/")
  public String getIndexPage() {

    Game game = new Game();
    game.setGameType("GEOGRAPHY");
    geographicInfoGame.playGeographicGame(game);
    return "index";
  }
}
