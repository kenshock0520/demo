CREATE TABLE DemoDB.dbo.test (
	id int NOT NULL,
	products varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT test_PK PRIMARY KEY (id)
);