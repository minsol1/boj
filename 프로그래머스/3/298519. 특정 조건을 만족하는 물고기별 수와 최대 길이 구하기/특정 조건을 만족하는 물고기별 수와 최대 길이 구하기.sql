select count(1) FISH_COUNT, max(LENGTH) MAX_LENGTH, FISH_TYPE
from (select ID	,FISH_TYPE,ifnull(LENGTH,10) LENGTH,TIME
     from FISH_INFO) fi
group by FISH_TYPE
having avg(LENGTH)>=33
order by FISH_TYPE
     
     