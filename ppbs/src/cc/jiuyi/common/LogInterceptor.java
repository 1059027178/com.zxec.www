package cc.jiuyi.common;

import java.util.List;

import javax.annotation.Resource;

import cc.jiuyi.action.admin.BaseAdminAction;
import cc.jiuyi.entity.Log;
import cc.jiuyi.entity.LogConfig;
import cc.jiuyi.service.AdminService;
import cc.jiuyi.service.LogConfigService;
import cc.jiuyi.service.LogService;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 拦截器 - 管理日志
 */

public class LogInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 276741467699160227L;
	
	//public static final String[] excludeActionClassNames = new String[] {"cc.jiuyi.action.admin.InstallAction"};// 需要排除的Action类名称
	public static final String[] excludeActionClassNames = new String[] {""};// 需要排除的Action类名称
	public static final String[] excludeActionMethodNames = new String[] {};// 需要排除的Action方法名称

	@Resource
	private LogService logService;
	@Resource
	private AdminService adminService;
	@Resource
	private LogConfigService logConfigService;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		invocation.invoke();
		String actionClassName = invocation.getAction().getClass().getName();
		String actionMethodName = invocation.getProxy().getMethod();
		if (ArrayUtils.contains(excludeActionClassNames, actionClassName)) {
			return null;
		}
		if (ArrayUtils.contains(excludeActionMethodNames, actionMethodName)) {
			return null;
		}
		List<LogConfig> allLogConfig = logConfigService.getAll();
		if (allLogConfig != null) {
			for (LogConfig logConfig : allLogConfig) {
				if (StringUtils.equals(logConfig.getActionClassName(), actionClassName)
						&& StringUtils.equals(logConfig.getActionMethodName(), actionMethodName)) {
					BaseAdminAction baseAction = (BaseAdminAction) invocation.getAction();
					String logInfo = baseAction.getLogInfo();
					String operator = adminService.getLoginAdmin().getUsername();
					if(operator == null) {
						operator = "未知用户";
					}
					String ip = ServletActionContext.getRequest().getRemoteAddr();
					String operationName = logConfig.getOperationName();
					Log log = new Log();
					log.setOperationName(operationName);
					log.setActionClassName(actionClassName);
					log.setActionMethodName(actionMethodName);
					log.setOperator(operator);
					log.setIp(ip);
					log.setInfo(logInfo);
					logService.save(log);
					break;
				}
			}
		}
		return null;
	}

}