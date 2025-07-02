select ID, case 
when NTILE(4) over (order by SIZE_OF_COLONY desc) = 1 then 'CRITICAL'
when NTILE(4) over (order by SIZE_OF_COLONY desc) = 2 then 'HIGH'
when NTILE(4) over (order by SIZE_OF_COLONY desc) = 3 then 'MEDIUM'
else 'LOW'
end
COLONY_NAME
from ECOLI_DATA
order by ID
