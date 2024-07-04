create table Company_Person
(
    Company_id bigint not null,
    persons_id bigint not null
);

create table Person
(
    id        bigint not null,
    firstName varchar(255),
    lastName  varchar(255),
    role      varchar(255) check (role in ('CEO', 'CTO', 'CFO')),
    primary key (id)
);

alter table if exists Company_Person
    drop constraint if exists persons_id_uniq;

alter table if exists Company_Person
    add constraint persons_id_uniq unique (persons_id);

create sequence Person_SEQ start with 1 increment by 50;

alter table if exists Company_Person
    add constraint persons_fk
        foreign key (persons_id)
            references Person;

alter table if exists Company_Person
    add constraint company_fk
        foreign key (Company_id)
            references Company;
