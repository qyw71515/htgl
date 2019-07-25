<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
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
<script>
	var ctx = "${ctx}";
	$(function() {
		$("#userSubmit")
				.click(
						function() {
							var yhid = $.trim($("#username").val());
							var mima = $.trim($("#password").val());
							if (yhid == ''
									|| yhid == document
											.getElementById('username').defaultValue) {
								$(".messager-body").window('close');
								$.messager.alert('提示', '用户名不能为空，请输入！');
								return false;
							}
							if (mima == ''
									|| mima == document
											.getElementById('password').defaultValue) {
								$(".messager-body").window('close');
								$.messager.alert('提示', '密码不能为空，请重新输入！');
								return false;
							}
							$(this).addClass("logining");
							$
									.getJSON(
											ctx + "/login",
											{
												"t" : Math.random(),
												"yhid" : yhid,
												"mima" : mima
											},
											function(data) {
												try {
													if (data == "1") {
														window.location.href = ctx
																+ "/index.jsp";
													} else {
														$("#userSubmit")
																.removeClass(
																		"logining");
														$(".messager-body")
																.window('close');
														$.messager
																.alert('提示',
																		'输入用户名或密码有误，请重新输入！');
													}
												} catch (e) {
													$("#userSubmit")
															.removeClass(
																	"logining");
													$(".messager-body").window(
															'close');
													$.messager.alert('提示',
															'输入参数有误，请重新输入！');
												}
											}).error(
											function() {
												$("#userSubmit").removeClass(
														"logining");
												// 网络连接异常
												$.messager.alert('登录提示',
														'网络连接异常，请稍后再试！');
											});

						});
	});
</script>
</head>
<body>
	username：
	<input type="text" name="username" id="username" class="placeholder"
		value="用户名" tabindex="1">
	<br /> password：
	<input type="password" name="password" id="password">
	<br />
	<input type="button" name="userSubmit" id="userSubmit"
		class="userSubmit" value="login">
</body>
</html>
