create table parsing_statistic
(
    id       serial not null
        constraint parsing_statistic_pkey
            primary key,
    url_name varchar
);

create table statistic_string
(
    url_id      integer
        constraint statistic_string_parsing_statistic_id_fk
            references parsing_statistic
            on update cascade on delete cascade,
    word_n      varchar,
    statistic_w integer
);
