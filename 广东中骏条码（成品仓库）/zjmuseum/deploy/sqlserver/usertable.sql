USE [ecology]
GO

/****** Object:  Table [dbo].[workflow_cssdetail]    Script Date: 05/30/2014 09:07:45 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO
DROP TABLE [dbo].[usertable]
go
CREATE TABLE [dbo].[usertable] (
  userId [int] IDENTITY(1,1) NOT NULL,
  userBH varchar(50) default NULL,
  userName varchar(50) NOT NULL,
  userPassword varchar(50) NOT NULL,
  userFunction varchar(2000) default NULL,
  createUser varchar(24) default NULL,
  createDate varchar(50) default NULL,
  updateUser varchar(24) default NULL,
  updateDate varchar(50) default NULL,
  isDel varchar(10) default 'N'  NOT NULL ,
  CHECK( isDel IN ('Y','N') ) 
) 
GO

-- ----------------------------
-- Records of usertable
-- ----------------------------
INSERT INTO usertable VALUES ('admin', 'admin', 'C4CA4238A0B923820DCC509A6F75849B', '1000,1001', null, null, 'admin', '2013-10-26 22:42:21', 'N');

GO

SET ANSI_PADDING OFF

GO
