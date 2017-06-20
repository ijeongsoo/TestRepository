select * 
from board
where bwriter='홍길동';



select bno, btitle, bwriter
from board
where bwriter='홍길동';



select * from board where bno<=10 and bno>=1;


select * from board where bno between 1 and 10;


select bno, btitle, bwriter from board where BWRITER like '%홍%';


select bno, btitle, bwriter from board where BTITLE like '%자바%';


select bno, btitle, bwriter, bcontent from board where BTITLE like '%자바%' or BCONTENT like '%자바%';


select bno, btitle, bwriter from board where bwriter in ('감자바','김길동','라즈베리');



select * from board where BORIGINALFILENAME is null;

--시험문제--
select * from board where BORIGINALFILENAME is not null;


select DISTINCT bwriter from board;


select * from board where '2016.01.01'<=bdate and bdate<='2016.12.31';


select * from board where bdate between '2016.01.01' and '2016.12.31';


select * from board where to_char(BDATE, 'YYYY') > '2016';


select bno 번호, btitle 제목, bwriter 글쓴이 from board;


select * from board ORDER BY bno;


select * from board where to_char(BDATE, 'YYYY') ='2017' order by bno desc;


select * from board order by bwriter , bno desc;

--페이징 처리

select rownum, bno, btitle, bwriter, bdate, bhitcount 
from board;


select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc)
where rownum<=10;

select *
from(
    select rownum as r, bno, btitle, bwriter, bdate, bhitcount
    from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc)
    where rownum<=(pageNo*rowsPerPage)
)
where r>=((pageNo-1)*rowsPerPage+1);



select count(*) from board;
select count(bno) from board;
select count(boriginalfilename) from board;

select count(*) from board where bwriter <> '홍길동';

select count(*) from board group by bwriter;



