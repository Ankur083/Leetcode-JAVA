# Write your MySQL query statement below
Select customer_number From 
(Select customer_number , Count(*) As total
From Orders
group by customer_number
order by total Desc
limit 1) As t