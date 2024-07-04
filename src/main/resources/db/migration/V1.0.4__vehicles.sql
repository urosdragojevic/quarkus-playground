create table Vehicle (
                         id bigint not null,
                         model varchar(255),
                         company_id bigint,
                         primary key (id)
);

create sequence Vehicle_SEQ start with 1 increment by 50;

alter table if exists Vehicle
    add constraint vehicle_company_fk
        foreign key (company_id)
            references Company;
