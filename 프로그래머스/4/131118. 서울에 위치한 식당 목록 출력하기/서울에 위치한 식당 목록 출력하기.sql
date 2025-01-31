SELECT ri.REST_ID, ri.REST_NAME, ri.FOOD_TYPE, ri.FAVORITES,ri.ADDRESS,round( avg(rr.REVIEW_SCORE),2) SCORE
from REST_REVIEW rr left join REST_INFO ri
on rr.REST_ID = ri.REST_ID
where ri.ADDRESS like "서울%"
group by ri.REST_ID
order by SCORE desc, ri.FAVORITES desc