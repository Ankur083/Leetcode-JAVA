# Write your MySQL query statement below
with cte As(
    Select *,
            LAG(temperature, 1, temperature+1) OVER(Order by recordDate) As prevTemp,
            LAG(recordDate, 1) OVER(Order by recordDate) As prevRecord
        From Weather
)

select id From cte where temperature > prevTemp AND DAteDIFF(recordDate , prevRecord) = 1;