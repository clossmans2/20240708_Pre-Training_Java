-- FUNCTIONS: Built in operations that perform calculations or manipulation of data
-- and can be used in queries to perform math, string manipulation or date processing/conversion
-- Scalar: Returns a single value based on the input value
-- Aggregate: Return a signle value calculated from values in a column

-- UPPER: turns a string to uppercase, UCASE
SELECT UPPER('hello, world!') as UppercaseText;
-- LOWER: turns a string to lowercase, LCASE
SELECT LOWER('HELLO, world!') as LowercaseText;
-- ROUND: rounds a number to a specific number of decimal places
SELECT ROUND(123.456, 0) as RoundedNumber;
-- LENGTH: returns the length of a string
SELECT LENGTH('The quick brown fox jumps over the lazy dog');
-- CONCAT: Combines strings and returns a single string
SELECT CONCAT('I''m a little teapot', ' short and stout', ', here is my handle') as ConcatenatedString;
-- CONCAT_WS(separator, N-Strings..): Combines strings with a specific separator
SELECT CONCAT_WS(', ', 'red', 'orange', 'yellow', 'green', 'blue', 'violet') as ColorSpectrum;

-- LEFT/RIGHT - Grab a portion of the string from a side up to N characters
SELECT LEFT('Lorem ipsum dolor sit', 5);
SELECT RIGHT('Lorem ipsum dolor sit', 5);

-- TRIM, LTRIM, RTRIM: Remove the leading/trailing spaces characters and return the string
SELECT TRIM('               Lorem ipsum dolor sit   ') as FillerText;
-- Date Functions
-- Get the current date
SELECT CURDATE() as CurrentDate;
SELECT CURRENT_DATE() as CurrentDate;
SELECT CURRENT_DATE as CurrentDate;
-- Get the current time
SELECT CURTIME() as CurrentTime1, 
	CURRENT_TIME() as CurrentTime2,
    CURRENT_TIME as CurrentTime3;
-- Get the current timestamp
SELECT NOW() as Now,
	CURRENT_TIMESTAMP() as CurTimeStamp1,
    CURRENT_TIMESTAMP as CurTimeStamp2;
-- Date Math & Comparison
-- Gets just the date from a date or datetime expression
SELECT DATE(NOW());
SELECT MONTH(NOW());
SELECT MONTHNAME(NOW());
SELECT DAY(NOW());
SELECT YEAR(NOW());
SELECT MINUTE(NOW());
SELECT SECOND(NOW());
-- Adds intervals to a date and outputs a datetime
SELECT DATE(DATE_ADD(NOW(), INTERVAL 90 DAY)) as 90DaysFromToday;
-- Subtracts intervals from a date and outputs a datetime
SELECT DATE_SUB(CURRENT_TIMESTAMP, INTERVAL 30 DAY) as OneMonthAgo;
-- Subtracts one date from another
SELECT DATEDIFF(CURRENT_TIMESTAMP, '2024-07-01 09:36:04') as DateDiff;
-- Format a date according to a specific format string
SELECT DATE_FORMAT(Now(), '%a %M %e, %Y - %h:%i:%s %p') AS NOW;

-- COUNT: Returns the number of rows
SELECT actor.first_name, actor.last_name, COUNT(film.film_id) as NumberOfFilms FROM sakila.actor
LEFT JOIN sakila.film_actor 
ON actor.actor_id = film_actor.actor_id
LEFT JOIN sakila.film
ON film.film_id = film_actor.film_id
GROUP BY actor.actor_id, actor.first_name, actor.last_name
HAVING COUNT(film.film_id) > 40;

-- SUM: Sum the values in a column
SELECT customer_id, SUM(amount) as Payments_Total 
FROM sakila.payment 
GROUP BY customer_id
HAVING SUM(amount) > 175.00;

-- AVG: Returns the average value of column
-- MIN: Return the minimum value of a column
-- MAX: Returns the max value of a column
SELECT 
	CONCAT('$ ', SUM(amount)) as Payments_Total, 
	CONCAT('$ ', ROUND(AVG(amount), 2)) as Average_Payment, 
    CONCAT('$ ', MIN(amount)) as Minimum_Payment, 
    CONCAT('$ ', MAX(amount)) as Maximum_Payment
FROM sakila.payment;

-- USER DEFINED FUNCTIONS -> reads data, cannot modify db
-- You can only use them with Select/Join/Apply
-- Can't use temp table, only a table variable
-- Can't use transactions
-- Can't execute a stored procedure
-- DETERMINISTIC: the function always gives the same result for the same input
-- CREATE FUNCTION FindPayment(paymentid INT)
-- RETURNS DECIMAL (6,2) DETERMINISTIC
-- RETURN (SELECT amount FROM sakila.payment WHERE payment_id = paymentid);

-- SELECT * FROM sakila.payment;
SELECT FindPayment(5);
-- SELECT amount FROM sakila.payment WHERE payment_id = 2;