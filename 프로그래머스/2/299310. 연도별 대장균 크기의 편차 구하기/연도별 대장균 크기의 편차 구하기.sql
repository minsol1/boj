-- 코드를 작성해주세요
select Year(ed.DIFFERENTIATION_DATE) YEAR, s.ms-ed.SIZE_OF_COLONY as YEAR_DEV, ed.ID
from ECOLI_DATA ed left join (select year(DIFFERENTIATION_DATE) y, max(SIZE_OF_COLONY) ms
                          from ECOLI_DATA
                          group by year(DIFFERENTIATION_DATE)) s
on Year(ed.DIFFERENTIATION_DATE) = s.y                         
order by Year(ed.DIFFERENTIATION_DATE),YEAR_DEV