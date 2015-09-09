<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>比赛管理</title>
<link type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui-1.8.16.custom.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/league.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/match.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/dialog.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui-timepicker-addon.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui-timepicker-addon.js"></script>
<!--中文-->
<script
	src="${pageContext.request.contextPath}/js/jquery.ui.datepicker-zh-CN.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery-ui-timepicker-zh-CN.js"
	type="text/javascript"></script>
<script type="text/javascript">
	var forwardurl = "${pageContext.request.contextPath}";
	$(function() {
		// 时间设置
		$('#time1').datetimepicker({
			dateFormat : "yy-mm-dd"
		});
		$('#time2').datetimepicker({
			dateFormat : "yy-mm-dd"
		});

		$("input:disabled").css('color', '#b0b5a0;')
	});
</script>
<title>比赛管理</title>
<style>
.height3 td {
	height: 40px
}
</style>
</head>
<body>
	<div class="operation ">
		<ul class="a_caipan">
			<li id="competition_liebiao" class="border_bo"><div>
					<img src="${pageContext.request.contextPath}/images/a_revise.png" />
				</div>
				<p>比赛列表</p></li>
			<c:if test="${userGroup!='9'}">
			<li id="add_competition"><div>
					<img src="${pageContext.request.contextPath}/images/a_add.png" />
				</div>
				<p>添加比赛</p></li></c:if>
		</ul>
	</div>
	<div class="neirong_wk">
		<div id="match_list">
			<!--查找-->
			<table class="search_table">
				<tbody>
					<tr>
						<td>联赛</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<select id="league_search_select">
											<option id="search_league_option_0" value="0">全部</option>
											<c:set var="count_league" value="0"></c:set>
											<c:forEach items="${leagues}" var="xx" varStatus="loop">
												<c:set var="count_level" value="${count_level+1}"></c:set>
												<option id="search_league_option_${xx.getLeagueId()}"
													value="${count_league}">${xx.getLeagueName()}</option>
											</c:forEach>
										</select>
										<div class="select_icon"></div>
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
						<td>等级</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<select id="zone_search_select">
										</select>
										<div class="select_icon"></div>
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
						<td>时间</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input type="text" id='search_time'
											style="height: 30px; border: none; background: none">
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
						<td>
							<!--  <img id="button_filter"
							src="${pageContext.request.contextPath}/images/btn_filter.png">-->
							<input type="button" id="button_filter"
							style="width: 150px; border-width: 0px; background-image: url(http://localhost:8080/YSMS/images/btn_filter.png);">
						</td>
					</tr>
				</tbody>
			</table>
			<!--查找 END-->
			<!--比赛列表-->
			<table id="competition_list" class="list_info" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>
						<td width='145px'>
							<div class="table_head_left" style="width: 160px">时&nbsp;
								&nbsp;间</div>
						</td>
						<td width="208px">联赛</td>
						<td width="95px">等级</td>
						<td width="74px">类型</td>
						<td width="195px">主队</td>
						<td width="195px">客队</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="10">
							<div class="tbody_sroll" style='height: 417px'>
								<table id="inner_table" cellpadding="0" cellspacing="0"
									width='100%'>
								</table>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<!--比赛列表 END-->

			<!--分页-->
			<div id="paging" class="choose_bottom">
				<div class="choose_btn_delete">
					<p style="" id="page_setting" class="choose_kuai">
						<input id='pageIndex' type='text' width='10px' value='1'>
					</p>
				</div>
			</div>
			<!--分页 END-->

			<!--修改列表的弹出框-->
			<div class="edit_match">
				<div class="close"></div>
				<!--内容-->
				<table class="competition_apply">
					<tr>
						<td>所属联赛：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input type="text" disabled="disabled" id="game_league_modify" />
										<div class="select_icon"></div>
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
						<td>裁判员：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input <c:if test="${userGroup!='1'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
											id="judgeposition_1" class="choose_judge_input">
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
					</tr>
					<tr>
						<td>联赛等级：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input type="text" disabled="disabled" id="game_zone_modify" />
										<div class="select_icon"></div>
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
						<td>第一助理裁判：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input <c:if test="${userGroup!='1'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
											id="judgeposition_2" class="choose_judge_input">
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
					</tr>
					<tr>
						<td>比赛类型：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input type="text" disabled="disabled" id="game_group_modify" />
										<div class="select_icon"></div>
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
						<td>第二助理裁判：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input <c:if test="${userGroup!='1'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
											id="judgeposition_3" class="choose_judge_input">
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
					</tr>
					<tr>
						<td>主队学校：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input type="text" disabled="disabled" id="host_team_modify" />
										<div class="select_icon"></div>
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
						<td>第四官员：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input <c:if test="${userGroup!='1'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
											id="judgeposition_4" class="choose_judge_input">
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
					</tr>
					<tr>
						<td>主队球衣：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input id="host_uniform_modify" type="text">
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
						<td>裁判监督：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input <c:if test="${userGroup!='4'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
											id="judgeposition_5" class="choose_judge_input">
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
					</tr>
					<tr>
						<td>客队学校：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input type="text" disabled="disabled" id="guest_team_modify" />
										<div class="select_icon"></div>
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
						<td>比赛监督：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input <c:if test="${userGroup!='4'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
											id="judgeposition_6" class="choose_judge_input">
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
					</tr>
					<tr>
						<td>客队球衣：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input id="guest_uniform_modify" type="text">
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
						<td>统&nbsp;&nbsp;&nbsp;计：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input <c:if test="${userGroup!='1'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
											id="judgeposition_7" class="choose_judge_input">
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
					</tr>
					<tr>
						<td>比赛时间：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input type="text" id='time1'>
										<!--时间表-->
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
						<td>统&nbsp;&nbsp;&nbsp;计：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input <c:if test="${userGroup!='1'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
											id="judgeposition_8" class="choose_judge_input">
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
					</tr>
					<tr>
						<td>比赛地点：</td>
						<td><div class="input_wk">
								<div class="input_l"></div>
								<div class="input_m">
									<div class="select_wk">
										<input type="text" id="address_modify">
									</div>
								</div>
								<div class="input_r"></div>
							</div></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="4">
							<div class="btn_wk">
								<div class="btn_l btn_l_a_green"></div>
								<div class="btn_m btn_m_a_green">
									<input type="button" class="input_btn" id="modifymatch_btn"
										style="background: none" value="确认修改">
								</div>
								<div class="btn_r btn_r_a_green"></div>
							</div>
						</td>
					</tr>
				</table>

			</div>
			<!--修改列表的弹出框 END-->

			<!--比赛结果 登记-->
			<div class="saishi_results">
				<div class="close"></div>
				<div class="score">
					<table width="100%" style="text-align: center">
						<tr>
							<td style="width: 150px;">
								<table>
									<tr>
										<td><img id="host_downloadteammemberlist"
											class="download"
											src="${pageContext.request.contextPath}/images/gameview_downloadteammemberlist.png" /></td>
									</tr>
									<tr>
										<td><img id="host_suspension" class="download"
											src="${pageContext.request.contextPath}/images/gameview_downloadcardiinfo.png" /></td>
									</tr>
								</table>
							</td>
							<td><img
								src="${pageContext.request.contextPath}/images/logo.png">
								<p id="record_host_school_name"></p></td>
							<td class="score_score"><input id="record_host_score"
								type="text" onfocus="if(this.value == '--') this.value = ''"
								onblur="if(this.value =='') this.value = '--'"></td>
							<td><img
								src="${pageContext.request.contextPath}/images/vs_icon2.png"></td>
							<td class="score_score"><input id="record_guest_score"
								type="text" onfocus="if(this.value == '--') this.value = ''"
								onblur="if(this.value =='') this.value = '--'"></td>
							<td><img
								src="${pageContext.request.contextPath}/images/logo.png">
								<p id="record_guest_school_name"></p></td>
							<td style="width: 150px;">
								<table>
									<tr>
										<td><img id="guest_downloadteammemberlist"
											class="download"
											src="${pageContext.request.contextPath}/images/gameview_downloadteammemberlist.png" /></td>
									</tr>
									<tr>
										<td><img id="guest_suspension" class="download"
											src="${pageContext.request.contextPath}/images/gameview_downloadcardiinfo.png" /></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>

				<div class="xijie">
					<table class="fenlai_2">
						<tr>
							<!--第一个学校-->
							<td class="td_waikuang" style="border-left: 1px solid #eee">
								<!-- <span class="school_name" id="record_host_team_name"></span> -->
								<div class="tab_xijie">
									<span class="span_tab">进球得分</span> <span>红黄牌</span><span>比赛数据</span>
								</div>

								<table class="honghuangpai" cellpadding="0" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<td width="83px">球衣号码</td>
											<td width="130px">运动员</td>
											<td width="113px">犯规类型</td>
											<td width="90px">犯规时间</td>
											<td></td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td colspan="6">
												<div class="tbody_sroll"
													style="height: 256px; overflow: auto;">
													<table id="host_foul_table" cellpadding="0" cellspacing="0"
														width="100%">
														<tr id="host_foul_bottom_tr">
															<td colspan="6" style="text-align: right"><img
																src="images/add_jilu.png"></td>
														</tr>
													</table>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
								<table class="personscore" cellpadding="0" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<td width="65px">球衣号码</td>
											<td width="90px">进球球员</td>
											<td width="65px">球衣号码</td>
											<td width="90px">助攻球员</td>
											<td width="90px">进球类型</td>
											<td width="70px">进球时间</td>
											<td></td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td colspan="8">
												<div class="tbody_sroll"
													style="height: 256px; overflow: auto;">
													<table id="host_goal_table" cellpadding="0" cellspacing="0"
														width="100%">
														<tr id="host_goal_bottom_tr">
															<td colspan="8" style="text-align: right"><img
																src="images/add_jilu.png"></td>
														</tr>
													</table>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
								<table class="otherrecord" cellpadding="0" cellspacing="0"
									width="100%" height="300px">
									<thead>
										<tr>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td colspan="8">
												<div class="tbody_sroll"
													style="height: 256px; overflow: auto;">
													<table id="host_otherrecord_table" cellpadding="0"
														cellspacing="0" width="100%">
														<tr>
															<td width="135px">射门次数：</td>
															<td width="100px"><input id="host_goalattempt_input"></td>
															<td width="135px">射正次数：</td>
															<td width="100px"><input
																id="host_targetnumber_input"></td>
														</tr>
														<tr>
															<td>角球：</td>
															<td><input id="host_cornerkick_input"></td>
															<td>任意球：</td>
															<td><input id="host_freekick_input"></td>
														</tr>
														<tr>
															<td>犯规：</td>
															<td><input id="host_foul_input"></td>
															<td>越位：</td>
															<td><input id="host_offside_input"></td>
														</tr>
														<tr>
															<td colspan="2"><input type="checkbox"
																class="overtime_checkbox"
																style='vertical-align: middle;'
																id="host_isovertime_flag"
																onchange="overtime_checkbox_change(this)"><a>是否加时赛</a></td>
															<td>加时赛得分：</td>
															<td><input id="host_overtime_score"
																disabled="disabled"></td>
														</tr>
														<tr>
															<td colspan="2"><input type="checkbox"
																class="penalty_checkbox" style='vertical-align: middle;'
																id="host_ispenalty_flag"
																onchange="penalty_checkbox_change(this)"><a>是否点球决胜</a></td>
															<td>球点球得分：</td>
															<td><input id="host_penalty_score"
																disabled="disabled"></td>
														</tr>

													</table>
												</div>
											</td>
										</tr>
									</tbody>
								</table>

							</td>
							<!--第一个学校 END-->
							<!--第二个学校-->
							<td class="td_waikuang">
								<!-- <span class="school_name2" id="record_guest_team_name"></span> -->
								<div class="tab_xijie">
									<span class="span_tab">进球得分</span><span>红黄牌</span><span>比赛数据</span>
								</div>
								<table class="honghuangpai" cellpadding="0" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<td width="83px">球衣号码</td>
											<td width="130px">运动员</td>
											<td width="113px">犯规类型</td>
											<td width="90px">犯规时间</td>
											<td></td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td colspan="6">
												<div class="tbody_sroll"
													style="height: 256px; overflow: auto;">
													<table id="guest_foul_table" cellpadding="0"
														cellspacing="0" width="100%">
														<tr id="guest_foul_bottom_tr">
															<td colspan="6" style="text-align: right"><img
																src="images/add_jilu.png"></td>
														</tr>
													</table>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
								<table class="personscore" cellpadding="0" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<td width="65px">球衣号码</td>
											<td width="90px">进球球员</td>
											<td width="65px">球衣号码</td>
											<td width="90px">助攻球员</td>
											<td width="90px">进球类型</td>
											<td width="70px">进球时间</td>
											<td></td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td colspan="8">
												<div class="tbody_sroll"
													style="height: 256px; overflow: auto;">
													<table id="guest_goal_table" cellpadding="0"
														cellspacing="0" width="100%">
														<tr id="guest_goal_bottom_tr">
															<td colspan="8" style="text-align: right"><img
																src="images/add_jilu.png"></td>
														</tr>
													</table>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
								<table class="otherrecord" cellpadding="0" cellspacing="0"
									width="100%" height="300px">
									<thead>
										<tr>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td colspan="8">
												<div class="tbody_sroll"
													style="height: 256px; overflow: auto;">
													<table id="guest_otherrecord_table" cellpadding="0"
														cellspacing="0" width="100%">
														<tr>
															<td width="135px">射门次数：</td>
															<td width="100px"><input
																id="guest_goalattempt_input"></td>
															<td width="135px">射正次数：</td>
															<td width="100px"><input
																id="guest_targetnumber_input"></td>
														</tr>
														<tr>
															<td>角球：</td>
															<td><input id="guest_cornerkick_input"></td>
															<td>任意球：</td>
															<td><input id="guest_freekick_input"></td>
														</tr>
														<tr>
															<td>犯规：</td>
															<td><input id="guest_foul_input"></td>
															<td>越位：</td>
															<td><input id="guest_offside_input"></td>
														</tr>
														<tr>
															<td colspan="2"><input type="checkbox"
																class="overtime_checkbox"
																style='vertical-align: middle;'
																id="guest_isovertime_flag"
																onchange="overtime_checkbox_change(this)"><a>是否加时赛</a></td>
															<td>加时赛得分：</td>
															<td><input id="guest_overtime_score"
																disabled="disabled"></td>
														</tr>
														<tr>
															<td colspan="2"><input type="checkbox"
																class="penalty_checkbox" style='vertical-align: middle;'
																id="guest_ispenalty_flag"
																onchange="penalty_checkbox_change(this)"><a>是否点球大战</a></td>
															<td>点球大战得分：</td>
															<td><input id="guest_penalty_score"
																disabled="disabled"></td>
														</tr>

													</table>
												</div>
											</td>
										</tr>
									</tbody>
								</table>

							</td>
							<!--第二个学校 END-->
						</tr>
						<tr>
							<td colspan="7"><a id="gamestatus0" onclick="setGameOver()"
								href="javascript:void(0)" style="display: inline;">设置完赛 </a> <a
								id="gamestatus1" onclick="cancelGameOver()"
								href="javascript:void(0)" style="display: none;">取消完赛 </a> <a
								id="save_record" href="javascript:void(0)">保 &nbsp; &nbsp;存
							</a> <a id="cancel_record" href="javascript:void(0)">取 &nbsp;
									&nbsp; 消</a></td>
						</tr>
					</table>
				</div>
			</div>
			<!--比赛结果-->
		</div>

		<!--添加比赛-->
		<div id="competition_apply" style="display: none">
			<table class="competition_apply">
				<tr>
					<td>所属联赛：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<select id="game_league_select">
										<option value="0">--请选择--</option>
										<c:set var="count_league" value="0"></c:set>
										<c:forEach items="${leagues}" var="xx" varStatus="loop">
											<c:set var="count_level" value="${count_level+1}"></c:set>
											<option id="game_league_option_${xx.getLeagueId()}"
												value="${count_league}">${xx.getLeagueName()}</option>
										</c:forEach>
									</select>
									<div class="select_icon"></div>
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
					<td>裁判员：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<input <c:if test="${userGroup!='1'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
										value="暂不支持" class="choose_judge_input">
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
				</tr>
				<tr>
					<td>联赛等级：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<select id="game_zone_select">
									</select>
									<div class="select_icon"></div>
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
					<td>第一助理裁判：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<input <c:if test="${userGroup!='1'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
										value="暂不支持" class="choose_judge_input">
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
				</tr>
				<tr>
					<td>联赛分组：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<select id="game_group_select">
										<option value="0">--请选择--</option>
										<option value="1">A组</option>
										<option value="2">B组</option>
										<option value="3">C组</option>
										<option value="4">D组</option>
										<option value="5">淘汰赛</option>
									</select>
									<div class="select_icon"></div>
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
					<td>第二助理裁判：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<input <c:if test="${userGroup!='1'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
										value="暂不支持" class="choose_judge_input">
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
				</tr>
				<tr>
					<td>主队学校：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<select onchange="refresh_select_team_list(this)"
										id="host_team_select" class="refresh_select">
										<option id="team_select_option_0" value="0">--请选择--</option>
									</select>
									<div class="select_icon"></div>
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
					<td>第四官员：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<input <c:if test="${userGroup!='1'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
										value="暂不支持" class="choose_judge_input">
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
				</tr>
				<tr>
					<td>主队球衣：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<input id="host_uniform_input" type="text">
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
					<td>比赛监督：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<input <c:if test="${userGroup!='4'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
										value="暂不支持" class="choose_judge_input">
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
				</tr>
				<tr>
					<td>客队学校：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<select onchange="refresh_select_team_list(this)"
										id="guest_team_select" class="refresh_select">
										<option id="team_select_option_0" value="0">--请选择--</option>
									</select>
									<div class="select_icon"></div>
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
					<td>裁判监督：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<input <c:if test="${userGroup!='4'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
										value="暂不支持" class="choose_judge_input">
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
				</tr>
				<tr>
					<td>客队球衣：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<input id="guest_uniform_input" type="text">
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
					<td>统&nbsp;&nbsp;&nbsp;计：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<input <c:if test="${userGroup!='1'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
										value="暂不支持" class="choose_judge_input">
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
				</tr>
				<tr>
					<td>比赛时间：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<input type="text" id='time2'>
									<!--时间表-->
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
					<td>统&nbsp;&nbsp;&nbsp;计：</td>
					<td><div class="input_wk" class="choose_judge_input">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<input <c:if test="${userGroup!='1'}">disabled="disabled" readOnly="readonly"</c:if> type="text"
										value="暂不支持">
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
				</tr>
				<tr>
					<td>比赛地点：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<div class="select_wk">
									<input type="text" id="address">
								</div>
							</div>
							<div class="input_r"></div>
						</div></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="4">
						<div class="btn_wk">
							<div class="btn_l btn_l_a_green"></div>
							<div class="btn_m btn_m_a_green">
								<input type="button" class="input_btn" id="addmatch_btn"
									style="background: none" value="确认添加">
							</div>
							<div class="btn_r btn_r_a_green"></div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<!--添加比赛 END-->
		<div class="suspension_block">
			<div class="outerclose"></div>
			<table class="personscore" id="suspension_table" cellpadding="0" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<td>球衣号码</td>
						<td>球员姓名</td>
						<td>停赛原因</td>
					</tr>
				</thead>
				<tbody>
					<tr>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="choose_judge_block">
			<div class="outerclose"></div>
			<br/>
			<div id="judge_table_container">
			<table class="judges" id="judges" cellpadding="0" cellspacing="0" width="90%" style="margin-left:5%;">
				<thead>
					<tr>
						<td colspan="2" style="text-align:center;">选择裁判员&nbsp;&nbsp;<a id="cancel_judge_selection" href="javascript:void(0)">取消选择</a></td>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/js/match.js"
			type="text/javascript"></script>
	</div>
</body>
</html>