-- Вставка прав доступа в таблицу "authorities"
INSERT INTO authorities (authority_id, authority_name)
VALUES (CAST('67b54d31-5644-4340-bf28-64a952b4c920' as binary(16)), 'READ'),
       (CAST('3f94a694-a768-49b3-be56-1409e95e09d9' as binary(16)), 'CREATE'),
       (CAST('8db81e88-b27e-4a8d-83b9-b8ab066fa2ac' as binary(16)), 'UPDATE'),
       (CAST('d9233466-7c97-4478-81f6-628fcc1438b3' as binary(16)), 'DELETE');


-- Вставка ролей в таблицу "roles"
INSERT INTO roles(role_id, role_name)
VALUES (CAST('6e01b191-453c-4464-998f-a671619e89de' as binary(16)), 'ROLE_ADMIN'),
       (CAST('a87cb234-343b-4f87-a739-1ad4b45f1ee3' as binary(16)), 'ROLE_TEACHER'),
       (CAST('5d9eabf8-084a-46bb-a329-b6db2f68000b' as binary(16)), 'ROLE_STUDENT'),
       (CAST('c89a7f93-6f32-400e-847c-c229a3971579' as binary(16)), 'ROLE_USER'),
       (CAST('9d4788fc-4fd3-4864-a60a-9c080b8a187c' as binary(16)), 'ROLE_DIRECTOR');


-- Вставка данных в таблицу "role_authority". Связывание ролей и прав
INSERT INTO role_authorities(role_id, authority_id)
VALUES (CAST('6e01b191-453c-4464-998f-a671619e89de' as binary(16)),
        CAST('d9233466-7c97-4478-81f6-628fcc1438b3' as binary(16))),
       (CAST('c89a7f93-6f32-400e-847c-c229a3971579' as binary(16)),
        CAST('67b54d31-5644-4340-bf28-64a952b4c920' as binary(16))),
       (CAST('6e01b191-453c-4464-998f-a671619e89de' as binary(16)),
        CAST('3f94a694-a768-49b3-be56-1409e95e09d9' as binary(16))),
       (CAST('6e01b191-453c-4464-998f-a671619e89de' as binary(16)),
        CAST('8db81e88-b27e-4a8d-83b9-b8ab066fa2ac' as binary(16))),
       (CAST('5d9eabf8-084a-46bb-a329-b6db2f68000b' as binary(16)),
        CAST('3f94a694-a768-49b3-be56-1409e95e09d9' as binary(16)));


-- Вставка персональных данных в таблицу " user_infos"
INSERT INTO user_infos (user_info_id, username, password, email, payment_tribute, phone_number, salary)
VALUES (CAST('2dd4c08c-50cd-444b-a75c-4e86001e8bbf' as binary(16)), 'user1', '$2a$10$5GOSARIOZ23c04ORlvXSrODJj/v9tsk63HfMhS.3/r5Rfpq/3Xm8G', 'Kikosin34@gmail.com',
        '4600906895214405', '+1234567890', 0000.00),
       (CAST('e2d3ab6d-734d-4140-a399-17b41640e190' as binary(16)), 'user2', '$2a$10$lfRhINsfChs9Fpe/B1.dXOphzztYWMdiYlIia23sipcmJv5F60rqy', 'LENA2@meta.ua',
        '377457426914898', '+0987654321', 2500.00),
       (CAST('a14dc00b-e97f-4ef7-bbb3-bfcbc074a9de' as binary(16)), 'user3', '$2a$10$D1..3IlaaPoZgd36XVPyz.N8z0NGs3VEyFrWu0Kor.XqQQCkJ3BiC', 'Kolya3@example.com',
        '4405355163778666', '+1122334455', 3000.00);


-- Вставка данных в таблицу "user_info_role". Связывание пользователей и ролей
INSERT INTO user_info_role (user_info_id, role_id)
VALUES (CAST('2dd4c08c-50cd-444b-a75c-4e86001e8bbf' as binary(16)),
        CAST('5d9eabf8-084a-46bb-a329-b6db2f68000b' as binary(16))),
       (CAST('e2d3ab6d-734d-4140-a399-17b41640e190' as binary(16)),
        CAST('6e01b191-453c-4464-998f-a671619e89de' as binary(16))),
       (CAST('e2d3ab6d-734d-4140-a399-17b41640e190' as binary(16)),
        CAST('a87cb234-343b-4f87-a739-1ad4b45f1ee3' as binary(16))),
       (CAST('a14dc00b-e97f-4ef7-bbb3-bfcbc074a9de' as binary(16)),
        CAST('a87cb234-343b-4f87-a739-1ad4b45f1ee3' as binary(16)));


-- Вставка  данных в таблицу "schools"
INSERT INTO schools (school_id, address, is_open, link, name, phone_number, type_schools)
VALUES (CAST('7a4a0dc7-371a-481f-a967-d4455151a4a0' as binary(16)),
        'Ukraina, Uman, str. Bogdana Chornomaza 5, 20300',false, 'https://www.school11.org.ua', 'Uman Gymnasium No. 11',
        '(04744)3-80-69', 'COLLEGE');


-- Вставка  данных в таблицу "classes"
INSERT INTO classes (class_id, class_name, class_teacher_id, school_id)
VALUES (CAST('f653101d-6ffe-436b-83ba-1c59af00248b' as binary (16)), '1-A',
        CAST('e2d3ab6d-734d-4140-a399-17b41640e190' as binary (16)),
        CAST('7a4a0dc7-371a-481f-a967-d4455151a4a0' as binary (16))),
       (CAST('fafe2f11-fd4e-4abc-a0dc-b479a453ffaa' as binary (16)), '2-A',
        CAST('a14dc00b-e97f-4ef7-bbb3-bfcbc074a9de' as binary (16)),
        CAST('7a4a0dc7-371a-481f-a967-d4455151a4a0' as binary (16)));


-- Вставка персональных данных в таблицу "users"
INSERT INTO users (user_id, first_name, last_name, birthday, class_id, user_info_id)
VALUES (CAST('d234d99d-170e-42f7-b6ae-435ee56f49b5' as binary (16)), 'Kira', 'Mikiz', '1993-10-25',
        CAST('fafe2f11-fd4e-4abc-a0dc-b479a453ffaa' as binary (16)),
        CAST('2dd4c08c-50cd-444b-a75c-4e86001e8bbf' as binary (16))),
       (CAST('14a59ac9-8681-432b-a770-7893b52b6e6e' as binary (16)), 'Lena', 'Grynik', '1993-01-05', NULL,
        CAST('e2d3ab6d-734d-4140-a399-17b41640e190' as binary (16))),
       (CAST('47487a2c-79f1-421b-af53-807678193c0f' as binary (16)), 'Kolya', 'Nastasev', '1993-04-02', NULL,
        CAST('a14dc00b-e97f-4ef7-bbb3-bfcbc074a9de' as binary (16)));

-- Заполнение данными  таблицу "subjects"
INSERT INTO subjekts (subjekt_id, subjekt_name, count_hours)
VALUES (CAST('35ab0c0a-45b8-419a-af3b-5f9b8dd66422' as binary (16)), 'HISTORY', 120),
       (CAST('9701dc02-5ee5-47ae-852a-ddc95828d15d' as binary (16)), 'MATHEMATICS', 150),
       (CAST('4a304e6a-106a-43a1-8f2a-b0d034b0b200' as binary (16)), 'GEOGRAPHY', 100),
       (CAST('6ab9bc05-ab00-4be9-872f-83adb630208c' as binary (16)), 'INFORMATICS', 135);


-- Заполнение данными  таблицу "lessons"
INSERT INTO lessons (lesson_id, time, class_id, subjekt_id, teacher_id)
VALUES (CAST('6ff0717f-2c96-46de-9ef7-f2bc2c5e9dc0' as binary (16)), '11:00:00',
        CAST('f653101d-6ffe-436b-83ba-1c59af00248b' as binary (16)),
        CAST('35ab0c0a-45b8-419a-af3b-5f9b8dd66422' as binary (16)),
        CAST('14a59ac9-8681-432b-a770-7893b52b6e6e' as binary (16))),
       (CAST('14b159e2-77d0-4ddd-8c92-0eb02c48ba26' as binary (16)), '12:30:00',
        CAST('f653101d-6ffe-436b-83ba-1c59af00248b' as binary (16)),
        CAST('4a304e6a-106a-43a1-8f2a-b0d034b0b200' as binary (16)),
        CAST('1c55c2f9-3ede-4985-908f-de38ed7f7cd3' as binary (16)));


-- Вставка  данных в таблицу "themes"
INSERT INTO themes (theme_id, theme_name, subjekt_id)
VALUES (CAST('e6403182-8ee8-4efd-a6eb-3c94bd512298' as binary (16)), 'Collection',
        CAST('6ab9bc05-ab00-4be9-872f-83adb630208c' as binary (16))),
       (CAST('1f01f77a-9d8e-4ff0-bf52-94b68e88d191' as binary (16)), 'Collection. List and ArryaList',
        CAST('6ab9bc05-ab00-4be9-872f-83adb630208c' as binary (16))),
       (CAST('2f6ed67f-d2f8-4291-ba69-b902b412c369' as binary (16)), 'Ocean',
        CAST('4a304e6a-106a-43a1-8f2a-b0d034b0b200' as binary (16)));

-- Вставка данных в таблицу "class_subjects". Связывание класса и предмета
INSERT INTO class_subjekts (class_id, subjekt_id)
VALUES (CAST('f653101d-6ffe-436b-83ba-1c59af00248b' as binary (16)),
        CAST('4a304e6a-106a-43a1-8f2a-b0d034b0b200' as binary (16))),
       (CAST('fafe2f11-fd4e-4abc-a0dc-b479a453ffaa' as binary (16)),
        CAST('6ab9bc05-ab00-4be9-872f-83adb630208c' as binary (16)));
