/**查看MYSQL数据库服务器和数据库字符集**/
show variables like '%character%';

show charset;
show table status from test like  'student%';


alter database test default character set utf8;
alter table student_tbl convert to character set utf8;



/***** 建立student表 *****/  
CREATE TABLE tb_student  
(  
   STUDENT_ID         VARCHAR(255) PRIMARY KEY auto_increment,  
   STUDENT_NAME       VARCHAR(10) NOT NULL,  
   STUDENT_SEX        VARCHAR(10),  
   STUDENT_BIRTHDAY   DATE,  
   CLASS_ID           VARCHAR(255)  ,
   TEACHER_ID         VARCHAR(255)
)DEFAULT CHARSET=utf8;  

CREATE TABLE tb_teacher
(  
   TEACHER_ID         VARCHAR(255) PRIMARY KEY auto_increment,  
   TEACHER_NAME       VARCHAR(10) NOT NULL,  
   TEACHER_SEX        VARCHAR(10),  
   TEACHER_BIRTHDAY   DATE,  
   WORK_DATE           VARCHAR(255),
	 PROFESSIONAL				 VARCHAR(10),
)DEFAULT CHARSET=utf8;  
  
alter table tb_student  modify STUDENT_ID VARCHAR(255) AUTO_INCREMENT;
alter table tb_student auto_increment = 5 ;

alter table tb_teacher auto_increment = 5 ;


select UUID()
  
/*插入学生数据*/  
INSERT INTO tb_student ( STUDENT_ID,  
                         STUDENT_NAME,  
                         STUDENT_SEX,  
                         STUDENT_BIRTHDAY,  
                         CLASS_ID)  
  VALUES   (123457,  
            '美女',  
            'w',  
            '1980-08-01',  
            121546  
            );
alter table tb_student add COLUMN teacher_id VARCHAR(255) ;
alter table tb_student add CONSTRAINT `FK_student_teacher_id_on_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `tb_teacher` (`teacher_id`)


INSERT INTO tb_teacher ( TEACHER_ID,  
                         TEACHER_NAME,  
                         TEACHER_SEX,  
                         TEACHER_BIRTHDAY 
                         )  
  VALUES   (666,  
            '美女老师',  
            'w',  
            '1980-08-01'
            );


select nextval('student');

SELECT  * from tb_student t;
SELECT * from tb_teacher t;




INSERT INTO `test`.`tb_student`
VALUES
	(
		null,
		'大美女',
		'女',
		'1980-08-01',
		'121546',
		'666'
	);





delete from tb_student t where t.student_id='2';
delete from tb_student where student_id='33';


/**分页查询是用limit实现的**/




DROP PROCEDURE IF EXISTS Proc; 

DELIMITER //
CREATE PROCEDURE Proc() 
BEGIN
  SELECT * FROM tb_student;
END//
DELIMITER ;

CALL Proc(); 




-- 创建一个无参的函数
create function hello() 
 -- 设置函数的返回类型
returns varchar (255)
begin-- 函数头
    -- 中间的是函数体
    return '一个简单的mysql函数'; -- 函数的返回值
end; -- 函数结尾

select hello(),t.STUDENT_NAME from tb_student t;

/**查看MYSQL数据库服务器和数据库字符集**/
show variables like '%character%';

show charset;
show table status from test like  'student%';


alter database test default character set utf8;
alter table student_tbl convert to character set utf8;



/***** 建立student表 *****/  
CREATE TABLE tb_student  
(  
   STUDENT_ID         VARCHAR(255) PRIMARY KEY auto_increment,  
   STUDENT_NAME       VARCHAR(10) NOT NULL,  
   STUDENT_SEX        VARCHAR(10),  
   STUDENT_BIRTHDAY   DATE,  
   CLASS_ID           VARCHAR(255)  ,
   TEACHER_ID         VARCHAR(255)
)DEFAULT CHARSET=utf8;  

CREATE TABLE tb_teacher
(  
   TEACHER_ID         VARCHAR(255) PRIMARY KEY auto_increment,  
   TEACHER_NAME       VARCHAR(10) NOT NULL,  
   TEACHER_SEX        VARCHAR(10),  
   TEACHER_BIRTHDAY   DATE,  
   WORK_DATE           VARCHAR(255),
	 PROFESSIONAL				 VARCHAR(10),
)DEFAULT CHARSET=utf8;  
  
alter table tb_student  modify STUDENT_ID VARCHAR(255) AUTO_INCREMENT;
alter table tb_student auto_increment = 5 ;

alter table tb_teacher auto_increment = 5 ;


select UUID()
  
/*插入学生数据*/  
INSERT INTO tb_student ( STUDENT_ID,  
                         STUDENT_NAME,  
                         STUDENT_SEX,  
                         STUDENT_BIRTHDAY,  
                         CLASS_ID)  
  VALUES   (123457,  
            '美女',  
            'w',  
            '1980-08-01',  
            121546  
            );
alter table tb_student add COLUMN teacher_id VARCHAR(255) ;
alter table tb_student add CONSTRAINT `FK_student_teacher_id_on_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `tb_teacher` (`teacher_id`)


INSERT INTO tb_teacher ( TEACHER_ID,  
                         TEACHER_NAME,  
                         TEACHER_SEX,  
                         TEACHER_BIRTHDAY 
                         )  
  VALUES   (666,  
            '美女老师',  
            'w',  
            '1980-08-01'
            );


select nextval('student');

SELECT  * from tb_student t;
SELECT * from tb_teacher t;




INSERT INTO `test`.`tb_student`
VALUES
	(
		null,
		'大美女',
		'女',
		'1980-08-01',
		'121546',
		'666'
	);





delete from tb_student t where t.student_id='2';
delete from tb_student where student_id='33';


/**分页查询是用limit实现的**/




