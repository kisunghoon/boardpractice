
/* Drop Tables */

DROP TABLE exam_weather CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE exam_weather
(
	w_uid number NOT NULL,
	city varchar2(30) NOT NULL,
	temp number(3,1) NOT NULL,
	weather varchar2(100),
	PRIMARY KEY (w_uid)
);
CREATE SEQUENCE exam_weather_seq;


SELECT * FROM EXAM_WEATHER;
INSERT INTO	exam_weather VALUES (exam_weather_seq.nextval, '서울', 2.0, '맑음');
INSERT INTO	exam_weather VALUES (exam_weather_seq.nextval, '인천', 17.0, '맑음');
INSERT INTO	exam_weather VALUES (exam_weather_seq.nextval, '경기', 11.1, '흐림');
INSERT INTO	exam_weather VALUES (exam_weather_seq.nextval, '대구', 13.4, '안개');

INSERT INTO EXAM_WEATHER (w_uid , city , temp , weather)
SELECT exam_weather_seq.nextval, city , temp , weather
FROM EXAM_WEATHER;

