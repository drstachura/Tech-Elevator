Begin Transaction;

----*Add DROP for each table*----
drop table if exists Employee                   cascade;          
drop table if exists Project                    cascade;         
drop table if exists Department                 cascade;
drop table if exists employee_project           cascade;
drop table if exists employee_department        cascade;

----*Create Base Tables*----
create table Employee
(employeeId serial not null
,first_name varchar (50)
,last_name varchar (50)
,job_title varchar (100)
,gender char (1)
,DOB date
,date_of_hire date
,constraint pk_employee_employeeId Primary Key (employeeId)
)
;
create table Project
(projectId serial not null
,project_name varchar (500)
,start_date date
,constraint pk_project_projectId Primary Key (projectId)
)
;
create table Department
(departmentId serial not null
,department_name varchar (500)
,constraint pk_department_departmentId Primary Key (departmentId)
)
;

----*Create RELATOR Tables and add FOREIGN KEY*----
create table employee_project
(employeeId integer not null
,projectId integer not null
,constraint pk_employee_project_employeeId_project_id Primary Key(employeeId, projectId)
)
;
create table employee_department
(employeeId integer not null
,departmentId integer not null
,constraint pk_employee_department_employeeId_department_id Primary Key(employeeId, departmentId)
)
;
alter table employee_project add foreign key (employeeId) references employee(employeeId);
alter table employee_project add foreign key (projectId) references project(projectId);
alter table employee_department add foreign key (employeeId) references employee(employeeId);
alter table employee_department add foreign key (departmentId) references department(departmentId);

----*Add 8 Employee*----
insert into Employee
(first_name,last_name,job_title,gender,dob,date_of_hire)
values ('Mt','Dew','Energize','M','11/12/1987','05/20/2020');
insert into Employee
(first_name,last_name,job_title,gender,dob,date_of_hire)
values ('Dr','Pepper','Flavor','F','06/14/1990','05/20/2020');
insert into Employee
(first_name,last_name,job_title,gender,dob,date_of_hire)
values ('Sierra','Mist','Refresh','F','09/24/1980','10/15/1995');
insert into Employee
(first_name,last_name,job_title,gender,dob,date_of_hire)
values ('Seven','Up','Refresh','F','09/24/1980','04/01/1996');
insert into Employee
(first_name,last_name,job_title,gender,dob,date_of_hire)
values ('Coca','Cola','Remedy','M','02/29/1960','06/15/1985');
insert into Employee
(first_name,last_name,job_title,gender,dob,date_of_hire)
values ('Pepsi','Cola','Quench','M','02/28/1963','08/13/1990');
insert into Employee
(first_name,last_name,job_title,gender,dob,date_of_hire)
values ('Orange','','Delicious','M','01/01/1990','08/13/2021');
insert into Employee
(first_name,last_name,job_title,gender,dob,date_of_hire)
values ('Ginger','Ale','Settler','F','02/17/1950','07/01/1970');

----*Add 4 Project*----
insert into Project
(project_name,start_date)
values ('Advertising','01/01/1971');
insert into Project
(project_name,start_date)
values ('Sales','01/01/1972');
insert into Project
(project_name,start_date)
values ('Research','07/01/1970');
insert into Project
(project_name,start_date)
values ('Audit','06/14/2021');

----*Add 3 Department*----
insert into Department
(department_name)
values ('Marketing');
insert into Department
(department_name)
values ('Sales');
insert into Department
(department_name)
values ('Accounting');

----*Add at least 1 employee to each Project*----
insert into employee_project
(employeeId, projectId)
values ((select employeeId from employee where first_name = 'Mt')
,       (select projectId from project where project_name = 'Research'));
insert into employee_project
(employeeId, projectId)
values ((select employeeId from employee where first_name = 'Dr')
,       (select projectId from project where project_name = 'Sales'));
insert into employee_project
(employeeId, projectId)
values ((select employeeId from employee where first_name = 'Orange')
,       (select projectId from project where project_name = 'Audit'));
insert into employee_project
(employeeId, projectId)
values ((select employeeId from employee where first_name = 'Ginger')
,       (select projectId from project where project_name = 'Advertising'));
        
----*Add at least 2 employee to each Department*----
insert into employee_department
(employeeId, departmentId)
values ((select employeeId from employee where first_name = 'Sierra')
,       (select departmentId from department where department_name = 'Accounting'));
insert into employee_department
(employeeId, departmentId)
values ((select employeeId from employee where first_name = 'Coca')
,       (select departmentId from department where department_name = 'Marketing'));
insert into employee_department
(employeeId, departmentId)
values ((select employeeId from employee where first_name = 'Pepsi')
,       (select departmentId from department where department_name = 'Marketing'));
insert into employee_department
(employeeId, departmentId)
values ((select employeeId from employee where first_name = 'Dr')
,       (select departmentId from department where department_name = 'Sales'));
insert into employee_department
(employeeId, departmentId)
values ((select employeeId from employee where first_name = 'Mt')
,       (select departmentId from department where department_name = 'Sales'));
insert into employee_department
(employeeId, departmentId)
values ((select employeeId from employee where first_name = 'Seven')
,       (select departmentId from department where department_name = 'Accounting'));
insert into employee_department
(employeeId, departmentId)
values ((select employeeId from employee where first_name = 'Orange')
,       (select departmentId from department where department_name = 'Accounting'));
insert into employee_department
(employeeId, departmentId)
values ((select employeeId from employee where first_name = 'Ginger')
,       (select departmentId from department where department_name = 'Marketing'));


commit;
--Rollback;

select projectId, count(*) from employee_project
group by projectId
;
select departmentId, count(*) from employee_department
group by departmentId
;
