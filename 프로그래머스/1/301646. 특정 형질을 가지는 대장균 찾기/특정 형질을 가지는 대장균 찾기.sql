-- 코드를 작성해주세요
select count(*) count
from ECOLI_DATA
where GENOTYPE&5 >0 and GENOTYPE&2=0