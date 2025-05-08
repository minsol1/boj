-- 코드를 입력하세요
SELECT year(SALES_DATE) YEAR, month(SALES_DATE) MONTH, ui.GENDER, count(distinct ui.USER_ID) USERS
from ONLINE_SALE os left join USER_INFO ui
on os.USER_ID = ui.USER_ID
where ui.GENDER is not null
group by year(SALES_DATE), month(SALES_DATE), ui.GENDER
order by year(SALES_DATE), month(SALES_DATE), ui.GENDER
