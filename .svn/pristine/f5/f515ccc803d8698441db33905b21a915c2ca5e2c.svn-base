<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dialog.css">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui-1.8.16.custom.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/league.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ui.datepicker-zh-CN.js"></script>
	<script src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<title>联赛报名</title>
<style type="text/css">
.tbody_sroll {
    height: 572px;
}
.table_head_left {
	cursor: pointer;
	background: #127419;
}
.add_liansai {
	position: absolute;
	top: 70px;
	left: 250px;
	padding: 20px;
	background: #fff;
	border: 1px solid #0fd46c;
	border-radius: 10px;
}
</style>
<script type="text/javascript">
	var leagueList = null;
	var year;
	$(function() {
		path="${pageContext.request.contextPath}";
		year = parseInt($("#year_div").html());
		load();
		loadLeagueList();
	});
	//加载初始化信息
	function load() {
		$("#league_year_l").click(function() {
			//var year = parseInt($("#year_div").html());
			year--;
			$("#year_div").html(year);
			loadLeagueList();
		});
		$("#league_year_r").click(function() {
			//var year = parseInt($("#year_div").html());
			year++;
			$("#year_div").html(year);
			loadLeagueList();
		});
		$('.table_head_left').click(function() {
			$('.add_liansai').show();
		})
		$('.close').click(function() {
			$('.add_liansai').hide();
		})
	}
	function loadLeagueList() {
		var year = parseInt($("#year_div").html());
		loading_juggle_empty();
		$.ajax({
			type : 'POST',
			url : "${pageContext.request.contextPath}/signup/leaguesbyyear.html",
			data : {
				year : year
			},
			dataType : "json",
			success : function(data) {
				if (data != null) {
					leagueList = data.league_list;
					// 加载联赛列表
					loadLeagues();
				} else {
					ds.dialog({
						title : '消息提示',
						content : "查询联赛信息失败！",
						onyes : true,
						icon : "../images/info.png"
					});
				}
				cancel_loading();
			},
			error : function() {
				ds.dialog({
					title : '消息提示',
					content : "查询联赛信息失败！",
					onyes : true,
					icon : "../images/info.png"
				});
				cancel_loading();
			}
		});

	}
	function loadLeagues() {
		$("#league_details").empty();
		if (leagueList != null && leagueList.length > 0) {
			$.each(leagueList, function(i, league) {
				if (league != null && league != "") {
					$("#league_details").append(
							"<tr id='league_" + league.leagueId + "'>"
									+ "<td width='90px'>" + (i + 1) + "</td>"
									+ "<td width='290px'>" + league.leagueName + "</td>"
									+ "<td width='190px'>"
									+ league.registerStartDate + "</td>"
									+ "<td width='190px'>"
									+ league.registerEndDate + "</td>"
									+ "<td width='100px' class='state'>"
									+ league.leagueStatus + "</td>"
									+ "<td width='188px'><a href='javascript:edit(" + league.leagueId + ");'>进入联赛...</a>"
									+ "</tr>");
				}
			});
		}
	}
	function edit(league_id) {
		window.location.href="${pageContext.request.contextPath}/signup/zonesbyleague.html?league_id=" + league_id;
	}
</script>
</head>
<body>
	<div class="neirong_wk">


		<!--联赛查看-->
		<div class="league_list_year">
			<div id="league_year_l" class="league_list_l unselectable"></div>
			<div id="year_div" class="league_list_m unselectable">${year}</div>
			<div id="league_year_r" class="league_list_r unselectable"></div>
		</div>
		<table class="unselectable" id="league_list" cellpadding="0"
			cellspacing="0">
			<thead>
				<tr>
					<td width='90px'><div class="table_head_left">联赛</div></td>
					<td width='300px'>联赛名称</td>
					<td width='190px'>报名时间</td>
					<td width='190px'>截止时间</td>
					<td width='100px'>状态</td>
					<td width='188px'></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="8" style="border-bottom-width:0px;">
						<div class="tbody_sroll">
							<table id="league_details" cellpadding="0" cellspacing="0"
								width='100%'>
							</table>
						</div>
					</td>
				</tr>

			</tbody>
		</table>
		<!--联赛查看-->

		<!-- 分页 -->
		<div id="paging" class="choose_bottom">
			<div class="choose_btn_delete"></div>
		</div>
		<!-- 分页 -->
	</div>
</body>
</html>