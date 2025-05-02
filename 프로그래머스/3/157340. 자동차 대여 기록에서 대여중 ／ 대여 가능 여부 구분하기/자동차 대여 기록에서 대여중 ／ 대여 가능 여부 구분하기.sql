-- 코드를 입력하세요
SELECT distinct CAR_ID , if(CAR_ID in (select CAR_ID
                from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                where date(START_DATE)<="2022-10-16" and date(END_DATE)>="2022-10-16"),"대여중","대여 가능") AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
order by CAR_ID desc