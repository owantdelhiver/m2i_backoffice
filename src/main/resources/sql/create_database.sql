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

CREATE TABLE orders(
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
                        FOREIGN KEY (id_order) REFERENCES orders(id)
);