-- 코드를 작성해주세요
select count(*) as FISH_COUNT, max(LENGTH) as MAX_LENGTH, FISH_TYPE
from (select ID, FISH_TYPE, IFNULL(LENGTH,10) as LENGTH from FISH_INFO) FISH_INFO
group by FISH_TYPE
having sum(LENGTH)/count(*) >=33
order by FISH_TYPE