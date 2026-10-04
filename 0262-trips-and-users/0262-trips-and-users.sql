# Write your MySQL query statement below
select 
t.request_at As Day,
Round(Avg( case when t.status = 'cancelled_by_driver' then 1
                when t.status = 'cancelled_by_client' then 1
                Else 0 End ),2) As "Cancellation Rate"

From 
Trips t Join Users u1
On t.client_id = u1.users_id
Join users u2
On t.driver_id = u2.users_id
where u1.banned != 'yes' AND u2.banned != 'yes' AND t.request_at between '2013-10-01' AND '2013-10-03'
group by t.request_at

