-- Example 1: Select the customer name and address (address, address2, postal_code)
SELECT concat(first_name, " ", last_name) name, CONCAT(address, " ", address2) AS address, postal_code zip_code
FROM customer JOIN address ON (customer.address_id = address.address_id);

-- Example 2: Select the customer name and address (address, address2, postal_code) and city name
SELECT 
    CONCAT(first_name, ' ', last_name) name,
    CONCAT(address, ' ', address2) AS address,
    city,
    postal_code zip_code
FROM
    customer
        JOIN
    address USING (address_id)
        JOIN
    city USING (city_id);