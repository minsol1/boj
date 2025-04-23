-- 코드를 작성해주세요
select fi.id ID, fni.FISH_NAME ,fi.LENGTH
from FISH_INFO fi left join FISH_NAME_INFO fni
on fi.FISH_TYPE = fni.FISH_TYPE
where (fi.FISH_TYPE,fi.LENGTH) in(select FISH_INFO.FISH_TYPE, max(LENGTH)
                                  from FISH_INFO
                                  where LENGTH is not null
                                  group by FISH_INFO.FISH_TYPE
                                  )
order by fi.ID