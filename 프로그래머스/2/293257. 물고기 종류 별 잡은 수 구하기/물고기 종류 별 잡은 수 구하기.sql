-- 코드를 작성해주세요
select count(*) FISH_COUNT, fni.FISH_NAME
from FISH_INFO fi 
left join FISH_NAME_INFO fni on fi.FISH_TYPE = fni.FISH_TYPE
group by fni.FISH_NAME
order by FISH_COUNT desc
