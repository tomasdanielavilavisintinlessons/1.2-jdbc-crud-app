create database jdbccrudapp;

use jdbccrudapp;

create table people(
id int primary key auto_increment,
name varchar(250),
surname varchar(250),
age int
);