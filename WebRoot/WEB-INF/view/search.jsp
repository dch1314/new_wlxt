<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"
	import="org.thcic.xapx.Constants"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
<form action="/u/equipment/search" id="queryForm">
	<div id="wrap">
	
		<div id="head">
			<div class="head_c">
				<a class="left" href="#" alt="军事管理系统"><img src="/res/images/head_logo_03.gif"/></a>
				<ul class="nav">
					<li><a href="/u/equipment">装备管理</a></li>
					<li><a href="/u/equipment/search"  class="active">装备查询</a></li>
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
					<h1>装备查询</h1>
					<a href="#" class="onActive">分类查询</a>
				</div>
				<div class="right_c">
					<div class="addBox">
						<h3>装备查询</h3>
						<table width="80%">
							<tr height="40">
								<td class="add_font" width="15%" align="center">编号</td>
								<td><input type="text" class="add_text" name="eqId" value="${exmaple.eqId}" /></td>
								<td class="add_font" width="15%" align="center">型号</td>
								<td><input type="text" class="add_text"  name="model" value="${exmaple.model}"  /></td>
							</tr>
							<tr height="40">
								<td colspan="2">
									<table width="100%">
										<tr>
											<td class="add_font" width="25%"  align="center">类型</td>
											<td>
									<select name="codeEqType.code" id="codeEqType">
									
									<option value="">-请选择-</option>
										<option value="01">飞行器</option>
										<option value="02">舰艇</option>
										<option value="03">导弹</option>
									</select>
											</td>
											<td class="add_font"  align="center">状态</td>
											<td>
												<select  name="codeEqStatus.code" id="codeEqStatus">
							    <option value="">-请选择-</option>
										<option value="01">正常</option>
										<option value="02">失效</option>
												</select>
											</td>
										</tr>
									</table>
								</td>
								<td class="add_font" align="center">责任人</td>
								<td><input type="text" class="add_text"  name="personResp" value="${exmaple.personResp}" /></td>
							</tr>
							<tr height="50">
								<td></td>
								<td colspan="3"><input type="submit" class="confirmSubmit searchSubmit" value="提交查询" /></td>
							</tr>
						</table>
					</div>
					<div class="searchResult">
						<h3>根据您的数据搜索到了<span class="highlight">
						<c:out value="${fn:length(data)}"/>
						</span>条数据，结果如下：</h3>
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
										<a href="/u/equipment/beforeEdit?eqSeq=${equipment.eqSeq}" class="editData">编辑</a><a href="/u/equipment/delete?eqSeq=${equipment.eqSeq}" class="delData  delete">删除</a>
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
</form>
 <script>
$("#codeEqType").change(function(){
	if($("#codeEqType").val() != ''){
		$("#queryForm").submit();
	}
  
});
$("#codeEqType").val('${exmaple.codeEqType.code}');

$("#codeEqStatus").change(function(){
	if($("#codeEqStatus").val() != ''){
		$("#queryForm").submit();
	}
  
});
$("#codeEqStatus").val('${exmaple.codeEqStatus.code}');

	$(".delete").click(function() {
		return confirm("您确认要删除吗?");
	});
</script>
</body>
</html>
