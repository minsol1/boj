-- 코드를 입력하세요
with mem
as (
    select MEMBER_ID
    from REST_REVIEW
    group by MEMBER_ID
    order by count(1) desc
    limit 1
)

SELECT mp.MEMBER_NAME, r.REVIEW_TEXT, date_format( r.REVIEW_DATE,"%Y-%m-%d") REVIEW_DATE
from MEMBER_PROFILE mp left join REST_REVIEW r
on mp.MEMBER_ID = r.MEMBER_ID
right join mem m 
on mp.MEMBER_ID = m.MEMBER_ID
order by r.REVIEW_DATE, r.REVIEW_TEXT