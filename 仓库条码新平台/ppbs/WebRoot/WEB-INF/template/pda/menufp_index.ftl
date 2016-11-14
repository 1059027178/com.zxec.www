<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>成品仓库管理系统</title>
<link href="${base}/template/pda/css/jiuhui.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<table class="table_border">
		<tr>
			<td align="center">用户名:${SPRING_SECURITY_CONTEXT.authentication.principal.name}</td>
		</tr>
		<tr>
			<td align="center">部门:${SPRING_SECURITY_CONTEXT.authentication.principal.department}</td>
		</tr>
		<tr>
			<td><input type="button"
				onclick="window.location.href='menu!inbound.action';" value="1.入库业务">
			</td>
		</tr>
		<tr>
			<td><input type="button"
				onclick="window.location.href='menu!outbound.action';"
				value="2.出库业务"></td>
		</tr>
		<tr>
			<td><input type="button"
				onclick="window.location.href='menu!internalJob.action';"
				value="3.内部作业"></td>
		</tr>
		<tr>
			<td><input type="button"
				onclick="window.location.href='stock_transfer!menu.action';"
				value="4.生产装配"></td>
		</tr>
		<tr>
			<td><input type="button"
				onclick="window.location.href='menu!query.action';" value="5.查询"></td>
		</tr>
		<tr>
			<td class="two_menu"><input type="button"
				onclick="window.location.href='/admin/logout';" value="7.退出系统">
				<input type="button" class="menu_half"
				onclick="window.location.href='admin!updatePassword.action?id=${SPRING_SECURITY_CONTEXT.authentication.principal.id}';"
				value="8.修改密码"></td>
		</tr>
	</table>
</body>
</html>
