select ccc.CAR_ID,ccc.CAR_TYPE, round(DAILY_FEE*30*(1-DISCOUNT_RATE/100) )as FEE
from CAR_RENTAL_COMPANY_CAR ccc left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN ccd
on ccc.CAR_TYPE = ccd.CAR_TYPE
where ccc.CAR_TYPE in ('세단' ,'SUV') 
and ccc.CAR_ID not in (SELECT car_id
        FROM car_rental_company_rental_history
        WHERE end_date >= "2022-11-01"
        AND start_date <= "2022-11-30")
and  DURATION_TYPE = "30일 이상"  
and DAILY_FEE*30*(1-DISCOUNT_RATE/100) >=500000 and DAILY_FEE*30*(1-DISCOUNT_RATE/100) <2000000
order by FEE desc, ccc.CAR_TYPE,ccc.CAR_ID desc