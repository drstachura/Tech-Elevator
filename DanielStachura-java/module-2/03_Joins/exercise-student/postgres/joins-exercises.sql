-- The following queries utilize the "dvdstore" database.
--      **WILL HAVE 4,5,6 TABLE JOINS**

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
select title
from film
        inner join
        film_actor
        on film_actor.film_id = film.film_id
        inner join
        actor
        on film_actor.actor_id = actor.actor_id
 where actor.actor_id = 44
;
-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
select title
from film
        inner join
        film_actor
        on film_actor.film_id = film.film_id
        inner join
        actor
        on film_actor.actor_id = actor.actor_id
 where actor.actor_id = 135
;
-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
select title
from film
        inner join
        film_actor
        on film_actor.film_id = film.film_id
        inner join
        actor 
        on film_actor.actor_id = actor.actor_id
where actor.actor_id = 143 or actor.actor_id = 35
;
-- 4. All of the the Documentary films
-- (68 rows)
select title
from film
        inner join
        film_category
        on film.film_id = film_category.film_id
        inner join
        category
        on category.category_id = film_category.category_id
where name = 'Documentary'
;
-- 5. All of the Comedy films
-- (58 rows)
select title
from film
        inner join
        film_category
        on film.film_id = film_category.film_id
        inner join
        category
        on category.category_id = film_category.category_id
where name = 'Comedy'
;
-- 6. All of the Children films that are rated G
-- (10 rows)
select title, rating
from film
        inner join
        film_category
        on film.film_id = film_category.film_id
        inner join
        category
        on category.category_id = film_category.category_id
where name = 'Children' and rating = 'G'
;
-- 7. All of the Family films that are rated G and are less than 2 hours in length
-- (3 rows)
select title, rating, length
from film
        inner join
        film_category
        on film.film_id = film_category.film_id
        inner join
        category
        on category.category_id = film_category.category_id
where name = 'Family' and rating = 'G' and length < 120
;
-- 8. All of the films featuring actor Matthew Leigh that are rated G
-- (9 rows)
select title, rating
from film
        inner join
        film_actor
        on film.film_id = film_actor.film_id
        inner join
        actor
        on film_actor.actor_id = actor.actor_id
where actor.actor_id = 103 and rating = 'G'
;
-- 9. All of the Sci-Fi films released in 2006
-- (61 rows)
select title, release_year
from film
        inner join
        film_category
        on film.film_id = film_category.film_id
        inner join
        category
        on film_category.category_id = category.category_id
where name = 'Sci-Fi'and film.release_year = '2006'
;
-- 10. All of the Action films starring Nick Stallone
-- (2 rows)
select title 
from film
        inner join
        film_category
        on film.film_id = film_category.film_id
        inner join
        category
        on film_category.category_id = category.category_id
        inner join film_actor
        on film.film_id = film_actor.film_id
        inner join
        actor
        on film_actor.actor_id = actor.actor_id
where category.name = 'Action' and actor.actor_id = 44
;
-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
select address, city, district, country
from address
        inner join city
        on address.city_id = city.city_id
        inner join country
        on city.country_id = country.country_id
        inner join store
        on address.address_id = store.address_id
;     
-- 12. A list of all stores by ID, the stores street address, and the name of the stores manager
-- (2 rows)
select store.store_id, address, first_name, last_name
from store
        inner join address
        on store.address_id = address.address_id
        inner join staff
        on store.store_id = staff.store_id
;
-- 13. The first and last name of the top ten customers ranked by number of rentals
-- (#1 should be ELEANOR HUNT with 46 rentals, #10 should have 39 rentals)
select first_name, last_name, count(rental.customer_id)
from customer
        inner join rental
        on customer.customer_id = rental.customer_id
group by customer.first_name, customer.last_name, rental.customer_id
order by count desc
limit 10
;
-- 14. The first and last name of the top ten customers ranked by dollars spent
-- (#1 should be KARL SEAL with 221.55 spent, #10 should be ANA BRADLEY with 174.66 spent)

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that while a customer has only one primary store, they may rent from either store.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)

-- 16. The top ten film titles by number of rentals
-- (#1 should be BUCKET BROTHERHOOD with 34 rentals and #10 should have 31 rentals)

-- 17. The top five film categories by number of rentals
-- (#1 should be Sports with 1179 rentals and #5 should be Family with 1096 rentals)

-- 18. The top five Action film titles by number of rentals
-- (#1 should have 30 rentals and #5 should have 28 rentals)

-- 19. The top 10 actors ranked by number of rentals of films starring that actor
-- (#1 should be GINA DEGENERES with 753 rentals and #10 should be SEAN GUINESS with 599 rentals)

-- 20. The top 5 Comedy actors ranked by number of rentals of films in the Comedy category starring that actor
-- (#1 should have 87 rentals and #5 should have 72 rentals)
select first_name || ' ' || last_name as actor_name, count(i.film_id) as number_time_rented, c.name as movie_category
from film f
        inner join
        film_actor fa
       on f.film_id = fa.film_id
        inner join 
        actor a
       on fa.actor_id = a.actor_id
        inner join
        inventory i
       on f.film_id = i.film_id
        inner join
        rental r
       on i.inventory_id = r.inventory_id
        inner join
        film_category fc
       on f.film_id = fc.film_id
        inner join
        category c
       on fc.category_id = c.category_id
        where c.name = 'Comedy'
group by a.actor_id, c.name
order by number_time_rented desc
limit 5
;