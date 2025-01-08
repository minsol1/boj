select hd.DEPT_ID,hd.DEPT_NAME_EN,round(sum(he.SAL)/count(*),0) AVG_SAL
from HR_EMPLOYEES he left join HR_DEPARTMENT hd
on he.DEPT_ID = hd.DEPT_ID
group by hd.DEPT_ID
order by sum(he.SAL)/count(*) desc
