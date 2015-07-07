<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>联赛级别管理</title>
<link type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui-1.8.16.custom.css"
	rel="stylesheet" />
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dialog.css">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/league.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
 
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ui.datepicker-zh-CN.js"></script>
	<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<!--	<script src="js/combobox/common.js" type="text/javascript"></script>
    <script src="js/combobox/combobox.js" type="text/javascript"></script>
    -->
<style type="text/css">
.neirong_wk {
	padding: 0;
	height: 565px;
	margin-top: 5px !important;
}

.operation .a_caipan {
	width: 520px;
}
/**/
.neirong_wk>ul li {
	float: left;
	width: 170px;
	background:#127419;
	color: #fff;
	font-size: 1.2em;
	height: 48px;
	cursor: pointer;
	position: relative;
}

.neirong_wk>ul {
	width: 98%;
	height: 48px;
	margin: 0 auto;
}

.neirong_wk>ul li>div {
	height: 100%;
	width: 100%;
	line-height: 48px;
	text-align: center;
	position: absolute;
	top: 0;
	left: 0;
}

.tab {
	background: #127419 !important;
	box-shadow: 0 0 5px rgba(0, 0, 0, 1);
	height: 110% !important;
	width: 110% !important;
	top: -5% !important;
	left: -5% !important;
	z-index: 2;
}

.group {
	height: 460px;
	width: 99%;
	margin: -10px auto;
}

#group_stage>ul {
	width: 100%;
	margin: 50px auto;
	height: 350px;
}

#group_stage>ul>li {
	width: 25%;
	height: 350px;
	float: left;
}

#group_stage img {
	height: 36px;
	width: auto;
}

#group_stage i {
	height: 36px;
	width: auto;
}

.group_kuang {
	height: 98%;
	width: 98%;
	margin-top: 1%;
	margin-left: 1%;
	border: 1px solid #ccc;
	overflow: hidden;
	font-weight: bolder;
}

.group_kuang table {
	width: 90%;
	height: 80%;
	text-align: center;
	margin: 10px auto;
}

.group_kuang select {
	border-radius: 3px;
	border: 1px solid #fff;
}

.group_title {
	  height: 43px;
	  line-height: 43px;
	  padding-left: 20px;
	  background: #fff;
	  font-size: 1.5em;
	  text-align: center;
	  color: #fff!important;
}

.color1,.color3 {
	background: #9198ab;
	border: 1px solid #fff;
	color: #fff;
}
.color1 .group_title,.color3 .group_title{
	background:url(../images/group_title1.png)
}
.color2,.color4 {
	background: #ecf0f5;
	border: 1px solid #fff;
	color: #000;
}
.color2 .group_title,.color4 .group_title{
	background:url(../images/group_title2.png)
}
#group_a1,#group_a3{
	color:#000;
}


#elimination_game table {
	width: 98%;
	margin: 10px auto;
	height: 80%;
	text-align: center;
}

#elimination_game td {
	position: relative;
}

#elimination_game td>div {
	position: absolute;
	width: 30px;
	top: -58%;
	left: 0;
}

#elimination_game a {
	padding: 2px 8px;
	border-radius: 3px;
	border: 1px solid #0a982c;
	background: #2fc152;
	cursor: pointer;
	color: #fff;
	text-decoration: none
}

#elimination_game a:hover {
	background: #058323;
}

#elimination_game select {
	border-radius: 3px;
}

.add_match {
	position: absolute;
	top: 1%;
	left: 1%;
	height: 98%;
	width: 98%;
	border-radius: 5px;
	border: 1px solid #0fd46c;
	background: #fff;
	display: none;
	z-index: 3
}

.close {
	position: absolute;
	height: 36px;
	width: 36px;
	right: -13px;
	top: -13px;
	cursor: pointer;
	background:
		url(${pageContext.request.contextPath}/images/outdiv_delete.png);
}
.btn_wk{margin:-10px auto!important;}
</style>
<body>
	<% String leagueId=request.getParameter("leagueId");
	   Integer zoneId=(Integer)session.getAttribute("zoneId");
	
	%>


	<%-- 	<div class="operation ">
					<ul class="a_caipan">
						<li id="competition_liebiao"><div>
								<img src="${pageContext.request.contextPath}/images/a_fanhui.png" />
							</div>
							<p>返回联赛</p></li>
						<li id="add_competition"><div>
								<img src="${pageContext.request.contextPath}/images/a_groups.png" />
							</div>
							<p>新增组别</p></li>
					</ul>
				</div> --%>
	<div class="neirong_wk">
		<ul class="tab_ul">
			<li><div class="tab">小组赛</div></li>
		<!-- 	<li><div>淘汰赛</div></li> -->
		</ul>
		<!--小组赛-->
		<div id="group_stage" class="group"  >
			<ul>
				<li>
					<div class='group_kuang color1'>
						<div class="group_title">A &nbsp; 组</div>
						<table>
							<tbody>
								<tr>
									<td>A1</td>
									<td><img
										src="${pageContext.request.contextPath}/images/logo.png"></td>
									<td><select name="group_select" id="group_a1"
										onchange="getTeams()">
											<!--select值每改变一次 前一个太多里面的img数据库查找更换一次-->
											<!-- <option>--请选择A1球队--</option> -->
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>A2</td>
									<td><img
										src="${pageContext.request.contextPath}/images/logo.png"></td>
									<td><select name="group_select" id="group_a2" onchange="getTeams()">
											<option value="">--请选择球队--</option>
											 
									</select></td>
								</tr>
								<tr>
									<td>A3</td>
									<td><img
										src="${pageContext.request.contextPath}/images/logo.png"></td>
									<td><select name="group_select" id="group_a3" onchange="getTeams()">
											<option value="">--请选择球队--</option>
											 
									</select></td>
								</tr>
								<tr>
									<td>A4</td>
									<td><img
										src="${pageContext.request.contextPath}/images/logo.png"></td>
									<td><select name="group_select" id="group_a4" onchange="getTeams()">
											<option value="">--请选择球队--</option>
										 
									</select></td>
								</tr>
								<tr>
									<td>A5</td>
									<td><img
										src="${pageContext.request.contextPath}/images/logo.png"></td>
									<td><select name="group_select" id="group_a5" onchange="getTeams()">
											<option value="">--请选择球队--</option>
											 
									</select></td>
								</tr>
								<tr>
									<td>A6</td>
									<td><img
										src="${pageContext.request.contextPath}/images/logo.png"></td>
									<td><select name="group_select" id="group_a6" onchange="getTeams()">
											<option value="">--请选择球队--</option>
											 
									</select></td>
								</tr>
							</tbody>
						</table>
					</div>
				</li>
				<li>
					<div class='group_kuang color2'>
						<div class="group_title">B &nbsp; 组</div>
						<table>
							<tbody>
								<tr>
									<td>B1</td>
									<td></td>
									<td><select name="group_select" id="group_b1" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>B2</td>
									<td></td>
									<td><select name="group_select" id="group_b2" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>B3</td>
									<td></td>
									<td><select name="group_select" id="group_b3" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>B4</td>
									<td></td>
									<td><select name="group_select" id="group_b4" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>B5</td>
									<td></td>
									<td><select name="group_select" id="group_b5" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>B6</td>
									<td></td>
									<td><select name="group_select" id="group_b6" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
							</tbody>
						</table>
					</div>
				</li>
				<li>
					<div class='group_kuang color3'>
						<div class="group_title">C &nbsp; 组</div>
						<table>
							<tbody>
								<tr>
									<td>C1</td>
									<td></td>
									<td><select name="group_select" id="group_c1" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>C2</td>
									<td></td>
									<td><select name="group_select" id="group_c2" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>C3</td>
									<td></td>
									<td><select name="group_select" id="group_c3" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>C4</td>
									<td></td>
									<td><select name="group_select" id="group_c4" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>C5</td>
									<td></td>
									<td><select name="group_select" id="group_c5" onchange="getTeams()">
										<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>C6</td>
									<td></td>
									<td><select name="group_select" id="group_c6" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
							</tbody>
						</table>
					</div>
				</li>
				<li>
					<div class='group_kuang color4'>
						<div class="group_title">D &nbsp; 组</div>
						<table>
							<tbody>
								<tr>
									<td>D1</td>
									<td></td>
									<td><select name="group_select" id="group_d1" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>D2</td>
									<td></td>
									<td><select name="group_select" id="group_d2" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>D3</td>
									<td></td>
									<td><select name="group_select" id="group_d3" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>D4</td>
									<td></td>
									<td><select name="group_select" id="group_d4" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>D5</td>
									<td></td> 
									<td><select name="group_select" id="group_d5" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
								<tr>
									<td>D6</td>
									<td></td>
									<td><select name="group_select" id="group_d6" onchange="getTeams()">
											<option value="">--请选择球队--</option>
									</select></td>
								</tr>
							</tbody>
						</table>
					</div>
				</li>
			</ul>
			<div class="btn_wk">
				<div class="btn_l btn_l_a_green"></div>
				<div class="btn_m btn_m_a_green">
					<input type="button" class="input_btn" id="create_btn"
						style="background: none" value="提交分组" onclick="grouping()">
				</div>
				<div class="btn_r btn_r_a_green"></div>
			</div>
		</div>
		<!--小组赛-->

		<!--淘汰赛-->
		<div id="elimination_game" class="group" style="display: none">
			<table>
				<tr>
					<td><select name="" id="eight_1">
							<option>--请选择A1球队--</option>
							<option>南京第一中学</option>
							<option>南京第九中学</option>
							<option>金陵中学</option>
							<option>中华中学</option>
							<option>南京师大附属</option>
							<option>南京第三中学</option>
					</select></td>
					<td width='20px'></td>
					<td></td>
					<td width='20px'></td>
					<td></td>
					<td></td>
					<td width='20px'></td>
					<td></td>
					<td width='20px'></td>
					<td><select name="" id="eight_2">
							<option>--请选择A1球队--</option>
							<option>南京第一中学</option>
							<option>南京第九中学</option>
							<option>金陵中学</option>
							<option>中华中学</option>
							<option>南京师大附属</option>
							<option>南京第三中学</option>
					</select></td>
				</tr>
				<tr>
					<td><a href="javascript:create_match(eight_1,eight_3)">新建比赛</a>
					</td>
					<td>
						<div
							style="height: 123px; background: url(${pageContext.request.contextPath}/images/weikaisai_left.png) no-repeat;"></div>
					</td>
					<td><select name="" id="four_1">
							<option>--请选择A1球队--</option>
							<option>南京第一中学</option>
							<option>南京第九中学</option>
							<option>金陵中学</option>
							<option>中华中学</option>
							<option>南京师大附属</option>
							<option>南京第三中学</option>
					</select></td>
					<td><div style="height: 110px;"></div></td>
					<td></td>
					<td></td>
					<td><div style="height: 110px;"></div></td>
					<td><select name="" id="four_1">
							<option>--请选择A1球队--</option>
							<option>南京第一中学</option>
							<option>南京第九中学</option>
							<option>金陵中学</option>
							<option>中华中学</option>
							<option>南京师大附属</option>
							<option>南京第三中学</option>
					</select></td>
					<td>
						<div
							style="height: 123px; background: url(${pageContext.request.contextPath}/images/weikaisai_right.png) no-repeat;"></div>
					</td>
					<td><a href="javascript:create_match(eight_2,eight_4)">新建比赛</a>
					</td>
				</tr>
				<tr>
					<td><select name="" id="eight_3">
							<option>--请选择A1球队--</option>
							<option>南京第一中学</option>
							<option>南京第九中学</option>
							<option>金陵中学</option>
							<option>中华中学</option>
							<option>南京师大附属</option>
							<option>南京第三中学</option>
					</select></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><select name="" id="eight_4">
							<option>--请选择A1球队--</option>
							<option>南京第一中学</option>
							<option>南京第九中学</option>
							<option>金陵中学</option>
							<option>中华中学</option>
							<option>南京师大附属</option>
							<option>南京第三中学</option>
					</select></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><a href="javascript:create_match(four_1,four_3)">新建比赛</a>
					</td>
					<td>
						<div
							style="height: 233px; background: url(${pageContext.request.contextPath}/images/weikaisai_long_left.png) no-repeat; top: -158%"></div>
					</td>
					<td><select name="" id="two_1">
							<option>--请选择A1球队--</option>
							<option>南京第一中学</option>
							<option>南京第九中学</option>
							<option>金陵中学</option>
							<option>中华中学</option>
							<option>南京师大附属</option>
							<option>南京第三中学</option>
					</select> <a href="javascript:create_match(two_1,two_2)"
						style="position: absolute; top: 100%; left: 72%; width: 70px; z-index: 2;">新建比赛</a>
					</td>
					<td><select name="" id="two_2">
							<option>--请选择A1球队--</option>
							<option>南京第一中学</option>
							<option>南京第九中学</option>
							<option>金陵中学</option>
							<option>中华中学</option>
							<option>南京师大附属</option>
							<option>南京第三中学</option>
					</select></td>
					<td><div
							style="height: 233px; background: url(${pageContext.request.contextPath}/images/weikaisai_long_right.png) no-repeat; top: -158%"></div></td>
					<td><a href="javascript:create_match(four_2,four_2)">新建比赛</a>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><select name="" id="eight_5">
							<option>--请选择A1球队--</option>
							<option>南京第一中学</option>
							<option>南京第九中学</option>
							<option>金陵中学</option>
							<option>中华中学</option>
							<option>南京师大附属</option>
							<option>南京第三中学</option>
					</select></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><select name="" id="eight_6">
							<option>--请选择A1球队--</option>
							<option>南京第一中学</option>
							<option>南京第九中学</option>
							<option>金陵中学</option>
							<option>中华中学</option>
							<option>南京师大附属</option>
							<option>南京第三中学</option>
					</select></td>
				</tr>
				<tr>
					<td><a href="javascript:create_match(eight_5,eight_7)">新建比赛</a>
					</td>
					<td>
						<div
							style="height: 123px; background: url(${pageContext.request.contextPath}/images/weikaisai_left.png) no-repeat;"></div>
					</td>
					<td><select name="" id="four_3">
							<option>--请选择A1球队--</option>
							<option>南京第一中学</option>
							<option>南京第九中学</option>
							<option>金陵中学</option>
							<option>中华中学</option>
							<option>南京师大附属</option>
							<option>南京第三中学</option>
					</select></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><select name="" id="four_4">
							<option>--请选择A1球队--</option>
							<option>南京第一中学</option>
							<option>南京第九中学</option>
							<option>金陵中学</option>
							<option>中华中学</option>
							<option>南京师大附属</option>
							<option>南京第三中学</option>
					</select></td>
					<td>
						<div
							style="height: 123px; background: url(${pageContext.request.contextPath}/images/weikaisai_right.png) no-repeat;"></div>
					</td>
					<td><a href="javascript:create_match(eight_6,eight_8)">新建比赛</a>
					</td>
				</tr>
				<tr>
					<td><select name="" id="eight_7">
							<option>--请选择A1球队--</option>
							<option>南京第一中学</option>
							<option>南京第九中学</option>
							<option>金陵中学</option>
							<option>中华中学</option>
							<option>南京师大附属</option>
							<option>南京第三中学</option>
					</select></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><select name="" id="eight_8">
							<option>--请选择A1球队--</option>
							<option>南京第一中学</option>
							<option>南京第九中学</option>
							<option>金陵中学</option>
							<option>中华中学</option>
							<option>南京师大附属</option>
							<option>南京第三中学</option>
					</select></td>
				</tr>
			</table>
			<div class="add_match">
				<div class="close"></div>
			</div>
		</div>
		<!--淘汰赛-->
		
		
		<div id="paging" class="choose_bottom">
				<div class="choose_btn_delete">
					
				</div>
			</div>
	</div>


	<script type="text/javascript">
$(function(){
	init();
	
	//tab和对应内容切换
 $('.tab_ul li').click(function(){
 	$('.tab_ul  div').removeClass('tab');
 	$(this).find('div').addClass('tab');
 	if($(this).index()==1){
 		$('#group_stage').hide();
 		$('#elimination_game').show();
 	}
 	else if($(this).index()==0){
 		$('#group_stage').show();
 		$('#elimination_game').hide();
 	}
 })
 //
 $('#elimination_game tr').each(function(){$(this).find('td:eq(4)').css('border-right','1px solid #aaa')})
 $('.close').click(function(){
 	$('.add_match').hide()
 })
})

function create_match(el1,el2){
	//**el1,el2对应的两个队伍的Id
	$('.add_match').show()
}


function getTeams(){
	 
	var id="";
	$("select[name=group_select]").each(function(){
		 
		 if($(this).val()!=null&&$(this).val()!=""){
			 id+=$(this).val()+",";
		 }
	})
	 
 	$.ajax( {
		async : false,
		cache : false,
		type : 'POST',
	  	data : {
	  		 zoneId:<%=zoneId%>,
	  		 teamId:id
		},  
		dataType : "json",
		url : "<%=basePath%>league/getNotSelectedTeams.html",
		//请求的action路径
		error : function() { //请求失败处理函数
			ds.dialog({
				title : '消息提示',
				content : "请求失败，请联系管理员！",
				onyes : true,
				icon : "../images/info.png"
			});
		},
		success : function(data) { //请求成功后处理函数。  
			 if(data!=null){
				 
				
					 $("select[name=group_select]").each(function(){
						 
						 if($(this).val()==null||$(this).val()==""){
							  $(this).empty();
							  $(this).append("<option value=''>--请选择球队--</option>")
							    
							  for(var i=0;i<data.length;i++){  
							  $(this).append("<option value='"+data[i].team_id+"'>"+data[i].school_name+"</option>")
							  }
						 }else{
							  var tempText=$(this).find("option:selected").text();
							  var tempVal=$(this).val();
							  $(this).empty();
							  $(this).append("<option value=''>--请选择球队--</option>")
							    $(this).append("<option value='"+tempVal+"'>"+tempText+"</option>")
							  for(var i=0;i<data.length;i++){  
							  $(this).append("<option value='"+data[i].team_id+"'>"+data[i].school_name+"</option>")
							  }
							  $(this).val(tempVal);
						 }
					 })
				 
					
			 }
		}
	})  
}

 
 function grouping(){
	 var zone_id="";
	 var team_group="";
	 
	 $("select[name=group_select]").each(function(i){  
		 
		team_group+= $(this).val()+",";	  
	 })
	  
		$.ajax( {
			async : false,
			cache : false,
			type : 'POST',
		  	data : {
		  		zone_id:<%=zoneId%>,
		  		team_group:team_group
			},  
			dataType : "json",
			url : "<%=basePath%>league/leaguegroupforteams.html",
			//请求的action路径
			error : function() { //请求失败处理函数
				ds.dialog({
					title : '消息提示',
					content : "请求失败，请联系管理员！",
					onyes : true,
					icon : "../../images/info.png"
				});
			},
			success : function(data) { //请求成功后处理函数。  
		 
				 if( data.returnMessage==true||data.returnMessage=="true"){
					 ds.dialog({
							title : '消息提示',
							content : "分 组 成 功 ！",
							onyes : true,
							 icon : '../../images/socceralert.png'
						});
						$("select[name=group_select]").each(function(){
							 
								 $(this).val("")
							 
						})
					init();
				 }else{
					 ds.dialog({
							title : '消息提示',
							content : "分 组 失 败 ！",
							onyes : true,
							 icon : '../../images/info.png'
						});
				 }
			}
		})  
 }
 
 
 
 function init(){
	 	
	 	$.ajax( {
			async : false,
			cache : false,
			type : 'POST',
		  	data : {
		  		 zoneId:<%=zoneId%>,
			},  
			dataType : "json",
			url : "<%=basePath%>league/getNotSelectedTeams.html",
			//请求的action路径
			error : function() { //请求失败处理函数
				ds.dialog({
					title : '消息提示',
					content : "请求失败，请联系管理员！",
					onyes : true,
					icon : "../images/info.png"
				});
			},
			success : function(data) { //请求成功后处理函数。  
				 if(data!=null){
						 var a=1;
						 var b=1;
						 var c=1;
						 var d=1;
						
						 $("select[name=group_select]").each(function(){	
									
							    if($(this).val()==null||$(this).val()==""){
								  $(this).empty();
								  $(this).append("<option value=''>--请选择球队--</option>")
								    
								   for(var j=0;j<data.length;j++){  
									 
								  $(this).append("<option value='"+data[j].team_id+"'>"+data[j].school_name+"</option>")
								  } 
							 }  
						 })	    
							
							 for(var i=0;i<data.length;i++){
								 if(data[i].zone_group=="A"){					 		
									 $("#group_a"+a+"").val(data[i].team_id);
									 a++;
									 
									 
								 }
								 
								 if(data[i].zone_group=="B"){
									 $("#group_b"+b+"").val(data[i].team_id);
									 b++;
								 }
								  
								 if(data[i].zone_group=="C"){
									 $("#group_c"+c+"").val(data[i].team_id);
									 c++;
								 }
								  
								 if(data[i].zone_group=="D"){
									 $("#group_d"+d+"").val(data[i].team_id);
									 d++;
								 }   
							 }
					 		 
						
						 
						 
						
				 }
					 getTeams(); 
			}
		})  
	}
</script>
</body>
</html>