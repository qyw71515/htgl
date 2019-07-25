<%@ page contentType="text/html;charset=UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>发票管理平台</title>
<%@ include file="/common/meta.jsp"%>
<%@ include file="/common/easyuilibs.jsp"%>

<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePath %>js/calendar/WdatePicker.js"></script>
<base href="<%=basePath%>">
<script type="text/javascript">
	$(function() {
		nobackpace();
		var rzsjs = window.parent.$("#rzsjs").val();
		var rzsje = window.parent.$("#rzsje").val();
		$("#rzsjs").val(rzsjs);
		$("#rzsje").val(rzsje);
	});

	function query() {
		var rzsje = $("#rzsje").val();
		var rzsjs = $("#rzsjs").val();
		window.parent.$("#rzsjs").val(rzsjs);
		window.parent.$("#rzsje").val(rzsje);
		closeWindow2();
	}
	
	function reset(){
		$("#rzsjs").val('');
		$("#rzsje").val('');
		window.parent.$("#rzsjs").val('');
		window.parent.$("#rzsje").val('');
	
	}
</script>
</head>
<body>
	<form id="form" method="post">
		<table width="99.5%" border="0" cellpadding="1" cellspacing="1"
			class="table">
			
			<tr class="line">
				<td align='right' width="20%" class="title1">日志日期起</td>
				<td align='left'>
				<input type="text" name="rzsjs" id="rzsjs" maxlength="10" class="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'rzsje\')||\'%y-%M-%d %H:%m:%s\'}',isShowClear:true,readOnly:true})" />
				</td>
				<td align='right' width="20%" class="title1">日志日期止</td>
				<td align='left'>
				<input type="text" name="rzsje" id="rzsje" maxlength="10" class="Wdate"  onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'rzsjs\')}',isShowClear:true,readOnly:true})"/>
				</td>
			</tr>
		
		</table>
		<div align="center">
			<a href="javascript:void(0)" id="submit" iconcls="fa fa-search"
				class="easyui-linkbutton" onclick="query();">查询</a>
			<a href="javascript:void(0)" id="submit" iconcls="fa fa-refresh"
				class="easyui-linkbutton" onclick="reset();">重置</a>
			<a href="javascript:void(0)" id="submit" iconcls="fa fa-times-circle"
			class="easyui-linkbutton" onclick="closeWindow2();">关闭</a>
		</div>
	</form>
</body>
</html>