-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, sum(os.SALES_AMOUNT)*p.PRICE sales
from OFFLINE_SALE os
left join PRODUCT p
on os.PRODUCT_ID = p.PRODUCT_ID
group by os.PRODUCT_ID
order by sales desc, p.PRODUCT_CODE