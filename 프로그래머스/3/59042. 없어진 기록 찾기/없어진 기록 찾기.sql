-- 코드를 입력하세요
SELECT aout.animal_id as ANIMAL_ID, aout.name AS NAME
from animal_ins ain right join animal_outs aout on ain.animal_id = aout.animal_id
where ain.animal_id is null