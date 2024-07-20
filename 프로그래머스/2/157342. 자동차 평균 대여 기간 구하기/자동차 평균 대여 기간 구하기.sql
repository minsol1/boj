-- 코드를 입력하세요
SELECT CAR_ID, round(avg(datediff(END_DATE,START_DATE)+1),1)AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
having AVERAGE_DURATION >=7
order by 2 desc, CAR_ID desc