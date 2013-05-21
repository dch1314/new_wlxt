<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"
	import="org.thcic.xapx.Constants"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<title>军事装备管理系统</title>
	<link href="/res/styles/common.css" rel="stylesheet" type="text/css" />
	<link href="/res/styles/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
				<form id="loginForm"
					action="<c:url value='/j_spring_security_check' />" method='POST'>
	<div id="login">
		<div class="login_c">
			<div class="login_box">
				<div class="login_inner">
					<h1>军事装备管理系统</h1>
					<div class="login_wrap">
						<table width="80%">
							<tr height="40">
								<td width="20%"><span class="login_txt">用户名</span></td>
								<td><input type="text" name="j_username"  class="login_input" /></td>
							</tr>
							<tr height="40">
								<td><span class="login_txt">密&nbsp;&nbsp;&nbsp;&nbsp;码</span></td>
								<td><input type="password" name="j_password" class="login_input" /></td>
							</tr>
							<tr height="40">
								<td></td>
								<td>
									<table>
										<tr>
											<td>
												<input type="submit" value="登录" class="login_btn" />
												<input type="reset" class="login_btn" />
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<img src="/res/images/star_19.png" alt="" class="star" />
					</div>
				</div>
				<div class="decoration"></div>
			</div>
		</div>
	</div>
</form>
</body>
</html>
