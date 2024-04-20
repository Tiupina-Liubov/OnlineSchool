-- Вставка прав доступа в таблицу "authorities"
INSERT INTO authorities (authority_id, authority_name)
VALUES
    (UUID_TO_BIN('67b54d31-5644-4340-bf28-64a952b4c920'), 'READ'),
    (UUID_TO_BIN('3f94a694-a768-49b3-be56-1409e95e09d9'), 'CREATE'),
    (UUID_TO_BIN('8db81e88-b27e-4a8d-83b9-b8ab066fa2ac'), 'UPDATE'),
    (UUID_TO_BIN('d9233466-7c97-4478-81f6-628fcc1438b3'), 'DELETE');


-- Вставка ролей в таблицу "roles"
INSERT INTO roles(role_id,role_name)
VALUES
    (UUID_TO_BIN('6e01b191-453c-4464-998f-a671619e89de'), 'ADMIN'),
    (UUID_TO_BIN('a87cb234-343b-4f87-a739-1ad4b45f1ee3'),'TEACHER'),
    (UUID_TO_BIN('5d9eabf8-084a-46bb-a329-b6db2f68000b'),'STUDENT'),
    (UUID_TO_BIN('9d4788fc-4fd3-4864-a60a-9c080b8a187c'),'DIRECTOR');


-- Вставка данных в таблицу "role_authority". Связывание ролей и прав
INSERT INTO role_authority(role_id,authority_id)
VALUES
    (UUID_TO_BIN('6e01b191-453c-4464-998f-a671619e89de'),UUID_TO_BIN('d9233466-7c97-4478-81f6-628fcc1438b3')),
    (UUID_TO_BIN('6e01b191-453c-4464-998f-a671619e89de'),UUID_TO_BIN('67b54d31-5644-4340-bf28-64a952b4c920')),
    (UUID_TO_BIN('6e01b191-453c-4464-998f-a671619e89de'),UUID_TO_BIN('3f94a694-a768-49b3-be56-1409e95e09d9')),
    (UUID_TO_BIN('6e01b191-453c-4464-998f-a671619e89de'),UUID_TO_BIN('8db81e88-b27e-4a8d-83b9-b8ab066fa2ac')),
    (UUID_TO_BIN('5d9eabf8-084a-46bb-a329-b6db2f68000b'),UUID_TO_BIN('3f94a694-a768-49b3-be56-1409e95e09d9'));


-- Вставка персональных данных в таблицу " user_infos"
INSERT INTO user_infos (user_info_id, username, password, payment_tribute, phone_number, salary)
VALUES
    (UUID_TO_BIN('2dd4c08c-50cd-444b-a75c-4e86001e8bbf'), 'user1', 'password1', '4600906895214405', '+1234567890', 0000.00),
    (UUID_TO_BIN('e2d3ab6d-734d-4140-a399-17b41640e190'), 'user2', 'password2', '377457426914898', '+0987654321', 2500.00),
    (UUID_TO_BIN('a14dc00b-e97f-4ef7-bbb3-bfcbc074a9de'), 'user3', 'password3', '4405355163778666', '+1122334455', 3000.00);


-- Вставка данных в таблицу "user_info_role". Связывание пользователей и ролей
INSERT INTO user_info_role (user_info_id, role_id)
VALUES
    (UUID_TO_BIN('2dd4c08c-50cd-444b-a75c-4e86001e8bbf'), UUID_TO_BIN('5d9eabf8-084a-46bb-a329-b6db2f68000b')),
    (UUID_TO_BIN('e2d3ab6d-734d-4140-a399-17b41640e190'), UUID_TO_BIN('6e01b191-453c-4464-998f-a671619e89de')),
    (UUID_TO_BIN('e2d3ab6d-734d-4140-a399-17b41640e190'), UUID_TO_BIN('a87cb234-343b-4f87-a739-1ad4b45f1ee3')),
    (UUID_TO_BIN('a14dc00b-e97f-4ef7-bbb3-bfcbc074a9de'), UUID_TO_BIN('a87cb234-343b-4f87-a739-1ad4b45f1ee3'));


-- Вставка  данных в таблицу "schools"
INSERT INTO schools (school_id, address,link, name,phone_number, type_schools )
VALUES
    (UUID_TO_BIN('7a4a0dc7-371a-481f-a967-d4455151a4a0'), 'Ukraina, Uman, str. Bogdana Chornomaza 5, 20300','https://www.school11.org.ua','Uman Gymnasium No. 11', '(04744)3-80-69', 'COLLEGE');


-- Вставка  данных в таблицу "classes"
INSERT INTO clazzes (clazz_id, clazz_name, class_teacher_id, school_id)
VALUES
    (UUID_TO_BIN('f653101d-6ffe-436b-83ba-1c59af00248b'),'1-A',UUID_TO_BIN('e2d3ab6d-734d-4140-a399-17b41640e190'),UUID_TO_BIN('7a4a0dc7-371a-481f-a967-d4455151a4a0')),
    (UUID_TO_BIN('fafe2f11-fd4e-4abc-a0dc-b479a453ffaa'),'2-A',UUID_TO_BIN('a14dc00b-e97f-4ef7-bbb3-bfcbc074a9de'),UUID_TO_BIN('7a4a0dc7-371a-481f-a967-d4455151a4a0'));


-- Вставка персональных данных в таблицу "users"
INSERT INTO users (user_id, first_name, last_name, age, email, clazz_id, user_info_id)
VALUES
    (UUID_TO_BIN('d234d99d-170e-42f7-b6ae-435ee56f49b5'), 'Kira', 'Mikiz', 19, 'Kikosin34@gmail.com', UUID_TO_BIN('fafe2f11-fd4e-4abc-a0dc-b479a453ffaa'), UUID_TO_BIN('2dd4c08c-50cd-444b-a75c-4e86001e8bbf')),
    (UUID_TO_BIN('14a59ac9-8681-432b-a770-7893b52b6e6e'), 'Lena', 'Grynik', 25,  'LENA2@meta.ua',NULL, UUID_TO_BIN('e2d3ab6d-734d-4140-a399-17b41640e190')),
    (UUID_TO_BIN('47487a2c-79f1-421b-af53-807678193c0f'), 'Kolya', 'Nastasev', 35, 'Kolya3@example.com',NULL ,  UUID_TO_BIN('a14dc00b-e97f-4ef7-bbb3-bfcbc074a9de'));


-- Заполнение данными  таблицу "subjects"
INSERT INTO subjekts (subjekt_id, subjekt_name, count_hours)
VALUES
    (UUID_TO_BIN('35ab0c0a-45b8-419a-af3b-5f9b8dd66422'), 'HISTORY', 120),
    (UUID_TO_BIN('9701dc02-5ee5-47ae-852a-ddc95828d15d'), 'MATHEMATICS', 150),
    (UUID_TO_BIN('4a304e6a-106a-43a1-8f2a-b0d034b0b200'), 'GEOGRAPHY', 100),
    (UUID_TO_BIN('6ab9bc05-ab00-4be9-872f-83adb630208c'), 'INFORMATICS', 135);


-- Заполнение данными  таблицу "lessons"
INSERT INTO lessons (lesson_id,time,clazz_id,subjekt_id,teacher_id)
VALUES
    (UUID_TO_BIN('6ff0717f-2c96-46de-9ef7-f2bc2c5e9dc0'), '11:00:00',UUID_TO_BIN('f653101d-6ffe-436b-83ba-1c59af00248b'),UUID_TO_BIN('35ab0c0a-45b8-419a-af3b-5f9b8dd66422'),UUID_TO_BIN('14a59ac9-8681-432b-a770-7893b52b6e6e')),
    (UUID_TO_BIN('14b159e2-77d0-4ddd-8c92-0eb02c48ba26'), '12:30:00',UUID_TO_BIN('f653101d-6ffe-436b-83ba-1c59af00248b'),UUID_TO_BIN('4a304e6a-106a-43a1-8f2a-b0d034b0b200'),UUID_TO_BIN('1c55c2f9-3ede-4985-908f-de38ed7f7cd3'));


-- Вставка  данных в таблицу "themes"
INSERT INTO themes (theme_id, theme_name, subjekt_id)
VALUES
    (UUID_TO_BIN('e6403182-8ee8-4efd-a6eb-3c94bd512298'), 'Collection', UUID_TO_BIN('6ab9bc05-ab00-4be9-872f-83adb630208c')),
    (UUID_TO_BIN('1f01f77a-9d8e-4ff0-bf52-94b68e88d191'), 'Collection. List and ArryaList', UUID_TO_BIN('6ab9bc05-ab00-4be9-872f-83adb630208c')),
    (UUID_TO_BIN('2f6ed67f-d2f8-4291-ba69-b902b412c369'), 'Ocean', UUID_TO_BIN('4a304e6a-106a-43a1-8f2a-b0d034b0b200'));

-- Вставка данных в таблицу "class_subjects". Связывание класса и предмета
INSERT INTO clazz_subjekts (clazz_id,subjekt_id)
VALUES
    (UUID_TO_BIN('f653101d-6ffe-436b-83ba-1c59af00248b'),UUID_TO_BIN('4a304e6a-106a-43a1-8f2a-b0d034b0b200')),
    (UUID_TO_BIN('fafe2f11-fd4e-4abc-a0dc-b479a453ffaa'),UUID_TO_BIN('6ab9bc05-ab00-4be9-872f-83adb630208c'));
