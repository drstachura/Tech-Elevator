-- Keys, Joins and Unions
--
-- Primary Key - a column or set of columns that uniquely identify a row in a table (Parent table)
-- Foreigh Key - a column or set of columns that match the primary key of another table (Dependent table)
--
-- Foreign Key and Primary are typically used in join conditions between teh tables
-- a join matches rows between tables, so Primary Key, Foreign are obviously good to use in a join conditions
--
-- Natural Key   - Value(s) that exist for a table that can be used as primary keys
-- Surrogate Key - Artificially generated keys to use as a primary key
--
--  Joins are used when columns from multiple tables are required in a query
--
-- INNER JOIN - Matching rows between tables 
--       JOIN  
--
-- LEFT JOIN  - Difference between tables, what's in one table but not the other
-- 
-- OUTER JOIN - All rows from both tables - the full set      
------------------------------------------------------------------------------------------------
-- Inner Join syntax - 2 forms
-- 
--  SELECT columns
--    FROM table1, table2  
--  WHERE table1.column = table2.column  
--
-- If you omit join conditions the result is Cartersian Product
--    each from one table with each row in the other - IT'S NOT A JOIN
--
-- minimum # conditions on WHERE = # tables - 1
--
--  SELECT columns
--    FROM table1
--         INNER JOIN
--         table2
--      on table1.column = table2.column
--
-- Additional WHERE predicates may be added to either syntax to filter rows
------------------------------------------------------------------------------------------------
-- -- OUTER JOIN syntax 
--
--  SELECT columns
--    FROM table1
--         FULL OUTER JOIN
--         table2
--      on table1.column = table2.column
--
-- Additional WHERE predicates may be added to either syntax to filter rows
------------------------------------------------------------------------------------------------
-- UNION - Merging rows between two tables
--
-- Each SELECT must have the same number of columns in the same order and be compatible datatypes 
--      use literals if necessary to make the UNION work
--
-- SELECT columns
--   FROM table1
-- WHERE predicate
--
-- UNION
--
-- SELECT columns
--   FROM table2
-- WHERE predicate
------------------------------------------------------------------------------------------------
--
-- UNION All - Concatenating rows between two tables
--
-- Each SELECT must have the same number of columns in the same order and be compatible datatypes 
--      use literals if necessary to make the UNION work
--
-- SELECT columns
--   FROM table1
-- WHERE predicate
--
-- UNION ALL
--
-- SELECT columns
--   FROM table2
-- WHERE predicate
------------------------------------------------------------------------------------------------
-- ********* INNER JOIN ***********

-- Show the last_name of all the actors in the movie FINDING ANACONDA
--
-- Need data from actor table (last_name) and the film table (title)
-- Since I need data from more than one table - it's a join
-- I need to match data from actor table to film table - a match means inner join
-- What matches bewteen the actor table and film table - NOTHING
-- Since nothing matches between the tables can I use another table to connect them? Yes - film_actor table
-- We need to connect three tables (film, actor, film_actor) to get the information need - 2 joins

select last_name  -- column(s) we want to see in the result
  from film       -- connect the film table
       inner join -- to
       film_actor -- film_actor table
    on film_actor.film_id = film.film_id -- based on the film_id in both (join condition - what matches)
       inner join -- then connect the result
       actor      -- to the actor table 
    on film_actor.actor_id = actor.actor_id    -- based on the actor_id in film_actor and actor_id in actor
 where title = 'FINDING ANACONDA'        -- only for film titled FINDING ANACONDA
;
--
-- A nick name (correlation name or alias) may be assigned to the tables make coding easier
-- code the nick name after the table where you code it
-- Use the nickname / alias / correlation name in place of th table name in the query
--e
select last_name       -- column(s) we want to see in the result
  from film f          -- connect the film table (nicknamed 'f')
       inner join      -- to
       film_actor fa   -- film_actor table (nicknamed 'fa')
    on fa.film_id = f.film_id -- based on the film_id in both (join condition - what matches)
       inner join      -- then connect the result
       actor a         -- to the actor table (nicknamed 'a')
    on fa.actor_id = a.actor_id    -- based on the actor_id in film_actor and actor_id in actor
 where title = 'FINDING ANACONDA'  -- only for film titled FINDING ANACONDA
;

-- Let's find out who made payment 16666:

-- Ok, that gives us a customer_id, but not the name. We can use the customer_id to get the name FROM the customer table

-- We can see that the * pulls back everything from both tables. We just want everything from payment and then the first and last name of the customer:

-- But when did they return the rental? Where would that data come from? From the rental table, so let’s join that.

-- What did they rent? Film id can be gotten through inventory.

-- What if we wanted to know who acted in that film?

-- What if we wanted a list of all the films and their categories ordered by film title
--
-- title from film table
-- category from category table
-- multiple tables - that's a join
-- what matches between film and category? NOTHING
-- Is there another tbale we can use to connect them? YES! - film_category table

select title, name  -- I want to the title of the film and the name of the category it is in
  from film         -- connect the film table
       inner join   -- to
       film_category-- the film_category table
    on film.film_id = film_category.film_id  -- based on their film_ids
       inner join   -- then connect the result
       category     -- to the category table 
    on category.category_id = film_category.category_id  -- based on their category_ids
 order by title     -- Sequence the result by film title
;






-- Show all the 'Comedy' films ordered by film title

-- Finally, let's count the number of films under each category

-- ********* LEFT JOIN ***********

-- (There aren't any great examples of left joins in the "dvdstore" database, so the following queries are for the "world" database)

-- A Left join, selects all records from the "left" table and matches them with records from the "right" table if a matching record exists.

-- Let's display a list of all countries and their capitals, if they have some.

-- Only 232 rows
-- But we’re missing entries:

-- There are 239 countries. So how do we show them all even if they don’t have a capital?
-- That’s because if the rows don’t exist in both tables, we won’t show any information for it. If we want to show data FROM the left side table everytime, we can use a different join:

-- *********** UNION *************

-- Back to the "dvdstore" database...

-- Gathers a list of all first names used by actors and customers
-- By default removes duplicates

-- Gather the list, but this time note the source table with 'A' for actor and 'C' for customer
