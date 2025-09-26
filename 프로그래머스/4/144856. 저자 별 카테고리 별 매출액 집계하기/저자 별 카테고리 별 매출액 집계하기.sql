-- 코드를 입력하세요
SELECT  a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY,sum(bs.SALES*b.PRICE) TOTAL_SALES
from BOOK_SALES bs left join BOOK b
on bs.BOOK_ID = b.BOOK_ID
left join AUTHOR a
on b.AUTHOR_ID = a.AUTHOR_ID
where SALES_DATE like "2022-01%"
group by a.AUTHOR_ID, b.CATEGORY
order by a.AUTHOR_ID, b.CATEGORY desc
