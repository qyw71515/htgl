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
			url : '<%=basePath%>ocr/listData',
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
				width : 80,
				sortable : true
			},{
				field : 'by1',
				title : '文件名',
				width : 100,
				sortable : true
			},{
				field : 'lx',
				title : '类型',
				width : 50,
				sortable : true
			},{
				field : 'cguid',
				title : '操作',
				sortable : true,
				formatter: function(value,row,index){
					if(row.cyzt!="1"){
						return "<a href=\"javascript:viewPic('"+row.uuid+"');\"><key style='text-decoration:underline;color:blue;'>查看原始图片</key></a>&nbsp&nbsp&nbsp<a href=\"javascript:viewMsg('"+row.uuid+"');\"><key style='text-decoration:underline;color:blue;'>查看返回结果</key></a>";
					}else{
						//return "<a href=\"javascript:querySpData('"+row.fpdm+"','"+row.fphm+"','"+row.fpzl+"');\"><key style='text-decoration:underline;color:blue;'>明细</key></a>";
						return "";
					}
				},
				width:100
			}] ],
			toolbar : [{
				text:'上传识别',
				iconCls:'icon-add',
				handler:function(){
					showWindow2("search", '<%=basePath%>ocr/upload', 600,400, "icon-search", true, false,false)
				}
			},'-',{
				text:'查询',
				iconCls:'icon-search',
				handler:function(){
					showWindow2("search", '<%=basePath%>ocr/query',600,400, "icon-search", true, false,false)
				}
			}]

		});
	});
	
	function viewPic(uuid){
		showWindow2("查看图片", '<%=basePath%>ocr/viewPic?uuid='+uuid,600,400, "icon-tip", true, false,false)
	}
	function viewMsg(uuid){
		showWindow2("查看返回结果", '<%=basePath%>ocr/viewMsg?uuid='+uuid,600,400, "icon-tip", true, false,false)
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
