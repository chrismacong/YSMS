<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>比赛结果</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/wechat.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script type="text/javascript">
	$(function() {
		$(".gamelistitem").click(function(){
			var games_id = $(this).attr("id").split("_")[1];
			window.location.href = "${pageContext.request.contextPath}/wechat/game.html?games_id=" + games_id;
		});
	});
</script>
<body>
	<div class="bg">
		<img src="../images/bg2.jpg" />
	</div>
	<div class="container">
		<c:forEach items="${games}" var="xx" varStatus="loop">
			<div class="gamelistitem" id="game_${xx.gamesId}">
				<h2>${xx.gameTime}&nbsp;&nbsp;${xx.gameLocation}</h2>
				<h1>${xx.hostSchoolName}&nbsp;VS&nbsp;${xx.guestSchoolName}</h1>
			</div>
		</c:forEach>
	</div>
</body>
</html>
