create database Project;

use Project;

create table if not exists customer(
	c_id int(10) not null primary key auto_increment,
	c_name varchar(255) collate utf8_unicode_ci not null,
    c_email varchar(255) not null,
    c_subject varchar(255) not null,
    c_message varchar(255) collate utf8_unicode_ci not null,
    c_sendto int(10) not null
) engine = InnoDB default charset=utf8 auto_increment=1;

select * from customer;

alter table customer add primary key (c_name);

create table if not exists admin(
	a_id int(10) not null primary key auto_increment,
    a_name varchar(255) not null,
	a_user varchar(255) not null,
    a_pass varchar(255) collate utf8_unicode_ci not null,
    a_permission int(10) not null
) engine = InnoDB default charset=utf8 auto_increment=1;

select * from admin;

alter table admin add primary key (a_id);

-- Auto_increment

alter table admin modify a_id int(10) not null auto_increment;

alter table customer modify c_id int(10) not null auto_increment;


insert into admin values(1,"t-r33t","admin","kqisenzust123!A!",1);
insert into admin values(2,"user","user","user123!@#",0);

insert into manager values(1,1);

-- delete row
delete from admin where a_id=1;

delete from customer where c_name='t2';

-- delete column 

alter table customer drop column c_sendto; 

alter table customer drop column c_id;

alter table admin drop column a_permission;