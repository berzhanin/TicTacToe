package com.games.battle.controllers;

import com.games.battle.domain.Game;
import com.games.battle.model.GameDto;
import com.games.battle.services.GameService;
import com.games.user.domain.User;
import com.games.user.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/game")
public class GameController {

    GameService gameService;

    UserService userService;

    HttpSession httpSession;

    @PostMapping
    @RequestMapping(value = "/create")
    public Game createGame(@RequestBody GameDto gameDto){

        //todo: change new User() to userService.getUserById()
        Game game = gameService.createGame(new User(), gameDto);
        httpSession.setAttribute("gameId", game.getId());

        return game;
    }

    @PostMapping
    @RequestMapping(value = "/join")
    public Game joinGame(@RequestBody GameDto gameDTO) {

        //todo: change new User() to userService.getUserById()
        Game game = gameService.joinGame(new User(), gameDTO);
        return game;
    }
}
