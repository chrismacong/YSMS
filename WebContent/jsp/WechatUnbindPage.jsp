<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>绑定用户信息</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link href="${pageContext.request.contextPath}/css/info_css.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script><!--JQ库-->
	<!--解决IE9以下浏览器不支持html5的问题-->
	<!--[if lt IE 9]>
  	   <script src="bootstrap-3.2.0-dist/js/html5.js"></script>
	<![endif]-->
</head>
<body>
	<div class="header">
		<div></div>
		<div>南京少年足球管理平台</div>
		<div></div>
	</div>
	<div class="title">我的信息</div>
	<div class="info">
		<table >
			<tr>
				<td width="30%">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
				<td>${athlete.getIdentifiedName()}</td>
			</tr>
			<tr>
				<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
				<td>
					<c:if test="${athlete.getIdentifiedGender()==0}">女</c:if>
					<c:if test="${athlete.getIdentifiedGender()==1}">男</c:if>
				</td>
			</tr>
			<tr>
				<td>民&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;族:</td>
				<td>${athlete.getIdentifiedNationality()}</td>
			</tr>
			<tr>
				<td>出生日期:</td>
				<td>${athlete.getIdentifiedBirthday()}</td>
			</tr>
			<tr>
				<td>身份证号:</td>
				<td>${athlete.getIdentifiedId()}</td>
			</tr>
			
		</table>
	</div>
	<div class="form_div2 info">
		<table >
			<tr>
				<td width="30%">身&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;高:</td>
				<td>${athlete.getAthleteHeight()}cm</td>
			</tr>
			<tr>
				<td>体&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;重:</td>
				<td>${athlete.getAthleteWeight()}kg</td>
			</tr>
			<tr>
				<td>鞋&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
				<td>${athlete.getAthleteFootsize()}码</td>
			</tr>
		</table>
		<input id="unbind_btn" type="button" value="取&nbsp;消&nbsp;绑&nbsp;定">
	</div>

</body>
<script type="text/javascript">
$(function(){
	$("#unbind_btn").click(function(){
		$.ajax({
			"type" : "GET",
			"contentType" : "application/json",
			"url" : "${pageContext.request.contextPath}/wechat/unbinduser.html",
			"dataType" : "json",
			"data" : {
				open_id : "${open_id}"
			}, //以json格式传递   
			"success" : function(data) {
				if(data.success){
					alert("解除绑定成功");//此处应跳转至信息及解除绑定页
					window.location.href = "${pageContext.request.contextPath}/wechat/bind.html?open_id=${open_id}"
				}
				else{
					alert("解除绑定失败， 您的信息验证失败，请检查！");
				}
			}
		});
	})
})
</script>
</html>