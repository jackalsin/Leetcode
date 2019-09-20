Create table If Not Exists Spending (user_id int, spend_date date, platform ENUM('desktop', 'mobile'), amount int);
Truncate table Spending;
insert into Spending (user_id, spend_date, platform, amount) values ('1', '2019-07-01', 'mobile', '100');
insert into Spending (user_id, spend_date, platform, amount) values ('1', '2019-07-01', 'desktop', '100');
insert into Spending (user_id, spend_date, platform, amount) values ('2', '2019-07-01', 'mobile', '100');
insert into Spending (user_id, spend_date, platform, amount) values ('2', '2019-07-02', 'mobile', '100');
insert into Spending (user_id, spend_date, platform, amount) values ('3', '2019-07-01', 'desktop', '100');
insert into Spending (user_id, spend_date, platform, amount) values ('3', '2019-07-02', 'desktop', '100');

--Solution start from here
select spend_date,
 platform,
 IFNULL(sum(total_amount), 0)  total_amount,
 sum(total_users) as total_users
from (
    select format_table.spend_date as spend_date,
     format_table.platform as platform,
      ifNULL(value_table.total_users, 0) as total_users,
      ifnull(value_table.total_amount, 0 )as total_amount
      from
    (
        SELECT DISTINCT(spend_date), 'desktop' platform FROM Spending
        UNION
        SELECT DISTINCT(spend_date), 'mobile' platform FROM Spending
        UNION
        SELECT DISTINCT(spend_date), 'both' platform FROM Spending
    ) format_table left join
        (
        select spend_d,
            (case when mobile_amount > 0 then
                (case when desktop_amount > 0 then 'both' else 'mobile' end)
            else "desktop" end) as platform2,
            sum(mobile_amount + desktop_amount) as total_amount,
            count(distinct user_id) as total_users
        from
        (
        select spend_date as spend_d, user_id,
         sum(amount * (case when platform='mobile' then 1 else 0 end)) as mobile_amount,
         sum(amount * (case when platform='desktop' then 1 else 0 end)) as desktop_amount
        from Spending group by user_id, spend_d
        ) a group by spend_d, user_id
    ) value_table
        on format_table.spend_date=value_table.spend_d
         and format_table.platform=value_table.platform2
) p
group by spend_date,platform;

