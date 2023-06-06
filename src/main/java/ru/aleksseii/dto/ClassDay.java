package ru.aleksseii.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ClassDay(@NotNull String dayOfWeek,
                       @NotNull String timeStart,
                       @Positive int ballroomId,
                       @NotNull String ballroomName,
                       @NotNull String teacherName) {
}
