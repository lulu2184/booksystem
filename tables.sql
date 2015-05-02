
CREATE TABLE Publisher(	pname CHAR(40),
						introduce VARCHAR(2000),
						PRIMARY KEY(pname));

CREATE TABLE Book(	ISBN CHAR(40),
					title VARCHAR(100),
					inum INTEGER,
					price REAL,
					formate CHAR(40),
					subject CHAR(40),
					pname CHAR(40),
					publish_year INTEGER CHECK(publish_year >= 1900),
					PRIMARY KEY(ISBN),
					FOREIGN KEY(pname) REFERENCES Publisher(pname));

CREATE TABLE Author(aname CHAR(40),
					introduce VARCHAR(2000),
					PRIMARY KEY(aname));


CREATE TABLE User(	username CHAR(20),
					password CHAR(15),
					fullname CHAR(20),
					age INTEGER CHECK(age > 0),
					addr CHAR(100),
					phone CHAR(10),
					PRIMARY KEY(username));

CREATE TABLE Feedback(	fid INTEGER,
						propose_date DATETIME,
						score SMALLINT CHECK(score >=0 AND score <= 10),
						ISBN CHAR(40),
						username CHAR(20),
						content VARCHAR(2000),
						PRIMARY KEY(fid),
						FOREIGN KEY(ISBN) REFERENCES Book(ISBN),
						FOREIGN KEY(username) REFERENCES User(username));

CREATE TABLE Orders(orderid INTEGER,
					order_date DATETIME,
					username CHAR(20),
					PRIMARY KEY (orderid),
					FOREIGN KEY(username) REFERENCES User(username));

CREATE TABLE AuthorOf(	aname CHAR(40),
						ISBN CHAR(40),
						PRIMARY KEY(aname, ISBN),
						FOREIGN KEY(aname) REFERENCES Author(aname),
						FOREIGN KEY(ISBN) REFERENCES Book(ISBN));

CREATE TABLE Keyword(	ISBN CHAR(40),
						content VARCHAR(100),
						PRIMARY KEY(ISBN, content),
						FOREIGN KEY(ISBN) REFERENCES Book(ISBN));

CREATE TABLE InOrder(	orderid INTEGER,
						ISBN CHAR(40),
						num INTEGER CHECK(num > 0),
						PRIMARY KEY(orderid, ISBN),
						FOREIGN KEY(orderid) REFERENCES Orders(orderid),
						FOREIGN KEY(ISBN) REFERENCES Book(ISBN));

CREATE TABLE Rate(	fid INTEGER,
					username CHAR(20),
					rate_num SMALLINT CHECK(rate_num >=0 AND rate_num <= 2),
					PRIMARY KEY(fid, username),
					FOREIGN KEY(fid) REFERENCES Feedback(fid),
					FOREIGN KEY(username) REFERENCES User(username));

CREATE TABLE Declares(	declare_username CHAR(20),
						declared_username CHAR(20),
						trust_num BIT,
						PRIMARY KEY(declare_username, declared_username),
						FOREIGN KEY(declare_username) REFERENCES User(username),
						FOREIGN KEY(declared_username) REFERENCES User(username));
