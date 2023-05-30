package ru.aleksseii.controller;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aleksseii.dao.impl.DanceGroupDao;

@RestController
@RequestMapping("/group")
public final class DanceGroupController {

    private final @NotNull DanceGroupDao danceGroupDao;

    @Autowired
    public DanceGroupController(@NotNull DanceGroupDao danceGroupDao) {
        this.danceGroupDao = danceGroupDao;
    }
}
