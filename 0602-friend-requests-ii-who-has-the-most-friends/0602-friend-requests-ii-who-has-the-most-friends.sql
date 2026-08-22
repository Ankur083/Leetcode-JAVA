# Write your MySQL query statement below
Select Id, Sum(count) AS num
From
(Select requester_id AS Id , Count(*) AS count
From RequestAccepted
group by requester_id
UNION ALL
Select accepter_id AS Id , Count(*) AS count
From RequestAccepted
group by accepter_id) AS Nested
group by Id
Order By num DESC limit 1;



