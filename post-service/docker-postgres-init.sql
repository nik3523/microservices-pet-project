-- Path: post-service\docker-postgres-init.sql
create table posts (
    id serial primary key,
    author_id varchar(255),
    posted_at DATE,
    text text
);

insert into posts (author_id, posted_at, text) values ('1', '2020-01-01', 'Hello World!');
insert into posts (author_id, posted_at, text) values ('1', '2020-02-11', 'Random text');
insert into posts (author_id, posted_at, text) values ('2', '2020-03-01', 'Lorem ipsum');
insert into posts (author_id, posted_at, text) values ('3', '2020-04-01', 'Dolor sit amet');
insert into posts (author_id, posted_at, text) values ('4', '2020-05-01', 'Consectetur adipiscing elit');
insert into posts (author_id, posted_at, text) values ('4', '2020-06-01', 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua');