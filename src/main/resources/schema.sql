create table if not exists product(
    productId INT PRIMARY KEY AUTO_INCREMENT,
    productName VARCHAR(250),
    price DOUBLE
);

create table if not exists review(
    reviewId INT PRIMARY KEY AUTO_INCREMENT,
    reviewContent VARCHAR(250),
    rating INT,
    productId INT,
    FOREIGN KEY(productId) REFERENCES product(productId) 

);