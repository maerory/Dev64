begin
for i in 1..10002 loop
insert into t_article(no, title, name, content,passwd)
values(seq_article.nextval,'난 알아요','서태지','이밤이 흐르면','1111');
end loop;
end;
/
commit

SELECT B.*
FROM  (SELECT rownum as rnum, A.*
	   FROM	 (select no, title, name, readcount
		            ,to_char(regdate,'YYYY/MM/DD') as regdate
		      from   t_article
		      order  by no desc) A) B
WHERE  rnum between 11 and 20;
	
	
4:SELECT
1:FROM
2:WHERE
3:GROUP BY
5:HAVING
6:ORDER BY

















update t_article set
		passwd = (select passwd from t_article
		          where  no=10063);
commit

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

select * from t_article;

select no, title, name, readcount 
      ,to_char(regdate,'YYYY/MM/DD') as regdate
from   t_article
order  by no desc;

select no, title, name, readcount, regdate, content  
from   t_article
where  no=7;











