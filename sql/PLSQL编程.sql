--set serveroutput on;
declare
 a int:=100;
 b int:=200;
 c number;
 d varchar2(100);--100�Ǹ�������󳤶�
 today date;
--l_date date:= TO_DATE ('January 11 2011', 'Month DD YYYY');
flag boolean :=true;
var_job emp.job%type;
type my_type is record(
     var_ename varchar2(20),
     var_job varchar2(20),
     var_sal number
);
chang constant varchar2(10):='aaa';
var_emp emp%rowtype;
 begin 
    c:=a+b;
    d:='hehelo';
    today:=sysdate;
    today:=systimestamp;
   dbms_output.put_line('hello c is :' || c ||d || to_char(today,'YYYY-MM-DD HH24:MI:SS'));
   --
   select * into var_emp from emp where empno=7369;
   
   exception
   when zero_divide then
     dbms_output.put_line('error');
end;

/     


 


=======
--�������׽�쳣
 declare
begin
  insert into dept values (10, '��', 'ˮ���');
  dbms_output.put_line('end');
end;
/

 --�Զ����쳣
declare
  primary_iterant exception;
  pragma exception_init(primary_iterant, -00001);
begin
  insert into dept values (10, '��', 'ˮ���');
   dbms_output.put_line('end');
exception
  when primary_iterant then
    dbms_output.put_line('error');
    dbms_output.put_line('end');
end;
/





