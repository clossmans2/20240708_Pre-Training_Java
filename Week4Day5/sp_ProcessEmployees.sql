/**
*
* Cursor: a database object that allow row-by-row processing of
*  a result set obtained through a query.
*
**/

DELIMITER //

CREATE PROCEDURE ProcessEmployees()
BEGIN
	DECLARE done INT DEFAULT 0;
    DECLARE empId INT;
    DECLARE empSalary DECIMAL(10,2);
    DECLARE empCursor CURSOR FOR SELECT emp_id, salary FROM employee;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    
    OPEN empCursor;
    
    read_loop: LOOP
		FETCH empCursor INTO empId, empSalary;
        IF done THEN
			LEAVE read_loop;
		END IF;
        -- Process each employee (print out each employee id and salary)
        SELECT empId, empSalary;
	END LOOP;
    
    CLOSE empCursor;
END //

DELIMITER ;