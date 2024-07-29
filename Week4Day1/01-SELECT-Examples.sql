-- This is a comment
/* 
We doe have 
multiline comments as well
*/

/*
SQL Syntax

for CRUD operations (create read update delete)

SELECT - reading (querying the data)
INSERT - creating new entries in the database
UPDATE - updating data
DELETE - deleting data

DDL = data definition language

CREATE 
SET
DROP

DML = data manipulation language

*/

-- Example 1: Get all the data from the films table
SELECT * FROM sakila.film;
-- SELECT   - keyword indicating the type of query
-- *        - wildcard indicating all columns data should be retrieved
-- FROM     - cluase indicating what database table
-- sakila.film    - sakila is the schema name (optional if default set) film is the table name

-- Example 2: Select just the table names of all the films
SELECT title FROM film;

-- Example 3: Select title, description, release_year, rating
select title, 
       'description', 
	   release_year, 
       rating 
from film;

-- Example 4: Select the films rated PG
SELECT title, rating
FROM film
WHERE rating = 'PG'; -- = is comparison not assignment

/* 
In general, a SELECT query can have several different clauses

SELECT
FROM
WHERE
GROUP BY
HAVING
ORDER BY
LIMIT ... OFFSET

*/

-- Example 5: Get all actors in alphabetical order by last name
SELECT *
FROM actor
ORDER BY LAST_NAME ASC; -- DESC;

-- Example 6: Get all actors in alphabetical order by last name and first name
SELECT *
FROM actor
ORDER BY LAST_NAME ASC, first_name DESC; -- ASC is the default;

-- Example 7: Get the first 3 categories (in alphabetical order)
SELECT *
FROM category
ORDER BY name
LIMIT 3;

-- Example 7: Get the next 3 categories (in alphabetical order)
SELECT *
FROM category
ORDER BY name
LIMIT 3 OFFSET 3;

-- Example 8: Select the list of distinct last names 
SELECT DISTINCT last_name FROM actor;

-- Example 9: Keywords and queries other than Select
DESCRIBE film;

