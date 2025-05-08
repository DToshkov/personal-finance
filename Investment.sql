CREATE TABLE Investment (
    investment_ID int NOT NULL,
    user_id int NOT NULL,
    type varchar(50) NOT NULL,
    institution varchar(50) NOT NULL,
    date_received date,
    ROI decimal(9,2) NOT NULL,
    account_deposit_id int NOT NULL,
    recurring boolean,
    associated_account varchar(50) NOT NULL,
    vendor varchar(50) NOT NULL,
    PRIMARY KEY (investment_ID),
    FOREIGN KEY (user_id) REFERENCES User_Details(user_id)
);
