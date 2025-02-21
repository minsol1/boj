SELECT date_format(SALES_DATE,"%Y-%m-%d") SALES_DATE ,PRODUCT_ID,USER_ID,SALES_AMOUNT
from ONLINE_SALE
where Year(SALES_DATE) = 2022 and Month(SALES_DATE) =3

union

select date_format(SALES_DATE,"%Y-%m-%d") SALES_DATE ,PRODUCT_ID,NULL as user_id, SALES_AMOUNT
from OFFLINE_SALE
where Year(SALES_DATE) = 2022 and Month(SALES_DATE) =3

order by SALES_DATE, PRODUCT_ID,user_id