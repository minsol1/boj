select c.CAR_ID,p.CAR_TYPE, c.DAILY_FEE*30*0.01*(100-ifnull(substring_index(p.DISCOUNT_RATE,"%",1),0)) as FEE
from CAR_RENTAL_COMPANY_CAR c left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
on c.CAR_TYPE = p.CAR_TYPE
where c.CAR_ID not in (select CAR_ID
                      from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
                       where h.START_DATE <="2022-11-30" and h.END_DATE >="2022-11-01"
                      )
                      and DURATION_TYPE = "30일 이상"
                      and c.DAILY_FEE*30*0.01*(100-ifnull(substring_index(p.DISCOUNT_RATE,'%',1),0)) >=500000 and c.DAILY_FEE*30*0.01*(100-ifnull(substring_index(p.DISCOUNT_RATE,'%',1),0))  < 2000000 
order by c.DAILY_FEE*30*0.01*(100-ifnull(substring_index(p.DISCOUNT_RATE,'%',1),0))  desc , p.CAR_TYPE,c.CAR_ID desc