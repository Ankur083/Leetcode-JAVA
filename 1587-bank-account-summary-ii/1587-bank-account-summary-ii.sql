# Write your MySQL query statement below
Select u.name, t.balance
From Users u
Join 
(Select account, Sum(Amount) As balance From Transactions group by account) As t
On u.account = t.account
Where t.balance > 10000