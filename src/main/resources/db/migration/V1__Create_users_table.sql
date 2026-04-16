CREATE TABLE IF NOT EXISTS users
(
    id         BIGSERIAL PRIMARY KEY,
    email      VARCHAR(255) NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    role       VARCHAR(20)  NOT NULL,
    created_at DATE NOT NULL DEFAULT CURRENT_DATE,

    CONSTRAINT role_check CHECK ( role IN ('USER', 'ADMIN') )
);