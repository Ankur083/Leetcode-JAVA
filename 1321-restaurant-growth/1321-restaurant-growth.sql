# Write your MySQL query statement below
Select visited_on,

    (Select Sum(amount) From Customer 
        Where 
    visited_on between 
    Date_sub(c.visited_on, Interval 6 DAY) AND c.visited_on ) 
    AS amount,

    Round((Select Sum(amount)/7 From Customer 
        Where 
    visited_on between 
    Date_sub(c.visited_on, Interval 6 DAY) AND c.visited_on ),2) 
    AS average_amount

From Customer c 
Where visited_on >= (Select DATE_ADD(MIN(visited_on), Interval 6 DAY) From Customer)
group by visited_on
Order By visited_on