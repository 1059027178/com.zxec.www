package cc.jiuyi.logic.test;
import org.springframework.web.servlet.ModelAndView;

import com.sap.mw.jco.JCO;

import cc.jiuyi.bean.SAPRequest;
import cc.jiuyi.util.SAPModel;
import cc.jiuyi.util.SAPUtil;

public class TestSAPconn {

	public static void main(String[] args) {
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
	}

}
