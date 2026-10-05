# Write your MySQL query statement below
select u.name, IfNull(Sum(r.distance),0) As travelled_distance
From Users u left join Rides r
On u.id = r.user_id
group by u.id, u.name
order by travelled_distance Desc, u.name Asc