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
	href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/team.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script type="text/javascript">
	var new_window = null; 
	var team_id = "${team.getTeamId()}";
	var selected_num = 0;
	var selected_atag;
	var selected_ptag;
	$(function() {
		path="${pageContext.request.contextPath}";
		$("#teamname_div").click(function() {
			$("#teamname_div").css("visibility", "hidden");
			$("#teamname_input").css("visibility", "visible");
			$("#teamname_modify_btn").css("visibility", "visible");
		})
		$('.close').click(function() {
			$('.change_num').hide();
		})
		$("#export_excel").click(function(){
			window.location.href="${pageContext.request.contextPath}/team/exportexcel.html?team_id=" + team_id;
		});
		$("#export_word").click(function(){
			window.location.href="${pageContext.request.contextPath}/team/exportword.html?team_id=" + team_id;
		});
		$("#export_pdf").click(function(){
			window.location.href="${pageContext.request.contextPath}/team/exportpdf.html?team_id=" + team_id;
		});
		$("#confirm_signup_btn").click(function(){
			ds.dialog({
				title : '消息提示',
				content : "确认报名后名单成员不可修改，确定报名？",
				yesText : "确定",
				onyes : function() {
					$.ajax({
						type : 'POST',
						url : "${pageContext.request.contextPath}/team/signtoleague.html",
						data : {
							team_id : team_id
						},
						dataType : "json",
						success : function(data) {
							if (data.success) {
								window.parent.location.href = "${pageContext.request.contextPath}/signup.html";
							} else {
								ds.dialog({
									title : '消息提示',
									content : "报名参赛失败！",
									onyes : true,
									icon : "../../images/info.png"
								});
							}
						},
						error : function() {
							ds.dialog({
								title : '消息提示',
								content : "报名参赛失败！",
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
		$("#cancel_signup_btn").click(function(){
			ds.dialog({
				title : '消息提示',
				content : "放弃报名后丢失当前球队信息，确定取消报名？",
				yesText : "确定",
				onyes : function() {
					$.ajax({
						type : 'POST',
						url : "${pageContext.request.contextPath}/team/giveupsigntoleague.html",
						data : {
							team_id : team_id
						},
						dataType : "json",
						success : function(data) {
							if (data.success) {
								window.parent.location.href = "${pageContext.request.contextPath}/signup.html";
							} else {
								ds.dialog({
									title : '消息提示',
									content : "放弃参赛失败！",
									onyes : true,
									icon : "../../images/info.png"
								});
							}
						},
						error : function() {
							ds.dialog({
								title : '消息提示',
								content : "放弃参赛失败！",
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
		$("#teamname_modify_btn")
				.click(
						function() {
							var team_name = $("#teamname_input").val();
							$
									.ajax({
										type : 'POST',
										url : "${pageContext.request.contextPath}/team/changename.html",
										data : {
											team_id : team_id,
											team_name : team_name
										},
										dataType : "json",
										success : function(data) {
											if (data.success) {
											} else {
												ds.dialog({
													title : '消息提示',
													content : "修改队名失败！",
													onyes : true,
													icon : "../../images/info.png"
												});
											}
										},
										error : function() {
											ds.dialog({
												title : '消息提示',
												content : "修改队名失败！",
												onyes : true,
												icon : "../../images/info.png"
											});
										}
									});
							$("#teamname_input").css("visibility", "hidden");
							$("#teamname_modify_btn").css("visibility",
									"hidden");
							if(team_name!=''){
								$("#teamname_div").html(team_name);
							}
							else
								$("#teamname_div").html("队伍未命名");
							$("#teamname_div").css("visibility", "visible");
						})
	});
	function open_window(url) {    
	    new_window.location.href = url;    
	}  
	function numblock(atag) {
		selected_atag = atag;
		selected_num = atag.innerHTML;
		var obj = $("a[name='numbers']");
		var nums = $("div[id='cloth']");
		for (var i = 0; i < obj.length; i++) {
			var num = obj[i].innerText;
			if (num != "Nil") {
				var div = nums[parseInt(num) - 1];
				div.setAttribute("class", "cloth_div_disabled");
			}
		}
		$('#div_choosenum').show();
	}
	function selectnum(obj) {
		var classname = $(obj).attr("class");
		if (classname == "cloth_div") {
			var nums = $("div[id='cloth']");
			var teammember_id = $(selected_atag).parent().parent().parent("tr")
					.attr("id").split("_")[1];
			
			$.ajax({
				type : 'POST',
				url : "${pageContext.request.contextPath}/team/changeathletenum.html",
				data : {
					athlete_num : $(obj).text(),
					teammember_id : teammember_id
				},
				dataType : "json",
				success : function(data) {
					if (data.success) {
						if (selected_num != "Nil") {
							$(nums[parseInt(selected_num) - 1]).attr("class", "cloth_div");
						}
						$(obj).attr("class", "cloth_div_disabled");
						$(selected_atag).html($(obj).text());
					} else {
						ds.dialog({
							title : '消息提示',
							content : "修改球衣号失败！",
							onyes : true,
							icon : "../../images/info.png"
						});
					}
				},
				error : function() {
					ds.dialog({
						title : '消息提示',
						content : "修改改球衣号失败！",
						onyes : true,
						icon : "../../images/info.png"
					});
				}
			});
			$('.change_num').hide();
		}
	}
	
	function positionblock(obj){
		selected_ptag = obj;
		var type = $(obj).attr("src").split("_")[1].substr(0, 1); 
		$('#div_chooseposition .checkimg').css("display", "none");
		$('#imgposition' + type).css("display", "block");
		$('#div_chooseposition').show();
	}
	
	function selectposition(obj){
		var id = $(obj).attr("id") + "";
		if(id != null && id != ""){
			var teammember_id = $(selected_ptag).parent().parent("tr")
								 .attr("id").split("_")[1];
			var position = id.substr(8);
			$.ajax({
				type : 'POST',
				url : "${pageContext.request.contextPath}/team/changeathleteposition.html",
				data : {
					athlete_position : position,
					teammember_id : teammember_id
				},
				dataType : "json",
				success : function(data) {
					if (data.success) {
						$(selected_ptag).attr("src", "${pageContext.request.contextPath}/images/position_" + position + ".png");
					} else {
						ds.dialog({
							title : '消息提示',
							content : "修改球员位置失败！",
							onyes : true,
							icon : "../../images/info.png"
						});
					}
				},
				error : function() {
					ds.dialog({
						title : '消息提示',
						content : "修改球员位置失败！",
						onyes : true,
						icon : "../../images/info.png"
					});
				}
			});
			$('.change_num').hide();
		}
	}
</script>
<title>报名参赛</title>
</head>
<body id="signuptoleague_body">
	<div id="signuptoleague_content">
		<div id="team_logo"></div>
		<div id="teamname_div"><c:if test="${team.getTeamName()==''}">队伍未命名</c:if>
		<c:if test="${team.getTeamName()==null}">队伍未命名</c:if>${team.getTeamName()}</div>
		<input type="text" id="teamname_input" value="${team.getTeamName()}" />
		<a id="teamname_modify_btn"></a>
		<div id="leader_img"></div>
		<div id="leadername_div">${team.getLeaderName()}</div>
		<div id="doctor_img"></div>
		<div id="doctorname_div">${team.getDoctorName()}</div>
	</div>
	<table id="coach_table" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="2" width="100%"><img
				src="${pageContext.request.contextPath}/images/member_coach_tt.png" />
			</td>
		</tr>
		<c:forEach items="${coaches}" var="xx" varStatus="loop">
			<tr id="member_${xx.getCoachTeammemberId()}">
				<td class="member_tt" width="100px"><img
					src="${pageContext.request.contextPath}/images/coach_fr.png" /></td>
				<td class="member_td" width="280px">
					<div style="width: 20px; float: left;">&nbsp;</div>
					<div style="width: 260px; float: left;">
						<a href="">${xx.getCoachName()}</a>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
	<table id="athlete_table" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="2" width="100%"><img
				src="${pageContext.request.contextPath}/images/member_athlete_tt.png" />
			</td>
		</tr>
		<c:set var="count_athlete" value="0"></c:set>
		<c:forEach items="${athletes}" var="xx" varStatus="loop">
			<c:if test="${count_athlete<9}">
				<tr id="member_${xx.getAthleteTeammemberId()}">
					<c:set var="count_athlete" value="${count_athlete+1}"></c:set>
					<td class="member_tt" width="100px"><img style="cursor:pointer;"
						src="${pageContext.request.contextPath}/images/position_${xx.getAthletePosition()}.png" onclick="positionblock(this)" />
					</td>
					<td class="member_td" width="280px">
						<div style="width: 20px; float: left;">&nbsp;</div>
						<div style="width: 80px; float: left;">
							#<a name="numbers" onclick="javascript:numblock(this);"><c:if
									test="${xx.getAthleteNum()==null}">Nil</c:if>${xx.getAthleteNum()}</a>
						</div>
						<div style="width: 170px; float: left;">
							<a href="">${xx.getIdentifiedName()}</a>
						</div>
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<table id="athlete_more_table" cellpadding="0" cellspacing="0">
		<c:forEach items="${athletes_more}" var="xx" varStatus="loop">
			<tr id="member_${xx.getAthleteTeammemberId()}">
				<td class="member_tt" width="100px"><img style="cursor:pointer;"
					src="${pageContext.request.contextPath}/images/position_${xx.getAthletePosition()}.png" onclick="positionblock(this)" />
				</td>
				<td class="member_td" width="280px">
					<div style="width: 20px; float: left;">&nbsp;</div>
					<div style="width: 80px; float: left;">
						#<a name="numbers" onclick="javascript:numblock(this);"><c:if
								test="${xx.getAthleteNum()==null}">Nil</c:if>${xx.getAthleteNum()}</a>
					</div>
					<div style="width: 170px; float: left;">
						<a href="">${xx.getIdentifiedName()}</a>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a id="export_excel"></a>
	<a id="export_word"></a>
	<a id="export_pdf"></a>
	<c:if test="${signedup==false}">
		<a id="confirm_signup_btn"></a>
		<a id="cancel_signup_btn"></a>
	</c:if>

	<!--选择球衣-->
	<div id="div_choosenum" class="change_num" style="display: none">
		<div class="neirong">
			<div class="close" style="top:-17px;right:-17px;"></div>
			<table>
				<tr>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">1</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">2</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">3</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">4</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">5</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">6</div>
					</td>
				</tr>
				<tr>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">7</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">8</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">9</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">10</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">11</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">12</div>
					</td>
				</tr>
				<tr>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">13</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">14</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">15</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">16</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">17</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">18</div>
					</td>
				</tr>
				<tr>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">19</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">20</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">21</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">22</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">23</div>
					</td>
					<td>
						<div id="cloth" class="cloth_div"
							onclick="javascript:selectnum(this)">24</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<!--选择球衣 END-->
	
	<!--选择位置 -->
	<div id="div_chooseposition" class="change_num" style="width:220px;height:220px;top:100px;left:400px;display:none;">
		<div class="neirong">
			<div class="close" style="top:-17px;right:-17px;"></div>
			<table border="0" style="width:220px;height:220px;text-align: right;">
				<tr>
					<td width="140px"><img id="position1" class="positionimg" src="${pageContext.request.contextPath}/images/position_1.png" onclick="selectposition(this)"></td>
					<td width="40px"><img id="imgposition1" class="checkimg" src="${pageContext.request.contextPath}/images/success.png" style="display:none;"></td>
					<td width="10px"></td>
				</tr>
				<tr>
					<td><img id="position2" class="positionimg" src="${pageContext.request.contextPath}/images/position_2.png" onclick="selectposition(this)"></td>
					<td><img id="imgposition2" class="checkimg" src="${pageContext.request.contextPath}/images/success.png" style="display:none;"></td>
					<td></td>
				</tr>
				<tr>
					<td><img id="position3" class="positionimg" src="${pageContext.request.contextPath}/images/position_3.png" onclick="selectposition(this)"></td>
					<td><img id="imgposition3" class="checkimg" src="${pageContext.request.contextPath}/images/success.png" style="display:none;"></td>
					<td></td>
				</tr>
				<tr>
					<td><img id="position4" class="positionimg" src="${pageContext.request.contextPath}/images/position_4.png" onclick="selectposition(this)"></td>
					<td><img id="imgposition4" class="checkimg" src="${pageContext.request.contextPath}/images/success.png" style="display:none;"></td>
					<td></td>
				</tr>
				<tr>
					<td><img id="position5" class="positionimg" src="${pageContext.request.contextPath}/images/position_5.png" onclick="selectposition(this)"></td>
					<td><img id="imgposition5" class="checkimg" src="${pageContext.request.contextPath}/images/success.png" style="display:none;"></td>
					<td></td>
				</tr>
			</table>
		</div>
	</div>
	<!--选择位置 END -->
	
</body>
</html>