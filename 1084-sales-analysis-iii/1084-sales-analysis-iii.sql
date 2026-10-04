# Write your MySQL query statement below
Select p.product_id, p.product_name
From Product p Join Sales s
On p.product_id = s.product_id
GROUP BY p.product_id, p.product_name
HAVING MIN(s.sale_date) >= '2019-01-01'
   AND MAX(s.sale_date) <= '2019-03-31';
