create table Company_Product (
                                 Company_id bigint not null,
                                 products_id bigint not null
);

create table Product (
                         id bigint not null,
                         price integer not null,
                         productName varchar(255),
                         primary key (id)
);

create sequence Product_SEQ start with 1 increment by 50;

alter table if exists Company_Product
    add constraint company_product_products_fk
        foreign key (products_id)
            references Product;

alter table if exists Company_Product
    add constraint company_product_company_fk
        foreign key (Company_id)
            references Company;
