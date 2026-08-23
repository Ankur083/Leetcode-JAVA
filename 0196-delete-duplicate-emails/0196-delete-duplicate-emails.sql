# Write your MySQL query statement below
Delete 
From Person 
Where (id, email) NOT IN (Select id , email From 
    (
        Select Min(id) as id, email From person group by email
    )    As temp

);

