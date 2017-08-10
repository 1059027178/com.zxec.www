import org.springframework.beans.factory.annotation.Autowired;

import cn.webChatServer.pojo.AccessToken;
import cn.webChatServer.service.WebChartServer;


public class TestGetAccessToken {
	
	@Autowired
	private static  WebChartServer webChartServer;
	@Autowired
	private static  AccessToken accessToken;
	
	public static void main(String[] args) {
		TestGetAccessToken.InitThread();
	}
	
	public static void InitThread(){
		new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					accessToken = webChartServer.getAccessToken();
					Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);
					TestGetAccessToken.InitThread();
					//更新access_token
					System.out.println("**************");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
}
