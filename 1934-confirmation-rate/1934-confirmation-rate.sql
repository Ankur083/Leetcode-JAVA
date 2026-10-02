# Write your MySQL query statement below
select 
    s.user_id,
    Round(Avg(case when c.action is null then 0
                when c.action = 'timeout' then 0
                Else 1 End), 2)As confirmation_rate

From Signups s Left Join Confirmations c
On s.user_id = c.user_id
group by s.user_id