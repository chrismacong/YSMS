<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联赛分组</title>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<link type="text/css" href="${pageContext.request.contextPath}/css/leaguegroup.css" rel="stylesheet" />
</head>
<body>
	<div class="div_choose_leaguesystem">
		<table border="0" cellpadding="0" cellspacing="0" class="table_choose_leaguesystem">
			<tr>
				<td>
					<input id="type1" type="button" value="40支球队分8组" class="input_choose_leaguesystem"  />
				</td>
				<td>
					<input id="type2" type="button" value="32支球队分8组" class="input_choose_leaguesystem" />
				</td>
			</tr>
			<tr>
				<td>
					<input id="type3" type="button" value="20支球队分4组" class="input_choose_leaguesystem" />
				</td>
				<td>
					<input id="type4" type="button" value="16支球队分4组" class="input_choose_leaguesystem" />
				</td>
			</tr>
		</table>
	</div>
	<script type="text/javascript">
		$(function(){
			path="${pageContext.request.contextPath}";
			$(".input_choose_leaguesystem").click(function(){
				var id = $(this).attr("id");
				var team = 0;
				var group = 0;
				switch(id){
					case "type1":
						team = 40;
						group = 8;
						break;
					case "type2":
						team = 32;
						group = 8;
						break;
					case "type3":
						team = 20;
						group = 4;
						break;
					case "type4":
						team = 16;
						group = 4;
						break;
				}
				
				if(team != 0 && group != 0){
					$("#league_group").load("${pageContext.request.contextPath}/league/leaguegroupforteams.html?league_id=${leagueId}&team=" 
											+ team + "&group=" + group);
				}
			});
		});
	</script>
</body>
</html>