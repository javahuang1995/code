declare

  cursor cur_emp(var_job in varchar2 := 'SALESMAN') is
    select empno, ename, sal from emp where job = var_job;

  type record_tmp is record(
    var_empno   emp.empno%type,
    var_empname emp.ename%type,
    var_sal     emp.sal%type);
  emp_row record_tmp;

begin
  open cur_emp('MANAGER');
  fetch cur_emp
    into emp_row;
  while cur_emp%found loop
    dbms_output.put_line(emp_row.var_empname || '�����' || emp_row.var_empno);
    fetch cur_emp
      into emp_row;
  end loop;
  close cur_emp;
end;
/




--��for���ѭ���α���ӷ���
begin
  for emp_record in (select * from emp where job = 'SALESMAN') loop
    dbms_output.put_line(emp_record.ename);
  end loop;

end;
