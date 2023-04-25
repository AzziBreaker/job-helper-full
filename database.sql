CREATE DATABASE jobHelper;
USE jobHelper;
CREATE TABLE users(
id INT,
username VARCHAR(255),
email VARCHAR(255),
phone VARCHAR(255),
password VARCHAR(255)
);
INSERT INTO users VALUES (1, "admin", "admin@local.bg", "0888948064", "admin");