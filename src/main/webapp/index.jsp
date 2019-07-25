<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<title>后台管理</title>
<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/easyuilibs.jsp"%>
<%@ include file="/common/artDialoglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styleV3.css?t=<%=Math.random() %>" />
<script type="text/javascript" src="<%=basePath%>js/aisino_mainV3.js?t=<%=Math.random() %>"></script>
	<script type="text/javascript" src="<%=basePath%>js/common.js"></script>

<script>
	window.onload = function() {
		$('#loading-mask').fadeOut();
	}
	var _menus;
	$.ajax({
		type : "GET",
		url : "<%=basePath%>initMenu?t=" + Math.random() + "",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		success : function(data) {
			_menus = data;
		},
		cache : false,
		async : false,
		error : function(msg) {
			alert(msg);
		}
	});
	var onlyOpenTitle = "我的桌面";//不允许关闭的标签的标题
	$(function(){
		//nobackpace();
		InitLeftMenu("<%=basePath%>");
		tabClose();
		tabCloseEven();
		//InitNuonuo("<%=basePath%>");
	});
</script>
</head>
<body>
	<div id="loading-mask"
		style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100%; background: #D2E0F2; z-index: 20000">
		<div id="pageloading"
			style="position: absolute; top: 50%; left: 50%; margin: -120px 0px 0px -120px; text-align: center; border: 2px solid #8DB2E3; width: 200px; height: 60px; font-size: 14px; padding: 10px; font-weight: bold; background: #fff; color: #15428B;">
			<img src="<%=basePath%>images/loading.gif" align="absmiddle" />
			正在加载中,请稍候...
		</div>
	</div>
	<div id="cc" class="easyui-layout" fit="true">
		<!-- 北区 -->
		<div data-options="region:'north'" style="height: 48px;"></div>
		<!-- 南区 -->
		<div data-options="region:'south'" style="height: 30px;"></div>
		<!-- 西区 -->
		<div data-options="region:'west',split:true"
			title="<i class='fa fa-home'></i>&nbsp;&nbsp;功能菜单"
			style="width: 200px;color:black">
			<div id="nav"></div>
		</div>
		<!-- 中心 -->
		<div data-options="region:'center'" style="border: none;"
			href="<%=basePath%>main.jsp"></div>
	</div>
</body>
</html>
