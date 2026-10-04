# Write your MySQL query statement below
Select employee_id, 
Case when employee_id % 2 = 1 AND name  not like 'M%' then salary
    Else 0 End As bonus
From Employees
order by employee_id
