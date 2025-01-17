-- 코드를 입력하세요
SELECT distinct rh.CAR_ID
from CAR_RENTAL_COMPANY_RENTAL_HISTORY rh right join CAR_RENTAL_COMPANY_CAR c
on rh.CAR_ID = c.CAR_ID
where month(rh.START_DATE) = 10 and c.CAR_TYPE ='세단'
order by c.CAR_ID desc