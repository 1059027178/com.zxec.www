
<!-- #section:basics/sidebar -->
<div id="sidebar" class="sidebar                  responsive">
	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'fixed')
		} catch (e) {
		}
	</script>


	<!-- /.sidebar-shortcuts -->



	<ul class="nav nav-list">
		<li><a href="admin!index.action"> <i
				class="menu-icon fa fa-tachometer"></i> <span class="menu-text">
					首页 </span>
		</a> <b class="arrow"></b></li>
		<li class=""><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa fa-cog"></i> <span class="menu-text">
					系统管理 </span> <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>

			<ul class="submenu">
			<li class=""><a href="system_config!edit.action"> <i
						class="menu-icon fa fa-caret-right"></i> 系统设置
				</a> <b class="arrow"></b></li>

				<li class=""><a href="admin!list.action"> <i
						class="menu-icon"></i> 用户管理
				</a> <b class="arrow"></b></li>
				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-caret-right"></i> 权限管理 <b
						class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a href="role!list.action"> <i
								class="menu-icon fa fa-caret-right"></i> 角色管理
						</a> <b class="arrow"></b></li>

						<li class=""><a href="resource!list.action"> <i
								class="menu-icon fa fa-caret-right"></i> 访问路径授权
						</a> <b class="arrow"></b></li>

						<!--  	<li class="">
								<a href="access_object!list.action" >
									<i class="menu-icon fa fa-caret-right"></i>
									权限对象
								</a>

								<b class="arrow"></b>
							</li>
							<li class="">
								<a href="access_resource!list.action" >
									<i class="menu-icon fa fa-caret-right"></i>
									权限资源设置
								</a>

								<b class="arrow"></b>
							</li>
							-->
					</ul></li>


				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-caret-right"></i> 日志管理 <b
						class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a href="log!list.action"> <i
								class="menu-icon"></i> 日志列表
						</a> <b class="arrow"></b></li>

						<li class=""><a href="log_config!list.action"> <i
								class="menu-icon"></i> 日志设置 <b class="arrow fa"></b>
						</a> <b class="arrow"></b></li>



					</ul></li>





			</ul></li>
		<!-- <li class=""><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa fa-tag"></i> 开发工具 <b
				class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>

			<ul class="submenu">
				<li class=""><a href="dict!list.action"> <i
						class="menu-icon fa fa-caret-right"></i> 数据字典管理
				</a> <b class="arrow"></b></li>

				<li class="">
						<a href="area!list.action" >
							<i class="menu-icon fa fa-caret-right"></i>
							常用地区
							<b class="arrow fa"></b>
						</a>

						<b class="arrow"></b>

						
					</li>
					
					<li class="">
						<a href="#">
							<i class="menu-icon fa fa-caret-right"></i>
							定时同步管理
						</a>

						<b class="arrow"></b>
					</li>

					<li class="">
						<a href="#l">
							<i class="menu-icon fa fa-caret-right"></i>
							SAP RFC函数配置
						</a>

						<b class="arrow"></b>
					</li>
					
		

			</ul></li>			-->

	</ul>
	<!-- /.nav-list -->

	<!-- #section:basics/sidebar.layout.minimize -->
	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>

	<!-- /section:basics/sidebar.layout.minimize -->
	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'collapsed')
		} catch (e) {
		}
	</script>
</div>

<!-- /section:basics/sidebar -->