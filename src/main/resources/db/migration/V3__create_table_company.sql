CREATE TYPE person_type AS ENUM('PJ', 'PF');

CREATE TYPE company_status AS ENUM('PENDING', 'ACTIVE', 'SUSPEND');

CREATE TABLE company
(
    id                 uuid           NOT NULL PRIMARY KEY,
    person_type        person_type    not null,
    fantasy_name       VARCHAR(200)   NOT NULL,
    document           VARCHAR(14)    NOT NULL UNIQUE,
    legal_name         VARCHAR(200)   NOT NULL,
    state_registration VARCHAR(20),
    email              VARCHAR(200)   NOT NULL,
    phone              VARCHAR(20)    NOT NULL,
    description        TEXT,
    logo_url           TEXT,
    status             company_status NOT NULL,
    created_at         TIMESTAMPTZ    NOT NULL DEFAULT NOW(),
    updated_at         TIMESTAMPTZ    NOT NULL DEFAULT NOW()
);