package com.games.battle.controllers;

import com.games.battle.domain.Game;
import com.games.battle.model.GameDto;
import com.games.battle.services.GameService;
import com.games.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    GameService gameService;

    @PostMapping
    @RequestMapping(value = "/create")
    public ResponseEntity<Game> createGame(@RequestBody User user, GameDto gameDto) {

        Game newGame = gameService.createGame(user, gameDto);

        return ResponseEntity.ok(newGame);
    }

    @GetMapping
    public ResponseEntity<List<Game>> finAllGames() {
        return ResponseEntity.ok(gameService.listAllGames());
    }
    @GetMapping("/{gameId}")
    public ResponseEntity<Optional<Game>> findGameById(@PathVariable Long gameId) {
        return ResponseEntity.ok(gameService.findGameById(gameId));
    }

    @PostMapping
    @RequestMapping(value = "/join")
    public Game joinGame(@RequestBody GameDto gameDTO) {

        //todo: change new User() to userService.getUserById()
        Game game = gameService.joinGame(new User(), gameDTO);
        return game;
    }
}
