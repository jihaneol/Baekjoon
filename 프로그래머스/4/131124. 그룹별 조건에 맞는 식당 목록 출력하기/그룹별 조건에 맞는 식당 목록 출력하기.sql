SELECT MEMBER_NAME, A.REVIEW_TEXT, DATE_FORMAT(A.REVIEW_DATE,"%Y-%m-%d") REVIEW_DATE
FROM REST_REVIEW A JOIN (SELECT *
FROM REST_REVIEW
GROUP BY MEMBER_ID ORDER BY COUNT(MEMBER_ID) DESC LIMIT 1) B 
ON A.MEMBER_ID = B.MEMBER_ID LEFT JOIN MEMBER_PROFILE C 
ON A.MEMBER_ID = C.MEMBER_ID
ORDER BY 3