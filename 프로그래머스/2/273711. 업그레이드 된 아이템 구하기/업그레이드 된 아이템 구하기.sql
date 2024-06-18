select ii2.ITEM_ID,ii2.ITEM_NAME,ii2.RARITY
from ITEM_INFO ii join ITEM_TREE it
on ii.ITEM_ID = it.PARENT_ITEM_ID
join ITEM_INFO ii2
on it.ITEM_ID = ii2.ITEM_ID
where ii.RARITY = "RARE"
order by ITEM_ID desc