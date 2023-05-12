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
                        id_user INT,
                        PRIMARY KEY (id),
                        FOREIGN KEY(id_user) REFERENCES USER(id)

);

CREATE TABLE order_line
(
    id INT AUTO_INCREMENT,
    id_product INT,
    id_order INT,
    quantity INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id_product) REFERENCES product(id),
    FOREIGN KEY (id_order) REFERENCES `order`(id)
);

CREATE TABLE cart
(
    id INT AUTO_INCREMENT,
    PRIMARY KEY (id)
);

CREATE TABLE adress
(
    id int AUTO_INCREMENT,
    street VARCHAR(255),
    number int,
    zipcode int,
    city VARCHAR(255),
    country VARCHAR(255),
    extra_info TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE USER
(
    id INT AUTO_INCREMENT,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    id_adress INT,
    id_cart INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id_adress) REFERENCES adress(id),
    FOREIGN KEY (id_cart) REFERENCES cart(id)
);

CREATE TABLE cart_line
(
    id int AUTO_INCREMENT,
    quantity int,
    id_cart int,
    id_product int,
    PRIMARY KEY (id),
    FOREIGN KEY (id_cart) REFERENCES cart(id),
    FOREIGN KEY (id_product) REFERENCES product(id)
);