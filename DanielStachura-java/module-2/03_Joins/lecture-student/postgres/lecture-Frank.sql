--
-- Frank's JOIN lecture code
--
-- This SQL uses the world database - be sure you run it in ther world database
--
-- Show the country name, city name, district for all the cities
--
--      we need data from the country table (country name) and city table (city name and district)
--      **Need to access 2 Tables
--
--      if coulmn names are not uniques between the tables, put tablename. in front of the column name
--
--      The join-condition is what matches between the talbes
--
--      The order of the tables for the join doesn't matter - database managers do that for you
--
-- There are 2 formats for coding a JOIN:
--      1. Classic syntax - code all tables for the join on the FROM
--                              and the join condition on the WHERE
--                            ONLY an INNER JOIN may be done
--                             Works if you forget the conditions - NOT CORRECTLY (not a join) but it runs
--                              if you forget the join condition result is a Cartersian Product
--                                (each row from one table is produced for every row in the other)
--                                (the number of rows in the result = #-rows-in-one-table * #-rows-in-other-table
--                                (if you try to join a 1000 row table to a 1000 row table without 
--                                      a JOIN condition you will get 1000000 rows in the result)
--                                (since a JOIN is used to show matching data between tables, a Cartersian Product is NOT a join)
--
--      2. Mordern syntax - code the type of JOIN between the tables instead of a comma
--                              and the join condition is coded on an ON statement not WHERE
--                            ANY type of JOIN may be done
--                              Error if you forget the join condition
--
----------------------------------------------------------------------------------------------------------------
-- Classic Syntax JOIN
----------------------------------------------------------------------------------------------------------------
select country.name, city.name, district         -- columns you want in the result
from city, country                               -- table(s) with the columns you want
where code = countrycode                         -- JOIN condition - columns that match between the tables
    and code = 'USA'                             -- add other WHERE conditions to the JOIN condition
                                                 -- code in country matches to the countrycode in city
;

----------------------------------------------------------------------------------------------------------------
-- Mordern Syntax JOIN
----------------------------------------------------------------------------------------------------------------
select country.name, city.name, district        -- columns you want in the result
from city                                       -- on of the table to join                                                  
     join                                       -- type of join - instead of the comma, use the word join
     country                                    -- other table in the join
  on code = countrycode                         -- join condition is coded on an ON (instead of a WHERE)
where code = 'USA'                              -- code any additional conditions on thr WHERE (as always)
;









