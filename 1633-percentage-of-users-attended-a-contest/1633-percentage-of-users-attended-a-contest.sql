# Write your MySQL query statement below
Select 
    r.contest_id,
    Round(Count(*)/(Select count(*) From Users)*100, 2) As percentage
From 
Register r
group by r.contest_id
order by percentage Desc,r.contest_id ASC