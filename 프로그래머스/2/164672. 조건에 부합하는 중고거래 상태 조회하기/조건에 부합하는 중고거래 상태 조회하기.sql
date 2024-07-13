-- 코드를 입력하세요
SELECT BOARD_ID,WRITER_ID,TITLE,PRICE,if(status="DONE", "거래완료",if(status = "SALE","판매중","예약중")) status
from USED_GOODS_BOARD
where year(CREATED_DATE) =2022 and month(CREATED_DATE) = 10 and day(CREATED_DATE)=5
order by BOARD_ID desc