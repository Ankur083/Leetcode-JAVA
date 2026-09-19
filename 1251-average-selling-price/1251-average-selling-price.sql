# Write your MySQL query statement below
Select
p.product_id,
Round(IFNULL(Sum(u.units*p.price)/sum(u.units),0),2) As average_price
From Prices p Left JOIN UnitsSold u
On p.product_id = u.product_id
And u.purchase_date between p.start_date and p.end_date
group by p.product_id;