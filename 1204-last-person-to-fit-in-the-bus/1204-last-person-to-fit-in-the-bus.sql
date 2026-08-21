# Write your MySQL query statement below
-- With clt As
--     (
--         Select turn , person_id , person_name ,
--         weight, Sum(Weight) Over (order by turn) AS Total 
--         From Queue
--         Order by turn ASC
--     )
-- Select person_name From clt 
-- Where Total <= 1000
-- Order By total DESC limit 1;

Select person_name 
From
    (
        Select turn , person_id , person_name ,
        weight, Sum(Weight) Over (order by turn) AS Total 
        From Queue
        Order by turn ASC
    ) As clt 
Where Total <= 1000
Order By total DESC limit 1;