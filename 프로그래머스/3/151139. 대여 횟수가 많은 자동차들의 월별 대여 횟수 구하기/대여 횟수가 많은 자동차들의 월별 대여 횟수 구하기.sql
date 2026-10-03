-- 코드를 입력하세요

# with as id(
# select CAR_ID
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY h 
# where START_DATE >= '2022-08-01' and START_DATE < '2022-11-01'
# group by CAR_ID
# having count(CAR_ID) >= 5
# )

select MONTH(START_DATE), CAR_ID, count(CAR_ID) RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h 
where CAR_ID in (
select CAR_ID
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h 
where START_DATE >= '2022-08-01' and START_DATE < '2022-11-01'
group by CAR_ID
having count(CAR_ID) >= 5
) and START_DATE >= '2022-08-01' and START_DATE < '2022-11-01'
group by MONTH(START_DATE), CAR_ID
order by MONTH(START_DATE), CAR_ID desc