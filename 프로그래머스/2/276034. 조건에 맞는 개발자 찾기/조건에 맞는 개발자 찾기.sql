select distinct id, email, FIRST_NAME, LAST_NAME
from developers
join skillcodes on skillcodes.code & developers.skill_code=skillcodes.code
where skillcodes.name in ('C#','Python')
order by id


