-- 코드를 입력하세요
with recursive h 
as (
    select 0 as n
    union all
    select n+1
    from h
    where n<23
)

select h.n HOUR, COUNT(ao.DATETIME) COUNT
from h left join ANIMAL_OUTS ao
on h.n = hour(ao.DATETIME)
group by h.n
