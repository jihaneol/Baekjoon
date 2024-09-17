SELECT CONCAT("/home/grep/src/",A.BOARD_ID,"/",A.FILE_ID,FILE_NAME,A.FILE_EXT) FILE_PATH
FROM USED_GOODS_FILE A JOIN 
                            (
                                SELECT BOARD_ID
                                FROM USED_GOODS_BOARD 
                                ORDER BY VIEWS DESC
                                LIMIT 1
                            )B ON A.BOARD_ID = B.BOARD_ID

ORDER BY 1 DESC