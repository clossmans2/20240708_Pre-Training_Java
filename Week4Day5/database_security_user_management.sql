/**
*
* Database Security: protecting the database against unauthorized
* 	access, malicious threats, and attacks.
*
* - Authentication: Verifies the identity of users attempting to access the db
*	"Check to see if they are who they say they are"
* - Authorization: Verifies that a person has a role/permission to perform
*	 specific actions on database objects.
* - Auditing: Tracking and logging database activities to monitor and
*	 review user actions.
* - Encryption: Protecting data by converting it into a secure format
*	 that can only be read by authorized users.
*
**/

CREATE USER 'sclossman'@'localhost' IDENTIFIED BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE 
ON employee
TO 'sclossman'@'localhost';

REVOKE DELETE ON employee FROM 'sclossman'@'localhost';
DROP USER 'sclossman'@'localhost';
SELECT * FROM mysql.user;