# Write your MySQL query statement below
Select r.contest_id,
    Round(Count(r.user_id)/(Select count(*) From users)*100, 2)As percentage

From 
Users u  JOIN Register r
On u.user_id = r.user_id
group by r.contest_id
order by percentage Desc,r.contest_id ASC