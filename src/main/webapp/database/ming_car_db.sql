CREATE DATABASE rent_car_db;
USE rent_car_db;

CREATE TABLE users (
`user_id` VARCHAR(20) PRIMARY KEY,
`password` VARCHAR(255) NOT NULL,
`email` VARCHAR(40),
`name` VARCHAR(40) NOT NULL,
`birth` DATE NOT NULL,
`phone` CHAR(13) NOT NULL UNIQUE CHECK(`phone` REGEXP '^[0-9]{3}-[0-9]{4}-[0-9]{4}$'),
`gender` ENUM('M', 'F') NOT NULL,
`reg_date` TIMESTAMP NOT NULL DEFAULT(NOW()),
`mod_date` TIMESTAMP NOT NULL DEFAULT(NOW()) ON UPDATE NOW()
);

CREATE TABLE cars (
`car_code` INT PRIMARY KEY AUTO_INCREMENT,
`car_name` VARCHAR(20) NOT NULL,
`car_price` INT NOT NULL,
`car_type` VARCHAR(10) NOT NULL,
`car_seat` INT NOT NULL
);

CREATE TABLE reservation (
`reserve_code` INT PRIMARY KEY AUTO_INCREMENT,
`user_id` VARCHAR(20) NOT NULL,
`car_code` INT NOT NULL,
`start_date` DATETIME NOT NULL,
`end_date` DATETIME NOT NULL,
`payment_method` VARCHAR(10) NOT NULL,
`payment` TINYINT NOT NULL DEFAULT(false),
FOREIGN KEY(`user_id`) REFERENCES users(`user_id`),
FOREIGN KEY(`car_code`) REFERENCES cars(`car_code`)
);

CREATE TABLE board (
`board_code` INT PRIMARY KEY AUTO_INCREMENT,
`user_id` VARCHAR(20) NOT NULL,
`title` VARCHAR(100) NOT NULL,
`content` VARCHAR(300) NOT NULL,
`author` VARCHAR(20) NOT NULL,
`category` TINYINT NOT NULL DEFAULT(false),
`reg_write` DATE NOT NULL,
`mod_write` DATE NOT NULL,
FOREIGN KEY(`user_id`) REFERENCES users(`user_id`)
);