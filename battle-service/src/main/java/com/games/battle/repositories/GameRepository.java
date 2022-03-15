package com.games.battle.repositories;

import com.games.battle.domain.Game;
import com.games.battle.enums.GameStatus;
import com.games.battle.enums.GameType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {

    List<Game> findGameByStatus(GameStatus gameStatus);

    List<Game> findGameByTypeAndStatus(GameType gameType, GameStatus gameStatus);
}
