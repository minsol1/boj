-- 코드를 입력하세요
SELECT ugu.USER_ID, ugu.NICKNAME, concat(CITY," ",STREET_ADDRESS1," ",STREET_ADDRESS2) as "전체주소" , concat(substr(ugu.TLNO,1,3),"-",substr(ugu.TLNO,4,4),"-",substr(ugu.TLNO,8,4)) as "전화번호"
from USED_GOODS_BOARD ugb left join USED_GOODS_USER ugu
on ugb.WRITER_ID = ugu.USER_ID
group by ugu.USER_ID
having count(ugu.USER_ID) >=3
order by ugu.USER_ID desc