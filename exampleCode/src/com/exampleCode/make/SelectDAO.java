package com.exampleCode.make;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.exampleCode.db.operate.DBsqlserver;
import com.exampleCode.model.PositionsInfo;
/**
 * 查询类
 * */
public class SelectDAO {
	/*public static void main(String[] args) {
		SelectDAO dao = new SelectDAO();
		List<PositionsInfo> list = dao.selectWuLiaoInfo("", "", "","");
	}*/
	
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
