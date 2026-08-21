# Write your MySQL query statement below
select product_id, new_price As price
    From Products 
    Where (product_id, change_date) In
    (
        Select product_id, MAX(change_date)
            From 
        Products
        Where change_date <= '2019-08-16'
        group by product_id
        
    )
Union
Select product_id, 10 AS price
    From Products 
    Where product_id not In
    (
        Select product_id From Products
        Where change_date <= '2019-08-16'
        group by product_id
    )

