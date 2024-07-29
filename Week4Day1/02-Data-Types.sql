/*
Data types in MySQL

similary to Java Data types

1. byte    8bit whole number
2. short   16bit whole number
3. int     32bit whole number
4. long    64bit whole number
5. float   32bit floating point number
6. double  32bit floating point number
7. char    16bit Unicode (superset of ASCII)
8. String  (any length sequence of characters)
9. boolean true or false

MySQL Numeric types

1. TINYINT    8bit whole number
2. SMALLINT   16bit whole number
3. MEDIUMINT  24bit whole number
4. INT     32bit whole number
5. BIGINT    64bit whole number

Floating Point numbers

1. DECIMAL (fixed precision)
    - ex: decimal(5,2)   - 5 total digits and 2 digits after the decimal
2. FLOAT, DOUBLE (floating point precision)
    - notation float(m,d) and double(m,d) are depricated
    
Text data types

1. CHAR(m)   - characters 
   - ex: CHAR(2)   - always holds exactly 2 characters 
2. VARCHAR(m)
   - ex: varchar(16) - a maximum of 16 characters 
   
3. TEXT    - for long blocks of text like descriptions stored elsewhere in memory for optimal performacne
   - TINYTEXT, TEXT, MEDIUMTEXT, and LONGTEXT.
   
Non-text data types

Example: images or other file types:
1. TINYBLOB
2. BLOB    - for non-text data like 
3. MEDIUMBLOB
4. LONGBLOB

Booleans

1. TINYINT(1)   - use one bit (0 or 1)

Date/Time:

1. DATE (YYYY-MM-DD)                   ex: 
2. TIME (HH:MM:SS)                     ex: 
3. DATETIME (YYYY-MM-DD HH:MM:SS)      ex:
 4. TIMESTAMP (YYYYMMDDHHMMSS)         ex:
5. YEAR
	- 2 Digits ranges from 70 to 69 where 70 is 1970 and 69 is 2069
    - 4 Digits allows me to enter the year of my choosing
       1969 or 1869 etc.
*/

