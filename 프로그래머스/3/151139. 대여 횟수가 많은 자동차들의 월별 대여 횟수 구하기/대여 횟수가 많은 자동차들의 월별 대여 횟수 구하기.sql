select month(START_DATE),cr.CAR_ID, count(cr.CAR_ID) RECORDS
from (select CAR_ID
     from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
     where year(START_DATE) = 2022 and month(START_DATE) in (8,9,10)
     group by CAR_ID
      having count(CAR_ID) >=5
     )
     ci
     left join CAR_RENTAL_COMPANY_RENTAL_HISTORY cr
on ci.CAR_ID = cr.CAR_ID
where year(START_DATE) = 2022 and month(START_DATE) in (8,9,10)
group by cr.CAR_ID , month(START_DATE)
having count(cr.CAR_ID)>0
order by month(START_DATE), cr.CAR_ID desc 
