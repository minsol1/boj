select a.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY,sum(SALES *PRICE ) TOTAL_SALES
from BOOK_SALES bs left join BOOK b
on bs.BOOK_ID = b.BOOK_ID
left join AUTHOR a
on a.AUTHOR_ID = b.AUTHOR_ID
where SALES_DATE like '2022-01%'
group by b.AUTHOR_ID, CATEGORY
order by a.AUTHOR_ID, b.CATEGORY desc
