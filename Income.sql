CREATE TABLE Income (
    income_ID int NOT NULL,
    user_id int NOT NULL,
    source_name varchar(50) NOT NULL,
    category varchar(50) NOT NULL,
    date_received date,
    amount decimal(9,2),
    account_deposit_id int NOT NULL,
 	PRIMARY KEY (income_ID),
    FOREIGN KEY (user_id) REFERENCES User_Details(user_id)
    

);
