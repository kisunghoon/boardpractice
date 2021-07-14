
/* Drop Tables */

DROP TABLE exam_book CASCADE CONSTRAINTS;

/* Create Tables */

CREATE TABLE exam_book
(
	bk_uid number NOT NULL,
	bk_subject varchar2(20) NOT NULL,
	bk_content clob,
	bk_price number DEFAULT 0,
	bk_viewcnt number DEFAULT 0,
	bk_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (bk_uid),
	CHECK(bk_price >= 0),
	CHECK(bk_viewcnt >= 0)
);

CREATE SEQUENCE exam_book_seq;
DROP SEQUENCE exam_book_seq;

SELECT * FROM EXAM_BOOK ORDER BY bk_uid DESC;

