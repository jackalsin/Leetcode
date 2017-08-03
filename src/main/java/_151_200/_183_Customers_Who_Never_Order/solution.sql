use leetcode;
Create table If Not Exists Customers (Id int, Name varchar(255));
Create table If Not Exists Orders (Id int, CustomerId int);
Truncate table Customers;
insert into Customers (Id, Name) values ('1', 'Joe');
insert into Customers (Id, Name) values ('2', 'Henry');
insert into Customers (Id, Name) values ('3', 'Sam');
insert into Customers (Id, Name) values ('4', 'Max');
Truncate table Orders;
insert into Orders (Id, CustomerId) values ('1', '3');
insert into Orders (Id, CustomerId) values ('2', '1');

-- solution
SELECT Name AS Customers FROM Customers c WHERE NOT EXISTS (SELECT * FROM Customers RIGHT JOIN Orders ON Customers.Id = Orders.CustomerId);
SELECT Name AS Customers FROM Customers WHERE NOT EXISTS (SELECT Name FROM Customers c WHERE Not EXISTS (SELECT CustomerId FROM Orders o WHERE o.CustomerId = c.Id));
