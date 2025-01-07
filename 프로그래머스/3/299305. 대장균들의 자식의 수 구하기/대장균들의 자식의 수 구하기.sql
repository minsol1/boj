select ed.ID, count(ced.id) CHILD_COUNT
from ECOLI_DATA ed left join ECOLI_DATA ced
on ed.id = ced.PARENT_ID
group by ed.id
order by ed.id