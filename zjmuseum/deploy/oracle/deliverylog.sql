
CREATE TABLE deliverylog (
  id integer   NOT NULL  ,
  dataObj varchar2(50) default NULL,
  dataObjText varchar2(50) default NULL ,
  objPrimaryKey varchar2(50) default NULL,
  operationContent varchar2(1000) default NULL,
  userName varchar2(50) default NULL,
  operationDate varchar2(20) default NULL ,
  PRIMARY KEY  (id)
);

-- ----------------------------
-- Records of userlog
-- ----------------------------
/
CREATE sequence sq_deliverylog
start with 1
increment by 1
nomaxvalue
nocycle
/
CREATE OR  REPLACE TRIGGER tr_deliverylog
before insert on deliverylog 
for each row
begin
select sq_deliverylog  .nextval into :new.id from dual;
end;
