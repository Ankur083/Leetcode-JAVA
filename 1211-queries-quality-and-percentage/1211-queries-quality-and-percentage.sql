# Write your MySQL query statement below
Select 
    query_name,
    Round(Avg(rating/position), 2) As quality,
    Round(Avg(case when rating < 3 then 1 Else 0 End)*100, 2) As poor_query_percentage

From 
    Queries
    group by query_name
