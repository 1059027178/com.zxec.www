package com.exampleCode.make;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.exampleCode.db.operate.DBsqlserver;
import com.exampleCode.model.BillsInfo;
import com.exampleCode.model.PositionsInfo;
/**
 * 查询类
 * */
public class SelectDAO {
	/*public static void main(String[] args) {
		SelectDAO dao = new SelectDAO();
		List<PositionsInfo> list = dao.selectWuLiaoInfo("", "", "","");
	}*/
	/**
	 * @author YangYang: 插入表数据
	 * @param  useNumber  已领用数量
	 * @param  dingdaohao 订单号
	 * @param  wuliaohao  物料号
	 * @return
	 */
	public boolean writeUseNumber(String useNumber,String dingdaohao,String wuliaohao){
		
		boolean result = true;
		
		Connection conn = null;
		
		Statement ps = null;

		String sql = "update BillsInfo_Table set useNumber = '"+useNumber+ "' where itemNO = '"+wuliaohao+"' and billsNO = '"+dingdaohao+"'";
		
		System.out.println("***数据库操作：sql= "+sql);
		try {
			
			conn = DBsqlserver.getConnection();
			
			ps = conn.createStatement();
			
			ps.executeUpdate(sql);
			
			System.out.println("****数据库操作结束****");
			
			conn.close();
			ps.close();
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
		
	}
	/**
	 * @author YangYang ：查询订单信息
	 * @param billsNO 订单号
	 * @param matnr   物料编码
	 * @return List<BillsInfo>
	 */
	public List<BillsInfo> selectDingDanInfo(String dingdanhao,String wuliaohao){
		List<BillsInfo> list = new ArrayList<BillsInfo>();
		
		Connection conn = null;
		
		ResultSet rs = null;
		
		PreparedStatement ps = null;

		String sql = "select * from BillsInfo_Table where 1=1 ";
		//物料编号
		if (wuliaohao != "")  sql+= "and itemNO ='"+ wuliaohao +"'";
		//订单号
		if (dingdanhao != "")  sql+= " and billsNO = '" + dingdanhao + "'";
		
		sql+= " order by billsNO";
		
		System.out.println("***数据库操作：sql= "+sql);
		try {
			
			conn = DBsqlserver.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			int i = 1;
			System.out.println("****数据库操作开始****");
			while (rs.next()) {
				BillsInfo info = new BillsInfo();
				
				String billsNO 	= rs.getString("billsNO");
				String itemNO	= rs.getString("itemNO");
				String number 	= rs.getString("number");
				String batchNo  = rs.getString("batchNo");
				String useNumber= rs.getString("useNumber") == null ? "" : rs.getString("useNumber");

				System.out.println(i+"| billsNO= "+billsNO+"| itemNO=  "+itemNO+"| number=  "+number+"| batchNo=  "+batchNo+"| useNumber=  "+useNumber);
				
				info.setBillsNO(billsNO);
				info.setItemNO(itemNO);
				info.setNumber(number);
				info.setBatchNO(batchNo);
				info.setUseNumber(useNumber);
				
				list.add(info);
				
				i++;
				if (i > 5) {
					i = 1;
					System.out.println("");
				}
			}
			System.out.println("****数据库操作结束****");
			DBsqlserver.free(rs, ps, conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * @author YangYang: 查询物料信息
	 * @param matnr 物料编号
	 * @param lgort 库存地点
	 * @param charg 批次号
	 * @param literaNO 仓位号
	 * @return List<PositionsInfo>
	 */
	public List<PositionsInfo> selectWuLiaoInfo(String matnr,String lgort,String charg,String literaNO){
		
		List<PositionsInfo> list = new ArrayList<PositionsInfo>();
		
		Connection conn = null;
		
		ResultSet rs = null;
		
		PreparedStatement ps = null;

		String sql = "select * from PositionsInfo_Table where 1=1 ";
		//物料编号
		if (matnr != "")  sql+= "and itemNO ='"+ matnr +"'";
		//库存地点
		if (lgort != "")  sql+= " and storageLocation = '" + lgort + "'";
		//批次号
		if (charg != "")  sql+= " and batchNO = '" + charg + "'";
		//仓位号
		if (literaNO != "")  sql+= " and literaNO = '" + literaNO + "'";
		
		sql+= " order by supplierProductDate";
		
		System.out.println("***数据库操作：sql= "+sql);
		try {
			
			conn = DBsqlserver.getConnection();
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			int i = 1;
			System.out.println("****数据库操作开始****");
			while (rs.next()) {
				PositionsInfo info = new PositionsInfo();
				
				String batchNO 		   = rs.getString("batchNO");
				String factoryNO	   = rs.getString("factoryNO");
				String itemDescription = rs.getString("itemDescription");
				String itemNO		   = rs.getString("itemNO");
				String literaNo		   = rs.getString("literaNO");
				String number		   = rs.getString("number");
				String storageLocation = rs.getString("storageLocation");
				String supplierBatch   = rs.getString("supplierBatch");
				String supplierProductDate	= rs.getString("supplierProductDate");
				String unit			   = rs.getString("unit");
				String warehouseNO	   = rs.getString("warehouseNO");
//				String zhuanyi	   	   = rs.getString("zhuanyishuliang");

				System.out.println(i+"| batchNO= "+batchNO+
						"| factoryNO= "			  +factoryNO+
						"| itemDescription= "	  +itemDescription+
						"| itemNO= "			  +itemNO+
						"| literaNO= "	  		  +literaNo+
						"| number= "			  +number+
						"| storageLocation= "	  +storageLocation+
						"| supplierBatch= "		  +supplierBatch+
						"| supplierProductDate= " +supplierProductDate+
						"| unit= "				  +unit+
						"| warehouseNO= "		  +warehouseNO);
//						"| zhuanyi= "			  +zhuanyi);
				
				info.setBatchNO(batchNO);
				info.setFactoryNO(factoryNO);
				info.setItemDescription(itemDescription);
				info.setItemNO(itemNO);
				info.setLiteraNO(literaNo);
				info.setNumber(number);
				info.setStorageLocation(storageLocation);
				info.setSupplierBatch(supplierBatch);
				info.setSupplierProductDate(supplierProductDate);
				info.setUnit(unit);
				info.setWarehouseNO(warehouseNO);
//				info.setZhuanyishuliang(zhuanyi);
				list.add(info);
				
				i++;
				if (i > 5) {
					i = 1;
					System.out.println("");
				}
			}
			System.out.println("****数据库操作结束****");
			DBsqlserver.free(rs, ps, conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
