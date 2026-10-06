# Write your MySQL query statement below
select user_id, MAX(time_stamp) As last_stamp
from Logins
where Year(Date(time_stamp)) = '2020' 
group by user_id