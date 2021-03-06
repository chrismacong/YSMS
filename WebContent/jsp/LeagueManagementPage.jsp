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
<title>联赛管理</title>
<style type="text/css">
html{
	overflow-x:hidden;
}

.neirong_wk {
	height: 655px;
}

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

.liansai_info {
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
		loadLeagueList();
		load();
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
			$("#name_input").val("");
			$("#start_register_time").val("");
			$("#end_register_time").val("");
		})
		$("#create_btn").click(function(){
			var league_name = $("#name_input").val();
			var register_start_time = $("#start_register_time").val();
			var register_end_time = $("#end_register_time").val();
			if(league_name=="")
				ds.dialog({
					title : '消息提示',
					content : "联赛名称不得为空！",
					onyes : true,
					icon : "../images/info.png"
				});
			else if(register_start_time=="" || register_end_time=="")
				ds.dialog({
					title : '消息提示',
					content : "报名开始时间和截止时间不得为空",
					onyes : true,
					icon : "../images/info.png"
				});
			else if(register_start_time>register_end_time)
				
				ds.dialog({
					title : '消息提示',
					content : "报名截止日期不得早于报名开始时间！",
					onyes : true,
					icon : "../images/info.png"
				});
			else if(parseInt(register_start_time.split("-")[0])>year)
				ds.dialog({
					title : '消息提示',
					content : "报名开始时间不得晚于联赛所在年份！",
					onyes : true,
					icon : "../images/info.png"
				});
			else if(parseInt(register_end_time.split("-")[0])>year)
				ds.dialog({
					title : '消息提示',
					content : "报名截止时间不得晚于联赛所在年份！",
					onyes : true,
					icon : "../images/info.png"
				});
			else{
				$.ajax({
					type : 'POST',
					url : "${pageContext.request.contextPath}/league/addleague.html",
					data : {
						year : year,
						name : league_name,
						start_date : register_start_time,
						end_date : register_end_time
					},
					dataType : "json",
					success : function(data) {
						if (data != null) {
							// 加载联赛列表
							loadLeagueList();
						} else {
							ds.dialog({
								title : '消息提示',
								content : "添加联赛失败！",
								onyes : true,
								icon : "../images/info.png"
							});
						}
					},
					error : function() {
						ds.dialog({
							title : '消息提示',
							content : "添加联赛失败！",
							onyes : true,
							icon : "../images/info.png"
						});
					}
				});
				$('.add_liansai').hide();
				$("#name_input").val("");
				$("#start_register_time").val("");
				$("#end_register_time").val("");
			}
		})
		$("#start_register_time").datepicker();
		$("#end_register_time").datepicker();
	}
	function loadLeagueList() {
		var year = parseInt($("#year_div").html());
		loading_juggle_empty();
		$.ajax({
			type : 'POST',
			url : "${pageContext.request.contextPath}/league/leaguesbyyear.html",
			data : {
				year : year
			},
			dataType : "json",
			success : function(data) {
				if (data != null) {
					leagueList = data.league_list;
					// 加载联赛列表
					loadLeagues();
					cancel_loading();
				} else {
					ds.dialog({
						title : '消息提示',
						content : "查询联赛信息失败！",
						onyes : true,
						icon : "../images/info.png"
					});
					cancel_loading();
				}
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
									+ "<td width='290px'><a href='javascript:void(0)' onclick='showinfo(this)'>" + league.leagueName
									+ "</a></td>"
									+ "<td width='120px' class='state'>"
									+ league.leagueStatus + "</td>"
									+ "<td width='220px'>"
									+ league.registerStartDate + "</td>"
									+ "<td width='220px'>"
									+ league.registerEndDate + "</td>"
									+ "<td width='118px'><img class='edit'"
									+ "src='images/list_edit_btn.png'"
									+ "alt='修改' onclick='edit(this);' />"
									+ "</td></tr>");
				}
			});
		}
	}

	function infoClose(){
		$('.liansai_info').hide();
	}
	function edit(obj) {
		var leagueId = $(obj).parent().parent().attr("id").split("_")[1];
		$('#ui-datepicker-div').remove();
		window.location.href = "${pageContext.request.contextPath}/league/leaguebyid.html?league_id=" + leagueId;
	}

	function createInput(ty, value, name, obj) {
		$('<input />', {
			type : ty,
			val : value,
			name : name
		}).appendTo(obj);
	}

	function createSelect(name, val1, text1, val2, text2, obj, text) {
		var slt = $('<select />', {
			name : name
		});
		$('<option />', {
			val : val1,
			text : text1,
			selected : "selected" //应该是值为text的被选中。。。。
		}).appendTo(slt);
		$('<option>', {
			val : val2,
			text : text2
		}).appendTo(slt);
		slt.appendTo(obj)
	}
	function showinfo(obj){
		var leagueId = $(obj).parent().parent().attr("id").split("_")[1];
		$.ajax({
			type : 'POST',
			url : "${pageContext.request.contextPath}/league/getleagueinfo.html",
			data : {
				league_id : leagueId
			},
			dataType : "json",
			success : function(data) {
				if(data!=null){
					$(".liansai_info").empty();
					var html = "";
					html += "<div class='neirong' id='info_neirong'><div class='close' onclick='infoClose()'></div>";
					html += "<h1>" + data.league_name + "</h1><br/>";
					html += "<div>" + data.during_time + "</div><br/>";
					html += "<div>" + data.league_description + "</div></div>";
					$(".liansai_info").append(html);
					$(".liansai_info").show();
				}
			},
			error : function() {
			}
		});
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
					<td width='90px'><div class="table_head_left green">创建联赛</div></td>
					<td width='290px'>联赛名称</td>
					<td width='120px'>状态</td>
					<td width='220px'>报名时间</td>
					<td width='220px'>截止时间</td>
					<td width='118px'></td>
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
		<div id="paging" class="choose_bottom">
				<div class="choose_btn_delete"></div>
			</div>
		<!--联赛查看-->

		<div class="liansai_info" style="display: none">
		</div>
		<!--创建联赛-->
		<div class="add_liansai" style="display: none">
			<div class="neirong">
				<div class="close"></div>
				<table id="league_add" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td>联赛名称：</td>
							<td>
								<div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<input id="name_input" type="text" class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>开始报名时间：</td>
							<td>
								<div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<input class="input_text" readonly="readonly" type="text" id="start_register_time">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>截止报名时间：</td>
							<td>
								<div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<input class="input_text" readonly="readonly" type="text" id="end_register_time">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="btn_wk">
									<div class="btn_l btn_l_a_green"></div>
									<div class="btn_m btn_m_a_green">
										<input type="button" class="input_btn" id="create_btn"
											style="background:none" value="创建联赛">
									</div>
									<div class="btn_r btn_r_a_green"></div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!--创建联赛 END-->
	</div>
</body>
</html>