/*
 * JSP generated by Resin-3.0.28 (built Mon, 18 May 2009 02:16:38 PDT)
 */

package _jsp._web_22dinf._view;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import org.thcic.xapx.Constants;

public class _edit__jsp extends com.caucho.jsp.JavaPage{
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.Application _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = com.caucho.jsp.QJspFactory.allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      _caucho_expr_0.print(out, pageContext, false);
      out.write(_jsp_string1, 0, _jsp_string1.length);
      _caucho_expr_1.print(out, pageContext, false);
      out.write(_jsp_string2, 0, _jsp_string2.length);
      _caucho_expr_2.print(out, pageContext, false);
      out.write(_jsp_string3, 0, _jsp_string3.length);
      _caucho_expr_3.print(out, pageContext, false);
      out.write(_jsp_string4, 0, _jsp_string4.length);
      _caucho_expr_4.print(out, pageContext, false);
      out.write(_jsp_string5, 0, _jsp_string5.length);
      _caucho_expr_5.print(out, pageContext, false);
      out.write(_jsp_string6, 0, _jsp_string6.length);
      _caucho_expr_6.print(out, pageContext, false);
      out.write(_jsp_string7, 0, _jsp_string7.length);
      _caucho_expr_7.print(out, pageContext, false);
      out.write(_jsp_string8, 0, _jsp_string8.length);
      _caucho_expr_7.print(out, pageContext, false);
      out.write(_jsp_string9, 0, _jsp_string9.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      com.caucho.jsp.QJspFactory.freePageContext(pageContext);
    }
  }

  private java.util.ArrayList _caucho_depends = new java.util.ArrayList();

  public java.util.ArrayList _caucho_getDependList()
  {
    return _caucho_depends;
  }

  public void _caucho_addDepend(com.caucho.make.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;
    if (com.caucho.util.CauchoSystem.getVersionId() != -4644494061398360982L)
      return true;
    for (int i = _caucho_depends.size() - 1; i >= 0; i--) {
      com.caucho.make.Dependency depend;
      depend = (com.caucho.make.Dependency) _caucho_depends.get(i);
      if (depend.isModified())
        return true;
    }
    return false;
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("WEB-INF/view/edit.jsp"), -852328891530309749L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }
  private final static com.caucho.el.Expr _caucho_expr_0 =
    new com.caucho.el.PathExpr(new com.caucho.el.ArrayExpr(new com.caucho.el.ArrayExpr(new com.caucho.el.ArrayExpr(new com.caucho.el.IdExpr("SPRING_SECURITY_CONTEXT"), new com.caucho.el.StringLiteral("authentication")), new com.caucho.el.StringLiteral("principal")), new com.caucho.el.StringLiteral("username")), "SPRING_SECURITY_CONTEXT.authentication.principal.username");
  private final static com.caucho.el.Expr _caucho_expr_1 =
    new com.caucho.el.PathExpr(new com.caucho.el.ArrayExpr(new com.caucho.el.IdExpr("data"), new com.caucho.el.StringLiteral("eqId")), "data.eqId");
  private final static com.caucho.el.Expr _caucho_expr_2 =
    new com.caucho.el.PathExpr(new com.caucho.el.ArrayExpr(new com.caucho.el.IdExpr("data"), new com.caucho.el.StringLiteral("eqSeq")), "data.eqSeq");
  private final static com.caucho.el.Expr _caucho_expr_3 =
    new com.caucho.el.PathExpr(new com.caucho.el.ArrayExpr(new com.caucho.el.IdExpr("data"), new com.caucho.el.StringLiteral("model")), "data.model");
  private final static com.caucho.el.Expr _caucho_expr_4 =
    new com.caucho.el.PathExpr(new com.caucho.el.ArrayExpr(new com.caucho.el.IdExpr("data"), new com.caucho.el.StringLiteral("quantity")), "data.quantity");
  private final static com.caucho.el.Expr _caucho_expr_5 =
    new com.caucho.el.PathExpr(new com.caucho.el.ArrayExpr(new com.caucho.el.IdExpr("data"), new com.caucho.el.StringLiteral("weight")), "data.weight");
  private final static com.caucho.el.Expr _caucho_expr_6 =
    new com.caucho.el.PathExpr(new com.caucho.el.ArrayExpr(new com.caucho.el.IdExpr("data"), new com.caucho.el.StringLiteral("personResp")), "data.personResp");
  private final static com.caucho.el.Expr _caucho_expr_7 =
    new com.caucho.el.PathExpr(new com.caucho.el.ArrayExpr(new com.caucho.el.ArrayExpr(new com.caucho.el.IdExpr("data"), new com.caucho.el.StringLiteral("codeEqStatus")), new com.caucho.el.StringLiteral("code")), "data.codeEqStatus.code");

  private final static char []_jsp_string3;
  private final static char []_jsp_string5;
  private final static char []_jsp_string1;
  private final static char []_jsp_string4;
  private final static char []_jsp_string7;
  private final static char []_jsp_string0;
  private final static char []_jsp_string9;
  private final static char []_jsp_string2;
  private final static char []_jsp_string6;
  private final static char []_jsp_string8;
  static {
    _jsp_string3 = "\" />\r\n								</td>\r\n							</tr>\r\n							<tr height=\"40\">\r\n								<td class=\"add_font\"  align=\"center\">\u578b\u53f7</td>\r\n								<td><input type=\"text\" class=\"add_text required\" name=\"model\"  value=\"".toCharArray();
    _jsp_string5 = "\" /></td>\r\n							</tr>\r\n							<tr height=\"40\">\r\n								<td class=\"add_font\" align=\"center\">\u8d28\u91cf</td>\r\n								<td><input type=\"text\" class=\"add_text number\" name=\"weight\"   value=\"".toCharArray();
    _jsp_string1 = "\r\n</a></li>\r\n					<li><a href=\"#\">\u8d26\u6237</a></li>\r\n					<li><a href=\"/login\">\u9000\u51fa</a></li>\r\n				</ul>\r\n			</div>\r\n		</div>\r\n		\r\n		<div id=\"content\">\r\n			<div class=\"content_c\">\r\n				<div class=\"left_c\">\r\n					<h1>\u88c5\u5907\u7ba1\u7406</h1>\r\n					<a href=\"#\" class=\"onActive\">\u4fee\u6539\u88c5\u5907\u4fe1\u606f</a>\r\n				</div>\r\n				<div class=\"right_c\">\r\n					<div class=\"addBox\">\r\n						<h3>\u4fee\u6539\u88c5\u5907\u4fe1\u606f</h3>\r\n						<table width=\"60%\">\r\n							<tr height=\"40\">\r\n								<td class=\"add_font\" width=\"15%\" align=\"center\">\u7f16\u53f7</td>\r\n								<td><input type=\"text\" class=\"add_text required\" name=\"eqId\" value=\"".toCharArray();
    _jsp_string4 = "\" /></td>\r\n							</tr>\r\n							<tr height=\"40\">\r\n								<td class=\"add_font\" align=\"center\" >\u7c7b\u578b</td>\r\n								<td>\r\n									<select name=\"codeEqType.code\" id=\"codeEqType\" class=\"\">\r\n									\r\n									<option value=\"\">-\u8bf7\u9009\u62e9-</option>\r\n										<option value=\"01\">\u98de\u884c\u5668</option>\r\n										<option value=\"02\">\u8230\u8247</option>\r\n										<option value=\"03\">\u5bfc\u5f39</option>\r\n									</select>\r\n								</td>\r\n							</tr>\r\n							<tr height=\"40\">\r\n								<td class=\"add_font\" align=\"center\" >\u6570\u91cf</td>\r\n								<td><input type=\"text\" class=\"add_text number\"  name=\"quantity\"  value=\"".toCharArray();
    _jsp_string7 = "\"/></td>\r\n							</tr>\r\n							<tr>\r\n								<td></td>\r\n								<td><input type=\"submit\" class=\"confirmSubmit\" value=\"\u786e\u8ba4\u63d0\u4ea4\" /></td>\r\n							</tr>\r\n						</table>\r\n					</div>\r\n				</div>\r\n				<div class=\"clear\"></div>\r\n			</div>\r\n		</div>\r\n		\r\n		<div id=\"footer\">\r\n			<div class=\"footer_c\"><span class=\"right\">Copyright \u00a9 2013 \u519b\u4e8b\u88c5\u5907\u7ba1\u7406\u7cfb\u7edf\u00a9 \u6e05\u534e\u5927\u5b66\u4fe1\u606f\u5316\u6280\u672f\u4e2d\u5fc3</span></div>\r\n		</div>\r\n	</div>\r\n</form>\r\n<script>\r\n	$(\"#form\").validate();\r\n$(\"#codeEqType\").val(\"".toCharArray();
    _jsp_string0 = "\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\">\r\n<head>\r\n	<meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\" />\r\n	<title>\u519b\u4e8b\u88c5\u5907\u7ba1\u7406\u7cfb\u7edf</title>\r\n	<link href=\"/res/styles/common.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n	<link href=\"/res/styles/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n<script type=\"text/javascript\" src=\"/res/scripts/jquery-1.7.2.min.js\"></script>\r\n<script type=\"text/javascript\" src=\"/res/scripts/jquery.validate.js\"></script>\r\n<script type=\"text/javascript\" src=\"/res/scripts/messages_cn.js\"></script>\r\n\r\n</head>\r\n<body>\r\n<form action=\"/u/equipment/saveEdit\" method=\"post\" id=\"form\">\r\n	<div id=\"wrap\">\r\n	\r\n		<div id=\"head\">\r\n			<div class=\"head_c\">\r\n				<a class=\"left\" href=\"#\" alt=\"\u519b\u4e8b\u7ba1\u7406\u7cfb\u7edf\"><img src=\"/res/images/head_logo_03.gif\"/></a>\r\n				<ul class=\"nav\">\r\n					<li><a href=\"/u/equipment\" class=\"active\">\u88c5\u5907\u7ba1\u7406</a></li>\r\n					<li><a href=\"/u/equipment/search\">\u88c5\u5907\u67e5\u8be2</a></li>\r\n				</ul>\r\n				<ul class=\"settings\">\r\n					<li><a href=\"#\">\r\n".toCharArray();
    _jsp_string9 = "\");\r\n</script>\r\n\r\n</body>\r\n</html>".toCharArray();
    _jsp_string2 = "\" />\r\n								<input type=\"hidden\"  name=\"eqSeq\" value=\"".toCharArray();
    _jsp_string6 = "\" /></td>\r\n							</tr>\r\n							<tr height=\"40\">\r\n								<td class=\"add_font\" align=\"center\">\u72b6\u6001</td>\r\n								<td>\r\n									<select name=\"codeEqStatus.code\" id=\"codeEqStatus\" class=\"\">\r\n									    <option value=\"\">-\u8bf7\u9009\u62e9-</option>\r\n										<option value=\"01\">\u6b63\u5e38</option>\r\n										<option value=\"02\">\u5931\u6548</option>\r\n									</select>\r\n								</td>\r\n							</tr>\r\n							<tr height=\"40\">\r\n								<td class=\"add_font\" align=\"center\">\u8d23\u4efb\u4eba</td>\r\n								<td><input type=\"text\" name=\"personResp\" class=\"add_text \"  value=\"".toCharArray();
    _jsp_string8 = "\");\r\n$(\"#codeEqStatus\").val(\"".toCharArray();
  }
}
