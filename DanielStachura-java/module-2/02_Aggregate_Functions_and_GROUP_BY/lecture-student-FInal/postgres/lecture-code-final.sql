--------------------------------------------------------------------------------------------------------
-- Ordering, Grouping Basic Functions Lecture Code
--------------------------------------------------------------------------------------------------------
--
-- The order of the rows in a result is unpredictable unless you code an ORDER BY
-- You can run the same SELECT without an ORDER BY 1000 times and get results in the same order each time
-- but there is guarantee the order will be the same the 1001st time
--
-- IF YOU CARE ABOUT THE ORDER OF THE ROWS IN A RESULT CODE AN ORDER BY
--
-- ORDER BY is always coded last in standard SQL
--
-- ORDER BY -  Sequence of Rows in Result
--
--    ORDER BY          -- Ascending Sequence (low-high)
--    ORDER BY ASC      -- Ascending Sequence (low-high)
--    ORDER BY DESC     -- Descending Sequence (high-low)

-- Show Populations of all countries in acscending order
select population          -- columns to include in the result
  from country             -- table with the columns ti include in the results
 order by population asc   -- see the columns in the result in ascending population order
;

select population          -- columns to include in the result
  from country             -- table with the columns ti include in the results
 order by population       -- see the columns in the result in ascending population order - ASC is assumed
;
-- we want to include the country name in the result
select name, population    -- columns to include in the result
  from country             -- table with the columns ti include in the results
 order by population       -- see the columns in the result in ascending population order - ASC is assumed
;


-- Show Populations of all countries in descending order
-- include the name of the country
select name, population    -- columns to include in the result
  from country             -- table with the columns ti include in the results
 order by population desc      -- see the columns in the result in ascending population order - ASC is assumed
;

-- Show Populations of all countries in poulation ascending order 
-- only if population is greater than 1 million
-- include the name of the country
select name, population      -- columns to include in the result
  from country               -- table with the columns to include in the results
 where population > 1000000  -- show only if population is greater than 1 million
 order by population         -- see the columns in the result in ascending population order - ASC is assumed
;

-- Show Populations of all countries in poulation ascending order 
-- only if population is between 1 million and 10 million
-- include the name of the country
select name, population            -- columns to include in the result
  from country                     -- table with the columns to include in the results
 where population >= 1000000       -- show only if population is greater or equal than 1 million
   and population <= 10000000     --                    and less than or equal 10000000
 order by population               -- see the columns in the result in ascending population order - ASC is assumed
;

select name, population                          -- columns to include in the result
  from country                                   -- table with the columns to include in the results
 where population between 1000000 and 10000000   -- show only if population is between 1 million and 10 million
 order by population                             -- see the columns in the result in ascending population order - ASC is assumed
;

-- Show  the names of countries and continents in ascending order
select name, continent     -- columns to include in the result
  from country             -- table with the columns ti include in the results
 order by continent        -- see the columns in the result in ascending continent order - ASC is assumed
;

-- Show  the names of countries and continents with both in ascending order
select name, continent        -- columns to include in the result
  from country                -- table with the columns ti include in the results
 order by continent, name     -- see the columns in the result in ascending continent and name order - ASC is assumed
;

-- Show  the names of countries and continents with both in ascending order
select name, continent        -- columns to include in the result
  from country                -- table with the columns to include in the results
 order by name, continent     -- see the columns in the result in ascending name and continent order - ASC is assumed
;

-- Show  the names of countries and continents with name in descending order and continents in ascending order
select name, continent          -- columns to include in the result
  from country                  -- table with the columns to include in the results
 order by continent, name desc  -- see the columns in the result in ascending continent and name order - ASC is assumed
;

-- Show  the names of countries and continents with both in descending order
select name, continent               -- columns to include in the result
  from country                       -- table with the columns to include in the results
 order by continent desc, name desc  -- see the columns in the result in descedning order
;


--------------------------------------------------------------------------------------------------------
-- Limiting the number of rows in the result
--
-- LIMIT is proprietary to postgreSQL - it maynot work in other dialects of SQL for other data base managers
--
-- LIMIT n   - Limit the number of rows in the result - always goes at the end of the SELECT - even after ORDER BY
--
--

-- Show the name and average life expectancy of the countries with the 10 highest life expectancies.
select name, lifeexpectancy        -- columns to see in the result
from country                       -- table with the columns
where lifeexpectancy is not null   -- only include rows where lifeexpectancy values that are not null
order by lifeexpectancy desc       -- see them from high to low order
limit 10                           -- limit the result to 10 rows instead of all rows that match the WHERE clause
;
--------------------------------------------------------------------------------------------------------
-- Concatenating values (like + in Java with Strings)
--
-- the concat operator (||) may be used to concatenate character (string) values in a result
--

-- Show the name & state in the format: "city-name, state"
-- of all cities in California, Oregon, or Washington.
-- sorted by state then city
select name || ', ' || district   -- concatenate the city name a commma-space and district for my column
    as City_State                 -- give a name to the derived column
  from city
 where district = 'California'
    or district = 'Oregon'
    or district = 'Washington' 
 order by district, name
;

select name || ', ' || district   -- concatenate the city name a commma-space and district for my column
    as City_State                 -- give a name to the derived column
  from city
 where district in('California', 'Oregon', 'Washington') -- in is alternative ot a series of =/or conditions
 order by district, name
;

--------------------------------------------------------------------------------------------------------
-- Aggregate functions - produce one row in result for each group specified no matter how many rows are in the result
--                       rather than on row in the result for each row that satisifies teh WHERE clause
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
--  if the requirement says "number of" - count(*)
--  if the requirement says "number of without nulls" in a column - count(column-name)
--  if the requirement says "largest / biggest" - Max() or order by desc and LIMIT
--  if the requirement says "smallest / least" - Min() or order by asc and LIMIT
--  if the requirement says "total or sum" - sum()
--  if the requirement says "average" - avg() 
--  if the requirement says "for each" or "by each" - GROUP BY
--
-- AVG(), SUM() may only be used with numeric data types
-- MIN(), MAX() may be used with numeric, character, date, time datatypes
--
-- COUNT() is applied to rows in the result (not columns)
--
--
-- Show average life expectancy in the world
select lifeexpectancy   -- show me the lifeexpectancy
  from country          -- of each country - one row in the result for every country in the table (239)
;
select avg(lifeexpectancy)   -- show me the lifeexpectancy
  from country               -- of each of all countries - one row in the result regardless of the number of countries
;
-- Show the average life expectancy in the world for each continent
select   continent, avg(lifeexpectancy)  -- a column used in the GROUP BY may be coded on the SELECT
  from   country
group by continent   -- perform the aggregate function for each unique continent - one row in result for each continent
;
-- Show the average life expectancy in the world for each continent
-- ONLY columns used in the GROUP BY are allowed yto be included on the SELECT
select    continent
  --     , region  -- region is not allowed because it is not included in a group by
         , avg(lifeexpectancy)  -- a column used in the GROUP BY may be coded on the SELECT
  from   country
group by continent   -- perform the aggregate function for each unique continent - one row in result for each continent
;

-- Show the total population in Ohio
select  sum(population)    -- sum - total up all the value in column you give         
  from city                -- district is in city
where district = 'Ohio'
;

-- Show the total and average population in Ohio
select  sum(population), avg(population)    -- sum - total up all the value in column you give         
  from city                -- district is in city
where district = 'Ohio'
;

-- Show the total and average population in Ohio - include the name of the state
select  district
      , sum(population) as Total_People_Living_in_Ohio
      , avg(population) as Average_Population_In_Ohio       
  from city                -- district is in city
where district = 'Ohio'
group by district
;

-- Show the surface area of the smallest country in the world
select surfacearea
  from country
 order by surfacearea
 limit 1
;
-- Show the surface area and name of the smallest country in the world
select name, surfacearea
  from country
 order by surfacearea
 limit 1
;
-- Show the surface area of the smallest country in the world
select min(surfacearea)
  from country
;
-- Show the surface area and name of the smallest country in the world
select name, min(surfacearea)
  from country
  group by name
  order by min(surfacearea) asc
  limit 1
;

-- Show The 10 largest countries (by surface area) in the world
select name,surfacearea
  from country
order by surfacearea desc
limit 10
;
-- Show The 10 largest countries (by surface area) in the world
select name,max(surfacearea)
  from country
 group by name, surfacearea
order by surfacearea desc
limit 10
;
-- Show The 10 largest countries (by surface area) in the world
select name,max(surfacearea)
  from country
 group by name, surfacearea
order by 2 desc   -- order by column 2 in the SELECT - used for derived columns without names
limit 10
;

-- Show The 10 largest countries (by surface area) in the world
select name,max(surfacearea) as how_big_they_are
  from country
 group by name, surfacearea
order by how_big_they_are desc   -- order by an as name in the SELECT
limit 10
;
-- Show the number of countries who declared independence in 1991
select count(*)  -- count(*) - number of rows in the result
  from country  
 where indepyear = 1991 -- limit the result to rows with indpeyear of 1991
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