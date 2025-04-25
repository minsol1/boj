-- 코드를 입력하세요
SELECT ri.REST_ID,ri.REST_NAME, FOOD_TYPE,FAVORITES,ADDRESS,round(avg(REVIEW_SCORE),2) SCORE
from REST_INFO ri right join REST_REVIEW rr
on ri.REST_ID =rr.REST_ID
where ri.ADDRESS like "서울%"
group by ri.REST_ID
order by SCORE desc, FAVORITES desc