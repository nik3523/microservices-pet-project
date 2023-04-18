create table users
(
    id            serial primary key,
    username      varchar(255),
    amount_of_posts int
);

insert into users (username, amount_of_posts) values ('Jack Daniels', 2);
insert into users (username, amount_of_posts) values ('John Doe', 1);
insert into users (username, amount_of_posts) values ('Jane Doe', 1);
insert into users (username, amount_of_posts) values ('John Smith', 2);
insert into users (username, amount_of_posts) values ('Jane Smith', 0);