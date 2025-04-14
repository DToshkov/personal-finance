CREATE TABLE Expenses (
    expense_id int NOT NULL,
    user_id int NOT NULL,
    source_name varchar(50) NOT NULL,
    category varchar(50) NOT NULL,
    date_received date NOT NULL,
    amount decimal(9,2) NOT NULL,
    recurring boolean,
    associated_account varchar(50) NOT NULL,
    vendor varchar(50) NOT NULL,
    PRIMARY KEY (expense_id),
    FOREIGN KEY (user_id)  REFERENCES User_Details(user_id)
    );


