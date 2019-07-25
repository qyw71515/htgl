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
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<script type="text/javascript">
	var datagrid;
	$(function() {
		nobackpace();
		var dg = $('#dg');
		
		$('#dg').datagrid({
			url : '<%=basePath%>doc/listData',
			pagination : true,
			pagePosition : 'bottom',
			pageSize : pageSize,
			pageList : pageList,
			fit : true,
			fitColumns : true,
			ctrlSelect:true,
			striped : true,
			rownumbers : true,
			sortName : 'createtime',
			sortOrder : 'desc',
			columns : [ [ {
				field : 'createtime',
				title : '上传时间',
				formatter: function(value,row,index){
	        		if(row.createtime != ""&& row.createtime != null){
	        			return row.createtime.substring(0,4)+"-"+row.createtime.substring(4,6)+"-"+row.createtime.substring(6,8)+" "+row.createtime.substring(8,10)+":"+row.createtime.substring(10,12)+":"+row.createtime.substring(12,14);
	        		}
	        	},
				width : 30,
				sortable : true
			},{
				field : 'wjm',
				title : '文件名',
				width : 30,
				sortable : true
			},{
				field : 'yhid',
				title : '用户id',
				width : 30,
				sortable : true
			},{
				field : 'by1',
				title : '操作',
				sortable : true,
				/*formatter: function(value,row,index){
						return "<a href=\"javascript:downLoad('"+row.uuid+"');\"><key style='text-decoration:underline;color:blue;'>下载</key></a>";
				},*/
				formatter: function(value,row,index){
					return "<a href=\"<%=basePath%>doc/down?id="+row.uuid+"\"><key style='text-decoration:underline;color:blue;'>下载</key></a>";
				},
				width:100
			}] ],
			toolbar : [{
				text:'上传',
				iconCls:'icon-add',
				handler:function(){
					showWindow2("upload", '<%=basePath%>doc/upload', 600,400, "icon-add", true, false,false)
				}
			},'-',{
				text:'查询',
				iconCls:'icon-search',
				handler:function(){
					showWindow2("search", '<%=basePath%>doc/query',600,400, "icon-search", true, false,false)
				}
			}]

		});
	});
	
	function downLoad(uuid){
		showWindow2("查看图片", '<%=basePath%>img/showPic?id='+uuid+'&type=b',600,400, "icon-tip", true, false,false)
	}
	
</script>
</head>
<body>
<div style="float:left,width:100%,height:100%,background:black"></div>
	<form id="form">
		<input type="hidden" name="scsje" id="scsje" /> 
		<input type="hidden" name="scsjs" id="scsjs" />
	</form>
	
	<table id="dg"></table>

</body>
</html>
