# Write your MySQL query statement below
With cte As (
    Select *, 
        LAG(temperature) Over(order by recordDate) As prevTemp,
        LAG(recordDate) Over(order by recordDate) As prevDate
    From Weather
)

Select id
From cte Where DateDiff(recordDate, prevDate) = 1 AND temperature > prevTemp;
