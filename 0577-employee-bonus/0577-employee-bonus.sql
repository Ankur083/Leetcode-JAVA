# Write your MySQL query statement below
select name, bonus
From Employee e Left JOIN Bonus b
on e.empId = b.empId
Where bonus < 1000 OR bonus is NULL;