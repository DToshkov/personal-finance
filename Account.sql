CREATE TABLE Account (
    account_id INT NOT NULL,
    user_id INT NOT NULL,
    opening_date DATE NOT NULL,
    account_sum DECIMAL(9,2) NOT NULL,
    account_apr DECIMAL(9,2) NOT NULL,
    account_type VARCHAR(50) NOT NULL,
    account_routing INT NOT NULL,
    account_number INT NOT NULL,
    account_bank VARCHAR(50) NOT NULL,
    
    PRIMARY KEY (account_id),
    FOREIGN KEY (user_id) REFERENCES User_Details(user_id)
);

