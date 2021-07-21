-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**
--
-- Frank suggests making the entire exercise one transaction
--      because several exercises depend on previous exercises running
--      if you try to make smaller transactions, Frank says you will drive yourself nuts!
--      put a Begin Transaction; at the start and a rollback; at the end until you are sure
--      everything works ok if you want
--
-- **Ignore #12 until tomorrow...if you can't look at the end of today's lecture code
--
-- Consider running verifying selects before and/or after your insert/update/delete to see that they work
--      your changes will NOT be in the tables if you are doing a rollback;
-- 
-- Be sure you know what the data types of your columns are
-- Consider that some columns are generated by the database (serial) on insert - you don't need/want to specify them
--      you dont want to specify them, but you may need to know what they are
--
-- Remember the movie "Hunt for Red October"?  What were they always doing? ... a sub query!

begin transaction;
-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
insert into actor
(first_name, last_name)
values('Hampton' , 'Avenue')
;
insert into actor
(first_name, last_name)
values('Lisa' , 'Byway')
;
select * from actor;


-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
--begin transaction;

insert into film
(title
,description
,release_year
,language_id
,length)
values('Euclidean PI'
,'The epic story of Euclid as a pizza delivery boy in
ancient Greece',2008,1,196)
;

select * from film where title = 'Euclidean PI';


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
--begin transaction;      

insert into film_actor(actor_id,film_id)
values( (select actor_id from actor where first_name = 'Hampton'  and last_name = 'Avenue') 
,     (select film_id from film where title = 'Euclidean PI') )
;
insert into film_actor(actor_id,film_id)
values( (select actor_id from actor where first_name = 'Lisa' and  last_name = 'Byway') 
,     (select film_id from film where title = 'Euclidean PI') )
;

select * from film_actor;

    
-- 4. Add Mathmagical to the category table.
--begin transaction;

insert into category
(name)
values('Mathmagical')
;

select * from category;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
--begin transaction;

insert into film_category(film_id, category_id)
values( (select film_id from film where title = 'Euclidean PI')  
        , (select CATEGORY_ID from category where name = 'Mathmagical') )
;
insert into film_category
(film_id, category_id)
values( (select film_id from film where title = 'EGG IGBY')  
        , (select CATEGORY_ID from category where name = 'Mathmagical') )
;

insert into film_category
(film_id, category_id)
values( (select film_id from film where title = 'KARATE MOON')  
        , (select CATEGORY_ID from category where name = 'Mathmagical') )
;

insert into film_category
(film_id, category_id)
values( (select film_id from film where title = 'RANDOM GO')  
        , (select CATEGORY_ID from category where name = 'Mathmagical') )
;

insert into film_category
(film_id, category_id)
values( (select film_id from film where title = 'YOUNG LANGUAGE')  
        , (select CATEGORY_ID from category where name = 'Mathmagical') )
;


select * from film_category;
       

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)
--
--update film
--   set rating = 'G'
-- where title in ('Euclidean PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE')
--;

update film
   set rating = 'G'
 where title in ((select title 
                  from film 
                  where film_id in(select film_id 
                                   from film_category 
                                   where category_id in(select category_id
                                                        from category
                                                        where name = 'Mathmagical'))))
;

select rating from film where title = 'Euclidean PI';

-- 7. Add a copy of "Euclidean PI" to all the stores.
-- film to inventory via film_id where title = euclidean pi
--inventory id to store via store id
--begin transaction;
insert into inventory
(film_id, store_id)
values ((select film_id from film where title = 'Euclidean PI')
,      (1))
;
insert into inventory
(film_id, store_id)
values ((select film_id from film where title = 'Euclidean PI')
,      (2))
;
select inventory_id, film_id,store_id from inventory;
--rollback;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

--it did not delete because film_id is tied to other tables


--begin transaction;
--select title from film;
--delete from film
--where title = 'Euclidean PI'
--;
--select title from film;
--rollback;


-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

--it did not delete because category is tied to other tables

--begin transaction;
--select name from category;
--delete from category
--where name = 'Mathmagical'
--;
--select name from category;
--rollback;


-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.


rollback;