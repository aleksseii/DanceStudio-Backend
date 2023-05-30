package ru.aleksseii.controller;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aleksseii.dao.impl.TeacherDao;

@RestController
@RequestMapping("/teacher")
public final class TeacherController {

    private final @NotNull TeacherDao teacherDao;

    @Autowired
    public TeacherController(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
}
