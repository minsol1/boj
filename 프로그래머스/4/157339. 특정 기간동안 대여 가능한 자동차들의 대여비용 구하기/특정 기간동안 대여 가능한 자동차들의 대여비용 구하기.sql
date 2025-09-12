select c.CAR_ID, c.CAR_TYPE ,round((DAILY_FEE*30)*(100-p.DISCOUNT_RATE)*0.01) FEE
from CAR_RENTAL_COMPANY_CAR c 
left join(select CAR_TYPE, DISCOUNT_RATE
        from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
        where DURATION_TYPE = '30일 이상')p
on c.CAR_TYPE = p.CAR_TYPE
where (c.CAR_TYPE = '세단' or c.CAR_TYPE = 'SUV' )
        and c.CAR_ID not in (select CAR_ID
                   from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
                   where end_date >= "2022-11-01"
        AND start_date <= "2022-11-30")
    and ((DAILY_FEE*30)*(100-p.DISCOUNT_RATE)*0.01) >=500000 and ((DAILY_FEE*30)*(100-p.DISCOUNT_RATE)*0.01)<2000000
order by FEE desc, c.CAR_TYPE,c.CAR_ID desc