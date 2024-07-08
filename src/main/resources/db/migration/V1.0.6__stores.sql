create table CompanyStore (
                              extraCol varchar(255),
                              store_id bigint not null,
                              company_id bigint not null,
                              primary key (company_id, store_id)
);

create table Store (
                       id bigint not null,
                       country varchar(255),
                       street varchar(255),
                       primary key (id)
);

create sequence Store_SEQ start with 1 increment by 50;

alter table if exists CompanyStore
    add constraint FKjfequ9n658yiokvsj8ihmvtkm
        foreign key (company_id)
            references Company;

alter table if exists CompanyStore
    add constraint FK3vnpoymdtfuogdblj20atpicx
        foreign key (store_id)
            references Store;
