# Write your MySQL query statement below
Select unique_id, name
From Employees Left Join EmployeeUNI
On Employees.id = EmployeeUNI.id;