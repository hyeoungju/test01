CREATE TABLE Customer (
	cId			BIGINT			PRIMARY KEY	AUTO_INCREMENT,
	userId		VARCHAR(30)		NOT NULL,
	passwd		VARCHAR(30)		NOT NULL,
	name		VARCHAR(30)		NOT NULL
)AUTO_INCREMENT = 1001;

INSERT INTO Customer (userId, passwd, name) VALUES ('nam', '1111', '형주');
SELECT * FROM Customer;