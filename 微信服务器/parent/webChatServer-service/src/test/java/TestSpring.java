
import cn.webChatServer.service.WebChatService;
import cn.webChatServer.service.WebChatServiceImpl;


public class TestSpring {
	
	private static WebChatService webChatService = new WebChatServiceImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGetAccessToken testGetAccessToken = new TestGetAccessToken(webChatService);
		Thread thread = new Thread(testGetAccessToken);
		thread.start();
	}

}
