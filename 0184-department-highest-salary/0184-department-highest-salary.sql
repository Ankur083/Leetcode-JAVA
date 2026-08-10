# Write your MySQL query statement below
Select d.name AS department, e.name AS Employee, e.salary As Salary
    From Employee AS e  JOIN Department AS d
    ON e.departmentid = d.id 
    Where 
        e.salary = (Select max(salary) From Employee Where departmentId = e.departmentid
);