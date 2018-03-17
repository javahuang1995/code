--解锁普通用户scott
alter user scott account unlock;

select * from user_tables t;

select * from dba_tables t where t.owner=upper('scott');


select * from scott.emp;

select distinct job from scott.emp;


select empno,ename,job from scott.emp where job in ('MANAGER');

--分组查询
select * from scott.emp t;
select deptno,job,avg(sal),count(*) from scott.emp t group by t.deptno,t.job order by t.deptno;
select t.job from scott.emp t group by t.job;

create tablespace test(表空间的名字) 
datafile 'D:\oracle\product\10.2.0\userdata\test.dbf'  (这边可以写成oracle的某个路径下)
size 50m  （初始大小）
autoextend on;（自动扩展）

CREATE USER crm 
IDENTIFIED BY crm;

GRANT CONNECT TO crm;  
GRANT RESOURCE TO crm;  
GRANT dba TO crm;--dba为最高级权限，可以创建数据库，表等。


CREATE USER crm 
IDENTIFIED BY 'crm';
DEFAULT TABLESPACE test
TEMPORARY TABLESPACE temp;

select * from user_all_tables t;

select * from v_login ;


select * from crm.login t;

create table v_login as select * from crm.login;
select count(login_id) from v_login v where v.acount='111';
