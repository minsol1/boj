# -- 코드를 입력하세요
# SELECT CART_ID,count(CART_ID)
# from ( select CART_ID
#         from CART_PRODUCTS
#         where NAME = 'Yogurt' or NAME = 'Milk'
#      ) c
# group by CART_ID
# having count(CART_ID) >=2
# order by CART_ID


select CART_ID
from (select distinct CART_ID
from CART_PRODUCTS
where NAME = 'Yogurt'

union all

select distinct CART_ID
from CART_PRODUCTS
where NAME = 'Milk')c
group by CART_ID
having count(CART_ID) >=2


