create SEQUENCE s_board;
create table board(
    bno number CONSTRAINT board_bno_p primary key,
    bsubject varchar2(300) not null,
    bname varchar2(300) not null,
    bcontent clob not null,
    breg_dt date default sysdate
);

select * from board;