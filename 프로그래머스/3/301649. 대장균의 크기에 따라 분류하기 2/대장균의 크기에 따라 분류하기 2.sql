select ID ,
case 
    when NTILE(4) over (order by SIZE_OF_COLONY) =1 then "LOW"
    when NTILE(4) over (order by SIZE_OF_COLONY) =2 then "MEDIUM"
    when NTILE(4) over (order by SIZE_OF_COLONY) =3 then "HIGH"
    else "CRITICAL"
end
COLONY_NAME
from ECOLI_DATA
order by ID