CREATE TABLE IF NOT EXISTS users
(

    id        SERIAL PRIMARY KEY,
    name      VARCHAR,
    user_name VARCHAR UNIQUE,
    email     VARCHAR UNIQUE,
    password  VARCHAR


);

CREATE TABLE IF NOT EXISTS category
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR UNIQUE,
    description VARCHAR


);
CREATE TABLE IF NOT EXISTS brand
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR UNIQUE,
    website     VARCHAR,
    description VARCHAR


);
CREATE TABLE IF NOT EXISTS product
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR,
    create_date VARCHAR,
    category_id INTEGER,
    brand_id    INTEGER,
    FOREIGN KEY (category_id) REFERENCES category (id),
    FOREIGN KEY (brand_id) REFERENCES brand (id)
);
CREATE TABLE IF NOT EXISTS shareholder
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR,
    phone_number  VARCHAR,
    national_code VARCHAR UNIQUE


);
CREATE TABLE IF NOT EXISTS shareholder_brand
(
    id             INTEGER,
    brand_id       INTEGER,
    shareholder_id INTEGER,
    FOREIGN KEY (brand_id) REFERENCES shareholder (id),
    FOREIGN KEY (shareholder_id) REFERENCES brand (id)
);