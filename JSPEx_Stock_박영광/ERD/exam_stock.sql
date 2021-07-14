
/* Drop Tables */

DROP TABLE exam_stock CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE exam_stock
(
	ex_uid number NOT NULL,
	ex_name varchar2(100) NOT NULL,
	ex_intro clob,
	ex_total number DEFAULT 0,
	ex_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (ex_uid),
	CHECK(ex_total >= 0)
	
);

CREATE SEQUENCE exam_stock_seq;
DROP SEQUENCE exam_stock_seq;

INSERT INTO EXAM_STOCK (ex_uid, ex_name, ex_intro, EX_REGDATE) VALUES (exam_stock_seq.nextval, 'LG_MONITOR', '모니터', sysdate);
INSERT INTO EXAM_STOCK VALUES (exam_stock_seq.nextval, 'Intel i7', 'CPU', 10, sysdate);
INSERT INTO EXAM_STOCK VALUES (exam_stock_seq.nextval, 'GeForce RTX', '그래픽카드', 22, sysdate);
INSERT INTO EXAM_STOCK VALUES (exam_stock_seq.nextval, 'Intel i5', 'CPU', 6, sysdate);
INSERT INTO EXAM_STOCK VALUES (exam_stock_seq.nextval, 'Logitech G102IC', '마우스', 77, sysdate);

SELECT * FROM EXAM_STOCK;

SELECT ex_uid "uid", ex_name name, ex_intro intro, ex_total total, ex_regdate regdate 
FROM exam_stock ORDER BY ex_uid DESC
