select fi.ID, fni.FISH_NAME, fi.LENGTH
from FISH_INFO fi join FISH_NAME_INFO fni
on fi.FISH_TYPE = fni.FISH_TYPE, (select max(LENGTH) max_LENGTH, FISH_TYPE
                                 from FISH_INFO
                                  where LENGTH is not null
                                 group by FISH_TYPE) ml
where fi.FISH_TYPE = ml.FISH_TYPE and fi.LENGTH = ml.max_LENGTH
order by fi.ID 
