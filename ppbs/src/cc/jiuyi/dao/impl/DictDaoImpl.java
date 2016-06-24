package cc.jiuyi.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import cc.jiuyi.bean.Pager;
import cc.jiuyi.dao.DictDao;
import cc.jiuyi.entity.Dict;

/**
 * Dao实现类 - dict
 */

@Repository
public class DictDaoImpl extends BaseDaoImpl<Dict, String> implements DictDao {
	
	// 关联处理
	@Override
	public void delete(Dict dict) {
		super.delete(dict);
	}

	// 关联处理
	@Override
	public void delete(String id) {
		Dict dict = load(id);
		this.delete(dict);
	}

	// 关联处理
	@Override
	public void delete(String[] ids) {
		for (String id : ids) {
			Dict dict = load(id);
			this.delete(dict);
		}
	}
	
	//根据dictName和dictkey找到dict对象
	public Dict getDict(String dictname,String dictkey) {
		String hql = "from Dict as dict where dict.dictname = ? and dict.dictkey = ? ";
		return (Dict) getSession().createQuery(hql).setParameter(0, dictname).setParameter(1, dictkey).uniqueResult();
	}
	
	
	public Pager getDictPager(Pager pager,Map map) {
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Dict.class);
			pagerSqlByjqGrid(pager,detachedCriteria);

			return super.findByPager(pager,detachedCriteria);
		
	}

	@Override
	public String getDictValueByDictKey(Object dictname, Object dictkey) {
		// TODO Auto-generated method stub
		String hql = "from Dict dict where dict.dictname=? and dictkey=?order by dict.dictkey asc";
		
		return ((Dict) getSession().createQuery(hql).setParameter(0, dictname)
				.setParameter(1, dictkey).list().get(0)).getDictvalue();
	}

	//获取dict的html标签,状态
	@SuppressWarnings("unchecked")
	@Override
	public List<Dict> getSate(String dictname)
	{
		String hql="from Dict as a where a.dictname=? order by a.orderList asc";
		return this.getSession().createQuery(hql).setParameter(0, dictname).list();
	}
	
	/**
	 * 根据状态获取抽检类型
	 */
	@SuppressWarnings("unchecked")
	public String getByState(String dictname,String state)
	{
		String hql="from Dict as a where a.dictname=? and a.dictkey=?";
		List<Dict> list=this.getSession().createQuery(hql).setParameter(0, dictname).setParameter(1, state).list();
		Dict d=list.get(0);
		return d.getDictvalue();
	}
	
}