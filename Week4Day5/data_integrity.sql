/**
*
* Data Integrity: the accuracy, consistency, and reliability of
*  data stored in a database.  We want the data to remain correct,
*  complete, and current during all operations including storage,
*  retrieval and update.
*
* Types:
* - Entity Integrity: Ensuring each table has primary key and that
*      the primary key is unique and not null.
*
* - Referential Integrity: Ensuring that a foreign key value is always
*	   pointing to an existing, valid record in another table.
*
* - Domain Integrity: Ensuring that all values in a column are valid
*	   according to defined rules such as data types, formats, and ranges
*
**/


CREATE TABLE `employee` (
	-- Entity Integrity
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `age` int DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `manager_id` int DEFAULT '0',
  -- Entity Integrity
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `last_name` (`last_name`,`first_name`),
  KEY `dept_id` (`dept_id`),
  KEY `idx_lastname` (`last_name`),
  -- Referential Integrity
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`),
  -- Domain Integrity
  CONSTRAINT `employee_chk_1` CHECK ((`age` >= 18))
) ENGINE=InnoDB AUTO_INCREMENT=992 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

