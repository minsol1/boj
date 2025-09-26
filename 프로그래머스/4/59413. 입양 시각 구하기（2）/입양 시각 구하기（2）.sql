with recursive a as(
select 0 as h
union all
select h + 1 
from a
where h < 23
)

select a.h ,ifnull( count(ANIMAL_ID),0) COUNT
from a left join ANIMAL_OUTS ao
on a.h = hour(ao.DATETIME)
group by a.h
order by a.h 

