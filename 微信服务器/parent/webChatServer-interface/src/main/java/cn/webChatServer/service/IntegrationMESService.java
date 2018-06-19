package cn.webChatServer.service;

import cn.webChatServer.mes.pojo.FlowCard;
import cn.webChatServer.mes.pojo.MyOutput;
import cn.webChatServer.mes.pojo.MyOutputIntoParms;

/**
 * mes系统集成服务
 * @author qianyang
 * @since 2018-06-06
 * @version V1.1
 */
public interface IntegrationMESService {
	/**
	 * 查询产量
	 * @param intoParms 传入参数
	 * @return 
	 */
	public abstract MyOutput findMyOut(MyOutputIntoParms intoParms);
	/**
	 * 查询流转卡信息
	 * @param flowCardNo 流转卡号
	 * @return
	 */
	public abstract FlowCard findFlowCard(String flowCardNo);
}
