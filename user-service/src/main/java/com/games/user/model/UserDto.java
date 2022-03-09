package com.games.user.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @Nullable
    private UUID id = null;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;
}
