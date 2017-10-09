use leetcode;
Create table If Not Exists Weather (Id int, Date date, Temperature int);
Truncate table Weather;
insert into Weather (Id, Date, Temperature) values ('1', '2015-01-01', '10');
insert into Weather (Id, Date, Temperature) values ('2', '2015-01-02', '25');
insert into Weather (Id, Date, Temperature) values ('3', '2015-01-03', '20');
insert into Weather (Id, Date, Temperature) values ('4', '2015-01-04', '30');

-- solution
SELECT w1.Id FROM Weather w1, Weather w2 WHERE w1.Date = Date_ADD(w2.Date, INTERVAL 1 DAY) And w1.Temperature > w2.Temperature;
