# Write your MySQL query statement below
Select p.product_id,
ROUND(
    IfNULL(SUM(u.units * p.price) / SUM(u.units), 0),
    2
) AS average_price
From 
Prices p Left Join UnitsSold u 
On p.product_id = u.product_id And purchase_date between start_date and end_date
group by p.product_id