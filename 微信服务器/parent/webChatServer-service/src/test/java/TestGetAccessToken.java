import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webChatServer.util.SpringBeanUtil;

import cn.webChatServer.pojo.AccessToken;
import cn.webChatServer.service.WebChatService;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestGetAccessToken implements Runnable {
	/*public static void main(String[] args) {
		Thread thread = new Thread(new TestGetAccessToken());
		thread.start();
	}*/
	private WebChatService webChartServer;
	private AccessToken accessToken = null;

	public TestGetAccessToken() {
		this.webChartServer = (WebChatService) SpringBeanUtil.getBeanByName("webChartServer");
	}
	public void run() {
		// TODO Auto-generated method stub
		try {
			accessToken = webChartServer.getAccessToken();
			Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);
			new Thread(new TestGetAccessToken()).start();
			// 更新access_token
			System.out.println("**************");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebChatService getWebChartServer() {
		return webChartServer;
	}

	public void setWebChartServer(WebChatService webChartServer) {
		this.webChartServer = webChartServer;
	}
}
