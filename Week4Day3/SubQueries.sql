/**
* Sub-Query: a query nested inside another query
* - Locations -- SELECT, FROM, WHERE, HAVING
* - Returns -- Scalar, Table, Row, Column
**/
-- Subquery in the WHERE statement
SELECT first_name, last_name, email FROM sakila.customer
WHERE store_id = (
	-- Give me the store id of the returned address_id
	SELECT store_id
    FROM sakila.store
    -- Subquery in the Subquery WHERE statement
    WHERE address_id = (
		-- Give me the address_id of 28 MySQL Boulevard
		SELECT address_id
        FROM sakila.address
        WHERE address = '28 MySQL Boulevard'
	)
)
ORDER BY last_name;

-- SELECT statement SubQuery
-- Nearly identical result to LEFT JOIN
SELECT 
	emp_id, 
    first_name,
    last_name,
    age,
    (SELECT name FROM drivenowdb.department WHERE employee.dept_id = department.dept_id) as department
    FROM drivenowdb.employee;
    
-- Equivalent LEFT JOIN
SELECT 
	emp_id, 
    first_name,
    last_name,
    age,    
    name as department
    FROM drivenowdb.employee e
    LEFT JOIN drivenowdb.department d
    ON e.dept_id = d.dept_id;
    
-- SubQuery in the FROM
SELECT emp.first_name, emp.last_name
FROM (
	SELECT 
		emp_id, 
		first_name,
		last_name,
		age,    
		name as department
    FROM drivenowdb.employee e
    LEFT JOIN drivenowdb.department d
    ON e.dept_id = d.dept_id
) as emp;
    
-- Subquery in the HAVING clause
SELECT customer_id as Customer,
	CONCAT('$ ', SUM(amount)) as Payments_Total, 
	CONCAT('$ ', ROUND(AVG(amount), 2)) as Average_Payment
FROM sakila.payment
GROUP BY customer_id
HAVING AVG(amount) <= (
	SELECT avg(amount)
    FROM sakila.payment
);
    
    
    
    
    
    
