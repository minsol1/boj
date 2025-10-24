SELECT concat("/home/grep/src/", concat( concat(f.BOARD_ID,"/"), concat(concat(f.FILE_ID,f.FILE_NAME ),FILE_EXT)))FILE_PATH
From (select BOARD_ID 
      from USED_GOODS_BOARD 
      order by VIEWS desc
      limit 1
     )b left join USED_GOODS_FILE f
on b.BOARD_ID = f.BOARD_ID
order by f.FILE_ID desc

