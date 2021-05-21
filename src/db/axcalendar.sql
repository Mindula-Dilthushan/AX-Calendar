DROP DATABASE axcalendar;
CREATE DATABASE axcalendar;
USE axcalendar;

CREATE TABLE login(
    username varchar (10),
    password varchar (10)
);

CREATE TABLE birthday(
    firstName  varchar (40),
    lastName varchar (40),
    birthday varchar (40)
);
SELECT * FROM login;
SELECT * FROM birthday;
