# Write your MySQL query statement below


Select Round(AVG(Case when order_date = customer_pref_delivery_date then 1 Else 0 End)*100,2) As immediate_percentage From Delivery
where (customer_id, order_date) In (select customer_id, MIN(order_date) From Delivery group by customer_id)