package ru.aleksseii.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Student {

    private @Positive int studentId;

    private @Positive int groupId;

    private @NotEmpty String email;

    private @NotEmpty String pass;

    private @NotEmpty String fullName;

    public Student(@Positive int groupId,
                   @NotEmpty String email,
                   @NotEmpty String pass,
                   @NotEmpty String fullName) {

        this(0, groupId, email, pass, fullName);
    }
}
