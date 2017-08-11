import org.springframework.beans.factory.annotation.Autowired;
import cn.webChatServer.pojo.AccessToken;
import cn.webChatServer.service.WebChatService;
import cn.webChatServer.service.WebChatServiceImpl;

public class SingleAccessToken {
	@Autowired
    private AccessToken accessToken;
	
	private WebChatService webChartServer = new WebChatServiceImpl();
	
    private static SingleAccessToken singleAccessToken;
    /**
     * 私有构造函数
     */
    public SingleAccessToken(){
        accessToken = webChartServer.getAccessToken();
        initThread(accessToken.getExpiresIn());
    }
    /**
     * 获取SingleAccessToken对象
     * @return
     */
    public static SingleAccessToken getInstance(){
        if(singleAccessToken==null){
            singleAccessToken=new SingleAccessToken();
        }
        return singleAccessToken;
    }

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }
    /**
     * 开启线程，设置SingleAccessToken为空
     */
    private void initThread(final int expiresIn){
        new Thread(new Runnable() {
            public void run() {
                try {
                   //睡眠
					Thread.sleep((expiresIn - 200) * 1000);   
                    singleAccessToken=null;

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }).start();
    }

}