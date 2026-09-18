# Write your MySQL query statement below
select e1.name From
Employee e1 JOIN Employee e2 
On e1.id = e2.managerId
group by e1.id 
Having count(e1.id) >= 5;