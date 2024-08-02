DELIMITER //
CREATE TRIGGER  log_after_employee_update
-- Time: BEFORE or AFTER
AFTER
-- Event: INSERT or UPDATE or DELETE
UPDATE
-- Table name to bind the trigger to
ON employee FOR EACH ROW
BEGIN
	SET @changes = '{ ';
	IF OLD.last_name != NEW.last_name
		THEN SET @changes = CONCAT(@changes, 'last_name=', OLD.last_name, '->', NEW.last_name, ', ');
	END IF;
	IF OLD.first_name != NEW.first_name
		THEN SET @changes = CONCAT(@changes,'first_name=', OLD.first_name, '->', NEW.first_name, ', ');
	END IF;
    IF OLD.age != NEW.age
		THEN SET @changes = CONCAT(@changes,'age=', OLD.age, '->', NEW.age, ', ');
	END IF;
    IF OLD.dept_id != NEW.dept_id
		THEN SET @changes = CONCAT(@changes,'dept_id=', OLD.dept_id, '->', NEW.dept_id, ', ');
	END IF;
    IF OLD.salary != NEW.salary
		THEN SET @changes = CONCAT(@changes,'salary=', OLD.salary, '->', NEW.salary, ', ');
	END IF;
        IF OLD.manager_id != NEW.manager_id
		THEN SET @changes = CONCAT(@changes,'manager_id=', OLD.manager_id, '->', NEW.manager_id, ', ');
	END IF;
    
    SET @changes = CONCAT(@changes, ' }');
    
	INSERT INTO `drivenowdb`.`employee_log`
	(`action`,
	`data`,
	`current_user`,
	`action_date`)
	VALUES
	('UPDATE',
	@changes,
	CURRENT_USER,
	CURRENT_TIMESTAMP);
END //

DELIMITER ;