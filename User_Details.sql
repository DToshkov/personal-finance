CREATE TABLE User_Details (
    user_id int NOT NULL,
    FirstName varchar(50),
    LastName varchar(50),
    Street varchar(50),
    City varchar(50),
    ZIP int,
    Phone int,
    Email varchar(50),
    id_document varchar(50) NOT NULL,
	Primary Key (user_id)
);
