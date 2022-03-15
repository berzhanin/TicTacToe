package com.games.battle.model;

import com.games.battle.enums.CrisCrossMark;
import com.games.battle.enums.GameType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDto {

    @NotNull
    private int id;

    @NotNull
    private GameType gameType;

    @NotNull
    private CrisCrossMark mark;
}
