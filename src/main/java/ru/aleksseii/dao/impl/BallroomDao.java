package ru.aleksseii.dao.impl;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.aleksseii.dao.CrudDao;
import ru.aleksseii.dto.Ballroom;

import java.util.List;

@SuppressWarnings({ "SqlResolve", "SqlNoDataSourceInspection" })
@Repository
public final class BallroomDao implements CrudDao<Ballroom> {

    private static final @NotNull RowMapper<Ballroom> BALLROOM_ROW_MAPPER = new DataClassRowMapper<>(Ballroom.class);

    //    --- SELECT queries ---
    private static final @NotNull String SELECT_BALLROOM_BY_ID_QUERY = """
            SELECT *
              FROM ballroom
             WHERE ballroom_id = ?
            """;

    private static final @NotNull String SELECT_ALL_BALLROOMS_QUERY = """
            SELECT *
              FROM ballroom
            """;

    //    --- INSERT queries ---
    private static final @NotNull String INSERT_NEW_BALLROOM_QUERY = """
            INSERT INTO ballroom(ballroom_name)
            VALUES (?)
            """;

    //    --- DELETE queries ---
    private static final @NotNull String DELETE_BALLROOM_QUERY = """
            DELETE
              FROM ballroom
             WHERE ballroom_id = ?
            """;

    private final @NotNull JdbcTemplate jdbcTemplate;

    @Autowired
    public BallroomDao(@NotNull JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Ballroom get(@Positive int id) {

        return jdbcTemplate.query(SELECT_BALLROOM_BY_ID_QUERY, BALLROOM_ROW_MAPPER, id)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public @NotNull List<@NotNull Ballroom> getAll() {
        return jdbcTemplate.query(SELECT_ALL_BALLROOMS_QUERY, BALLROOM_ROW_MAPPER);
    }

    @Override
    public void save(@NotNull Ballroom element) {
        jdbcTemplate.update(
                INSERT_NEW_BALLROOM_QUERY,
                element.getBallroomName()
        );
    }

    @Override
    public void delete(@Positive int id) {
        jdbcTemplate.update(DELETE_BALLROOM_QUERY, id);
    }
}
