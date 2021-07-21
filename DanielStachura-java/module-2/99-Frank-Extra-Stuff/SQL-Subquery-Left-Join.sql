--
-- Subquery Example -----------------------------------------------------------------------------------------------
-- **Be sure you are in the world database when you run this query**
--
-- A subquery is using a SELECT to retrive from one table to satisfy a WHERE clause in a SELECT
--
-- Looking up values in a table to substitute in a WHERE clause predicate
--
-- Usually a subquery is use with the WHERE IN clause - subquery may return multiple a list of values(multiple rows)
--                                                                                      (one column, multiple rows)
--
-- A subquery may be used with a WHERE = != < > if you are absolutley sure the subquery will only return one value
--
-- **It is safer to use an IN (rather than =) with subquery because it always works**
--
-- You can nest up to 32,766 subqueries (more than you ever need)
--
-- The subquery is run first and the result is pluigged in to the WHERE clause
--
--      Show the names of the countries that speak English
-- 
-- The name of the country is in the country table
-- The country codes of countries that speak English is in the countrylanguage table
--
-- 1. Get a list of the country codes that speak English from the country language table
-- 2. Take the list from step #1 and use it to search the country name to get the name of the country
--
select name
 from country
where code In(select countrycode from countrylanguage where language = 'English')
;








-- **This query needs the dvdstore database**
--
-- Show any actors we have in the actor table who are not in any films
-- in the film table (ie. no entry in the film_actor table)
--      Who is in the actor table, but not in the film_actor table?
--
-- 1. Add some test data to the actor table we know do not
--    have matches in the film_actor table;

Begin transaction; --starting a recoverable Unit of Work - want to be able to save/undo the changes

insert into actor (first_name, last_name) values('Agnes', 'Alexander');
insert into actor (first_name, last_name) values('Amber', 'Anthony');
insert into actor (first_name, last_name) values('Dana', 'Brian');
insert into actor (first_name, last_name) values('Aidan', 'Patrick');
insert into actor (first_name, last_name) values('Jared', 'Daniel');
insert into actor (first_name, last_name) values('Jess', 'Jared');
insert into actor (first_name, last_name) values('Josh', 'Lindsay');
insert into actor (first_name, last_name) values('Nia', 'Vanese');
insert into actor (first_name, last_name) values('Ruben', 'Java');
insert into actor (first_name, last_name) values('John', 'Frank');
insert into actor (first_name, last_name) values('Joiny', 'McJoinJoin');

--
--  2a. Problem solved with sub-query
--      Who is in the actor table, but not in the film_actor table?
-- 
-- actors in the fim_actor table are identified by actor_id
-- actors in the actor table are identified by actor_id

-- Which actor_id are in the actor table but not in the film_actor table?
--
-- We don't know the actual actor_id for any of the actors
-- We have to look in the actor table to fin the actor_id for the actors
--      and then see if they are not in the film_actor table
--
-- This is a job for subquery to get the list of actor_id from the actor table
--   and find which actor_id are not in the film_actor table

select actor_id
from actor
where actor_id not in(  select actor_id -- list of actor_id in the film_actor table
                        from film_actor )
;
--
-- 2b. Problem solved with left-join actor table to file_actor table
--
select actor.actor_id, first_name
from actor
left join
film_actor
on actor.actor_id = film_actor.actor_id
where film_actor.actor_id is null
;


--
-- 3. Reset table to original state before test data inserted
--
rollback; --undo any changes made since the start of the UOW - undo the inserts done before my test