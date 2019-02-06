alter table account rename t_account;
alter table category rename t_category;
alter table product rename t_product;
alter table sorder rename t_sorder;
alter table forder rename t_forder;
alter table `status` rename t_status;
alter table `user` rename t_user;

select * from t_category t;
SELECT * from t_product;
SELECT * from t_account; -- 后台管理员
select * from t_sorder t;-- 订单项
SELECT * from t_forder t;-- 订单
select * from `t_user` t;
select * from `t_status` t;

select * from 


-- Ctrl / 添加注释
-- 连接查询 外连接 内连接 。。
-- --后面有个空格
alter database test default character set utf8;

alter table account convert to character set utf8;
alter table category convert to character set utf8;
alter table forder convert to character set utf8;
alter table sorder convert to character set utf8;
alter table `status` convert to character set utf8;
alter table `user` convert to character set utf8;

-- 内连接
select * from category t INNER JOIN account tt on t.aid=tt.id;

-- 外连接 ：左外连接(left join)left outer join  右外连接(right join)right outer join 完全外连接(full join)full outer join
select * from category t LEFT OUTER JOIN account tt on t.aid=tt.id;
select * from category t RIGHT OUTER JOIN account tt on t.aid=tt.id;
select * from category t LEFT OUTER JOIN account tt on t.aid=tt.id union select * from category t RIGHT OUTER JOIN account tt on t.aid=tt.id;
-- 【注意】：Oracle数据库支持full join，mysql是不支持full join的，但仍然可以同过左外连接+ union+右外连接实现
-- select * from category t full JOIN account tt on t.aid=tt.id;
-- 笛卡尔积
select * from category join account;








