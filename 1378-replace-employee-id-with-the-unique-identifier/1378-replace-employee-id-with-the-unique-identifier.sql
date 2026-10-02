# Write your MySQL query statement below

Select en.unique_id, e.name 
From 
Employees e Left Join EmployeeUNI en
On e.id = en.id