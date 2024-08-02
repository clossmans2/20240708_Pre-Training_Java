/**
*
* Stored Procedure: pre-compiled statement, stored in the database
* manage and execute complex operations in a single statement call,
* can modify the database and call functions/sproc
*
**/

-- CALL `sakila`.`rewards_report`(30, 4.99, @rewardees);
-- SELECT @rewardees;

-- CALL drivenowdb.AddInventoryItem('Tomatoes', 1.99, 'lbs');
-- SELECT * FROM inventory;
-- Dynamic SQL
-- CALL drivenowdb.GetRecordsFromTable('inventory', 'name', 'apples');
-- Recursive Tables inside Stored Procedure
CALL GetSubordinates(157);

SELECT * FROM employee
WHERE dept_id = 6
AND manager_id = 0;

