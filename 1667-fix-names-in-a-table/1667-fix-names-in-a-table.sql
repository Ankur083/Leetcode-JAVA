# Write your MySQL query statement below
Select user_id, Concat(
            Upper(Substring(name, 1, 1)),
            lower(Substring(name, 2))
        ) As name
From Users order by user_id