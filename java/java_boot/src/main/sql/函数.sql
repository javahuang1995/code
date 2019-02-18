-- -- 如果有这个函数，就删除
--drop function if exists hello;
---- 创建一个无参的函数
--create function hello() 
-- -- 设置函数的返回类型
--returns varchar (255)
--begin-- 函数头
--    -- 中间的是函数体
--    return '一个简单的mysql函数'; -- 函数的返回值
--end; -- 函数结尾


drop function if exists hello;
-- a、b 都是函数的参数
--在创建一个带参数的自定义函数，函数是把传入的参数拼接成一个字符串返回出来
create function hello(a varchar(20),b varchar(20)) returns varchar (255)
begin
    begin
    -- declare 声明参数，default：设置声明参数的默认值
    declare x varchar(255) default ' x  ';
    declare y varchar(255) default b;
    declare c varchar(255) default ' 2017-01-02  ';
    declare d varchar(255);
    -- set 给声明的参数赋值
    SET d = concat(x,a,b,y,c);
    return d;
end;




select hello();

--函数可以和select混搭，实现复杂的sql
select hello(),t.STUDENT_NAME from tb_student t;


DROP FUNCTION hello; -- hello是函数名。







