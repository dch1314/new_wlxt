<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"
	import="org.thcic.xapx.Constants"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>军事装备管理系统</title>
	<link href="/res/styles/common.css" rel="stylesheet" type="text/css" />
	<link href="/res/styles/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="/res/scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/res/scripts/function.js"></script>
</head>
<body>
<form action="/u/equipment/" id="queryForm">
	<div id="wrap">
	
		<div id="head">
			<div class="head_c">
				<a class="left" href="#" alt="军事管理系统"><img src="/res/images/head_logo_03.gif"/></a>
				<ul class="nav">
					<li><a href="/u/equipment" class="active">装备管理</a></li>
					<li><a href="/u/equipment/search">装备查询</a></li>
				</ul>
				<ul class="settings">
					<li><a href="#">
<c:out value="${SPRING_SECURITY_CONTEXT.authentication.principal.username}" escapeXml="false"/>
</a></li>
					<li><a href="#">账户</a></li>
					<li><a href="/login">退出</a></li>
				</ul>
			</div>
		</div>
		
		<div id="content">
			<div class="content_c">
				<div class="left_c">
					<h1>装备管理</h1>
					<a href="/u/equipment/beforeAdd">新增装备</a>
				</div>
				<div class="right_c">
					<div class="sortable">
						<div class="sortable_btn">
							<!--  
							<span class="left">排序：</span>
							<a href="#" class="activeBtn">默认</a>
							<a href="http://166.111.4.89:21219/u/equipment">录入时间</a>
							<a href="#">编辑时间</a>
							
							<span class="">按装备类型：</span>
									<select name="codeEqType.code" id="codeEqType">
									
									<option value="">-请选择-</option>
										<option value="01">飞行器</option>
										<option value="02">舰艇</option>
										<option value="03">导弹</option>
									</select>
									-->

						</div>
						<!-- 
						<a href="#" class="delbtn">删除</a>
						 -->
						<div class="clear"></div>
					</div>
					<div class="dataList">
						<ul class="data">

			
			<c:forEach items="${data}" var="equipment" varStatus="status">
							<li>
								<div class="dataBox">
								<!-- 
									<img src="/res/images/data_img_06.png" alt="" width="220" height="148" />
								-->
									<p>编号：${equipment.eqId}</p>
									<p>型号：${equipment.model}</p>
									<p><span class="right_blank10">质量：${equipment.weight}</span><span>数量：${equipment.quantity}</span></p>
<p><span class="right_blank10">类型：${equipment.codeEqType.name}</span><span>状态：${equipment.codeEqStatus.name}</span></p>
									<p><span class="right_blank10">责任人：${equipment.personResp}</span><span>操作：
										<a href="/u/equipment/beforeEdit?eqSeq=${equipment.eqSeq}" class="editData">编辑</a><a href="/u/equipment/delete?eqSeq=${equipment.eqSeq}" class="delData delete">删除</a>
									</span></p>
								</div>
								<div class="status"></div>
							</li>
			</c:forEach>


						</ul>

					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		
		<div id="footer">
			<div class="footer_c"><span class="right">Copyright © 2013 军事装备管理系统© 清华大学信息化技术中心</span></div>
		</div>
	</div>
<script>
	$(".delete").click(function() {
		return confirm("您确认要删除吗?");
	});

</script>

 </form>
</body>
</html>
