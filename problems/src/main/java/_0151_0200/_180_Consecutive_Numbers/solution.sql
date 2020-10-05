use leetcode;
Create table If Not Exists Logs (Id int, Num int);
Truncate table Logs;
insert into Logs (Id, Num) values ('1', '1');
insert into Logs (Id, Num) values ('2', '1');
insert into Logs (Id, Num) values ('3', '1');
insert into Logs (Id, Num) values ('4', '2');
insert into Logs (Id, Num) values ('5', '1');
insert into Logs (Id, Num) values ('6', '2');
insert into Logs (Id, Num) values ('7', '2');

-- solution
SELECT DISTINCT l2.Num AS ConsecutiveNums FROM Logs l1, Logs l2, Logs l3 WHERE l2.Id = l1.Id + 1 AND l2.Id = l3.Id - 1 AND l3.Num = l2.Num AND l2.Num = l1.Num;
