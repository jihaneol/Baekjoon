SELECT ID, CASE 
                WHEN SIZE_OF_COLONY<=100 THEN "LOW"
                WHEN  SIZE_OF_COLONY<=1000 THEN "MEDIUM"
                WHEN  SIZE_OF_COLONY>1000  THEN  "HIGH"
            END  SIZE
FROM ECOLI_DATA