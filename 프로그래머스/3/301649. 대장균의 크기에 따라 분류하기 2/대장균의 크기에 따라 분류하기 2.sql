with A as(
    select ID ,PERCENT_RANK() over(order by size_of_colony desc) as no
    from ecoli_data
)

SELECT ID, CASE WHEN no <=0.25 THEN "CRITICAL"
                WHEN no <=0.5 then "HIGH"
                WHEN no <=0.75 then "MEDIUM"
                ELSE "LOW"
            END COLONY_NAME
FROM A
ORDER BY 1
