-- 코드를 입력하세요
SELECT concat("/home/grep/src/",bi.BOARD_ID,"/",FILE_ID,FILE_NAME,FILE_EXT) FILE_PATH
from (select BOARD_ID
     from USED_GOODS_BOARD
     order by VIEWS desc
     limit 1) as bi
     left join USED_GOODS_FILE as ugf
     on bi.BOARD_ID = ugf.BOARD_ID
order by ugf.FILE_ID desc
