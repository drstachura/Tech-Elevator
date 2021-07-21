Begin Transaction;

drop table if exists owner cascade;
drop table if exists pet cascade;
drop table if exists pet_type cascade;

--
--This illustrates use of a timestamp that is automatically set at INSERT for when added or updated
--
--It is the programmer job to be sure that any last update timestamps reflect the actual time of the last update
--

CREATE TABLE owner (
        ownerId       serial       NOT NULL,
        lastName      varchar(64)  NOT NULL,
        firstName     varchar(64)  NOT NULL,
        address       varchar(64)  ,
        city          varchar(64)  ,
        stateProvince varchar(24)  ,
        postalCode    varchar(10)  ,
        phone         char(20)     NOT NULL,
        whenAdded     timestamp    NOT NULL DEFAULT Current_Timestamp,  -- DEFAULT says use this value if one is not provided on INSERT
        lastUpdate    timestamp    NOT NULL DEFAULT Current_Timestamp,
        CONSTRAINT pk_owner_owner_id PRIMARY KEY (ownerId)
);

CREATE TABLE pet (
        petId         serial      NOT NULL,
        name          varchar(64) NOT NULL,
        petType       integer     NOT NULL,
        ownerId       integer     NOT NULL,
        whenAdded     timestamp   NOT NULL DEFAULT Current_Timestamp,
        lastUpdate    timestamp   NOT NULL DEFAULT Current_Timestamp,
        CONSTRAINT pk_pet_pet_id PRIMARY KEY (petId)
);

CREATE TABLE pet_type (  
        petTypeId      serial      NOT NULL,
        name           varchar(64) NOT NULL,
        whenAdded      timestamp   NOT NULL DEFAULT Current_Timestamp,
        lastUpdate     timestamp   NOT NULL DEFAULT Current_Timestamp,
        CONSTRAINT pk_pet_type_pet_type_id PRIMARY KEY (petTypeId)
);
--
-- Load Pet Types
--
INSERT INTO pet_type (name) VALUES ('Dog');
INSERT INTO pet_type (name) VALUES ('Cat');
INSERT INTO pet_type (name) VALUES ('Turtle');
INSERT INTO pet_type (name) VALUES ('Snake');
INSERT INTO pet_type (name) VALUES ('Rabbit');
INSERT INTO pet_type (name) VALUES ('Hamster');
INSERT INTO pet_type (name) VALUES ('Rat');
INSERT INTO pet_type (name) VALUES ('Horse');
INSERT INTO pet_type (name) VALUES ('Targ');
INSERT INTO pet_type (name) VALUES ('Cow');
INSERT INTO pet_type (name) VALUES ('Pig');
INSERT INTO pet_type (name) VALUES ('Iguana');
INSERT INTO pet_type (name) VALUES ('Sehlat');
INSERT INTO pet_type (name) VALUES ('Other');


--
--  Load Owner Table 
--
INSERT INTO owner (lastname, firstname, address, city, stateprovince, postalcode, phone) VALUES ('Potter', 'Harry', 'Hogwarts', null, null, null, 'the-wiz-ard1');
INSERT INTO owner (lastname, firstname, address, city, stateprovince, postalcode, phone) VALUES ('Kirk', 'James T.', 'Bridge', 'Enterprise', 'Milky Way', null, 'I-am-the-best');
INSERT INTO owner (lastname, firstname, address, city, stateprovince, postalcode, phone) VALUES ('McSpockSpock', 'Spocky', null, ' Shi''Kahr', 'Vulcan', null, 'Meld-4-U');
INSERT INTO owner (lastname, firstname, address, city, stateprovince, postalcode, phone) VALUES ('D''Android', 'Data', 'Deck 2, near Sickbay', 'Enterprise', 'Milky Way', null, 'Want-2-BHuman');
INSERT INTO owner (lastname, firstname, address, city, stateprovince, postalcode, phone) VALUES ('McAfAf', 'John', 'TE', 'Cleveland', 'OH', '44101', 'eye-chk-code');
INSERT INTO owner (lastname, firstname, address, city, stateprovince, postalcode, phone) VALUES ('Fonzerelli', 'Fonzie', 'Richies Garage', 'Milwaukee', 'WI', null, 'Ay-yyy-yyyy');
INSERT INTO owner (lastname, firstname, address, city, stateprovince, postalcode, phone) VALUES ('Son of Mogh', 'Worf', 'Deck 7, Sect. 25B', 'Enterprise', 'Milky Way', null, 'Is-Good-Day-2-Die');
--
-- Load pet table - NOTE: Must be done AFTER owner and pet_type table loads
--                        due to sub queries used in the INSERTs
--
INSERT INTO pet (name, pettype, ownerid) VALUES ('Voldemort',(select pettypeid from pet_type where name = 'Snake') , (select ownerid from owner where firstname = 'Harry' and lastname='Potter'));
INSERT INTO pet (name, pettype, ownerid) VALUES ('Spot'     ,(select pettypeid from pet_type where name = 'Cat')   , (select ownerid from owner where firstname = 'Data' and lastname='D''Android'));
INSERT INTO pet (name, pettype, ownerid) VALUES ('Ego'      ,(select pettypeid from pet_type where name = 'Horse') , (select ownerid from owner where firstname ilike 'James%'));
INSERT INTO pet (name, pettype, ownerid) VALUES ('I-Chaya'  ,(select pettypeid from pet_type where name = 'Sehlat'), (select ownerid from owner where firstname ilike 'Spock%'));
INSERT INTO pet (name, pettype, ownerid) VALUES ('Warrior'  ,(select pettypeid from pet_type where name = 'Targ')  , (select ownerid from owner where firstname ilike 'Worf%'));

--
-- Add foreign key constraints to tables
--

ALTER TABLE pet
ADD FOREIGN KEY(petType )
REFERENCES pet_type(petTypeId);

ALTER TABLE pet
ADD FOREIGN KEY (ownerId)
REFERENCES owner(ownerId);

Commit;