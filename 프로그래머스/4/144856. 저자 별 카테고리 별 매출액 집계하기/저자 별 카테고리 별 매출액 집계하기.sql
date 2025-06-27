SELECT a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(b.PRICE*SALES) SALES
from AUTHOR a left join BOOK b
on a.AUTHOR_ID = b.AUTHOR_ID
left join BOOK_SALES bs
on b.BOOK_ID = bs.BOOK_ID
where SALES_DATE like "2022-01%"
group by a.AUTHOR_ID,b.CATEGORY
order by a.AUTHOR_ID, b.CATEGORY desc