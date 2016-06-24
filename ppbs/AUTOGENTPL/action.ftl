package cc.jiuyi.action.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
 
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.BeanUtils;

import cc.jiuyi.bean.Pager;
import cc.jiuyi.bean.Pager.OrderType;
import cc.jiuyi.bean.jqGridSearchDetailTo;
import cc.jiuyi.entity.Admin;
import cc.jiuyi.entity.Dict;
import cc.jiuyi.entity.${Name};
import cc.jiuyi.service.DictService;
import cc.jiuyi.service.${Name}Service;
import cc.jiuyi.util.ThinkWayUtil;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;


/**
 * 后台Action类-${NameDes}管理
 */

@ParentPackage("admin")
public class ${Name}Action extends BaseAdminAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -433964280757192334L;

	private ${Name} ${Lname};
	//获取所有状态
	private List<Dict> allState;
	
	@Resource
	private ${Name}Service ${Lname}Service;
	@Resource
	private DictService dictService;
	
	//添加
	public String add(){
		return INPUT;
	}


	//列表
	public String list(){
		if(pager == null) {
			pager = new Pager();
			pager.setOrderType(OrderType.asc);
			pager.setOrderBy("orderList");
		}
		return LIST;
	}
	
	/**
	 * ajax 列表
	 * @return
	 */
	public String ajlist(){
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		if(pager == null) {
			pager = new Pager();
			pager.setOrderType(OrderType.asc);
			pager.setOrderBy("orderList");
		}
		if(pager.is_search()==true && filters != null){//需要查询条件
			JSONObject filt = JSONObject.fromObject(filters);
			Pager pager1 = new Pager();
			Map m = new HashMap();
			m.put("rules", jqGridSearchDetailTo.class);
			pager1 = (Pager)JSONObject.toBean(filt,Pager.class,m);
			pager.setRules(pager1.getRules());
			pager.setGroupOp(pager1.getGroupOp());
		}
		
		if (pager.is_search() == true && Param != null) {// 普通搜索功能
			// 此处处理普通查询结果 Param 是表单提交过来的json 字符串,进行处理。封装到后台执行
			JSONObject obj = JSONObject.fromObject(Param);
//{autoCode}
//{autoCode_Modify}
		}

		pager = ${Lname}Service.get${Name}Pager(pager, map);
		List<${Name}> ${Lname}List = pager.getList();
		List<${Name}> lst = new ArrayList<${Name}>();
		for (int i = 0; i < ${Lname}List.size(); i++) {
			${Name} ${Lname} = (${Name}) ${Lname}List.get(i);
			//${Lname}.setStateRemark(ThinkWayUtil.getDictValueByDictKey(dictService, "${Lname}State", ${Lname}.getState()));
			lst.add(${Lname});
		}
		pager.setList(lst);
		JsonConfig jsonConfig=new JsonConfig();   
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);//防止自包含
		jsonConfig.setExcludes(ThinkWayUtil.getExcludeFields(${Name}.class));//排除有关联关系的属性字段  
		JSONArray jsonArray = JSONArray.fromObject(pager,jsonConfig);
		System.out.println(jsonArray.get(0).toString());
		return ajaxJson(jsonArray.get(0).toString());
		
	}
	
	
	//删除
	public String delete(){
		ids=id.split(",");
		${Lname}Service.updateisdel(ids, "Y");
		redirectionUrl = "${Lname}!list.action";
		return SUCCESS;
	}

	
	//编辑
	public String edit(){
		${Lname}= ${Lname}Service.load(id);
		return INPUT;	
	}
		
	//更新
		@InputConfig(resultName = "error")
		public String update() {
			${Name} persistent = ${Lname}Service.load(id);
			BeanUtils.copyProperties(${Lname}, persistent, new String[] { "id","createDate", "modifyDate"});
			${Lname}Service.update(persistent);
			redirectionUrl = "${Lname}!list.action";
			return SUCCESS;
		}
		
	//保存
	@Validations(
		requiredStrings = {
//{autoCode2}
//{autoCode_Modify2}
				@RequiredStringValidator(fieldName = "${Lname}.id", message = "ID不允许为空!")
		  }
			  
	)
	@InputConfig(resultName = "error")
	public String save()throws Exception{
		${Lname}Service.save(${Lname});
		redirectionUrl="${Lname}!list.action";
		return SUCCESS;	
	}
		
	public ${Name} get${Name}() {
		return ${Lname};
	}

	public void set${Name}(${Name} ${Lname}) {
		this.${Lname} = ${Lname};
	}


	public ${Name}Service get${Name}Service() {
		return ${Lname}Service;
	}


	public void set${Name}Service(${Name}Service ${Lname}Service) {
		this.${Lname}Service = ${Lname}Service;
	}


	//获取所有状态
	public List<Dict> getAllState() {
		return dictService.getList("dictname", "StateRemark");
	}


	public void setAllState(List<Dict> allState) {
		this.allState = allState;
	}


	public DictService getDictService() {
		return dictService;
	}


	public void setDictService(DictService dictService) {
		this.dictService = dictService;
	}
	
	
}
