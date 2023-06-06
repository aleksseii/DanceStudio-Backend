package ru.aleksseii.controller;

import com.google.gson.Gson;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aleksseii.dao.impl.BallroomDao;
import ru.aleksseii.dto.Ballroom;

import java.util.List;

@RestController
@RequestMapping("/ballroom")
public final class BallroomController {

    private static final @NotNull Gson GSON = new Gson();

    private final @NotNull BallroomDao ballroomDao;

    @Autowired
    public BallroomController(@NotNull BallroomDao ballroomDao) {
        this.ballroomDao = ballroomDao;
    }

    @GetMapping("")
    public @NotNull String ballrooms() {

        List<Ballroom> ballrooms = ballroomDao.getAll();
        return GSON.toJson(ballrooms);
    }

    @GetMapping("/{id}")
    public @NotNull String getById(@PathVariable("id") @Positive int ballroomId) {

        Ballroom ballroom = ballroomDao.get(ballroomId);
        return GSON.toJson(ballroom);
    }

    @PostMapping("")
    public String insert(@RequestParam("name") String ballroomName) {

        Ballroom newBallroom = new Ballroom(ballroomName);
        ballroomDao.save(newBallroom);
        return GSON.toJson(newBallroom);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") @Positive int ballroomId) {

        Ballroom ballroom = ballroomDao.get(ballroomId);
        ballroomDao.delete(ballroomId);
        return GSON.toJson(ballroom);
    }
}
