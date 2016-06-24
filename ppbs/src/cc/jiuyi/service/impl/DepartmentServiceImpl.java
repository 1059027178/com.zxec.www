package cc.jiuyi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cc.jiuyi.dao.DepartmentDao;
import cc.jiuyi.entity.Department;
import cc.jiuyi.service.DepartmentService;
//import org.springmodules.cache.annotations.CacheFlush;

/**
 * Service实现类 - 随工单
 */

@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department, String> implements DepartmentService {
	
	@Resource
	private DepartmentDao departmentdao;
	
	@Resource
	public void setBaseDao(DepartmentDao departmentdao) {
		super.setBaseDao(departmentdao);
	}

	@Override
	public void updateisdel(String[] ids, String oper) {
		departmentdao.updateisdel(ids, oper);
	}

	@Override
	public List getAllByHql() {
		return departmentdao.getAllByHql();
	}



}