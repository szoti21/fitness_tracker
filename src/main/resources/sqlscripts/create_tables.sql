CREATE TABLE users (
    id INT not null auto_increment primary key,
    name VARCHAR(500),
    email_address VARCHAR(500) unique,
    password VARCHAR(1000),
    birth_date DATE,
    phone VARCHAR(500),
    role_id INT not null,
    constraint FK_users_role_id foreign key(role_id) references roles(role_id)
    );

CREATE TABLE food (
    id INT not null auto_increment primary key,
    food_name VARCHAR(500) unique not null,
    kcal INT,
    protein INT,
    fat INT,
    carbohydrates INT
    );

CREATE TABLE intake (
    date DATETIME,
    user_id INT not null,
    food_id INT not null,
    quantity INT,
    primary key(date, user_id),
    constraint FK_intake_user_id foreign key(user_id) references users(id),
    constraint FK_intake_food_id foreign key(food_id) references food(id)
    );

CREATE TABLE biometrics (
    date DATE,
    user_id INT,
    height INT,
    weight INT,
    body_fat INT,
    primary key(date, user_id),
    constraint FK_biometrics_user_id foreign key(user_id) references users(id)
);

CREATE TABLE roles (
    role_id INT not null auto_increment primary key,
    role_name VARCHAR(500)
    );
