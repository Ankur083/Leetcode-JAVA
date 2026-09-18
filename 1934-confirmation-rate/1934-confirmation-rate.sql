# Write your MySQL query statement below
Select s.user_id,
Round(AVG(case when c.action = 'confirmed' then 1 Else 0 End), 2) As confirmation_rate

From Signups s Left Join Confirmations c 
On s.user_id = c.user_id 
group by s.user_id