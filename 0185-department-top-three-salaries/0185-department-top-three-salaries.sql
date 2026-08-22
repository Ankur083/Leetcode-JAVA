# Write your MySQL query statement below
-- SELECT Department, name, salary
-- FROM (
--     SELECT Department,
--            name,
--            salary,
--            DENSE_RANK() OVER (
--                PARTITION BY Department
--                ORDER BY salary DESC
--            ) AS salary_rank
--     FROM Employee
-- ) AS t
-- WHERE salary_rank <= 3;

With  clt as (select e.id, e.name, e.salary, d.name As Department from Employee AS e left join Department AS d On e.departmentId = d.id)

SELECT Department, name AS Employee, salary AS Salary
FROM (
    SELECT Department,
           name,
           salary,
           DENSE_RANK() OVER (
               PARTITION BY Department
               ORDER BY salary DESC
           ) AS salary_rank
    FROM clt
) AS t
WHERE salary_rank <= 3;