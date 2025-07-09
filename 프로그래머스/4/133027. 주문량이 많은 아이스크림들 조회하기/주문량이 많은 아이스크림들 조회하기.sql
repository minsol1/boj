-- 코드를 입력하세요
SELECT j.FLAVOR 
from  JULY j left join FIRST_HALF fh
on j.FLAVOR = fh.FLAVOR
group by j.FLAVOR
order by sum(j.TOTAL_ORDER+fh.TOTAL_ORDER) desc
limit 3