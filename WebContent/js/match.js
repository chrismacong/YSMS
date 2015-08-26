var selectedGameId;
var recordingGameId;
var hostSelectNumHtml = "<option id='host_num_0' value='0'></option>";
var guestSelectNumHtml = "<option id='guest_num_0' value='0'></option>";
var hostSelectNameHtml = "<option id='host_name_0' value='0'></option>";
var guestSelectNameHtml = "<option id='guest_name_0' value='0'></option>";
var selectedHostTeamId;
var selectedGuestTeamId;
$(function() {
	$('#time').datepicker();
	$('#search_time').datepicker();
	refresh_competitions()
	$('#add_competition').click(function() {
		$('#match_list').hide();
		$('#competition_apply').show();
	})
	$('#competition_liebiao').click(function() {
		refresh_competitions()
		$('#competition_apply').hide();
		$('#match_list').show();
	})
	$("#host_downloadteammemberlist").click(function(){
				window.location.href=forwardurl + "/team/exportpdf.html?team_id=" + selectedHostTeamId;
			});
			$("#guest_downloadteammemberlist").click(function(){
				window.location.href=forwardurl + "/team/exportpdf.html?team_id=" + selectedGuestTeamId;
			});
			$("#host_suspension").click(function(){
				loading_juggle_empty();
				$(".suspension_block").show();
				$("#suspension_table tbody").empty();
				$.ajax({
					type : 'POST',
					url : forwardurl+"/gamemanagement/suspension.html",
					data : {
						game_id : recordingGameId,
						team_id : selectedHostTeamId
					},
					dataType : "json",
					success : function(data) {
						if(data.length==0){
							$("#suspension_table tbody").append("<tr><td colspan='3' style='text-align:center'>无停赛记录</td></tr>");
						}
						else{
							$.each(data,function(i,item) {
								var html = "<tr>";
								html += "<td>" + item.playerNum + "</td>";
								html += "<td>" + item.playerName + "</td>";
								html += "<td>" + item.suspensionReason + "</td></tr>";
								$("#suspension_table tbody").append(html);
							});
						}
						cancel_loading();
					},
					error : function() {
						cancel_loading();
					}
				});
			})
			$("#guest_suspension").click(function(){
				loading_juggle_empty();
				$(".suspension_block").show();
				$("#suspension_table tbody").empty();
				$.ajax({
					type : 'POST',
					url : forwardurl+"/gamemanagement/suspension.html",
					data : {
						game_id : recordingGameId,
						team_id : selectedGuestTeamId
					},
					dataType : "json",
					success : function(data) {
						if(data.length==0){
							$("#suspension_table tbody").append("<tr><td colspan='3' style='text-align:center'>无停赛记录</td></tr>");
						}
						else{
							$.each(data,function(i,item) {
								var html = "<tr>";
								html += "<td>" + item.playerNum + "</td>";
								html += "<td>" + item.playerName + "</td>";
								html += "<td>" + item.suspensionReason + "</td></tr>";
								$("#suspension_table tbody").append(html);
							});
						}
						cancel_loading();
					},
					error : function() {
						cancel_loading();
					}
				});
			})
	//填写记录tab切换
	$('.tab_xijie span').click(
			function() {
				var this_parent = $(this).parents('.td_waikuang');
				$(this).addClass('span_tab').siblings().removeClass(
				'span_tab');
				if ($(this).index() == 1) {
					$(this_parent).find('.honghuangpai').show();
					$(this_parent).find('.personscore').hide();
					$(this_parent).find('.otherrecord').hide();
				} else if ($(this).index() == 0) {
					$(this_parent).find('.honghuangpai').hide();
					$(this_parent).find('.personscore').show();
					$(this_parent).find('.otherrecord').hide();
				} else if ($(this).index() == 2) {
					$(this_parent).find('.honghuangpai').hide();
					$(this_parent).find('.personscore').hide();
					$(this_parent).find('.otherrecord').show();
				}
			})
			//填写记录tab切换中的table的样式
			$('.fenlai_2 table ').find('tr:even').css('background', '#eee')

			$('.close').click(function() {
				$('.saishi_results').hide();
				$('.edit_match').hide();
			})
			
			$(".outerclose").click(function(){
				$(".suspension_block").hide();
			})

			$('#cancel_record').click(function() {
				$('.saishi_results').hide();
				$('.edit_match').hide();
			})

			$("#save_record").click(function() {
				var reg = new RegExp("^[0-9]{1,2}$");
				var host_score = $("#record_host_score").val();
				var guest_score = $("#record_guest_score").val();
				if (!reg.test(host_score) || !reg.test(guest_score)) {
					ds.dialog({
						title : '消息提示',
						content : "比赛得分必须为1~2位数字!",
						onyes : true,
						icon : "../images/info.png"
					});
					cancel_loading();
					return;
				}
				var host_goal = "";
				var guest_goal = "";
				var host_foul = "";
				var guest_foul = "";
				var every_goal_has_shooter = true;
				var every_goal_has_time = true;
				var every_foul_has_player = true;
				var every_foul_has_time = true;
				loading_juggle_empty();
				$("#host_goal_table tr").each(function() {
					$(this).find(".record_host_name_select").eq(0).each(function() {
						if ($(this).get(0).selectedIndex == 0) {
							every_goal_has_shooter = false;
						}
						host_goal = host_goal+ $(this).find("option:selected").attr("id").substring(10) + ","
						+ $(this).parent().next().next().find("option:selected").attr("id").substring(10) + ","
						+ $(this).parent().next().next().next().find("select").eq(0).val() + ","
						+ $(this).parent().next().next().next().next().find("input").eq(0).val()+ ";";
					})
					$(this).find(".goal_time").each(function() {
						var time = $(this).val();
						if (!reg.test(time))
							every_goal_has_time = false;
					})
				})
				$("#guest_goal_table tr").each(function() {
					$(this).find(".record_guest_name_select").eq(0).each(function() {
						if ($(this).get(0).selectedIndex == 0) {
							every_goal_has_shooter = false;
						}
						guest_goal = guest_goal + $(this).find("option:selected").attr("id").substring(11) + ","
						+ $(this).parent().next().next().find("option:selected").attr("id").substring(11) + ","
						+ $(this).parent().next().next().next().find("select").eq(0).val() + ","
						+ $(this).parent().next().next().next().next().find("input").eq(0).val() + ";";
					})
					$(this).find(".goal_time").each(function() {
						var time = $(this).val();
						if (!reg.test(time))
							every_goal_has_time = false;
					})
				})
				$("#host_foul_table tr").each(function() {
					$(this).find(".record_host_name_select").eq(0).each(function() {
						if ($(this).get(0).selectedIndex == 0) {
							every_foul_has_player = false;
						}
						host_foul = host_foul + $(this).find("option:selected").attr("id").substring(10) + ","
						+ $(this).parent().next().find("select").eq(0).val() + ","
						+ $(this).parent().next().next().find("input").eq(0).val() + ";";
					})
					$(this).find(".foul_time").each(function() {
						var time = $(this).val();
						if (!reg.test(time))
							every_foul_has_time = false;
					})
				})
				$("#guest_foul_table tr").each(function() {
					$(this).find(".record_guest_name_select").eq(0).each(function() {
						if ($(this).get(0).selectedIndex == 0) {
							very_foul_has_player = false;
						}
						guest_foul = guest_foul + $(this).find("option:selected").attr("id").substring(11) + ","
						+ $(this).parent().next().find("select").eq(0).val()+ ","
						+ $(this).parent().next().next().find("input").eq(0).val() + ";";
					})
					$(this).find(".foul_time").each(function() {
						var time = $(this).val();
						if (!reg.test(time))
							every_foul_has_time = false;
					})
				})
				if (!every_goal_has_shooter) {
					ds.dialog({
						title : '消息提示',
						content : "必须选择进球者!",
						onyes : true,
						icon : "../images/info.png"
					});
					cancel_loading();
					return;
				}
				if (!every_foul_has_player) {
					ds.dialog({
						title : '消息提示',
						content : "必须选择犯规人!",
						onyes : true,
						icon : "../images/info.png"
					});
					cancel_loading();
					return;
				}

				if (!every_goal_has_time || !every_foul_has_time) {
					ds.dialog({
						title : '消息提示',
						content : "必须以1~2位数字格式填写进球或红黄牌时间!",
						onyes : true,
						icon : "../images/info.png"
					});
					cancel_loading();
					return;
				}
				if (host_goal.length > 0) {
					host_goal = host_goal.substring(0,
							host_goal.length - 1);
				}
				if (guest_goal.length > 0) {
					guest_goal = guest_goal.substring(0,
							guest_goal.length - 1);
				}
				if (host_foul.length > 0) {
					host_foul = host_foul.substring(0,
							host_foul.length - 1);
				}
				if (guest_foul.length > 0) {
					guest_foul = guest_foul.substring(0,
							guest_foul.length - 1);
				}
				var isovertime_flag = $("#host_isovertime_flag").prop("checked")//主客队联动，所以是一样的
				var ispenalty_flag = $("#host_ispenalty_flag").prop("checked")//主客队联动，所以是一样的
				var host_goal_attempt = $("#host_goalattempt_input").val();
				var host_target_number = $("#host_targetnumber_input").val();
				var host_corner_kick = $("#host_cornerkick_input").val();
				var host_free_kick = $("#host_freekick_input").val();
				var host_foul_number = $("#host_foul_input").val();
				var host_offside = $("#host_offside_input").val();
				var host_overtime_score = $("#host_overtime_score").val();
				var host_penalty_score = $("#host_penalty_score").val();
				var guest_goal_attempt = $("#guest_goalattempt_input").val();
				var guest_target_number = $("#guest_targetnumber_input").val();
				var guest_corner_kick = $("#guest_cornerkick_input").val();
				var guest_free_kick = $("#guest_freekick_input").val();
				var guest_foul_number = $("#guest_foul_input").val();
				var guest_offside = $("#guest_offside_input").val();
				var guest_overtime_score = $("#guest_overtime_score").val();
				var guest_penalty_score = $("#guest_penalty_score").val();
				$.ajax({
					type : 'POST',
					url : forwardurl+"/gamemanagement/record.html",
					data : {
						game_id : recordingGameId,
						host_score : host_score,
						guest_score : guest_score,
						host_goal : host_goal,
						guest_goal : guest_goal,
						host_foul : host_foul,
						guest_foul : guest_foul,
						isovertime_flag : isovertime_flag==true?1:0,
								ispenalty_flag : ispenalty_flag==true?1:0,
										host_goal_attempt : host_goal_attempt,
										host_target_number : host_target_number,
										host_corner_kick : host_corner_kick,
										host_free_kick : host_free_kick,
										host_foul_number : host_foul_number,
										host_offside : host_offside,
										host_overtime_score : host_overtime_score,
										host_penalty_score : host_penalty_score,
										guest_goal_attempt : guest_goal_attempt,
										guest_target_number : guest_target_number,
										guest_corner_kick : guest_corner_kick,
										guest_free_kick : guest_free_kick,
										guest_foul_number : guest_foul_number,
										guest_offside : guest_offside,
										guest_overtime_score : guest_overtime_score,
										guest_penalty_score : guest_penalty_score
					},
					dataType : "json",
					success : function(data) {
						if (data.success) {
							ds
							.dialog({
								title : '消息提示',
								content : "记录已提交！",
								onyes : true,
								icon : "../images/socceralert.png"
							});
							$('.saishi_results').hide();
							$('.edit_match').hide();
						} else {
							ds
							.dialog({
								title : '消息提示',
								content : "记录失败！ ",
								onyes : true,
								icon : "../images/info.png"
							});
						}
						cancel_loading();
					},
					error : function() {
						ds.dialog({
							title : '消息提示',
							content : "记录失败，请检查网络连接！",
							onyes : true,
							icon : "../images/info.png"
						});
						cancel_loading();
					}
				});
			})

			//添加记录条数
			$("#host_foul_table img[src*='add_jilu.png']").click(function() {
				var st = $(this).parent().parent();
				$(st)
				.before(
						"<tr>"
						+ "<td width='83px'>"
						+ "<select class='record_host_num_select' onchange='record_host_num_select_onchange(this)'>"
						+ hostSelectNumHtml
						+ "</select>"
						+ "</td>"
						+ "<td width='130px'><select class='record_host_name_select'>"
						+ hostSelectNameHtml
						+ "</select></td>"
						+ "<td width='113px'><select><option value='1'>黄牌</option><option value='2'>红牌</option></select></td>"
						+ "<td width='90px'><input class='foul_time' type='text' ></td>"
						+ "<td onclick='shanchu(this)'><img src='images/shanchu.png'></td>"
						+ "</tr>");
				$('.fenlai_2 table ').find('tr:even').css(
						'background', '#eee');
			})
			$("#guest_foul_table  img[src*='add_jilu.png']").click(function() {
				var st = $(this).parent().parent();
				$(st).before(
						"<tr>"
						+ "<td width='83px'>"
						+ "<select class='record_guest_num_select' onchange='record_guest_num_select_onchange(this)'>"
						+ guestSelectNumHtml
						+ "</select>"
						+ "</td>"
						+ "<td width='130px'><select class='record_guest_name_select'>"
						+ guestSelectNameHtml
						+ "</select></td>"
						+ "<td width='113px'><select><option value='1'>黄牌</option><option value='2'>红牌</option></select></td>"
						+ "<td width='90px'><input class='foul_time' type='text' ></td>"
						+ "<td onclick='shanchu(this)'><img src='images/shanchu.png'></td>"
						+ "</tr>");
				$('.fenlai_2 table ').find('tr:even').css(
						'background', '#eee');
			})
			$("#host_goal_table  img[src*='add_jilu.png']").click(function() {
				var st = $(this).parent().parent();
				$(st).before(
						"<tr>"
						+ "<td width='65px'><select class='record_host_num_select' onchange='record_host_num_select_onchange(this)'>"
						+ hostSelectNumHtml
						+ "</select></td>"
						+ "<td width='90px'><select class='record_host_name_select'>"
						+ hostSelectNameHtml
						+ "</select></td>"
						+ "<td width='65px'><select class='record_host_num_select' onchange='record_host_num_select_onchange(this)'>"
						+ hostSelectNumHtml
						+ "</select></td>"
						+ "<td width='90px'><select class='record_host_name_select'>"
						+ hostSelectNameHtml
						+ "</select></td>"
						+ "<td width='90px'><select><option value='1'>正常进球</option><option value='2'>点球</option><option value='3'>乌龙球</option></select></td>"
						+ "<td width='70px'><input class='goal_time' type='text'></td><td onclick='shanchu(this)'><img  src='images/shanchu.png'></td>"
						+ "</tr>");
				$('.fenlai_2 table ').find('tr:even').css(
						'background', '#eee');
			})
			$("#guest_goal_table  img[src*='add_jilu.png']").click(function() {
				var st = $(this).parent().parent();
				$(st)
				.before(
						"<tr>"
						+ "<td width='65px'><select class='record_guest_num_select' onchange='record_guest_num_select_onchange(this)'>"
						+ guestSelectNumHtml
						+ "</select></td>"
						+ "<td width='90px'><select class='record_guest_name_select'>"
						+ guestSelectNameHtml
						+ "</select></td>"
						+ "<td width='65px'><select class='record_guest_num_select' onchange='record_guest_num_select_onchange(this)'>"
						+ guestSelectNumHtml
						+ "</select></td>"
						+ "<td width='90px'><select class='record_guest_name_select'>"
						+ guestSelectNameHtml
						+ "</select></td>"
						+ "<td width='90px'><select><option value='1'>正常进球</option><option value='2'>点球</option><option value='3'>乌龙球</option></select></td>"
						+ "<td width='70px'><input class='goal_time' type='text'></td><td onclick='shanchu(this)'><img  src='images/shanchu.png'></td>"
						+ "</tr>");
				$('.fenlai_2 table ').find('tr:even').css(
						'background', '#eee');
			})
			//删除行

			$("#league_search_select").change(function() {
				var league_id = $("#league_search_select").find('option:selected').attr("id").substr(21);
				$.ajax({
					type : 'POST',
					url : forwardurl+"/gamemanagement/getzonesbyleague.html",
					data : {
						league_id : league_id
					},
					dataType : "json",
					success : function(data) {
						$("#zone_search_select").empty();
						$("#zone_search_select").append("<option id='search_zone_option_0'>全部</option>");
						$.each(data.zones,function(i,item) {
							$("#zone_search_select").append("<option id='search_zone_option_" + item.zoneId + "'>"
									+ item.zoneName
									+ "</option>");
						});
					},
					error : function() {
					}
				});
			})
			$("#game_league_select").change(function() {
				if ($("#game_league_select").get(0).selectedIndex == 0) {
					$("#game_zone_select").empty();
					return;
				}
				var league_id = $("#game_league_select").find('option:selected').attr("id").substr(19);
				$.ajax({
					type : 'POST',
					url : forwardurl+"/gamemanagement/getzonesbyleague.html",
					data : {
						league_id : league_id
					},
					dataType : "json",
					success : function(data) {
						$("#game_zone_select").empty();
						$("#game_group_select").get(0).selectedIndex = 0;
						$.each(data.zones,function(i,item) {
							$("#game_zone_select").append(
									"<option id='game_zone_option_" + item.zoneId + "'>"
									+ item.zoneName
									+ "</option>");
						});
					},
					error : function() {
					}
				});
			})
			$("#game_group_select").change(function() {
				refresh_select_team_list(null);
			})
			$("#button_filter").click(function() {
				refresh_competitions();
			})
			$("#modifymatch_btn").click(function() {
				var host_uniform = $("#host_uniform_modify").val();
				var guest_uniform = $("#guest_uniform_modify").val();
				if (host_uniform.length>5||guest_uniform.length>5) {
					ds.dialog({
						title : '消息提示',
						content : "球衣颜色文字长度不能大于5位！",
						onyes : true,
						icon : "../images/info.png"
					});
					return;
				}
				var game_time = $("#time1").val();
				var game_location = $("#address_modify").val();

				$.ajax({
					type : 'POST',
					url : forwardurl+"/gamemanagement/modifygame.html",
					data : {
						game_id : selectedGameId,
						game_time : game_time,
						game_location : game_location,
						host_uniform : host_uniform,
						guest_uniform : guest_uniform
					},
					dataType : "json",
					success : function(data) {
						if (data.success) {
							ds.dialog({
								title : '消息提示',
								content : "比赛已修改！",
								onyes : true,
								icon : "../images/socceralert.png"
							});
							refresh_competitions();
							$('.saishi_results').hide();
							$('.edit_match').hide();
						} else {
							ds.dialog({
								title : '消息提示',
								content : "修改比赛失败！",
								onyes : true,
								icon : "../images/info.png"
							});
						}
					},
					error : function() {
						ds.dialog({
							title : '消息提示',
							content : "添加比赛失败！请检查网络连接！",
							onyes : true,
							icon : "../images/info.png"
						});
					}
				});
			})
			$("#addmatch_btn").click(function() {
				if ($("#game_zone_select").get(0).selectedIndex < 0) {
					ds.dialog({
						title : '消息提示',
						content : "请选择联赛和联赛等级！",
						onyes : true,
						icon : "../images/info.png"
					});
					return;
				}
				if ($("#game_group_select").get(0).selectedIndex == 0) {
					ds.dialog({
						title : '消息提示',
						content : "请选择联赛分组信息！",
						onyes : true,
						icon : "../images/info.png"
					});
					return;
				}
				if ($("#host_team_select").get(0).selectedIndex == 0
						|| $("#guest_team_select").get(0).selectedIndex == 0) {
					ds.dialog({
						title : '消息提示',
						content : "请选择联赛双方球队！",
						onyes : true,
						icon : "../images/info.png"
					});
					return;
				}
				var host_uniform = $("#host_uniform_input").val();
				var guest_uniform = $("#guest_uniform_input").val();
				if (host_uniform.length>5||guest_uniform.length>5) {
					ds.dialog({
						title : '消息提示',
						content : "球衣颜色文字长度不能大于5位！",
						onyes : true,
						icon : "../images/info.png"
					});
					return;
				}
				var game_time = $("#time2").val();
				var game_location = $("#address").val();
				var zone_id = $("#game_zone_select").find('option:selected').attr("id").substr(17);
				var group_index = $("#game_group_select").find('option:selected').val();
				var game_order = 1; //小组赛
				if (group_index == 5) {
					game_order = 2; //淘汰赛
				}
				var host_team_id = $("#host_team_select").find("option:selected").attr("id").substr(19);
				var guest_team_id = $("#guest_team_select").find("option:selected").attr("id").substr(19);
				$.ajax({
					type : 'POST',
					url : forwardurl+"/gamemanagement/addgame.html",
					data : {
						host_team_id : host_team_id,
						guest_team_id : guest_team_id,
						zone_id : zone_id,
						game_time : game_time,
						game_location : game_location,
						game_order : game_order,
						host_uniform : host_uniform,
						guest_uniform : guest_uniform
					},
					dataType : "json",
					success : function(data) {
						if (data.success) {
							ds.dialog({
								title : '消息提示',
								content : "比赛已添加！",
								onyes : true,
								icon : "../images/socceralert.png"
							});
							$("#game_league_select").get(0).selectedIndex = 0;
							$("#game_zone_select").get(0).selectedIndex = -1;
							$("#game_group_select").get(0).selectedIndex = 0;
							$("#host_team_select").get(0).selectedIndex = 0;
							$("#guest_team_select").get(0).selectedIndex = 0;
							$("#host_uniform_input").val("")
							$("#guest_uniform_input").val("");
							$("#time2").val("");
							$("#address").val("");
							$('#competition_apply').hide();
							$('#match_list').show();
							refresh_competitions();
						} else {
							ds.dialog({
								title : '消息提示',
								content : "添加比赛失败！",
								onyes : true,
								icon : "../images/info.png"
							});
						}
					},
					error : function() {
						ds.dialog({
							title : '消息提示',
							content : "添加比赛失败！请检查网络连接！",
							onyes : true,
							icon : "../images/info.png"
						});
					}
				});
			})
})
function nextPage() {
	var index = $("#pageIndex").val();
	$("#pageIndex").val(parseInt(index) + 1)
	refresh_competitions();
}

function prePage() {
	var index = $("#pageIndex").val();
	$("#pageIndex").val(parseInt(index) - 1)
	refresh_competitions();
}
function refresh_competitions() {
	$("#inner_table").empty();
	var current_page = $("#pageIndex").val();
	var r = /^\+?[1-9][0-9]*$/;
	if (!r.test(current_page)) {
		current_page = "1";
	}
	var league_id = $("#league_search_select").find('option:selected')
	.attr("id").substr(21);
	if (league_id == "0")
		league_id = null;
	var zone_id = null;
	if ($("#zone_search_select").get(0).selectedIndex != -1) {
		zone_id = $("#zone_search_select").find('option:selected')
		.attr("id").substr(19);
	}
	if (zone_id == "0")
		zone_id = null;
	var date = $("#search_time").val();
	loading_juggle_empty();
	$.ajax({
		type : 'POST',
		url : forwardurl+"/gamemanagement/getgames.html",
		data : {
			current_page : current_page,
			league_id : league_id,
			zone_id : zone_id,
			date : date
		},
		dataType : "json",
		success : function(data) {
			$("#page_setting").empty();

			if (data.page.hasPrePage == true) {
				$("#page_setting").append(" <label onclick='prePage()'>上一页</label>");
			}
			if (data.page.hasNextPage == true) {
				$("#page_setting").append(" <label onclick='nextPage()'>下一页</label>");
			}
			$("#page_setting").append("<span>第</span><input id='pageIndex' type='text' width='10px' value='"
					+ data.page.currentPage
					+ "'>/<span id='pageCount'></span>页 <button id='page_ok' onclick='refresh_competitions()'>跳转</button>");
			$("#pageCount").text(data.page.totalPage)
			$.each(data.games,function(i, item) {
				if (data.isrecorder) {
					$("#inner_table").append(
							"<tr id='gametr_" + item.gamesId + "'>"
							+ "<td width='145px'>"
							+ item.gameTime
							+ "</td>"
							+ "<td width='208px'>"
							+ item.leagueName
							+ "</td>"
							+ "<td width='95px'>"
							+ item.zoneName
							+ "</td>"
							+ "<td width='74px'>"
							+ item.orderName
							+ "</td>"
							+ "<td width='190px'>"
							+ item.hostSchoolName
							+ "</td>"
							+ "<td width='190px'>"
							+ item.guestSchoolName
							+ "</td>"
							+ "<td><img class='record' src='images/edit_saishi_info.png' alt='记录' onmouseover='mouseover_obj(this)' onmouseout='mouseout_obj(this)'>"
							+ "<img class='edit' src='images/list_modify_btn.png' alt='修改' onmouseover='mouseover_obj(this)' onmouseout='mouseout_obj(this)'></td>"
							+ "</tr>");
				} else {
					$("#inner_table").append(
							"<tr id='gametr_" + item.gamesId + "'>"
							+ "<td width='145px'>"
							+ item.gameTime
							+ "</td>"
							+ "<td width='208px'>"
							+ item.leagueName
							+ "</td>"
							+ "<td width='95px'>"
							+ item.zoneName
							+ "</td>"
							+ "<td width='74px'>"
							+ item.orderName
							+ "</td>"
							+ "<td width='190px'>"
							+ item.hostSchoolName
							+ "</td>"
							+ "<td width='190px'>"
							+ item.guestSchoolName
							+ "</td>"
							+ "<td><img class='record' src='images/edit_saishi_info.png' alt='记录' onmouseover='mouseover_obj(this)' onmouseout='mouseout_obj(this)'>"
							+ "<img class='edit' src='images/list_modify_btn.png' alt='修改' onmouseover='mouseover_obj(this)' onmouseout='mouseout_obj(this)'>"
							+ "<img class='delete' src='images/list_delete_btn.png' alt='删除' onmouseover='mouseover_obj(this)' onmouseout='mouseout_obj(this)'></td>"
							+ "</tr>");
				}
			});
			cancel_loading();
			$('.record').click(function() {
				$("#host_goal_bottom_tr").siblings().remove();
				$("#guest_goal_bottom_tr").siblings().remove();
				$("#host_foul_bottom_tr").siblings().remove();
				$("#guest_foul_bottom_tr").siblings().remove();
				var game_id = $(this).parent().parent().attr("id").substr(7);
				recordingGameId = game_id;
				loading_juggle_empty();
				$.ajax({
					type : 'POST',
					url : forwardurl+"/gamemanagement/getgameinfo.html",
					data : {
						game_id : game_id
					},
					dataType : "json",
					success : function(data) {
						$("#record_host_school_name").html(data.game.hostSchoolName);
						$("#record_guest_school_name").html(data.game.guestSchoolName);
						selectedHostTeamId = data.game.hostTeamId;
						selectedGuestTeamId = data.game.guestTeamId;
						if(data.game.isGameOver==1){
							$("#gamestatus0").css("display", "none");
							$("#gamestatus1").css("display", "inline");
						}
						else{
							$("#gamestatus1").css("display", "none");
							$("#gamestatus0").css("display", "inline");
						}
						var hostTeamName = data.game.hostTeamName;
						var guestTeamName = data.game.guestTeamName;
						if (hostTeamName == null || hostTeamName == "")
							hostTeamName = "球队未命名";
						if (guestTeamName == null || guestTeamName == "")
							guestTeamName = "球队未命名";
						$("#record_host_team_name").html(hostTeamName);
						$("#record_guest_team_name").html(guestTeamName);
						var hostScore = data.game.hostScore;
						var guestScore = data.game.guestScore;
						if (hostScore == null)
							hostScore = "--";
						if (guestScore == null)
							guestScore = "--";

						var isOvertimeFlag = data.game.isOvertimeFlag;
						if(isOvertimeFlag==1){
							$(".overtime_checkbox").prop("checked",true);
							$("#host_overtime_score").attr("disabled", false);
							$("#guest_overtime_score").attr("disabled", false);
						}
						else if(isOvertimeFlag==0){
							$(".overtime_checkbox").prop("checked",false);
							$("#host_overtime_score").attr("disabled", true);
							$("#guest_overtime_score").attr("disabled", true);
							$("#host_overtime_score").val(null);
							$("#guest_overtime_score").val(null);
						}

						var isPenaltyFlag = data.game.isPenaltyFlag;
						if(isPenaltyFlag==1){
							$(".penalty_checkbox").prop("checked",true);
							$("#host_penalty_score").attr("disabled", false);
							$("#guest_penalty_score").attr("disabled", false);
						}
						else if(isPenaltyFlag==0){
							$(".penalty_checkbox").prop("checked",false);
							$("#host_penalty_score").attr("disabled", true);
							$("#guest_penalty_score").attr("disabled", true);
							$("#host_penalty_score").val(null);
							$("#guest_penalty_score").val(null);
						}
						var hostOvertimeScore = data.game.hostOvertimeScore;
						var guestOvertimeScore = data.game.guestOvertimeScore;
						if(hostOvertimeScore==null)
							hostOvertimeScore = "";
						if(guestOvertimeScore==null)
							guestOvertimeScore = "";
						var hostPenaltyScore = data.game.hostPenaltyScore;
						var guestPenaltyScore = data.game.guestPenaltyScore;
						if(hostPenaltyScore==null)
							hostPenaltyScore = "";
						if(guestPenaltyScore==null)
							guestPenaltyScore = "";
						$("#host_penalty_score").val(hostPenaltyScore);
						$("#guest_penalty_score").val(guestPenaltyScore);
						$("#host_overtime_score").val(hostOvertimeScore);
						$("#guest_overtime_score").val(guestOvertimeScore);

						//主队比赛数据
						var hostGoalAttempt = data.game.hostGoalAttempt;
						if(hostGoalAttempt == null)
							hostGoalAttempt = "";
						$("#host_goalattempt_input").val(hostGoalAttempt);
						var hostTargetNumber = data.game.hostTargetNumber;
						if(hostTargetNumber == null)
							hostTargetNumber = "";
						$("#host_targetnumber_input").val(hostTargetNumber);
						var hostCornerKick = data.game.hostCornerKick;
						if(hostCornerKick == null)
							hostCornerKick = "";
						$("#host_cornerkick_input").val(hostCornerKick);
						var hostFreeKick = data.game.hostFreeKick;
						if(hostFreeKick == null)
							hostFreeKick = "";
						$("#host_freekick_input").val(hostFreeKick);
						var hostFoul = data.game.hostFoul;
						if(hostFoul == null)
							hostFoul = "";
						$("#host_foul_input").val(hostFoul);
						var hostOffside = data.game.hostOffside;
						if(hostOffside == null)
							hostOffside = "";
						$("#host_offside_input").val(hostOffside)

						//客队比赛数据
						var guestGoalAttempt = data.game.guestGoalAttempt;
						if(guestGoalAttempt == null)
							guestGoalAttempt = "";
						$("#guest_goalattempt_input").val(guestGoalAttempt);
						var guestTargetNumber = data.game.guestTargetNumber;
						if(guestTargetNumber == null)
							guestTargetNumber = "";
						$("#guest_targetnumber_input").val(guestTargetNumber);
						var guestCornerKick = data.game.guestCornerKick;
						if(guestCornerKick == null)
							guestCornerKick = "";
						$("#guest_cornerkick_input").val(guestCornerKick);
						var guestFreeKick = data.game.guestFreeKick;
						if(guestFreeKick == null)
							guestFreeKick = "";
						$("#guest_freekick_input").val(guestFreeKick);
						var guestFoul = data.game.guestFoul;
						if(guestFoul == null)
							guestFoul = "";
						$("#guest_foul_input").val(guestFoul);
						var guestOffside = data.game.guestOffside;
						if(guestOffside == null)
							guestOffside = "";
						$("#guest_offside_input").val(guestOffside)
 
						$("#record_host_score").val(hostScore);
						$("#record_guest_score").val(guestScore);
						hostSelectNumHtml = "<option id='host_num_0' value='0'></option>";
						hostSelectNameHtml = "<option id='host_name_0' value='0'></option>";
						$.each(data.host_athletes,function(i,item) {
							hostSelectNameHtml += "<option id='host_name_" + item.athleteId + "'>"
							+ item.athleteName
							+ "</option>";
							if (item.athleteNumber != null) {
								hostSelectNumHtml += "<option id='host_num_" + item.athleteId + "'>"
								+ item.athleteNumber
								+ "</option>";
							}
						});
						guestSelectNumHtml = "<option id='guest_num_0' value='0'></option>";
						guestSelectNameHtml = "<option id='guest_name_0' value='0'></option>";
						$.each(data.guest_athletes,function(i,item) {
							guestSelectNameHtml += "<option id='guest_name_" + item.athleteId + "'>"
							+ item.athleteName
							+ "</option>";
							if (item.athleteNumber != null) {
								guestSelectNumHtml += "<option id='guest_num_" + item.athleteId + "'>"
								+ item.athleteNumber
								+ "</option>";
							}
						});
						$(".record_host_name_select").empty();
						$(".record_host_name_select").append(hostSelectNameHtml);
						$(".record_guest_name_select").empty();
						$(".record_guest_name_select").append(guestSelectNameHtml);
						$(".record_host_num_select").empty();
						$(".record_host_num_select").append(hostSelectNumHtml);
						$(".record_guest_num_select").empty();
						$(".record_guest_num_select").append(guestSelectNumHtml);
						$.each(data.host_goals,function(i,item) {
							var appendHtml = "<tr style='background: rgb(238, 238, 238);'>"
								+ "<td width='65px'><select class='record_host_num_select' onchange='record_host_num_select_onchange(this)'>";
							appendHtml += hostSelectNumHtml;
							appendHtml += "</select></td><td width='90px'><select class='record_host_name_select'>";
							appendHtml += hostSelectNameHtml;
							appendHtml += "</select></td><td width='65px'><select class='record_host_num_select' onchange='record_host_num_select_onchange(this)'>";
							appendHtml += hostSelectNumHtml;
							appendHtml += "</select></td><td width='90px'><select class='record_host_name_select'>";
							appendHtml += hostSelectNameHtml;
							appendHtml += "</select></td><td width='90px'><select><option value='1'>正常进球</option><option value='2'>点球</option><option value='3'>乌龙球</option></select>";
							appendHtml += "</select></td><td width='70px'><input class='goal_time' type='text'></td>";
							appendHtml += "<td onclick='shanchu(this)'><img src='images/shanchu.png'></td></tr>";
							$("#host_goal_bottom_tr").before(appendHtml);
							$("#host_goal_bottom_tr").prev().find(".record_host_num_select").eq(0).find("option:contains('" + item.shooterNumber + "')").each(function() {
								if ($(this).text() == item.shooterNumber + "") {
									$(this).attr("selected",true);
								}
							})
							$("#host_goal_bottom_tr").prev().find(".record_host_name_select").eq(0).find("option:contains('" + item.shooterName + "')").each(function() {
								if ($(this).attr("id").substring(10) == item.shooterId) {
									$(this).attr("selected",true);
								}
							})
							$("#host_goal_bottom_tr").prev().find(".record_host_num_select").eq(1).find("option:contains('" + item.assistantNumber + "')").each(function() {
								if ($(this).text() == item.assistantNumber + "") {
									$(this).attr("selected", true);
								}
							})
							$("#host_goal_bottom_tr").prev().find(".record_host_name_select").eq(1).find("option:contains('" + item.assistantName + "')").each(function() {
								if ($(this).attr("id").substring(10) == item.assistantId) {
									$(this).attr("selected",true);
								}
							})
							$("#host_goal_bottom_tr").prev().find("select").eq(4).val(item.style);
							$("#host_goal_bottom_tr").prev().find("input").eq(0).val(item.time);
						});
						$.each(data.guest_goals,function(i,item) {
							var appendHtml = "<tr style='background: rgb(238, 238, 238);'>"
								+ "<td width='65px'><select class='record_guest_num_select' onchange='record_guest_num_select_onchange(this)'>";
							appendHtml += guestSelectNumHtml;
							appendHtml += "</select></td><td width='90px'><select class='record_guest_name_select'>";
							appendHtml += guestSelectNameHtml;
							appendHtml += "</select></td><td width='65px'><select class='record_guest_num_select' onchange='record_guest_num_select_onchange(this)'>";
							appendHtml += guestSelectNumHtml;
							appendHtml += "</select></td><td width='90px'><select class='record_guest_name_select'>";
							appendHtml += guestSelectNameHtml;
							appendHtml += "</select></td><td width='90px'><select><option value='1'>正常进球</option><option value='2'>点球</option><option value='3'>乌龙球</option></select>";
							appendHtml += "</select></td><td width='70px'><input class='goal_time' type='text'></td>";
							appendHtml += "<td onclick='shanchu(this)'><img src='images/shanchu.png'></td></tr>";
							$("#guest_goal_bottom_tr").before(appendHtml);
							$("#guest_goal_bottom_tr").prev().find(".record_guest_num_select").eq(0).find("option:contains('" + item.shooterNumber + "')").each(function() {
								if ($(this).text() == item.shooterNumber + "") {
									$(this).attr("selected",true);
								}
							})
							$("#guest_goal_bottom_tr").prev().find(".record_guest_name_select").eq(0).find("option:contains('" + item.shooterName + "')").each(function() {
								if ($(this).attr("id").substring(11) == item.shooterId) {
									$(this).attr("selected",true);
								}
							})
							$("#guest_goal_bottom_tr").prev().find(".record_guest_num_select").eq(1).find("option:contains('" + item.assistantNumber + "')").each(function() {
								if ($(this).text() == item.assistantNumber+ "") {
									$(this).attr("selected",true);
								}
							})
							$("#guest_goal_bottom_tr").prev().find(".record_guest_name_select").eq(1).find("option:contains('"+ item.assistantName + "')").each(function() {
								if ($(this).attr("id").substring(11) == item.assistantId) {
									$(this).attr("selected",true);
								}
							})
							$("#guest_goal_bottom_tr").prev().find("select").eq(4).val(item.style);
							$("#guest_goal_bottom_tr").prev().find("input").eq(0).val(item.time);
						});

						$.each(data.host_fouls,function(i,item) {
							var appendHtml = "<tr style='background: rgb(238, 238, 238);'>"
								+ "<td width='83px'><select class='record_host_num_select' onchange='record_host_num_select_onchange(this)'>";
							appendHtml += hostSelectNumHtml;
							appendHtml += "</select></td><td width='130px'><select class='record_host_name_select'>";
							appendHtml += hostSelectNameHtml;
							appendHtml += "</select></td><td width='113px'><select><option value='1'>黄牌</option><option value='2'>红牌</option></select>";
							appendHtml += "</select></td><td width='90px'><input class='goal_time' type='text'></td>";
							appendHtml += "<td onclick='shanchu(this)'><img src='images/shanchu.png'></td></tr>";
							$("#host_foul_bottom_tr").before(appendHtml);
							$("#host_foul_bottom_tr").prev().find(".record_host_num_select").eq(0).find("option:contains('" + item.athleteNumber + "')").each(function() {
								if ($(this).text() == item.athleteNumber + "") {
									$(this).attr("selected",true);
								}
							})
							$("#host_foul_bottom_tr").prev().find(".record_host_name_select").eq(0).find("option:contains('" + item.athleteName + "')").each(function() {
								if ($(this).attr("id").substring(10) == item.athleteId) {
									$(this).attr("selected",true);
								}
							})
							$("#host_foul_bottom_tr").prev().find("select").eq(2).val(item.foulLevel);
							$("#host_foul_bottom_tr").prev().find("input").eq(0).val(item.time);
						});
						$.each(data.guest_fouls,function(i,item) {
							var appendHtml = "<tr style='background: rgb(238, 238, 238);'>"
								+ "<td width='83px'><select class='record_guest_num_select' onchange='record_guest_num_select_onchange(this)'>";
							appendHtml += guestSelectNumHtml;
							appendHtml += "</select></td><td width='130px'><select class='record_guest_name_select'>";
							appendHtml += guestSelectNameHtml;
							appendHtml += "</select></td><td width='113px'><select><option value='1'>黄牌</option><option value='2'>红牌</option></select>";
							appendHtml += "</select></td><td width='90px'><input class='goal_time' type='text'></td>";
							appendHtml += "<td onclick='shanchu(this)'><img src='images/shanchu.png'></td></tr>";
							$("#guest_foul_bottom_tr").before(appendHtml);
							$("#guest_foul_bottom_tr").prev().find(".record_guest_num_select").eq(0).find("option:contains('" + item.athleteNumber + "')").each(function() {
								if ($(this).text() == item.athleteNumber + "") {
									$(this).attr("selected",true);
								}
							})
							$("#guest_foul_bottom_tr").prev().find(".record_guest_name_select").eq(0).find("option:contains('" + item.athleteName + "')").each(function() {
								if ($(this).attr("id").substring(11) == item.athleteId) {
									$(this).attr("selected",true);
								}
							})
							$("#guest_foul_bottom_tr").prev().find("select").eq(2).val(item.foulLevel);
							$("#guest_foul_bottom_tr").prev().find("input").eq(0).val(item.time);
						});
						cancel_loading();
					},
					error : function() {
						ds.dialog({
							title : '消息提示',
							content : "请检查网络连接！",
							onyes : true,
							icon : "../images/info.png"
						});
						cancel_loading();
					}
				});
				$('.saishi_results').show();
			})
			$('.edit').click(function() {
				var game_id = $(this).parent().parent().attr("id").substr(7);
				selectedGameId = game_id;
				$.ajax({
					type : 'POST',
					url : forwardurl+"/gamemanagement/getsinglegame.html",
					data : {
						game_id : game_id
					},
					dataType : "json",
					success : function(data) {
						$("#game_league_modify").val(data.game.leagueName);
						$("#game_zone_modify").val(data.game.zoneName);
						$("#game_group_modify").val(data.game.orderName);
						$("#team_modify").val(data.game.hostSchoolName);
						$("#host_team_modify").val(data.game.hostSchoolName);
						$("#guest_team_modify").val(data.game.guestSchoolName);
						$("#time1").val(data.game.gameTime);
						$("#address_modify").val(data.game.gameLocation);
						var host_uniform = data.game.hostUniform;
						var guest_uniform = data.game.guestUniform;
						$("#host_uniform_modify").val(host_uniform);
						$("#guest_uniform_modify").val(guest_uniform);
					},
					error : function() {
						ds.dialog({
							title : '消息提示',
							content : "请检查网络连接！",
							onyes : true,
							icon : "../images/info.png"
						});
					}
				});
				$('.edit_match').show();
			})
			$(".delete").click(function() {
				var game_id = $(this).parent().parent().attr("id").substr(7);
				ds.dialog({
					title : '消息提示',
					content : "将删除该比赛，确定删除？",
					yesText : "确定",
					onyes : function() {
						$.ajax({
							type : 'POST',
							url : forwardurl+"/gamemanagement/deletegame.html",
							data : {
								game_id : game_id
							},
							dataType : "json",
							success : function(
									data) {
								refresh_competitions();
							},
							error : function() {
								ds
								.dialog({
									title : '消息提示',
									content : "删除比赛失败！请检查网络连接！",
									onyes : true,
									icon : "../images/info.png"
								});
							}
						});
					},
					noText : "取消",
					onno : function() {
						this.close();
					},
					icon : "../images/confirm.png"
				});
			})
		},
		error : function() {
			ds.dialog({
				title : '消息提示',
				content : "请检查网络连接！",
				onyes : true,
				icon : "../images/info.png"
			});
			cancel_loading();
		}
	});
}
function record_host_num_select_onchange(obj) {
	var selectedNum = $(obj).find("option:selected").text();
	var nextSelect = $(obj).parent().next().find("select");
	loading_juggle_empty();
	$.ajax({
		type : 'POST',
		url : forwardurl+"/gamemanagement/getgameinfo.html",
		data : {
			game_id : recordingGameId
		},
		dataType : "json",
		success : function(data) {
			$.each(data.host_athletes,function(i, item) {
				if (item.athleteNumber == selectedNum) {
					//why?
					$(nextSelect).find("option:contains('" + item.athleteName + "')").each(
							function() {$(this).attr("selected",false);
							if ($(this).attr("id") == "host_name_" + item.athleteId) {
								$(this).attr("selected",true);
							}
							})
				}
			});
			cancel_loading();
		},
		error : function() {
			cancel_loading();
		}
	});
}
function record_guest_num_select_onchange(obj) {
	var selectedNum = $(obj).find("option:selected").text();
	var nextSelect = $(obj).parent().next().find("select");
	loading_juggle_empty();
	$.ajax({
		type : 'POST',
		url : forwardurl+"/gamemanagement/getgameinfo.html",
		data : {
			game_id : recordingGameId
		},
		dataType : "json",
		success : function(data) {
			$.each(data.guest_athletes,function(i, item) {
				if (item.athleteNumber == selectedNum) {
					//why?
					$(nextSelect).find("option:contains('" + item.athleteName + "')").each(
							function() {
								if ($(this).attr("id") == "guest_name_" + item.athleteId) {
									$(this).attr("selected",true);
								}
							})
				}
			});
			cancel_loading();
		},
		error : function() {
			cancel_loading();
		}
	});
}
function refresh_select_team_list(obj) {
	var group_index = $("#game_group_select").find('option:selected')
	.val();
	if ($("#game_zone_select").find('option:selected').attr("id") == null) {
		ds.dialog({
			title : '消息提示',
			content : "请选择联赛和联赛等级！",
			onyes : true,
			icon : "../images/info.png"
		});
		return;
	}
	var zone_id = $("#game_zone_select").find('option:selected').attr(
	"id").substr(17);
	var group_name = null;
	//A,B,C,D组
	if (group_index == 1) {
		group_name = "A";
	} else if (group_index == 2) {
		group_name = "B";
	} else if (group_index == 3) {
		group_name = "C";
	} else if (group_index == 4) {
		group_name = "D";
	}
	var selected_teamid = "";

	$(".refresh_select").each(
			function() {
				if ($(this).get(0).selectedIndex != 0) {
					selected_teamid = selected_teamid
					+ $(this).find("option:selected")
					.attr("id").substr(19) + ",";
				}
			})
			if (selected_teamid.length > 0) {
				selected_teamid = selected_teamid.substr(0,
						selected_teamid.length - 1);
			}
	$.ajax({
		type : 'POST',
		url : forwardurl+"/gamemanagement/getteamsbyzone.html",
		data : {
			group_name : group_name,
			zone_id : zone_id,
			selected_teamid : selected_teamid
		},
		dataType : "json",
		success : function(data) {
			$(".refresh_select").each(
					function() {
						if ($(this).get(0).selectedIndex != 0) {
							selectedId = $(this).find("option:selected").attr("id");
							selectedSchoolName = $(this).find("option:selected").text();
							$(this).empty();
							$(this).append("<option id='team_select_option_0' value='0'>--请选择--</option>");
							if (obj != null)
								$(this).append("<option id='" + selectedId + "' selected='selected'>" + selectedSchoolName + "</option>");
						} else {
							$(this).empty();
							$(this).append("<option id='team_select_option_0' value='0'>--请选择--</option>");
						}
						var theObj = $(this);
						$.each(data.teams, function(i,item) {
							$(theObj).append("<option id='team_select_option_" + item.teamId + "'>" + item.schoolName + "</option>");
						});
					});
		},
		error : function() {
		}
	});
}
function shanchu(obj) {
	$(obj).parent().remove();
}
function overtime_checkbox_change(obj){
	if($(obj).prop("checked")==true){
		$(".overtime_checkbox").prop("checked",true);
		$("#host_overtime_score").attr("disabled", false);
		$("#guest_overtime_score").attr("disabled", false);
	}
	else if($(obj).prop("checked")==false){
		$(".overtime_checkbox").prop("checked",false);
		$("#host_overtime_score").attr("disabled", true);
		$("#guest_overtime_score").attr("disabled", true);
		$("#host_overtime_score").val(null);
		$("#guest_overtime_score").val(null);
	}
}
function penalty_checkbox_change(obj){
	if($(obj).prop("checked")==true){
		$(".penalty_checkbox").prop("checked",true);
		$("#host_penalty_score").attr("disabled", false);
		$("#guest_penalty_score").attr("disabled", false);
	}
	else if($(obj).prop("checked")==false){
		$(".penalty_checkbox").prop("checked",false);
		$("#host_penalty_score").attr("disabled", true);
		$("#guest_penalty_score").attr("disabled", true);
		$("#host_penalty_score").val(null);
		$("#guest_penalty_score").val(null);
	}
}

function setGameOver(){
	$("#gamestatus0").css("display", "none");
	$("#gamestatus1").css("display", "inline");
	$.ajax({
		type : 'POST',
		url : forwardurl+"/gamemanagement/setgameover.html",
		data : {
			game_id : recordingGameId
		},
		dataType : "json",
		success : function(data) {
			if(data){
				ds.dialog({
					title : '消息提示',
					content : "操作成功！",
					onyes : true,
					icon : "../images/socceralert.png"
				});
			}
			else{
				ds.dialog({
					title : '消息提示',
					content : "操作失败！",
					onyes : true,
					icon : "../images/info.png"
				});
			}
		},
		error : function() {
			ds.dialog({
				title : '消息提示',
				content : "请检查网络连接！",
				onyes : true,
				icon : "../images/info.png"
			});			
		}
	});
}
function cancelGameOver(){
	$("#gamestatus1").css("display", "none");
	$("#gamestatus0").css("display", "inline");
	$.ajax({
		type : 'POST',
		url : forwardurl+"/gamemanagement/cancelgameover.html",
		data : {
			game_id : recordingGameId
		},
		dataType : "json",
		success : function(data) {
			if(data){
				ds.dialog({
					title : '消息提示',
					content : "操作成功！",
					onyes : true,
					icon : "../images/socceralert.png"
				});
			}
			else{
				ds.dialog({
					title : '消息提示',
					content : "操作失败！",
					onyes : true,
					icon : "../images/info.png"
				});
			}
		},
		error : function() {
			ds.dialog({
				title : '消息提示',
				content : "请检查网络连接！",
				onyes : true,
				icon : "../images/info.png"
			});			
		}
	});
}