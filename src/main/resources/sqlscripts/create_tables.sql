CREATE TABLE users (
    id INT not null auto_increment primary key,
    name VARCHAR(500),
    email_address VARCHAR(500),
    password VARCHAR(500),
    address VARCHAR(500),
    phone VARCHAR(500),
    role_id INT not null
    );

CREATE TABLE food (
    id not null primary key,
    food_name VARCHAR(500) unique not null,
    kcal INT,
    protein INT,
    fat INT,
    carbohydrates INT
    );

CREATE TABLE intake (
    date DATE,
    user_id INT,
    food_id INT,
    quantity INT
    );

CREATE TABLE biometrics (
    date DATE,
    user_id INT,
    height INT,
    weight INT,
    body_fat INT,
    primary key(date, user_id)
    );

CREATE TABLE role (
    role_id INT not null,
    role_name VARCHAR(500)
    );