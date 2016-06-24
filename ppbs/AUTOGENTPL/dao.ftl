package cc.jiuyi.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.jiuyi.bean.Pager;
import cc.jiuyi.entity.Brand;
import cc.jiuyi.entity.${Name};

/**
 * Dao接口 - 字典
 */

public interface ${Name}Dao extends BaseDao<${Name}, String> {
	
	/**
	 * 取出所有${NameDes}对象
	 * @return
	 */
	public List<${Name}> get${Name}List();
	
	public Pager get${Name}Pager(Pager pager,HashMap<String,String>map);

	/**
	 * 标记删除
	 * @param id
	 * @param oper Y/N
	 */
	public void updateisdel(String[] ids,String oper);
}