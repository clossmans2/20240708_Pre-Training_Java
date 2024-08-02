DELIMITER //
CREATE TRIGGER  log_after_employee_insert
-- Time: BEFORE or AFTER
AFTER
-- Event: INSERT or UPDATE or DELETE
INSERT
-- Table name to bind the trigger to
ON employee FOR EACH ROW
BEGIN
	INSERT INTO `drivenowdb`.`employee_log`
	(`action`,
	`data`,
	`current_user`,
	`action_date`)
	VALUES
	('INSERT',
	CONCAT('{ emp_id=', NEW.emp_id,
			', last_name=', NEW.last_name,
            ', first_name=', NEW.first_name,
            ', age=', NEW.age,
            ', dept_id=', NEW.dept_id,
            ', salary=', NEW.salary,
            ', manager_id=', NEW.manager_id, ' }'),
	CURRENT_USER,
	CURRENT_TIMESTAMP);
END //

DELIMITER ;