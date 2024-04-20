DROP TABLE IF EXISTS clazz_subjekts;

DROP TABLE IF EXISTS lessons;

DROP TABLE IF EXISTS role_authority;

DROP TABLE IF EXISTS authorities;

DROP TABLE IF EXISTS themes;

DROP TABLE IF EXISTS subjekts;

DROP TABLE IF EXISTS user_info_role;

DROP TABLE IF EXISTS roles;

DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS clazzes;

DROP TABLE IF EXISTS schools;

DROP TABLE IF EXISTS user_infos;


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
    `authority_id` BINARY(16) NOT NULL,
    `role_id`      binary(16) NOT NULL,
    CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
    CONSTRAINT `authority_id` FOREIGN KEY (`authority_id`) REFERENCES `authorities` (`authority_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `user_infos`

CREATE TABLE `user_infos`
(
    `user_info_id`    binary(16) PRIMARY KEY,
    `username`        varchar(255) UNIQUE,
    `password`        varchar(255)   NOT NULL,
    `payment_tribute` varchar(255)   NOT NULL,
    `phone_number`    varchar(255)   NOT NULL,
    `salary`          decimal(10, 2) NOT NULL,
    `update_at`       TIMESTAMP DEFAULT NULL,
    `create_at`       TIMESTAMP DEFAULT CURRENT_TIMESTAMP

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `schools`

CREATE TABLE `schools`
(
    `school_id`    BINARY(16) PRIMARY KEY,
    `address`      VARCHAR(255)                                                                                 DEFAULT NULL,
    `is_open`      BIT(1)                                                                                       DEFAULT FALSE,
    `link`         VARCHAR(512)                                                                                 DEFAULT NULL,
    `name`         VARCHAR(255)                                                                                 DEFAULT NULL,
    `phone_number` VARCHAR(25)                                                                                  DEFAULT NULL,
    `type_schools` ENUM ('COLLEGE','ELEMENTARY','HIGH','JUNIOR_COLLEGE','JUNIOR_HIGH','TECHNICAL','UNIVERSITY') DEFAULT NULL,
    `create_at`    TIMESTAMP                                                                                    DEFAULT CURRENT_TIMESTAMP,
    `update_at`    TIMESTAMP                                                                                    DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `user_info_role`

CREATE TABLE `user_info_role`
(
    `user_info_id` BINARY(16) NOT NULL,
    `role_id`      BINARY(16) NOT NULL,
    CONSTRAINT `fk_user_info_id` FOREIGN KEY (`user_info_id`) REFERENCES `user_infos` (`user_info_id`),
    CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `school_classes`

CREATE TABLE `clazzes`
(
    `clazz_id`         BINARY(16) PRIMARY KEY,
    `clazz_name`       VARCHAR(255) NOT NULL,
    `create_at`        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at`        TIMESTAMP DEFAULT NULL,
    `class_teacher_id` BINARY(16)   NOT NULL,
    `school_id`        BINARY(16)   NOT NULL,
    CONSTRAINT `fk_school_id` FOREIGN KEY (`school_id`) REFERENCES `schools` (`school_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `users`
CREATE TABLE `users`
(
    `user_id`      BINARY(16) PRIMARY KEY,
    `first_name`   VARCHAR(255) NOT NULL,
    `last_name`    VARCHAR(255) NOT NULL,
    `age`          INT        DEFAULT 0,
    `email`        VARCHAR(255) UNIQUE,
    `create_at`    TIMESTAMP  DEFAULT CURRENT_TIMESTAMP,
    `update_at`    TIMESTAMP  DEFAULT NULL,
    `clazz_id`     BINARY(16) DEFAULT NULL,
    `user_info_id` BINARY(16)   NOT NULL,
    UNIQUE KEY `UK_65t6bc8nlb8lpnk86aimnl7pd` (`user_info_id`),
    KEY `FKnn16x6b0t9rgy795hsj5h8cry` (`clazz_id`),
    CONSTRAINT `FKnn16x6b0t9rgy795hsj5h8cry` FOREIGN KEY (`clazz_id`) REFERENCES `clazzes` (`clazz_id`),
    CONSTRAINT `FKsgb97rb3a0nnev8y3nvu9unmk` FOREIGN KEY (`user_info_id`) REFERENCES `user_infos` (`user_info_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- Table structure for table `subjects`

CREATE TABLE `subjekts`
(
    `subjekt_id`   BINARY(16) PRIMARY KEY,
    `subjekt_name` ENUM ('HISTORY','MATHEMATICS', 'GEOGRAPHY', 'INFORMATICS', 'LITERATURE') NOT NULL,
    `count_hours`  INT       DEFAULT 0,
    `create_at`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `update_at`    TIMESTAMP DEFAULT NULL

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
    `clazz_id`   binary(16) NOT NULL,
    `subjekt_id` binary(16) NOT NULL,
    `teacher_id` binary(16) NOT NULL

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- Table structure for table `themes`

CREATE TABLE `themes`
(
    `theme_id`   BINARY(16) PRIMARY KEY,
    `theme_name` VARCHAR(255) DEFAULT NULL,
    `create_at`  TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    `update_at`  TIMESTAMP    DEFAULT NULL,
    `subjekt_id` BINARY(16)   DEFAULT NULL,
    CONSTRAINT `FK4tfrjhvv2v7hkaboute0cqkk3` FOREIGN KEY (`subjekt_id`) REFERENCES `subjekts` (`subjekt_id`)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- Table structure for table `school_class_subjects`

CREATE TABLE `clazz_subjekts`
(
    `clazz_id`   BINARY(16) NOT NULL,
    `subjekt_id` BINARY(16) NOT NULL,

    CONSTRAINT `FK57b8ex6ynjpbcjekn3m4pdw96` FOREIGN KEY (`subjekt_id`) REFERENCES `subjekts` (`subjekt_id`),
    CONSTRAINT `FKatjhr0n9o093gl0dkqjk005ux` FOREIGN KEY (`clazz_id`) REFERENCES `clazzes` (`clazz_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


COMMIT;
