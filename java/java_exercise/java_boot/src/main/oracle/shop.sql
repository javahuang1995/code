                               /*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2019/2/18 20:07:35                           */
/*==============================================================*/


alter table t_category
   drop constraint aid_FK;

alter table t_forder
   drop constraint sid_FK;

alter table t_forder
   drop constraint uid_FK;

alter table t_product
   drop constraint cid_FK;

alter table t_sorder
   drop constraint fid_FK;

alter table t_sorder
   drop constraint pid_FK;

drop table t_account cascade constraints;

drop table t_category cascade constraints;

drop table t_forder cascade constraints;

drop table t_product cascade constraints;

drop table t_sorder cascade constraints;

drop table t_status cascade constraints;

drop table t_user cascade constraints;

/*==============================================================*/
/* Table: t_account                                             */
/*==============================================================*/
create table t_account
(
   id                   int                  not null,
   login                varchar(20),
   name                 varchar(20),
   pass                 varchar(20),
   constraint PK_T_ACCOUNT primary key (id)
);

/*==============================================================*/
/* Table: t_category                                            */
/*==============================================================*/
create table t_category
(
   id                   int                  not null,
   type                 varchar(20),
   hot                  number(1)                 default 0,
   aid                  int,
   constraint PK_T_CATEGORY primary key (id)
);

/*==============================================================*/
/* Table: t_forder                                              */
/*==============================================================*/
create table t_forder
(
   id                   int                  not null,
   name                 varchar(20),
   phone                varchar(20),
   remark               varchar(20),
   "date"               timestamp            default sysdate,
   total                decimal(8,2),
   post                 varchar(20),
   address              varchar(200),
   sid                  int                  default 1,
   "uid"                int,
   constraint PK_T_FORDER primary key (id)
);

/*==============================================================*/
/* Table: t_product                                             */
/*==============================================================*/
create table t_product
(
   id                   int                  not null,
   name                 varchar(50),
   price                decimal(8,2),
   pic                  varchar(300),
   remark               varchar(300),
   xremark              varchar(300),
   "date"               timestamp            default sysdate,
   commend              number(1),
   open                 number(1),
   cid                  int,
   constraint PK_T_PRODUCT primary key (id)
);

/*==============================================================*/
/* Table: t_sorder                                              */
/*==============================================================*/
create table t_sorder
(
   id                   int                  not null,
   name                 varchar(20),
   price                decimal(8,2),
   "number"             int                  not null,
   pid                  int,
   fid                  int,
   constraint PK_T_SORDER primary key (id)
);

/*==============================================================*/
/* Table: t_status                                              */
/*==============================================================*/
create table t_status
(
   id                   int                  not null,
   status               varchar(10),
   constraint PK_T_STATUS primary key (id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   int                  not null,
   login                varchar(20),
   name                 varchar(20),
   pass                 varchar(20),
   sex                  varchar(20),
   phone                varchar(20),
   email                varchar(20),
   constraint PK_T_USER primary key (id)
);

alter table t_category
   add constraint aid_FK foreign key (aid)
      references t_account (id);

alter table t_forder
   add constraint sid_FK foreign key (sid)
      references t_status (id);

alter table t_forder
   add constraint uid_FK foreign key ("uid")
      references t_user (id);

alter table t_product
   add constraint cid_FK foreign key (cid)
      references t_category (id);

alter table t_sorder
   add constraint fid_FK foreign key (fid)
      references t_forder (id);

alter table t_sorder
   add constraint pid_FK foreign key (pid)
      references t_product (id);

