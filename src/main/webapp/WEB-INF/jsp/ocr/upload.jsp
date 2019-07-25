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
		    url:'<%=basePath%>ocr/uploadImg?lx='+lx,
			onSubmit : function() {
				showProcess(true, "上传", "正在上传图片，请稍候...");
			},
			success : function(data) {
				showProcess(false, "上传", "正在上传图片，请稍候...");
				var data = eval('(' + data + ')');
				if (data.retCode == "1") {
					msgShow('提示', data.MSG, 'info');
					showWindow2("查看返回结果", '<%=basePath%>ocr/viewMsg?uuid='+data.uuid,600,400, "icon-tip", true, false,false)
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
		<legend>OCR识别</legend>
		<form id="form" method="post" enctype="multipart/form-data">

			选择文件：<input name="file" id="file" class="easyui-filebox"
				style="width: 80%" buttonText="浏览">&nbsp;&nbsp;&nbsp;<br />
			
			
			<br /> 选择类型：<select class="easyui-combobox" name="state" id="se"
				style="width: 200px;">
				<option value="ty">通用文字识别</option>
				<option value="tygjd">通用文字识别（高精度版）</option>
				<option value="fp">增值税发票识别</option>
				
				
				
			</select> <br />
			<br />
			<div align="center">
				<a href="javascript:void(0)" id="submit" iconcls="fa fa-floppy-o"
					class="easyui-linkbutton" onclick="save();">上传</a>
			</div>
		</form>
	</fieldset>

</body>
</html>