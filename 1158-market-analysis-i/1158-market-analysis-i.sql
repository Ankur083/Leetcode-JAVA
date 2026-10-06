# Write your MySQL query statement below
Select u.user_id AS buyer_id, u.join_date, Count(o.item_id) As orders_in_2019
From  Users u Left join orders o on  o.buyer_id = u.user_id
AND Year(o.order_date) = 2019
group by u.user_id, u.join_date