package cc.jiuyi.service;

import java.util.HashMap;
import java.util.List;

import cc.jiuyi.bean.Pager;
import cc.jiuyi.entity.${Name};

/**
 * Service接口 - ${NameDes}管理
 */

public interface ${Name}Service extends BaseService<${Name}, String> {

	/**
	 * 分页取出所有${NameDes}对象
	 * 
	 * @return
	 */

	public Pager get${Name}Pager(Pager pager, HashMap<String, String> map);
	
	/**
	 * 标记删除
	 * @param ids
	 * @param oper Y/N
	 */
	public void updateisdel(String[] ids,String oper);

}