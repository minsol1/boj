-- 코드를 입력하세요

select r.FOOD_TYPE, r.REST_ID,r.REST_NAME,r.FAVORITES
from(
    SELECT max(FAVORITES) FAVORITES,FOOD_TYPE
    from REST_INFO
    group by FOOD_TYPE
) m left join REST_INFO r
on m.FAVORITES = r.FAVORITES and m.FOOD_TYPE= r.FOOD_TYPE
order by r.FOOD_TYPE desc
