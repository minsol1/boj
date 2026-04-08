# select history_ID, round( DAILY_FEE*(datediff(END_DATE, START_DATE) +1 ) * (1- 0.01 *ifnull(cast ( substring_index(DISCOUNT_RATE,'%',1) as signed),0) )  )fee
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY rh left join CAR_RENTAL_COMPANY_CAR c
# on rh.CAR_ID = c.CAR_ID
# left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN dp
# on case when datediff(END_DATE, START_DATE) +1 >= 90 then "90일 이상"
#         when datediff(END_DATE, START_DATE) +1 >= 30 then "30일 이상"
#         when datediff(END_DATE, START_DATE) +1 >= 70 then "70일 이상"
#         end
#         = dp.DURATION_TYPE and dp.CAR_TYPE = c.CAR_TYPE
# where c.CAR_TYPE ='트럭'
# order by fee desc, history_ID desc











SELECT 
    h.history_id,
    ROUND(((DATEDIFF(h.end_date, h.start_date) + 1) * c.daily_fee) *
    (1 - (IFNULL(p.discount_rate, 0) / 100)), 0) AS fee
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
LEFT JOIN CAR_RENTAL_COMPANY_CAR c
    ON h.car_id = c.car_id
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
    ON CASE WHEN (DATEDIFF(h.end_date, h.start_date) + 1) >= 90 THEN '90일 이상'
            WHEN (DATEDIFF(h.end_date, h.start_date) + 1) >= 30 THEN '30일 이상'
            WHEN (DATEDIFF(h.end_date, h.start_date) + 1) >= 7 THEN '7일 이상' END
        = p.duration_type
    AND c.car_type = p.car_type
WHERE c.car_type = "트럭"
ORDER BY fee DESC, history_id DESC
