-- 코드를 입력하세요
select FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from rest_info
where (FOOD_TYPE,favorites) IN (SELECT FOOD_TYPE,max(favorites)
from rest_info
group by food_type)
order by FOOD_TYPE DESC