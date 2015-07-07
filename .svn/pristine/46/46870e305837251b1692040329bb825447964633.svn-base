<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui-1.8.16.custom.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/athlete.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script language="javascript" type="text/javascript">
	$(function() {
		path="${pageContext.request.contextPath}";
		$("#register_op_btn").click(function(){
			$("#athlete_frame").attr("src", 
					"${pageContext.request.contextPath}/athletemanagement/registerathlete.html");
		});
		$("#list_op_btn").click(function(){
			$("#athlete_frame").attr("src", "${pageContext.request.contextPath}/athletemanagement/listathlete.html");
		});
	});
</script>
<title>运动员管理</title>
</head>
<body>
	<div class="operation">
		<ul class="a_athlete">
			<li id="register_op_btn" class="border_bo"><div>
					<img
						src="${pageContext.request.contextPath}/images/add_athlete.png" />
				</div>
				<p>运动员注册</p></li>
			<li id="list_op_btn"><div>
					<img
						src="${pageContext.request.contextPath}/images/list_athlete.png" />
				</div>
				<p>运动员列表</p></li>
		</ul>
	</div>
	<div></div>
	<iframe id="athlete_frame" class="main_content" frameborder="0"
		src="${pageContext.request.contextPath}/athletemanagement/registerathlete.html">
	</iframe>
</body>
</html>