CREATE TABLE micromarinedb.plastics
(
    ExperimentId INT AUTO_INCREMENT PRIMARY KEY,
    FullName NVARCHAR(128) NOT NULL,
    Email NVARCHAR(128) NOT NULL,
    CountTotal INT NOT NULL,
    USAState NVARCHAR(2) NOT NULL,
    MaxSize DECIMAL(6, 3) NOT NULL,
    Season NVARCHAR(10) NOT NULL
);
insert into micromarinedb.plastics(FullName, Email, CountTotal, USAState, MaxSize, Season) values("Samantha Falcucci", "sqf5077@psu.edu", 11, "NJ", .22, "Summer")