CREATE PROCEDURE GetSubordinates (
	IN EmpId INT
)
BEGIN
	-- Common Table Expression
    -- RECURSIVE: allowing inside the table expression to reference itself
	WITH RECURSIVE EmployeeCTE AS (
		SELECT emp_id, first_name, last_name, manager_id
        FROM employee
        WHERE emp_id = EmpId
        -- Combine the results from the initial query to get the manager
        -- With the recursive query to get subordinates of that manager
        UNION ALL
        SELECT e.emp_id, e.first_name, e.last_name, e.manager_id
        FROM employee e
        INNER JOIN EmployeeCTE cte ON e.manager_id = cte.emp_id        
    )
    SELECT * FROM EmployeeCTE;
END
