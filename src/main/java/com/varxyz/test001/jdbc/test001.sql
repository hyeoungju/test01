CREATE TABLE Customer (
	cId			BIGINT			PRIMARY KEY	AUTO_INCREMENT,
	userId		VARCHAR(30)		NOT NULL,
	passwd		VARCHAR(30)		NOT NULL,
	name		VARCHAR(30)		NOT NULL
)AUTO_INCREMENT = 1001;

INSERT INTO Customer (userId, passwd, name) VALUES ('nam', '1111', '형주');
SELECT * FROM Menu;
INSERT INTO Menu (menuName, menuPrice, menuType) VALUES ('카페라떼', '2000', '커피');

CREATE TABLE Menu (
	mId			BIGINT			PRIMARY KEY	AUTO_INCREMENT,
	menuName	VARCHAR(40)		NOT NULL,
	menuPrice	INT				NOT NULL,
	menuType	VARCHAR(40)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL		DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 2001;

SELECT menuName, menuPrice, menuType FROM Menu;