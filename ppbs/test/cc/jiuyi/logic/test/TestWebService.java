package cc.jiuyi.logic.test;

import java.net.URL;

import javax.annotation.Resource;

import org.codehaus.xfire.client.Client;
import org.junit.Test;

import cc.jiuyi.service.DictService;

public class TestWebService extends BaseTestCase {
	@Resource  
	private DictService dictService;
	
	protected void setUp() {
		
	}
	
	@Test
	public void webserviceTest() throws Exception{
		Client client = new Client(new URL("http://127.0.0.1:8081/service/DictWebService?wsdl"));  
	    Object[] results = client.invoke("getDict", new Object[] {});  
	    System.out.println(results[0]);  
	}
	
}


