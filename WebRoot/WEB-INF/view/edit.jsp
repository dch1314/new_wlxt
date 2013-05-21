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
<script type="text/javascript" src="/res/scripts/jquery.validate.js"></script>
<script type="text/javascript" src="/res/scripts/messages_cn.js"></script>

</head>
<body>
<form action="/u/equipment/saveEdit" method="post" id="form">
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
					<a href="#" class="onActive">修改装备信息</a>
				</div>
				<div class="right_c">
					<div class="addBox">
						<h3>修改装备信息</h3>
						<table width="60%">
							<tr height="40">
								<td class="add_font" width="15%" align="center">编号</td>
								<td><input type="text" class="add_text required" name="eqId" value="${data.eqId}" />
								<input type="hidden"  name="eqSeq" value="${data.eqSeq}" />
								</td>
							</tr>
							<tr height="40">
								<td class="add_font"  align="center">型号</td>
								<td><input type="text" class="add_text required" name="model"  value="${data.model}" /></td>
							</tr>
							<tr height="40">
								<td class="add_font" align="center" >类型</td>
								<td>
									<select name="codeEqType.code" id="codeEqType" class="">
									
									<option value="">-请选择-</option>
										<option value="01">飞行器</option>
										<option value="02">舰艇</option>
										<option value="03">导弹</option>
									</select>
								</td>
							</tr>
							<tr height="40">
								<td class="add_font" align="center" >数量</td>
								<td><input type="text" class="add_text number"  name="quantity"  value="${data.quantity}" /></td>
							</tr>
							<tr height="40">
								<td class="add_font" align="center">质量</td>
								<td><input type="text" class="add_text number" name="weight"   value="${data.weight}" /></td>
							</tr>
							<tr height="40">
								<td class="add_font" align="center">状态</td>
								<td>
									<select name="codeEqStatus.code" id="codeEqStatus" class="">
									    <option value="">-请选择-</option>
										<option value="01">正常</option>
										<option value="02">失效</option>
									</select>
								</td>
							</tr>
							<tr height="40">
								<td class="add_font" align="center">责任人</td>
								<td><input type="text" name="personResp" class="add_text "  value="${data.personResp}"/></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" class="confirmSubmit" value="确认提交" /></td>
							</tr>
						</table>
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
	$("#form").validate();
$("#codeEqType").val("${data.codeEqStatus.code}");
$("#codeEqStatus").val("${data.codeEqStatus.code}");
</script>

</body>
</html>