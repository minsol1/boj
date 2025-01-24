select ch.ID , ch.GENOTYPE, p.GENOTYPE PARENT_GENOTYPE
from ECOLI_DATA ch left join ECOLI_DATA p
on ch.PARENT_ID = p.ID	
where ch.GENOTYPE & p.GENOTYPE >= p.GENOTYPE
order by ch.ID