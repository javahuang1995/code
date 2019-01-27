--在公司里面习惯用in，in可以表示范围，可以匹配多个，用=则匹配一个
select empno,ename,job from emp
where deptno=(select deptno from dept t where t.dname='RESEARCH');

select * from dept ;


select empno,ename,job from emp
where deptno in (select deptno from dept t where t.dname in('RESEARCH','SALES'));

--也可以用关联查询，效率更高
select empno,ename,job from emp join dept on emp.deptno=dept.deptno 
where dept.dname='RESEARCH';

--1.查询员工，部门不为10
--2.工资大于任意一个部门为10的员工
select * from emp where sal>any(select sal from emp where deptno=10) and deptno<>10;

--2.工资大于所有部门为10的员工
select * from emp where sal>all(select sal from emp where deptno=10) and deptno<>10;

