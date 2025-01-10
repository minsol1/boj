-- 코드를 작성해주세요
select ii.ITEM_ID,ITEM_NAME,RARITY
from ITEM_INFO ii left join (select ii.ITEM_ID ITEM_ID
                          from ITEM_INFO ii right join ITEM_TREE it 
                          on ii.ITEM_ID = it.PARENT_ITEM_ID
                         ) pi
on ii.ITEM_ID = pi.ITEM_ID
where pi.ITEM_ID is null
order by ii.ITEM_ID desc
