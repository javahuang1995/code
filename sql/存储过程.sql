create or replace procedure pro_test is
begin
  insert into dept values(77,'sdf','sdfsd');
  commit;
end pro_test;
/

begin
    pro_test;  
end;
/

--execute pro_test;
