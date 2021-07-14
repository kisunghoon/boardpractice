CREATE TABLE test_department (
	dept_uid NUMBER PRIMARY KEY,
	dept_name VARCHAR(10) NOT NULL UNIQUE,
	dept_build VARCHAR(10) CHECK(dept_build IN ('K301', 'A203', 'B306'))
);

CREATE TABLE test_student (
	stu_uid NUMBER PRIMARY KEY,
	stu_name VARCHAR2(20) NOT NULL,
	stu_age INT CHECK (stu_age >= 0),
	stu_grade NUMBER CHECK(stu_grade BETWEEN 1 AND 4),
	stu_deptno NUMBER REFERENCES test_department(dept_uid)
);

-- #02

-- 일단 샘플 테이블 작성
DROP TABLE department CASCADE CONSTRAINTS;
DROP TABLE professor CASCADE CONSTRAINTS;
DROP TABLE student CASCADE CONSTRAINTS;

-- SELECT * FROM t_department;
CREATE TABLE department(
	deptno NUMBER PRIMARY KEY,
	dname VARCHAR(50)
);
INSERT INTO department SELECT deptno, dname FROM t_department;
-- SELECT * FROM department;

-- SELECT * FROM t_professor;
CREATE TABLE professor(
	profno NUMBER PRIMARY KEY,
	pname VARCHAR(50),
	deptno NUMBER REFERENCES department(deptno)
);
INSERT INTO professor SELECT profno, name, deptno FROM t_professor;
-- SELECT * FROM professor;

-- SELECT * FROM t_student;
CREATE TABLE STUDENT (
	studno NUMBER PRIMARY KEY,
	name VARCHAR(50),
	profno NUMBER REFERENCES professor(profno),
	deptno NUMBER REFERENCES department(deptno)
);
INSERT INTO student SELECT studno, name, profno, deptno1 FROM t_student;
-- SELECT * FROM student;

SELECT * FROM student;
SELECT * FROM professor;
SELECT * FROM department;

SELECT p.profno "지도교수번호",  p.pname "지도교수이름", d.dname "지도교수학과명", count(s.name) "지도학생수"
FROM professor p 
	LEFT OUTER JOIN student s ON p.profno = s.profno
	JOIN department d ON p.deptno = d.deptno
GROUP BY p.profno, p.pname, d.dname
;

-- subquery
SELECT p.profno "지도교수번호",  p.pname "지도교수이름", d.dname "지도교수학과명",
      (SELECT count(*) FROM student WHERE profno = p.profno ) "지도학생수"
FROM professor p, department d
WHERE p.deptno = d.deptno
;











