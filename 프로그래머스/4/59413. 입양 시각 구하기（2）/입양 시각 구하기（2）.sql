with recursive TIME as (
    select 0 as hour
    union all
    select hour+1 from TIME where hour<23
)

SELECT hour, COUNT(animal_id)
FROM TIME T LEFT JOIN ANIMAL_OUTS A
ON hour = DATE_FORMAT(DATETIME,"%H")
GROUP BY 1
order by 1