-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE IF NOT EXISTS ballroom(
    ballroom_id      SERIAL         PRIMARY KEY,
    ballroom_name    VARCHAR(32)    NOT NULL
);

CREATE TABLE IF NOT EXISTS teacher(
    teacher_id      SERIAL          PRIMARY KEY,
    email           VARCHAR(64)     NOT NULL,
    pass            VARCHAR(64)     NOT NULL,
    full_name       VARCHAR(64)     NOT NULL
);

CREATE TABLE IF NOT EXISTS dance_group(
    group_id        SERIAL      PRIMARY KEY,
    teacher_id      INT
        REFERENCES teacher(teacher_id)
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    ballroom_id     INT
        REFERENCES ballroom(ballroom_id)
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    time_slot_id    INT
        REFERENCES time_slot(time_slot_id)
        ON UPDATE CASCADE
        ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS student(
    student_id      SERIAL          PRIMARY KEY,
    group_id        INT
        REFERENCES dance_group(group_id)
        ON UPDATE CASCADE
        ON DELETE SET NULL,
    email           VARCHAR(64)     NOT NULL,
    pass            VARCHAR(64)     NOT NULL,
    full_name       VARCHAR(64)     NOT NULL
);
