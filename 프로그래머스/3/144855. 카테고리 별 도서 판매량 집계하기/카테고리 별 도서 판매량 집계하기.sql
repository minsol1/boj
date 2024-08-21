-- 코드를 입력하세요
SELECT b.CATEGORY , sum(bs.SALES) TOTAL_SALES
from book b left join book_sales bs
on b.BOOK_ID = bs.BOOK_ID
where year(bs.SALES_DATE) = 2022 and month(bs.SALES_DATE) = 1
group by b.CATEGORY
order by b.CATEGORY