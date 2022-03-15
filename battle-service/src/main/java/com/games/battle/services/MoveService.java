package com.games.battle.services;

import com.games.battle.domain.Game;
import com.games.battle.domain.Move;
import com.games.battle.enums.GameStatus;
import com.games.battle.model.MoveDto;
import com.games.battle.repositories.MoveRepository;
import com.games.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MoveService {

    private final MoveRepository moveRepository;

    public Move createMove(Game game, User user, MoveDto moveDto){
        Move move = new Move();

        //todo: add setters

        moveRepository.save(move);

        return move;
    }

    public GameStatus checkGameStatus(Game game){

        //todo: implementation for different GameStatuses

        return GameStatus.START;
    }
}
