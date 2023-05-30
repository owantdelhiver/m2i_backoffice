DROP DATABASE IF EXISTS technocomptoir2;
create database technocomptoir2;
use technocomptoir2;

create table admin
(
    id        int auto_increment
        primary key,
    lastname  varchar(50) not null,
    firstname varchar(50) null,
    email     varchar(50) null,
    password  varchar(50) null
);

create table adress
(
    id         int auto_increment
        primary key,
    street     varchar(255) null,
    number     int          null,
    zipcode    int          null,
    city       varchar(255) null,
    country    varchar(255) null,
    extra_info text         null
);

create table cart
(
    id int auto_increment
        primary key
);

create table cart_line
(
    id         int auto_increment
        primary key,
    quantity   int null,
    id_cart    int null,
    id_product int null
);

create index id_cart
    on cart_line (id_cart);

create index id_product
    on cart_line (id_product);

alter table cart_line
    add constraint cart_line_ibfk_1
        foreign key (id_cart) references cart (id);

create table order_line
(
    id         int auto_increment
        primary key,
    id_product int null,
    id_order   int null,
    quantity   int null
);

create index id_order
    on order_line (id_order);

create index id_product
    on order_line (id_product);

create table orders
(
    id      int auto_increment
        primary key,
    date    date        null,
    status  varchar(50) null,
    id_user int         null
);

alter table order_line
    add constraint order_line_ibfk_2
        foreign key (id_order) references orders (id);

create table product
(
    id                int auto_increment
        primary key,
    name              varchar(50)  null,
    price             float        null,
    short_description varchar(50)  null,
    description       varchar(255) null,
    stock             int          null,
    picture_url       text         null,
    id_category       int          null
);

alter table cart_line
    add constraint cart_line_ibfk_2
        foreign key (id_product) references product (id);

alter table order_line
    add constraint order_line_ibfk_1
        foreign key (id_product) references product (id);

create index id_category
    on product (id_category);

create table product_category
(
    id   int auto_increment
        primary key,
    name varchar(50) null
);

alter table product
    add constraint product_ibfk_1
        foreign key (id_category) references product_category (id);

create table role
(
    id   int          not null,
    name varchar(255) null
);

alter table role
    add primary key (id);

create table ticket
(
    id       int auto_increment
        primary key,
    email    varchar(255) null,
    message  varchar(255) null,
    admin_id varchar(255) null
);

create table user
(
    id        int auto_increment
        primary key,
    firstname varchar(255) null,
    lastname  varchar(255) null,
    email     varchar(255) null,
    password  varchar(255) null,
    id_adress int          null,
    id_cart   int          null
);

alter table orders
    add constraint orders_user_id_fk
        foreign key (id_user) references user (id);

create index id_adress
    on user (id_adress);

create index id_cart
    on user (id_cart);

alter table user
    add constraint user_ibfk_1
        foreign key (id_adress) references adress (id);

alter table user
    add constraint user_ibfk_2
        foreign key (id_cart) references cart (id);

create table user_role
(
    id_user int not null,
    id_role int not null
);

alter table user_role
    add primary key (id_user, id_role);

alter table user_role
    add constraint user_role___fk
        foreign key (id_user) references user (id);

alter table user_role
    add constraint user_role_role_id_fk
        foreign key (id_role) references role (id);

INSERT INTO role VALUES (1, 'USER');

INSERT INTO cart VALUES (1);

INSERT INTO adress VALUES (1, 'user street', 3, 44000, 'user city', 'user country', 'user adress');

INSERT INTO user VALUES (1, 'user', 'user', 'user@gmail.com', '$2a$10$pq63eXYA/4sq46.pkwZy1.j.6RGIf/x78G.FCTtdRri8rRnh20T2K', 1, 1);

INSERT INTO product_category VALUES (1, 'Ecran');
INSERT INTO product_category VALUES (2, 'Carte graphique');
INSERT INTO product_category VALUES (3, 'Processeur');

INSERT INTO product VALUES (1, 'Ryzen 7', 599.99, 'processeur ryzen de 7ème génération', 'Amd ryzen 7', 4, 'Ryzen7.jpg', 3);
INSERT INTO product VALUES (2, 'Rtx 3080', 890, 'Rtx 3080 gaming', 'Carte graphique MSI RTX 3080', 5, 'rtx3080.jpg', 2);

INSERT INTO user_role VALUES (1,1);

INSERT INTO orders VALUES (1, '2023-05-29', 'DELIVERY_IN_PROGRESS', 1);

INSERT INTO order_line VALUES (1,1,1,1);

INSERT INTO admin VALUES (1, 'ADMIN', 'admin', 'admin@gmail.com', 'admin');