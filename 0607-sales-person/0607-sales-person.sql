# Write your MySQL query statement below
select name
From SalesPerson
Where sales_id not in(
Select o.sales_id From  orders o
  JOIN Company c On c.com_id = o.com_id
Where c.name = 'RED'
)

