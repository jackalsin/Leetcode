use leetcode;
Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Max', '90000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');

-- solution
SELECT d.Name Department, e1.Name Empolyee, e1.Salary
FROM Employee e1 JOIN Department d on e1.DepartmentId = d.Id
WHERE 3 > (SELECT COUNT(DISTINCT(e2.Salary)) FROM Employee e2 WHERE e2.Salary > e1.Salary AND e1.DepartmentId = e2.DepartmentId)
ORDER BY d.Name
;
