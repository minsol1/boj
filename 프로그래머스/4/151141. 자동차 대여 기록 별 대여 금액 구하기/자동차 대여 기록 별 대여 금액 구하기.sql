
SELECT HISTORY_ID, DAILY_FEE*day*(1 - 0.01* ifnull (discount_rate,0)) FEE
from ( select h.CAR_ID, HISTORY_ID, datediff(END_DATE,START_DATE)+1 day, DAILY_FEE,CAR_TYPE
      from CAR_RENTAL_COMPANY_RENTAL_HISTORY h left join CAR_RENTAL_COMPANY_CAR c 
      on h.CAR_ID = c.CAR_ID
      where CAR_TYPE = '트럭'
     ) d
     left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
     on d.CAR_TYPE = p.CAR_TYPE and substring_index(DURATION_TYPE,"일",1) <= day

group by HISTORY_ID
order by fee desc,  HISTORY_ID desc