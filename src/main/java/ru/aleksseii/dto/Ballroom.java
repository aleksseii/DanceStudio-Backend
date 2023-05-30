package ru.aleksseii.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Ballroom {

    private @Positive int ballroomId;

    private @NotNull String ballroomName;

    public Ballroom(String ballroomName) {
        this(0, ballroomName);
    }
}
