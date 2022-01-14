create database address_book_system;
use address_book_system;

create table address_book(
id int not null primary key auto_increment,
first_name varchar(20),
last_name varchar(20),
address varchar(100),
city varchar(20),
state varchar(20),
zip int,
phone_number long,
email varchar(20)
);

insert into address_book(first_name,last_name,address,city,state,zip,phone_number,email)
values ('Makrand','Shingare','Velapur','Solapur','Maharashtra',413113,9096592086,'makrand@gmail.com');

select * from address_book;

alter table address_book add column date_added date not null;