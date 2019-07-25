<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.jx.aisino.web.priv.PrivTool"%>
<%@ page import="com.jx.aisino.web.priv.GNConstant"%>
<%@ page import="com.jx.aisino.model.TabGn"%>
<%
	String ser_path = request.getContextPath();
	String ser_basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ ser_path + "/";
%>
<%
	// 权限认证页面
	// 加密规则： 功能代码+权限代码+aisino+sessionid
	// 返回列表时 需将gnbh重新生 rzid重新生成
	/**
	   gnbh     左边菜单中的功能编号
	   qxcode   权限标记
	   checkid  关个页面Md5值   
	   rzid     本页面Md5值     
	   在页面中使用 Tools.Qxrz(yhid,dwid,ywdm,arg0,target)来调用
	 **/
	String yhid = PrivTool.dealNull((String)session.getAttribute("yhid"));	
	String qybm = PrivTool.dealNull((String)session.getAttribute("qybm"));	
	Map<Integer,TabGn> gnmap = (Map<Integer,TabGn>)session.getAttribute("gn");
    if(yhid.equals("")){
        %>
        <%-- <link rel="stylesheet" type="text/css" href="<%=ser_basePath%>js/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="<%=ser_basePath%>js/easyui/themes/icon.css">
		<script type="text/javascript" src="<%=ser_basePath%>js/easyui/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="<%=ser_basePath%>js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=ser_basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script> --%>
		<link rel="stylesheet" type="text/css" href="<%=ser_basePath%>js/easyui-1.5.5/themes/material/easyui-builder.css">
		<link rel="stylesheet" type="text/css" href="<%=ser_basePath%>js/easyui-1.5.5/themes/icon.css">
		<script type="text/javascript" src="<%=ser_basePath%>js/easyui-1.5.5/jquery.min.js"></script>
		<script type="text/javascript" src="<%=ser_basePath%>js/easyui-1.5.5/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="<%=ser_basePath%>js/easyui-1.5.5/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="<%=ser_basePath%>js/common.js"></script></br>
		<script language="JavaScript">
				parent.$.messager.alert('信息提示','系统会话过期，请重新登陆！','info',function(){
					window.parent.location.href="<%=ser_basePath%>default3.jsp";
			   });
		</script>
		<%
		return ;
    }
%>