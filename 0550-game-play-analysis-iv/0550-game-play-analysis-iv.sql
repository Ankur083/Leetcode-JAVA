# Write your MySQL query statement below
Select
  Round(count(*)/(Select Count(Distinct player_id) From Activity),2) As fraction
From Activity a1 Join (
    SELECT
        player_id,
        MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
) a2 on a1.player_id = a2.player_id AND DateDiff(a1.event_date, a2.first_login) = 1