# Write your MySQL query statement below
Select user_id, 
    CONCAT(
        Upper(Substring(name, 1, 1)),
        Lower(Substring(name, 2))
    ) As name
From Users order by user_id Asc;