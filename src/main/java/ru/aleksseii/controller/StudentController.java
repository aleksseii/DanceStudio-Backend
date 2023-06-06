package ru.aleksseii.controller;

import com.google.gson.Gson;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aleksseii.dao.impl.StudentDao;
import ru.aleksseii.dto.Student;

import java.util.List;

@RestController
@RequestMapping("/student")
public final class StudentController {

    private static final @NotNull Gson GSON = new Gson();

    private final @NotNull StudentDao studentDao;

    @Autowired
    public StudentController(@NotNull StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("")
    public @NotNull String students() {

        List<Student> students = studentDao.getAll();
        return GSON.toJson(students);
    }

    @GetMapping("/{id}")
    public @NotNull String getById(@PathVariable("id") @Positive int studentId) {

        Student student = studentDao.get(studentId);
        return GSON.toJson(student);
    }

    @PostMapping("")
    public String insert(@RequestParam("group_id") @Positive int groupId,
                         @RequestParam("email") String email,
                         @RequestParam("pass") String pass,
                         @RequestParam("full_name") String fullName) {

        Student newStudent = new Student(
                groupId,
                email,
                pass,
                fullName
        );
        studentDao.save(newStudent);
        return GSON.toJson(newStudent);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") @Positive int studentId) {

        Student student = studentDao.get(studentId);
        studentDao.delete(studentId);
        return GSON.toJson(student);
    }
}
