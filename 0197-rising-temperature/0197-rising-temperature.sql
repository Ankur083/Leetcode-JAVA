# Write your MySQL query statement below
-- With cte As (
--     Select *, 
--         LAG(temperature) Over(order by recordDate) As prevTemp,
--         LAG(recordDate) Over(order by recordDate) As prevDate
--     From Weather
-- )

-- Select id
-- From cte Where DateDiff(recordDate, prevDate) = 1 AND temperature > prevTemp;

select w1.id 
From 
Weather w1 Join Weather w2
On DateDiff(w1.recordDate,w2.recordDate) = 1
And w1.temperature > w2.temperature;

