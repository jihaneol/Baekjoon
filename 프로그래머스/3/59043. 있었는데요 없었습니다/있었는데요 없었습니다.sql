-- 코드를 입력하세요
SELECT ai.ANIMAL_ID , AI.NAME 
from animal_ins ai join animal_outs ao on ai.animal_id = ao.animal_id AND ai.datetime > ao.datetime 
ORDER BY AI.DATETIME