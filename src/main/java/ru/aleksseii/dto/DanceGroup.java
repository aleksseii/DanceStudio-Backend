package ru.aleksseii.dto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class DanceGroup {

    private @Positive int groupId;

    private @Positive int teacherId;

    private @Positive int ballroomId;

    private @Positive int timeSlotId;

    public DanceGroup(@Positive int teacherId,
                      @Positive int ballroomId,
                      @Positive int timeSlotId) {

        this(0, teacherId, ballroomId, timeSlotId);
    }
}
