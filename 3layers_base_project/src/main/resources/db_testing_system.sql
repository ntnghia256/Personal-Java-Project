-- 1. DROP DATABASE & CREATE DATABASE
DROP DATABASE IF EXISTS db_testing_system;
CREATE DATABASE db_testing_system;
USE db_testing_system;

-- Department
DROP TABLE IF EXISTS department;
CREATE TABLE department (
    department_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(40) NOT NULL UNIQUE
);

-- Position
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
    position_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
--     position_name ENUM('Dev', 'Test', 'Scrum Master', 'PM') NOT NULL UNIQUE
	position_name VARCHAR(50) NOT NULL UNIQUE
);

-- Account
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
    account_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50) NOT NULL UNIQUE,
    username VARCHAR(50) NOT NULL UNIQUE,
    full_name VARCHAR(50) NOT NULL,
    department_id TINYINT UNSIGNED NOT NULL,
    position_id TINYINT UNSIGNED NOT NULL,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department(department_id),
    FOREIGN KEY (position_id) REFERENCES `position`(position_id)
);

-- Group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
    group_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    group_name VARCHAR(30) NOT NULL,
    creator_id INT UNSIGNED NOT NULL,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);

-- Group account
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account (
    group_id TINYINT UNSIGNED,
    account_id INT UNSIGNED,
    join_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (group_id, account_id),
    FOREIGN KEY (group_id) REFERENCES `group`(group_id),
    FOREIGN KEY (account_id) REFERENCES `account`(account_id)
);

-- TypeQuestion
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question (
    type_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    type_name ENUM('Essay', 'Multiple-Choice') NOT NULL
);

-- CategoryQuestion
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question (
    category_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL UNIQUE
);

-- Question
DROP TABLE IF EXISTS question;
CREATE TABLE question (
    question_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL, -- NOI DUNG NHIEU
    category_id TINYINT UNSIGNED NOT NULL,
    type_id TINYINT UNSIGNED NOT NULL,
    creator_id INT UNSIGNED NOT NULL,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id),
    FOREIGN KEY (type_id) REFERENCES type_question(type_id),
    FOREIGN KEY (creator_id) REFERENCES account(account_id)
);

-- Answer
DROP TABLE IF EXISTS answer;
CREATE TABLE answer (
    answer_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL,
    question_id INT UNSIGNED NOT NULL,
    is_correct BOOLEAN NOT NULL CHECK (is_correct IN (0, 1)),
    FOREIGN KEY (question_id) REFERENCES question(question_id)
);

-- Exam
DROP TABLE IF EXISTS exam;
CREATE TABLE exam (
    exam_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `code` VARCHAR(20) NOT NULL UNIQUE,
    title VARCHAR(255) NOT NULL,
    category_id TINYINT UNSIGNED NOT NULL,
    duration TINYINT UNSIGNED NOT NULL CHECK (duration > 0),
    creator_id INT UNSIGNED NOT NULL,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES category_question(category_id),
    FOREIGN KEY (creator_id) REFERENCES account(account_id)
);

-- Exam question
DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question (
	exam_id INT UNSIGNED,
    question_id INT UNSIGNED,
    PRIMARY KEY (exam_id, question_id),
    FOREIGN KEY (exam_id) REFERENCES exam(exam_id),
    FOREIGN KEY (question_id) REFERENCES question(question_id)
);



