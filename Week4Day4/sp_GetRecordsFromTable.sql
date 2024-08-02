/**
* Name: GetRecordsFromTable
* Author: Seth Clossman
* Desc: Gets a record from a specific table with a specific where clause (Dynamic SQL Demo)
* Inputs:
* - TableName: The name of the table
* - ColumnName: Column in the table to search through
* - SearchValue: Value to search for in the column
**/

DELIMITER //

CREATE PROCEDURE GetRecordsFromTable(
	IN TableName VARCHAR(64),
    IN ColumnName VARCHAR(64),
    IN SearchValue VARCHAR(255)
)
BEGIN
	-- Step 1:
    -- Construct the sql query as a string
    -- Inserting the variables we passed in
	SET @sql = CONCAT('SELECT * FROM ', TableName, ' WHERE ', ColumnName, ' = ?');
    -- Prepares the statement for actual execution from the string
    PREPARE stmt FROM @sql;
    -- Set the value passed in to search on as a variable to hand to our statement
    SET @val = SearchValue;
    -- Executes the prepared statement with a given value
    -- Supports parameterized query that helps reduce risk of SQL injection
    EXECUTE stmt USING @val;
    -- Deallocate the prepared statement to free up resources once the
    -- dynamic query has been executed.
    DEALLOCATE PREPARE stmt;
END //

DELIMITER ;