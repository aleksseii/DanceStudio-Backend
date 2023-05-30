package ru.aleksseii.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Teacher {

    private @Positive int teacherId;

    private @NotEmpty String email;

    private @NotEmpty String pass;

    private @NotEmpty String fullName;

    public Teacher(@NotEmpty String email,
                   @NotEmpty String pass,
                   @NotEmpty String fullName) {

        this(0, email, pass, fullName);
    }
}
