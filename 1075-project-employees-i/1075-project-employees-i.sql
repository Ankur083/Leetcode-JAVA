# Write your MySQL query statement below
Select 
    p.project_id,
    Round(Avg(e.experience_years), 2) As average_years
From Project p Left Join Employee e
on p.employee_id = e.employee_id
group by p.project_id