-- 제약조건

SELECT * FROM t_dept2;

-- 제약조건을 컬럼 정의와 함께 명시하는 방법
DROP TABLE t_emp4 CASCADE CONSTRAINT;  -- 테이블 삭제시 제약조건도 함께 삭제
CREATE TABLE t_emp4(
	no NUMBER(4) PRIMARY KEY,
	name VARCHAR2(10) NOT NULL,
	jumin VARCHAR2(13) NOT NULL UNIQUE,
	area NUMBER(1) CHECK(area < 5),
	deptno VARCHAR2(6) REFERENCES t_dept2(dcode)
)

-- 제약조건을 별도의 항목으로 설정 가능.
DROP TABLE t_emp4 CASCADE CONSTRAINT;  -- 테이블 삭제시 제약조건도 함께 삭제
CREATE TABLE t_emp4(
	no NUMBER(4),
	name VARCHAR2(10) NOT NULL,
	jumin VARCHAR2(13) NOT NULL,
	area NUMBER(1),
	deptno VARCHAR2(6),
	PRIMARY KEY(no),
	UNIQUE(jumin),
	CHECK(area < 5),
	FOREIGN KEY (deptno) REFERENCES t_dept2(dcode)
)

-- #9002
-- 제약조건 명을 명시
DROP TABLE t_emp3 CASCADE CONSTRAINT;  -- 테이블 삭제시 제약조건도 함께 삭제
CREATE TABLE t_emp3(
	no NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY KEY,
	name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL,
	jumin VARCHAR2(13) 
		CONSTRAINT emp3_jumin_nn NOT NULL 
		CONSTRAINT emp3_jumin_uk UNIQUE,
	area NUMBER(1) CONSTRAINT emp3_area_ck CHECK(area < 5),
	deptno VARCHAR2(6) CONSTRAINT emp3_deptno_fk REFERENCES t_dept2(dcode)
)

-- 별도 항목으로도 정의 가능
DROP TABLE t_emp3 CASCADE CONSTRAINT;  -- 테이블 삭제시 제약조건도 함께 삭제
CREATE TABLE t_emp3(
	no NUMBER(4),
	name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL,
	jumin VARCHAR2(13) 
		CONSTRAINT emp3_jumin_nn NOT NULL,
	area NUMBER(1),
	deptno VARCHAR2(6),
	CONSTRAINT emp3_no_pk PRIMARY KEY(no),
	CONSTRAINT emp3_jumin_uk UNIQUE(jumin),
	CONSTRAINT emp3_area_ck CHECK(area < 5),
	CONSTRAINT emp3_deptno_fk FOREIGN KEY(deptno) REFERENCES t_dept2(dcode)
)

SELECT * FROM t_emp3;
SELECT * FROM t_emp4;

-- #9003  제약조건 조회
SELECT owner,  CONSTRAINT_NAME , CONSTRAINT_TYPE , status
FROM USER_CONSTRAINTS 
WHERE table_name = 'T_EMP4';  -- 테이블명 대문자로!
;

-- CONSTRAINT TYPE
-- 'C' : NN, CK
-- 'P' : PK
-- 'U' : UK
-- 'R' : FK

SELECT owner,  CONSTRAINT_NAME , CONSTRAINT_TYPE , status
FROM USER_CONSTRAINTS 
WHERE table_name = 'T_EMP3';  -- 테이블명 대문자로!
;

-- #9005) t_emp3 의 제약조건에 위배되는 DML 시도해보기.
INSERT INTO t_emp3 VALUES(
	1, '오라클', '1234561234567', 4, 1000
);
-- 위 쿼리 두번실행하면 에러 : ORA-00001: unique constraint (SCOTT26.EMP3_NO_PK) violated

SELECT * FROM t_emp3;
SELECT * FROM t_dept2;

INSERT INTO t_emp3 VALUES(
	2, '오라클', '1234561234567', 4, 1000
); -- 에러 : ORA-00001: unique constraint (SCOTT26.EMP3_JUMIN_UK) violated

INSERT INTO t_emp3 VALUES(
	2, '오라클', '22222222222222222', 4, 1000
);
-- 에러 : VARCHAR2(13) 초과 오류
-- ORA-12899: value too large for column "SCOTT26"."T_EMP3"."JUMIN" (actual: 17, maximum: 13)

INSERT INTO t_emp3 VALUES(
	2, '오라클', '2222222222222', 10, 1000
);
-- 에러:
-- ORA-01438: value larger than specified precision allowed for this column


INSERT INTO t_emp3 VALUES(
	2, '오라클', '2222222222222', 3, 2000
);

-- 에러
-- ORA-02291: integrity constraint (SCOTT26.EMP3_DEPTNO_FK) violated - parent key not found

INSERT INTO t_emp3 (NO, jumin, area, deptno) VALUES(
	2, '3333333333333', 4, 1001
); 
-- 에러
-- ORA-01400: cannot insert NULL into ("SCOTT26"."T_EMP3"."NAME")

SELECT * FROM t_emp3;
UPDATE t_emp3 SET area = 10 WHERE NO = 1;
-- 에러 : CK

DELETE FROM t_dept2 WHERE dcode = 1000;
-- ORA-02292: integrity constraint (SCOTT26.EMP3_DEPTNO_FK) violated - child record found

-- #9005) ALTER 를 사용하여 테이블에 제약조건 추가가능
ALTER TABLE t_emp4
ADD CONSTRAINT emp4_name_uk UNIQUE(name);

ALTER TABLE t_emp4
ADD CONSTRAINT emp4_area_nn NOT NULL(area);
-- 이미 컬럼의 기본값이 null 허용으로 되어 있기 때문에 ADD 가 아닌 MODIFY 로 해야 한다.

ALTER TABLE t_emp4
MODIFY (area CONSTRAINT emp4_area_nn NOT NULL);


-- #9008)
DROP TABLE t_emp3 CASCADE CONSTRAINT;  -- 테이블 삭제시 제약조건도 함께 삭제
CREATE TABLE t_emp3(
	no NUMBER(4),
	name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL,
	jumin VARCHAR2(13) 
		CONSTRAINT emp3_jumin_nn NOT NULL,
	area NUMBER(1),
	deptno VARCHAR2(6),
	CONSTRAINT emp3_no_pk PRIMARY KEY(no),
	CONSTRAINT emp3_jumin_uk UNIQUE(jumin),
	CONSTRAINT emp3_area_ck CHECK(area < 5),
	CONSTRAINT emp3_deptno_fk FOREIGN KEY(deptno) 
		REFERENCES t_dept2(dcode) 
		-- ON DELETE CASCADE --  부모테이블의 참조가 삭제되면 함께 자동 삭제
		ON DELETE SET NULL  --  부모테이블의 참조가 삭제되면 null  로 남아있기
		-- ON UPDATE  -- 부모테이블의 참조 내용이 수정되는 경우. (오라클은 지원안함)
)

SELECT * FROM t_dept2;
INSERT INTO t_dept2 VALUES(5000, '야근팀', '0001', '전국구');

INSERT INTO t_emp3 VALUES(
	1, '오라클', '1234561234567', 3, 5000
);
SELECT * FROM t_emp3;

DELETE FROM t_dept2 WHERE dcode = 5000;









