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
`car_seat` INT NOT NULL,
`reservation` TINYINT NOT NULL DEFAULT(false)
);

CREATE TABLE reservation (
`reserve_code` INT PRIMARY KEY AUTO_INCREMENT,
`user_id` VARCHAR(20) NOT NULL,
`car_code` INT NOT NULL,
`start_date` TIMESTAMP NOT NULL,
`end_date` TIMESTAMP NOT NULL,
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
`reg_write` TIMESTAMP NOT NULL DEFAULT(NOW()),
`mod_write` TIMESTAMP NOT NULL DEFAULT(NOW()) ON UPDATE NOW(),
FOREIGN KEY(`user_id`) REFERENCES users(`user_id`)
);

USE rent_car_db;
INSERT INTO cars(car_code, car_name, car_price, car_type, car_seat, reservation)
VALUES
('1001', 'GV80', 100000, '대형', 5, false),
('1002', '아반떼', 70000, '준중형', 5, false),
('1003', '쏘나타', 80000, '중형', 5, false),
('1004', 'K5', 75000, '중형', 5, false),
('1005', '쏘렌토', 90000, '중형', 6, false),
('1006', '모닝', 40000, '경형', 4, false),
('1007', '그랜저', 90000, '준대형', 5, false),
('1008', 'G80', 95000, '대형', 5, false),
('1009', '스포티지', 65000, '준중형', 5, false),
('1010', '코나', 60000, '소형', 5, false),
('1011', 'K8', 90000, '준대형', 5, false),
('1012', '투싼', 70000, '준중형', 5, false),
('1013', '싼타페', 85000, '중형', 7, false),
('1014', '스타리아', 120000, '대형', 9, false),
('1015', '팰리세이드', 110000, '대형', 7, false);