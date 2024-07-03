-- 코드를 작성해주세요
select sum(hg.SCORE) SCORE, hg.EMP_NO , he.EMP_NAME, he.POSITION, he.EMAIL
from HR_DEPARTMENT hd 
join HR_EMPLOYEES he on hd.DEPT_ID = he.DEPT_ID
join HR_GRADE hg on he.EMP_NO = hg.EMP_NO
where hg.year =2022 
group by he.EMP_NO
order by sum(hg.SCORE) desc
limit 1
