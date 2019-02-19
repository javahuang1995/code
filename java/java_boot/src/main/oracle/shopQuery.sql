select table_name,t.* from user_tables t;
select t.owner,t.* from all_tables t where t.owner='HUANG';-- 查询的时候注意用户名要大写
select t.owner,t.* from all_tables t where t.table_name like 't_%';



select * from huang.t_category t;
SELECT * from t_product;
SELECT * from t_account; -- 后台管理员
select * from t_sorder t;-- 订单项
SELECT * from t_forder t;-- 订单
select * from t_user t;
select * from t_status t;

