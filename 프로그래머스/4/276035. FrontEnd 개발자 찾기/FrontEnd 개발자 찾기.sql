select distinct d.ID, EMAIL,FIRST_NAME,LAST_NAME
from DEVELOPERS d left join SKILLCODES s
on d.SKILL_CODE & s.CODE >=1
where s.CATEGORY = 'Front End'
order by d.ID