
CREATE TABLE dellockuser (
  id integer   NOT NULL  ,
  userid varchar2(50) default NULL,
  username varchar2(50) default NULL ,
  vbeln varchar2(12) default NULL,
  lockdata varchar2(20) default NULL ,
  PRIMARY KEY  (id)
);
/
CREATE sequence sq_dellockuser
start with 1
increment by 1
nomaxvalue
nocycle
/
CREATE OR  REPLACE TRIGGER tr_dellockuser
before insert on dellockuser 
for each row
begin
select sq_dellockuser  .nextval into :new.id from dual;
end;
