CREATE DATABASE technocomptoir;
USE technocomptoir;

CREATE TABLE product_category(
                                 id INT AUTO_INCREMENT,
                                 name VARCHAR(50),
                                 PRIMARY KEY(id)
);

CREATE TABLE admin(
                      id INT AUTO_INCREMENT,
                      lastname VARCHAR(50) NOT NULL,
                      firstname VARCHAR(50),
                      email VARCHAR(50) UNIQUE,
                      password VARCHAR(50),
                      PRIMARY KEY(id)
);

CREATE TABLE product(
                        id INT AUTO_INCREMENT,
                        name VARCHAR(50),
                        price DECIMAL(15,2),
                        short_description VARCHAR(50),
                        description VARCHAR(255),
                        stock INT,
                        picture_url TEXT,
                        id_category INT,
                        PRIMARY KEY(id),
                        FOREIGN KEY(id_category) REFERENCES product_category(id)
);

CREATE TABLE `order`(
                       id INT AUTO_INCREMENT,
                       date DATE,
                       status VARCHAR(50),
                       PRIMARY KEY (id)

);

CREATE TABLE orderLine
(
                        id INT AUTO_INCREMENT,
                        id_product INT,
                        id_order INT,
                        quantity INT,
                        PRIMARY KEY (id),
                        FOREIGN KEY (id_product) REFERENCES product(id),
                        FOREIGN KEY (id_order) REFERENCES `order`(id)
);

create table role
(
    id int not null ,
    name varchar(255),
    PRIMARY KEY (id)
);

create table user_role
(
    id_user int not null,
    id_role int not null,
    constraint user_role_pk
        primary key (id_user, id_role),
    constraint user_role___fk
        foreign key (id_user) references user (id),
    constraint user_role_role_id_fk
        foreign key (id_role) references role (id)
);