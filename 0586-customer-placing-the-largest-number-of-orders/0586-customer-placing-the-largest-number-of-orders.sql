# Write your MySQL query statement below
Select customer_number 
From Orders
group by customer_number
order by Count(*) Desc
limit 1