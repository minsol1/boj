SELECT CATEGORY, sum(SALES) TOTAL_SALES
from BOOK_SALES bs left join BOOK b
on bs.BOOK_ID = b.BOOK_ID
where bs.SALES_DATE >= "2022-01-01" and bs.SALES_DATE < "2022-02-01"
group by b.CATEGORY
order by CATEGORY