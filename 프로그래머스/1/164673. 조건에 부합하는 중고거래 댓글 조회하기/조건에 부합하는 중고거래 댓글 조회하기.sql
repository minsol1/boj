-- 코드를 입력하세요
SELECT board.title, board.board_id, reply.reply_id, reply.writer_id, reply.contents, date_format(reply.created_date,"%Y-%m-%d")
from USED_GOODS_BOARD board inner join USED_GOODS_REPLY reply
on board.board_id = reply.board_id
where year(board.created_date) = 2022 and month(board.created_date)=10 
order by reply.CREATED_DATE, board.title