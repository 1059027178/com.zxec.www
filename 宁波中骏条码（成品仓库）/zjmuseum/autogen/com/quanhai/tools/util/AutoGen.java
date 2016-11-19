package com.quanhai.tools.util;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AutoGen {

	public static void main(String[] args) {
		TemplateUtil tu = new TemplateUtil();
		Map<String,String> iMap = new LinkedHashMap();
		/*
		//文章分类
		 
		iMap = new LinkedHashMap();
		iMap.put("articleClassName", "String|分类名称|R|input");
		tu.process("cms", "ArticleClass", "文章分类", iMap);
		
		//文章
		iMap = new LinkedHashMap();
		iMap.put("articleClass", "Integer|所属分类|R|select");
		iMap.put("postTitle", "String|标题|R|input");
		iMap.put("linkAddr", "String|链接地址|O|input");
		iMap.put("postDate", "Timestamp|发表日期|R|datepicker");
		iMap.put("postContent", "String|内容|O|textarea");
		iMap.put("sortstr", "String|排序码|O|input");
		tu.process("cms", "Article", "文章", iMap);
		
		//展厅
		iMap = new LinkedHashMap();
		iMap.put("hallName", "String|展厅名称|R|input");
		iMap.put("hallArea", "String|所在区域|R|input");
		iMap.put("hallFloor", "String|所在楼层|R|input");
		tu.process("cms", "Hall", "展厅", iMap);
		

		iMap = new LinkedHashMap();
		iMap.put("showTypeName", "String|类型名称|R|input");
		tu.process("cms", "ShowType", "展览类型", iMap);
		
		
		//展览
		iMap = new LinkedHashMap();
		iMap.put("exshowName", "String|展览名称|R|input");
		iMap.put("exshowOwner", "String|主办单位|R|input");
		iMap.put("exshowType", "String|展览类型|R|select");
		iMap.put("beginTime", "Timestamp|开始时间|R|datepicker");
		iMap.put("endTime", "Timestamp|结束时间|R|datepicker");
		iMap.put("exshowTheme", "String|专题|O|input");
		iMap.put("exshowDesp", "String|展览介绍|O|textarea");
		iMap.put("exshowImg", "String|展览介绍图片|O|upload");
		tu.process("cms", "Exshow", "展览", iMap);
		
		
		//展览单元
		iMap = new LinkedHashMap();
		iMap.put("unitName", "String|单元名称|R|input");
		iMap.put("exshowId", "Integer|所属展览|R|select");
		iMap.put("unitSortStr", "String|单元排序|R|input");
		iMap.put("unitDesp", "String|单元介绍|R|textarea");
		iMap.put("unitImg", "String|单元介绍图片|R|upload");
		tu.process("cms", "Unit", "展览单元", iMap);
		
		*/
		/*
		 *   `exhibitName` varchar(100) NOT NULL COMMENT '展品标题名称',
  `exhibitName1` varchar(100) DEFAULT NULL COMMENT '副标题1',
  `exhibitName2` varchar(100) DEFAULT NULL COMMENT '副标题2',
  `hallId` int(10) unsigned NOT NULL COMMENT '展厅ID',
  `exshowId` int(10) unsigned NOT NULL COMMENT '所属展览ID',
  `unitId` int(10) unsigned DEFAULT NULL COMMENT '单元ID',
  `exhibitImg` varchar(200)  DEFAULT NULL COMMENT '展品图片',
  `exhibitDesp` mediumtext  DEFAULT NULL COMMENT '展品介绍',
		 */
		
		//展品
		iMap = new LinkedHashMap();
		iMap.put("exhibitName", "String|展品名称|R|input");
		iMap.put("exhibitName1", "String|副标题一|O|input");
		iMap.put("exhibitName2", "String|副标题二|O|input");
		iMap.put("hallId", "Integer|所属展厅|R|select");
		iMap.put("exshowId", "Integer|所属展览|R|select");
		iMap.put("unitId", "Integer|所属展览单元|R|select");
		iMap.put("exhibitDesp", "String|展品介绍|O|textarea");
		iMap.put("exhibitImg", "String|展品图片|O|upload");
		tu.process("cms", "Exhibits", "展品", iMap);
		
	}

}
