change master to
master_host='192.168.0.10',
master_user='root',
master_password='1995',
master_port=3306,
master_log_file='mysql-bin.000001',
master_log_pos=2373;

start slave;
stop slave;

show slave status;


select * from test.huang_hehe t;