# Write your MySQL query statement below
Select teacher_id, Count(distinct subject_id) As cnt From Teacher group by teacher_id;