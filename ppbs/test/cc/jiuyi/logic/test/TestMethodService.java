package cc.jiuyi.logic.test;

import java.io.IOException;

import javax.annotation.Resource;

import org.junit.Test;

import cc.jiuyi.bean.Pager;
import cc.jiuyi.bean.Pager.OrderType;
import cc.jiuyi.service.DictService;

public class TestMethodService extends BaseTestCase {
	@Resource  
	private DictService dictService;
	
	protected void setUp() {
		
	}
	
	@Test
	public void getDictCountTest() throws IOException{
		Pager pager = new Pager();
		pager.setOrderType(OrderType.asc);
		pager.setOrderBy("orderList");
		pager = dictService.findByPager(pager);
		System.out.println(pager.getList().size());
	}	
	
	
	
}


