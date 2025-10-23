select y.YEAR , y.YEAR_DEV - ed.SIZE_OF_COLONY YEAR_DEV, ID
from ECOLI_DATA ed left join (select Year(DIFFERENTIATION_DATE) YEAR, max(SIZE_OF_COLONY) YEAR_DEV
                     from ECOLI_DATA
                     group by Year(DIFFERENTIATION_DATE)) y
on Year( ed.DIFFERENTIATION_DATE) = y.YEAR
order by y.YEAR, YEAR_DEV

