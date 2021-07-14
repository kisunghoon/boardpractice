-- 계층형 쿼리 (Hierarchical Query)

-- LEVEL ~ CONNECT BY 조건
-- LEVEL 은 1부터 시작하여 증가
SELECT LEVEL
FROM dual 
CONNECT BY LEVEL <= 10;


SELECT * FROM t_dept2;

SELECT LPAD(dname, 10, '*') FROM t_dept2;

-- LEVEL
SELECT dname, LEVEL
FROM t_dept2
CONNECT BY PRIOR dcode = pdept
-- START WITH dcode = 0001;
START WITH dcode = 1000;
;

/* 해설
 * LEVEL 은 오라클에서 계속 사용할 수 있는 것으로
 * 해당 데이터가 몇번째 단계 이냐를 의미하는 것.
 * 
 * CONNECT BY PRIOR  :  각 row 들이 어떻게 연결되어야 하는지 조건 지정
 * PRIOR를 어느쪽에 주느냐가 중요!
 */

SELECT dname, LEVEL
FROM t_dept2
CONNECT BY  dcode = PRIOR pdept
-- START WITH dcode = 0001;   --  결과) 사장실만 달랑~
START WITH dcode = 1011; -- 영업4팀 부터.. - 영업기획팀 - 영어부 - 사장님



SELECT LPAD(dname, LEVEL * 6, '*') 부서명
FROM t_dept2
CONNECT BY  PRIOR dcode = pdept
START WITH dcode = 0001;

-- CONNECT BY 절에는 subQuery 사용 불가!
-- 계층형 쿼리가 수행되는 순서
--  1. START WITH 절에 시작조건을 찾습니다.
--  2. CONNECT BY 절에 연결조선을 찻습니다.
--  3. WHERE 절의 조건을 검색


SELECT * FROM t_emp2;

SELECT e.name || ' ' || d.dname || ' ' || NVL(e.post, '사원')
FROM t_emp2 e, (SELECT dname, dcode, pdept FROM t_dept2) d
WHERE e.deptno = d.dcode
;


SELECT LPAD(e.name || ' ' || d.dname || ' ' || NVL(e.post, '사원'), LEVEL * 22, '-') "이름과 직급"
FROM t_emp2 e, (SELECT dname, dcode, pdept FROM t_dept2) d
WHERE e.deptno = d.dcode
CONNECT BY PRIOR e.empno = e.pempno
START WITH e.empno = 20000101
;


-----------------------------------------------------------------------------------
-- 입양 시각 구하기(2)
-- https://programmers.co.kr/learn/courses/30/lessons/59413?language=oracle

-- 데이터 확인
SELECT * FROM ANIMAL_OUTS

-- 24hr 시간제, 시간대별로 입양된 동물들의 count
SELECT h.hr "HOUR", count(*) "COUNT"
FROM 
   (SELECT TO_CHAR(datetime, 'hh24') hr FROM ANIMAL_OUTS) h
GROUP BY h.hr
ORDER BY 1
-- 문제점!  입양되지 않은 시간대는 select 되지 안는다!!!!

-- 0 ~ 23 까지 SELECT 하는 쿼리
SELECT LEVEL - 1 FROM dual CONNECT BY LEVEL <= 24
;

SELECT h.hr "HOUR", count(datetime) "COUNT"
FROM
	(SELECT LEVEL - 1 hr FROM dual CONNECT BY LEVEL <= 24) h
	LEFT OUTER JOIN ANIMAL_OUTS a
	ON
	h.hr = to_number(to_char(a.datetime, 'hh24'))
GROUP BY h.hr
ORDER BY 1
;












