CREATE TABLE client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3 AND LENGTH(name) <= 200)
);

CREATE TABLE Planet (
    id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(500) NOT NULL,
    CONSTRAINT check_id_format CHECK (id ~ '^[A-Z]+$')
);

CREATE TABLE ticket (
id IDENTITY PRIMARY KEY,
created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
client_id BIGINT NOT NULL,
from_planet_id VARCHAR NOT NULL,
to_planet_id VARCHAR NOT NULL,
CONSTRAINT ticket_client FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE,
CONSTRAINT ticket_from_planet FOREIGN KEY (from_planet_id) REFERENCES planet (id) ON DELETE CASCADE,
CONSTRAINT ticket_to_planet FOREIGN KEY (to_planet_id) REFERENCES planet (id) ON DELETE CASCADE
);
