# Write your MySQL query statement below
-- with cte As(
--     Select *,
--             LAG(temperature, 1, temperature+1) OVER(Order by recordDate) As prevTemp,
--             LAG(recordDate, 1) OVER(Order by recordDate) As prevRecord
--         From Weather
-- )

-- select id From cte where temperature > prevTemp AND DAteDIFF(recordDate , prevRecord) = 1;


Select w2.id From Weather w1 JOIN Weather w2
On DateDiff(w2.recordDate, w1.recordDate) = 1
Where w2.temperature > w1.temperature