# Write your MySQL query statement below
Select v.customer_id, Count(v.customer_id) As count_no_trans
from Visits v Left Join Transactions t
On v.visit_id = t.visit_id
where t.transaction_id Is Null
group by v.customer_id
order by count_no_trans Asc;
