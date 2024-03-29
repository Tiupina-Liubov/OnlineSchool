# Online School[Backend]

There is a prototype data of the main services BackEnd online school.
The data consists of users, school classes, subjects, lessons, themes.

### Class Diagram BankApplication


### Sequence Diagram Account

### Database Diagram


___
## Database Structure

### Table user (users table)

| Column name | Type        | Description                                   |
|-------------|-------------|-----------------------------------------------|
| id          | binary(16)  | id key of row - unique, not null, primary key | 
| first_name  | varchar(50) | users name                                    | 
| last_name   | varchar(50) | users  surname                                |
| age         | int         | users age                                     |
| class_id    | binary(16)  | id key of row - unique, not null, primary key |
| class_id    | binary(16)  | id key of row - unique, not null, primary key |
| created_at  | timestamp   | timestamp of row creation                     |
| updated_at  | timestamp   | timestamp of last update                      | 
