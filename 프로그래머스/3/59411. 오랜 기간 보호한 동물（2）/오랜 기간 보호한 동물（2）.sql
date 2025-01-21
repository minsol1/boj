-- 코드를 입력하세요
SELECT ai.ANIMAL_ID, ai.name
from ANIMAL_INS ai left join ANIMAL_OUTS ao
on ai.ANIMAL_ID = ao.ANIMAL_ID
order by datediff(ao.DATETIME,ai.DATETIME) desc
limit 2