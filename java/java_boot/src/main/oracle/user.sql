
create user huang identified by 1995;
create user taotao;

grant connect,resource to huang;


-- 查询用户下所有的表
select * from all_tables where owner='huang';

select table_name from user_tables;



select * from user_tables;

