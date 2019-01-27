--·ÖÇø±í
create tablespace huang datafile 
'f:\OracleFile\huang.dbf' size 100m
 extend management local autoallocate;

drop table ware_retail_part;
create table ware_retail_part(
id integer primary key,
retail_date date,
ware_name varchar2(50)
)

partition by range(retail_date)(
partition par_01 values less than(to_date('2011-04-01','yyyy-mm-dd')) tablespace huang,
partition par_02 values less than(to_date('2011-07-01','yyyy-mm-dd')) tablespace huang,
partition par_03 values less than(to_date('2011-10-01','yyyy-mm-dd')) tablespace huang
);

select t.rowid,t.*from crm.ware_retail_part t;
select * from ware_retail_part t partition(par_01);
