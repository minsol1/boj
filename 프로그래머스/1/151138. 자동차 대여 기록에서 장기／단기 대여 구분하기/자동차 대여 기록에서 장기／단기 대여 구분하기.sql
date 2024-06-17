-- 코드를 입력하세요
SELECT HISTORY_ID ,CAR_ID,date_format(START_DATE ,"%Y-%m-%d") START_DATE,date_format(END_DATE ,"%Y-%m-%d") END_DATE, 
CASE
        WHEN DATEDIFF(END_DATE,START_DATE)+1 >=30 THEN "장기 대여"
        ELSE "단기 대여"
    END as RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where year(START_DATE) = 2022 and month(START_DATE) = 9
order by HISTORY_ID desc