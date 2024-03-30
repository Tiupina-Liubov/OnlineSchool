SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+01:00";

CREATE DATABASE IF NOT EXISTS `online_school` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci*/ /*!80016 DEFAULT ENCRYPTION = 'N';
USE online_school;

-- Table structure for table `authorities`

CREATE TABLE `authorities`
(
    `authority_id`   BINARY(16) PRIMARY KEY,
    `authority_name` ENUM ('CREATE','READ','UPDATE','DELETE') DEFAULT 'READ',
    `created_at`     TIMESTAMP                                DEFAULT CURRENT_TIMESTAMP,
    `update_at`      TIMESTAMP                                DEFAULT NULL

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `roles`

CREATE TABLE `roles`
(
    `role_id`   BINARY(16) PRIMARY KEY,
    `create_at` TIMESTAMP                                                          DEFAULT CURRENT_TIMESTAMP,
    `role_name` ENUM ('ADMIN','TEACHER','CLASS_ROOM_TEACHER','STUDENT','DIRECTOR') DEFAULT 'STUDENT',
    `update_at` TIMESTAMP                                                          DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `role_authority`

CREATE TABLE `role_authority`
(
    `authority_authority_id` BINARY(16) NOT NULL,
    `roles_role_id`          binary(16) NOT NULL,
    CONSTRAINT `role_id` FOREIGN KEY (`roles_role_id`) REFERENCES `roles` (`role_id`),
    CONSTRAINT `authority_id` FOREIGN KEY (`authority_authority_id`) REFERENCES `authorities` (`authority_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `user_infos`

CREATE TABLE `user_infos`
(
    `user_info_id`    binary(16) PRIMARY KEY,
    `email`           varchar(255) UNIQUE,
    `password`        varchar(255)   NOT NULL,
    `payment_tribute` varchar(255)   NOT NULL,
    `phone_number`    varchar(255)   NOT NULL,
    `salary`          decimal(10, 2) NOT NULL,
    `update_at`       TIMESTAMP DEFAULT NULL,
    `create_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `username`        varchar(255) UNIQUE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `schools`

CREATE TABLE `schools`
(
    `school_id`    BINARY(16) PRIMARY KEY,
    `address`      VARCHAR(255)                                                                                 DEFAULT NULL,
    `create_at`    TIMESTAMP                                                                                    DEFAULT CURRENT_TIMESTAMP,
    `is_open`      BIT(1)                                                                                       DEFAULT NULL,
    `link`         VARCHAR(512)                                                                                 DEFAULT NULL,
    `name`         VARCHAR(255)                                                                                 DEFAULT NULL,
    `phone_number` VARCHAR(25)                                                                                  DEFAULT NULL,
    `type_schools` ENUM ('COLLEGE','ELEMENTARY','HIGH','JUNIOR_COLLEGE','JUNIOR_HIGH','TECHNICAL','UNIVERSITY') DEFAULT NULL,
    `update_at`    TIMESTAMP                                                                                    DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `user_info_role`

CREATE TABLE `user_info_role`
(
    `user_info_id` BINARY(16) PRIMARY KEY,
    `role_id`      BINARY(16) NOT NULL,
    CONSTRAINT `fk_user_info_id` FOREIGN KEY (`user_info_id`) REFERENCES `user_infos` (`user_info_id`),
    CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `school_classes`

CREATE TABLE `school_classes`
(
    `class_id`   BINARY(16) PRIMARY KEY,
    `class_name` VARCHAR(255) DEFAULT NULL,
    `create_at`  TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    `update_at`  TIMESTAMP    DEFAULT NULL,
    `school_id`  BINARY(16) NOT NULL,
    CONSTRAINT `fk_school_id` FOREIGN KEY (`school_id`) REFERENCES `schools` (`school_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `users`
CREATE TABLE `users`
(
    `user_id`      BINARY(16) PRIMARY KEY,
    `age`          INT       DEFAULT 0,
    `first_name`   VARCHAR(255) NOT NULL,
    `last_name`    VARCHAR(255) NOT NULL,
    `create_at`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at`    TIMESTAMP DEFAULT NULL,
    `class_id`     BINARY(16)   NOT NULL,
    `user_info_id` BINARY(16)   NOT NULL,
    UNIQUE KEY `UK_65t6bc8nlb8lpnk86aimnl7pd` (`user_info_id`),
    KEY `FKnn16x6b0t9rgy795hsj5h8cry` (`class_id`),
    CONSTRAINT `FKnn16x6b0t9rgy795hsj5h8cry` FOREIGN KEY (`class_id`) REFERENCES `school_classes` (`class_id`),
    CONSTRAINT `FKsgb97rb3a0nnev8y3nvu9unmk` FOREIGN KEY (`user_info_id`) REFERENCES `user_infos` (`user_info_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `lessons`

CREATE TABLE `lessons`
(
    `lesson_id`  binary(16) PRIMARY KEY,
    `create_at`  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `time`       time(6)   DEFAULT NULL,
    `update_at`  TIMESTAMP DEFAULT NULL,
    `class_id`   binary(16) NOT NULL,
    `subject_id` binary(16) NOT NULL,
    `teacher_id` binary(16) NOT NULL

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `school_subjects`

CREATE TABLE `school_subjects`
(
    `subject_id`   BINARY(16) PRIMARY KEY,
    `count_hours`  INT       DEFAULT 0,
    `create_at`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at`    TIMESTAMP DEFAULT NULL,
    `subject_name` ENUM('HISTORY','MATHEMATICS', 'GEOGRAPHY', 'INFORMATICS', 'LITERATURE') NOT NULL
)ENGINE = InnoDB
 DEFAULT CHARSET = utf8mb4
 COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `themes`

CREATE TABLE `themes`
(
    `theme_id` BINARY(16) PRIMARY KEY,
    `thema_name` VARCHAR(255) DEFAULT NULL,
    `create_at`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at`    TIMESTAMP DEFAULT NULL,
    `subject_id` BINARY(16) DEFAULT NULL,
    CONSTRAINT `FK4tfrjhvv2v7hkaboute0cqkk3` FOREIGN KEY (`subject_id`) REFERENCES `school_subjects` (`subject_id`)

)ENGINE=InnoDB
 DEFAULT CHARSET=utf8mb4
 COLLATE=utf8mb4_0900_ai_ci;

-- Table structure for table `school_class_subjects`

CREATE TABLE `school_class_subjects`
(
    `class_id`   BINARY(16) NOT NULL,
    `subject_id` BINARY(16) NOT NULL,

    CONSTRAINT `FK57b8ex6ynjpbcjekn3m4pdw96` FOREIGN KEY (`subject_id`) REFERENCES `school_subjects` (`subject_id`),
    CONSTRAINT `FKatjhr0n9o093gl0dkqjk005ux` FOREIGN KEY (`class_id`) REFERENCES `school_classes` (`class_id`)
)ENGINE=InnoDB
 DEFAULT CHARSET=utf8mb4
 COLLATE=utf8mb4_0900_ai_ci;


COMMIT;
