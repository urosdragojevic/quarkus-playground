alter table if exists Person
    add column company_id bigint;

alter table if exists Person
    add constraint person_company_fk
        foreign key (company_id)
            references Company;
