# Write your MySQL query statement below
Select p.product_name, Sum(o.unit) as unit
From Products AS p JOIN Orders AS o 
On p.product_id = o.product_id
Where MONTH(o.order_date) = 2 AND YEAR(o.order_date) = 2020
group by p.product_name
Having Sum(o.unit) >= 100 
