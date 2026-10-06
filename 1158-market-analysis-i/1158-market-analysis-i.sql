# Write your MySQL query statement below


Select u.user_id AS buyer_id, u.join_date, Count(o.item_id) As orders_in_2019
From Items i JOin Orders o
On i.item_id = o.item_id
Right Join Users u on  o.buyer_id = u.user_id
AND Year(order_date) = '2019'
group by u.user_id