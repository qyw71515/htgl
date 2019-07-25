/* 计算字符长度 */
function strlen(strTemp) {
	var i, sum;
	sum = 0;
	for (i = 0; i < strTemp.length; i++) {
		if ((strTemp.charCodeAt(i) >= 0) && (strTemp.charCodeAt(i) <= 255))
			sum = sum + 1;
		else
			sum = sum + 2;
	}
	return sum;
}

/**
 * 检验手机是否合法
 * @param value
 * @returns {Boolean}
 */
function checkMobile(value){
	//var reg = "/(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/";
    var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if(reg.test(value)){
		return true;
	}else{
		return false;
	}
}
/**
 * 校验邮箱是否合法
 * @param value
 * @returns {Boolean}
 */
function checkEmail(value){
	 
	var reg = "/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/";
	if(reg.test(value)){
		return true;
	}else{
		return false;
	}
}

/**
 * 验证移动电话
 * 
 * @param value
 * @returns {Boolean}
 */
function isMobile(value) {
	if (/^13\d{9}$/g.test(value) || (/^15[0-35-9]\d{8}$/g.test(value))
			|| (/^18[05-9]\d{8}$/g.test(value))) {
		return true;
	} else {
		return false;
	}
}

/**
 * 邮政编码
 * 
 * @param value
 * @returns {Boolean}
 */
function isYzbm(value) {
	if (/^[1-9][0-9]{5}$/.test(value)) {
		return true;
	}
	return false;
}

/**
 * 判断复选框是否选中
 * 
 * @returns {Boolean}
 */
function ischeckBoxCheck(obj) {
	var check = document.getElementsByName(obj);
	for (var i = 0; i < check.length; i++) {
		if (check[i].checked) {
			return true;
		}
	}
	return false;
}

/**
 * 设置当前时间
 * 
 * @param o
 */
function setCurrentDateTime(o) {
	var d = new Date();
	var da = d.getDate();
	var mo = d.getMonth() + 1;
	var y = d.getFullYear();
	var h = d.getHours();
	if (h < 10) {
		h = '0' + h;
	}
	var m = d.getMinutes();
	if (m < 10) {
		m = '0' + m;
	}
	var s = d.getSeconds();
	if (s < 10) {
		s = '0' + s;
	}
	var week = [ '天', '一', '二', '三', '四', '五', '六' ];
	if (typeof (o) != 'object') {
		// o=$(o);
		o = document.getElementById(o);
	}
	o.innerHTML = y + '年' + mo + '月' + da + '日  星期' + week[d.getDay()] + '  '
			+ h + ':' + m + ':' + s;
	window.setTimeout(function() {
		setCurrentDateTime(o);
	}, 1000);
}

/**
 * 空字符串验证
 */
function dealnull(exp) {
	if (exp != null || typeof (exp) != "undefined" || typeof (exp) != undefined
			|| exp != undefined) {
		return exp;
	}
	if (exp == undefined || exp == null || exp == "undefined") {
		return "";
	}
	return "";
}

/**
 * 退出登录
 */
function loginout() {
	/***************************************************************************
	 * ymPrompt.confirmInfo({message:'确定要退出此系统!',handler:function(){
	 * window.parent.location.href = 'loginout.jsp'; },titile:'退出系统提示'});
	 **************************************************************************/
	window.parent.location.href = 'loginout.jsp';
}

/**
 * 关闭ymPrompt窗口
 */
function closeWin() {
	/* window.parent.ymPrompt.doHandler('error', true); */
	var list = window.parent.art.dialog.list;
	for ( var i in list) {
		list[i].close();
	}
	;
}

/** ***********字符空验证************************** */
function dealnull(exp) {
	if (exp != null || typeof (exp) != "undefined" || typeof (exp) != undefined
			|| exp != undefined) {
		return exp;
	}
	if (exp == undefined || exp == null || exp == "undefined") {
		return "";
	}
	return "";
}

/** **********Cookie设置************************** */
function getCValue(CName) {
	var getValue = getCookie(CName);
	return getValue;
}

function setCValue(CName, CValue) {
	var expdate = new Date();
	expdate.setTime(expdate.getTime() + 24 * 60 * 60 * 1000);
	setCookie(CValue, [ CName, expdate, "", "" ]); // [name, expires, path,
	// domain,
	// secure] WindowUtilities.
	return true;
}

function setCookie(value, parameters) {
	document.cookie = parameters[0]
			+ "="
			+ escape(value)
			+ ((parameters[1]) ? "; expires=" + parameters[1].toGMTString()
					: "")
			+ ((parameters[2]) ? "; path=" + parameters[2] : "; path=/")
			+ ((parameters[3]) ? "; domain=" + parameters[3] : "")
			+ ((parameters[4]) ? "; secure" : "");
}

function getCookie(name) {
	var dc = document.cookie;
	var prefix = name + "=";
	var begin = dc.indexOf("; " + prefix);
	if (begin == -1) {
		begin = dc.indexOf(prefix);
		if (begin != 0)
			return null;
	} else {
		begin += 2;
	}
	var end = document.cookie.indexOf(";", begin);
	if (end == -1) {
		end = dc.length;
	}
	return unescape(dc.substring(begin + prefix.length, end));

}
/** **********Cookie设置************************** */

/** ***********防止在弹出页面启用Backspace返回********** */
function nobackpace() {
	$(document).keydown(
			function(e) {
				e = e || window.event;
				var target = e.target;
				var tag = e.target.tagName.toUpperCase();
				if (e.keyCode == 8) {
					if ((tag == 'INPUT' && !$(target).attr("readonly"))
							|| (tag == 'TEXTAREA' && !$(target)
									.attr("readonly"))) {
						if ((target.type.toUpperCase() == "RADIO")
								|| (target.type.toUpperCase() == "CHECKBOX")) {
							return false;
						} else {
							return true;
						}
					} else {
						return false;
					}
				}
				if ((e.keyCode == 116)) {
					// F5键
					// e.cancelBubble = false;
					// e.returnValue = false;
					event.keyCode = 0;
					event.returnValue = false;
					return false;
				}
				if (event.keyCode == 122) {// 屏蔽F11键
					event.keyCode = 0;
					event.cancelBubble = true;
					return false;
				}
				if ((event.ctrlKey && event.keyCode == 82)) {// 屏蔽Ctrl+R
					event.keyCode = 0;
					event.cancelBubble = true;
					return false;
				}
				if ((event.ctrlKey && event.keyCode == 78)) {// 屏蔽Ctrl+N
					event.keyCode = 0;
					event.cancelBubble = true;
					return false;
				}
				if ((e.keyCode == 13)) {
					// enter
					return false;
				}
			});
	/** 屏蔽右键* */
	$(document).bind("contextmenu", function() {
		return false;
	});
}

/**
 * 替换函数
 * 
 * @param s1
 * @param s2
 * @returns
 */
String.prototype.replaceAll = function(s1, s2) {
	return this.replace(new RegExp(s1, "gm"), s2);
};

/*
 * 特殊字符在ASCII码中所表示的范围为32~48，57~65，90~97
 * event.returnValue=false;设置键盘输入主false，则不能在文本框中输入内容
 */
function checkComments() {
	var key = window.event ? event.keyCode : e.which;
	if ((key > 32 && key < 48) || (key > 57 && key < 65)
			|| (key > 90 && key < 97)) {
		event.returnValue = false;
	}
}
/*
 * 引号的ASCII码为34和39
 */
function checkEmail() {
	if (event.keyCode == 34 || event.keyCode == 39) {
		event.returnValue = false;
	}
}
/*
 * 数字的ASCII表示范围为 45~57
 */
function checkPostalCode() {
	if (event.keyCode < 45 || event.keyCode > 57) {
		event.returnValue = false;
	}
}
/*
 * 大写英文字母ASCII表示范围为65~91 小写英文字母ASCII表示范围为97~123
 */
function checkEnglish() {
	if (event.keyCode < 65 || event.keyCode > 91) {
		event.returnValue = false;
	}
}

/**
 * 对像转换成字符型
 * 
 * @param o
 * @returns
 */
function obj2str(o) {
	var r = [];
	if (typeof o == "string")
		return "\""
				+ o.replace(/([\'\"\\])/g, "\\$1").replace(/(\n)/g, "\\n")
						.replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
	if (typeof o == "object") {
		if (!o.sort) {
			for ( var i in o)
				r.push(i + ":" + obj2str(o[i]));
			if (!!document.all
					&& !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/
							.test(o.toString)) {
				r.push("toString:" + o.toString.toString());
			}
			r = "{" + r.join() + "}";
		} else {
			for (var i = 0; i < o.length; i++)
				r.push(obj2str(o[i]));
			r = "[" + r.join() + "]";
		}
		return r;
	}
	return o.toString();
}

/**
 * 切分字符
 * 
 * @param str
 * @param len
 * @returns
 */
function splitstr(str, len) {
	if (str.length > len) {
		return str.substring(0, len) + "...";
	}
	return str;
}

/**
 * 转义字符
 * 
 * @returns
 */
function escapeChar(str) {
	return str.replaceAll("'", "\'");
}

/** 过滤表单中的特殊字符 */
function checkSpecialCharacter(inputvalue) {
	var str = inputvalue.value;
	var SPECIAL_STR = "￥$~!@%^&*();'\"?><[]{}\\|,:/=“”‘"; // "￥#$~!@%^&*();'\"?><[]{}\\|,:/=+—“”‘";
	for (i = 0; i < str.length; i++)
		if (SPECIAL_STR.indexOf(str.charAt(i)) != -1) {
			alert("不能填写非法字符(" + str.charAt(i) + ")！");
			inputvalue.value = '';
			inputvalue.focus();
			return false;
		}
	return true;
}

/** 只能输入英文 */
function checkEnglishCharacter(inputvalue) {
	var str = inputvalue.value;
	for (i = 0; i < str.length; i++) {
		ecStr = str.substr(i, 1);
		ascStr = ecStr.charCodeAt();
		if (ascStr > 127) {
			alert("只能输入英文!");
			inputvalue.value = '';
			inputvalue.focus();
			return false;
		}
	}
	return true;
}

/**
 * 输入正整数
 */
function checkIntegerCharacter(inputvalue) {
	var obj = inputvalue.value;
	reg = /^[1-9]d*|0$/g;
	if (reg.test(obj)) {
		return true;
	} else {
		inputvalue.value = '';
		// inputvalue.focus();
		return false;
	}
}

/**
 * float型数据 2位小数点
 * 
 * @param inputvalue
 * @returns {Boolean}
 */
function checkFloatCharacter(inputvalue) {
	var obj = inputvalue.value;
	reg = /^[0-9]+(.[0-9]{1,2})?$/g;
	if (dealnull == '') {
		return true;
	} else {
		if (reg.test(obj)) {
			return true;
		} else {
			alert("只能输入至多两位小数的数字！");
			inputvalue.value = '';
			return false;
		}
	}
}

/**
 * 获取14位的本地时间
 * 
 * @returns {String}
 */
function getTimeString() {
	var now = new Date();
	var year = now.getFullYear();
	var month = now.getMonth() + 1;
	var day = now.getDate();
	var hour = now.getHours();
	var minute = now.getMinutes();
	var second = now.getSeconds();
	var str = year + "" + (month < 10 ? "0" + month : month) + "" + ""
			+ (day < 10 ? "0" + day : day) + ""
			+ (hour < 10 ? "0" + hour : hour) + ""
			+ (minute < 10 ? "0" + minute : minute) + ""
			+ (second < 10 ? "0" + second : second);
	return str;
}

/**
 * 字体color变色
 * 
 * @param ele
 * @param cls
 * @param times
 */
function dealshake(ele, cls, times) {
	var i = 0, t = false, o = ele.attr("class") + " ", c = "", times = times || 2;
	if (t)
		return;
	t = setInterval(function() {
		i++;
		c = i % 2 ? o + cls : o;
		ele.attr("class", c);
		if (i == 2 * times) {
			clearInterval(t);
			ele.removeClass(cls);
		}
	}, 600);
};

// 这是有设定过期时间的使用示例：
// s20是代表20秒
// h是指小时，如12小时则是：h12
// d是天数，30天则：d30

// setCookie("name","hayden","s20");
function setCookieNew(name, value, time) {
	var strsec = getsec(time);
	var exp = new Date();
	exp.setTime(exp.getTime() + strsec * 1);
	document.cookie = name + "=" + escape(value) + ";expires="
			+ exp.toGMTString() + "; path=/";
}

function getsec(str) {
	var str1 = str.substring(1, str.length) * 1;
	var str2 = str.substring(0, 1);
	if (str2 == "s") {
		return str1 * 1000;
	} else if (str2 == "h") {
		return str1 * 60 * 60 * 1000;
	} else if (str2 == "d") {
		return str1 * 24 * 60 * 60 * 1000;
	}
}

String.prototype.isNumber = function(s) {
	return (this.search(/^[+-]?[0-9.]*$/) >= 0);
};

/**
 * 发票号码补0
 * 
 * @param fphm
 * @returns
 */
function fomartFphm(fphm) {
	var len = fphm.toString().length;
	if (len == 7) {
		return "0" + fphm;
	} else if (len == 6) {
		return "00" + fphm;
	} else if (len == 5) {
		return "000" + fphm;
	} else if (len == 4) {
		return "0000" + fphm;
	} else if (len == 3) {
		return "00000" + fphm;
	} else if (len == 2) {
		return "000000" + fphm;
	} else if (len == 1) {
		return "0000000" + fphm;
	}
	return fphm;
}

/*******************************************************************************
 * 
 * 以下为easyui框架使用
 * 
 ******************************************************************************/

/**
 * 统一设置分页大小列表，即每页记录数
 */
var pageSize = 20;
var pageList = [ 20, 30, 40, 50, 100, 200];
/**
 * @author qiuchangwen
 * 
 * @requires jQuery
 * 
 * 将form表单元素的值序列化成对象
 * 
 * @returns object
 */
function serializeObject(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
};

function createFrame(url) {
	var s = '<iframe name="f1" id="f1" scrolling="auto" frameborder="0"  src="' + url
			+ '" style="width:100%;height:99%;"></iframe>';
	return s;
}
/**
 * 弹出框以及系统消息框
 * 
 * @param title
 * @param msg
 * @param isAlert
 */
function showMsg(title, msg, isAlert) {
	if (isAlert !== undefined && isAlert) {
		parent.$.messager.alert(title, msg);
	} else {
		parent.$.messager.show({
			title : title,
			msg : msg,
			howType : 'show'
		});
	}
}

/**
 * 弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
 */
function msgShow(title, msgString, msgType) {
	parent.$.messager.alert(title, msgString, msgType);
}

/**
 * 确认框
 * 
 * @param title
 * @param msg
 * @param callback
 * @returns
 */
function showConfirm(title, msg, callback) {

	parent.$.messager.confirm(title, msg, function(r) {

		if (r) {

			if (jQuery.isFunction(callback))

				callback.call();

		}

	});

}

/**
 * 进度框
 * 
 * @param isShow
 * @param title
 * @param msg
 * @returns
 */

function showProcess(isShow, title, msg) {

	if (!isShow) {

		parent.$.messager.progress('close');

		return;

	}

	var win = parent.$.messager.progress({

		title : title,

		msg : msg,
		
		interval : 1000

	});

}
/**
 * 进度框
 * 
 * @param isShow
 * @param title
 * @param msg
 * @returns
 */

function showProcessBar(isShow, title,text,time) {

	if (!isShow) {

		parent.$.messager.progress('close');

		return;

	}

	var win = parent.$.messager.progress({

		title : title,
		text:text, 
		interval : time

	});

}
/**
 * 统一查询调用函数
 */
function queryResult() {
	var form = $("#form").form();
	var dg = $('#dg');
	dg.datagrid('load', serializeObject(form));
}
function queryResult1() {
	var form = $("#form").form();
	var dg = $('#dg');
	dg.treegrid('reload', serializeObject(form));
}
/**
 * 查询重置
 */
function queryReset() {
	var form = $("#form").form();
	form.find('input').val('');
	form.find('select').val('');
}
/**
 * 窗口
 * 
 * @param title
 * @param href
 * @param width
 * @param height
 * @param iconCls
 * @param modal
 * @param minimizable
 * @param maximizable
 */
function showWindow(title, href, width, height, iconCls, modal, minimizable,
		maximizable) {
	var openWin = window.top.$(
			'<div id="myWinId" class="easyui-window" closed="true"></div>')
			.appendTo(window.top.document.body);
	openWin.window({
		title : title,
		width : width == undefined || width == 0 ? 700 : width,
		height : height == undefined || width == 0 ? 500 : height,
		content : createFrame(href),
		modal : modal == undefined ? true : modal,
		minimizable : minimizable == undefined ? false : minimizable,
		maximizable : maximizable == undefined ? false : maximizable,
		shadow : false,
		cache : false,
		closed : false,
		collapsible : false,
		resizable : false,
		iconCls : iconCls,
		loadingMessage : '正在努力加载中...',
		onClose : function() {
			openWin.window("destroy");
			queryResult();
			queryResult1();
		}
	});
}

function showWindow2(title, href, width, height, iconCls, modal, minimizable,
		maximizable) {
	var openWin = $(
			'<div id="myWinId2" class="easyui-window" closed="true"></div>')
			.appendTo(document.body);
	openWin.window({
		title : title,
		width : width == undefined || width == 0 ? 650 : width,
		height : height == undefined || width == 0 ? 500 : height,
		content : '<iframe name="f2" id="f2" scrolling="auto" frameborder="0"  src="' + href
			+ '" style="width:100%;height:99%;"></iframe>',
		modal : modal == undefined ? true : modal,
		minimizable : minimizable == undefined ? false : minimizable,
		maximizable : maximizable == undefined ? false : maximizable,
		shadow : false,
		cache : false,
		closed : false,
		collapsible : false,
		resizable : false,
		iconCls : iconCls,
		loadingMessage : '正在努力加载中...',
		onClose : function() {
			openWin.window("destroy");
			queryResult();
		}
	});
}

/**
 * 窗口   没有刷新的，关闭时同时关闭其父窗口
 * 
 * @param title
 * @param href
 * @param width
 * @param height
 * @param iconCls
 * @param modal
 * @param minimizable
 * @param maximizable
 */
function showWindow3(title, href, width, height, iconCls, modal, minimizable,
		maximizable) {
	var openWin = window.top.$(
			'<div id="myWinId" class="easyui-window" closed="true"></div>')
			.appendTo(window.top.document.body);
	openWin.window({
		title : title,
		width : width == undefined || width == 0 ? 700 : width,
		height : height == undefined || width == 0 ? 500 : height,
		content : createFrame(href),
		modal : modal == undefined ? true : modal,
		minimizable : minimizable == undefined ? false : minimizable,
		maximizable : maximizable == undefined ? false : maximizable,
		shadow : false,
		cache : false,
		closed : false,
		collapsible : false,
		resizable : false,
		iconCls : iconCls,
		loadingMessage : '正在努力加载中...',
		onClose : function() {
			openWin.window("destroy");
			closeTabs();
		}
	});
}

/**
 * 窗口   没有刷新的，关闭时同时不关闭其父窗口
 * 
 * @param title
 * @param href
 * @param width
 * @param height
 * @param iconCls
 * @param modal
 * @param minimizable
 * @param maximizable
 */
function showWindow4(title, href, width, height, iconCls, modal, minimizable,
		maximizable) {
	var openWin = window.top.$(
			'<div id="myWinId" class="easyui-window" closed="true"></div>')
			.appendTo(window.top.document.body);
	openWin.window({
		title : title,
		width : width == undefined || width == 0 ? 700 : width,
		height : height == undefined || width == 0 ? 500 : height,
		content : createFrame(href),
		modal : modal == undefined ? true : modal,
		minimizable : minimizable == undefined ? false : minimizable,
		maximizable : maximizable == undefined ? false : maximizable,
		shadow : false,
		cache : false,
		closed : false,
		collapsible : false,
		resizable : false,
		iconCls : iconCls,
		loadingMessage : '正在努力加载中...',
		onClose : function() {
			openWin.window("destroy");
		}
	});
}

/**
 * 通过ID创建窗口
 * @param title
 * @param title
 * @param href
 * @param width
 * @param height
 * @param iconCls
 * @param modal
 * @param minimizable
 * @param maximizable
 */
function showWindowById(id,title, href, width, height, iconCls, modal, minimizable,
		maximizable) {
	var openWin = window.top.$(
			'<div id='+id+' class="easyui-window" closed="true"></div>')
			.appendTo(window.top.document.body);
	openWin.window({
		title : title,
		width : width == undefined || width == 0 ? 700 : width,
		height : height == undefined || width == 0 ? 500 : height,
		content : createFrame(href),
		modal : modal == undefined ? true : modal,
		minimizable : minimizable == undefined ? false : minimizable,
		maximizable : maximizable == undefined ? false : maximizable,
		shadow : false,
		cache : false,
		closed : false,
		collapsible : false,
		resizable : false,
		iconCls : iconCls,
		loadingMessage : '正在努力加载中...',
		onClose : function() {
			openWin.window("destroy");
		}
	});
}

function closeWindowById(id) {
	window.parent.$('#'+id).window('close');
}



/**
 * 关闭窗口
 */
function closeWindow() {
	window.parent.$('#myWinId').window('close');
}

function closeWindow2() {
	window.parent.$('#myWinId2').window('close');
}
/**
 * 弹出的窗口关闭时调用，关闭弹出窗口的父窗口所在的tabs
 */
function closeTabs(){
	var tab = parent.$('#tabs').tabs('getSelected');
	if(tab){
        var index = parent.$('#tabs').tabs('getTabIndex',tab);
        parent.$('#tabs').tabs('close',index);
    }
}

function setValue(row){
	//alert(row.jspid);
	 //var x = window.top.document.getElementById('f1').contentWindow.document.getElementById('test').value;
	//console.info(x);
	//获取iframe的window对象
	//var topWin = window.top.document.getElementById("f1").contentWindow;
	//console.info(topWin);
	//通过获取到的window对象操作HTML元素，这和普通页面一样
	// var x = topWin.document.getElementById("test").value;
	//alert(x.document.getElementById("test").val());
	$("#jspid").textbox('setValue',row.jspid);
}
/**
 * 提示tips
 * 
 * @param obj
 * @param message
 */
function showTips(obj, message) {
	$('#' + obj).tooltip({
		position : 'bottom',
		content : '<span style="color:#fff">' + message + '</span>',
		onShow : function() {
			$(this).tooltip('tip').css({
				backgroundColor : '#666',
				borderColor : '#666'
			});
		}
	});
}

// combotree 过滤查询
function queryComboTree(q, comboid) {
	var datalist = [];// 用平面的combobox来展示过滤的结果
	var childrenlist = [];
	var combotreeid = "#" + comboid;
	var roots = $(combotreeid).combotree('tree').tree('getRoots');// 得到根节点数组
	var children;
	var entertext = $(combotreeid).combotree('getText');
	$(combotreeid).combotree('setText', q);
	if (entertext == null || entertext == "") {// 如果文本框的值为空，或者将文本框的值删除了，重新reload数据
		$(combotreeid).combotree('reload');
		$(combotreeid).combotree('clear');
		$(combotreeid).combotree('setText', q);
		return;
	}
	// 循环数组，找到与输入值相似的，加到前面定义的数组中，
	for (i = 0; i < roots.length; i++) {
		if (q == roots[i].text) {
			$(combotreeid).combotree('tree').tree('select', roots[i].target);
			return;
		} else {
			if (roots[i].text.indexOf(q) >= 0 && roots[i].text != "") {
				var org = {
					"id" : roots[i].id,
					"text" : roots[i].text
				};
				datalist.push(org);
			}
		}
		// 找子节点（递归）
		childrensTree(combotreeid, roots[i].target, datalist, q);
	}
	// 如果找到相似的结果，则加载过滤的结果
	if (datalist.length > 0) {
		$(combotreeid).combotree('loadData', datalist);
		$(combotreeid).combotree('setText', q);
		datalist = [];// 这里重新赋值是避免再次过滤时，会有重复的记录
		return;
	} else {
		$(combotreeid).combotree('reload');
		$(combotreeid).combotree('clear');
		$(combotreeid).combotree('setText', q);
		return;
	}
}

function childrensTree(combotreeid, rootstarget, datalist, q) {
	children = $(combotreeid).combotree('tree').tree('getChildren', rootstarget);
	console.log(children);
	for (j = 0; j < children.length; j++) {
		if (q == children[j].text) {
			$(combotreeid).combotree('tree').tree('select', children[j].target);
			return;
		} else {
			if (children[j].text.indexOf(q) >= 0 && children[j].text != "") {
				var org = {
					"id" : children[j].id,
					"text" : children[j].text
				};
				datalist.push(org);
			}
		}
	}
}

/**
 * ajax执行后台操作
 * @param url
 * @param param
 * @param msg
 */
function ajaxDo(url,param,msg) {
	showConfirm("提示",msg,function(){
		showProcess(true, "提示", "正在操作，请稍候...");
		 $.ajax({
		      type: "post",
		      url: url,
			  data: param,
		      async: false,
		      dataType: "json",
		      cache: false,
			  timeout: 60000,
		      success: function (data) {
		    	  showProcess(false, "提示", "正在操作，请稍候...");
		    	  if(data != null){
		    		  if(data.retCode=='1'){
		    			  msgShow("提示",data.retMsg,"info");
		    		  }else if(data.retCode=='0'){
		    			  msgShow("提示",data.retMsg,"info");
		    		  }else{
		    			  msgShow("提示",data.retMsg,"error");
		    		  }
		    	  }
		      },
		      error: function (msg) {
		    	  showProcess(false, "提示", "正在操作，请稍候...");
		    	  msgShow("提示",msg,"error");
		      }
		 });
		 queryResult();
	});
}

/**
 * 调用ajax
 * @param url
 * @param param
 */
function ajaxFun(url,param) {
	 $.ajax({
	      type: "post",
	      url: url,
		  data: param,
	      async: false,
	      dataType: "json",
	      cache: false,
		  timeout: 60000,
	      success: function (data) {
	    	  if(data != null){
	    		  if(data.retCode=='1'){
	    			  msgShow("提示",data.retMsg,"info");
	    		  }else if(data.retCode=='0'){
	    			  msgShow("提示",data.retMsg,"info");
	    		  }else{
	    			  msgShow("提示",data.retMsg,"error");
	    		  }
	    	  }
	      },
	      error: function (msg) {
	    	  msgShow("提示",msg,"error");
	      }
	 });
}
/**
 * 密码复杂度校验
 * @param pass
 * @returns
 */
function checkPass(pass){
	var ls = 0;
	if(pass.length >= 6){
		ls++;
	}
	if(pass.match(/([a-z])+/)){
		ls++;
	}
	if(pass.match(/([0-9])+/)){
		ls++;  
	}
	if(pass.match(/([A-Z])+/)){
		ls++;
	}
	if(pass.match(/[^a-zA-Z0-9]+/)){
		ls++;
	}
	if(ls<3){
		return true
	}
	return false;
}

/**
 * 帮助文档展示
 * @param url
 */
function showHelp(url){
 	window.open(url); 
 }
//请求头类型
function getProtocol() {
	return window.location.protocol + "//";
}
// 域名：端口
function getHost() {
	return window.location.host; // localhost:8080
}
function getPreUrl() {
	return getProtocol() + getHost() + '/' + getProjectName();
}
function getProjectName() {
	var relativePath = location.pathname;
	var tmp = relativePath.split("/");
	if (tmp[1].length == 0) {
		return tmp[2];
	} else {
		return tmp[1];
	}
}

// 获取?后参数的值
function getQueryString(name) {
	console.log(name);
	var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {
		return unescape(r[2]);
	}
	return null;
}

// 获取url参数的value getUrlArgumentValue(参数名称)
function getUrlArgumentValue(name) {
	var hash = window.location.hash;
	if (hash != "" && name == 'code') { // 路径中有锚点 不能直接获取到 参数
		if (hash.indexOf('&') > 0) {
			return hash.split('&')[1].split('=')[1];
		} else {
			return hash.split('?')[1].split('=')[1];
		}
	}
	if (hash != "" && name == 'path') {
		return window.location.search.substr(6).split("?")[0]
				+ hash.split('&')[0];
	}
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {
		return unescape(r[2]) + hash;
	} else {
		return null;
	}
}

// 获取url参数列表 数组
function getUrlArgumentArr() {
	var name, value;
	var str = location.href; // 取得整个地址栏
	var num = str.indexOf("?")
	str = str.substr(num + 1); // 取得所有参数 stringvar.substr(start [, length ]

	var arr = str.split("&"); // 各个参数放到数组里
	for (var i = 0; i < arr.length; i++) {
		num = arr[i].indexOf("=");
		if (num > 0) {
			name = arr[i].substring(0, num);
			value = arr[i].substr(num + 1);
			this[name] = value;
		}
	}
	return arr;
}

// 获取url参数列表 数组
function getUrlArgumentArr() {
	var name, value;
	var str = location.href; // 取得整个地址栏
	var num = str.indexOf("?")
	str = str.substr(num + 1); // 取得所有参数 stringvar.substr(start [, length ]

	var arr = str.split("&"); // 各个参数放到数组里
	for (var i = 0; i < arr.length; i++) {
		num = arr[i].indexOf("=");
		if (num > 0) {
			name = arr[i].substring(0, num);
			value = arr[i].substr(num + 1);
			this[name] = value;
		}
	}
	return arr;
}
