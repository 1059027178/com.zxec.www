<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

     
		  <!--.我的资料-->
		     <div class="row-fluid" style="margin-bottom: 9px;">
			    <div class="span1">
				<a href="#" class="thumbnail"><img src="/img/T.png" alt=""></a>
				</div>
    			<div class="span10">
				<p>
				<a href="#">Welson Dou</a>
				<span style="padding-left:10px;">因为活着，所以道不出滋味</span>
				<span style="padding-left:10px;color:#666">17分钟前</span>
				<a style="padding-left:10px;" href="#">清除</a>
				</p>
				<p><a>星期三 2012年3月28日</a></p>
				</div>
			 </div>	
		  <!--/.我的资料-->
		  
		  <!--.当前位置导航-->
		  
		  <div class="row-fluid">
		     <ul class="breadcrumb">
			  <li>
				当前位置：<span><i class="icon-home"></i> 首页</span> 
			  </li>
			</ul>
		  </div>	
		  
		  <!--/.当前位置导航-->	
		  
		  <!--.Chatter-header-->
		  <div class="row-fluid">
			  <div class="tabbable">
			  <ul class="nav nav-tabs">	
				  <li class="active"><a href="#chatter" class="badge badge-info" data-toggle="tab"><i class="icon-pencil"> </i> Chatter</a>
				  </li>			   
			  </ul>
			  </div>
		  </div>
		  <!--/.Chatter-header-->
		 <!--.Chatter-content-->
		  <div class="row-fluid">
			  <div class="tab-content">
				<div class="tab-pane active" id="chatter">
				
				<div class="container-fluid">
				<div class="row-fluid">
				
				<div class="span9">
				<!--chatter form-->	
				<div class="row-fluid">
				<form class="form-horizontal">
				  <div class="alert alert-block" style="padding:5px;">
				  
				 <a rel="popover" id="helpchatter" class="badge badge-warning"  data-content="@ 以通知同事您的帖子。<br> # 以添加主题到您的帖子。<br> <strong>例如：</strong><br> 在新的 #Smart SRM 上使用 @wilson”。 
" rel="popover" href="#" data-original-title="尝试输入以下字符来完成">i</a>
<span style="padding-left:10px;"> 字符：@ 以通知同事您的帖子。 # 以添加主题到您的帖子。</span>
                  </div>

				 <textarea id="textarea" class="input" style="width:98%" rows="2"></textarea>
				<a class="btn btn-primary pull-right" style="margin-top:8px;" href="#"><i class="icon-white icon-pencil"> </i> 发表我的看法</a>
				 <p style="line-height:35px;">
				  <Strong>附加：</Strong>
				 <span style="margin-left:10px;"><i class="icon-picture"> </i> <a href="#">文件</a></span>
				 <span style="margin-left:10px;"><i class="icon-bookmark"> </i> <a href="#">链接</a></span>
				 
				 </p>
				 </form>
				 </div>
				 <!--/.chatter form-->
				 
				 <!--.chatterOrderType-->
				 <div class="row-fluid" >
				   <ul class="nav nav-pills pull-right"> 
				   <li><a style="color:#222;">排序方式：</a></li>
				   <li class="dropdown" id="menuOrder">
					   <a href="#menuOrder" class="dropdown-toggle" data-toggle="dropdown">张贴日期
						   <b class="caret"></b>
					   </a>
					   <ul class="dropdown-menu">
							<li><a href="#">
							<i class="icon-user"> </i>
							张贴日期</a> </li>
							<li><a href="#">
							<i class="icon-cog"> </i>
							回复日期</a></li>
					   </ul>
					</li>
				   </ul>
				   </div>
				 <!--/.chatterOrderType-->	
				 
			<hr>	 
				 
            <!--.chatterlist1-->
			 <div class="container-fluid" style="padding:0pt;">	
			      <!--.chatterlist1-->		 
				 <div class="row-fluid">
						<div class="span1">
						<a href="#" class="thumbnail"><img src="/img/T.png" alt=""></a> 
						</div>   			
						<div class="span11" style="padding:0;">
						<a class="close">×</a>
						<p><a href="#">Welson Dou</a></p>
						<p>因为活着，所以道不出滋味</p>
						<p>
						<span style="pcolor:#777;">今天,下午17:10</span>
						<a style="padding:0px 5pt;" href="#">评论(1)</a>
						<a style="padding:0px 5pt;" href="#">赞扬</a>
						<a style="padding:0px 5pt;" href="#">转发</a>
						<a style="padding:0px 5pt;" href="#">收藏</a>
						</p>
						<p style="border-bottom:#eee 1px solid;border-top:#eee 1px solid;line-height:32px;">
						<i class="icon-gift"> </i> 您喜欢这个
						</p>
						</div>
				 </div>	
				 <!--/.chatterlist1-->	
				
			 </div>
			 <!--/.chatterlist1-->
			 
				 
				</div><!--/.span7-->
			  <div class="span3">
					
 				  <!--.推荐-->
				   <div class="alert alert-block">
					<a class="close" data-dismiss="alert">×</a>
					<h5 class="alert-heading">填写您的简档!</h5>
					<br>
					<p>告诉每个人有关您自己的状况并上载照片。</a></p>
					<p><a href="#">跳过 ></a></p>
					</div>
					
					<!--.推荐-->
					</div><!--/.span3-->
					
					</div><!--row-fluid-chatter-->
					</div><!--container-fluid-chatter-->
					 
				</div>
			  </div>
		  </div>
		  
		  <!--/.Chatter-content-->
		  
		  
		  
		   <!--.task-header-->
		  <div class="row-fluid">
			  <div class="tabbable">
			  <ul class="nav nav-tabs">	
				  <li class="active"><a href="#chatter" class="badge badge-info" data-toggle="tab"><i class="icon-time"> </i> 我的任务</a>
				  </li>			   
			  </ul>
			  </div>
		  </div>
		  
		  <!--/.task-header-->
		  <!--.task-content-->
		  <div class="row-fluid">
		    <table class="table table-striped table-bordered">
			<thead class="well">
				<th>完成</th>
				<th>日期</th>
				<th>主题</th>
				<th>名称</th>
				<th>相关项</th>
			</thead>
			<tbody>
			<tr>
				<td>X</td>
				<td>2012.03.24</td>
				<td>完成操作手册的编写</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>2012.04.24</td>
				<td>完成数据的导入</td>
				<td></td>
				<td></td>
			</tr>
			</tbody>
  
			</table>
		  </div>
		  <!--/.task-content-->