-- 코드를 작성해주세요
SELECT A.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO A JOIN (select A.ITEM_ID
                        from ITEM_TREE A LEFT JOIN ITEM_TREE B
                        ON A.ITEM_ID = B.PARENT_ITEM_ID
                        WHERE B.ITEM_ID IS NULL)B
ON A.ITEM_ID = B.ITEM_ID
ORDER BY 1 DESC;
