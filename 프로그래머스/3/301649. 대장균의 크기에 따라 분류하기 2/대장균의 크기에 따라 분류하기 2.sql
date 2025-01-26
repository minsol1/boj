select ID, case
when r =1 then "CRITICAL"
when r =2 then "HIGH"
when r =3 then "MEDIUM"
else "LOW"
end as "COLONY_NAME"
from (
    select ID, NTILE(4) over(order by SIZE_OF_COLONY desc) as r
    from ECOLI_DATA
) ranked_data
order by ID