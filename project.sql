CREATE DATABASE customer;
use customer;
CREATE TABLE customer(
id INT NOT NULL UNIQUE AUTO_INCREMENT,
firstname VARCHAR(200) NOT NULL,
age INT NOT NULL,
lastname VARCHAR(200) NOT NULL,

PRIMARY KEY(id));

DESCRIBE customer;
SELECT * FROM customer;

INSERT INTO customer(firstname, age, lastname) VALUES("James",25,"Morgan");