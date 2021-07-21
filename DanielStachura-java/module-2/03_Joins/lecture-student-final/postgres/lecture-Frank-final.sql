--
-- Frank's JOIN lecture code
--
-- This SQL uses the world database - be sure you run it in the world database
--
-- show the country name, city name, district for all cities
--
-- we need data from country table (country name) and city table (city name and district)
--
-- if columns names are not unique between the tables, put tablename. front of the column name
--
-- The join-condition is what matches between the tables
--
-- The order of the tables for the join doesn't matter - data base managers figures out what to do
--
-- There are two formats for coding a join:
--
--      1. Classic syntax - code all tables for the join on the FROM
--                               and the join condition on the WHERE
--                          only an INNER JOIN may be done
--                          Works if you forget the join condition(s) - not correctly (not a join) but it runs
--                          if you forget the join condition result is a Cartersian Product
--                             (each row from one table is produced for every row in the other)
--                             (the number of rows in the results = #-rows-in-one-table * #-rows-in-other)
--                             (if you try to join a 1000 row table to a 1000 row table without
--                                 a join condition you will get 1000000 rows in the result)
--                             (since join is used to show matching data between tables, a Cartersian product is NOT a join)
--
--      2. Modern syntax - code the type of join bewteen the tables instead of a comma
--                              and the join conditionis coded on an ON statement not WHERE
--                         any type of join may be done
--                         error if you forget the join condition(s)
--
--
----------------------------------------------------------------------------------------
-- Classic Syntax join
----------------------------------------------------------------------------------------
select  country.name, city.name, district    -- columns you want in the result
  from  country, city                        -- table(s) with the columns you want
 where  code = countrycode                   -- join condition - columns that match between teh tables
   and  code = 'USA'                         -- add other WHERE conditions to the join conditiond
;                                             
----------------------------------------------------------------------------------------
-- Modern Syntax join
----------------------------------------------------------------------------------------                                            
select country.name, city.name, district    -- columns you want to see in the result
  from country                              -- one of the tables to join
       join                                 -- type of join
       city                                 -- other table in the join  
    on code = countrycode                   -- join condition is coded on an ON (instead of a WHERE)                                                                 
 where code = 'USA'                         -- code any additional conditiosn on the WHERE (as always)
;                                             
                   
                   
                   
                   
                                             
                                             