# Write your MySQL query statement below
Select date_id,
    make_name, 
    Count(Distinct lead_id) As unique_leads,
    Count(Distinct partner_id) As unique_partners
From DailySales
group by date_id,make_name
