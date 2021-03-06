package cc.jiuyi.action.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.BeanUtils;

import cc.jiuyi.entity.Department;
import cc.jiuyi.service.DepartmentService;

/**
 * 后台Action类 - 部门管理 
 */

@ParentPackage("admin")
public class DepartmentAction extends BaseAdminAction {

	private static final long serialVersionUID = 3142941564892040221L;
	@Resource
	private DepartmentService deptservice;
	
	private List<Department> list;
	private Department department;
	private String pid;//父节点id
	private String pname;//父节点名称
	private String factoryid;
	private String workplatformid;
	private String factoryunitid;
	
	/**
	 * 跳转List 页面
	 * @return
	 */
	public String list(){
		list = deptservice.getAllByHql();
		return "list";
	}
	
	public String browser(){
		list = deptservice.getAllByHql();
		return "browser";
	}
	
	public String listajax(){
		list = deptservice.getAllByHql();
		
		for(int i =0; i < list.size();i++){
			Department department  = (Department)list.get(i);
		//	department.setAdmin(null);
			department.setChildDept(null);
			department.setParentDept(null);
			list.set(i, department);
		}
		
		JsonConfig jsonConfig=new JsonConfig();   
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);//防止自包含
		JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
		
		return ajaxJson(jsonArray.toString());
	}
	
	/**
	 * 添加页面
	 * @return
	 */
	public String add(){
		Department depart = deptservice.get(pid);
		pname = depart.getDeptName();
		return "input";
	}
	/**
	 * 修改页面
	 * @return
	 */
	public String edit(){
		department = deptservice.load(id);//获取的当前节点的属性
		return "input";
	}
	
	
	
	/**
	 * 保存
	 * @return
	 */
	public String save(){
		id = deptservice.save(department);
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS, SUCCESS);
		jsonMap.put(MESSAGE, "部门添加成功");
		jsonMap.put("id", id);//将id 返回
		jsonMap.put("deptName", department.getDeptName());//将name 返回
		jsonMap.put("parentDept", department.getParentDept().getId());//将父节点返回
		return ajaxJson(jsonMap);
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update(){
		if(department.getParentDept().getId().equals(""))//如果传过来的是空字符串，将parentdept赋值成空
			department.setParentDept(null);
		Department persistent = deptservice.load(department.getId());
		BeanUtils.copyProperties(department, persistent, new String[] {"id", "isDel"});
		deptservice.update(persistent);
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS, SUCCESS);
		jsonMap.put(MESSAGE, "部门修改成功");
		jsonMap.put("id", department.getId());//将id 返回
		jsonMap.put("deptName", department.getDeptName());//将name 返回
		return ajaxJson(jsonMap);
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		ids = id.split(",");
		deptservice.updateisdel(ids, "Y");//删除
		Map<String, String> jsonMap = new HashMap<String, String>();
		jsonMap.put(STATUS, SUCCESS);
		jsonMap.put(MESSAGE, "部门删除成功");
		return ajaxJson(jsonMap);
	}
	
	/**
	 * 检查部门名称
	 * @return
	 */
	public String CheckDeptName(){
		//暂时不需要使用
		return ajaxText("true");
	}

	public List<Department> getList() {
		return list;
	}

	public void setList(List<Department> list) {
		this.list = list;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getFactoryid() {
		return factoryid;
	}

	public void setFactoryid(String factoryid) {
		this.factoryid = factoryid;
	}

	public String getWorkplatformid() {
		return workplatformid;
	}

	public void setWorkplatformid(String workplatformid) {
		this.workplatformid = workplatformid;
	}

	public String getFactoryunitid() {
		return factoryunitid;
	}

	public void setFactoryunitid(String factoryunitid) {
		this.factoryunitid = factoryunitid;
	}
	
	
	
	
}