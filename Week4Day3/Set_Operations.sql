-- Joins: Combining two tables based on a condition
-- Types: LEFT, INNER, RIGHT, OUTER

SELECT 
	emp_id, 
    first_name,
    last_name,
    age,    
    name as department
    FROM drivenowdb.employee e
    LEFT JOIN drivenowdb.department d
    ON e.dept_id = d.dept_id;
    
SELECT 
	emp_id, 
    first_name,
    last_name,
    age,    
    name as department
    FROM drivenowdb.employee e
    RIGHT JOIN drivenowdb.department d
    ON e.dept_id = d.dept_id;
    
SELECT 
	emp_id, 
    first_name,
    last_name,
    age,    
    name as department
    FROM drivenowdb.employee e
    INNER JOIN drivenowdb.department d
    ON e.dept_id = d.dept_id;
    
SELECT 
	emp_id, 
    first_name,
    last_name,
    age,    
    name as department
    FROM drivenowdb.employee e
    RIGHT OUTER JOIN drivenowdb.department d
    ON e.dept_id = d.dept_id;
    
SELECT 
	emp_id, 
    first_name,
    last_name,
    age,    
    name as department
    FROM drivenowdb.employee e
    JOIN drivenowdb.department d
    ON e.dept_id = d.dept_id;

/**
*
* Union Clauses
* UNION [ALL|DISTINCT]
* Combines the results of multiple queries
* into a single result set
* Required to have the same number of columns
**/

SELECT emp_id, first_name, last_name, age    
FROM drivenowdb.employee
WHERE first_name = 'Seth'
UNION ALL
SELECT emp_id, first_name, last_name, age    
FROM drivenowdb.employee
WHERE first_name = 'Bob';

-- Getting distinct customer records from the 
-- 2 versions of our order table
SELECT customer_name FROM drivenowdb.order_1nf
UNION DISTINCT
SELECT customer_name FROM drivenowdb.order_2nf;

-- Side Note: Manual Backup
SELECT CONCAT('INSERT INTO employee (emp_id, last_name, first_name, age, dept_id) VALUES (', emp_id, ', ', '''', last_name, ''', ', '''', first_name, ''' ,', age, ',', dept_id, ');' ) as statements
FROM drivenowdb.employee;

-- INTERSECT: Returns rows that are present in both tables
SELECT customer_name FROM drivenowdb.order_1nf INTERSECT DISTINCT
SELECT customer_name FROM drivenowdb.order_2nf;

-- EXCEPT: limits the results from the first query block to those
-- that are not found in the second.
SELECT customer_name FROM drivenowdb.order_1nf EXCEPT
SELECT customer_name FROM drivenowdb.order_2nf;