
DROP TABLE IF EXISTS `TEST_USERS`;
-- Create table
create table TEST_USERS
(
    id        NUMBER not null,
    username  VARCHAR2(64),
    password  VARCHAR2(64),
    nick_name VARCHAR2(64)
)
    tablespace ECPDATA
    pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 1M
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints
alter table TEST_USERS
    add constraint DEV_CUST primary key (ID)
        using index
    tablespace ECPDATA
    pctfree 10
    initrans 2
    maxtrans 255
    storage
    (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
    );
