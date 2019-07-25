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
<script language="javascript" type="text/javascript"
	src="<%=basePath%>js/calendar/WdatePicker.js"></script>
<base href="<%=basePath%>">
<script type="text/javascript">
	$(function() {
		nobackpace();
	}); 
	
	function save(){
		var lx = $('#se option:selected') .val();
		$('#form').form('submit',{    
		    url:'<%=basePath%>img/uploadImg',
			onSubmit : function() {
				showProcess(true, "上传", "正在上传图片，请稍候...");
			},
			success : function(data) {
				showProcess(false, "上传", "正在上传图片，请稍候...");
				var data = eval('(' + data + ')');
				if (data.retCode == "1") {
					msgShow('提示', data.MSG, 'info');
				} else {
					msgShow('提示', data.MSG, 'error');
				}
				closeWindow2();
			}
		});
	}
</script>
</head>
<body>
	<fieldset>
		<legend>图片上传</legend>
		<form id="form" method="post" enctype="multipart/form-data">

			选择文件：<input name="file" id="file" class="easyui-filebox"
				style="width: 80%" buttonText="浏览">&nbsp;&nbsp;&nbsp;<br />
			
			
			<br />
			<div align="center">
				<a href="javascript:void(0)" id="submit" iconcls="fa fa-floppy-o"
					class="easyui-linkbutton" onclick="save();">上传</a>
			</div>
		</form>
	</fieldset>

</body>
</html>