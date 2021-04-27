DROP DATABASE axcalendar;
CREATE DATABASE axcalendar;
USE axcalendar;

CREATE TABLE login(
    username varchar (10),
    password varchar (10)
);

INSERT INTO login VALUES ('mindula','1023');

SELECT * FROM login;