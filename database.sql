DROP DATABASE IF EXISTS jobHelper;
CREATE DATABASE jobHelper;
USE jobHelper;
CREATE TABLE users(
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(255),
email VARCHAR(255),
phone VARCHAR(255),
pass VARCHAR(255)
);
INSERT INTO users VALUES (1, "admin", "admin@local.bg", "0888948064", "admin");