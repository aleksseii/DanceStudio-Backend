package ru.aleksseii;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DanceStudioApplication {

    public static void main(@NotNull String @NotNull [] args) {

        SpringApplication.run(DanceStudioApplication.class, args);
    }
}
