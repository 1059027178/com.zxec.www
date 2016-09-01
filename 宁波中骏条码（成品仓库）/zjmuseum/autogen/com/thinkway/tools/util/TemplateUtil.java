package com.thinkway.tools.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.thinkway.cms.util.DataMethod;
import com.thinkway.cms.util.ReadWriteFile;


import freemarker.template.TemplateException;

public class TemplateUtil {
	private String project = null;// 项目名
	List fileName = new ArrayList();// 模板文件名
	private String tempPath = null;// 模板文件存放路径

	public TemplateUtil() {
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
		String pn = projectname.substring(projectname.lastIndexOf('\\') + 1,
				projectname.length());
		project = pn;
	}

	public void setTempPath(String tempPath) {
		if (tempPath == null) {
			this.tempPath = System.getProperty("user.dir") + "\\template";
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
			newJavaFile = projectDir + "/src/com/thinkway/" + project + "/business/domains/"
					+ className + ".java";
		} else if (type.equalsIgnoreCase("pojoQuery")) {
			newJavaFile = projectDir + "/src/com/thinkway/" + project + "/business/query/"
			+ className + "Query.java";
		} else if (type.equalsIgnoreCase("dao")) {
			newJavaFile = projectDir + "/src/com/thinkway/" + project + "/persistence/iface/"
					+ className + "Dao.java";
		} else if (type.equalsIgnoreCase("daoImpl")) {
			newJavaFile = projectDir + "/src/com/thinkway/" + project
					+ "/persistence/sqlmapdao/" + className + "SqlMapDao.java";
		} else if (type.equalsIgnoreCase("service")) {
			newJavaFile = projectDir + "/src/com/thinkway/" + project
					+ "/business/service/iface/" + className + "Service.java";
		} else if (type.equalsIgnoreCase("serviceImpl")) {
			newJavaFile = projectDir + "/src/com/thinkway/" + project
					+ "/business/service/localimpl/" + className + "ServiceImpl.java";
		} else if (type.equalsIgnoreCase("daosql")) {
			newJavaFile = projectDir + "/src/com/thinkway/" + project
			+ "/persistence/sqlmapdao/sql/" + className + ".xml";
		} else if (type.equalsIgnoreCase("controller-rest")) {
			newJavaFile = projectDir + "/src/com/thinkway/" + project
			+ "/presentation/controller/restapi/" + className + "JsonController.java";
		} else if (type.equalsIgnoreCase("controller-add")) {
			newJavaFile = projectDir + "/src/com/thinkway/" + project
			+ "/presentation/web/controller/bizinfo/" + className + "AddController.java";
		} else if (type.equalsIgnoreCase("controller-edit")) {
			newJavaFile = projectDir + "/src/com/thinkway/" + project
			+ "/presentation/web/controller/bizinfo/" + className + "EditController.java";
		} else if (type.equalsIgnoreCase("controller-list")) {
			newJavaFile = projectDir + "/src/com/thinkway/" + project
			+ "/presentation/web/controller/bizinfo/" + className + "ListController.java";
		} else if (type.equalsIgnoreCase("view-add")) {
			newJavaFile = projectDir + "/war/WEB-INF/jsp/bizinfo/" + xr.changeToLower(className) + "_add.jsp";
		} else if (type.equalsIgnoreCase("view-edit")) {
			newJavaFile = projectDir + "/war/WEB-INF/jsp/bizinfo/" + xr.changeToLower(className) + "_edit.jsp";
		} else if (type.equalsIgnoreCase("view-list")) {
			newJavaFile = projectDir + "/war/WEB-INF/jsp/bizinfo/" + xr.changeToLower(className) + "_list.jsp";
		}
		
		return new String(newJavaFile);
	}
	

	@SuppressWarnings( { "static-access", "unchecked" })
	public void process(String project,String className,String nameDes,Map tpMap) {
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
			try {
				SpringTemplateUnits.templateAppend(tempName, newJavaFile,
						map, tu.getTempPath());
				System.out.println(newJavaFile+"已生成!");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				e.printStackTrace();
			}
			

			//附件POJO的类属性
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
					/*
					 * public Integer getClassroomId() {
							return classroomId;
						}
						public void setClassroomId(Integer classroomId) {
							this.classroomId = classroomId;
						}
					 */
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
			} else if (type.equalsIgnoreCase("pojoQuery")) {
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
			}else if (type.equalsIgnoreCase("daosql")) {
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
					codeBuf1.append("\t<result property=\""+fieldName+"\" column=\""+fieldName+"\"/>");
					codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode1}",codeBuf1.toString());
				//autocode2
				StringBuffer codeBuf2 = new StringBuffer();
				iter = tpMap.entrySet().iterator();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];
					if(iter.hasNext()){
						codeBuf2.append("\tA."+fieldName+",");
						codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
					}else{
						codeBuf2.append("\tA."+fieldName+"");
					}
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode2}",codeBuf2.toString());
				//autocode3
				StringBuffer codeBuf3 = new StringBuffer();
				iter = tpMap.entrySet().iterator();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];
					if(iter.hasNext()){
						codeBuf3.append("\tA."+fieldName+",");
						codeBuf3 = codeBuf3.append(System.getProperty("line.separator"));
					}else{
						codeBuf3.append("\tA."+fieldName+"");
					}
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode3}",codeBuf3.toString());
				//autocode4
				StringBuffer codeBuf4 = new StringBuffer();
				iter = tpMap.entrySet().iterator();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];
					if(iter.hasNext()){
						codeBuf4.append("\t"+fieldName+",");
						codeBuf4 = codeBuf4.append(System.getProperty("line.separator"));
					}else{
						codeBuf4.append("\t"+fieldName+"");
					}
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode4}",codeBuf4.toString());
				//autocode5
				StringBuffer codeBuf5 = new StringBuffer();
				iter = tpMap.entrySet().iterator();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];
					if(iter.hasNext()){
						codeBuf5.append("\t  #"+fieldName+"#,");
						codeBuf5 = codeBuf5.append(System.getProperty("line.separator"));
					}else{
						codeBuf5.append("\t  #"+fieldName+"#");
					}
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode5}",codeBuf5.toString());
				//autocode6
				StringBuffer codeBuf6 = new StringBuffer();
				iter = tpMap.entrySet().iterator();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];
					if(iter.hasNext()){
						codeBuf6.append("\t  "+fieldName+" = #"+fieldName+"#,");
						codeBuf6 = codeBuf6.append(System.getProperty("line.separator"));
					}else{
						codeBuf6.append("\t  "+fieldName+" = #"+fieldName+"#");
					}
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode6}",codeBuf6.toString());

			} else if (type.equalsIgnoreCase("controller-rest")) {
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
					if(fieldType.equals("Integer")){
						codeBuf1.append("\t\tint "+fieldName+"=ParamUtils.getIntParameter(request, \""+fieldName+"\",0);");
						codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
						if(fieldInput.equals("R")){
							codeBuf1.append("\t\tif("+fieldName+"==0){");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
							codeBuf1.append("\t\t\tresponse.getWriter().write(\"{\\\"errmsg\\\": \\\""+fieldName_cn+"不能为空!\\\"}\");");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
							codeBuf1.append("\t\t\treturn null;");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
							codeBuf1.append("\t\t}");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
						}
						codeBuf1.append("\t\tacObj.set"+xr.changeToUpper(""+fieldName)+"("+fieldName+");");
						codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
					}else if(fieldType.equals("Double")){
						codeBuf1.append("\t\tdouble "+fieldName+"=ParamUtils.getDoubleParameter(request, \""+fieldName+"\",.0);");
						codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
						if(fieldInput.equals("R")){
							codeBuf1.append("\t\tif("+fieldName+"==.0){");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
							codeBuf1.append("\t\t\tresponse.getWriter().write(\"{\\\"errmsg\\\": \\\""+fieldName_cn+"不能为空!\\\"}\");");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
							codeBuf1.append("\t\t\treturn null;");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
							codeBuf1.append("\t\t}");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
						}
						codeBuf1.append("\t\tacObj.set"+xr.changeToUpper(""+fieldName)+"("+fieldName+");");
						codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
					}else if(fieldType.equals("Timestamp")){
						codeBuf1.append("\t\tString "+fieldName+"=ParamUtils.getParameter(request, \""+fieldName+"\",\"\");");
						codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
						if(fieldInput.equals("R")){
							codeBuf1.append("\t\tif("+fieldName+".equals(\"\")){");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
							codeBuf1.append("\t\t\tresponse.getWriter().write(\"{\\\"errmsg\\\": \\\""+fieldName_cn+"不能为空!\\\"}\");");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
							codeBuf1.append("\t\t\treturn null;");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
							codeBuf1.append("\t\t}");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
						}
						codeBuf1.append("\t\tacObj.set"+xr.changeToUpper(""+fieldName)+"(DataMethod.transferDate("+fieldName+"));");
						codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
					}else{
						codeBuf1.append("\t\tString "+fieldName+"=ParamUtils.getParameter(request, \""+fieldName+"\",\"\");");
						codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
						if(fieldInput.equals("R")){
							codeBuf1.append("\t\tif("+fieldName+".equals(\"\")){");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
							codeBuf1.append("\t\t\tresponse.getWriter().write(\"{\\\"errmsg\\\": \\\""+fieldName_cn+"不能为空!\\\"}\");");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
							codeBuf1.append("\t\t\treturn null;");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
							codeBuf1.append("\t\t}");
							codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
						}
						codeBuf1.append("\t\tacObj.set"+xr.changeToUpper(""+fieldName)+"("+fieldName+");");
						codeBuf1 = codeBuf1.append(System.getProperty("line.separator"));
					}
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode1}",codeBuf1.toString());
				//autocode2
				StringBuffer codeBuf2 = new StringBuffer();
				iter = tpMap.entrySet().iterator();
				while (iter.hasNext()){
					Map.Entry entry = (Map.Entry) iter.next();
					Object fieldName = entry.getKey();
					Object fieldDes = entry.getValue();
					String[] fdArr = (""+fieldDes).split("\\|");
					String fieldType = fdArr[0];
					String fieldName_cn = fdArr[1];
					String fieldInput = fdArr[2];
					String fieldShow = fdArr[3];
					if(fieldType.equals("Integer")){
						codeBuf2.append("\t\tint "+fieldName+"=ParamUtils.getIntParameter(request, \""+fieldName+"\",0);");
						codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
						if(fieldInput.equals("R")){
							codeBuf2.append("\t\tif("+fieldName+"==0){");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
							codeBuf2.append("\t\t\tresponse.getWriter().write(\"{\\\"errmsg\\\": \\\""+fieldName_cn+"不能为空!\\\"}\");");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
							codeBuf2.append("\t\t\treturn null;");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
							codeBuf2.append("\t\t}");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
						}
						codeBuf2.append("\t\tacObj.set"+xr.changeToUpper(""+fieldName)+"("+fieldName+");");
						codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
					}else if(fieldType.equals("Double")){
						codeBuf2.append("\t\tdouble "+fieldName+"=ParamUtils.getDoubleParameter(request, \""+fieldName+"\",.0);");
						codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
						if(fieldInput.equals("R")){
							codeBuf2.append("\t\tif("+fieldName+"==.0){");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
							codeBuf2.append("\t\t\tresponse.getWriter().write(\"{\\\"errmsg\\\": \\\""+fieldName_cn+"不能为空!\\\"}\");");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
							codeBuf2.append("\t\t\treturn null;");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
							codeBuf2.append("\t\t}");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
						}
						codeBuf2.append("\t\tacObj.set"+xr.changeToUpper(""+fieldName)+"("+fieldName+");");
						codeBuf2 = codeBuf1.append(System.getProperty("line.separator"));
					}else if(fieldType.equals("Timestamp")){
						codeBuf2.append("\t\tString "+fieldName+"=ParamUtils.getParameter(request, \""+fieldName+"\",\"\");");
						codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
						if(fieldInput.equals("R")){
							codeBuf2.append("\t\tif("+fieldName+".equals(\"\")){");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
							codeBuf2.append("\t\t\tresponse.getWriter().write(\"{\\\"errmsg\\\": \\\""+fieldName_cn+"不能为空!\\\"}\");");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
							codeBuf2.append("\t\t\treturn null;");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
							codeBuf2.append("\t\t}");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
						}
						codeBuf2.append("\t\tacObj.set"+xr.changeToUpper(""+fieldName)+"(DataMethod.transferDate("+fieldName+"));");
						codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
					}else{
						codeBuf2.append("\t\tString "+fieldName+"=ParamUtils.getParameter(request, \""+fieldName+"\",\"\");");
						codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
						if(fieldInput.equals("R")){
							codeBuf2.append("\t\tif("+fieldName+".equals(\"\")){");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
							codeBuf2.append("\t\t\tresponse.getWriter().write(\"{\\\"errmsg\\\": \\\""+fieldName_cn+"不能为空!\\\"}\");");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
							codeBuf2.append("\t\t\treturn null;");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
							codeBuf2.append("\t\t}");
							codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
						}
						codeBuf2.append("\t\tacObj.set"+xr.changeToUpper(""+fieldName)+"("+fieldName+");");
						codeBuf2 = codeBuf2.append(System.getProperty("line.separator"));
					}
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode2}",codeBuf2.toString());
				
			} else if (type.equalsIgnoreCase("view-add")) {
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
					if(fieldInput.equals("R")){fieldName_cn_1 = "<font color=red>*</font>&nbsp;"+fieldName_cn_1;}
					codeBuf = codeBuf.append("\t\t<div class=\"control-group\">");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t\t<label class=\"control-label\" for=\"\">"+fieldName_cn_1+"</label>");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t\t<div class=\"controls\">");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t\t\t");
					
					if(fieldShow.equals("datepicker")){
						codeBuf = codeBuf.append("\t<div class=\"row\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<div class=\"span3\"><input type=\"text\" name=\""+fieldName+"\" id=\""+fieldName+"\" value=\"${qhcms:getCurrentDate(\"yyyy-MM-dd\")}\" placeholder=\""+fieldName_cn+"\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t<script>$(\"#"+fieldName+"\").datepicker({inline: true,changeYear: true,changeMonth: true});</script>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t<div id=\""+fieldName+"Tip\" class=\"span4\"></div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t</div>");
					}else if(fieldShow.equals("select")){
						codeBuf = codeBuf.append("\t<div class=\"row\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<div class=\"span3\"><select name=\""+fieldName+"\" id=\""+fieldName+"\" >");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						codeBuf = codeBuf.append("\t\t\t\t<c:forEach var=\"iter\" items=\"${"+fieldName.toString().replace("Id", "")+"List}\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t\t <option value=\"${iter."+fieldName.toString().replace("Id", "")+"Id}\">${iter."+fieldName.toString().replace("Id", "")+"Name}</option>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</c:forEach> ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						codeBuf = codeBuf.append("\t\t\t\t</select>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t<div id=\""+fieldName+"Tip\" class=\"span4\"></div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t</div>");
					}else if(fieldShow.equals("textarea")){
						codeBuf = codeBuf.append("\t<div class=\"row\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<div class=\"span3\"><textarea name=\""+fieldName+"\" id=\""+fieldName+"\"></textarea>");
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
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t<div id=\""+fieldName+"Tip\" class=\"span4\"></div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t</div>");
					}else if(fieldShow.equals("upload")){
						codeBuf = codeBuf.append("\t\t\t\t<input type=\"hidden\" name=\""+fieldName+"\" id=\""+fieldName+"\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t<iframe style=\"margin-left:10px;\" src=\"/authFileUpload.do?srcField="+fieldName+"&retElement=showpics&retMessage=${qhcms:encode(\"文件上传成功!\",\"UTF-8\")}\" frameborder=0 scrolling=no width=\"100%\" height=\"40\"></iframe>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t <div id=\"showpics\" style=\"color:blue;margin-left:10px;\"></div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
					}else{
						codeBuf = codeBuf.append("\t<div class=\"row\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<div class=\"span3\"><input type=\"text\" name=\""+fieldName+"\" id=\""+fieldName+"\" placeholder=\""+fieldName_cn+"\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t<div id=\""+fieldName+"Tip\" class=\"span4\"></div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t</div>");
					}
					
					
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t</div>");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode}",codeBuf.toString());
			}else if (type.equalsIgnoreCase("view-edit")) {
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
					if(fieldInput.equals("R")){fieldName_cn_1 = "<font color=red>*</font>&nbsp;"+fieldName_cn_1;}
					codeBuf = codeBuf.append("\t\t<div class=\"control-group\">");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t\t<label class=\"control-label\" for=\"\">"+fieldName_cn_1+"</label>");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t\t<div class=\"controls\">");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));

					if(fieldShow.equals("datepicker")){
						codeBuf = codeBuf.append("\t<div class=\"row\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<div class=\"span3\"><input type=\"text\" name=\""+fieldName+"\" id=\""+fieldName+"\" value=\"${qhcms:getTheDate("+Lname+"Obj."+fieldName+",\"yyyy-MM-dd\")}\" placeholder=\""+fieldName_cn+"\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t<script>$(\"#"+fieldName+"\").datepicker({inline: true,changeYear: true,changeMonth: true});</script>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t<div id=\""+fieldName+"Tip\" class=\"span4\"></div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t</div>");
					}else if(fieldShow.equals("select")){
						codeBuf = codeBuf.append("\t<div class=\"row\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<div class=\"span3\"><select name=\""+fieldName+"\" id=\""+fieldName+"\" >");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						codeBuf = codeBuf.append("\t\t\t\t<c:forEach var=\"iter\" items=\"${"+fieldName.toString().replace("Id", "")+"List}\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t\t <option value=\"${iter."+fieldName.toString().replace("Id", "")+"Id}\" <c:if test=\"${iter."+fieldName.toString().replace("Id", "")+"Id eq "+fieldName.toString().replace("Id", "")+"Obj."+fieldName+"}\">selected</c:if> >${iter."+fieldName.toString().replace("Id", "")+"Name}</option>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</c:forEach> ");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						codeBuf = codeBuf.append("\t\t\t\t</select>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t<div id=\""+fieldName+"Tip\" class=\"span4\"></div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t</div>");
					}else if(fieldShow.equals("textarea")){
						codeBuf = codeBuf.append("\t<div class=\"row\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<div class=\"span3\"><textarea name=\""+fieldName+"\" id=\""+fieldName+"\">${"+Lname+"Obj."+fieldName+"}</textarea>");
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
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t<div id=\""+fieldName+"Tip\" class=\"span4\"></div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t</div>");
					}else if(fieldShow.equals("upload")){
						codeBuf = codeBuf.append("\t\t\t\t<input type=\"hidden\" name=\""+fieldName+"\" value=\"${"+Lname+"Obj."+fieldName+"}\" id=\""+fieldName+"\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t<iframe style=\"margin-left:10px;\" src=\"/authFileUpload.do?srcField="+fieldName+"&retElement=showpics&retMessage=${qhcms:encode(\"文件上传成功!\",\"UTF-8\")}\" frameborder=0 scrolling=no width=\"100%\" height=\"40\"></iframe>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t <div id=\"showpics\" style=\"color:blue;margin-left:10px;\"></div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						
						codeBuf = codeBuf.append("\t\t\t\t  <c:if test=\"${not empty "+Lname+"Obj."+fieldName+"}\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  <ul id=\"imgGallery\" style=\"margin:5;padding:0;\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  <c:forEach var=\"imgStr\" items=\"${fn:split("+Lname+"Obj."+fieldName+", '|')}\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  <li>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  <img  border=0 src=\"<%=uploadDir%>/${fn:substring(imgStr,0,4)}/${qhcms:getScalePic(imgStr,\"small\")}\"/>&nbsp;");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  <a href=\"javascript:;\" onclick=\"deleteSFile('${imgStr}',$(this).parent(),document.getElementById('"+fieldName+"'))\">删除</a>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  </li>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  </c:forEach>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  </ul>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t  </c:if>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						
						
						
					}else{
						codeBuf = codeBuf.append("\t<div class=\"row\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t<div class=\"span3\"><input type=\"text\" name=\""+fieldName+"\" id=\""+fieldName+"\" value=\"${"+Lname+"Obj."+fieldName+"}\" placeholder=\""+fieldName_cn+"\">");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t<div id=\""+fieldName+"Tip\" class=\"span4\"></div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t\t</div>");
						codeBuf = codeBuf.append(System.getProperty("line.separator"));
						codeBuf = codeBuf.append("\t\t\t</div>");
					}
					
					
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					codeBuf = codeBuf.append("\t\t</div>");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
					
				}
				codeBuf = codeBuf.append("\t\t\t\t<input type=\"hidden\" name=\""+Lname+"Id\" value=\"${"+Lname+"Obj."+Lname+"Id}\">");
				codeBuf = codeBuf.append(System.getProperty("line.separator"));
				
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode}",codeBuf.toString());
			}else if (type.equalsIgnoreCase("view-list")) {
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode0}","\t\t\t\t\t<input name=\"selId\" type=\"checkbox\" value=\"${list."+Lname+"Id}\" />");
				
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
					codeBuf = codeBuf.append("\t\t\t\t<display:column title=\""+fieldName_cn+"\" property=\""+fieldName+"\"/>");
					codeBuf = codeBuf.append(System.getProperty("line.separator"));
				}
				ReadWriteFile.replaceTxtByStr(newJavaFile,"//{autoCode}",codeBuf.toString());
			}
			
		}
		System.out.println("\n\n");
		System.out.println("======================恭喜您，"+className+"的CRUD代码已成功生成！===============================");
		System.out.println("\n\n");
		System.out.println("请将如下内容粘贴到SqlMapConfig.xml :\n\n");
		System.out.println("<sqlMap resource=\"com/thinkway/"+project+"/persistence/sqlmapdao/sql/"+className+".xml\"/>");
		System.out.println("\n\n");
		
		System.out.println("请将如下内容粘贴到serviceContext.xml :\n\n");
		System.out.println("<bean id=\""+Lname+"Service\"");
		System.out.println("   class=\"com.thinkway."+project+".business.service.localimpl."+className+"ServiceImpl\">");
		System.out.println("</bean>");
		System.out.println("\n\n");
		
		System.out.println("请将如下内容粘贴到"+project+"-servlet.xml :\n\n");
		System.out.println("<!-- "+className+" -->\n\n");
		System.out.println("<bean name=\"/"+Lname+"Add.do\" class=\"com.thinkway."+project+".presentation.web.controller.bizinfo."+className+"AddController\">");
		System.out.println("\t<property name=\"viewName\" value=\"/WEB-INF/jsp/bizinfo/"+Lname+"_add.jsp\"/>");	
		System.out.println("\t<property name=\"permission\" value=\"1001\"></property>");
		System.out.println("\t<property name=\"tokenNeed\" value=\"N\"></property>");
		System.out.println("\t<property name=\""+Lname+"Service\" ref=\""+Lname+"Service\"/>");	
		System.out.println("\t<property name=\"userService\" ref=\"userService\"></property>");
		System.out.println("\t<property name=\"authenticator\" ref=\"authenticator\"/>");
		System.out.println("</bean>");
		System.out.println("\n");
		System.out.println("<bean name=\"/"+Lname+"Edit.do\" class=\"com.thinkway."+project+".presentation.web.controller.bizinfo."+className+"EditController\">");
		System.out.println("\t<property name=\"viewName\" value=\"/WEB-INF/jsp/bizinfo/"+Lname+"_edit.jsp\"/>");	
		System.out.println("\t<property name=\"permission\" value=\"1001\"></property>");
		System.out.println("\t<property name=\"tokenNeed\" value=\"N\"></property>");
		System.out.println("\t<property name=\""+Lname+"Service\" ref=\""+Lname+"Service\"/>");	
		System.out.println("\t<property name=\"userService\" ref=\"userService\"></property>");
		System.out.println("\t<property name=\"authenticator\" ref=\"authenticator\"/>");
		System.out.println("</bean>");
	
		System.out.println("<bean name=\"/"+Lname+"List.do\" class=\"com.thinkway."+project+".presentation.web.controller.bizinfo."+className+"ListController\">");
		System.out.println("\t<property name=\"viewName\" value=\"/WEB-INF/jsp/bizinfo/"+Lname+"_list.jsp\"/>");	
		System.out.println("\t<property name=\"permission\" value=\"1001\"></property>");
		System.out.println("\t<property name=\"tokenNeed\" value=\"N\"></property>");
		System.out.println("\t<property name=\""+Lname+"Service\" ref=\""+Lname+"Service\"/>");	
		System.out.println("\t<property name=\"userService\" ref=\"userService\"></property>");
		System.out.println("\t<property name=\"authenticator\" ref=\"authenticator\"/>");
		System.out.println("</bean>");	
		System.out.println("\n");
		System.out.println("<bean name=\"/"+Lname+"Json.do\" class=\"org.springframework.web.servlet.mvc.multiaction.MultiActionController\">");
		System.out.println("\t<property name=\"methodNameResolver\" ref=\"paramResolver\"></property>");
		System.out.println("\t<property name=\"delegate\" ref=\""+className+"JsonController\"></property>");
		System.out.println("</bean>");
		System.out.println("\n");
		System.out.println("<bean id=\""+className+"JsonController\" class=\"com.thinkway."+project+".presentation.controller.restapi."+className+"JsonController\">");
		System.out.println("\t<property name=\"userService\" ref=\"userService\"></property>");
		System.out.println("\t<property name=\""+Lname+"Service\" ref=\""+Lname+"Service\"></property>");
		System.out.println("\t<property name=\"permission\" value=\"901\"></property>");
		System.out.println("\t<property name=\"maxUploadSize\" value=\"104857600\" />");
		System.out.println("\t<property name=\"uploadDir\" value=\"${app.uploadpath}\" />");
		System.out.println("\t<property name=\"tokenNeed\" value=\"N\"></property>");
		System.out.println("\t<property name=\"authenticator\" ref=\"authenticator\"/>");
		System.out.println("</bean>");
		
		
	
	}
}