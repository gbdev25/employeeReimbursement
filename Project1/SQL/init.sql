


drop table if exists reimbursement_status cascade
create table if not exists reimbursement_status(
status_id serial primary key,
status varchar(30) default 'pending'
);

insert into reimbursement_status (status) values('accepted');
insert into reimbursement_status (status) values('rejected');
insert into reimbursement_status (status) values('pending');



drop table if exists reimbursement_type cascade
create table if not exists reimbursement_type(
type_id serial primary key,
type varchar(30) default 'other'
);

insert into reimbursement_type ("type") values('travel');
insert into reimbursement_type ("type") values('lodging');
insert into reimbursement_type ("type") values('food');
insert into reimbursement_type ("type") values('other');

drop table if exists user_role
create table if not exists user_role(
user_role_id serial primary key,
user_role varchar(30) 
);
insert into user_role(user_role) values('manager');
insert into user_role(user_role) values ('employee');
insert into user_role(user_role) values ('placeholder');


drop table if exists users;
create table if not exists users(
id serial primary key,
username varchar(30) unique,
password varchar(30) not null,
role varchar(30)
);

insert into users (username, password, role) values ('manager', 'password', 'manager');
insert into users (username, password, role) values ('employee', 'password', 'employee');
insert into users (username, password, role) values ('john ','password1', 'employee');
insert into users (username, password, role) values ('jack', 'password2', 'employee');
insert into users (username, password, role) values ('jane', 'password3', 'employee');




drop table if exists reimbursement cascade
create table if not exists reimbursement(
reimbursement_id serial primary key,
amount int,
description text,
author varchar(30) references users(username),
resolver varchar(30) references users(username),
status_id int references reimbursement_status(status_id),
type_id int references reimbursement_type(type_id)
);

insert into reimbursement (amount, description, author, resolver,status_id, type_id) values(100, 'description', 'employee','manager', 1, 1);
insert into reimbursement (amount, description, author, type_id) values(50,'description','employee', 2);
insert into reimbursement (amount, description, author) values(300,'description', 'jane');
