package cc.jiuyi.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cc.jiuyi.bean.Pager;
import cc.jiuyi.bean.jqGridSearchDetailTo;
import cc.jiuyi.dao.${Name}Dao;
import cc.jiuyi.entity.${Name};


/**
 * Dao实现类 - ${Name}
 */

@Repository
public class ${Name}DaoImpl extends BaseDaoImpl<${Name}, String> implements ${Name}Dao {
	
	public Pager get${Name}Pager(Pager pager, HashMap<String, String> map) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(${Name}.class);
		pagerSqlByjqGrid(pager,detachedCriteria);
		if (map.size() > 0) {
//{autoCode}
//{autoCode_Modify}
		}		
		detachedCriteria.add(Restrictions.eq("isDel", "N"));//取出未删除标记数据
		return super.findByPager(pager, detachedCriteria);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<${Name}> get${Name}List() {
		String hql = "From ${Name} ${Lname} order by ${Lname}.id asc ${Lname}.crateDate desc";
		return getSession().createQuery(hql).list();
	}

	@Override
	public void updateisdel(String[] ids, String oper) {
		for(String id:ids){
			${Name} x${Name}=super.load(id);
			x${Name}.setIsDel(oper);//标记删除
			super.update(x${Name});
		}
		
	}
}