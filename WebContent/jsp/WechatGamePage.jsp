<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>比赛预告</title>
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/wechat.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/Duang.js"></script>

<!--JQ库-->
<script type="text/javascript">
	$(function() {
		getData();
	});
	function getData() {
		loading_juggle_empty_small();
		$.ajax({
			"type" : "GET",
			"contentType" : "application/json",
			"url" : "${pageContext.request.contextPath}/wechat/getnextgame.html",
			"dataType" : "json",
			"data" : {
				athlete_id : "${athlete_id}"
			}, //以json格式传递   
			"success" : function(data) {
				if(data.game!=null){
					$(".matchtime").text(data.game.gameTime + " " + data.game.gameLocation);
					$(".leaguename").text(data.game.leagueName);
					$(".matchlevel").text(data.game.zoneName + " " + data.game.orderName);
					var hostScore = data.game.hostScore;
					var guestScore = data.game.guestScore;
					if(hostScore==null)
						hostScore = "--";
					if(guestScore==null)
						guestScore = "--";
					$(".hostscore").text(hostScore);
					$(".guestscore").text(guestScore);
					$(".hostschoolname").text(data.game.hostSchoolName);
					$(".guestschoolname").text(data.game.guestSchoolName);
					$("#hostteamname").text(data.game.hostTeamName);
					$("#guestteamname").text(data.game.guestTeamName);
					document.title="比赛预告：" + data.game.gameTime + " "+ data.game.hostSchoolName + " VS " + data.game.guestSchoolName;
				}
				cancel_loading();
			}
		});
	}
</script>
</head>
<body>
	<div class="bg">
		<img src="../images/bg2.jpg" />
	</div>
	<div class="container">
		<!--打比分-->
		<div class="bifen">
			<div class="logo_wk">
				<div class="logo"></div>
				<p class="hostschoolname"></p>
				<p id="hostteamname"></p>
			</div>
			<div class="num hostscore">--</div>
			<div class="vs">
				<img src="../images/vs.png" />
			</div>
			<div class="num guestscore">--</div>
			<div class="logo_wk">
				<div class="logo"></div>
				<p class="guestschoolname"></p>
				<p id="guestteamname"></p>
			</div>
		</div>

		<div class="name">
			<div class="matchlevel"></div>
			<div class="leaguename"></div>
			<div class="matchtime"></div>
		</div>


		<div class="bottom">
			<div>
				<i></i>
				<p>南京市校园足球管理平台</p>
				<i></i>
			</div>
		</div>
	</div>
</body>
</html>