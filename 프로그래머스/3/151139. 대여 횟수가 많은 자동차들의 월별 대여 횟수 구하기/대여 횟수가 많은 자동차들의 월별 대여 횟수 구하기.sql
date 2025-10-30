-- 코드를 입력하세요
SELECT month(START_DATE) MONTH, c.CAR_ID, count(1) RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
right join (select CAR_ID
           from CAR_RENTAL_COMPANY_RENTAL_HISTORY
           where Year(START_DATE) = 2022 and (month(START_DATE) >= 8 and month(	START_DATE) <= 10)
           group by CAR_ID
           having count(1) >=5
            ) c
on h.CAR_ID = c.CAR_ID
where Year(START_DATE) = 2022 and (month(START_DATE) >= 8 and month(START_DATE) <= 10)
group by CAR_ID, month(START_DATE)

order by MONTH, c.CAR_ID desc