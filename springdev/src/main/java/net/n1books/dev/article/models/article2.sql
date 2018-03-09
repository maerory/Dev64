
/* Drop Tables */

DROP TABLE t_article CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE seq_article;




/* Create Sequences */

CREATE SEQUENCE seq_article;



/* Create Tables */

CREATE TABLE t_article
(
	no number NOT NULL,
	title varchar2(100) NOT NULL,
	name varchar2(20) NOT NULL,
	passwd varchar2(128) NOT NULL,
	readcount number(5) DEFAULT 0 NOT NULL,
	regdate date DEFAULT sysdate NOT NULL,
	content varchar2(4000) NOT NULL,
	PRIMARY KEY (no)
);


select no, title, name, regdate, readcount
from t_article
order by no desc;


select no, title, name, readcount, regdate, content
from t_article
where no=1;



