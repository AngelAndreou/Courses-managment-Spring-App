CREATE DATABASE `web_app` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `web_app` ;
DROP TABLE IF EXISTS `courses`;
DROP TABLE IF EXISTS `students`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `courses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `syllabus` varchar(45) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `semester` varchar(45) DEFAULT NULL,
  `grade_average` decimal(5,2) DEFAULT NULL,
  `description` varchar(90) DEFAULT NULL,
  `instructor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `year_of_registration` varchar(45) DEFAULT NULL,
  `semester` varchar(45) DEFAULT NULL,
  `year_of_studies` varchar(45) DEFAULT NULL,
  `grade_project` decimal(5,2) DEFAULT NULL,
  `grade_exam` decimal(5,2) DEFAULT NULL,
  `total_grade` decimal(5,2) DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  `weight_project` decimal(5,2) DEFAULT '0.50',
  `weight_exam` decimal(5,2) DEFAULT '0.50',
  PRIMARY KEY (`id`),
  KEY `fk_courseid_idx` (`course_id`),
  CONSTRAINT `fk_courseid` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



create table `users` (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table `authorities` (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

insert into users(username, password, enabled)values('angel','{noop}angel',true);
insert into users(username, password, enabled)values('admin','{noop}admin',true);

insert into authorities(username,authority)values('angel','ROLE_ADMIN');
insert into authorities(username,authority)values('admin','ROLE_ADMIN');