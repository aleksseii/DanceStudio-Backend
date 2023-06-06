package ru.aleksseii.controller;

import com.google.gson.Gson;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aleksseii.dao.impl.DanceGroupDao;
import ru.aleksseii.dto.ClassDay;
import ru.aleksseii.dto.DanceGroup;

import java.util.List;

@RestController
@RequestMapping("/group")
public final class DanceGroupController {

    private static final @NotNull Gson GSON = new Gson();

    private final @NotNull DanceGroupDao danceGroupDao;

    @Autowired
    public DanceGroupController(@NotNull DanceGroupDao danceGroupDao) {
        this.danceGroupDao = danceGroupDao;
    }

    @GetMapping("/calendar")
    public @NotNull String calendar() {
        List<ClassDay> calendar = danceGroupDao.getCalendar();
        return GSON.toJson(calendar);
    }

    @GetMapping("")
    public @NotNull String groups() {

        List<DanceGroup> groups = danceGroupDao.getAll();
        return GSON.toJson(groups);
    }

    @GetMapping("/{id}")
    public @NotNull String getById(@PathVariable("id") @Positive int danceGroupId) {

        DanceGroup danceGroup = danceGroupDao.get(danceGroupId);
        return GSON.toJson(danceGroup);
    }

    @PostMapping("")
    public String insert(@RequestParam("teacher_id") @Positive int teacherId,
                         @RequestParam("ballroom_id") @Positive int ballroomId,
                         @RequestParam("time_slot_id") @Positive int timeSlotId) {

        DanceGroup newDanceGroup = new DanceGroup(
                teacherId,
                ballroomId,
                timeSlotId
        );
        danceGroupDao.save(newDanceGroup);
        return GSON.toJson(newDanceGroup);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") @Positive int groupId) {

        DanceGroup danceGroup = danceGroupDao.get(groupId);
        danceGroupDao.delete(groupId);
        return GSON.toJson(danceGroup);
    }
}
