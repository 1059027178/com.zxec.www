package com.jiuyi.tools.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import freemarker.template.TemplateException;

public class TemplateUtil {
	private String project = null;// 项目名
	List fileName = new ArrayList();// 模板文件名
	private String tempPath = null;// 模板文件存放路径
	public TemplateUtil() {
        //System.out.println("===========file.separator:"+System.getProperties().getProperty("file.separator"));  
		setProject();
		setTempPath(null);
		setFileName();
	}

	public TemplateUtil(String tempPath) {
		setProject();
		setTempPath(tempPath);
		setFileName();
	}

	public void setProject() {
		String projectname = System.getProperty("user.dir");
		//System.out.println("the FP index1 is \t"+projectname.lastIndexOf(""+this.getFileSeparatorChar()+""));
		String pn = projectname.substring(projectname.lastIndexOf(""+this.getFileSeparatorChar()+"") + 1,
				projectname.length());
		project = pn;
	}
	
	public String getFileSeparatorChar(){
		if(isWindows()){
			return "\\";
		}
		return "/";
	}

	 /**
	  * 判断当前操作系统是不是window
	  * @return boolean
	  */
	 public boolean isWindows(){
	  boolean flag = false;
	  if (System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
	   flag = true;
	  }
	  return flag;
	 } 
	 
	public void setTempPath(String tempPath) {
		if (tempPath == null) {
			this.tempPath = System.getProperty("user.dir") +this.getFileSeparatorChar()+"AUTOGENTPL";
		}
	}

	public String getTempPath() {
		return tempPath;
	}

	public List getFileName() {
		return fileName;
	}

	public void setFileName() {
		File filePath = new File(tempPath);
		if (filePath.isDirectory()) {
			File[] files = filePath.listFiles();
			for (File file : files) {
				if(file.getName().indexOf(".ftl")>0){fileName.add(file.getName());}
					
			}
		}
	}

	public String getProject() {
		return project;
	}

	public String getSavePath(String type, String project, String className) {
		String newJavaFile = null;
		XmlReader xr = new XmlReader();
		String projectDir = System.getProperty("user.dir");
		if (type.equalsIgnoreCase("pojo")) {
			newJavaFile = projectDir + "/src/cc/jiuyi/entity/"
					+ className + ".java";
		}  else if (type.equalsIgnoreCase("dao")) {
			newJavaFile = projectDir + "/src/cc/jiuyi/dao/"
					+ className + "Dao.java";
		} else if (type.equalsIgnoreCase("daoImpl")) {
			newJavaFile = projectDir + "/src/cc/jiuyi/dao/impl/" + className + "DaoImpl.java";
		} else if (type.equalsIgnoreCase("service")) {
			newJavaFile = projectDir + "/src/cc/jiuyi/service/" + className + "Service.java";
		} else if (type.equalsIgnoreCase("serviceImpl")) {
			newJavaFile = projectDir + "/src/cc/jiuyi//service/impl/" + className + "ServiceImpl.java";
		} else if (type.equalsIgnoreCase("action")) {
			newJavaFile = projectDir + "/src/cc/jiuyi/action/admin/" + className + "Action.java";
		} else if (type.equalsIgnoreCase("view-input")) {
			newJavaFile = projectDir + "/WebRoot/WEB-INF/template/admin/" + xr.changeToLower(className) + "_input.ftl";
		} else if (type.equalsIgnoreCase("view-list")) {
			newJavaFile = projectDir + "/WebRoot/WEB-INF/template/admin/" + xr.changeToLower(className) + "_list.ftl";
		} else if (type.equalsIgnoreCase("view-js")) {
			newJavaFile = projectDir + "/WebRoot/template/admin/js/manage/" + xr.changeToLower(className) + ".js";
		}
		
		return new String(newJavaFile);
	}
	

	@SuppressWarnings( { "static-access", "unchecked" })
	public void process(String project,String className,String nameDes,Map tpMap,String genConfigFile) {
		XmlReader xr = new XmlReader();
		// 类名
		TemplateUtil tu = new TemplateUtil();
		// 模板名
		List<String> tempNameList = tu.getFileName();
		Map map = new HashMap();
		map.put("project", project);
		String Lname = xr.changeToLower(className);
		map.put("Lname", Lname);
		map.put("Name", className);
		map.put("NameDes", nameDes);
		map.put("JspTaglibs", "JspTaglibs");
		
		for (int j = 0; j < tempNameList.size(); j++) {
			String tempName = tempNameList.get(j);
			String type = tempName.substring(0, tempName.lastIndexOf("."));
			String newJavaFile = null;
			newJavaFile = tu.getSavePath(type, project, className);
			try {
				SpringTemplateUnits.templateAppend(tempName, newJavaFile,
						map, tu.getTempPath());
				System.out.println(newJavaFile+"已生成!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				e.printStackTrace();
			}
			

			//POJO的类属性
			if (type.equalsIgnoreCase("pojo")) {
				StringBuffer codeBuf = new StringBuffer();
				Iterator iter = tpMap.entrySet().iterator();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];
					codeBuf = codeBuf.append("\tprivate "+fieldType+" "+ fieldName +";");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					
					//getter
					codeBuf = codeBuf.append("\tpublic "+fieldType+" get"+xr.changeToUpper(""+fieldName)+"() {");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\treturn "+fieldName+";");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t}");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					//setter
					codeBuf = codeBuf.append("\tpublic void set"+xr.changeToUpper(""+fieldName)+"("+fieldType+" "+fieldName+") {");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\tthis."+fieldName+" = "+fieldName+";");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t}");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode}",codeBuf.toString());
			}  else if (type.equalsIgnoreCase("daoImpl")) {
				//autocode1
				StringBuffer codeBuf1 = new StringBuffer();
				Iterator iter = tpMap.entrySet().iterator();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];
					if(fieldType.equals("String")){
						codeBuf1.append("\t\tif(map.get(\""+fieldName+"\")!=null){");
						codeBuf1.append(System.getProperty("line.separator"));
						codeBuf1.append("\t\t\tdetachedCriteria.add(Restrictions.like(\""+fieldName+"\", \"%\"+map.get(\""+fieldName+"\")+\"%\"));");
						codeBuf1.append(System.getProperty("line.separator"));
						codeBuf1.append("\t\t}");
						codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
					}
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode}",codeBuf1.toString());
			}else if (type.equalsIgnoreCase("action")) {
				//autocode1
				StringBuffer codeBuf1 = new StringBuffer();
				StringBuffer codeBuf2 = new StringBuffer();
				Iterator iter = tpMap.entrySet().iterator();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];

					if(fieldType.equals("String")){
						codeBuf1.append("\t\tif(obj.get(\""+fieldName+"\") != null) {");
						codeBuf1.append(System.getProperty("line.separator"));
						codeBuf1.append("\t\t\tmap.put(\""+fieldName+"\", obj.getString(\""+fieldName+"\").toString());");
						codeBuf1.append(System.getProperty("line.separator"));
						codeBuf1.append("\t\t}");						
						codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
					}
					
					if(fieldType.equals("String")||fieldType.equals("Integer")||fieldType.equals("Double")){
						codeBuf2.append("\t\t@RequiredStringValidator(fieldName = \""+Lname+"."+fieldName+"\", message = \""+fieldName_cn+"不允许为空!\"),");						
						codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
					}
					
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode}",codeBuf1.toString());
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode2}",codeBuf2.toString());
				
				
				
			}else if (type.equalsIgnoreCase("view-input")) {
				StringBuffer codeBuf = new StringBuffer();
				Iterator iter = tpMap.entrySet().iterator();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];
					String fieldName_cn_1 = fieldName_cn;
					String fieldRequiredClass = "";
					String fieldRequiredLable = "";
					if(fieldInput.equals("R")){
						fieldName_cn_1 = "<font color=red>*</font>&nbsp;"+fieldName_cn_1;
						fieldRequiredClass = "{required: true,minlength:2,maxlength: 100}";
						fieldRequiredLable = "<label class=\"requireField\">*</label>";
					}
					codeBuf = codeBuf.append("\t\t<div class=\"profile-info-row\">");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t\t<div class=\"profile-info-name\"> "+fieldName_cn_1+" </div>");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t\t<div class=\"profile-info-value\">");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t\t\t");
					
					if(fieldShow.equals("datepicker")){
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<input type=\"text\" name=\""+Lname+"."+fieldName+"\" value=\"${("+Lname+"."+fieldName+")!}\" class=\" input input-sm  form-control datePicker "+fieldRequiredClass+"\" />");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t"+fieldRequiredLable);
						
					}else if(fieldShow.equals("datetimepicker")){
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<input type=\"text\" name=\""+Lname+"."+fieldName+"\" value=\"${("+Lname+"."+fieldName+")!}\" class=\" input input-sm  form-control dateTimePicker "+fieldRequiredClass+"\" />");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t"+fieldRequiredLable);
					}else if(fieldShow.equals("select")){
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<select name=\""+Lname+"."+fieldName+"\" id=\""+Lname+"."+fieldName+"\" value=\"${("+Lname+"."+fieldName+")!}\" class=\" input input-sm  formText "+fieldRequiredClass+"\" >");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						

						codeBuf = codeBuf.append("\t\t\t\t\t <option value=\"\">请选择</option>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						codeBuf = codeBuf.append("\t\t\t\t<#list "+fieldName+"List as list>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t\t <option value=\"${list.dictkey}\"<#if ((isAdd && list.isDefault) || (isEdit && "+Lname+"."+fieldName+" == list.dictkey))!> selected</#if>>${list.dictvalue}</option>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</#list> ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						codeBuf = codeBuf.append("\t\t\t\t</select>");
						
						codeBuf = codeBuf.append("\t\t\t\t"+fieldRequiredLable);
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						
					}else if(fieldShow.equals("browser")){
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<input type=\"text\" readonly name=\""+Lname+"."+fieldName+"\" value=\"${("+Lname+"."+fieldName+")!}\" class=\" input input-sm  formText "+fieldRequiredClass+"\" />");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<input type=\"hidden\" name=\""+fieldName+"\" id=\""+fieldName+"\"/>");

						codeBuf = codeBuf.append("\t\t\t\t\t <a  href=\"javascript:;\"  class=\"btn btn-sm\" name=\""+fieldName+"browser\" id=\""+fieldName+"browser\" onclick=\"window.open('/"+fieldName+"List.action!forSel');\">...</a>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						codeBuf = codeBuf.append("\t\t\t\t"+fieldRequiredLable);

						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						

					}else if(fieldShow.equals("textarea")){
						codeBuf = codeBuf.append("\t\t\t<textarea name=\""+fieldName+"\" id=\""+fieldName+"\"></textarea>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t <script type=\"text/javascript\"> ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  CKEDITOR.replace('"+fieldName+"', { ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  toolbar : [ ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['Source', 'Preview', '-'],	");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'], ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'], ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'], ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['Link','Unlink','Anchor'], ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'], ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  '/', ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['Styles','Format','Font','FontSize'], ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['TextColor','BGColor'], ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['Maximize', 'ShowBlocks','-','-','Undo','Redo']");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ],");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  height : '200',");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  width : '600'  ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t   }); ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  </script>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t"+fieldRequiredLable);
					}else if(fieldShow.equals("upload")){
						codeBuf = codeBuf.append("\t\t\t\t<input type=\"hidden\" name=\""+fieldName+"\" id=\""+fieldName+"\"/>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t//暂不支持upload类型");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
					}else{//input-text
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<input type=\"text\" name=\""+Lname+"."+fieldName+"\" value=\"${("+Lname+"."+fieldName+")!}\" class=\" input input-sm  formText "+fieldRequiredClass+"\" />");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t"+fieldRequiredLable);
					}
					

					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t\t\t</div>");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t</div>");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode}",codeBuf.toString());
			}else if (type.equalsIgnoreCase("view-list")) {
				StringBuffer chkSelBtnCode = new StringBuffer();
				StringBuffer codeBuf = new StringBuffer();
				Iterator iter = tpMap.entrySet().iterator();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];
					if(fieldType.equals("String")){
						codeBuf = codeBuf.append("\t\t\t\t<label class=\"col-sm-1 col-md-offset-1\" style=\"text-align:right\">"+fieldName_cn+":</label>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t<div class=\"col-sm-4\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						//扩展更多类型,todo...
						codeBuf = codeBuf.append("\t\t\t\t<input type=\"text\" name=\""+fieldName+"\" class=\"input input-sm form-control\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
					}
					
					
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode}",codeBuf.toString());
			}else if (type.equalsIgnoreCase("view-js")) {
				StringBuffer chkSelBtnCode = new StringBuffer();
				StringBuffer codeBuf = new StringBuffer();
				Iterator iter = tpMap.entrySet().iterator();
				StringBuilder desArrJsonStr = new StringBuilder();
				StringBuilder propDetailJsonStr = new StringBuilder();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];
					if(fieldType.equals("String")){
						desArrJsonStr.append("'"+fieldName_cn+"',");
						propDetailJsonStr.append("{name:'"+fieldName+"',index:'"+fieldName+"',label:\""+fieldName_cn+"\",editable:false},");
					    propDetailJsonStr.append(System.getProperty("line.separator"));
					}
					
				}
				codeBuf = codeBuf.append("\t\tcolNames:["+desArrJsonStr.toString()+"'创建日期']");
				codeBuf = codeBuf.append(System.getProperty("line.separator"));

				codeBuf = codeBuf.append("\t\tcolModel:[");
				codeBuf = codeBuf.append(System.getProperty("line.separator"));
				codeBuf = codeBuf.append("\t\t\t"+propDetailJsonStr);
				codeBuf = codeBuf.append(System.getProperty("line.separator"));
				codeBuf = codeBuf.append("{name:'createDate',index:'createDate',label:\"创建日期\",editable:false, sorttype:\"date\",unformat: pickDate,formatter:datefmt}");
				codeBuf = codeBuf.append(System.getProperty("line.separator"));
				
				codeBuf = codeBuf.append("\t\t],");
				codeBuf = codeBuf.append(System.getProperty("line.separator"));
				
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode}",codeBuf.toString());
			}
			
		}
		//判断是否生成配置文件-开始
        if(genConfigFile.equals("Y")){//如果已经生成了配置文件就不要再生成配置文件
        	
		String projectDir = System.getProperty("user.dir");
		String configFile="";
		String replaceConfigCode = "";
		System.out.println("\n\n");
		System.out.println("======================恭喜您，"+className+"的CRUD代码已成功生成！===============================");
		StringBuffer configBuf = new StringBuffer();
		
		//Entity配置注入 - begin
		configBuf = new StringBuffer();
		configFile = projectDir + "/src/applicationContext.xml";
		replaceConfigCode = "<!--//{autoCode}-->";
		configBuf.append("\t\t\t\t<value>cc.jiuyi.entity."+className+"</value>");
		configBuf.append(System.getProperty("line.separator"));
		configBuf.append(replaceConfigCode);
		configBuf = configBuf.append(System.getProperty("line.separator"));
		ReadWriteFile.replaceTxtByStr(configFile,replaceConfigCode,configBuf.toString());

		System.out.println("\n\n");
		System.out.println("已将如下内容追加到applicationContext.xml 中:\n\n");
		System.out.println("<value>cc.jiuyi.entity."+className+"</value>");
		System.out.println("\n\n");
		//end - Entity配置注入
		

        }//判断是否生成配置文件-结束
        	
	}
	
	
	@SuppressWarnings( { "static-access", "unchecked" })
	public void processModify(String project,String className,String nameDes,Map tpMap,String afterWhosFieldName) {
		XmlReader xr = new XmlReader();
		// 类名
		
		
		TemplateUtil tu = new TemplateUtil();
		// 模板名
		List<String> tempNameList = tu.getFileName();
		Map map = new HashMap();
		map.put("project", project);
		String Lname = xr.changeToLower(className);
		map.put("Lname", Lname);
		map.put("Name", className);
		map.put("NameDes", nameDes);
		
		for (int j = 0; j < tempNameList.size(); j++) {
			String tempName = tempNameList.get(j);
			String type = tempName.substring(0, tempName.lastIndexOf("."));
			String newJavaFile = null;
			newJavaFile = tu.getSavePath(type, project, className);
			

			//附件POJO的类属性
			if (type.equalsIgnoreCase("pojo")) {
				StringBuffer codeBuf = new StringBuffer();
				Iterator iter = tpMap.entrySet().iterator();

				String replaceCode = "//{autoCode_Modify}";
				codeBuf.append(""+replaceCode);
				codeBuf = codeBuf.append(System.getProperty("line.separator"));
				
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];
					codeBuf = codeBuf.append("\tprivate "+fieldType+" "+ fieldName +";");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					//getter
					codeBuf = codeBuf.append("\tpublic "+fieldType+" get"+xr.changeToUpper(""+fieldName)+"() {");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\treturn "+fieldName+";");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t}");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					//setter
					codeBuf = codeBuf.append("\tpublic void set"+xr.changeToUpper(""+fieldName)+"("+fieldType+" "+fieldName+") {");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\tthis."+fieldName+" = "+fieldName+";");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t}");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,replaceCode,codeBuf.toString());
			} else  if (type.equalsIgnoreCase("daoImpl")) {
				//autocode
				StringBuffer codeBuf1 = new StringBuffer();
				String replaceCode1 = "//{autoCode_Modify}";
				codeBuf1.append(""+replaceCode1);
				codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
				
				Iterator iter = tpMap.entrySet().iterator();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];

					if(fieldType.equals("String")){
						codeBuf1.append("\t\tif(map.get(\""+fieldName+"\")!=null){");
						codeBuf1.append(System.getProperty("line.separator"));
						codeBuf1.append("\t\t\tdetachedCriteria.add(Restrictions.like(\""+fieldName+"\", \"%\"+map.get(\""+fieldName+"\")+\"%\"));");
						codeBuf1.append(System.getProperty("line.separator"));
						codeBuf1.append("\t\t}");
						codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
					}
					
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,replaceCode1,codeBuf1.toString());
				
				
			}  else  if (type.equalsIgnoreCase("action")) {
				//autocode
				StringBuffer codeBuf1 = new StringBuffer();
				StringBuffer codeBuf2 = new StringBuffer();
				String replaceCode1 = "//{autoCode_Modify}";
				String replaceCode2 = "//{autoCode_Modify}";
				codeBuf1.append(""+replaceCode1);
				codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
				codeBuf2.append(""+replaceCode2);
				codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
				
				Iterator iter = tpMap.entrySet().iterator();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];
					if(fieldType.equals("String")){
						codeBuf1.append("\t\tif(obj.get(\""+fieldName+"\") != null) {");
						codeBuf1.append(System.getProperty("line.separator"));
						codeBuf1.append("\t\t\tmap.put(\""+fieldName+"\", obj.getString(\""+fieldName+"\").toString());");
						codeBuf1.append(System.getProperty("line.separator"));
						codeBuf1.append("\t\t}");						
						codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
					}
					
					if(fieldType.equals("String")||fieldType.equals("Integer")||fieldType.equals("Double")){
						codeBuf2.append("\t\t@RequiredStringValidator(fieldName = \""+Lname+"."+fieldName+"\", message = \""+fieldName_cn+"不允许为空!\"),");						
						codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
					}
					
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,replaceCode1,codeBuf1.toString());
				ReadWriteFile.replaceTxtByStr(newJavaFile,replaceCode2,codeBuf2.toString());
				
			} else if (type.equalsIgnoreCase("view-input")) {
				StringBuffer codeBuf = new StringBuffer();
				
				String replaceCode = "<!--//{autoCode_Modify}-->";
				codeBuf.append(replaceCode);
				codeBuf = codeBuf.append(System.getProperty("line.separator"));
				
				Iterator iter = tpMap.entrySet().iterator();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];
					String fieldName_cn_1 = fieldName_cn;
					String fieldRequiredClass = "";
					String fieldRequiredLable = "";
					if(fieldInput.equals("R")){
						fieldName_cn_1 = "<font color=red>*</font>&nbsp;"+fieldName_cn_1;
						fieldRequiredClass = "{required: true,minlength:2,maxlength: 100}";
						fieldRequiredLable = "<label class=\"requireField\">*</label>";
					}
					codeBuf = codeBuf.append("\t\t<div class=\"profile-info-row\">");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t\t<div class=\"profile-info-name\"> "+fieldName_cn_1+" </div>");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t\t<div class=\"profile-info-value\">");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t\t\t");
					
					if(fieldShow.equals("datepicker")){
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<input type=\"text\" name=\""+Lname+"."+fieldName+"\" value=\"${("+Lname+"."+fieldName+")!}\" class=\" input input-sm  form-control datePicker "+fieldRequiredClass+"\" />");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t"+fieldRequiredLable);
						
					}else if(fieldShow.equals("datetimepicker")){
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<input type=\"text\" name=\""+Lname+"."+fieldName+"\" value=\"${("+Lname+"."+fieldName+")!}\" class=\" input input-sm  form-control dateTimePicker "+fieldRequiredClass+"\" />");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t"+fieldRequiredLable);
					}else if(fieldShow.equals("select")){
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<select name=\""+Lname+"."+fieldName+"\" id=\""+Lname+"."+fieldName+"\" value=\"${("+Lname+"."+fieldName+")!}\" class=\" input input-sm  formText "+fieldRequiredClass+"\" >");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						

						codeBuf = codeBuf.append("\t\t\t\t\t <option value=\"\">请选择</option>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						codeBuf = codeBuf.append("\t\t\t\t<#list "+fieldName+"List as list>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t\t <option value=\"${list.dictkey}\"<#if ((isAdd && list.isDefault) || (isEdit && "+Lname+"."+fieldName+" == list.dictkey))!> selected</#if>>${list.dictvalue}</option>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</#list> ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						codeBuf = codeBuf.append("\t\t\t\t</select>");
						
						codeBuf = codeBuf.append("\t\t\t\t"+fieldRequiredLable);
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						
					}else if(fieldShow.equals("browser")){
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<input type=\"text\" readonly name=\""+Lname+"."+fieldName+"\" value=\"${("+Lname+"."+fieldName+")!}\" class=\" input input-sm  formText "+fieldRequiredClass+"\" />");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<input type=\"hidden\" name=\""+fieldName+"\" id=\""+fieldName+"\"/>");

						codeBuf = codeBuf.append("\t\t\t\t\t <a  href=\"javascript:;\"  class=\"btn btn-sm\" name=\""+fieldName+"browser\" id=\""+fieldName+"browser\" onclick=\"window.open('/"+fieldName+"List.action!forSel');\">...</a>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						codeBuf = codeBuf.append("\t\t\t\t"+fieldRequiredLable);

						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						

					}else if(fieldShow.equals("textarea")){
						codeBuf = codeBuf.append("\t\t\t<textarea name=\""+fieldName+"\" id=\""+fieldName+"\"></textarea>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t <script type=\"text/javascript\"> ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  CKEDITOR.replace('"+fieldName+"', { ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  toolbar : [ ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['Source', 'Preview', '-'],	");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'], ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'], ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'], ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['Link','Unlink','Anchor'], ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'], ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  '/', ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['Styles','Format','Font','FontSize'], ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['TextColor','BGColor'], ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ['Maximize', 'ShowBlocks','-','-','Undo','Redo']");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  ],");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  height : '200',");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  width : '600'  ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t   }); ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  </script>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t"+fieldRequiredLable);
					}else if(fieldShow.equals("upload")){
						codeBuf = codeBuf.append("\t\t\t\t<input type=\"hidden\" name=\""+fieldName+"\" id=\""+fieldName+"\"/>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t//暂不支持upload类型");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
					}else{//input-text
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<input type=\"text\" name=\""+Lname+"."+fieldName+"\" value=\"${("+Lname+"."+fieldName+")!}\" class=\" input input-sm  formText "+fieldRequiredClass+"\" />");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t"+fieldRequiredLable);
					}
					

					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t\t\t</div>");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t</div>");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,replaceCode,codeBuf.toString());
			}
			
		}
		System.out.println("\n\n");
		System.out.println("======================恭喜您，"+className+"的新字段已成功添加！===============================");
		
		
		
	
	}
	
	
	@SuppressWarnings( { "static-access", "unchecked" })
	public void processDeleteFilesByClassName(String project,String className) {
		XmlReader xr = new XmlReader();
		// 类名
		TemplateUtil tu = new TemplateUtil();
		// 模板名
		List<String> tempNameList = tu.getFileName();
		Map map = new HashMap();
		map.put("project", project);
		String Lname = xr.changeToLower(className);
		map.put("Lname", Lname);
		map.put("Name", className);


		String projectDir = System.getProperty("user.dir");
		String configFile="";
		String replaceConfigCode = "";
		System.out.println("\n\n");
		StringBuffer configBuf = new StringBuffer();
		
		
		for (int j = 0; j < tempNameList.size(); j++) {
			String tempName = tempNameList.get(j);
			String type = tempName.substring(0, tempName.lastIndexOf("."));
			String newJavaFile = null;
			newJavaFile = tu.getSavePath(type, project, className);
			try {
				ReadWriteFile.deleteTxtFile(new File(newJavaFile));
				//System.out.println(newJavaFile+" 已删除!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			

		}
		

		System.out.println("======================恭喜您，"+className+"的相关文件已删除！===============================");
		System.out.println("请手工调整如下文件:");
		System.out.println("applicationContext.xml");

		
	
	}
}