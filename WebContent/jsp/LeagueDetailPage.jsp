<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dialog.css">
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
<script src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ui.datepicker-zh-CN.js"></script>
<title>联赛管理</title>
<script type="text/javascript">
	var league_id = "${league.leagueId}";
	var league_year = "${league.leagueYear}";
	var selected_zone_index = 0;
	var is_modify_allowed = "${league.isModifyAllowed()}";
	var is_register_end = "${league.isRegisterEnd()}";
	var zoneList;
	$(function() {
		path = "${pageContext.request.contextPath}";
		$(":disabled").each(
				function() {
					if ($(this).parent().css('background-image').indexOf(
							'input_m.png') >= 0) {
						$(this).parent().prev().css('background-image',
								'url(' + path + '/images/input_l2.png)');
						$(this).parent().css('background-image',
								'url(' + path + '/images/input_m2.png)');
						$(this).parent().next().css('background-image',
								'url(' + path + '/images/input_r2.png)');
					}
					if ($(this).parent().css('background-image').indexOf(
							'input_m_thin.png') >= 0) {
						$(this).parent().prev().css('background-image',
								'url(' + path + '/images/input_l_thin2.png)');
						$(this).parent().css('background-image',
								'url(' + path + '/images/input_m_thin2.png)');
						$(this).parent().next().css('background-image',
								'url(' + path + '/images/input_r_thin2.png)');
					}
				})
		loadZoneList();
		if (is_register_end == 1) {
			//$(".table_head_left_fat").css("display", "none");
			$(".table_head_left_fat").text('组别列表');
			$(".table_head_left_fat").unbind();
		} else {
			$(".table_head_left_fat").click(function() {
				$(".zone_block").css("display", "block");
			})
		}
		$("#menubtn_back")
				.click(
						function() {
							$('#ui-datepicker-div').remove();
							window.location.href = "${pageContext.request.contextPath}/league.html";
						});
		$("#menubtn_league").click(function() {
			$('#ui-datepicker-div').remove();
			$("#league_group").css("display", "none");
			$("#league_detail").css("display", "block");
		});
		$("#menubtn_zone").click(function() {
			$('#ui-datepicker-div').remove();
			$("#league_group").css("display", "block");
			$("#league_detail").css("display", "none");
		});
		$("#start_register_time").datepicker();
		$("#end_register_time").datepicker();
		$("#league_start_time").datepicker();
		$("#league_end_time").datepicker();

		$(".close").click(function() {
			$('input:checkbox[name=items]:checked').each(function(i) {
				$(this).prop('checked', false);
			});
			$("#zonename_input").val("");
			$(".zone_block").css("display", "none");
			$("#add_wk").css("display", "block");
			$("#modify_wk").css("display", "none");
		})
		$("#addzone_btn").click(function() {
			var levels = "";
			var zone_name = $("#zonename_input").val();
			if (zone_name == "") {
				ds.dialog({
					title : '消息提示',
					content : "级别名称不得为空！",
					onyes : true,
					icon : "../../images/info.png"
				});
				return;
			}
			$('input:checkbox[name=items]:checked').each(function(i) {
				levels += $(this).val() + ";";
			});
			var max_athletenum = $("#zone_maxathlete").val();
			if(max_athletenum == ""){
				ds.dialog({
					title : '消息提示',
					content : "必须填写运动员报名上限！",
					onyes : true,
					icon : "../../images/info.png"
				});
				return;
			}
			if (levels == "") {
				ds.dialog({
					title : '消息提示',
					content : "级别中至少应包含一个可报名年级！",
					onyes : true,
					icon : "../../images/info.png"
				});
				return;
			}
			$.ajax({
				type : 'POST',
				url : "${pageContext.request.contextPath}/league/addzone.html",
				data : {
					league_id : league_id,
					zone_name : zone_name,
					levels : levels,
					max_athletenum : max_athletenum
				},
				dataType : "json",
				success : function(data) {
					if (data.result) {
						// 加载联赛列表
						loadZoneList();
					} else {
						ds.dialog({
							title : '消息提示',
							content : "添加联赛组失败！",
							onyes : true,
							icon : "../../images/info.png"
						});
					}
					$('.zone_block').hide();
					$('input:checkbox[name=items]:checked').each(function(i) {
						$(this).attr('checked', false);
					});
					$("#zonename_input").val("");
				},
				error : function() {
					ds.dialog({
						title : '消息提示',
						content : "添加联赛组失败！",
						onyes : true,
						icon : "../../images/info.png"
					});
				}
			});
		})
		$("#modifyzone_btn")
				.click(
						function() {
							var levels = "";
							var zone_name = $("#zonename_input").val();
							$('input:checkbox[name=items]:checked').each(
									function(i) {
										levels += $(this).val() + ";";
									});
							$
									.ajax({
										type : 'POST',
										url : "${pageContext.request.contextPath}/league/modifyzone.html",
										data : {
											zone_id : selected_zone_index,
											zone_name : zone_name,
											levels : levels
										},
										dataType : "json",
										success : function(data) {
											if (data.result) {
												// 加载联赛列表
												loadZoneList();
											} else {
												ds
														.dialog({
															title : '消息提示',
															content : "修改联赛组失败！",
															onyes : true,
															icon : "../../images/info.png"
														});
											}
											$('.zone_block').hide();
											$(
													'input:checkbox[name=items]:checked')
													.each(
															function(i) {
																$(this)
																		.attr(
																				'checked',
																				false);
															});
											$("#zonename_input").val("");
										},
										error : function() {
											ds.dialog({
												title : '消息提示',
												content : "修改联赛组失败！",
												onyes : true,
												icon : "../../images/info.png"
											});
										}
									});
							$("#add_wk").css("display", "block");
							$("#modify_wk").css("display", "none");
						})
		$("#menubtn_delete")
				.click(
						function() {
							$('#ui-datepicker-div').remove();
							ds
									.dialog({
										title : '消息提示',
										content : "将丢失该联赛的全部信息，确定删除？",
										yesText : "确定",
										onyes : function() {
											$
													.ajax({
														type : 'POST',
														url : "${pageContext.request.contextPath}/league/deleteleague.html",
														data : {
															league_id : league_id
														},
														dataType : "json",
														success : function(data) {
															if (data.success) {
																// 回到列表
																$(
																		'#ui-datepicker-div')
																		.remove();
																window.location.href = "${pageContext.request.contextPath}/league.html";
															} else {
																ds
																		.dialog({
																			title : '消息提示',
																			content : '删除联赛失败！',
																			onyes : true,
																			icon : "../../images/info.png"
																		});
															}
														},
														error : function() {
															ds
																	.dialog({
																		title : '消息提示',
																		content : '删除联赛失败！',
																		onyes : true,
																		icon : "../../images/info.png"
																	});
														}
													});
										},
										noText : "取消",
										onno : function() {
											this.close();
										},
										icon : "../../images/confirm.png"
									});

						});

		$("#modify_btn_liansai")
				.click(
						function() {
							var league_name = $("#name_input").val();
							var register_start_time = $("#start_register_time")
									.val();
							var register_end_time = $("#end_register_time")
									.val();
							if (register_start_time > register_end_time) {
								ds.dialog({
									title : '消息提示',
									content : "报名截止日期不得早于报名开始时间",
									onyes : true,
									icon : "../../images/info.png"
								});
								return;
							}
							var league_start_time = $("#league_start_time").val();
							var league_end_time = $("#league_end_time").val();
							var league_description = $("#league_description").val();
							if(league_description.length>500){
								ds.dialog({
									title : '消息提示',
									content : "联赛介绍不能多于500字!",
									onyes : true,
									icon : "../../images/info.png"
								});
								return;
							}
							$
									.ajax({
										type : 'POST',
										url : "${pageContext.request.contextPath}/league/modifyleague.html",
										data : {
											league_id : league_id,
											year : league_year,
											name : league_name,
											start_date : register_start_time,
											end_date : register_end_time,
											league_start_time : league_start_time,
											league_end_time : league_end_time,
											league_description : league_description
										},
										dataType : "json",
										success : function(data) {
											if (data.success) {
												// 加载联赛列表
												$('#ui-datepicker-div')
														.remove();
												window.location.href = "${pageContext.request.contextPath}/league.html";
											} else {
												ds
														.dialog({
															title : '消息提示',
															content : "修改联赛失败",
															onyes : true,
															icon : "../../images/info.png"
														});
											}
										},
										error : function() {
											ds.dialog({
												title : '消息提示',
												content : "修改联赛失败",
												onyes : true,
												icon : "../../images/info.png"
											});
										}
									});
						});
	})
	function loadZoneList() {
		var league_id = "${league.leagueId}";
		loading_juggle_empty();
		$
				.ajax({
					type : 'POST',
					url : "${pageContext.request.contextPath}/league/getzonesbyleagueid.html",
					data : {
						league_id : league_id
					},
					dataType : "json",
					success : function(data) {
						if (data != null) {
							zoneList = data.zones;
							// 加载联赛列表
							loadZones();
						} else {
							ds.dialog({
								title : '消息提示',
								content : "查询联赛组信息失败",
								onyes : true,
								icon : "../../images/info.png"
							});
						}
						cancel_loading();
					},
					error : function() {
						ds.dialog({
							title : '消息提示',
							content : "查询联赛组信息失败",
							onyes : true,
							icon : "../../images/info.png"
						});
						cancel_loading();
					}
				});
	}
	function loadZones() {
		$("#list_zones").empty();
		if (zoneList != null && zoneList.length > 0) {
			$
					.each(
							zoneList,
							function(i, zone) {
								if (zone != null && zone != "") {
									$("#list_zones")
											.append(
													"<tr id='zone_" + zone.zoneId + "'>"
															+ "<td width='150px'>"
															+ zone.zoneName
															+ "</td>"
															+ "<td style='position:relative' width='720px'>"
															+ "<div style='display:none'>"
															+ zone.levelStr
															+ "</div>"
															+ "<div style='position:absolute;left:2px;top:1px;width:718px;height:46px;'>"
															+ "<div style='position:absolute;left:10px;top:0px;width:108px;height:46px;background:url(${pageContext.request.contextPath}/images/primary.png) no-repeat left center;'></div>"
															+ "<div style='position:absolute;left:110px;top:0px;width:23px;height:23px;background:url(${pageContext.request.contextPath}/images/primary_male.png) no-repeat left center;'></div>"
															+ "<div style='left:135px;top:0px;' class="
															+ (zone.levelArray[0] ? "'include_primary_grade'"
																	: "'disclude_grade'")
															+ ">2</div>"
															+ "<div style='left:160px;top:0px;' class="
															+ (zone.levelArray[2] ? "'include_primary_grade'"
																	: "'disclude_grade'")
															+ ">3</div>"
															+ "<div style='left:185px;top:0px;' class="
															+ (zone.levelArray[4] ? "'include_primary_grade'"
																	: "'disclude_grade'")
															+ ">4</div>"
															+ "<div style='left:210px;top:0px;' class="
															+ (zone.levelArray[6] ? "'include_primary_grade'"
																	: "'disclude_grade'")
															+ ">5</div>"
															+ "<div style='left:235px;top:0px;' class="
															+ (zone.levelArray[8] ? "'include_primary_grade'"
																	: "'disclude_grade'")
															+ ">6</div>"
															+ "<div style='position:absolute;left:100px;top:23px;width:23px;height:23px;background:url(${pageContext.request.contextPath}/images/primary_female.png) no-repeat left center;'></div>"
															+ "<div style='left:125px;top:23px;' class="
															+ (zone.levelArray[1] ? "'include_primary_grade'"
																	: "'disclude_grade'")
															+ ">2</div>"
															+ "<div style='left:150px;top:23px;' class="
															+ (zone.levelArray[3] ? "'include_primary_grade'"
																	: "'disclude_grade'")
															+ ">3</div>"
															+ "<div style='left:175px;top:23px;' class="
															+ (zone.levelArray[5] ? "'include_primary_grade'"
																	: "'disclude_grade'")
															+ ">4</div>"
															+ "<div style='left:200px;top:23px;' class="
															+ (zone.levelArray[7] ? "'include_primary_grade'"
																	: "'disclude_grade'")
															+ ">5</div>"
															+ "<div style='left:225px;top:23px;' class="
															+ (zone.levelArray[9] ? "'include_primary_grade'"
																	: "'disclude_grade'")
															+ ">6</div>"
															+ "<div style='position:absolute;left:290px;top:0px;width:108px;height:46px;background:url(${pageContext.request.contextPath}/images/junior.png) no-repeat left center;'></div>"
															+ "<div style='position:absolute;left:390px;top:0px;width:23px;height:23px;background:url(${pageContext.request.contextPath}/images/junior_male.png) no-repeat left center;'></div>"
															+ "<div style='left:415px;top:0px;' class="
															+ (zone.levelArray[10] ? "'include_junior_grade'"
																	: "'disclude_grade'")
															+ ">7</div>"
															+ "<div style='left:440px;top:0px;' class="
															+ (zone.levelArray[12] ? "'include_junior_grade'"
																	: "'disclude_grade'")
															+ ">8</div>"
															+ "<div style='left:465px;top:0px;' class="
															+ (zone.levelArray[14] ? "'include_junior_grade'"
																	: "'disclude_grade'")
															+ ">9</div>"
															+ "<div style='position:absolute;left:380px;top:23px;width:23px;height:23px;background:url(${pageContext.request.contextPath}/images/junior_female.png) no-repeat left center;'></div>"
															+ "<div style='left:405px;top:23px;' class="
															+ (zone.levelArray[11] ? "'include_junior_grade'"
																	: "'disclude_grade'")
															+ ">7</div>"
															+ "<div style='left:430px;top:23px;' class="
															+ (zone.levelArray[13] ? "'include_junior_grade'"
																	: "'disclude_grade'")
															+ ">8</div>"
															+ "<div style='left:455px;top:23px;' class="
															+ (zone.levelArray[15] ? "'include_junior_grade'"
																	: "'disclude_grade'")
															+ ">9</div>"
															+ "<div style='position:absolute;left:520px;top:0px;width:108px;height:46px;background:url(${pageContext.request.contextPath}/images/senior.png) no-repeat left center;'></div>"
															+ "<div style='position:absolute;left:620px;top:0px;width:23px;height:23px;background:url(${pageContext.request.contextPath}/images/senior_male.png) no-repeat left center;'></div>"
															+ "<div style='left:645px;top:0px;' class="
															+ (zone.levelArray[16] ? "'include_senior_grade'"
																	: "'disclude_grade'")
															+ ">1</div>"
															+ "<div style='left:670px;top:0px;' class="
															+ (zone.levelArray[18] ? "'include_senior_grade'"
																	: "'disclude_grade'")
															+ ">2</div>"
															+ "<div style='left:695px;top:0px;' class="
															+ (zone.levelArray[20] ? "'include_senior_grade'"
																	: "'disclude_grade'")
															+ ">3</div>"
															+ "<div style='position:absolute;left:610px;top:23px;width:23px;height:23px;background:url(${pageContext.request.contextPath}/images/senior_female.png) no-repeat left center;'></div>"
															+ "<div style='left:635px;top:23px;' class="
															+ (zone.levelArray[17] ? "'include_senior_grade'"
																	: "'disclude_grade'")
															+ ">1</div>"
															+ "<div style='left:660px;top:23px;' class="
															+ (zone.levelArray[19] ? "'include_senior_grade'"
																	: "'disclude_grade'")
															+ ">2</div>"
															+ "<div style='left:685px;top:23px;' class="
															+ (zone.levelArray[21] ? "'include_senior_grade'"
																	: "'disclude_grade'")
															+ ">3</div>"
															+ "</div>"
															+ "</td>"
															+ "<td width='18px'></td>"
															+ "<td width='44px' style='align: center;'>"
															+ "<img class='modify' src='${pageContext.request.contextPath}/images/list_modify_btn_blue.png'"
															+ "	alt='修改' onclick='modifyzone(this);' /></td>"
															+ "<td width='44px' style='align: center;'>"
															+ "<img class='edit' src='${pageContext.request.contextPath}/images/list_edit_btn.png'"
															+ "	alt='管理' onclick='editzone(this);' onmouseover='mouseover_obj(this)' onmouseout='mouseout_obj(this)' /></td>"
															+ "<td width='44px' style='align: center;'>"
															+ "<img class='delete' src='${pageContext.request.contextPath}/images/list_delete_btn.png'"
															+ "	alt='删除' onclick='deletezone(this);' onmouseover='mouseover_obj(this)' onmouseout='mouseout_obj(this)'/></td>"
															+ "<td width='18px'></td></tr>");
								}
							});
		}
		if (is_modify_allowed == 0) {
			$(".modify").css("display", "none");
		}
		if (is_register_end == 1) {
			$(".delete").css("display", "none");
		}
	}
	function deletezone(obj) {
		var zone_id = $(obj).parent().parent().attr("id").substring(5);
		ds
				.dialog({
					title : '消息提示',
					content : "将丢失该组别的全部信息，确定删除？",
					yesText : "确定",
					onyes : function() {
						$
								.ajax({
									type : 'POST',
									url : "${pageContext.request.contextPath}/league/deletezone.html",
									data : {
										zone_id : zone_id
									},
									dataType : "json",
									success : function(data) {
										if (data.result) {
											// 加载联赛列表
											loadZoneList();
										} else {
											ds.dialog({
												title : '消息提示',
												content : "删除联赛组信息失败",
												onyes : true,
												icon : "../../images/info.png"
											});
										}
									},
									error : function() {
										ds.dialog({
											title : '消息提示',
											content : "删除联赛组信息失败",
											onyes : true,
											icon : "../../images/info.png"
										});
									}
								});
					},
					noText : "取消",
					onno : function() {
						this.close();
					},
					icon : "../../images/confirm.png"
				});

	}

	function modifyzone(obj) {
		var zone_id = $(obj).parent().parent().attr("id").substring(5);
		var zone_name = $(obj).parent().parent().find("td:eq(0)").html();
		var zone_levels = $(obj).parent().parent().find("td:eq(1)").find(
				"div:eq(0)").html().split(",");
		for (var i = 0; i < zone_levels.length; i++) {
			var level_name = zone_levels[i];
			$('.levellb').each(
					function() {
						if ($(this).html() == level_name) {
							$(this).parent().find("input:checkbox").prop(
									'checked', "checked");
						}
					});
		}
		$("#zonename_input").val(zone_name);
		$(".zone_block").css("display", "block");
		$("#add_wk").css("display", "none");
		$("#modify_wk").css("display", "block");
		selected_zone_index = zone_id;
	}

	function editzone(obj) {
		var zone_id = $(obj).parent().parent().attr("id").substring(5);
		window.location.href = "${pageContext.request.contextPath}/league/zone.html?zone_id="
				+ zone_id;
	}
</script>
</head>
<body>
	<div class="operation ">
		<ul class="a_liansai">
			<li id="menubtn_back"><div>
					<img src="../images/a_fanhui.png" />
				</div>
				<p>联赛列表</p></li>
			<!--点击返回联赛列表页-->
			<li id="menubtn_league" class="border_bo"><div>
					<img src="../images/a_league.png" />
				</div>
				<p>联赛信息</p></li>
			<li id="menubtn_zone"><div>
					<img src="../images/a_zone.png" />
				</div>
				<p>设置级别</p></li>
			<li id="menubtn_delete"><div>
					<img src="../images/a_delete.png" />
				</div>
				<p>删除联赛</p></li>
		</ul>
	</div>
	<div style="margin-top: 10px; padding-top: 0px;">
		<!--基本信息-->
		<div id="league_detail" class="neirong_l" style="margin-top: 70px;">
			<table id="league_detail_tb" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td>联赛名称：</td>
						<td colspan="3">
							<div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<input class="input_text" type="text" id="name_input"
										value="${league.leagueName}">
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
									<input class="input_text" type="text" id="start_register_time"
										readonly="readonly" value="${league.registerStartDate}"
										<c:if test="${league.isModifyAllowed()==0}">disabled="true"</c:if>>
								</div>
								<div class="input_r"></div>
							</div>
						</td>
						<td>截止报名时间：</td>
						<td>
							<div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<input class="input_text" type="text" id="end_register_time"
										readonly="readonly" value="${league.registerEndDate}"
										<c:if test="${league.isRegisterEnd()==1}">disabled="true"</c:if>>
								</div>
								<div class="input_r"></div>
							</div>
						</td>
					</tr>
					<tr>
						<td>联赛开始时间：</td>
						<td>
							<div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<input class="input_text" type="text" id="league_start_time"
										readonly="readonly" value="${league.leagueBeginTime}">
								</div>
								<div class="input_r"></div>
							</div>
						</td>
						<td>联赛结束时间：</td>
						<td>
							<div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<input class="input_text" type="text" id="league_end_time"
										readonly="readonly" value="${league.leagueEndTime}">
								</div>
								<div class="input_r"></div>
							</div>
						</td>
					</tr>
					<tr>
						<td><br />
						<td>
					</tr>
					<tr>
						<td>联赛介绍：</td>
						<td colspan="3"><textarea class="input_textarea" id="league_description" rows="6"
								cols="90">${league.leagueDescription}</textarea></td>
					</tr>
					<tr>
						<td colspan="4">
							<div class="btn_wk">
								<div class="btn_l btn_l_a_green"></div>
								<div class="btn_m btn_m_a_green">
									<input type="button" class="input_btn" id="modify_btn_liansai"
										style="background: none" value="确认修改">
								</div>
								<div class="btn_r btn_r_a_green"></div>
							</div>


						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!--基本信息 END-->


		<!--设置级别-->
		<div id="league_group"
			style="width: 100%; height: 100%; display: none;">
			<!--学校查看-->
			<table class="unselectable" id="league_list" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>
						<td width='150px'><div class="table_head_left_fat green">添加比赛级别</div></td>
						<td width='720px'><div>可参加的年级</div></td>
						<td width='18px'></td>
						<td width='44px'></td>
						<td width='44px'></td>
						<td width='44px'></td>
						<td width='18px'></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="10" style="border-bottom-width: 0px;">
							<div class="tbody_sroll" style="height: 537px">
								<table id="list_zones" cellpadding="0" cellspacing="0"
									width='100%'>
								</table>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!--联赛分组 END-->

		<div class="zone_block" style="display: none">
			<div class="neirong">
				<div class="close"></div>
				<table cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td>级别名称：</td>
							<td colspan="3">
								<div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<input id="zonename_input" type="text" class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<br />
				<table id="level_table" style="width: 100%;" cellpadding="0"
					cellspacing="0">
					<tbody>
						<tr>
							<td colspan="4">可报名年级：</td>
						</tr>
						<tr>
							<c:set var="count_level" value="0"></c:set>
							<c:forEach items="${levels}" var="xx" varStatus="loop">
								<c:set var="count_level" value="${count_level+1}"></c:set>
								<td style="border-right: 0px solid rgb(167, 167, 167);"><input
									name="items" class="level_checkbox" type="checkbox"
									value="${xx.getLevelId()}" /><label class="levellb">${xx.getLevelName()}</label>
								</td>
								<c:if test="${count_level==4}">
									<tr />
									<c:set var="count_level" value="0"></c:set>
								</c:if>
							</c:forEach>
						</tr>
						<tr>
							<td>可报名运动员上限：</td>
							<td colspan="3">
								<div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<input id="zone_maxathlete" type="text" class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<div id="add_wk" class="btn_wk">
									<div class="btn_l btn_l_a_green"></div>
									<div class="btn_m btn_m_a_green">
										<input type="button" class="input_btn" id="addzone_btn"
											style="background: none" value="确定添加">
									</div>
									<div class="btn_r btn_r_a_green"></div>
								</div>
								<div id='modify_wk' class="btn_wk" style="display: none;">
									<div class="btn_l btn_l_a_green"></div>
									<div class="btn_m btn_m_a_green">
										<input type="button" class="input_btn" id="modifyzone_btn"
											style="background: none" value="确定修改">
									</div>
									<div class="btn_r btn_r_a_green"></div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<br/>
			</div>
		</div>

	</div>
</body>
</html>