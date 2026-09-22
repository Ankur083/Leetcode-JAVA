# Write your MySQL query statement below
Select 
activity_date As day, Count(distinct user_id) As active_users

From Activity
where activity_date >= '2019-06-28' AND activity_date <= '2019-07-27'
group by activity_date