package com.games.battle.services;

import com.games.battle.domain.Game;
import com.games.battle.enums.GameStatus;
import com.games.battle.model.GameDto;
import com.games.battle.repositories.GameRepository;
import com.games.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public Game createGame(User user, GameDto gameDto){

        Game game = new Game();

        //todo: add setters for new Game


        gameRepository.save(game);

        return game;
    }

    public void updateGame(Game game, GameStatus gameStatus){

        //todo: add implementation
    }

    public Optional<Game> findGameById(Long id){
        return gameRepository.findById(id);
    }

    public Game joinGame(User user, GameDto gameDto){

        //todo: add implementation

        return null;
    }
}
