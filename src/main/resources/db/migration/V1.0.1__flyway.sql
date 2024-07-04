create table Company (
                         id bigint not null,
                         domicileAddressAdditionalInfo varchar(255),
                         domicileAddressCity varchar(255),
                         domicileAddressCountry varchar(255),
                         domicileAddressNumber varchar(255),
                         domicileAddressPostalCode varchar(255),
                         domicileAddressStreet varchar(255),
                         name varchar(255),
                         status varchar(255) check (status in ('DRAFT','IN_PROGRESS','DOCUMENTS_PENDING')),
                         taxInformation jsonb,
                         website_id bigint,
                         primary key (id)
);

create table Website (
                         id bigint not null,
                         domain varchar(255),
                         primary key (id)
);

alter table if exists Company
    drop constraint if exists company_website_id_uniq;

alter table if exists Company
    add constraint company_website_id_uniq unique (website_id);

create sequence Company_SEQ start with 1 increment by 50;

create sequence Website_SEQ start with 1 increment by 50;

alter table if exists Company
    add constraint company_website_fk
        foreign key (website_id)
            references Website;
