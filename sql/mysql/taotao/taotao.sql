/* tb_content有个广告，是大广告 category_id是89，也就是会在前台显示的**/
SELECT * from tb_content;
SELECT * from tb_content_category t where t.id='89';


/**商品项目**/
select* from tb_item_cat t where t.id='560';
select* from tb_item t where t.title='情趣内衣啪啪啪';/**按照商品名字查询 商品如果有多个图片是用逗号分隔的**/
select * from tb_item_desc  t where t.item_id='536563';

SELECT * from tb_item_param t where t.item_cat_id='560';
SELECT * from tb_item_param_item t where t.item_id='536563';

select * from tb_item_param;

/**--订单--每个订单项--物流表**/
select * from tb_order;
select * from tb_order_item;
select * from tb_order_shipping;


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

