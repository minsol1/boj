select truc.HISTORY_ID, ROUND(day*DAILY_FEE*(1-0.01* ifnull(max(dr),0)) )FEE
from (select h.HISTORY_ID HISTORY_ID, datediff(END_DATE,START_DATE)+1 day, c.DAILY_FEE DAILY_FEE
     from CAR_RENTAL_COMPANY_RENTAL_HISTORY h left join
      CAR_RENTAL_COMPANY_CAR c 
      on h.CAR_ID =c.CAR_ID
     where c.CAR_TYPE = '트럭') truc 
     left join (select substring_index(DURATION_TYPE,'일',1)dt, CAST(substring_index(DISCOUNT_RATE,'%',1)AS SIGNED) dr
                from CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
                where p.CAR_TYPE = '트럭'
                ) discount
      on truc.day > discount.dt
group by HISTORY_ID
order by FEE desc, truc.HISTORY_ID desc


# -- 코드를 입력하세요
# SELECT H.HISTORY_ID, ROUND((DAILY_FEE * RENT_DAY) - (DAILY_FEE * RENT_DAY * 0.01 * IFNULL(MAX(DISCOUNT_RATE), 0))) AS FEE 

# FROM CAR_RENTAL_COMPANY_CAR AS R
# JOIN (
#     SELECT HISTORY_ID, CAR_ID, DATEDIFF(END_DATE, START_DATE) + 1 AS RENT_DAY 
#     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#     )  AS H ON R.CAR_ID = H.CAR_ID
# LEFT JOIN (
#     SELECT 
#         CAR_TYPE
#         , SUBSTRING_INDEX(DURATION_TYPE, '일', 1) AS DURATION_DATE
#         , CAST(SUBSTRING_INDEX(DISCOUNT_RATE, '%', 1) AS SIGNED) AS DISCOUNT_RATE
#     FROM  CAR_RENTAL_COMPANY_DISCOUNT_PLAN
#     ) AS D ON H.RENT_DAY > D.DURATION_DATE
# WHERE R.CAR_TYPE = '트럭' AND (D.CAR_TYPE = '트럭' OR D.CAR_TYPE IS NULL)
# GROUP BY HISTORY_ID
# ORDER BY FEE DESC, HISTORY_ID DESC