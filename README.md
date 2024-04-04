# Online School[Backend]

There is a prototype data of the main services BackEnd online school.
The data consists of users, user info, school classes, subjects, lessons, themes.

### Class Diagram BankApplication


### Sequence Diagram Account

### Database Diagram


___
## Database Structure

### Table user (users table)

| Column name   | Type         | Description                                   |
|---------------|--------------|-----------------------------------------------|
| user_id       | binary(16)   | id key of row - unique, not null, primary key | 
| first_name    | varchar(255) | users name                                    | 
| last_name     | varchar(255) | users  surname                                |
| age           | int          | users age                                     |
| class_id      | binary(16)   | id key of row - unique, not null, primary key |
| user_info_id  | binary(16)   | id key of row - unique, not null, primary key |
| created_at    | timestamp    | timestamp of row creation                     |
| updated_at    | timestamp    | timestamp of last update                      | 


### Table user info ( user infos table )
| Column name     | Type          | Description                                      |
|-----------------|---------------|--------------------------------------------------|
| user_info_id    | binary(16)    | id key of entity - unique, not null, primary key |
| username        | varchar(255)  |                                                  |
| email           | varchar(255)  | user email                                       |
| password        | varchar(255)  | user password                                    |
| payment_tribute | varchar(255)  |                                                  |
| phone_number    | varchar(255)  | user phone number                                |
| salary          | decimal(38,2) |                                                  |
| created_at      | timestamp     | timestamp of row creation                        |
| updated_at      | timestamp     | timestamp of last update                         |