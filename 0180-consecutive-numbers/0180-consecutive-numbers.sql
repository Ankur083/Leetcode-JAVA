# Write your MySQL query statement below
-- Select Distinct(L1.num) As ConsecutiveNums
-- From 
--     Logs L1 
--         JOIN 
--     Logs L2 
--         ON L1.id = L2.id-1 
--         JOIN 
--     Logs L3 
--         ON L2.id = L3.id-1
-- Where 
-- L1.num = L2.num AND L2.num = L3.num;

Select Distinct(L1.num) AS ConsecutiveNums
From Logs L1,
     Logs L2,
     Logs L3

where L1.id = L2.id-1 AND L2.id = L3.id-1 
     AND L1.num = L2.num AND L2.num = L3.num;
