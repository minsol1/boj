-- 코드를 입력하세요
SELECT ugb.WRITER_ID, ugu.NICKNAME,sum(ugb.PRICE)
from USED_GOODS_BOARD ugb left join USED_GOODS_USER ugu
on ugb.WRITER_ID = ugu.USER_ID
where ugb.STATUS = 'DONE'
group by ugb.WRITER_ID
having sum(ugb.PRICE) >=700000
order by sum(ugb.PRICE)