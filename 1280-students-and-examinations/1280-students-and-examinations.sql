# Write your MySQL query statement below
Select s.student_id, s.student_name, sub.subject_name, COUNT(e.subject_name) AS attended_exams
From Students s cross Join Subjects sub left Join Examinations e
ON s.student_id = e.student_id AND sub.subject_name = e.subject_name
group by s.student_id, sub.subject_name
order by s.student_id , sub.subject_name