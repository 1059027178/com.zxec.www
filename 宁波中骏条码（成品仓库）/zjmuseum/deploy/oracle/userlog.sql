
CREATE TABLE userlog (
  id integer   NOT NULL  ,
  dataObj varchar2(50) default NULL,
  dataObjText varchar2(50) default NULL ,
  objPrimaryKey varchar2(50) default NULL,
  operationContent varchar2(1000) default NULL,
  userName varchar2(50) default NULL,
  operationDate varchar(20) default NULL ,
  PRIMARY KEY  (id)
);

-- ----------------------------
-- Records of userlog
-- ----------------------------
/
CREATE sequence sq_userlog 
start with 1
increment by 1
nomaxvalue
nocycle
/
CREATE OR  REPLACE TRIGGER tr_userlog 
before insert on userlog 
for each row
begin
select sq_userlog  .nextval into :new.id from dual;
end;

