package org.apache.jsp.statistics.showgrid;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class allGrid_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head lang=\"en\">\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("<title>网格基本情况</title>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        function initEvent() {\r\n");
      out.write("            var tableCol = document.getElementById(\"tableColor\");\r\n");
      out.write("            var trs = tableCol.getElementsByTagName(\"tr\");\r\n");
      out.write("            for (var i = 1; i <= trs.length; i++) {\r\n");
      out.write("                var tr = trs[i];\r\n");
      out.write("                if (i % 2 == 0) {\r\n");
      out.write("                    tr.style.background = \"#d3d3d3\";\r\n");
      out.write("                }\r\n");
      out.write("                else {\r\n");
      out.write("                    tr.style.background = \"white\";\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("\t\tbody{\r\n");
      out.write("            font-family: 宋体;\r\n");
      out.write("        }\r\n");
      out.write("         table  thead{\r\n");
      out.write("            color: #f8f8f8;\r\n");
      out.write("            background-color: rgba(51, 122, 183, 1);\r\n");
      out.write("            font-family:宋体;\r\n");
      out.write("            font-size:18px;\r\n");
      out.write("        }\r\n");
      out.write("        table tr {\r\n");
      out.write("            font-family:宋体;\r\n");
      out.write("            font-size:18px;\r\n");
      out.write("        }\r\n");
      out.write("        th,td {\r\n");
      out.write("        \ttext-align:center;\r\n");
      out.write("        }\r\n");
      out.write("        h2 {\r\n");
      out.write("            color: #5E5E5E;\r\n");
      out.write("            text-align:center\r\n");
      out.write("        }\r\n");
      out.write("        a:link{\r\n");
      out.write("            color: darkblue;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            font-family:宋体;\r\n");
      out.write("            font-size:18px;\r\n");
      out.write("        }\r\n");
      out.write("        a:visited{\r\n");
      out.write("            color: darkblue;\r\n");
      out.write("        }\r\n");
      out.write("        a:hover{\r\n");
      out.write("            color: #49FF1C;\r\n");
      out.write("        }\r\n");
      out.write("        a:active{\r\n");
      out.write("            color: goldenrod;\r\n");
      out.write("        }\r\n");
      out.write("    \t#clude {\r\n");
      out.write("            vertical-align: middle; \r\n");
      out.write("    \t}\r\n");
      out.write("    \t#clude table {\r\n");
      out.write("    \t\tmargin-left: auto; \r\n");
      out.write("\t\t\tmargin-right: auto; \r\n");
      out.write("    \t}\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"initEvent()\">\r\n");
      out.write("\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/statistics/main.jsp\">返回</a>\r\n");
      out.write("\t<h1 align=\"center\">网格基本情况</h1>\r\n");
      out.write("    <table id=\"tableColor\"  cellpadding=\"10\" cellspacing=\"0\" border=2px align=\"center\">\r\n");
      out.write("    \t<thead>\r\n");
      out.write("    \t\t<th>序号</th>\r\n");
      out.write("        \t<th>所属域区</th>\r\n");
      out.write("            <th>所属社区</th>\r\n");
      out.write("            <th>所在网格</th>\r\n");
      out.write("            <th>网格管理员</th>\r\n");
      out.write("            <th>所管辖的范围</th>\r\n");
      out.write("            <th>手机号码</th>\r\n");
      out.write("        </thead>\r\n");
      out.write("        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    </table>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${grids}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("c");
    _jspx_th_c_forEach_0.setVarStatus("vs");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("    \t<tr>\r\n");
          out.write("    \t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vs.index+1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.ssyq}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("        \t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.sssq}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.szwg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.wgyxm}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.fw}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("        </tr>\r\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
