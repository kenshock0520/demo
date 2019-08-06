CREATE TABLE DemoDB.dbo.junitTest (
	id int NOT NULL,
	products varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT junitTest_PK PRIMARY KEY (id)
);

INSERT INTO DemoDB.dbo.junitTest (id, products) VALUES (1,'updateFF');

INSERT INTO DemoDB.dbo.junitTest (id, products) VALUES (4,'1test');