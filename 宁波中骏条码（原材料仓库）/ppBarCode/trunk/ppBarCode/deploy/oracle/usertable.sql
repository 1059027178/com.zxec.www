
CREATE TABLE usertable (
  userId integer NOT NULL,
  userBH varchar2(50) default NULL,
  userName varchar2(50) NOT NULL,
  userPassword varchar2(50) NOT NULL,
  userFunction varchar2(2000) default NULL,
  createUser varchar2(24) default NULL,
  createDate varchar2(50) default NULL,
  updateUser varchar2(24) default NULL,
  updateDate varchar2(50) default NULL,
  isDel VARCHAR2(10) default 'N'  NOT NULL ,
  PRIMARY KEY  (userId),
  CHECK( isDel IN ('Y','N') ) 
) ;

-- ----------------------------
-- Records of usertable
-- ----------------------------
INSERT INTO usertable VALUES ('1', 'admin', 'admin', 'C4CA4238A0B923820DCC509A6F75849B', '1000,1001', null, null, 'admin', '2013-10-26 22:42:21', 'N');
/
CREATE sequence sq_usertable 
start with 1
increment by 1
nomaxvalue
nocycle
/
CREATE OR  REPLACE TRIGGER tr_usertable 
before insert on usertable 
for each row
begin
select sq_usertable .nextval into :new.userId from dual;
end;