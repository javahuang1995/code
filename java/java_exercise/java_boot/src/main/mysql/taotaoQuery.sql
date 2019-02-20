-- 一共11个表

-- tb_content有个广告，是大广告 category_id是89，也就是会在前台显示
-- tb_content_category tb_content
SELECT * from tb_content_category t where t.id='89';
SELECT * from tb_content t where t.category_id='90';



-- 商品 商品分类 商品描述 tb_item tb_item_cat tb_item_desc
select* from tb_item t where t.title='情趣内衣啪啪啪';
select* from tb_item t where t.id='1068557';
select* from tb_item_cat t where t.id='560';
select * from tb_item_desc  t where t.item_id='1068557';

-- 规格参数 tb_item_param tb_item_param_item
SELECT * from tb_item_param t where t.item_cat_id='560';
SELECT * from tb_item_param_item t where t.item_id='536563';


-- 订单 大订单 订单项 物流订单信息 tb_order tb_order_item tb_order_shipping
select * from tb_order;
select * from tb_order_item;
select * from tb_order_shipping;


-- 用户信息 tb_user
select * from tb_user;
select * from tb_user t where t.username='huang';



INSERT INTO `taotao`.`tb_content` (
	`id`,
	`category_id`,
	`title`,
	`sub_title`,
	`title_desc`,
	`url`,
	`pic`,
	`pic2`,
	`content`,
	`created`,
	`updated`
)
VALUES
	(
		'77',
		'89',
		'标题1',
		'标题1',
		'标题1',
		'http://www.jd.com',
		'http://localhost:9000/images/2015/07/27/1437979301511057.jpg',
		NULL,
		'标题1',
		'2015-07-27 14:41:57',
		'2015-07-27 14:41:57'
	);





-- 一共11个表

-- tb_content有个广告，是大广告 category_id是89，也就是会在前台显示
-- tb_content_category tb_content
SELECT * from tb_content_category t where t.parent_id=0;-- 顶层目录
SELECT * from tb_content_category t where t.id='89';
SELECT * from tb_content t where t.category_id='89';


-- 商品 商品分类 商品描述 tb_item tb_item_cat tb_item_desc
select* from tb_item t where t.image!='http://image.taotao.com/common.jpg';
select* from tb_item t where t.title like '%大电视%';
select* from tb_item t where t.title like '%dd%';
select* from tb_item t where t.title like '%合约%';
select* from tb_item t where t.image like '%jd%';

select * from tb_item tt where tt.id not in (select t.id from tb_item t where t.image like '%jd%')
select * from tb_item t where t.image like '%jd%';

update tb_item t set t.image='http://image.taotao.com/common.jpg'
where t.image like '%jd%';



select* from tb_item t where t.id='1068557';
select* from tb_item_cat t where t.id='560';
select* from tb_item_cat t order by t.created desc;
select* from tb_item_cat t where t.parent_id=0; -- 顶层商品目录
select* from tb_item_cat t where t.parent_id=6666666;

select * from tb_item_desc  t where t.item_id='1068557';

-- 规格参数 tb_item_param tb_item_param_item
SELECT * from tb_item_param t where t.item_cat_id='560';
SELECT * from tb_item_param_item t where t.item_id='536563';


-- 订单 大订单 订单项 物流订单信息 tb_order tb_order_item tb_order_shipping
select * from tb_order;
select * from tb_order_item;
select * from tb_order_shipping;



-- 用户信息 tb_user
select * from tb_user;
select * from tb_user t where t.username='huang';



-- 查询商品大类信息 parent_id为0
select count(*) from tb_item_cat t where t.parent_id=0;
select * from tb_item_cat t where t.parent_id=0;



INSERT INTO `taotao`.`tb_content` (
	`id`,
	`category_id`,
	`title`,
	`sub_title`,
	`title_desc`,
	`url`,
	`pic`,
	`pic2`,
	`content`,
	`created`,
	`updated`
)
VALUES
	(
		'77',
		'89',
		'标题1',
		'标题1',
		'标题1',
		'http://www.jd.com',
		'http://localhost:9000/images/2015/07/27/1437979301511057.jpg',
		NULL,
		'标题1',
		'2015-07-27 14:41:57',
		'2015-07-27 14:41:57'
	);













