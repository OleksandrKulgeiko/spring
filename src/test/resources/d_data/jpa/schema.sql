drop table if exists blogger;
drop table if exists post;

create table blogger (
  id identity,
  username varchar(25) not null,
  password varchar(25) not null,
  fullName varchar(100) not null,
  email varchar(50) not null,
  updateByEmail boolean not null,
  status varchar(10) not null
);

create table post (
  id integer identity primary key,
  blogger integer not null,
  message varchar(2000) not null,
  postedTime datetime not null,
  foreign key (blogger) references blogger(id)
);