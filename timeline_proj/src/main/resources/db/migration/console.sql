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
    id      bigserial primary key,
    content varchar(255) not null,
    user_id bigint       not null references user_table (id) on update cascade on delete cascade
);

insert into role_table(name)
values ('ROLE_ADMIN');
insert into role_table(name)
values ('ROLE_USER');

-- create table users
-- (
--     user_id  bigserial primary key,
--     login    varchar(50)                   not null unique,
--     password varchar(40)                   not null,
--     admin    boolean
--         constraint def_admin default false not null
-- );
--


-- create table likes
-- (
--     user_id bigint not null references users (user_id) on update cascade on delete cascade,
--     post_id bigint not null references posts (post_id) on update cascade on delete cascade,
--     constraint pk_like primary key (user_id, post_id)
-- )