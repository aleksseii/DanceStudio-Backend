package ru.aleksseii.controller;

import com.google.gson.Gson;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aleksseii.dao.impl.TeacherDao;
import ru.aleksseii.dto.Teacher;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public final class TeacherController {

    private static final @NotNull Gson GSON = new Gson();

    private final @NotNull TeacherDao teacherDao;

    @Autowired
    public TeacherController(@NotNull TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @GetMapping("")
    public @NotNull String teachers() {

        List<Teacher> teachers = teacherDao.getAll();
        return GSON.toJson(teachers);
    }

    @GetMapping("/{id}")
    public @NotNull String getById(@PathVariable("id") @Positive int teacherId) {

        Teacher teacher = teacherDao.get(teacherId);
        return GSON.toJson(teacher);
    }

    @PostMapping("")
    public String insert(@RequestParam("email") String email,
                         @RequestParam("pass") String pass,
                         @RequestParam("full_name") String fullName) {

        Teacher newTeacher = new Teacher(
                email,
                pass,
                fullName
        );
        teacherDao.save(newTeacher);
        return GSON.toJson(newTeacher);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") @Positive int teacherId) {

        Teacher teacher = teacherDao.get(teacherId);
        teacherDao.delete(teacherId);
        return GSON.toJson(teacher);
    }
}
