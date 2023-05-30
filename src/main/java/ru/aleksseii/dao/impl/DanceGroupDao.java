package ru.aleksseii.dao.impl;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.aleksseii.dao.CrudDao;
import ru.aleksseii.dto.DanceGroup;

import java.util.List;

@SuppressWarnings({ "SqlResolve", "SqlNoDataSourceInspection" })
@Repository
public final class DanceGroupDao implements CrudDao<DanceGroup> {

    private static final @NotNull RowMapper<DanceGroup> DANCE_GROUP_ROW_MAPPER = new DataClassRowMapper<>(DanceGroup.class);

    //    --- SELECT queries ---
    private static final @NotNull String SELECT_DANCE_GROUP_BY_ID_QUERY = """
            SELECT *
              FROM dance_group
             WHERE group_id = ?
            """;

    private static final @NotNull String SELECT_ALL_DANCE_GROUPS_QUERY = """
            SELECT *
              FROM dance_group
            """;

    //    --- INSERT queries ---
    private static final @NotNull String INSERT_NEW_DANCE_GROUP_QUERY = """
            INSERT INTO dance_group(teacher_id, ballroom_id, time_slot_id)
            VALUES (?, ?, ?)
            """;

    //    --- DELETE queries ---
    private static final @NotNull String DELETE_DANCE_GROUP_QUERY = """
            DELETE
              FROM dance_group
             WHERE group_id = ?
            """;

    private final @NotNull JdbcTemplate jdbcTemplate;

    @Autowired
    public DanceGroupDao(@NotNull JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public DanceGroup get(@Positive int id) {
        return jdbcTemplate.query(SELECT_DANCE_GROUP_BY_ID_QUERY, DANCE_GROUP_ROW_MAPPER, id)
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public @NotNull List<@NotNull DanceGroup> getAll() {
        return jdbcTemplate.query(SELECT_ALL_DANCE_GROUPS_QUERY, DANCE_GROUP_ROW_MAPPER);
    }

    @Override
    public void save(@NotNull DanceGroup element) {
        jdbcTemplate.update(
                INSERT_NEW_DANCE_GROUP_QUERY,
                element.getTeacherId(),
                element.getBallroomId(),
                element.getTimeSlotId()
        );
    }

    @Override
    public void delete(@Positive int id) {
        jdbcTemplate.update(DELETE_DANCE_GROUP_QUERY, id);
    }
}
