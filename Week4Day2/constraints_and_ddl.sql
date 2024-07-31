-- Constraint: Rule enforced on a column in a table to limit 
-- the type or length of data that can go into the table
-- Can be added when the table is created or after

-- NOT NULL: A column cannot have a NULL value
-- DEFAULT: (^ usually in combo with NOT NULL) Sets the default
-- value for a column when no value is specified/provided
-- UNIQUE: Ensures that all values in a column are different
-- PRIMARY KEY: (NOT NULL + UNIQUE) uniquely identifies each row in a table
-- FOREIGN KEY: Column in one table that references a column in another table
-- CHECK: Ensure that all values in a column satisfy a specific condition
-- CHECK (Age >= 15), INSERT VALUE (AGE=14) Fails

-- DML (Data Manipulation Language) INSERT, UPDATE, DELETE
-- DDL (Data Definition Language) CREATE, DROP, ALTER
-- DQL (Data Query Language) SELECT
-- DCL (Data Control Language) GRANT, REVOKE

-- Column Types
-- INT (integer)
-- TEXT fixed 
-- VARCHAR (restricted to 8-bit codepage) requires length (255) max size 65535 bytes
-- NVARCHAR (allows any unicode characters) requires length max size 65535 bytes

-- DROP TABLE employee;
-- DROP TABLE department;
/*
CREATE TABLE department (
	dept_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE,
    PRIMARY KEY (dept_id)
);

CREATE TABLE employee (
	emp_id INT NOT NULL AUTO_INCREMENT,
    last_name VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    age INT CHECK(age >= 18),
    dept_id INT,
    PRIMARY KEY (emp_id),
    UNIQUE(last_name, first_name),
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);

INSERT INTO department (name) VALUES ('Finance');
INSERT INTO department (name) VALUES ('Operations');
INSERT INTO department (name) VALUES ('IT');
INSERT INTO department (name) VALUES ('Accounting');
INSERT INTO department (name) VALUES ('Marketing');
INSERT INTO department (name) VALUES ('Sales');
INSERT INTO department (name) VALUES ('Human Resources');
INSERT INTO department (name) VALUES ('Software Development');

SELECT * FROM department 
ORDER BY dept_id;

SELECT * FROM employee;


SET @sdev = (SELECT dept_id FROM department WHERE name = 'Software Development');
SET @hr = (SELECT dept_id FROM department WHERE name = 'Human Resources');
SET @acct = (SELECT dept_id FROM department WHERE name = 'Accounting');
SET @it = (SELECT dept_id FROM department WHERE name = 'IT');

-- INSERT INTO employee (last_name, first_name, age, dept_id) VALUES ('Clossman', 'Seth', 36, @sdev);
INSERT INTO employee (last_name, first_name, age, dept_id) VALUES ('Dylan', 'Bob', 83, @hr);
INSERT INTO employee (last_name, first_name, age, dept_id) VALUES ('Hankins', 'Reginald', 23, @sdev);
INSERT INTO employee (last_name, first_name, age, dept_id) VALUES ('Blakeman', 'Dan', 39, @acct);
INSERT INTO employee (last_name, first_name, age, dept_id) VALUES ('Conaway', 'Willie', 46, @it);
INSERT INTO employee (last_name, first_name, age, dept_id) VALUES ('James', 'Calvin', 47, @hr);
*/
/*
SELECT 
	emp_id,
    last_name,
    first_name,
    age,
    d.name as 'department'
    FROM employee e
LEFT JOIN department d
ON d.dept_id = e.dept_id;
*/
-- Index: database object that improves the speed of data retrieval operations on a table
-- at the cost of additional writes and storage space

-- SELECT last_name from employee WHERE last_name LIKE 'Clo%';

-- CREATE INDEX idx_lastname ON employee (last_name);

-- Normalization: process of organizing fields and tables (entities and attributes) of a
-- relational database to minimize redundancy and dependency.  Ideally we want to 
-- separate data into different tables to improve data integrity.

-- CREATE TABLE `order` (
-- 	order_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
--     order_date TIMESTAMP,
--     customer_name VARCHAR(255),
--     items VARCHAR(255)
-- );

-- INSERT INTO drivenowdb.`order` (order_date, customer_name, items) VALUES (NOW(), 'Sean Carter', 'apples, oranges, bananas');
-- INSERT INTO drivenowdb.`order` (order_date, customer_name, items) VALUES (NOW(), 'Sean Carter', 'apples, oranges');
-- INSERT INTO drivenowdb.`order` (order_date, customer_name, items) VALUES (NOW(), 'Seth Clossman', 'apples, oranges');
-- INSERT INTO drivenowdb.`order` (order_date, customer_name, items) VALUES (NOW(), 'Erica Hicks', 'apples, oranges, bananas');


-- SELECT * FROM drivenowdb.order;

-- 1st Normal Form: the table contains atomic (indivisible) values [has a primary key], and each column contains values
-- of a single type/non-repeating [doesn't contain multiple values]

-- CREATE TABLE order_1nf (
-- 	order_id INT NOT NULL,
--     line_id INT NOT NULL,
--     order_date DATE,
--     customer_name VARCHAR(255),
--     item VARCHAR(255),
--     PRIMARY KEY (order_id, line_id)
-- );

-- INSERT INTO drivenowdb.order_1nf (order_id, line_id, order_date, customer_name, item) VALUES (1, 1, '2024-07-29', 'Sean Carter', 'apples');
-- INSERT INTO drivenowdb.order_1nf (order_id, line_id, order_date, customer_name, item) VALUES (1, 2, '2024-07-29', 'Sean Carter', 'oranges');
-- INSERT INTO drivenowdb.order_1nf (order_id, line_id, order_date, customer_name, item) VALUES (1, 3, '2024-07-29', 'Sean Carter', 'bananas');
-- INSERT INTO drivenowdb.order_1nf (order_id, line_id, order_date, customer_name, item) VALUES (2, 1, '2024-07-30', 'Sean Carter', 'apples');
-- INSERT INTO drivenowdb.order_1nf (order_id, line_id, order_date, customer_name, item) VALUES (2, 2, '2024-07-30', 'Sean Carter', 'oranges');
-- INSERT INTO drivenowdb.order_1nf (order_id, line_id, order_date, customer_name, item) VALUES (3, 1, '2024-07-18', 'Seth Clossman', 'apples');
-- INSERT INTO drivenowdb.order_1nf (order_id, line_id, order_date, customer_name, item) VALUES (3, 2, '2024-07-18', 'Seth Clossman', 'oranges');
-- INSERT INTO drivenowdb.order_1nf (order_id, line_id, order_date, customer_name, item) VALUES (4, 1, '2024-07-25', 'Erica Hicks', 'apples');
-- INSERT INTO drivenowdb.order_1nf (order_id, line_id, order_date, customer_name, item) VALUES (4, 2, '2024-07-25', 'Erica Hicks', 'oranges');
-- INSERT INTO drivenowdb.order_1nf (order_id, line_id, order_date, customer_name, item) VALUES (4, 3, '2024-07-25', 'Erica Hicks', 'bananas');

-- SELECT * FROM order_1nf

-- 2nd Normal Form: Requires that the table is in 1NF and all non-key attributes are fully
-- functionally dependent on the primary key

-- CREATE TABLE order_2nf (
-- 	order_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
--     order_date DATE,
--     customer_name VARCHAR(255)
-- );

-- CREATE TABLE order_item (
-- 	line_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
--     item VARCHAR(255),
--     order_id INT NOT NULL,
--     FOREIGN KEY (order_id) REFERENCES order_2nf(order_id)
-- );

-- INSERT INTO order_2nf (order_date, customer_name) VALUES ('2024-07-25', 'Erica Hicks');
-- INSERT INTO order_2nf (order_date, customer_name) VALUES ('2024-07-18', 'Seth Clossman');
-- INSERT INTO order_2nf (order_date, customer_name) VALUES ('2024-07-30', 'Sean Carter');
-- INSERT INTO order_2nf (order_date, customer_name) VALUES ('2024-07-29', 'Sean Carter');

-- SELECT * FROM  order_2nf;
-- SELECT * FROM  order_item;

-- INSERT INTO order_item (item, order_id) VALUES ('apples', 1);
-- INSERT INTO order_item (item, order_id) VALUES ('oranges', 1);
-- INSERT INTO order_item (item, order_id) VALUES ('bananas', 1);
-- INSERT INTO order_item (item, order_id) VALUES ('apples', 2);
-- INSERT INTO order_item (item, order_id) VALUES ('oranges', 2);
-- INSERT INTO order_item (item, order_id) VALUES ('apples', 3);
-- INSERT INTO order_item (item, order_id) VALUES ('oranges', 3);
-- INSERT INTO order_item (item, order_id) VALUES ('apples', 4);
-- INSERT INTO order_item (item, order_id) VALUES ('oranges', 4);
-- INSERT INTO order_item (item, order_id) VALUES ('bananas', 4);

-- SELECT * FROM  order_2nf;
-- SELECT * FROM  order_item;

-- 3rd Normal Form: 1NF & 2NF achieved, and no transitive dependencies


SELECT * FROM  order_2nf;
SELECT * FROM  order_item;

-- CREATE TABLE inventory (
-- 	item_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
--     name VARCHAR(255) NOT NULL,
--     price DOUBLE NOT NULL DEFAULT 0.00,
--     price_metric VARCHAR(255) NOT NULL DEFAULT 'lbs'
-- );

-- INSERT INTO inventory (name, price, price_metric) VALUES ('apples', 2.99, 'lbs');
-- INSERT INTO inventory (name, price, price_metric) VALUES ('oranges',1.99,'lbs');
-- INSERT INTO inventory (name, price, price_metric) VALUES ('bananas',0.19,'each');

SELECT * FROM inventory;

-- CREATE TABLE order_items_3nf (
-- 	line_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
--     order_id INT NOT NULL,
--     item_id INT NOT NULL,
--     FOREIGN KEY (order_id) REFERENCES order_2nf(order_id),
--     FOREIGN KEY (item_id) REFERENCES inventory(item_id)
-- );

-- SELECT o.line_id, i.item_id, o.order_id FROM drivenowdb.order_item o
-- LEFT JOIN drivenowdb.inventory i
-- ON o.item = i.name;

-- INSERT INTO order_items_3nf (item_id, order_id) VALUES (1,1);
-- INSERT INTO order_items_3nf (item_id, order_id) VALUES (2,1);
-- INSERT INTO order_items_3nf (item_id, order_id) VALUES (3,1);
-- INSERT INTO order_items_3nf (item_id, order_id) VALUES (1,2);
-- INSERT INTO order_items_3nf (item_id, order_id) VALUES (2,2);
-- INSERT INTO order_items_3nf (item_id, order_id) VALUES (1,3);
-- INSERT INTO order_items_3nf (item_id, order_id) VALUES (2,3);
-- INSERT INTO order_items_3nf (item_id, order_id) VALUES (1,4);
-- INSERT INTO order_items_3nf (item_id, order_id) VALUES (2,4);
-- INSERT INTO order_items_3nf (item_id, order_id) VALUES (3,4);
-- Each non-key column should depend on 
-- "The key, the whole key, and nothing but the key so help me Codd"

SELECT line_id, item_id, order_id FROM order_items_3nf;
SELECT * FROM order_2nf;
SELECT * FROM INVENTORY;

-- What is BCNF?  (Boyce-Codd Normal Form)