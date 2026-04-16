CREATE TABLE IF NOT EXISTS rooms
(
    id              BIGSERIAL PRIMARY KEY,
    hotel_id        BIGINT NOT NULL,
    number          BIGINT NOT NULL,
    capacity        BIGINT,
    price_per_night DECIMAL(11, 2),
    active          BOOLEAN,

    CONSTRAINT fk_rooms_hotel FOREIGN KEY (hotel_id) REFERENCES hotels (id)
)