SELECT MCDP_CD  '진료과 코드', count(PT_NO)'5월예약건수'
from APPOINTMENT
where year(APNT_YMD) = 2022 and month(APNT_YMD) =5
group by MCDP_CD
order by count(MCDP_CD), MCDP_CD;
