# Write your MySQL query statement below

Select 
DATE_FORMAT(trans_date, '%Y-%m') AS month,
country,
Count(*) As trans_count,
Sum(case when state = 'approved' then 1 else 0 END) As approved_count,
Sum(amount) As trans_total_amount,
Sum(case when state = 'approved' then amount else 0 END) As approved_total_amount

From 
Transactions 
group by MONTH(trans_date) , YEAR(trans_date) ,country 
 

