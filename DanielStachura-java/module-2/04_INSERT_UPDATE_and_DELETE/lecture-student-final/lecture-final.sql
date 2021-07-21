---------------------------------------------------------------------------------------------------------------------------------------
-- Referential Integrity (RI) - Enforcement of the Parent-Dependent relatiohnship
--                         ie. Ensure that every foreign key value has a matching primary key
--
--RI limits whats INSERT, UPDATE, DELETE can do
--
-- Constraints are rules regarding the data that must be complied with:
--
--  NOT NULL - Column must have a value
--
--  UNIQUE   - Column value must be unique with the table 
--
--  PRIMARY KEY - Column is part of the unique identifier for a row in the table
--                UNIQUE and NOT NULL are implied
--
--  FOREIGN KEY - Column is part of a foreign key for the table.  
--                Value must have a matching value in the primary key of the parent table
--                Establishes the parent-dependent relationship
--
--  CHECK  -  Specifies acceptable values for a column - any simple WHERE predicate is allowed
--
--  DEFAULT - Specify a default value for column if no value is supplied on INSER
---------------------------------------------------------------------------------------------------------------------------------------
-- Unit Of Work (UOW) - A recoverable sequence of operations within an application process
-- 
-- BEGIN TRANSACTION - Mark the start of a unit of work
-- 
-- COMMIT - End a unit of work and save changes - automatically done if no errors
-- 
-- ROLLBACK - End a unit of work and undo changes - automatically done if errors
---------------------------------------------------------------------------------------------------------------------------------------
--  INSERT - add a row to a table
--
--  Format 1: INSERT INTO table-name 
--            (column-list)           -- must contain all non-null columns
--            VALUES(value-list)      -- order of values must match order of columns specified
--
--
--  Format 2: INSERT INTO table-name 
--            VALUES(value-list)      -- order of values must match order of columns as defined in the table
--
--
--  Format 3: INSERT INTO table-name 
--            (SELECT statement)      -- order of columns in the SELECT must match the order of columns as defined in the table
--                                    -- () are optional
--
--    You MUST provide values for all non null columns or columns that the data base doesn't generate
--
--    The data base generate values for columns:
--
--        serial data types causes the data base manager to generate the next integer in a sequence
--                          to insure uniqueness - used for primary keys alot
--
--        if a column is assigned a default value it will be used by the database manager 
--                    if a value is not provided on an INSERT
-- 
--
--
--                                        
---------------------------------------------------------------------------------------------------------------------------------------
--  UPDATE - change data in a table
--
--  UPDATE table-name
--  SET column = new-value
--  WHERE condition            -- scope of update - if omitted, all rows are updated                                         
---------------------------------------------------------------------------------------------------------------------------------------
--  DELETE - Remove rows from a table
--
--  DELETE FROM table-name
--  WHERE condition            -- scope of delete - if omitted, all rows are deleted                                        
---------------------------------------------------------------------------------------------------------------------------------------
-- INSERT

-- 1. Add Klingon as a spoken language in the USA
Begin transaction; -- Start a UOW for the insert so we can decide to commit oro rollback;

insert into countrylanguage
(countrycode, language, isofficial, percentage)
values('USA', 'Klingon',  false,     1)
;
-- Verify that insert worked correctly
select * from countrylanguage where language = 'Klingon';

rollback;  -- undo the insert until we are sure it worked - the comment it out

-- 2. Add Klingon as a spoken language in Great Britain
--    we need the country code for Great Britain - it's United Kingdom in the country table
Begin transaction; -- Start a UOW for the insert so we can decide to commit oro rollback;

-- We found the countrycode for Great Britain/United Kingdom manually and hard-coded in the values
insert into countrylanguage
(countrycode, language, isofficial, percentage)
values('GBR', 'Klingon',  true,     34)
;
-- Verify that insert worked correctly
select * from countrylanguage where language = 'Klingon';

rollback;  

Begin transaction; -- Start a UOW for the insert so we can decide to commit oro rollback;

-- use a subquery to get the countrycode for Great Britain/United Kingdom
insert into countrylanguage
(countrycode, language, isofficial, percentage)
values((select code from country where name = 'United Kingdom')  -- get the country code form the country table
       , 'Klingon',  true,     34)
;
-- Verify that insert worked correctly
select * from countrylanguage where language = 'Klingon';

rollback; 


-- UPDATE

-- 1. Update the capital of the USA to Houston
--    the capital is an int in country repesenting the in the city table for the city
--    we need to find the city in the city table for Houston and use it to update the country table
--    This is job for Subquery!
--
Begin transaction;

-- Display what the current value is before the update
select capital as Before_Update from country where code = 'USA';

update country
   set capital = (select id from city where name = 'Houston')
 where code = 'USA'
 ;

-- Verify the update worked
select capital as After_update from country where code = 'USA';

-- undo any changes until you are sure you want them to be permanent
rollback;


-- 2. Update the capital of the USA to Cleveland and the head of state
Begin transaction;

-- Display what the current value is before the update
select capital, headofstate as Before_Update from country where code = 'USA';

update country
   set capital = (select id from city where name = 'Cleveland'),
       headofstate = 'Dan McDanDan '
 where code = 'USA'
 ;

-- Verify the update worked
select capital, headofstate as After_update from country where code = 'USA';

-- undo any changes until you are sure you want them to be permanent
rollback;

-- DELETE

-- 1. Delete English as a spoken language in the USA
Begin transaction;

-- verify the WHERE clause on the DELETE with a SELECT
select *, 'Testing the WHERE in the DELETE'
  from countrylanguage
  where countrycode = 'USA'
    and language = 'English'
    ;
    
delete from countrylanguage
  where countrycode = 'USA'
    and language = 'English'
    ;
-- verify the delete worked
select *, 'After the Delete'
  from countrylanguage
  where countrycode = 'USA'
    and language = 'English'
    ;

-- undo any changes until wee are sure the delete only did what it was suppsoed to
rollback;

-- 2. Delete all occurrences of the Klingon language 


-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.
begin transaction;

insert into countrylanguage
(countrycode,language,isofficial,percentage)
values('GBR','Elvish',true,55)
;

rollback;
-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?

-- 3. Try deleting the country USA. What happens?
Begin transaction;

delete from country
where code = 'USA'
;
rollback;

-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA

-- 2. Try again. What happens?

-- 3. Let's relocate the USA to the continent - 'Outer Space'


-- How to view all of the constraints
--
-- information about all database objects are stored in catalog table
-- every database manager has a set of catalog tables to keep track of everything in it
--
-- Anything you want to know about any object in a database manager cant be found 
--
-- Use the same SELECT yuou use for application table tyo access the catalog tables
--
SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;             --the catalog table in postgres with Table Constraints
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;       --the catalog table in postgres with column Constraints
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;       --the catalog table in postgres with referential Constraints


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.

-- 2. Try updating all of the cities to be in the USA and roll it back
