CREATE DATABASE IF NOT EXISTS leetcode;
USE leetcode;
-- 181. Employees Earning More Than Their Managers
CREATE TABLE IF NOT EXISTS Employee (
  Id INT ,
  Name varchar(255),
  Salary INT,
  ManagerId INT DEFAULT NULL ,
  PRIMARY KEY (Id)
);

LOAD DATA LOCAL INFILE '_181_Employees_Earning_More_Than_Their_Managers/data' INTO TABLE Employee FIELDS TERMINATED BY ' ' (Id, Name, Salary, @vManagerId) SET ManagerId = nullif(@vManagerId,'NULL');
