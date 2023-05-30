CREATE TABLE IF NOT EXISTS time_slot(
    time_slot_id    SERIAL          PRIMARY KEY,
    day_of_week     VARCHAR(16)     NOT NULL,
    _time           TIME            NOT NULL
);

INSERT INTO time_slot(day_of_week, _time     )
VALUES
                     ('Monday',    '10:00:00'),
                     ('Monday',    '12:00:00'),
                     ('Monday',    '14:00:00'),
                     ('Monday',    '16:00:00'),

                     ('Tuesday',   '10:00:00'),
                     ('Tuesday',   '12:00:00'),
                     ('Tuesday',   '14:00:00'),
                     ('Tuesday',   '16:00:00'),

                     ('Wednesday', '10:00:00'),
                     ('Wednesday', '12:00:00'),
                     ('Wednesday', '14:00:00'),
                     ('Wednesday', '16:00:00'),

                     ('Thursday',  '10:00:00'),
                     ('Thursday',  '12:00:00'),
                     ('Thursday',  '14:00:00'),
                     ('Thursday',  '16:00:00'),

                     ('Friday',    '10:00:00'),
                     ('Friday',    '12:00:00'),
                     ('Friday',    '14:00:00'),
                     ('Friday',    '16:00:00');
