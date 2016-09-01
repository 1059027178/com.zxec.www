
CREATE TABLE userlog (
  id integer   NOT NULL  ,
  dataObj varchar(50) default NULL,
  dataObjText varchar(50) default NULL ,
  objPrimaryKey varchar(50) default NULL,
  operationContent varchar(1000) default NULL,
  userName varchar(50) default NULL,
  operationDate varchar(20) default NULL ,
  PRIMARY KEY  (id)
);
