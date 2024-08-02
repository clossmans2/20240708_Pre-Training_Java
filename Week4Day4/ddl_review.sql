/**
* Statements - Anything in SQL not in DQL
* DDL - CREATE, ALTER, DROP, TRUNCATE
* CREATE -> Creates a database object (table, sproc, udf, trigger, etc)
* ALTER -> Changing database objects 
* DROP -> Deletes database objects
* TRUNCATE -> Removes all the rows from a table without deleting the table
**/
-- TRUNCATE TABLE employee;
-- SELECT * FROM employee;

-- INSERT INTO employee (last_name, first_name, age, dept_id) VALUES ('Clossman', 'Seth' ,36,8);
-- INSERT INTO employee (last_name, first_name, age, dept_id) VALUES ('Dylan', 'Bob' ,83,7);
-- INSERT INTO employee (last_name, first_name, age, dept_id) VALUES ('Hankins', 'Reginald' ,23,8);
-- INSERT INTO employee (last_name, first_name, age, dept_id) VALUES ('Blakeman', 'Dan' ,39,4);
-- INSERT INTO employee (last_name, first_name, age, dept_id) VALUES ('Conaway', 'Willie' ,46,3);
-- INSERT INTO employee (last_name, first_name, age, dept_id) VALUES ('James', 'Calvin' ,47,7);

-- Used new_employees.sql

-- SELECT * FROM employee;

-- ALTER TABLE employee
-- 	ADD COLUMN salary DECIMAL(10,2);
-- SDev Salary
-- UPDATE employee
-- SET salary = 120000.00
-- WHERE dept_id = 8;
-- -- HR Salary
-- UPDATE employee
-- SET salary = 84000.00
-- WHERE dept_id = 7;
-- -- Sales Salary
-- UPDATE employee
-- SET salary = 50000.00
-- WHERE dept_id = 6;
-- -- Marketing Salary
-- UPDATE employee
-- SET salary = 70000.00
-- WHERE dept_id = 5;
-- -- Accounting Salary
-- UPDATE employee
-- SET salary = 95000.00
-- WHERE dept_id = 4;
-- -- IT Salary
-- UPDATE employee
-- SET salary = 120000.00
-- WHERE dept_id = 3;
-- -- Operations Salary
-- UPDATE employee
-- SET salary = 70000.00
-- WHERE dept_id = 2;
-- -- Financy Salary
-- UPDATE employee
-- SET salary = 110000.00
-- WHERE dept_id = 1;

SELECT * FROM employee;

SELECT SUM(salary) as fixed_costs FROM employee;
-- '84,083,000.00'

-- 
CREATE TABLE IF NOT EXISTS `employee`  (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `age` int DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `last_name` (`last_name`,`first_name`),
  KEY `dept_id` (`dept_id`),
  KEY `idx_lastname` (`last_name`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`),
  CONSTRAINT `employee_chk_1` CHECK ((`age` >= 18))
) ENGINE=InnoDB AUTO_INCREMENT=990 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `employee`;