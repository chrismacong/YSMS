<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>南京市青少年足球联盟管理系统</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/md5.js"></script>
<link type="text/css"
	href="${pageContext.request.contextPath}/css/dialog.css"
	rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/logincss.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<style type="text/css">
</style>
<script type="text/javascript">
$(function() {
	path="${pageContext.request.contextPath}";
	checkCookie();
});


var i=-1;
setInterval(countSecond,6000);
function countSecond()
{
	if(i<5)i++;	
	else  i=0;
	 $('.bg').children().eq(i).fadeTo("slow", 1).siblings().hide();
}       

$(function(){
	document.onkeydown = function(e){ 
	    var ev = document.all ? window.event : e;
	    if(ev.keyCode==13) {
	    	if($(".ds_dialog") != null && $(".ds_dialog").length > 0){
	    		var isExist = false;
	    		$(".ds_dialog").each(function(){
	    			if($(this).css("display") == "block"){
	    				isExist = true;
		    		}
	    		});
	    		if(isExist){
	    			return;	
	    		}
	    	}
	    	userlogin();
	    }
	}
	
	$(".check_btn").click(
		function(){
			 var right = $(this).css("right");
			 if(right != '0px'){
				$(this).css("right","0px");
			 	$('.check').css('background',' url(${pageContext.request.contextPath}/images/check_on.png)');
			 }
			 else{
				$(this).css("right","39px");
			 	$('.check').css('background',' url(${pageContext.request.contextPath}/images/check_off.png)');
			 }
		}
   );
});  
function isEmpty(id) {

	var name = $("#" + id + "").val();

	if (name == null || name == undefined || name == "" || name == NaN) {
		return true;
	}
	return false;
}

function userlogin(){	
	var userName=$("#username").val();
	var userPassword;

	if(getCookie("userpwd")!=""&&getCookie("userpwd")!=null){
		userPassword=getCookie("userpwd");
	}else{
		userPassword=hex_md5($("#password").val());
	}
	 
	if(isEmpty("username")){
		  ds.dialog({
				title : '消息提示',
				content : "请输入登录账号！",
				onyes : true,
				icon : "../images/info.png"
			});
		 $("#username").focus();
		 return;
	 }
	 if(isEmpty("password")){
		 ds.dialog({
				title : '消息提示',
				content : "请输入登录密码！",
				onyes : true,
				icon : "../images/info.png"
			});
		 $("#password").focus();
		 return;
	 }

	 loading_juggle();
	$.ajax( {
		type : 'POST',
	   	data : {
	   		userName:userName,
	   		userPassword:userPassword
		},  
		dataType : "json",
		url : "<%=basePath%>usermanagement/login.html",
			//请求的action路径
			error : function() { //请求失败处理函数
				 ds.dialog({
						title : '消息提示',
						content : "请求失败，请联系管理员！",
						onyes : true,
						icon : "../images/info.png"
					});
				cancel_loading();
				 return;
			},
			success : function(data) { //请求成功后处理函数。 
				if(data.returnCode==200){
					 
					 if($("#rem").css("right")=="0px"){
						 setCookie('username',userName,7);
						 setCookie('userpwd',userPassword,7); 
					 }else{
						 setCookie('username',"",7);
						 setCookie('userpwd',"",7); 
					 }
					window.location.href = "<%=basePath%>management.html";
			} else {
				 ds.dialog({
						title : '消息提示',
						content : data.returnMessage,
						onyes : true,
						icon : "../images/info.png"
					});
				 
				 $("#username").val("");
				 $("#password").val("")
				 $(".back").focus();
					cancel_loading();
				 return;
			}
		}
	}); 
}

function getCookie(c_name) {
	if (document.cookie.length > 0) {
		c_start = document.cookie.indexOf(c_name + "=");
		if (c_start != -1) {
			c_start = c_start + c_name.length + 1;
			c_end = document.cookie.indexOf(";", c_start);
			if (c_end == -1)
				c_end = document.cookie.length;
			return unescape(document.cookie.substring(c_start, c_end));
		}
	}
	return "";
}

function setCookie(c_name, value, expiredays) {
	var exdate = new Date();
	exdate.setDate(exdate.getDate() + expiredays);
	document.cookie = c_name
			+ "="
			+ escape(value)
			+ ((expiredays == null) ? "" : ";expires="
					+ exdate.toGMTString());
}

function checkCookie() {

	var username = getCookie('username');
	var userpwd = getCookie('userpwd');

	if (username != null && username != "" && userpwd != null
			&& userpwd != "") {
		document.getElementById("username").value = username;
		document.getElementById("password").value = userpwd;
		$("#rem").css("right", "0");
		$('.check')
				.css('background',
						' url(${pageContext.request.contextPath}/images/check_on.png)');
	} else {
		return null;
	}
}
function clearCookie() {

	setCookie('username', "", 7);
	setCookie('userpwd', "", 7);
}

</script>
<body>
	<div class="back">
		<ul class="bg">
			<li><img src="${pageContext.request.contextPath}/images/1.jpg"
				alt=""></li>
			<li><img src="${pageContext.request.contextPath}/images/2.jpg"
				alt=""></li>
			<li><img src="${pageContext.request.contextPath}/images/3.jpg"
				alt=""></li>
			<li><img src="${pageContext.request.contextPath}/images/4.jpg"
				alt=""></li>
			<li><img src="${pageContext.request.contextPath}/images/5.jpg"
				alt=""></li>
		</ul>
		<div class="login">
			<div class="header">
				<div>
					<img src="${pageContext.request.contextPath}/images/logo.png" />
				</div>
				<div class="header_name">
					<img src="${pageContext.request.contextPath}/images/logo_name.png" />
				</div>
			</div>
			<div class="shuru">
				<div class="name">
					<div class="icon"></div>
					<input id="username" type="text" onchange="clearCookie()">
				</div>
				<div class="pwd">
					<div class="icon"></div>
					<input id="password" type="password" onchange="clearCookie()">
					<div class="icon_go">
						<button onclick="userlogin()">&nbsp;</button>
					</div>
				</div>

				<div class="remb">
					<div class="check">
						<div id="rem" class="check_btn"></div>
					</div>
					<div class="lable">记住密码</div>
				</div>
			</div>
			<div class="foot">
				<div>
					<img src="${pageContext.request.contextPath}/images/foot_imess.png" />
				</div>
				<div class="foot_right">
					<a id="rapid_judge_register" href="${pageContext.request.contextPath}/judgemanagement/register.html"></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>