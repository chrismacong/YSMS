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
		$("#news_verify_btn").click(function(){
			$("#news_frame").attr("src", "${pageContext.request.contextPath}/newsmanagement/newslistforverify.html");
		});
		$("#service_news_verify_btn").click(function(){
			$("#news_frame").attr("src", "${pageContext.request.contextPath}/newsmanagement/servicenewslistforverify.html");
		});
	});
</script>
<title>新闻管理</title>
</head>
<body>
		<div class="operation ">
		<ul class="a_athlete">
			<li id="news_verify_btn" class="border_bo"><div>
					<img src="${pageContext.request.contextPath}/images/a_revise.png" />
				</div>
				<p>订阅号审核</p></li>
			<li id="service_news_verify_btn"><div>
					<img src="${pageContext.request.contextPath}/images/a_revise.png" />
				</div>
				<p>服务号审核</p></li>
		</ul>
	</div>
	<div></div>
	<iframe id="news_frame" class="main_content" frameborder="0"
		src="${pageContext.request.contextPath}/newsmanagement/newslistforverify.html">
	</iframe>
</body>
</html>
