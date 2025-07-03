

SELECT c.CAR_ID , if(r.car_id,'대여중','대여 가능') AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY c left join
(
select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE<="2022-10-16" and END_DATE>="2022-10-16"
) r 
on c.CAR_ID = r.CAR_ID
group by c.CAR_ID
order by c.CAR_ID desc