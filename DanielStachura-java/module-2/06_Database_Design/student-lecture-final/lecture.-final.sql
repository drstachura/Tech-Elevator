---------------------------------------------------------------------------------------------------------------
--
-- DROP - remove a table and all it's data from the database
--
-- Consider referential constraints - cannot drop a parent if it has dependents
--
--      DROP TABLE table-name             - Will fail if table does not exist or if it has dependents
--
--      DROP TABLE IF EXISTS table-name   - Will run whether table exists or not; will fail if table has dependents
--
--      DROP TABLE IF EXISTS table-name  CASCADE   - Will run whether table exists or not and whether has dependents or not
--
--
--  CREATE - define a table to the database manager
--
--       CREATE TABLE table-name
--       (column-name     data-type    NOT NULL,
--        column-name     data-type,
--        column-name     data-type    DEFAULT   default-value,
--        column-name     data-type    UNIQUE,
--        CONSTRAINT constraint-name PRIMARY KEY (column(s)-in-table),
--        CONSTRAINT constraint-name FOREIGN KEY(for-key-column(s)) REFERENCES parent-table(pri-key-column(s)),
--        CONSTRAINT consraint-name  CHECK (where-predicate)
--       )
--
--       Note: CONTRAINT is part of the set of column definitions (i.e. inside the parens for column specification)
--
-- 
-- ALTER - changing the definition of a table
--
-- Commonly used to add/remove constraints on tables or change existing table attributes
--
--
-- Add a FOREIGN KEY - Establish Parent/Dependant relationship
--
-- FOREIGN KEY must have the same-number, same-order, compatible-data-type as entire PRIMARY KEY of parent
--             and must have a matching value in the PRIMARY KEY in the parent table
--
-- When adding FOREIGN KEY after data has been loaded into table, all FOREIGN KEY values must have a match in parent
--
--      ALTER TABLE dependent-table-name ADD FOREIGN KEY(for-key-column(s)) REFERENCES parent-table(pri-key-column(s)) 
--
-- Remove a constraint from a table
--
--      ALTER TABLE table-name DROP CONSTRAINT constraint_name
--
--
-- Add a column to an existing table
--
-- Cannot add a NOT NULL column to a table with existing data
--
--      ALTER TABLE table-name ADD COLUMN new_column_name data_type constraint
--
--
-- Rename an existing column in a table
--
--      ALTER TABLE table-name RENAME column-name TO new-column-name;
--
--
-- Rename a table
--
--      ALTER TABLE table-name RENAME TO new-table-name  - Will fail if table does not exist
--
--      ALTER TABLE IF EXISTS table-name RENAME TO new-table-name  - Successful if table exists or not
--
---------------------------------------------------------------------------------------------------------------
Begin transaction;

-- Drop any existing copies of the tables we are creating
--      so we can this entire set of SQL to re-create our tables at any time


drop table if exists artist          cascade;      -- Will work even if the does not exist
drop table if exists painting        cascade;     --      and if it has dependents
drop table if exists artist_painting cascade;

--
-- Creating the artist
--

create table artist             -- table names are usually singular
(artistId   serial   NOT NULL,       -- unique id for an artist; serial means postgres will generate a unique integer value
 artistName character varying(50),   -- name of the artist; allow for variable size names
                                     -- a maximum size may be specified; if no max size 32767 is assumed
                                     -- it more efficient if you set a max size rather than let it assume 32767
-- add primary key to the table using the PRIMARY_KEY constraint
-- constraint name usually formatted: abbrevation-of-constraint_table-name_columns(s)
--           constraint-name  constraint   constraint-definition
constraint pk_artist_artistid Primary Key (artistId)  -- tell postgres that artistId is the primary key
)
;


--
--  create the painting table
--

create table painting
(paintingId    serial   not null,                -- data base generated unique integer
 paintingTitle character varying(100) not null,  -- allow up to 100 character title
 -- decimal(total-#-digits, #-decimal-places)
 purchasePrice decimal(12,2)         not null,   -- maximum purchase allowed: +/1 9,999,999,999.99 (12 digits with 2 decimal places)
constraint pk_painting_paintingId Primary Key(paintingId)  -- tell the database manage the primary key
)
;

--
-- create the artist/painting relator table
--
create table artist_painting
(
artistnum     integer   not null,   -- these will match columns in another table because they are foreign key
paintingId    integer   not null,   --       did not use serial because we don't want a new unique value
Constraint pk_artist_painting_artist_id_painting_id Primary Key(artistnum, paintingId)
)
;

--
-- Use the ALTER statement to add a FOREIGN KEY constraints to the artist_painting table
-- since it is a dependent of both the artist and painting tables
-- Need one ALTER for each FOREIGN KEY
--
-- Typically add FOREIGN KEYS after all the all the tables are created so the order of create tables doesn't matter
-- Parent tables must be created before dependents if you don't
--
--           depenedent                   col-in-dependent        parent(pri-key-of-parent
 ALTER TABLE artist_painting ADD FOREIGN KEY(artistnum) REFERENCES artist(artistId) 
 ;
--           depenedent                   col-in-dependent        parent(pri-key-of-parent
 ALTER TABLE artist_painting ADD FOREIGN KEY(paintingId) REFERENCES painting(paintingId) 
 ;
--

-- now that we have some tables - lets put some data in them!

insert into artist
(artistname)
Values('Batman')  -- we only need to specify the non-database generated or not columns - artistid will be generated
;

insert into painting
(paintingtitle, purchaseprice)
values('The Starry Dark Night', 12000000)  -- we only need to specify the non-database generated or not columns - paintingid will be generated
;

insert into painting
(paintingtitle, purchaseprice)
values('Gotham', 5000000)  -- we only need to specify the non-database generated or not columns - paintingid will be generated
;

-- Lets add a row to artist_painting for each of our painting by Batman
-- Remember, the database manger generated the artistid and paintings ids, so we don't know that are

insert into artist_painting
(artistnum, paintingid) -- Frank called the column artistnum, if you called it artistid use artistid here
Values((select artistid   from artist   where artistname    = 'Batman')
      ,(select paintingid from painting where paintingtitle = 'Gotham'))
;

insert into artist_painting
(artistnum, paintingid) -- Frank called the column artistnum, if you called it artistid use artistid here
Values((select artistid from artist where artistname = 'Batman')
      ,(select paintingid from painting where paintingtitle = 'The Starry Dark Night'))
;
commit;
