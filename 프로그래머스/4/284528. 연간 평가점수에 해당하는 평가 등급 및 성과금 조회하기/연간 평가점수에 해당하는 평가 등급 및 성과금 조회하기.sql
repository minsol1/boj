select he.EMP_NO, he.EMP_NAME,g.GRADE, 
case 
when g.GRADE="S" then he.SAL*0.2
when g.GRADE="A" then he.SAL*0.15
when g.GRADE="B" then he.SAL*0.1
else 0
end BONUS
from HR_EMPLOYEES he left join HR_DEPARTMENT hd
on he.DEPT_ID = hd.DEPT_ID
left join (select EMP_NO,
           case
           when avg(SCORE) >=96 then "S"
           when avg(SCORE) >=90 then "A"
           when avg(SCORE) >=80 then "B"
           else "C"
           end GRADE
          from HR_GRADE
          group by EMP_NO) g
on he.EMP_NO = g.EMP_NO
