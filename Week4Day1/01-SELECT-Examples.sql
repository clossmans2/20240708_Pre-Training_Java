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
       `description`, -- backticks make sure this treated as a name of a column not a keyword
	   releast_year, 
       rating 
from film;