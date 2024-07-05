-- 코드를 작성해주세요
select count(ID) FISH_COUNT,month(TIME) MONTH
from FISH_INFO
group by month(TIME)
having count(ID)>0
order by month(TIME)
