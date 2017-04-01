CREATE TABLE IF NOT EXISTS person (
 id BIGINT auto_increment primary key,
 first_name varchar(50) NOT NULL,
 last_name varchar(50) NOT NULL,
 telephone varchar(15),
 PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS car (
 id BIGINT auto_increment primary key,
 model varchar(50) NOT NULL,
 color varchar(50) NOT NULL,
 person_id int,
 PRIMARY KEY (id),
 FOREIGN KEY (person_id) REFERENCES person(id));

