# with car as (
# SELECT distinct(CAR_ID)
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where START_DATE <= "2022-10-16" and END_DATE >="2022-10-16"
# )
SELECT distinct(CAR_ID),
case
when CAR_ID in (SELECT distinct(CAR_ID)
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE <= "2022-10-16" and END_DATE >="2022-10-16") then "대여중"
else "대여 가능"
end AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h 
order by CAR_ID desc