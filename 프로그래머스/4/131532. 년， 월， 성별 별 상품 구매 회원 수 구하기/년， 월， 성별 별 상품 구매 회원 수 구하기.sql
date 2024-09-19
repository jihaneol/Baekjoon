SELECT YEAR, MONTH, GENDER, COUNT(*) USERS
FROM (
    SELECT YEAR(SALES_DATE) YEAR, MONTH(SALES_DATE) MONTH, USER_ID
    FROM ONLINE_SALE 
    GROUP BY 1,2,3
    ) A JOIN USER_INFO B ON A.USER_ID = B.USER_ID AND GENDER IS NOT NULL
GROUP BY 1,2,3
ORDER BY 1,2,3
