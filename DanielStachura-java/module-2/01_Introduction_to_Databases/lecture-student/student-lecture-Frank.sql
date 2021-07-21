--------------------------------------------------------------------------------------------------------
-- Basic SELECT Lecture Code
--------------------------------------------------------------------------------------------------------
-- -- indicates a comment - anything following on the line is ignored
--
-- SQL SELECT statement - retrieve values form the database (Read)
--
-- A SELECT statement is often referred to as a query
--
-- Basic syntax:
--
--    1st       SELECT   - columns to include in the result (seperate mutiple column reqeusts with commas)
--    2nd       FROM     - table containing rows with columns used in the query 
--    optional  WHERE    - rows to include in the result / ROW filter
--    optional  ORDER BY - sequence of rows in the result
--                 without an ORDER BY the sequence of the rows in the result is not predictable
--                 if the sequence of teh rows in teh result matter - code an ORDER BY
--
-- WHERE predicates (condition - similar to Jave 'If' conditions with many more options):       
--
--      not equals is either  <> or !=
--
--        =  <>  !=  >  >=  <  <= 
--        IN(list-of-values)      -- alterative to a series of = OR
--        NOT IN(list-of-values)  -- alterative to a series of != AND
--        BETWEEN value AND value
--        IS NULL
--        IS NOT NULL
--        LIKE    (use wildcards: % means 0 to any number of any characters
--                                _ means exactly any one character)
--               'value%' - starts with the value
--                '%value' - end with the value
--              '%value%' - contains the value                                     
--        ILIKE   (case insensivtive LIKE - Postgres extension)
--
-- predicates may be combined using AND and OR - full predicates must be coded on both sides for AND / OR
--
-- use parentheses to make your multi-predicate condition clear

-- The DISTINCT clause on a SELECT removes duplicate values from the result
-- based on the all columns that follow
--
-- The DISTINCT ON(columns/expression) clause on a SELECT removes duplicate values from the result
-- based on the all columns/expression inside the parentheses that follow (Postgres extension)
------------------------------------------------------------------------------------------------------

-- Selecting the names for all countries
select name     -- columns i want to see in the result
from country    -- table with the columns I want
;               -- use a semi-colon to mark thge end of an SQL statement in a file

-- Selecting the name and population of all countries
select name, population         -- columns to see in the result in the order you want to see them
from country                    -- table with the columns I want
;                               -- semi-colon to mark the end 

select population, name         -- columns to see in the result in the order you want to see them
from country                    -- table with the columns I want
;                               -- semi-colon to mark the end 

-- Selecting all columns from the city table
select *                        -- columns to see in the result in the order you want to see them 
                                --      (* = all columns in order define in the table)
from city                       -- table with the columns I want
;                               -- semi-colon to mark the end

-- SELECT ... FROM ... WHERE
-- Selecting the cities in Ohio
select name             -- show me the name  
from city               -- from the city table
where district = 'Ohio' -- only include the rows for district = 'Ohio'
                        -- string literals are coded inside apostrophes (not double quotes like in Java)
                        -- **case if the string literal matters - MUST match what is in the table
;

-- Selecting countries that gained independence in the year 1776
select name
from country
where indepyear = 1776  -- numeric literals are just coded as numbers
;

-- Selecting countries not in Asia
select name, continent  -- sometimes include columns not asked for to verify your result
from country
where continent != 'Asia'
;

-- Selecting countries that do not have an independence year - independence year is null
--      In relational data bases null represents a missing or unknown value
--              (Frank: the "i dont know value")
--
--      since it's value is unknown, we cannot use normal WHERE predicates to test it(= != <> < >)
--      Special WHERE predicates are used to check nulls -  IS NOT NULL or IS NULL
select name, indepyear
from country
where indepyear is null -- must use the special predicate IS NULL to check for a null
;

-- Selecting countries that do have an independence year
select name, indepyear
from country
where indepyear is not null
;

-- Selecting countries that have a population greater than 5 million
select name, population
from country
where population > 5000000
;

-- SELECT ... FROM ... WHERE ... AND/OR
-- Selecting cities in Ohio and Population greater than 400,000
select name, population, district
from city
where population > 400000       -- a full predicate is required on each side of an AND / OR
and district = 'Ohio'           -- a full predicate is a column, operator, value
;

-- Selecting country names on the continent North America or South America
select name, continent
from country
where continent = 'North America'
or continent = 'South America'
;
select name, continent
from country
where continent like '%America'         -- continent ends with the word 'America'
;
select name, continent
from country
where continent like '%America%'         -- continent conatins the word 'America'
;
select name, continent
from country
where continent ilike '%AMERICA'         -- continent ends with the word 'America' - *ilike - ignores the case
                                         -- ilike is a postgreSQL extension to standartd SQL
                                         -- ilike may not work in database managers other than postgreSQL
;

-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area (population / surfacearea)
select population
        ,lifeexpectancy
        ,population
        ,population / surfacearea       --derived column - result of a calculation or function
                                        --derived coulmn do not have names in the result
from country
;

select population
        ,lifeexpectancy
        ,population
        ,population / surfacearea as population_per_area -- AS may be used to assign a name to a column in the result
                                                         -- DO NOT put the name inside apostrophe or quotes
                                                         -- DO NOT put spaces between the words of the names
                                                         --     use _ to seperate the words in the new name
                                                         --derived column - result of a calculation or function
                                                         --derived coulmn do not have names in the result                                      
from country
;


