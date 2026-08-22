# Write your MySQL query statement below
Select ROUND(Sum(tiv_2016),2) AS tiv_2016 
From Insurance
Where 
(lat, lon) In(
    Select lat, lon
    FROM Insurance
    group by lat, lon
    having count(*) = 1
)
AND 
tiv_2015 IN (
    SELECT tiv_2015
    FROM Insurance
    GROUP BY tiv_2015
    HAVING COUNT(*) > 1
);