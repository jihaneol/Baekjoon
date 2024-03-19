WITH A AS (
    SELECT SUM(CODE) AS CODE
    FROM SKILLCODES S
    WHERE CATEGORY = 'FRONT END'
), B AS (
    SELECT CODE
    FROM SKILLCODES S
    WHERE NAME = "C#"
)

SELECT (CASE 
       WHEN SKILL_CODE & (SELECT CODE FROM A) AND SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = "Python") THEN "A"
       WHEN SKILL_CODE & (SELECT CODE FROM B) THEN "B"
       WHEN SKILL_CODE & (SELECT CODE FROM A) THEN "C"
        END
       ) AS GRADE, ID, EMAIL
FROM DEVELOPERS
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID;