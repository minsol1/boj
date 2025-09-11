select GRADE, ID, EMAIL
from (select ID, EMAIL,
      case
          when SKILL_CODE & (select sum(code) 
                             from SKILLCODES
                             group by CATEGORY
                             having CATEGORY = "Front End") > 0
                and SKILL_CODE & (select code 
                             from SKILLCODES 
                             where NAME = "Python") > 0
            then 'A'
            when SKILL_CODE & (select code 
                             from SKILLCODES 
                             where NAME = "C#") > 0
            then 'B'
            when SKILL_CODE & (select sum(code) 
                             from SKILLCODES
                             group by CATEGORY
                             having CATEGORY = "Front End") > 0
            then 'C'
            else NULL
      end
      GRADE
     from DEVELOPERS) g
where GRADE is not null
order by GRADE, ID