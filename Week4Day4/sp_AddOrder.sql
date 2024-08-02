/**
* Name: AddOrder
* Author: Seth Clossman
* Desc: Adds an order record to the order_2nf
* Inputs:
* - CustomerName: The name of the customer
* Created On: 08/01/2024
* Last Modified On: 08/01/2024
**/

DELIMITER //

CREATE PROCEDURE AddOrder(
	IN CustomerName VARCHAR(255)
)
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
		-- Reverts the DB back to the state
        -- prior to running the transaction
		ROLLBACK;
        SELECT 'An error occurred while adding the order';
	END;
    -- Unit of Work
    -- All or nothing mentality
    -- [Statements that cannot be rolled back: DDL]
    START TRANSACTION;
		INSERT INTO drivenowdb.order_2nf (order_date, customer_name)
		VALUES(DATE(NOW()), CustomerName); 
    COMMIT;
END //

DELIMITER ;