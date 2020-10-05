use leetcode;
Create table If Not Exists Person (Id int, Email varchar(255));
Truncate table Person;
insert into Person (Id, Email) values ('1', 'a@b.com');
insert into Person (Id, Email) values ('2', 'c@d.com');
insert into Person (Id, Email) values ('3', 'a@b.com');

-- solution
SELECT DISTINCT p1.Email FROM Person p1, Person p2 WHERE p1.Id != p2.Id AND p1.Email = p2.Email;
