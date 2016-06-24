package cc.jiuyi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import cc.jiuyi.bean.Pager;
import cc.jiuyi.bean.Pager.OrderType;
import cc.jiuyi.dao.${Name}Dao;
import cc.jiuyi.entity.${Name};
import cc.jiuyi.service.${Name}Service;

/**
 * Service实现类 -${NameDes}管理
 * @author welson
 *
 */

@Service
public class ${Name}ServiceImpl extends BaseServiceImpl<${Name}, String>implements ${Name}Service{

	@Resource
	private ${Name}Dao postDao;
	
	@Resource
	public void setBaseDao(${Name}Dao postDao){
		super.setBaseDao(postDao);
	}
	

	@Override
	public Pager get${Name}Pager(Pager pager, HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return postDao.get${Name}Pager(pager, map);
	}

	@Override
	public void updateisdel(String[] ids, String oper) {
		// TODO Auto-generated method stub
		postDao.updateisdel(ids, oper);
		
	}

	
}
