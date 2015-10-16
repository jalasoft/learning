create table if not exists shovel(
  id bigint auto_increment,
  name varchar(20) not null,
  email varchar(20) default null,
  primary key (id)
);

create table if not exists motivation_index (
  id integer auto_increment,
  value integer not null check (value >= 0),
  name varchar(20) not null,
  primary key (id)
);

create table if not exists daily_motivation (
  id integer auto_increment,
  day date,
  shovel integer,
  index integer,
  primary key (id),
  foreign key (shovel) references shovel(id),
  foreign key (index) references motivation_index(id)
);

insert into motivation_index (value, name) values (0, 'pokus');
insert into motivation_index (value, name) values (1, 'pokus2');
insert into motivation_index (value, name) values (2, 'pokus3');