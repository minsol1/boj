select year(e.DIFFERENTIATION_DATE)YEAR,(msize - e.SIZE_OF_COLONY) YEAR_DEV, e.ID
from ECOLI_DATA e left join 
(select year(DIFFERENTIATION_DATE)year , max(SIZE_OF_COLONY) msize
from ECOLI_DATA
 group by year
) me
on year(e.DIFFERENTIATION_DATE) = me.year

order by YEAR, YEAR_DEV

