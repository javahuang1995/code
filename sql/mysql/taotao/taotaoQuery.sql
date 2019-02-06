SELECT * from tb_content;
SELECT * from tb_content_category;


/**商品项目**/
select* from tb_item_cat t where t.id='380';
select* from tb_item t where t.title='dfdsds';/**按照商品名字查询**/
select * from tb_item_desc  t where t.item_id='154713201110312';

SELECT * from tb_item_param t;
SELECT * from tb_item_param_item t;


select * from tb_item_param;

/**--订单--每个订单项--物流表**/
select * from tb_order;
select * from tb_order_item;
select * from tb_order_shipping;


select * from tb_user;



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

