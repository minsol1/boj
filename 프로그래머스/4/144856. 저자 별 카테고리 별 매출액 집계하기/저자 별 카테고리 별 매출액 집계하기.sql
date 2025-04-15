select a.AUTHOR_ID,a.AUTHOR_NAME,b.CATEGORY, sum(b.price*bs.SALES) SALES
from book b 
        left join AUTHOR a
        on b.AUTHOR_ID = a.AUTHOR_ID
        right join BOOK_SALES bs
        on b.BOOK_ID = bs.BOOK_ID
where year(bs.SALES_DATE) =2022 and month(bs.SALES_DATE) =01
group by a.AUTHOR_NAME,b.CATEGORY
order by a.AUTHOR_ID , b.CATEGORY desc