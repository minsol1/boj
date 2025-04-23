select month(START_DATE) MONTH, CAR_ID,count(CAR_ID) RECORDS 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where CAR_ID in (select CAR_ID
                from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                where date(START_DATE) >= "2022-08-01" and date(START_DATE) <= "2022-10-31"
                 group by CAR_ID
                 having count(CAR_ID) >=5
                 )
        and date(START_DATE) >= "2022-08-01" and date(START_DATE) <= "2022-10-31"
group by month(START_DATE), CAR_ID
having count(CAR_ID) >0
order by month(START_DATE) , CAR_ID desc