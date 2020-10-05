select login_date, count(1) as user_count from
(
select min(activity_date) as login_date, user_id from Traffic
where activity = 'login' group by user_id
) derived_table
where login_date >= (str_to_date('2019-06-30', "%Y-%m-%d") - interval 90 day)
group by login_date;
