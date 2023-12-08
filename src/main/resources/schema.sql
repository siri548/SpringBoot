CREATE TABLE restaurant(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250),
    address VARCHAR(250),
    cuisinetype VARCHAR(250),
    rating INT
);

CREATE TABLE chef(
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(250),
    lastname VARCHAR(250),
    expertise VARCHAR(250),
    experienceyears INT,
    restaurantid INT,
    FOREIGN KEY restaurantid REFERENCES restaurant(id);

);