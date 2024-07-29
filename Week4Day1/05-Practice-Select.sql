/*
Built-in Functions
- If you are trying to format, convert, or manipulate a value, 
  there is almost always a built-in function that will do that, 
  you just need to find which one it is.
https://dev.mysql.com/doc/refman/8.0/en/functions.html
*/

SELECT curdate() as today;
SELECT year(curdate()) as year;
SELECT month(curdate()) as month;
SELECT day(curdate()) as day;
SELECT year('70-10-11'); -- two digit years 70-99 are 1900s
SELECT year('69-2-14'); -- 0-29 are 2000s
SELECT TIMESTAMPDIFF(YEAR,'2000-01-01',CURDATE()) AS age;
SELECT timediff('14:00:00', time(now())) AS 'Time left in LEcture';


SELECT concat("hello ", "world", "!", " SQL is awesome!") as greeting;
SELECT upper('hello'); 
SELECT lower('HELLO');
SELECT substr('hello', 1); -- 'hello'
SELECT substr('hello', 2); -- 'ello' NOT zero-indexed 
SELECT substr('hello', 0); -- does not work
SELECT substr('hello!',4,2); -- start and number of characters

SELECT left('hello', 1); 
SELECT right('hello', 2); 


/*
Aggregate build-in functions in SELECT
*/

SELECT 
    MIN(rental_rate),
    MAX(rental_rate),
    AVG(rental_rate),
    SUM(rental_rate),
    COUNT(rental_rate),
    COUNT(DISTINCT rental_rate)
FROM
    sakila.film;
    
SELECT DISTINCT rental_rate FROM sakila.film;

SELECT COUNT(*), COUNT(IndepYear) FROM country;


/*
Query Practice Problems
SELECT
1. Retrieve all customers from the "customer" table.
2. Get the titles of all films from the "film" table.
3. Retrieve the first name, last name, and email of all customers.
4. Get the rental ID, rental date, and return date from the "rental" table.
5. Get the film titles and descriptions of films that have a rating of "R".
6. Retrieve the rental ID, customer ID, and return date of rentals that are overdue (return date is in
the past).
7. Get the distinct cities from the "city" table.
8. Retrieve the film titles and rental rates of films that have a rental rate greater than $4.50.
9. Retrieve the first name and last name of all staff members from the "staff" table.
10. Challenge: Retrieve the first name, last name, and phone number of customers whose last name
starts with "S".

*/ 



