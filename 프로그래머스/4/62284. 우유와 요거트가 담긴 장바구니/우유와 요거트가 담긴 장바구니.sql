-- 코드를 입력하세요
SELECT distinct y.CART_ID
from (select ID	, CART_ID, NAME, PRICE
     from CART_PRODUCTS
     where NAME = "Yogurt") as y
     join 
     (select ID	, CART_ID, NAME, PRICE
     from CART_PRODUCTS
     where NAME = "Milk") as m
     on y.CART_ID = m.CART_ID 
order by y.CART_ID