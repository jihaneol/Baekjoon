-- 코드를 입력하세요
SELECT MCDP_CD 진료과코드,COUNT(*) 5월예약건수
from appointment
where DATE_FORMAT(APNT_YMD,'%Y-%m') = '2022-05'
group by mcdp_cd
order by 2, 1