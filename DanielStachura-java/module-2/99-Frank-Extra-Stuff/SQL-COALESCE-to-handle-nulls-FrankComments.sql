------------------------------------------------------------------------------------------------------
-- The postgresSql COALESCE function may be used to replace a null value with a known value
--     to avoid either an error or a null result - any operation involving a null is a null
-- ie. Provide a default value if a column is null
--
-- Syntax:  COALESCE(value1, value2, value3...valuen)
--
-- How it works:  COALESCE will return the first non-null value in the list of arguments it is given
--
-- To provide a default value:  COALESCE(column-name, default-value)
--
------------------------------------------------------------------------------------------------------
begin transaction;   -- start a unit of work
--
-- Provide a default value of 0 if lifeexpectancy is null
--
Select name
     , lifeexpectancy               -- shown to verify test
     , COALESCE(lifeexpectancy, 0)  -- return a 0 if lifeexpectancy column is null
  from country
 where lifeexpectancy is Null  -- used in this example to test COALESCE
 ;
--
-- setup for the following example
--
update country 
   set gnp = null 
 where code In('GBR', 'ALB', 'BEL', 'GAB', 'TUV', 'MYT', 'MCO', 'NIU', 'GUF');
--
-- Perform a calculation when either or both or two values eiher of which might be null
-- If neither are null - perform the calculation
-- If one is null, return the one that is not null
-- If both are null, return 0
--
-- Example:   COALESCE(gnp-gnpold, gnp, gnpold, 0)  -- give me the first value in the list that is not null
--
--  result:   gnp      gnp-old      result
--            100      25            75      75,    100,   25, 0   - gnp-oldgnp was the first non-null in the list
--            null     50            50      null, null,   50, 0   - oldgnp was the first non-null in the list
--            100      null         100      null, 100,  null, 0   - gnp was the first non-null inthe list
--            null     null           0      null, null, null, 0   - 0 (the default value) was first non-null
--
Select name
      ,gnp
      ,gnpold
      ,COALESCE(gnp-gnpold, gnp, gnpold, 0) as gnp_diff
 from country
 where (gnp is null or gnpold is null)  -- used in this example to test COALESCE  
    or gnp > 3000000                    -- limit result set for example
 order by gnp DESC                      -- sort to make resuly easier to see
 ;
 --
 -- Rollback setup done for example
 --
 rollback;   -- undo any changes done in the unit of work
 --
 end transaction;   -- end of the unit of work