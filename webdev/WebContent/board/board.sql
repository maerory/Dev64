CREATE SEQUENCE seq_board;



/* Create Tables */

CREATE TABLE board
(
   no number NOT NULL,
   name varchar2(20) NOT NULL,
   title varchar2(100) NOT NULL,
   passwd varchar2(128) NOT NULL,
   content varchar2(4000) NOT NULL,
   regdate date DEFAULT sysdate NOT NULL,
   readcount number(5) DEFAULT 0 NOT NULL,
   PRIMARY KEY (no)
);

select * from board;

update board set
passwd = (select passwd from board where no=4);

commit

select no,passwd from board;


select no, name, title, to_char(regdate,'YYYY/MM/DD') as regdate, readcount
from BOARD
order by no desc;

c ;
