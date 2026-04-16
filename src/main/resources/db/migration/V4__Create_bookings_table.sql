CREATE TABLE IF NOT EXISTS bookings
(
    id             BIGSERIAL PRIMARY KEY,
    user_id        BIGINT      NOT NULL,
    room_id        BIGINT      NOT NULL,
    check_in_date  DATE        NOT NULL,
    check_out_date DATE        NOT NULL,
    status         VARCHAR(20) NOT NULL,
    created_at     DATE        NOT NULL DEFAULT CURRENT_DATE,

    CONSTRAINT status_check CHECK ( status IN ('CREATED', 'CANCELED') ),
    CONSTRAINT fk_bookings_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_bookings_room FOREIGN KEY (room_id) REFERENCES rooms (id)
)