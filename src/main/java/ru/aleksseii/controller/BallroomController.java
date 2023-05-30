package ru.aleksseii.controller;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aleksseii.dao.impl.BallroomDao;

@RestController
@RequestMapping("/ballroom")
public final class BallroomController {

    private final @NotNull BallroomDao ballroomDao;

    @Autowired
    public BallroomController(@NotNull BallroomDao ballroomDao) {
        this.ballroomDao = ballroomDao;
    }
}
