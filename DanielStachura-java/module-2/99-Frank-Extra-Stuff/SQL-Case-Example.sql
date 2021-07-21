--
-- This SQL depends on the dvdstore database
--
-- The case statement is used to "decode" value in a database
--

select title
      ,rating
      , case rating
            when 'G'  then 'General Audiences'
            when 'PG' then 'Parental Guidance'
            when 'R'  then 'Restricted'
            when 'NC-17'  then 'No one under 17 admitted' 
            when 'PG-13'  then 'Parents Strongly Cautioned'
            else 'Un-rated'
        end
        as film_Rating
  from film
  ;
  
  select title
        ,length
        ,case
           when length between 0 and 60  then 'short - less that an hour'
           when length is null           then 'unknown'
           when length between 61 and 90 then 'medium'
           when length > 150             then 'bring a pillow'
           else                                'tolerable'
         end
         as length_comment
     from film
  ;