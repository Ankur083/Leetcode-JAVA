# Write your MySQL query statement below
Select 
    s.student_id,s.student_name,sub.subject_name, Count(e.subject_name) As attended_exams

From Students s cross join  Subjects sub
        Left Join 
    Examinations e
    on s.student_id = e.student_id And e.subject_name = sub.subject_name
    group by s.student_id,sub.subject_name
    order by s.student_id,sub.subject_name