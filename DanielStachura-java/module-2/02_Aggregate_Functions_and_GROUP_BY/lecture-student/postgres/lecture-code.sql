--------------------------------------------------------------------------------------------------------
-- Ordering, Grouping Basic Functions Lecture Code
--------------------------------------------------------------------------------------------------------
--
-- The order of the rows in a result is unpredictable unless you code and ORDER BY
-- You can run the same SELECT without and ORDER BY 1000 times and get results in the same order each time
--      but there is no guarantee the order will be the same the 1001st time
--
-- IF YOU CARE ABOUT THE ORDER OF THE ROWS IN A RESULT CODE AN ORDER BY
--
-- ORDER BY is always coded last in standartd SQL
--
-- ORDER BY -  Sequence of Rows in Result
--
--    ORDER BY          -- Ascending Sequence (low-high)
--    ORDER BY ASC      -- Ascending Sequence (low-high)
--    ORDER BY DESC     -- Descending Sequence (high-low)

-- Show Populations of all countries in acscending order
select population       --columns to include in the result
from country            --table with the columns to include in the result
order by population asc -- see the columns in the result in acsending order
;

select population       --columns to include in the result
from country            --table with the columns to include in the result
order by population     -- see the columns in the result in acsending order - ASC is assumed/default
;

select name, population
from country 
order by population
;

-- Show Populations of all countries in descending order
select name, population
from country
order by population desc
;

-- Show Populations of all countries only if the population is greater than 1 million
select name, population
from country
where population > 1000000      --WHERE comes before ORDER BY
order by population 
;

select name, population
from country
where population >= 1000000 and population <= 10000000    -- check a range 
order by population 
;

select name, population
from country
where population between 1000000 and 10000000     --between will let you check a range
order by population 
;


-------------------------------------------------------------------------------------------------------------------

-- Show  the names of countries and continents in ascending order
select name, continent
from country
order by continent, name        --this will order the continent, then the name in ascending order
;

select name, continent
from country
order by name, continent        --this will order the name, then the continent 
                                        --does not make much sense because countries all have unique names
;

--show the names of countries and continent with name in descending order and continent in ascending order
select name, continent
from country
order by continent, name desc   --name is descending order
;

--show the names of countries and continent with BOTH in descending order 
select name, continent
from country
order by continent desc, name desc   --BOTH is descending order
;

--------------------------------------------------------------------------------------------------------
-- Limiting the number of rows in the result
--
-- LIMIT is proprietary to postgreSQL - it may not work in other dialect of SQL for other data base managers
--
-- LIMIT n   - Limit the number of rows in the result - always goes at the end of the SELECT -- even after the ORDER BY
--
--
-- Show the name and average life expectancy of the countries with the 10 highest life expectancies.
select name, lifeexpectancy
from country
where lifeexpectancy is not null
order by lifeexpectancy desc
limit 10                                -- limit the result to 10 rows instead of all rows that match the WHERE clause
;

--------------------------------------------------------------------------------------------------------
-- Concatenating values (like the + in Java with Strings)
--
-- the concat operator (||) may be used to concatenate character (string) values in a result
--

-- Show the name & state in the format: "city-name, state"
-- of all cities in California, Oregon, or Washington.
-- sorted by state then city
select name || ', ' || district        -- concatenate the city name a comma-space and district for my coulmn
        as City_State                   -- give a name to the derived column 
from city
where district = 'California' 
 or district = 'Oregon'
 or district = 'Washington'
 order by district, name 
;

select name || ', ' || district        
        as City_State                   
from city
where district in ('California', 'Oregon', 'Washington')        -- 'in' is alternative to a series of =/OR conditions
 order by district, name 
;


--------------------------------------------------------------------------------------------------------
-- Aggregate functions - produce one row in result for each group specified no matter how many rows are in the result
--                        rather than one row in the result for each row that satisfies the WHERE clause
--
-- Aggregate functions are used to produce a single value from a group of rows in a result
--
-- The group used by the aggregate functions is determined by the GROUP BY clause
-- if no GROUP BY clause is specified, the group is the set of rows in the result
--
--     AVG(column-expression)   - arithmentic average for group of non-NULL values in expression 
--     SUM(column-expression)   - arithmentic sum for group of a non-NULL values in expression 
--     MIN(column-expression)   - lowest value for group of non-NULL values in expression 
--     MAX(column-expression)   - highest value for group of non-NULL values in expression 
--     COUNT(*)                 - number of rows in the group
--     COUNT(column-expression) - number of rows for the group of non-NULL values in expression 
--
--
-- AVG(), SUM() may only be used with numeric data types
-- MIN(), MAX() may be used with numeric, character, date, time datatypes
--
-- COUNT() is applied to rows in the result (not columns)
--
--
-- Show average life expectancy in the world
select lifeexpectancy
from country
;

select avg(lifeexpectancy)
from country
;

--show average life expectancy in the world for each continent
select avg(lifeexpectancy), continent
from country
group by continent
;

-- Show the total population in Ohio
select district, sum(population)
from city
where district = 'Ohio'
group by district
;

-- Show the total and average population in Ohio
select district, sum(population), avg(population) 
from city
where district = 'Ohio'
group by district
;

-- Show the surface area of the smallest country in the world
select name, surfacearea
from country
order by surfacearea
limit 1
;

-- Show The 10 largest countries (by surface area) in the world
select name, surfacearea
from country
order by surfacearea desc
limit 10
;

-- Show the number of countries who declared independence in 1991
select  count(*)
from country
where indepyear = 1991

;
--------------------------------------------------------------------------------------------------------
-- GROUP BY  - Specify the group to which the aggregate functions apply
--
--      GROUP BY column-expression
--
-- When using a GROUP BY the SELECT is limited ot aggreggate functions or columns in the GROUP BY
--
--

-- Show the number of countries where each language is spoken, order show them from most countries to least



-- Show the average life expectancy of each continent ordered from highest to lowest



-- Exclude Antarctica from consideration for average life expectancy



-- What is the sum of the population of cities in each state in the USA ordered by state name



-- What is the average population of cities in each state in the USA ordered by state name


--------------------------------------------------------------------------------------------------------
-- SUBQUERIES - Using the result from one query (inner query) in another query (outer query)
--
-- Frequently used in a WHERE clause with an IN predicate:
--
--       WHERE column-name IN (SELECT column-name FROM some-table WHERE some-predicate)
--
-- Any WHERE predicate may be used to connect the subquery in a WHERE clause, but you must
-- be sure a single value is returned from the subquery. 
--
-- Subqueries may also be used in a SELECT as a column-specification or a FROM as a table
-- (These are advanced concepts we will discuss later, if there is time)
--
-- Show the cities under the same given government leader


-- Show countries with the same independece year


-- Show the cities cities whose country has not yet declared independence yet


--------------------------------------------------------------------------------------------------------
--
-- Additional samples
--
-- You may alias column and table names to provide more descriptive names
--
SELECT name AS CityName 
  FROM city AS cities

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)
SELECT name
     , population 
  FROM city 
 WHERE countryCode='USA' 
 ORDER BY name ASC, population DESC
;
-- Limiting results allows rows to be returned in 'limited' clusters where LIMIT says how many, 
-- and an optional OFFSET specifies number of rows to skip
SELECT name
     , population 
  FROM city 
  LIMIT 10 OFFSET 10
;