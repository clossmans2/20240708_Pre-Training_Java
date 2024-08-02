DELIMITER //

CREATE TRIGGER  log_after_employee_delete
-- Time: BEFORE or AFTER
AFTER
-- Event: INSERT or UPDATE or DELETE
DELETE
-- Table name to bind the trigger to
ON employee FOR EACH ROW
BEGIN
	INSERT INTO `drivenowdb`.`employee_log`
	(`action`,
	`data`,
	`current_user`,
	`action_date`)
	VALUES
	('DELETE',
	CONCAT('INSERT INTO employee (first_name, last_name, age, dept_id, salary, manager_id) VALUES (', 
			'''', OLD.first_name, ''', ', 
            '''', OLD.last_name, ''', ',            
            OLD.age,', ',
            OLD.dept_id,', ',
            OLD.salary,', ',
            OLD.manager_id,');'),
	CURRENT_USER,
	CURRENT_TIMESTAMP);
END //

DELIMITER ;