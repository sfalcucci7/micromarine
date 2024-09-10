DROP TABLE IF EXISTS PLASTICS;
CREATE TABLE PLASTICS (experimentid INT IDENTITY PRIMARY KEY, fullname NVARCHAR(128) NOT NULL, email NVARCHAR(128) NOT NULL, counttotal Integer NOT NULL, usastate NVARCHAR(2) NOT NULL, maxsize DOUBLE PRECISION NOT NULL, season NVARCHAR(10) NOT NULL);

-- DROP TABLE IF EXISTS todo;
-- CREATE TABLE todo (id INT PRIMARY KEY, description VARCHAR(255), details VARCHAR(4096), done BIT);