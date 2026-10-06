# Write your MySQL query statement below

(Select e.employee_id As employee_id
From
Employees e Left join Salaries s
On e.employee_id = s.employee_id
where s.salary is null) 

UNion 


(Select s.employee_id As employee_id
From
Employees e Right join Salaries s
On e.employee_id = s.employee_id
where e.name is null)
order by employee_id
