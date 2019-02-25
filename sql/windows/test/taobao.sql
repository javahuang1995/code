SELECT * from tb_item t where exists(SELECT t.cid from tb_item_cat t where t.title='手机');

SELECT * from tb_item t where t.cid in(76,298);