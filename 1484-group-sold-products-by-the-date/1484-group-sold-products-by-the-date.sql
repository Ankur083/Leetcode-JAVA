# Write your MySQL query statement below
Select 
    sell_date, 
    Count(Distinct Product) as num_sold,
    GROUP_CONCAT(DISTINCT Product ORDER BY Product SEPARATOR ',') AS products
From Activities group by sell_date Order by sell_date Asc