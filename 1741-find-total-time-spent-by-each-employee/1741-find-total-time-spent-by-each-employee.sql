# Write your MySQL query statement below
Select event_day As day, emp_id, Sum(out_time-in_time) As total_time
from Employees Group by emp_id, event_day