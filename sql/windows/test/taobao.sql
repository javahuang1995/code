SELECT * from tb_item t where exists(select * from tb_item where t);

SELECT * from tb_item t where t.cid in(76,298);