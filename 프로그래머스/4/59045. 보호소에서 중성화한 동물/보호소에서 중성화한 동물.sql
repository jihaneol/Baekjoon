SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME 
FROM ANIMAL_INS as I JOIN ANIMAL_OUTS as O 
WHERE I.ANIMAL_ID = O.ANIMAL_ID AND I.SEX_UPON_INTAKE != O.SEX_UPON_OUTCOME