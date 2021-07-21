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
--      so we can run this entire set of SQL to re-create our tables at any time
drop table if exists artist             cascade;          --'if exists' will work even if the table doesn't exists
drop table if exists painting           cascade;          --      and has dependents
drop table if exists artist_painting    cascade;

create table artist                     --table names are usually singular
(artistId   serial  not null ,          --unique id for an artist; serial means postgress will generate a unique integer value
artistName character varying(50)        --name of the artist; allow for variable size names
                                                --a maximum size may be specified; if no max size, 32767 is assumed
                                                --it is more efficient if you set a max size rather tyhan let it assume 32767
-- add primary key to the table using the Primary Key Constraint
-- constraint name is usually formatted: abbreviation-of-constraint_table-name_column(s)
--             constraint name    constraint  constraint-definition
, Constraint pk_artist_artistid Primary Key (artistId)  --tell postgres that artistId 
)
;
--
-- Create the painting table
--
create table Painting
(paintingId serial not null                      --database generated unique integer
,paintingTitle character varying(100) not null   --allow up to 100 character title
--decimal (total-#-digits, #-decimal-places)
,purchasePrice decimal(12,2) not null            --maximum purchase price allowed: 1,000,000,000.00 (12 digits with 2 decimal places)
,constraint pk_painting_paintingid primary key (paintingId)
)
;
--
-- create the artist/painting relator table
--
create table artist_painting
(artistId integer not null              --these will match columns in another table because they are foreign keys
,paintingId integer not null            --      did not use serial because we dont want a new unique value, one is already created
,constraint pk_artist_painting_artist_id_painting_id Primary Key(artistId, paintingId)
)
;
--
--Use the ALTER statement to add a FOREIGN KEY constraint to the artist_painting table
--      since it is a dependent of both the artist and painting table
-- **Need one ALTER for each FOREIGN KEY**
--
-- Typically add FOREIGN KEYS AFTER all the tables are created so the order of create tables doesn't matter
--      **Parent Tables must be created before dependents if you don't**
--
--  ALTER TABLE dependent-table-name ADD FOREIGN KEY(for-key-column(s)) REFERENCES parent-table(pri-key-column(s));
--              dependent               col-in-dependent          parent(pri-key-of-parent)
alter table artist_painting add foreign key (artistId) references artist(artistId);
--              dependent               col-in-dependent          parent(pri-key-of-parent)
alter table artist_painting add foreign key (paintingId) references painting(paintingId);
--
-- now that we have some tables - lets put some data in them!
--
insert into artist
(artistname)
values('Batman')   -- we only need to specify the non-database generated or not null columns - artistId will be generated
;

insert into painting
(paintingtitle, purchaseprice)
values('The Starry Dark Knight', 12000000)        -- we only need to specify the non-database generated or not null columns - paintingId will be generated
;

insert into painting
(paintingtitle, purchaseprice)
values('Gotham', 5000000)        -- we only need to specify the non-database generated or not null columns - paintingId will be generated
;
--
--let's add a row to artist_painting for each of our paintings by Batman
-- remember the database manager generated the artistId and paintingId so we don't know what they are
insert into artist_painting
(artistId, paintingId) 
values ((select artistId from artist where artistname = 'Batman') 
,       (select paintingId from painting where paintingtitle = 'Gotham'))
;

insert into artist_painting
(artistId, paintingId) 
values ((select artistId from artist where artistname = 'Batman') 
,       (select paintingId from painting where paintingtitle = 'The Starry Dark Knight'))
;

--rollback;
commit;