package com.games.battle.services;

import com.games.battle.domain.Game;
import com.games.battle.enums.GameStatus;
import com.games.battle.model.GameDto;
import com.games.battle.repositories.GameRepository;
import com.games.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    /**
     * Find a game by game Id.
     *
     * @param id the primary key of the game
     * @return GameDto object containing game details
     */
    public Optional<Game> findGameById(Long id){
        return gameRepository.findById(id);
    }

    /**
     * List all the Games which each game contains details such as game name, status etc.
     *
     * @return a list of game objects
     */
    public List<Game> listAllGames() {

        //todo: implementation

        return null;
    }

    public Game joinGame(User user, GameDto gameDto){

        //todo: add implementation

        return null;
    }
}
