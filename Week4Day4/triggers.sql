/**
*
* Triggers: a database object that is automatically executed
* or fired when a certain event occurs. Can usually be setup 
* to run before or after an INSERT, UPDATE, or DELETE operation.
*
**/
-- Test log after insert trigger
INSERT INTO `drivenowdb`.`employee` (`last_name`,`first_name`,`age`,`dept_id`,`salary`,`manager_id`)
VALUES ('Clossman', 'James', 18, 8, 120000.00, 1);

-- Test log after update trigger
SELECT * FROM employee WHERE dept_id = 8;

UPDATE employee 
SET age = 21, first_name= 'Charlotte', salary=150000.00
WHERE emp_id = 990;

DELETE FROM employee WHERE emp_id=991;
SELECT * FROM employee WHERE dept_id = 8;
SELECT * FROM employee_log;
INSERT INTO employee (first_name, last_name, age, dept_id, salary, manager_id) 
VALUES ('Charlotte', 'Clossman', 21, 8, 150000.00, 1);