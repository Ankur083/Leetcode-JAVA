# Write your MySQL query statement below
Select d.name AS Department, e.name AS Employee, e.salary As Salary
    From Employee AS e Left JOIN Department AS d
    ON e.departmentid = d.id 
    Where 
        (e.salary,d.name) IN  (Select max(e2.salary), d2.name From Employee AS e2 LEFT JOIN Department d2 ON e2.departmentid = d2.id group by d2.name
);