# Write your MySQL query statement below
Select * From Users 
Where  REGEXP_LIKE(mail,'^[A-Za-z][A-Za-z0-9_.-]*@leetcode\\.com$','c')

