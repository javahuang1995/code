INSERT INTO  huang . tb_item_param  ("id",  item_cat_id ,  param_data ,  created ,  "updated" ) VALUES ('1', '3', '[{\"group\":\"组名1\",\"params\":[\"组员1\",\"组员2\"]},{\"group\":\"组名2\",\"params\":[\"组员1\",\"组员2\"]},{\"group\":\"组名3\",\"params\":[\"组员1\",\"组员2\",\"组员3\",\"组员4\"]}]',sysdate, sysdate);
INSERT INTO  huang . tb_item_param  ("id",  item_cat_id ,  param_data ,  created ,  "updated" ) VALUES ('2', '560', '[{\"group\":\"主体\",\"params\":[\"品牌\",\"型号\",\"颜色\",\"上市年份\"]},{\"group\":\"网络\",\"params\":[\"4G网络制式\",\"3G网络制式\",\"2G网络制式\"]},{\"group\":\"存储\",\"params\":[\"机身内存\",\"储存卡类型\"]}]',sysdate,sysdate);
INSERT INTO  huang . tb_item_param  ("id",  item_cat_id ,  param_data ,  created ,  "updated" ) VALUES ('3', '298', '[{\"group\":\"g1\",\"params\":[\"aa\",\"bb\",\"cc\"]},{\"group\":\"g2\",\"params\":[\"ad\",\"sd\"]},{\"group\":\"g3\",\"params\":[\"sdd\",\"sdfs\",\"dfg\"]}]',sysdate, sysdate);
INSERT INTO  huang . tb_item_param  ("id",  item_cat_id ,  param_data ,  created ,  "updated" ) VALUES ('21', '440', '[{\"group\":\"1\",\"params\":[\"2w\"]},{\"group\":\"2\",\"params\":[\"1\"]},{\"group\":\"3\",\"params\":[\"1\"]},{\"group\":\"4\",\"params\":[\"1\"]}]',sysdate, sysdate);

INSERT INTO  huang . tb_item_param  ("id",  item_cat_id ,  param_data ,  created ,  "updated" ) VALUES ('22', '298', '[{\"group\":\"f1\",\"params\":[\"1\"]},{\"group\":\"f2\",\"params\":[\"2\"]}]',sysdate, sysdate);
INSERT INTO  huang . tb_item_param  ("id",  item_cat_id ,  param_data ,  created ,  "updated" ) VALUES ('23', '257', '[{\"group\":\"12\",\"params\":[\"12\"]}]',sysdate, sysdate);
INSERT INTO  huang . tb_item_param  ("id",  item_cat_id ,  param_data ,  created ,  "updated" ) VALUES ('24', '443', '[{\"group\":\"股氯气\",\"params\":[\"撒旦法\"]}]', sysdate, sysdate);
INSERT INTO  huang . tb_item_param  ("id",  item_cat_id ,  param_data ,  created ,  "updated" ) VALUES ('25', '298', '[{\"group\":\"1\",\"params\":[\"1\"]}]',sysdate, sysdate);
INSERT INTO  huang . tb_item_param  ("id",  item_cat_id ,  param_data ,  created ,  "updated" ) VALUES ('26', '582', '[{\"group\":\"分组1\",\"params\":[\"参数1\",\"参数2\",\"参数3\",\"参数4\",\"参数5\"]},{\"group\":\"分组2\",\"params\":[\"参数21\",\"参数22\",\"参数23\",\"参数24\"]}]',sysdate, sysdate);
INSERT INTO  huang . tb_item_param  ("id",  item_cat_id ,  param_data ,  created ,  "updated" ) VALUES ('27', NULL, '[{\"group\":\"fh\",\"params\":[\"gg\",\"gh\"]}]',sysdate, sysdate);

INSERT INTO  huang . tb_item_param  ("id",  item_cat_id ,  param_data ,  created ,  "updated" ) VALUES ('28', NULL, '[{\"group\":\"fgfd\",\"params\":[\"dsdd\"]}]',to_date('2019-01-13 23:43:44', 'yyyy-mm-dd hh24:mi:ss'),to_date('2019-01-13 23:43:44', 'yyyy-mm-dd hh24:mi:ss'));

select to_date('2019-01-13 23:43:44', 'yyyy-mm-dd hh24:mi:ss') from dual;


select t.*,t.rowid from huang."tb_item" t;

select t.*,t.rowid from HUANG."tb_content" t;


select t.*,t.rowid from huang.TB_CONTENT t;
select t.*,t.rowid from huang.TB_CONTENT_CATEGORY t;
select t.*,t.rowid from huang.tb_item t;

select t.*,t.rowid from huang.TB_ITEM_CAT t;
select t.*,t.rowid from huang.TB_ITEM_PARAM t;
select t.*,t.rowid from huang.TB_ITEM_DESC t;


select t.*,t.rowid from huang.TB_ITEM_PARAM t;

select t.*,t.rowid from huang.TB_ITEM_PARAM_ITEM t;




select t.*,t.rowid from TB_ORDER t;
select t.*,t.rowid from TB_ORDER_ITEM t ;
select t.*,t.rowid from TB_ORDER_SHIPPING t ;


select t.*,t.rowid from tb_user t ;



