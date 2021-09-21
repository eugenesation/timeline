create table role_table
(
    id   bigserial   not null
        constraint role_table_pk
            primary key,
    name varchar(20) not null
);

alter table role_table
    owner to postgres;

create table user_table
(
    id       bigserial not null
        constraint user_table_pk
            primary key,
    login    varchar(50) unique,
    password varchar(500),
    role_id  integer
        constraint user_table_role_table_id_fk
            references role_table
);

alter table user_table
    owner to postgres;

create unique index user_table_login_uindex
    on user_table (login);


create table posts
(
    id      bigserial primary key not null,
    content varchar(255) not null
);

insert into role_table(name)
values ('ROLE_ADMIN');
insert into role_table(name)
values ('ROLE_USER');