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
	href="${pageContext.request.contextPath}/css/zone.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/Duang.js"></script>
<title>组别管理</title>
<script language="javascript" type="text/javascript">
	var leagueId = "${league_id}";
	$(function() {
		path="${pageContext.request.contextPath}";
		$("#menubtn_back").click(function(){
			window.location.href = "${pageContext.request.contextPath}/league/leaguebyid.html?league_id=" + leagueId;
		});
	});
	
	
	function lxfz(){
		 $("#zone_frame").attr("src","${pageContext.request.contextPath}/league/lsfz.html?leagueId="+leagueId+"");
	}
	
	function ybmqd(){
		 $("#zone_frame").attr("src","${pageContext.request.contextPath}/jsp/SignedTeamListPage.jsp");
	}
	
	function jfpm(){
		$("#zone_frame").attr("src","${pageContext.request.contextPath}/league/jfpm.html");
	}
</script>

</head>
<body>
	<div class="operation">
		<ul class="a_zone">
			<li id="menubtn_back"><div>
					<img src="../images/a_fanhui.png" />
				</div>
				<p>组别列表</p></li>
			<li id="menubtn_league" onclick="ybmqd()" class="border_bo"><div>
					<img src="../images/a_team.png" />
				</div>
				<p>已报名球队</p></li>
			<li id="menubtn_zone" onclick="lxfz()"><div>
					<img src="../images/a_groupmng.png" />
				</div>
				<p>联赛分组</p></li>
			<li id="menubtn_rank" onclick="jfpm()"><div>
					<img src="../images/a_league.png" />
				</div>
				<p>积分排名</p></li>
		</ul>
	</div>
	<div></div>
	<iframe id="zone_frame" class="main_content" style="height:575px;"
		src="${pageContext.request.contextPath}/jsp/SignedTeamListPage.jsp">
	</iframe>
</body>
</html>