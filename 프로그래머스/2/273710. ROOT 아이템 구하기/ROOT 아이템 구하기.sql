-- 코드를 작성해주세요
select it.ITEM_ID, ii.ITEM_NAME
from ITEM_TREE it join ITEM_INFO ii 
on it.ITEM_ID = ii.ITEM_ID
where it.PARENT_ITEM_ID is null 
order by it.ITEM_ID
