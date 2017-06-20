create table account(
    ano varchar(20) primary key, 
    aowner varchar(10) not null, 
    amount number not null
    );
    
alter table account
rename column amount to abalance
;
    
insert into account values('111-111', '홍길동', 1000000);
insert into account values('222-222', '스프링', 0);

select * from account;

rollback;
commit;

--기능 단위의 트랜잭션--
update account set abalance=abalance-10000 where ano='111-111';
update account set abalance=abalance+10000 where ano='222-223';
rollback;