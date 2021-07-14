-- #6301

SELECT * FROM t_emp;
SELECT * FROM t_dept;

SELECT e.deptno, empno, e.ENAME, d.dname
FROM t_emp e, t_dept d
WHERE e.deptno = d.deptno
ORDER BY empno;

SELECT deptno, empno, ename, dname
FROM t_emp NATURAL JOIN t_dept
ORDER BY empno;
