package ru.aleksseii.dao.impl;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.aleksseii.dao.CrudDao;
import ru.aleksseii.dto.Student;

import java.util.List;

@SuppressWarnings({ "SqlResolve", "SqlNoDataSourceInspection" })
@Repository
public final class StudentDao implements CrudDao<Student> {

    private static final @NotNull RowMapper<Student> STUDENT_ROW_MAPPER = new DataClassRowMapper<>(Student.class);

    //    --- SELECT queries ---
    private static final @NotNull String SELECT_STUDENT_BY_ID_QUERY = """
            SELECT *
              FROM student
             WHERE student_id = ?
            """;

    private static final @NotNull String SELECT_ALL_STUDENTS_QUERY = """
            SELECT *
              FROM student
            """;

    //    --- INSERT queries ---
    private static final @NotNull String INSERT_NEW_STUDENT_QUERY = """
            INSERT INTO student(group_id, email, pass, full_name)
            VALUES (?, ?, ?, ?)
            """;

    //    --- DELETE queries ---
    private static final @NotNull String DELETE_STUDENT_QUERY = """
            DELETE
              FROM student
             WHERE student_id = ?
            """;

    private final @NotNull JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDao(@NotNull JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Student get(@Positive int id) {
        return jdbcTemplate.query(SELECT_STUDENT_BY_ID_QUERY, STUDENT_ROW_MAPPER, id)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public @NotNull List<@NotNull Student> getAll() {
        return jdbcTemplate.query(SELECT_ALL_STUDENTS_QUERY, STUDENT_ROW_MAPPER);
    }

    @Override
    public void save(@NotNull Student element) {
        jdbcTemplate.update(
                INSERT_NEW_STUDENT_QUERY,
                element.getGroupId(),
                element.getEmail(),
                element.getPass(),
                element.getFullName()
        );
    }

    @Override
    public void delete(@Positive int id) {
        jdbcTemplate.update(DELETE_STUDENT_QUERY, id);
    }
}
