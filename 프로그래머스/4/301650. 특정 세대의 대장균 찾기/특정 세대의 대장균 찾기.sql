-- 코드를 작성해주세요
select ID
from ECOLI_DATA
where PARENT_ID in (select ed1.ID
                   from ECOLI_DATA ed1 right join (select ID
                                                  from ECOLI_DATA
                                                  where PARENT_ID is null
                   ) ed2
                   on ed1.PARENT_ID = ed2.ID
                   where ed1.ID is not null)
order by ID