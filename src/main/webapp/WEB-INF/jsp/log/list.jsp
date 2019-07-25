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
			url : '<%=basePath%>log/listData',
			pagination : true,
			pagePosition : 'bottom',
			pageSize : pageSize,
			pageList : pageList,
			fit : true,
			fitColumns : true,
			ctrlSelect:true,
			striped : true,
			rownumbers : true,
			sortName : 'rzsj',
			sortOrder : 'desc',
			columns : [ [ {
				field : 'rzsj',
				title : '时间',
				formatter: function(value,row,index){
	        		if(row.rzsj != ""&& row.rzsj != null){
	        			return row.rzsj.substring(0,4)+"-"+row.rzsj.substring(4,6)+"-"+row.rzsj.substring(6,8)+" "+row.rzsj.substring(8,10)+":"+row.rzsj.substring(10,12)+":"+row.rzsj.substring(12,14);
	        		}
	        	},
				width : 80,
				sortable : true
			},{
				field : 'rzxx',
				title : '日志信息',
				width : 100,
				sortable : true
			},{
				field : 'ipdz',
				title : 'IP地址',
				width : 80,
				sortable : true
			},{
				field : 'by1',
				title : '类型',
				width : 30,
				sortable : true
			},{
				field : 'content',
				title : '内容',
				width : 100,
				sortable : true
			}] ],
			toolbar : [{
				text:'查询',
				iconCls:'icon-search',
				handler:function(){
					showWindow2("search", '<%=basePath%>log/query', 600,400, "icon-search", true, false,false)
				}
			}]

		});
	});
</script>
</head>
<body>

	<form id="form">
		<input type="hidden" name="rzsje" id="rzsje" /> 
		<input type="hidden" name="rzsjs" id="rzsjs" />
	</form>
	
	<table id="dg"></table>

</body>
</html>
