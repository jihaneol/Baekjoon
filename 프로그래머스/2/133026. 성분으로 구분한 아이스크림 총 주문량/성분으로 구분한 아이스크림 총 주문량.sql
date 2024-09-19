-- 코드를 입력하세요
SELECT INGREDIENT_TYPE ,sum(A.total_order) TOTAL_ORDER
from first_half A join icecream_info B on A.flavor = B.flavor
group by ingredient_type