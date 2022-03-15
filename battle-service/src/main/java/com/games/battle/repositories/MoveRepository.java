package com.games.battle.repositories;

import com.games.battle.domain.Game;
import com.games.battle.domain.Move;
import com.games.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MoveRepository extends CrudRepository<Move, Long> {

    List<Move> findGameByName(Game game);

    List<Move> findGameByNameAndUser(Game game, User user);

    int countGamesByUser(Game game, User user);
}
