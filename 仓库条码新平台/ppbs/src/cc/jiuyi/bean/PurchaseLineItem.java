package cc.jiuyi.bean;

import java.util.ArrayList;
import java.util.List;

import cc.jiuyi.util.SAPModel;

import com.sap.mw.jco.JCO;

/**
 * SAP Bean类，采购订单行项目明细
 * 
 */
public class PurchaseLineItem {

	// from input parameter
	private String EBELN; //采购订单

	// from export
	private String LIFNR; //供应商
	private String NAME1; //供应商名称

	// from export table
	private String EBELP; //行项目
	private String MATNR; // 物料编码
	private String MAKTX; // 物料描述
	private String KZKRI; //质检与免检字段（勾选则质检，不勾则免检）
	private Double WSHSL; //显示未收货数量
	private Double MENGE; //采购订单数量
	private Double WEMNG; //采购订单已经收货数量
	private String MEINS; //单位
	private String LGORT; //库存地点
	private String MATKL; //物料组
	private String WGBEZ; // 物料组描述
	private String WERKS; // 工厂
	private String LBPRT; // 打印参数；1:物料；2：物料批次；3：物料序列号；4：物料批次序列号

	// for upload
	private String CHARG; // 批次
	private List<String> SERNRList; // 序列号列表
	private Double ERFMG; // 实际收货数量

	public PurchaseLineItem() {
		super();
	}

	public PurchaseLineItem(String eBELN, String lIFNR, String nAME1) {
		super();
		EBELN = eBELN;
		LIFNR = lIFNR;
		NAME1 = nAME1;
	}

	/**
	 * 根据抬头和{@link SAPModel}生产采购订单行项目List
	 * 
	 * @param wERKS
	 *            工厂
	 * @param eBELN
	 *            采购订单
	 * @param model
	 * @return
	 */
	public static List<PurchaseLineItem> jcoModelToBean(String eBELN, SAPModel model) {
		JCO.Table jTable = model.getOuttab().getTable("T_OUT");
		List<PurchaseLineItem> items = new ArrayList<PurchaseLineItem>();
		if (jTable.getNumRows() > 0) {
			for (int i = 0; i < jTable.getNumRows(); i++) {
				jTable.setRow(i);
				PurchaseLineItem item = new PurchaseLineItem(eBELN, model.getOuts().getString("E_LIFNR"), model
						.getOuts().getString("E_NAME1"));
				item.setEBELP(jTable.getString("EBELP"));
				item.setMATNR(jTable.getString("MATNR"));
				item.setMAKTX(jTable.getString("MAKTX"));
				item.setKZKRI(jTable.getString("KZKRI"));
				item.setWSHSL(jTable.getDouble("WSHSL"));
				item.setMENGE(jTable.getDouble("MENGE"));
				item.setWEMNG(jTable.getDouble("WEMNG"));
				item.setMEINS(jTable.getString("MEINS"));
				item.setLGORT(jTable.getString("LGORT"));
				item.setMATKL(jTable.getString("MATKL"));
				item.setWGBEZ(jTable.getString("WGBEZ"));
				item.setWERKS(jTable.getString("WERKS"));
				item.setLBPRT(jTable.getString("LBPRT"));
				items.add(item);
			}
		}
		return items;
	}

	public String getWERKS() {
		return WERKS;
	}

	public void setWERKS(String wERKS) {
		WERKS = wERKS;
	}

	public String getEBELN() {
		return EBELN;
	}

	public void setEBELN(String eBELN) {
		EBELN = eBELN;
	}

	public String getLIFNR() {
		return LIFNR;
	}

	public void setLIFNR(String lIFNR) {
		LIFNR = lIFNR;
	}

	public String getNAME1() {
		return NAME1;
	}

	public void setNAME1(String nAME1) {
		NAME1 = nAME1;
	}

	public String getEBELP() {
		return EBELP;
	}

	public void setEBELP(String eBELP) {
		EBELP = eBELP;
	}

	public String getMATNR() {
		return MATNR;
	}

	public void setMATNR(String mATNR) {
		MATNR = mATNR;
	}

	public String getMAKTX() {
		return MAKTX;
	}

	public void setMAKTX(String mAKTX) {
		MAKTX = mAKTX;
	}

	public String getKZKRI() {
		return KZKRI;
	}

	public void setKZKRI(String kZKRI) {
		KZKRI = kZKRI;
	}

	public Double getWSHSL() {
		return WSHSL;
	}

	public void setWSHSL(Double wSHSL) {
		WSHSL = wSHSL;
	}

	public Double getMENGE() {
		return MENGE;
	}

	public void setMENGE(Double mENGE) {
		MENGE = mENGE;
	}

	public Double getWEMNG() {
		return WEMNG;
	}

	public void setWEMNG(Double wEMNG) {
		WEMNG = wEMNG;
	}

	public String getMEINS() {
		return MEINS;
	}

	public void setMEINS(String mEINS) {
		MEINS = mEINS;
	}

	public String getLGORT() {
		return LGORT;
	}

	public void setLGORT(String lGORT) {
		LGORT = lGORT;
	}

	public String getMATKL() {
		return MATKL;
	}

	public void setMATKL(String mATKL) {
		MATKL = mATKL;
	}

	public String getWGBEZ() {
		return WGBEZ;
	}

	public void setWGBEZ(String wGBEZ) {
		WGBEZ = wGBEZ;
	}

	public String getCHARG() {
		return CHARG;
	}

	public void setCHARG(String cHARG) {
		CHARG = cHARG;
	}

	public List<String> getSERNRList() {
		return SERNRList;
	}

	public void setSERNRList(List<String> sERNRList) {
		SERNRList = sERNRList;
	}

	public Double getERFMG() {
		return ERFMG;
	}

	public void setERFMG(Double eRFMG) {
		ERFMG = eRFMG;
	}

	
	public String getLBPRT() {
		return LBPRT;
	}

	
	public void setLBPRT(String lBPRT) {
		LBPRT = lBPRT;
	}

	
}
