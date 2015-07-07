<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>修改信息</title>
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
	<div class="title">基本信息</div>
	<div class="info">
		<table width="100%">
			<tr>
				<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
				<td>${athlete.getIdentifiedName()}</td>
			</tr>
			<tr>
				<td>身份证号:</td>
				<td>${athlete.getIdentifiedId()}</td>
			</tr>
			<tr>
				<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</td>
				<td><c:if test="${athlete.getIdentifiedGender()==0}">女</c:if>
					<c:if test="${athlete.getIdentifiedGender()==1}">男</c:if></td>
			</tr>
		</table>
	</div>
	<div class="form_div2 ">
		<form>
			<input id="height" type="text" value="${athlete.getAthleteHeight()}" onkeyup="value=value.replace(/[^\d]/g,'')"><span>(cm)</span>
			<input id="weight" type="text" value="${athlete.getAthleteWeight()}" onkeyup="value=value.replace(/[^\d]/g,'')"><span>(kg)</span>
			<input id="shoe_size" type="number" min="23" max="44" value="${athlete.getAthleteFootsize()}" onblur="onfootsizeblur(this)" alt='鞋码' onkeyup="value=value.replace(/[^\d]/g,'')"><span>(砝码)</span>
			<input id="modify_btn" type="button" value="修&nbsp;&nbsp;&nbsp;改">
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$("#modify_btn").click(function(){
			var athlete_height = $("#height").val();
			var athlete_weight = $("#weight").val();
			var athlete_footsize = $("#shoe_size").val();
			$.ajax({
				"type" : "GET",
				"contentType" : "application/json",
				"url" : "${pageContext.request.contextPath}/wechat/modifyuserinfo.html",
				"dataType" : "json",
				"data" : {
					athlete_id : "${athlete.getAthleteId()}",
					athlete_height : athlete_height,
					athlete_weight : athlete_weight,
					athlete_footsize : athlete_footsize
				}, //以json格式传递   
				"success" : function(data) {
					if(data.success){
						alert("修改信息成功");
					}
					else{
						alert("修改信息失败");
					}
				}
			});
		})
	})
	function onfootsizeblur(obj){
		var value = $(obj).val();
		if(value>44)
			$(obj).val("44");
		else if(value<23){
			$(obj).val("23");
		}
	}
</script>
</html>