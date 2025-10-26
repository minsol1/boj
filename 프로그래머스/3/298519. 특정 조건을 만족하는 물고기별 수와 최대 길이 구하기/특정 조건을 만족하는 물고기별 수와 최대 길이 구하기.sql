-- 코드를 작성해주세요
select count(ID) FISH_COUNT, max(LENGTH) MAX_LENGTH,FISH_TYPE
from FISH_INFO
where FISH_TYPE in (select a.FISH_TYPE
                   from (select ID,FISH_TYPE, ifnull(LENGTH,10) LENGTH
                         from FISH_INFO
                        ) a
                   group by a.FISH_TYPE
                   having avg(LENGTH)>=33)
group by FISH_TYPE
order by FISH_TYPE