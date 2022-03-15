package com.games.battle.domain;

import com.games.battle.enums.CrisCrossMark;
import com.games.battle.enums.GameStatus;
import com.games.battle.enums.GameType;
import com.games.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false )
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "first_user_id", nullable = true)
    private User firstUser;

    @ManyToOne
    @JoinColumn(name = "second_user_id", nullable = true)
    private User secondUser;

    @Enumerated(EnumType.STRING)
    private GameType gameType;

    @Enumerated(EnumType.STRING)
    private GameStatus gameStatus;

    @Enumerated(EnumType.STRING)
    private CrisCrossMark firstUserMark;

    @Column(name = "created", nullable = false)
    private Date created;
}
