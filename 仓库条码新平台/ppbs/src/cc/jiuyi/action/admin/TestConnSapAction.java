package cc.jiuyi.action.admin;
import org.apache.struts2.convention.annotation.ParentPackage;
import cc.jiuyi.bean.SAPRequest;
import cc.jiuyi.util.SAPModel;
import cc.jiuyi.util.SAPUtil;
import com.sap.mw.jco.JCO;

@ParentPackage("admin")
public class TestConnSapAction extends BaseAdminAction{
	
	private static final long serialVersionUID = -7287601765559410775L;
	private String sapHost ;
	private String sapClient ;
	private String sapSysnr ;
	private String sapUser ;
	private String sapPasswd ;
	private String sapLang ;
	private String sapCodePage ;

	public String testconn() {
		
		SAPRequest sapRequest = new SAPRequest("ZFM_BC_COMMON_01");//获取物料描述
		sapRequest.addParameter("I_MATNR", "50.5.000574");
		SAPModel model = SAPUtil.OperSAP(sapRequest);
		if ("E".equals(model.getOuts().getStructure("ES_RETURN").getString("MSGTY"))) {
			String msg = model.getOuts().getStructure("ES_RETURN").getString("MESSAGE");
			System.out.println("msg = "+ msg);
		} else {
			JCO.Structure struct = model.getOuts().getStructure("ES_RETURN");
			String type = struct.getString("MSGTY");
			if (type.equals("E")) {
				String msg = model.getOuts().getStructure("ES_RETURN").getString("MESSAGE");
				System.out.println("msg1" +msg);
			}else{
				String maktx = model.getOuts().getValue("E_MAKTX")+"";
				System.out.println("maktx = " + maktx);
			}
		}
		
		return "SUCCESS";
	}

	public String getSapClient() {
		return sapClient;
	}

	public void setSapClient(String sapClient) {
		this.sapClient = sapClient;
	}

	public String getSapSysnr() {
		return sapSysnr;
	}

	public void setSapSysnr(String sapSysnr) {
		this.sapSysnr = sapSysnr;
	}

	public String getSapUser() {
		return sapUser;
	}

	public void setSapUser(String sapUser) {
		this.sapUser = sapUser;
	}

	public String getSapPasswd() {
		return sapPasswd;
	}

	public void setSapPasswd(String sapPasswd) {
		this.sapPasswd = sapPasswd;
	}

	public String getSapLang() {
		return sapLang;
	}

	public void setSapLang(String sapLang) {
		this.sapLang = sapLang;
	}

	public String getSapCodePage() {
		return sapCodePage;
	}

	public void setSapCodePage(String sapCodePage) {
		this.sapCodePage = sapCodePage;
	}

	public String getSapHost() {
		return sapHost;
	}

	public void setSapHost(String sapHost) {
		this.sapHost = sapHost;
	}
}
