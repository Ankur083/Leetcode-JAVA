# Write your MySQL query statement below
select stock_name,
         Sum(case when operation = 'Buy' then -price Else price End) As capital_gain_loss
From Stocks 
Group by stock_name