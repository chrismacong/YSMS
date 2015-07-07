<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联赛分组</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dialog.css">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath}/css/league.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath}/css/leaguegroup.css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
</head>
<body>
	<div class="div_main">
		<div class="div_coachconfig_content">
			<div id="div_coach" class="div_configlist">
				<div style="float:left;">
					<img src="${pageContext.request.contextPath}/images/list_coach.png" class="img_configlist_titleico">
				</div>
				<div style="float:left;">联赛队伍选择</div>
			</div>
			<div id="div_coachlist" class="div_configlist_content">
				<div class="div_configlist_content_left">
					<div class="div_configlist_content_left_top">
						<select id="sltSearchTeamType" class="select_searchtype">
							<option value="0">请选择搜索类型</option>
							<option value="1">按球队名称搜索</option>
							<option value="2">按球队所属学校搜索</option>
						</select>
						<input id="txtSearchTeam" type="text" class="input_text_search">
						<input type="button" class="input_button_search" value="搜  索" onclick="btnSearch()">
					</div>
					<div style="width:100%;height:350px;">
						<table border="0" cellpadding="0" cellspacing="0" class="table_configlist_title">
							<tr>
								<td width="260px" style="background:#127419">球队名称</td>
								<td width="160px">球队所属学校</td>
							</tr>
						</table>
						<div class="div_configlist_contentlist">
							<table id="tb_teamlist" border="0" cellpadding="0" cellspacing="0" style="width:100%;">

							</table>
						</div>
					</div>
				</div>
				<div class="div_configlist_content_center">
					<p style="margin-top:50px;text-align: center;"> 
						<input type="button" value="添 加" class="input_button_addremove" onclick="addTeam()" />
					</p>
					<p style="margin-top:20px;text-align: center;">
						<input type="button" value="移 除" class="input_button_addremove" onclick="removeTeam()" />
					</p>
				</div>
				<div class="div_configlist_content_left">
					<p class="p_chooselist_title">球队列表(<label id="lbchooseteam"></label>/${team})：</p>
					<table border="0" cellpadding="0" cellspacing="0" class="table_configchooselist_title">
						<tr>
							<td width='240px' style="background:#160b2d">球队名称</td>
							<td width='160px'>球队所属学校</td>
						</tr>
					</table>
					<div class="div_configchooselist_contentlist">
						<table id="tb_chooseteamlist" border="0" cellpadding="0" cellspacing="0" style="width:100%;">

						</table>
					</div>
				</div>
			</div>
		</div>
		<p class="p_bottom">
			<input type="button" value="下一步" class="input_button_okreset" onclick="">
			<input type="button" value="重 置" class="input_button_okreset" style="margin-right:20px;" onclick="btnReset()">
		</p>
	</div>
	<script type="text/javascript">
		var team_list = null;
		var team_chooselist = null;
		var team = "${team}";
	
		$(function(){
			path="${pageContext.request.contextPath}";
			addEvent();
			loadInfo();
		});
		
		// 绑定事件
		function addEvent(){
			
		}
		
		// 发送获取数据请求并加载数据
		function loadInfo(){
			$.ajax({
				type : 'POST',
				url : "${pageContext.request.contextPath}/league/getteamlistbyleagueid.html",
				data : {
					league_id : "${leagueId}",
				},
				dataType : "json",
				success : function(data) {
					if (data != null) {
						team_list = data.team_list;
						team_chooselist = data.team_chooselist;
						$("#lbchooseteam").html(team_chooselist.length);
						// 加载信息列表
						loadList();
					} else {
						ds.dialog({
							title : '消息提示',
							content : "加载信息失败！",
							onyes : true,
							icon : "../../images/info.png"
						});
					}
				},
				error : function() {
					ds.dialog({
						title : '消息提示',
						content : "加载信息失败！",
						onyes : true,
						icon : "../../images/info.png"
					});
				}
			});
		}
		
		// 加载信息列表
		function loadList(){
			// 加载球队列表
			loadTeamList();
			// 加载已选择球队列表 
			loadTeamChooseList();
		}
		
		// 加载球队列表
		function loadTeamList(){
			$("#tb_teamlist").empty();
			if(team_list != null && team_list.length > 0){
				$.each(team_list, function(i, team){
					if(team != null){
						if(!isTeamSelected(team.teamId)){
							var schoolName = team.ysmsSchool == null ? "---" : team.ysmsSchool.schoolName;
							$("#tb_teamlist")
								.append('<tr>' +
											'<td width="50px" style="max-width:50px;" class="td_firsttd_content">' + 
												'<input id="t' + team.teamId + '" class="checkbox_style" type="checkbox">' +
											'</td>' +
											'<td width="210px" style="max-width:210px;">' + team.teamName + '</td>' +
											'<td width="160px" style="max-width:160px;">' + schoolName + '</td>' +
										'</tr>');
						}
					}
				});
			}
		}
		
		// 加载已选择球队列表 
		function loadTeamChooseList(){
			$("#tb_chooseteamlist").empty();
			if(team_chooselist != null && team_chooselist.length > 0){
				$.each(team_chooselist, function(i, team){
					if(team != null){
						var schoolName = team.ysmsSchool == null ? "---" : team.ysmsSchool.schoolName;
						$("#tb_chooseteamlist")
							.append('<tr>' +
										'<td width="50px" style="max-width:50px;" class="td_firstchoostd_content">' + 
											'<input id="tc' + team.teamId + '" class="checkbox_style" type="checkbox">' +
										'</td>' +
										'<td width="190px" style="max-width:210px;">' + team.teamName + '</td>' +
										'<td width="160px" style="max-width:160px;">' + schoolName + '</td>' +
									'</tr>');
					}
				});
			}
		}
		
		// 判断球队是否已经被选择到联赛中
		function isTeamSelected(id){
			var flag = false;
			if(team_chooselist != null && team_chooselist.length > 0){
				$.each(team_chooselist, function(i, team){
					if(team.teamId == id){
						flag = true;
					}
				});
			}
			return flag;
		}
		
		// 添加参加联赛的球队
		function addTeam(){
			var count = $("#tb_teamlist input[class='checkbox_style']:checked").length;
			if(count < 1){
				ds.dialog({
					title : '消息提示',
					content : "请在左侧列表选择需要添加的球队！",
					onyes : true,
					icon : "../../images/info.png"
				});
			}
			else{
				var selectCount = $("#tb_chooseteamlist tr").length;
				var totalCount = count + selectCount;
				if(totalCount > team){
					ds.dialog({
						title : '消息提示',
						content : "参赛球队总数大于" + team + "支",
						onyes : true,
						icon : "../../images/info.png"
					});
				}
				else{
					$("#tb_teamlist input[class='checkbox_style']:checked").each(function(){
						var idStr = $(this).attr("id");
						if(idStr != null && idStr != ""){
							idStr = idStr + "";
							var id = idStr.substr(1);
							if(!isTeamExist("tc" + id)){
								var selectTeam = getTeamById(id);
								// 右侧列表中添加
								if(selectTeam != null){
									var schoolName = selectTeam.ysmsSchool == null ? "---" : selectTeam.ysmsSchool.schoolName;
									$("#tb_chooseteamlist")
										.append('<tr>' +
													'<td width="50px" style="max-width:50px;" class="td_firstchoostd_content">' + 
														'<input id="tc' + selectTeam.teamId + '" class="checkbox_style" type="checkbox">' +
													'</td>' +
													'<td width="190px" style="max-width:210px;">' + selectTeam.teamName + '</td>' +
													'<td width="160px" style="max-width:160px;">' + schoolName + '</td>' +
												'</tr>');
								}
							}
							else{
								var selectTeam = getTeamById(id);
								if(selectTeam != null){
									ds.dialog({
										title : '消息提示',
										content : "球队" + selectTeam.teamName + "已经添加到联赛中！",
										onyes : true,
										icon : "../../images/info.png"
									});
								}
								
							}
						}
					});
				}
				
				$("#lbchooseteam").html($("#tb_chooseteamlist tr").length);
			}
		}
		
		// 将球队从联赛中移除
		function removeTeam(){
			var count = $("#tb_chooseteamlist input[class='checkbox_style']:checked").length;
			if(count < 1){
				ds.dialog({
					title : '消息提示',
					content : "请在右侧列表选择需要移除的球队！",
					onyes : true,
					icon : "../../images/info.png"
				});
			}
			else{
				$("#tb_chooseteamlist input[class='checkbox_style']:checked").each(function(){
					var idStr = $(this).attr("id");
					if(idStr != null && idStr != ""){
						// 左侧列表中移除
						$(this).parent().parent("tr").remove();
					}
				});
				
				$("#lbchooseteam").html($("#tb_chooseteamlist tr").length);
			}
		}
		
		// 根据ID获取获取对应球队信息
		function getTeamById(id){
			var teamInfo = null;
			if(team_list != null && team_list.length > 0){
				$.each(team_list, function(i, team){
					if(team.teamId == id){
						teamInfo = team;
					}
				});
			}
			return teamInfo;
		}
		
		function isTeamExist(id){
			var flag = false;
			
			if($("#tb_chooseteamlist input[type='checkbox']").length > 0){
				$("#tb_chooseteamlist input[type='checkbox']").each(function(){
					var idstr = $(this).attr("id");
					if(idstr == id){
						flag = true;
					}
				});
			}
			
			return flag;
		}
		
		// 重置队伍分组
		function btnReset(){
			ds.dialog({
				title : '消息提示',
				content : "确定要重置队伍分组马？",
				yesText : "确定",
				onyes : function() {
					$("#league_group").load("${pageContext.request.contextPath}/league/leaguegroupfortype.html?league_id=${leagueId}");
				},
				noText : "取消",
				onno : function() {
					this.close();
				},
				icon : "../../images/confirm.png"
			});
			
			
		}
		
		// 搜索球队
		function btnSearch(){
			var type = $("#sltSearchTeamType").val();
			if(type == null || type == "" || type < 1){
				ds.dialog({
					title : '消息提示',
					content : "请选择搜索类型！",
					onyes : true,
					icon : "../../images/info.png"
				});
				return;
			}
			
			var key = $("#txtSearchTeam").val();
			$.ajax({
				type : 'POST',
				url : "${pageContext.request.contextPath}/league/getteamlistbyleagueidandkey.html",
				data : {
					league_id : "${leagueId}",
					key : key,
					type : type
				},
				dataType : "json",
				success : function(data) {
					if (data != null) {
						team_list = data.team_list;
						// 加载信息列表
						loadTeamList();
					} else {
						ds.dialog({
							title : '消息提示',
							content : "加载信息失败！",
							onyes : true,
							icon : "../../images/info.png"
						});
					}
				},
				error : function() {
					ds.dialog({
						title : '消息提示',
						content : "加载信息失败！",
						onyes : true,
						icon : "../../images/info.png"
					});
				}
			});
		}
	</script>
</body>
</html>