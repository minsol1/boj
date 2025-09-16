select HISTORY_ID, round(day*c.DAILY_FEE * 0.01 *(100 - ifnull(max(DISCOUNT_RATE),0)) )  FEE
from CAR_RENTAL_COMPANY_CAR c 
left join (select HISTORY_ID,CAR_ID, datediff(END_DATE,START_DATE) +1 day
           from CAR_RENTAL_COMPANY_RENTAL_HISTORY
) h  on c.CAR_ID = h.CAR_ID
left join(select CAR_TYPE, substring_index(DURATION_TYPE,'일',1) DURATION_TYPE, 
          cast(substring_index(DISCOUNT_RATE,'%',1)as signed) DISCOUNT_RATE
          from CAR_RENTAL_COMPANY_DISCOUNT_PLAN p 
         where p.CAR_TYPE = '트럭') p
         on h.day > DURATION_TYPE
where c.CAR_TYPE = '트럭' and (p.CAR_TYPE = '트럭' or p.CAR_TYPE is null )
group by h.HISTORY_ID
order by FEE desc ,HISTORY_ID desc

