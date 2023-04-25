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
                      email VARCHAR(50),
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