/* Logical Operators 
   AND
   OR
   NOT
  Comparison
   < > <= >= != (or for not equal use <>) =
*/

-- get actors whose id is in the set 1 11 20 33
 SELECT * 
 FROM actor
 WHERE actor_id = 1 Or actor_id = 11 or actor_id = 20 or actor_id = 33;
 
 SELECT *
 FROM actor
 WHERE actor_id IN (1, 11, 20, 33);
 
 -- get actors whose id is in the set 1, 2, 3, 4, 5
 
 SELECT * 
 FROM actor
 WHERE actor_id >= 1 AND actor_id <= 5;
 
 SELECT *
 FROM actor
 WHERE actor_id BETWEEN 1 AND 5;
 
 use world; -- change schema we are using to run queries against
 -- select country name and independence year from world.country table
 SELECT Name, IndepYear
 FROM country
 WHERE IndepYear IS NULL;
 
 
 -- comparing strings
 -- RegEx - regular expressions - patterns for matching against strings
 -- LIKE operator - less powerful but simpler to use for matching strings against a pattern
 
 -- Example: Find all customers whose last name starts with A
 SELECT * FROM customer WHERE substr(last_name, 1, 1) = 'a'; -- not case sensitive
 
 SELECT * FROM customer WHERE last_Name LIKE 'A%'; -- wildcard % matches 0 or more
												   -- wildcard . matches exactly 1 character
                                                   
-- Example: Find all customers whose first name ends with Y
SELECT * FROM customer WHERE first_name LIKE '%Y';
 