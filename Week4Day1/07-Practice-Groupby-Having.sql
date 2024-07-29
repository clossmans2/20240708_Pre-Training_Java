/* GROUP BY */

-- example: how many customers names start with each letter of the alphabet?
SELECT * FROM customer WHERE first_name LIKE 'A%'; 
SELECT * FROM customer WHERE first_name LIKE 'B%'; 
SELECT * FROM customer WHERE first_name LIKE 'C%'; 
SELECT * FROM customer WHERE first_name LIKE 'D%'; 
SELECT * FROM customer WHERE first_name LIKE 'E%'; 
-- ETC is not the best way

SELECT count(first_name) as number, substring(first_name,1, 1) as first_letter
FROM actor
group by first_letter
ORDER BY number asc;

-- Find the least common letter for a name 
SELECT count(first_name) as number, substring(first_name,1, 1) as first_letter
FROM actor
group by first_letter
ORDER BY number asc
LIMIT 1;

-- Find the most common letter for a name
SELECT count(first_name) as number, substring(first_name,1, 1) as first_letter
FROM actor
group by first_letter
ORDER BY number desc
LIMIT 1;

-- challenge: get the max number of names startign with the same letter

-- example: group by to count the number of films in each category
SELECT count(*) as number, rating FROM film GROUP BY rating ORDER BY number desc;

-- example: only get film categories with over 200 available films
SELECT 
    COUNT(*) AS number, rating
FROM
    film
GROUP BY rating
HAVING number > 200
ORDER BY number DESC;


-- challenge: group by multiple columns


/* Query Practice Problems
GROUP BY
1. Count the number of films in each category.
2. Calculate the average rental duration for films in each language.
3. Determine the number of rentals made by each staff member.
4. Find the total sales (revenue) for each customer:
5. Calculate the average replacement cost of films in each rating category.
6. Find the total number of rentals per day.
7. Determine the maximum rental rate for each film category.
8. Calculate the total revenue for each month in the payment table.
9. Find the average rental rate and length for films in each language.
10. Determine the minimum and maximum rental duration for films in each category.
*/

-- 4. Find the total sales (revenue) for each customer:
SELECT customer_id, sum(amount) as sales_revenue
FROM payment
group by customer_id with rollup
ORDER BY customer_id;

SELECT customer.first_name, customer.last_name, customer_id, sales_revenue
FROM (SELECT customer_id, sum(amount) as sales_revenue
FROM payment
group by customer_id with rollup
ORDER BY customer_id) as tableA
  JOIN
customer USING (customer_id);

/* Query Practice Problems
HAVING
1. Retrieve the rental count and customer ID for customers who have rented more than 30 films.
2. Get the total payment amount and customer ID for customers whose total payment amount
exceeds $200.
3. Find the average rental rate and rental duration for films that have an average rental rate greater
than $3.50.
4. Retrieve the film IDs and their rental counts for films that have been rented more than 50 times.
5. Get the customer ID and the number of distinct cities the customer has rented films from for
customers who have rented from more than 2 distinct cities.

*/
