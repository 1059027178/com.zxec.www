package com.exampleCode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainServlet extends HttpServlet {

	public MainServlet() {
		super();
	}
	public void destroy() {
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();*/
	}

	
	@SuppressWarnings({ "unused", "null" })
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flag = null;
		String two = null;
		try {
			flag = request.getParameter("flag").toString().trim();
			System.out.println("******当前操作："+flag);
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		/*登录*/
		if (flag.equals("login")) {
			HttpSession session = request.getSession();
			String username = request.getParameter("userBH").toString().trim();
			System.out.println("****用户账户："+username+"已登录*****");
			session.setAttribute("username", username);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp"); // 使用req对象获取RequestDispatcher对象
			dispatcher.forward(request, response); // 使用RequestDispatcher对象在服务器端向目的路径跳转
		}
		
		/*主页一级菜单*/
		else if (flag.equals("1")) {//1.收货
			RequestDispatcher dispatcher = request.getRequestDispatcher("/include/two1.jsp"); 
			dispatcher.forward(request, response); 
		}else if (flag.equals("2")) {//2.发货
			RequestDispatcher dispatcher = request.getRequestDispatcher("/include/two2.jsp"); 
			dispatcher.forward(request, response); 
		}else if (flag.equals("3")) {//3.仓库作业
			RequestDispatcher dispatcher = request.getRequestDispatcher("/include/two3.jsp"); 
			dispatcher.forward(request, response); 
		}else if (flag.equals("4")) {//4.查询
			RequestDispatcher dispatcher = request.getRequestDispatcher("/include/two4.jsp"); 
			dispatcher.forward(request, response); 
		}
		
		/*收货二级菜单*/
		else if(flag.equals("1.1")){//PO收货
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/receipt_add.jsp"); 
			dispatcher.forward(request, response); 
		}
		else if(flag.equals("1.2")){//上架
			String string = request.getParameter("str") == null ? "" : request.getParameter("str").toString().trim();
			System.out.println("***上架操作："+string);
			if (string != "") {
				String aufnr 	= request.getParameter("aufnr").toString().trim();
				String lineItem = request.getParameter("lineItem").toString().trim();
				String boxs 	= request.getParameter("boxs").toString().trim();
				String wemng	= request.getParameter("wemng").toString().trim();
				String matnr 	= request.getParameter("matnr").toString().trim();
				String maktx 	= request.getParameter("maktx").toString().trim();
				String everyBagNumber 	= request.getParameter("everyBagNumber").toString().trim();
				String batchNo 	= request.getParameter("batchNo").toString().trim();
				String lgort 	= request.getParameter("lgort").toString().trim();
				String unit 	= request.getParameter("unit").toString().trim();
				
				request.getSession().setAttribute("str", string);
				request.getSession().setAttribute("boxs", boxs);
				request.getSession().setAttribute("aufnr", aufnr);
				request.getSession().setAttribute("lineItem", lineItem);
				request.getSession().setAttribute("wemng", wemng);
				request.getSession().setAttribute("maktx", maktx);
				request.getSession().setAttribute("matnr", matnr);
				request.getSession().setAttribute("everyBagNumber", everyBagNumber);
				request.getSession().setAttribute("batchNo", batchNo);
				request.getSession().setAttribute("lgort", lgort);
				request.getSession().setAttribute("unit", unit);
			}else{
				request.getSession().invalidate();//清空session
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/grounding_add.jsp"); 
			dispatcher.forward(request, response); 
		}
		else if(flag.equals("1.3")){//PO收货冲销
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/reversal_add.jsp"); 
			dispatcher.forward(request, response); 
		}
		
		/*发货二级菜单*/
		else if (flag.equals("2.1")) {//生产掉拔单领料
			request.getSession().setAttribute("type", "生产领料单");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/delivery/document_pick.jsp"); 
			dispatcher.forward(request, response); 
		}else if (flag.equals("2.2")) {//研发领料
			request.getSession().setAttribute("type", "研发领料单");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/delivery/document_pick.jsp"); 
			dispatcher.forward(request, response); 
		}else if (flag.equals("2.3")) {//委外发料
			request.getSession().setAttribute("type", "委外发料");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/delivery/weiwai_xiajia.jsp"); 
			dispatcher.forward(request, response); 
		}else if (flag.equals("2.4")) {//下架
			String matnr  	= request.getParameter("matnr")   == null ? "": request.getParameter("matnr");
			String batchNo  = request.getParameter("batchNo") == null ? "": request.getParameter("batchNo");
			System.out.println("***下架操作**matnr："+matnr+"；batchNo："+batchNo+"***");
			if (!matnr.equals("") && !batchNo.equals("")) {
				request.getSession().setAttribute("batchNo", batchNo);
				request.getSession().setAttribute("matnr", matnr);
			}else {
				request.getSession().invalidate();
			}
			request.getSession().setAttribute("type", "下架");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/delivery/weiwai_xiajia_pick.jsp"); 
			dispatcher.forward(request, response); 
		}
		/*仓库作业二级菜单*/
		else if (flag.equals("3.1")) {//仓位冻结/解冻
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/repertory_add.jsp"); 
			dispatcher.forward(request, response); 
		}else if (flag.equals("3.2")) {//仓位转移
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/storage_move.jsp"); 
			dispatcher.forward(request, response); 
		}else if (flag.equals("3.3")) {//库存转储
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/storageM_view.jsp"); 
			dispatcher.forward(request, response); 
		}else if (flag.equals("3.4")) {//记账变更
			String matnr  	= request.getParameter("matnr")   == null ? "": request.getParameter("matnr");
			String num  	= request.getParameter("num")   == null ? "": request.getParameter("num");
			if (!matnr.equals("") && !num.equals("")) {
				request.getSession().setAttribute("matnr", matnr);
				request.getSession().setAttribute("num", num);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/lubu_view.jsp"); 
			dispatcher.forward(request, response); 
		}
		/*查询二级菜单*/
		else if (flag.equals("4.1")) {//物料查询
			RequestDispatcher dispatcher = request.getRequestDispatcher("/matquy/matquy_Query.jsp"); 
			dispatcher.forward(request, response); 
		}else if (flag.equals("4.2")) {//仓位查询
			RequestDispatcher dispatcher = request.getRequestDispatcher("/lgpquy/lgpquy_Query.jsp"); 
			dispatcher.forward(request, response); 
		}else if (flag.equals("4.3")) {//库存查询
			RequestDispatcher dispatcher = request.getRequestDispatcher("/stoquy/stoquy_Query.jsp"); 
			dispatcher.forward(request, response); 
		}else if (flag.equals("4.4")) {//转储单查询
			RequestDispatcher dispatcher = request.getRequestDispatcher("/dumquy/dumquy_Query.jsp"); 
			dispatcher.forward(request, response); 
		}
		
		/***1收货***/
		/*PO收货*/
		else if (flag.equals("POshouhuo")) {
			String aufnr 	= request.getParameter("aufnr").toString().trim();
			String lineItem = request.getParameter("lineItem").toString().trim();
			String boxs 	= request.getParameter("boxs").toString().trim();
			String wemng	= request.getParameter("wemng").toString().trim();
			String str 		= request.getParameter("str").toString().trim() == null ? "" : request.getParameter("str").trim();
			String matnr 	= request.getParameter("matnr").toString().trim();
			String maktx 	= request.getParameter("maktx").toString().trim();
			String everyBagNumber 	= request.getParameter("everyBagNumber").toString().trim();
			String batchNo 	= request.getParameter("batchNo").toString().trim();
			String lgort 	= request.getParameter("lgort").toString().trim();
			String unit 	= request.getParameter("unit").toString().trim();
			System.out.println("***aufnr:"+str+"**");
			if (!str.equals("")) {
				System.out.println("***PO收货成功***");
				request.getSession().setAttribute("type", "收货成功！");
				request.getSession().setAttribute("message", "订单号为"+aufnr+"物料创建成功！");
				
				System.out.println("*****PO收货确认*****");
				System.out.println("*****aufnr:"+aufnr+";lineItem:"+lineItem+";boxs:"+boxs+";wemng:"+wemng);
				System.out.println("*******str:"+str);
				request.getSession().setAttribute("str", str);
				request.getSession().setAttribute("aufnr", aufnr);
				request.getSession().setAttribute("lineItem", lineItem);
				request.getSession().setAttribute("boxs", boxs);
				request.getSession().setAttribute("matnr", matnr);
				request.getSession().setAttribute("maktx", maktx);
				request.getSession().setAttribute("everyBagNumber", everyBagNumber);
				request.getSession().setAttribute("batchNo", batchNo);
				request.getSession().setAttribute("wemng", wemng);
				request.getSession().setAttribute("lgort", lgort);
				request.getSession().setAttribute("unit", unit);
				
				request.getSession().setAttribute("sobkz", "Z-00");
				
			}else {
				System.out.println("***PO收货失败***");
				request.getSession().setAttribute("type", "收货失败！");
				request.getSession().setAttribute("message", "订单号为"+aufnr+"物料创建失败！");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/receipt_edit.jsp"); 
			dispatcher.forward(request, response);
		}
		/*上架*/
		else if (flag.equals("groundingView")) {
			
			String matnr = request.getParameter("matnr") == null ? "" : request.getParameter("matnr").toString().trim();
			if (!matnr.equals("")) {
				System.out.println("***上架仓位选择"+matnr);
				request.getSession().setAttribute("matnr", matnr);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/grounding_view.jsp"); 
			dispatcher.forward(request, response);
		}
		else if (flag.equals("groundingEdit")) {
			String matnr = request.getParameter("matnr") == null ? "" : request.getParameter("matnr").trim();
			String message = null;
			System.out.println("***上架确认："+matnr);
			if (!matnr.equals("")) {
				message = "物料号为"+matnr+"上架成功！";
			}else {
				message = "物料上架失败！";
			}
			System.out.println("***message:"+message);
			request.getSession().setAttribute("message", message);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/grounding_edit.jsp"); 
			dispatcher.forward(request, response);
		}
		/*PO收货冲销*/
		else if (flag.equals("reversalCrt")) {
			String aufnr = request.getParameter("aufnr") == null ? "" : request.getParameter("aufnr").toString().trim();
			System.out.println("***收货冲销订单号："+aufnr);
			String message =null;
			String type = null;
			if (!aufnr.equals("")) {
				type = "PO收货冲销成功！";
				message = "采购订单号："+aufnr;
				
				String lineItem = request.getParameter("lineItem").toString().trim();
				String boxs 	= request.getParameter("boxs").toString().trim();
				String wemng	= request.getParameter("wemng").toString().trim();
				String str 		= request.getParameter("str").toString().trim() == null ? "" : request.getParameter("str").trim();
				String matnr 	= request.getParameter("matnr").toString().trim();
				String maktx 	= request.getParameter("maktx").toString().trim();
				String everyBagNumber 	= request.getParameter("everyBagNumber").toString().trim();
				String batchNo 	= request.getParameter("batchNo").toString().trim();
				String lgort 	= request.getParameter("lgort").toString().trim();
				String unit 	= request.getParameter("unit").toString().trim();
				System.out.println("***aufnr:"+str+"**");
				System.out.println("*****PO收货冲销确认*****");
				System.out.println("*****aufnr:"+aufnr+";lineItem:"+lineItem+";boxs:"+boxs+";wemng:"+wemng);
				System.out.println("*******str:"+str);
				
				request.getSession().setAttribute("str", str);
				request.getSession().setAttribute("aufnr", aufnr);
				request.getSession().setAttribute("lineItem", lineItem);
				request.getSession().setAttribute("boxs", boxs);
				request.getSession().setAttribute("matnr", matnr);
				request.getSession().setAttribute("maktx", maktx);
				request.getSession().setAttribute("everyBagNumber", everyBagNumber);
				request.getSession().setAttribute("batchNo", batchNo);
				request.getSession().setAttribute("wemng", wemng);
				request.getSession().setAttribute("lgort", lgort);
				request.getSession().setAttribute("unit", unit);
			}else {
				type = "PO收货冲销失败！";
				message = " ";
			}
			request.getSession().setAttribute("message", message);
			request.getSession().setAttribute("type", type);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/reversal_msg.jsp"); 
			dispatcher.forward(request, response);
		}
		/***1收货***/
		/***发货***/
		/*下架*/
		else if (flag.equals("xiajia")) {
			String matnr = request.getParameter("matnr") == null ? "" : request.getParameter("matnr").trim();
			String batchNO = request.getParameter("batchNo") == null ? "" : request.getParameter("batchNo").trim();
			String maktx = null;
			System.out.println("***发货下架："+matnr);
			if(matnr.equals("C.9.291400")) maktx = "C2沙剂-规格(25kg/桶)";
	  		else if(matnr.equals("C.6.040501")) maktx = "ABS 规格(730 颜色:本色 玻纤:无 其他:/)";
	  		else if(matnr.equals("C.6.040601")) maktx = "ABS-GP-22 颜色:本色 玻纤:/ 其他:/";
	  		else if(matnr.equals("C.6.040701")) maktx = "ABS规格(710 颜色:白色 玻纤:/ 其他:锦湖日丽710)";
	  		else if(matnr.equals("C.6.040802")) maktx = "ABS规格(4330C 颜色:本色 玻纤:/ 其他:/)";
			
			request.getSession().setAttribute("matnr", matnr);
			request.getSession().setAttribute("maktx", maktx);
			request.getSession().setAttribute("batchNo", batchNO);
			request.getSession().setAttribute("type", "下架");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/xiajia_pick.jsp"); 
			dispatcher.forward(request, response);
			
		}else if (flag.equals("xiajiaSave")) {
			String matnr = request.getParameter("matnr") == null ? "" : request.getParameter("matnr").trim();
			String message = null;
			String type = null;
			if (!matnr.equals("")) {
				message = "编号为"+matnr+"物料,";
				type = "下架操作成功！";
			}else {
				message = "下架操作失败！";
				type = "请检查数量是否超出范围！";
			}
			request.getSession().setAttribute("message", message);
			request.getSession().setAttribute("type", type);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/xiajia_save.jsp"); 
			dispatcher.forward(request, response);
		}/*下架*/
		/*委外下架*/
		else if (flag.equals("weiwaiB")) {
			String matnr = request.getParameter("matnr") == null ? "" : request.getParameter("matnr").trim();
			String aufnr = request.getParameter("aufnr") == null ? "" : request.getParameter("aufnr").trim();
			String maktx = null;
			System.out.println("***发货下架："+matnr);
			if(matnr.equals("C.9.291400")) maktx = "C2沙剂-规格(25kg/桶)";
	  		else if(matnr.equals("C.6.040501")) maktx = "ABS 规格(730 颜色:本色 玻纤:无 其他:/)";
	  		else if(matnr.equals("C.6.040601")) maktx = "ABS-GP-22 颜色:本色 玻纤:/ 其他:/";
	  		else if(matnr.equals("C.6.040701")) maktx = "ABS规格(710 颜色:白色 玻纤:/ 其他:锦湖日丽710)";
	  		else if(matnr.equals("C.6.040802")) maktx = "ABS规格(4330C 颜色:本色 玻纤:/ 其他:/)";
			
			request.getSession().setAttribute("matnr", matnr);
			request.getSession().setAttribute("maktx", maktx);
			request.getSession().setAttribute("aufnr", aufnr);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/weiwai_xiajia_B.jsp"); 
			dispatcher.forward(request, response);
		}else if (flag.equals("weiwaiC")) {
			String matnr = request.getParameter("matnr") == null ? "" : request.getParameter("matnr");
			String aufnr = request.getParameter("aufnr") == null ? "" : request.getParameter("aufnr");
			String maktx = "C2沙剂-规格(25kg/桶)"; 
			String num = request.getParameter("num") == null ? "" : request.getParameter("num");
			System.out.println("***matnr："+matnr+"；aufnr："+aufnr+"；maktx："+maktx+"；num："+num+"***");
			if (!maktx.equals("") && !aufnr.equals("") && !maktx.equals("") && !num.equals("")) {
				request.getSession().setAttribute("matnr", matnr);
				request.getSession().setAttribute("aufnr", aufnr);
				request.getSession().setAttribute("maktx", maktx);
				request.getSession().setAttribute("num", num);
				request.getSession().setAttribute("message", "下架成功！转储单号为：");
			}else {
				request.getSession().invalidate();
				request.getSession().setAttribute("message", "下架失败！");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/weiwai_xiajia_C.jsp"); 
			dispatcher.forward(request, response);
			
		}else if (flag.equals("weiwaiD")) {
			String PONO = request.getParameter("PONO") == null ? "" : request.getParameter("PONO").trim();
			String message = null;
			if (PONO != "") {
				message = "单号为"+PONO+"发货成功！";
			}else {
				message = "发货失败！";
			}
			request.getSession().setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/weiwai_xiajia_D.jsp"); 
			dispatcher.forward(request, response);
			
		}
		/*委外下架*/
		/*生产领料单*/
		else if(flag.equals("shengchanA")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/lingliaodan_A.jsp"); 
			dispatcher.forward(request, response);
		}
		else if(flag.equals("shengchanB")){
//			String matnr = "C.9.291400";
//			String maktx = "C2沙剂-规格(25kg/桶)";
//			request.getSession().setAttribute("matnr", matnr);
//			request.getSession().setAttribute("maktx", maktx);
			String batchNO = request.getParameter("batchNO") == null ? "" : request.getParameter("batchNO").trim();
			if (!batchNO.equals("")) {
				request.getSession().setAttribute("batchNO", batchNO);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/lingliaodan_B.jsp"); 
			dispatcher.forward(request, response);
			
		}else if(flag.equals("shengchanC")){
			String matnr = request.getParameter("matnr") == null ? "" : request.getParameter("matnr").trim();
			String maktx = null;
			if (matnr.equals("C.9.291400")) {
				maktx = "C2沙剂-规格(25kg/桶)";
			}
			else if (matnr.equals("C.9.291470")) {
				maktx = "Pro Cr23 三价铬保护剂规格(20L/桶)";
			}
			else if (matnr.equals("C.6.040601")) {
				maktx = "ABS-GP-22 颜色:本色 玻纤:/ 其他:/";
			}
			request.getSession().setAttribute("matnr", matnr);
			request.getSession().setAttribute("maktx", maktx);
			String batchNO = request.getParameter("batchNO") == null ? "" : request.getParameter("batchNO").trim();
			if (!batchNO.equals("")) {
				request.getSession().setAttribute("batchNO", batchNO);
			}
//			System.out.println("***matnr**"+matnr+"**maktx**"+maktx+"**batchNO**"+batchNO+"**");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/lingliaodan_C.jsp"); 
			dispatcher.forward(request, response);
			
		}else if (flag.equals("shengchanD")) {
			String num = request.getParameter("num") == null ? "" : request.getParameter("num").trim();
			String matnr = request.getParameter("matnr") == null ? "" : request.getParameter("matnr").trim();
			System.out.println("***领料单领取数量：num："+num);
			HttpSession session = request.getSession();
			String message = null;
			if (!num.equals("")) {
				session.setAttribute("num", num);
				message = "转储单创建成功！";
			}else {
				session.invalidate();
				message = "转储单创建失败！";
			}
			request.getSession().setAttribute("matnr", matnr);
			request.getSession().setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/lingliaodan_D.jsp"); 
			dispatcher.forward(request, response);
			
		}
		/*生产领料单*/
		/***发货***/
		/***仓库作业***/
		//仓位冻结
		else if (flag.equals("cangwei")) {
			String radioValue = request.getParameter("radioValue") == null ? "" : request.getParameter("radioValue").trim();//操作类型
			String nlpla	  = request.getParameter("nlpla") 	   == null ? "" : request.getParameter("nlpla").trim();//仓位号
			System.out.println("***仓位冻结："+nlpla+"**操作类型："+radioValue);
			request.getSession().setAttribute("nlpla", nlpla);
			if (radioValue.equals("1")||radioValue.equals("2")) {
				request.getSession().setAttribute("radioValue", radioValue);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/cangku_info.jsp"); 
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/cangku_list.jsp"); 
				dispatcher.forward(request, response);
			}
		}
		else if (flag.equals("cangkucaozuo")) {
			String radioValue = request.getParameter("radioValue") == null ? "" : request.getParameter("radioValue").trim();//操作类型
			System.out.println("*******仓位冻结解冻radioValue="+radioValue);
			String message = null;
			if (radioValue.equals("1")) {//仓位冻结
				message = "仓位冻结成功！";
			}
			if (radioValue.equals("2")) {//仓位解冻
				message = "仓位解冻成功！";
			}
			request.getSession().setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/cangku_msg.jsp"); 
			dispatcher.forward(request, response);
		}
		//仓位冻结
		//仓库转移
		else if (flag.equals("storageInfo")) {
			String literaNO = request.getParameter("literaNO");
			request.getSession().setAttribute("literaNO", literaNO);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/storage_info.jsp"); 
			dispatcher.forward(request, response);
			
		}
		else if (flag.equals("storageTo")) {
			String literaNO = request.getParameter("literaNO");
			String num = request.getParameter("num");
			request.getSession().setAttribute("literaNO", literaNO);
			request.getSession().setAttribute("num", num);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/storage_obj.jsp"); 
			dispatcher.forward(request, response);
		}
		else if (flag.equals("storageMsg")) {
			String message = "仓位转移操作成功！";
			request.getSession().setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/storage_msg.jsp"); 
			dispatcher.forward(request, response);
		}
		//仓库转移
		//仓库转储
		else if (flag.equals("zhuanchu")) {
			String matnr = request.getParameter("matnr") == null ? "" : request.getParameter("matnr").trim();//物料编码
			String maktx = request.getParameter("maktx") == null ? "" : request.getParameter("maktx").trim();//物料描述
			String batchNo = request.getParameter("batchNo") == null ? "" : request.getParameter("batchNo").trim();//批次
			request.getSession().setAttribute("matnr", matnr);
			request.getSession().setAttribute("maktx", maktx);
			request.getSession().setAttribute("batchNo", batchNo);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/zhuanchu_info.jsp"); 
			dispatcher.forward(request, response);
		}else if (flag.equals("zhuanchuMsg")) {
			String matnr = request.getParameter("matnr") == null ? "" : request.getParameter("matnr").trim();
			String batchNo = request.getParameter("batchNo") == null ? "" : request.getParameter("batchNo").trim();
			String message = "仓位转储成功！";
			request.getSession().setAttribute("matnr", matnr);
			request.getSession().setAttribute("batchNo", batchNo);
			request.getSession().setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/zhuanchu_msg.jsp"); 
			dispatcher.forward(request, response);
		}
		//仓库转储
		/*记账变更*/
		else if(flag.equals("jzbgMsg")){
			String message = null;
			String num = request.getParameter("num") == null ? "" : request.getParameter("num").trim();
			String batchNo = request.getParameter("batchNo") == null ? "" : request.getParameter("batchNo").trim();
			String matnr1 = request.getParameter("matnr1") == null ? "" : request.getParameter("matnr1").trim();
			if (!num.equals("")) {
				message = "记账变更成功！";
			}else {
				message = "记账变更失败！";
			}
			request.getSession().setAttribute("message", message);
			request.getSession().setAttribute("batchNo", batchNo);
			request.getSession().setAttribute("matnr1", matnr1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/bizinfo/jizhangbiangeng_msg.jsp"); 
			dispatcher.forward(request, response);
		}
		/*记账变更*/
		/***仓库作业***/
		
		
		/*退出，返回-首页,修改密码*/
		else if(flag.equals("exit")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp"); 
			dispatcher.forward(request, response); 
		}
		else if(flag.equals("return")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp"); 
			dispatcher.forward(request, response); 
		}
		else if(flag.equals("useredit")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/user/useredit.jsp"); 
			dispatcher.forward(request, response); 
		}
	}
	public void init() throws ServletException {
	}
}
