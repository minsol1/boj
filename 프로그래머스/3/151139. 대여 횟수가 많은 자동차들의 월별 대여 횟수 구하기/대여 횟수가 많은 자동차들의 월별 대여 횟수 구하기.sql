-- 코드를 입력하세요
SELECT MONTH(START_DATE) MONTH ,CAR_ID, count(1) RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE>="2022-08-01" and START_DATE < "2022-11-01"
and CAR_ID in(select CAR_ID
             from CAR_RENTAL_COMPANY_RENTAL_HISTORY
             where START_DATE>="2022-08-01" and START_DATE < "2022-11-01"
             group by CAR_ID
             having count(1) >=5
             )
group by MONTH(START_DATE),CAR_ID
order by MONTH(START_DATE),CAR_ID desc