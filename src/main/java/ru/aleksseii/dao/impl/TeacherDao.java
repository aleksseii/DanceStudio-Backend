package ru.aleksseii.dao.impl;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.aleksseii.dao.CrudDao;
import ru.aleksseii.dto.Teacher;

import java.util.List;

@SuppressWarnings({ "SqlResolve", "SqlNoDataSourceInspection" })
@Repository
public final class TeacherDao implements CrudDao<Teacher> {

    private static final @NotNull RowMapper<Teacher> TEACHER_ROW_MAPPER = new DataClassRowMapper<>(Teacher.class);

    //    --- SELECT queries ---
    private static final @NotNull String SELECT_TEACHER_BY_ID_QUERY = """
            SELECT *
              FROM teacher
             WHERE teacher_id = ?
            """;

    private static final @NotNull String SELECT_ALL_TEACHERS_QUERY = """
            SELECT *
              FROM teacher
            """;

    //    --- INSERT queries ---
    private static final @NotNull String INSERT_NEW_TEACHER_QUERY = """
            INSERT INTO teacher(email, pass, full_name)
            VALUES (?, ?, ?)
            """;

    //    --- DELETE queries ---
    private static final @NotNull String DELETE_TEACHER_QUERY = """
            DELETE
              FROM teacher
             WHERE teacher_id = ?
            """;

    private final @NotNull JdbcTemplate jdbcTemplate;

    @Autowired
    public TeacherDao(@NotNull JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Teacher get(@Positive int id) {
        return jdbcTemplate.query(SELECT_TEACHER_BY_ID_QUERY, TEACHER_ROW_MAPPER, id)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public @NotNull List<@NotNull Teacher> getAll() {
        return jdbcTemplate.query(SELECT_ALL_TEACHERS_QUERY, TEACHER_ROW_MAPPER);
    }

    @Override
    public void save(@NotNull Teacher element) {
        jdbcTemplate.update(
                INSERT_NEW_TEACHER_QUERY,
                element.getEmail(),
                element.getPass(),
                element.getFullName()
        );
    }

    @Override
    public void delete(@Positive int id) {
        jdbcTemplate.update(DELETE_TEACHER_QUERY, id);
    }
}
