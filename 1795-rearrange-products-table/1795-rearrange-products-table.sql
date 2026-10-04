# Write your MySQL query statement below
(Select product_id,
      'store1' As store,
      store1 As price
From Products
where store1 is not null)

UNION

(
Select product_id,
      'store2' As store,
      store2 As price
From Products
where store2 is not null
)

UNION 

(Select product_id,
      'store3' As store,
      store3 As price
From Products
where store3 is not null)




