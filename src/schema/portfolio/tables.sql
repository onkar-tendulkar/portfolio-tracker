
CREATE TABLE security (
    id INT auto_increment,
    symbol VARCHAR(10) NOT NULL,
    name VARCHAR(250) NOT NULL,
    created_time timestamp NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE portfolio (
    id INT auto_increment,
    user_id INT,
    name VARCHAR(250) NOT NULL,
    created_time timestamp NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE portfolio_security (
   id INT auto_increment,
   portfolio_id INT NOT NULL,
   symbol varchar(10) NOT NULL,
   units INT NOT NULL,
   cost_per_unit FLOAT,
   date_purchased DATE,
   created_time timestamp NULL DEFAULT CURRENT_TIMESTAMP
);