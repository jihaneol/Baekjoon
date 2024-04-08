SELECT A.REST_ID,REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, ROUND(AVG(REVIEW_SCORE),2) AS SCORE
FROM REST_INFO A JOIN REST_REVIEW B ON A.REST_ID = B.REST_ID
WHERE SUBSTRING(ADDRESS,1,2) = "서울" AND REVIEW_SCORE IS NOT NULL
GROUP BY A.REST_ID
ORDER BY SCORE DESC, FAVORITES DESC