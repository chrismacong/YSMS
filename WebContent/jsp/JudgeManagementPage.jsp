<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Document</title>
<link type="text/css"
	href="${pageContext.request.contextPath}/css/dialog.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=basePath%>css/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/style.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/league.css"
	rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/judge.css"
	rel="stylesheet" />
<script src="<%=basePath%>js/jquery.min.js"></script>
<script src="<%=basePath%>js/jquery-ui.min.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=basePath%>js/Duang.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=basePath%>js/jquery.ui.datepicker-zh-CN.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/html5tooltips.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/html5tooltips.animation.css" />
<script type="text/javascript" src="<%=basePath%>js/html5tooltips.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/md5.js"></script>

<script type="text/javascript">
	/*注册裁判的选择等级 */
	$(function() {
		path="${pageContext.request.contextPath}";
		$(":disabled").each(function(){
			if($(this).parents('.input_m').css('background-image').indexOf('input_m.png')>=0)
				{
				$(this).parents('.input_m').prev().css('background-image','url('+path+'/images/input_l2.png)');
				$(this).parents('.input_m').css('background-image','url('+path+'/images/input_m2.png)');
				$(this).parents('.input_m').next().css('background-image','url('+path+'/images/input_r2.png)');
				}
			if($(this).parents('.input_m').css('background-image').indexOf('input_m_thin.png')>=0)
				{
				$(this).parents('.input_m').prev().css('background-image','url('+path+'/images/input_l_thin2.png)');
				$(this).parents('.input_m').css('background-image','url('+path+'/images/input_m_thin2.png)');
				$(this).parents('.input_m').next().css('background-image','url('+path+'/images/input_r_thin2.png)');
				}
		})
		$(".caizhu").find('span').click(function() {
			 
			$(this).toggleClass("lev4")
		})
		 
		$('.close').click(function() {
			$('.caipan_detailed').hide();
			$('#fade').hide();
			$('.caipan_apply').hide();
			$(".fujian").hide();
			 
		})
		$('#riqi').datepicker();
		$("#detail_birthday").datepicker();
		 
	 
    	$('.fujian a').click(function(){
    		$('.fujian').hide();
    	})


    	$('.next').click(function(){
    		var num=$('.soli li').length;
    		var mar_left=parseInt($('.soli ul').css('margin-left'),10);
    		var widthli=$('.soli li').width();
    		if(mar_left>(1-num)*widthli){
    			mar_left=mar_left-widthli;
    			$('.soli ul').css('margin-left',mar_left)
    		}
    	})

    	$('.prev').click(function(){
    		var num=$('.soli li').length;
    		var widthli=$('.soli li').width();
    		var mar_left=parseInt($('.soli ul').css('margin-left'),10)
    		if(mar_left<0){
    			mar_left=mar_left+widthli;
    			$('.soli ul').css('margin-left',mar_left)
    		}
    	})
    	
    	$("#add_judge").click(function(){
    		$(".judge_block").show();

			$("#judgeName").val("");
			$("#judgeGender").val("1");
			$("#judgeUserName").val("");
			$("#judgeUserPassword").val("");
			$("#judgeUserComfirnPassword").val(""); 
			$(".caizhu").find("span").addClass("lev4")
    	})
    	
    	$(".close").click(function(){
    		$(".judge_block").hide();
    		//todo 清空block中input的所有输入内容
    	})
	})
	
	html5tooltips([
	  {
		contentText: "校级联赛裁判",
		targetSelector: ".judgelevel1",
		stickTo: "top",
		maxWidth: 100 ,
		animateFunction: "slidein"
	  },
	  {
		contentText: "区级联赛裁判",
		targetSelector: ".judgelevel2",
		stickTo: "top",
		maxWidth: 100 ,
		animateFunction: "slidein"
	  },
	  {
		contentText: "市级裁判员",
		targetSelector: ".judgelevel3",
		stickTo: "top",
		maxWidth: 100 ,
		animateFunction: "slidein"
	  },
	  {
		contentText: "市级助理裁判",
		targetSelector: ".judgelevel4",
		stickTo: "top",
		maxWidth: 100 ,
		animateFunction: "slidein"
	  },
	  {
		contentText: "市级第四官员",
		targetSelector: ".judgelevel5",
		stickTo: "top",
		maxWidth: 100 ,
		animateFunction: "slidein"
	  },
	  {
		contentText: "市级裁判监督",
		targetSelector: ".judgelevel6",
		stickTo: "top",
		maxWidth: 100 ,
		animateFunction: "slidein"
	  },
	  {
		contentText: "市级比赛监督",
		targetSelector: ".judgelevel7",
		stickTo: "top",
		maxWidth: 100 ,
		animateFunction: "slidein"
	  },
	  {
		contentText: "市级统计",
		targetSelector: ".judgelevel8",
		stickTo: "top",
		maxWidth: 100 ,
		animateFunction: "slidein"
	  }
	]);
</script>
</head>
<body>

	<div class="main_content">
		<div class="operation ">
			<ul class="a_caipan">
				<li id="xscp" onclick="show(1)"><div>
						<img src="<%=basePath%>images/a_revise.png" />
					</div>
					<p>显示裁判</p></li>
				<li id="cxcp" onclick="show(4)"><div>
						<img src="<%=basePath%>images/a_number.png" />
					</div>
					<p>查询裁判</p></li>
				<%-- <li onclick="show(3)"><div>
								<img src="<%=basePath%>images/a_add.png" />
							</div>
							<p>添加裁判</p></li> --%>

				<li onclick="show(2)"><div>
						<img src="<%=basePath%>images/a_message.png" />
					</div>
					<p>申请消息</p></li>
				<li id="delete_button" onclick="deleteJudges()"><div>
						<img src="<%=basePath%>images/a_delete.png" />
					</div>
					<p>删除裁判</p></li>
			</ul>
		</div>
		<div class="neirong_wk">


			<!--裁判信息-->
			<table id="caipan_xinxi" class="list_info" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>
						<td width='200px'>
							<div class="table_head_left" id="add_judge" style="width: 210px">添加裁判</div>
						</td>
						<td width='100px'>性别</td>
						<td width="192px">联系方式</td>
						<td width="466px">裁判等级</td>
						<td width='100px'></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="5">
							<div class="tbody_sroll" style="height: 482px;">
								<table id="list_judge" cellpadding="0" cellspacing="0"
									width='100%'>

								</table>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<!--裁判详细信息-->
			<div class="caipan_detailed" style="display: none">
				<div class="neirong" style="width: 780px;">
					<div class="close" style="right: -48px; top: -34px;"></div>
					<table class="add_info" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<td>姓名：</td>
								<td>
									<div>
										<div class="input_l"></div>
										<div class="input_m">
											<input id="detail_name" type="text" class="input_text"
												disabled="disabled"> <input id="detail_judgeid"
												type="text" class="input_text" style="display: none;">
										</div>
										<div class="input_r"></div>
									</div>
								</td>
								<td>性别：</td>
								<td>
									<div>
										<div class="input_l"></div>
										<div class="input_m">
											<div class="select_wk">
												<select id="detail_gender">
													<option value="" selected="selected">--请选择--</option>
													<option value="1">男</option>
													<option value="0">女</option>
												</select>
											</div>
										</div>
										<div class="input_r"></div>
									</div>
								</td>
							</tr>
							<tr>
								<td>身份证：</td>
								<td>
									<div>
										<div class="input_l"></div>
										<div class="input_m">
											<input id="detail_id" type="text" class="input_text">
										</div>
										<div class="input_r"></div>
									</div>
								</td>
								<td>出生日期：</td>
								<td>
									<div>
										<div class="input_l"></div>
										<div class="input_m">
											<input id="detail_birthday" type="text" class="input_text">
										</div>
										<div class="input_r"></div>
									</div>
								</td>
							</tr>
							<tr>

							</tr>
							<tr>
								<td>民族：</td>
								<td>
									<div>
										<div class="input_l"></div>
										<div class="input_m">
											<input id="detail_nationality" type="text" class="input_text">
										</div>
										<div class="input_r"></div>
									</div>
								</td>
								<td>手机号码：</td>
								<td>
									<div>
										<div class="input_l"></div>
										<div class="input_m">
											<input id="detail_mobile" type="text" class="input_text">
										</div>
										<div class="input_r"></div>
									</div>
								</td>
							</tr>
							<tr>
								<td>职业：</td>
								<td>
									<div>
										<div class="input_l"></div>
										<div class="input_m">
											<div class="select_wk">
												<select id="detail_job">
													<option value="" selected="selected">--请选择--</option>

												</select>
												<div class="select_icon"></div>
											</div>
										</div>
										<div class="input_r"></div>
									</div>
								</td>
								<td>等级证书：</td>
								<td>
									<div>
										<div class="input_l"></div>
										<div class="input_m">
											<div class="select_wk">
												<select id="detail_level">
													<option value="" selected="selected">--请选择--</option>
													<option value="0">无</option>
													<option value="1">三级裁判</option>
													<option value="2">二级裁判</option>
													<option value="3">一级裁判</option>
													<option value="4">国家级裁判</option>
													<option value="5">国际级裁判</option>
												</select>
											</div>
										</div>
										<div class="input_r"></div>
									</div>
								</td>
							</tr>
							<tr>
								<td>所在区：</td>
								<td>
									<div>
										<div class="input_l"></div>
										<div class="input_m">
											<div class="select_wk">
												<select id="detail_district">
													<option value="" selected="selected">--请选择--</option>

												</select>
												<div class="select_icon"></div>
											</div>
										</div>
										<div class="input_r"></div>
									</div>
								</td>
								<td>工作地址：</td>
								<td>
									<div>
										<div class="input_l"></div>
										<div class="input_m">
											<input id="detail_jobaddress" type="text" class="input_text">
										</div>
										<div class="input_r"></div>
									</div>
								</td>
							</tr>
							<tr>
								<td>家庭地址：</td>
								<td>
									<div>
										<div class="input_l"></div>
										<div class="input_m">
											<input id="detail_homeaddress" type="text" class="input_text">
										</div>
										<div class="input_r"></div>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="4" style="text-align: center">请选择裁判等级</td>
							</tr>
							<tr>
								<td class="level caizhu" colspan="4">
									<p width="315px" id="levels"></p>
								</td>
							</tr>
							<tr>
								<td colspan="4">
									<div class="btn_wk">
										<div class="btn_l btn_l_a_green"></div>
										<div class="btn_m btn_m_a_green">
											<input type="button" class="input_btn"
												style="background: none" value="保存修改" onclick="update()">
										</div>
										<div class="btn_r btn_r_a_green"></div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!--裁判详细信息-->

			<!--裁判信息 END-->



			<!--申请消息查看-->
			<table id="caipan_list" class="list_info" cellpadding="0"
				cellspacing="0" style="display: none;">
				<thead>

					<tr>
						<td width='200px'>
							<div class="table_head_left" style="width: 210px">姓名</div>
						</td>
						<td width='100px'>性别</td>
						<td width="192px">出生年月</td>
						<td width="266px">证书等级</td>
						<td width='200px'>联系电话</td>
						<td width='100px'></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="6">
							<div class="tbody_sroll" style="height: 481px">
								<table id="application_list" cellpadding="0" cellspacing="0"
									width='100%'>

								</table>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<!--申请消息查看 END-->

			<!--申请消息详细信息-->
			<div class="caipan_apply" style="display: none">
				<div class="neirong">
					<div class="close"></div>
					<table id="app_detail" class="add_info" cellpadding="0"
						cellspacing="0" width='85%'>
						<tbody>
							<tr>
								<td style="display: none;" id="app_id"></td>
								<td width="116px">姓名：</td>
								<td width="234px" id="name_detail">王小毛</td>
								<td width="0"></td>
								<td width="120px">性别：</td>
								<td width="230px" id="gender_detail">男</td>
							</tr>
							<tr>
								<td>民族：</td>
								<td id="nationality_detail">汉</td>
								<td></td>
								<td>出生日期：</td>
								<td id="birthday_detail">1978-2-12</td>
							</tr>
							<tr>
								<td>身份证：</td>
								<td id="id_detail">320981278738490032
									<div class="icon_fj"></div>
								</td>
								<td></td>
								<td>手机号码：</td>
								<td id="mobile_detail">南京六合哈哈</td>
							</tr>
							<tr>
								<td>职 业：</td>
								<td id="job_detail">国家机关、党群。。。。</td>
								<td></td>
								<td>工作所在区：</td>
								<td id="district_detail">南京六合哈哈</td>
							</tr>
							<tr>
								<td>工作地点：</td>
								<td id="jobaddress_detail">国家机关、党群。。。。</td>
								<td></td>
								<td>证书等级：</td>
								<td id="level_detail">国家一级
									<div class="icon_fj"></div>
								</td>
							</tr>
							<tr>
								<td width="100px">家庭地点：</td>
								<td colspan="4" id="homeaddress_detail">拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉拉</td>
							</tr>
							<tr>
								<td colspan="2">
									<div class="btn_wk">
										<div class="btn_l btn_l_a_green"></div>
										<div class="btn_m btn_m_a_green">
											<input id="yes" type="button" class="input_btn"
												style="background: none" value="通过申请" onclick="isPassed(2)">
										</div>
										<div class="btn_r btn_r_a_green"></div>
									</div>
								</td>
								<td></td>
								<td colspan="2">
									<div class="btn_wk">
										<div class="btn_l btn_l_a_red"></div>
										<div class="btn_m btn_m_a_red">
											<input id="no" type="button" class="input_btn"
												style="background: none" value="拒绝申请" onclick="isPassed(3)">
										</div>
										<div class="btn_r btn_r_a_red"></div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!--申请消息详细信息-->

			<div class="fujian" style="display: none">

				<div class="prev"></div>
				<div class="img">
					&nbsp;<a href="javascript:void(0)">关闭</a>
					<div class="soli">
						<ul id="atts">

						</ul>
					</div>
				</div>
				<div class="next"></div>
				<div class="clearboth"></div>
			</div>


			<!--分页跳转，裁判信息和申请消息都需要-->
			<div id="paging">
				<!--   <div class="choose_kuai">
					<p>
						选择：<label id="checkall">全选</label><label id="check_revsern">反选</label>
					</p>
				</div>  -->
				<div class="choose_btn_delete">

					<!-- <button onclick="deleteUser()">删除</button> -->
					<!-- 	<button>取消</button> -->
					<p style="" id="page_setting" class="choose_kuai">
						<input id='pageIndex' type='text' width='10px' value='1'>
					</p>
				</div>
			</div>

			<div id="caipan_search" class="neirong" style="display: none">
				<table class="add_info" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td>姓名关键字：</td>
							<td>
								<div>
									<div class="input_l"></div>
									<div class="input_m">
										<input id="judgeNameSearch" type="text" class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>性别：</td>
							<td>
								<div>
									<div class="input_l"></div>
									<div class="input_m">
										<div class="select_wk">
											<select id="judgeGenderSearch">
												<option value="" selected="selected">--请选择--</option>
												<option value="1">男</option>
												<option value="0">女</option>
											</select>
											<div class="select_icon"></div>
										</div>
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>出生大概时间(从)：</td>
							<td>
								<div>
									<div class="input_l"></div>
									<div class="input_m">
										<input id="judgeBirthDayBegin" readonly="readonly" type="text"
											class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>出生大概时间(至)：</td>
							<td>
								<div>
									<div class="input_l"></div>
									<div class="input_m">
										<input id="judgeBirthDayEnd" readonly="readonly" type="text"
											class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<!-- <tr>
							<td>职业状态：</td>
							<td>
								<div>
									<div class="input_l"></div>
									<div class="input_m">
										<div class="select_wk">
											<select id="judgeStatusSearch">
												<option value="" selected="selected">--请选择--</option>
												<option value="1">待审核</option>
												<option value="2">已审核</option>
												<option value="3">未通过</option>
											</select>
											<div class="select_icon"></div>
										</div>
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr> -->
						<tr>
							<td colspan="4" style="text-align: center">请选择裁判等级</td>
						</tr>
						<tr>
							<td class='level caizhu' colspan="4"><span id="slevel1"
								class="lev1 lev4 judgelevel1">校
									<div></div>
							</span> <span id="slevel2" class="lev2 lev4 judgelevel2">区
									<div></div>
							</span> <span id="slevel3" class="lev3 lev4 judgelevel3">主
									<div></div>
							</span> <span id="slevel4" class="lev3 lev4 judgelevel4">边
									<div></div>
							</span> <span id="slevel5" class="lev3 lev4 judgelevel5">四
									<div></div>
							</span> <span id="slevel6" class="lev3 lev4 judgelevel6">裁
									<div></div>
							</span> <span id="slevel7" class="lev3 lev4 judgelevel7">赛
									<div></div>
							</span> <span id="slevel8" class="lev3 lev4 judgelevel8">统
									<div></div>
							</span></td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="btn_wk">
									<div class="btn_l btn_l_a_green"></div>
									<div class="btn_m btn_m_a_green">
										<input type="button" class="input_btn"
											style="background: none" value="查询裁判"
											onclick="searchJudge();">
									</div>
									<div class="btn_r btn_r_a_green"></div>
								</div>
							</td>
						</tr>

					</tbody>
				</table>
			</div>

	



		</div>
	</div>
	<div id="fade" class="black_overlay"></div>

	<div class="judge_block" style="display: none">
		<div class="close"></div>
		<br/>
		<h1 id="register_judge_title">注册裁判员</h1><button>批量导入</button>
		<br/>
			<!--注册裁判-->
			<div id="caipan_add" class="neirong">
				<table class="add_info" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td>裁判姓名：</td>
							<td>
								<div>
									<div class="input_l"></div>
									<div class="input_m">
										<input id="judgeName" type="text" class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>性别：</td>
							<td>
								<div>
									<div class="input_l"></div>
									<div class="input_m">
										<div class="select_wk">
											<select id="judgeGender">
												<option value="" selected="selected">--请选择--</option>
												<option value="1">男</option>
												<option value="0">女</option>
											</select>
											<div class="select_icon"></div>
										</div>
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>身份证号：</td>
							<td>
								<div>
									<div class="input_l"></div>
									<div class="input_m">
										<input id="judgeUserIdentifiedId" type="text"
											class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>联系电话：</td>
							<td>
								<div>
									<div class="input_l"></div>
									<div class="input_m">
										<input id="judgeUserPhonenum" type="text"
											class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>用户名：</td>
							<td>
								<div>
									<div class="input_l"></div>
									<div class="input_m">
										<input id="judgeUserName" type="text" class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>输入密码：</td>
							<td>
								<div>
									<div class="input_l"></div>
									<div class="input_m">
										<input id="judgeUserPassword" type="password"
											class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>确认密码：</td>
							<td>
								<div>
									<div class="input_l"></div>
									<div class="input_m">
										<input id="judgeUserComfirnPassword" type="password"
											class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="4" style="text-align: center">请选择裁判等级</td>
						</tr>
						<tr>
							<td class='level caizhu' colspan="4"><span id="level1"
								class="lev1 lev4 judgelevel1">校
									<div></div>
							</span> <span id="level2" class="lev2 lev4 judgelevel2">区
									<div></div>
							</span> <span id="level3" class="lev3 lev4 judgelevel3">主
									<div></div>
							</span> <span id="level4" class="lev3 lev4 judgelevel4">助
									<div></div>
							</span> <span id="level5" class="lev3 lev4 judgelevel5">四
									<div></div>
							</span> <span id="level6" class="lev3 lev4 judgelevel6">裁
									<div></div>
							</span> <span id="level7" class="lev3 lev4 judgelevel7">赛
									<div></div>
							</span> <span id="level8" class="lev3 lev4 judgelevel8">统
									<div></div>
							</span></td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="btn_wk">
									<div class="btn_l btn_l_a_green"></div>
									<div class="btn_m btn_m_a_green">
										<input type="button" class="input_btn"
											style="background: none" value="注册裁判"
											onclick="registerJudge()">
									</div>
									<div class="btn_r btn_r_a_green"></div>
								</div>
							</td>
						</tr>

					</tbody>
				</table>
			</div>
	</div>
		

	<script type="text/javascript">
		$(function(){
			$("#xscp").css('border-bottom','3px solid rgb(18, 116, 25)');
			getJudges()
			$("#judgeBirthDayBegin").datepicker();
			$("#judgeBirthDayEnd").datepicker();
		})
	
	
		//切换菜单显示
		function show(id) {

			if (id == 1) {
				clearInput()
				getJudges();
				$("#caipan_xinxi").css("display", "block");
				$("#caipan_list").css("display", "none");
				$("#caipan_search").css("display", "none");
				
			 $("#delete_button").css("display", "block");   
				 $("#paging").css("display", "block");
				 
			} else if (id == 2) {
				clearInput()
				 $("#paging").css("display", "block");
				$("#caipan_xinxi").css("display", "none");
				  $("#delete_button").css("display", "block");   	
				$("#caipan_search").css("display", "none");
				$("#caipan_list").css("display", "block");
				getApplications();
				
				
				 
			} /* else if (id == 3) {
				 $("#paging").css("display", "none");
				$("#caipan_xinxi").css("display", "none");
				$("#caipan_list").css("display", "none");
				$("#caipan_search").css("display", "none");
				$("#delete_button").css("display", "block");  
				$("#judgeName").val("");
				$("#judgeGender").val("1");
				$("#judgeUserName").val("");
				$("#judgeUserPassword").val("");
				$("#judgeUserComfirnPassword").val(""); 
				$(".caizhu").find("span").addClass("lev4")
				$("#caipan_add").css("display", "block");
				 
			} */
			else if (id == 4) {
				clearInput()
				 $("#paging").css("display", "none");
				$("#caipan_search").css("display", "block");
				 
				$("#caipan_xinxi").css("display", "none");
				$("#caipan_list").css("display", "none");
				$("#delete_button").css("display", "none");  
			}
		}

		function clearInput(){
			$("#pageIndex").val("1");
			$("#judgeNameSearch").val("");
 			$("#judgeGenderSearch").val("");
 			$("#judgeBirthDayBegin").val("");
 			$("#judgeBirthDayEnd").val("");
 			$('.caizhu').find('span').addClass("lev4");
 			$("#judgeName").val("");
			$("#judgeGender").val("");
			$("#judgeUserName").val("");
			$("#judgeUserPassword").val("");
			$("#judgeUserComfirnPassword").val("")
		}
		
		//添加裁判
		function registerJudge() {

			var judgeName = $("#judgeName").val();
			var judgeGender = $("#judgeGender").val();
			var judgeUserName = $("#judgeUserName").val();
			var judgeUserPassword = $("#judgeUserPassword").val();
			var judgeUserComfirnPassword = $("#judgeUserComfirnPassword").val();
			var judgeUserIdentifiedId = $("#judgeUserIdentifiedId").val();
			var judgeUserPhonenum = $("#judgeUserPhonenum").val();
			
			var judgeLevel="";
			if($("#level1").attr("class")=="lev1 judgelevel1"){
				judgeLevel+=1+",";
			}
			if($("#level2").attr("class")=="lev2 judgelevel2"){
				judgeLevel+=2+",";
			}
			if($("#level3").attr("class")=="lev3 judgelevel3"){
				judgeLevel+=3+",";
			}
			if($("#level4").attr("class")=="lev3 judgelevel4"){
				judgeLevel+=4+",";
			}
			if($("#level5").attr("class")=="lev3 judgelevel5"){
				judgeLevel+=5+",";
			}
			if($("#level6").attr("class")=="lev3 judgelevel6"){
				judgeLevel+=6+",";
			}
			if($("#level7").attr("class")=="lev3 judgelevel7"){
				judgeLevel+=7+",";
			}
			if($("#level8").attr("class")=="lev3 judgelevel8"){
				judgeLevel+=8+",";
			}
			 
			if (isEmpty("judgeName")) {
				ds.dialog({
					title : '消息提示',
					content : "请填写裁判姓名！",
					onyes : true,
					icon : "../images/info.png"
				});
				$("#judgeName").focus();
				return;
			}
			if (isEmpty("judgeGender")) {
				ds.dialog({
					title : '消息提示',
					content : "请选择裁判性别！",
					onyes : true,
					icon : "../images/info.png"
				});
				$("#judgeGender").focus();
				return;
			}
			if (isEmpty("judgeUserName")) {
				ds.dialog({
					title : '消息提示',
					content : "请设置裁判用户名！",
					onyes : true,
					icon : "../images/info.png"
				});
				$("#judgeUserName").focus();
				return;
			}
			if (isEmpty("judgeUserPassword")) {
				ds.dialog({
					title : '消息提示',
					content : "请设置裁判登录密码！",
					onyes : true,
					icon : "../images/info.png"
				});
				$("#judgeUserPassword").focus();
				return;
			}
			if (isEmpty("judgeUserComfirnPassword")) {
				ds.dialog({
					title : '消息提示',
					content : "请确认裁判登录密码！",
					onyes : true,
					icon : "../images/info.png"
				});
				$("#judgeUserComfirnPassword").focus();
				return;
			}
			if (isEmpty("judgeUserIdentifiedId")||judgeUserIdentifiedId.length!=18) {
				ds.dialog({
					title : '消息提示',
					content : "请输入正确的18位身份证号码！",
					onyes : true,
					icon : "../images/info.png"
				});
				$("#judgeUserIdentifiedId").focus();
				return;
			}
			if (isEmpty("judgeUserPhonenum")) {
				ds.dialog({
					title : '消息提示',
					content : "请输入联系电话！",
					onyes : true,
					icon : "../images/info.png"
				});
				$("#judgeUserPhonenum").focus();
				return;
			}
			
			if (judgeUserPassword != judgeUserComfirnPassword) {
				ds.dialog({
					title : '消息提示',
					content : "两次输入的密码不一致，请重新输入！",
					onyes : true,
					icon : "../images/info.png"
				});
				$("#judgeUserPassword").val("");
				$("#judgeUserComfirnPassword").val("");
				$("#judgeUserPassword").focus();
				return;
			}
			if (judgeLevel==null||judgeLevel=="") {
				ds.dialog({
					title : '消息提示',
					content : "请选择裁判等级！",
					onyes : true,
					icon : "../images/info.png"
				});
				return;
			}
			
			$.ajax( {
				async : false,
				cache : false,
				type : 'POST',
			  	data : {
					judgeName:judgeName,
		        	judgeGender:judgeGender,
		        	judgeUserName:judgeUserName,
		        	judgeUserPassword:hex_md5(judgeUserPassword),
		        	judgeLevel:judgeLevel,
		        	judgeIdentifiedId: judgeUserIdentifiedId,
		        	judgePhonenum: judgeUserPhonenum
				},  
				dataType : "json",
				url : "<%=basePath%>judgemanagement/addjudge.html",
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
					if (data.returnCode == 200) {
						ds.dialog({
							title : '消息提示',
							content : data.returnMessage,
							onyes : true,
							icon : "../images/info.png"
						});
						$("#judgeName").val("");
						$("#judgeGender").val("1");
						$("#judgeUserName").val("");
						$("#judgeUserPassword").val("");
						$("#judgeUserComfirnPassword").val("");
						$('.caizhu').find('span').addClass("lev4");
					} else  {
						ds.dialog({
							title : '消息提示',
							content : data.returnMessage,
							onyes : true,
							icon : "../images/info.png"
						});
					}  
				}
			})

		}

		//显示裁判
		function getJudges() {
			$("#application_list").empty();
		    $("#list_judge").empty();
		    var pageIndex = $("#pageIndex").val();
		    var judgeName=$("#judgeNameSearch").val();
			var judgeGender=$("#judgeGenderSearch").val();
			var beginTime=$("#judgeBirthDayBegin").val();
			var endTime=$("#judgeBirthDayEnd").val();
		 
			var judgeLevel="";
			if($("#slevel1").attr("class")=="lev1"){
				judgeLevel+=1+",";
			}
			if($("#slevel2").attr("class")=="lev2"){
				judgeLevel+=2+",";
			}
			if($("#slevel3").attr("class")=="lev3"){
				judgeLevel+=3+",";
			}
			if($("#slevel4").attr("class")=="lev3"){
				judgeLevel+=4+",";
			}
			if($("#slevel5").attr("class")=="lev3"){
				judgeLevel+=5+",";
			}
			if($("#slevel6").attr("class")=="lev3"){
				judgeLevel+=6+",";
			}
			if($("#slevel7").attr("class")=="lev3"){
				judgeLevel+=7+",";
			}
			if($("#slevel8").attr("class")=="lev3"){
				judgeLevel+=8+",";
			}
		    $.ajax({
		        async: false,
		        cache: false,
		        type: 'POST',
		        data: {
		        	judgeName: judgeName,
		        	judgeGender:judgeGender,
		        	beginTime:beginTime,
		        	endTime:endTime,
		        	judgeStatus:2,
		        	judgeLevel:judgeLevel,
		        	currentPage: pageIndex
		        },
		        dataType: "json",
		        url: "<%=basePath%>judgemanagement/listjudge.html",
		        //请求的action路径
		        error: function () { //请求失败处理函数
		        	ds.dialog({
						title : '消息提示',
						content : "请求失败，请联系管理员！",
						onyes : true,
						icon : "../images/info.png"
					});
		        },
		        success: function (data) { //请求成功后处理函数。 
		            if (data != null) {
		            
		                $("#page_setting").empty();

		                if (data.page.hasPrePage == true) {
		                    $("#page_setting").append(" <label onclick='prePage()'>上一页</label>");
		                }
		                if (data.page.hasNextPage == true) {
		                    $("#page_setting").append(" <label onclick='nextPage()'>下一页</label>");
		                }
		                $("#page_setting").append("<span>第</span><input id='pageIndex' type='text' width='5px' value='" + data.page.currentPage + "'>/<span id='pageCount'></span>页 <button id='page_ok' onclick='getJudges()'>跳转</button>");
		                $("#pageCount").text(data.page.totalPage)
		                for (var i = 0; i < data.data.length; i++) {
		                	$("#list_judge").append("<tr id='tr"+i+"'></tr>")
		                    $("#tr"+i+"").append("<td width='50px' style='border-right: 1px solid rgb(167, 167, 167);'><input name='items' class='name_checkbox' type='checkbox' value='"+data.data[i].id+"' ></td><td width='150px'>"+data.data[i].name+"</td>");
		                	if(data.data[i].gender==0){
		                		$("#tr"+i+"").append("<td width='100px'>女</td>");
		                	}else if(data.data[i].gender==1){
		                		$("#tr"+i+"").append("<td width='100px'>男</td>");
		                	}
		                	$("#tr"+i+"").append("<td>"+data.data[i].mobile+"</td>")
		                	$("#tr"+i+"").append("<td id='td"+i+"' width='466px' class='level'></td>");
		                	 
		                	levelIds=data.data[i].level;
		                	 
		                	if(levelIds.indexOf("1")!=-1){
		                		$("#td"+i+"").append("<span class='lev1 judgelevel1'>校<div></div></span>");
		                	}else{
		                		$("#td"+i+"").append("<span class='lev1 lev4 judgelevel1'>校<div></div></span>");
		                	}
		                	if(levelIds.indexOf("2")!=-1){
		                		$("#td"+i+"").append(" <span class='lev2 judgelevel2'>区<div></div></span> ");
		                	}else{
		                		$("#td"+i+"").append(" <span class='lev2 lev4 judgelevel2'>区<div></div></span> ");
		                	}
		                	if(levelIds.indexOf("3")!=-1){
		                		$("#td"+i+"").append("<span class='lev3 judgelevel3'>主<div></div></span>");
		                	}else{
		                		$("#td"+i+"").append("<span class='lev3 lev4 judgelevel3'>主<div></div></span>");
		                	}
		                	if(levelIds.indexOf("4")!=-1){
		                		$("#td"+i+"").append("<span class='lev3 judgelevel4'>助<div></div></span>");
		                	}else{
		                		$("#td"+i+"").append("<span class='lev3 lev4 judgelevel4'>助<div></div></span>");
		                	}
		                	if(levelIds.indexOf("5")!=-1){
		                		$("#td"+i+"").append("<span class='lev3 judgelevel5'>四<div></div></span> ");
		                	}else{
		                		$("#td"+i+"").append("<span class='lev3 lev4 judgelevel5'>四<div></div></span> ");
		                	}
		                	if(levelIds.indexOf("6")!=-1){
		                		$("#td"+i+"").append("<span class='lev3 judgelevel6'>裁<div></div></span>");
		                	}else{
		                		$("#td"+i+"").append("<span class='lev3 lev4 judgelevel6'>裁<div></div></span>");
		                	}
		                	if(levelIds.indexOf("7")!=-1){
		                		$("#td"+i+"").append("<span class='lev3 judgelevel7'>赛<div></div></span>");
		                	}else{
		                		$("#td"+i+"").append("<span class='lev3 lev4 judgelevel7'>赛<div></div></span>");
		                	}
		                	if(levelIds.indexOf("8")!=-1){
		                		$("#td"+i+"").append("<span class='lev3 judgelevel8'>统<div></div></span>");
		                	}else{
		                		$("#td"+i+"").append("<span class='lev3 lev4 judgelevel8'>统<div></div></span>");
		                	}
		                  
		                	$("#tr"+i+"").append("<td width='100px'><div class='input_l'></div><div class='input_m detailed' style='width: auto' onclick='getJudgeById("+data.data[i].id+")'>详细</div><div class='input_r'></div></td>")
		                 
		                }  
		               
		            }  
		        }
		    })
		}
		
		
		
		function getApplications(){
			$("#list_judge").empty();
			$("#application_list").empty();
			var pageIndex = $("#pageIndex").val();
			$.ajax({
		        async: false,
		        cache: false,
		        type: 'POST',
		        data: {
		  
		        	currentPage: pageIndex
		        },
		        dataType: "json",
		        url: "<%=basePath%>judgemanagement/getapplications.html",
		        //请求的action路径
		        error: function () { //请求失败处理函数
		        	ds.dialog({
						title : '消息提示',
						content : "请求失败，请联系管理员！",
						onyes : true,
						icon : "../images/info.png"
					});
		        },
		        success: function (data) { //请求成功后处理函数。 
		            if (data != null) {  
		            	 
		                $("#page_setting").empty();

		                if (data.page.hasPrePage == true) {
		                    $("#page_setting").append(" <label onclick='prePage()'>上一页</label>");
		                }
		                if (data.page.hasNextPage == true) {
		                    $("#page_setting").append(" <label onclick='nextPage()'>下一页</label>");
		                }
		                $("#page_setting").append("<span>第</span><input id='pageIndex' type='text' width='5px' value='" + data.page.currentPage + "'>/<span id='pageCount'></span>页 <button id='page_ok_' onclick='getApplications()'>跳转</button>"    );
		                $("#pageCount").text(data.page.totalPage)
		                for (var i = 0; i < data.data.length; i++) {
		                 
		                	$("#application_list").append("<tr id='tr"+i+"'></tr>")
		                     $("#tr"+i+"").append("<td width='50px' style='border-right: 1px solid rgb(167, 167, 167);'><input name='items' class='name_checkbox' type='checkbox' value='"+data.data[i].id+"'></td><td width='150px'>"+data.data[i].name+"</td>");
		                 
		                	if(data.data[i].gender==0){
		                		 
		                		$("#tr"+i+"").append("<td width='100px'>女</td>");
		                	}else if(data.data[i].gender==1){
		                		
		                		$("#tr"+i+"").append("<td width='100px'>男</td>");
		                	}
		                 
		                	$("#tr"+i+"").append("<td>"+data.data[i].birthday+"</td>")
		                	  
		                	if(data.data[i].level==1){
		                		$("#tr"+i+"").append("<td width='266px'>三级裁判员</td>");
		                	}else if(data.data[i].level==2){
		                		$("#tr"+i+"").append("<td width='266px'>二级裁判员</td>");
		                	}else if(data.data[i].level==3){
		                		$("#tr"+i+"").append("<td width='266px'>一级裁判员</td>");
		                	}else if(data.data[i].level==4){
		                		$("#tr"+i+"").append("<td width='266px'>国家级裁判员</td>");
		                	}else if(data.data[i].level==5){
		                		$("#tr"+i+"").append("<td width='266px'>国际级裁判员</td>");
		                	}else{
		                 	
		                		$("#tr"+i+"").append("<td width='266px'></td>");
		                	}
		                	 
		                	$("#tr"+i+"").append("<td  width='200px' >"+data.data[i].mobile+"</td>");
		                	$("#tr"+i+"").append("<td width='100px'><div class='input_l'></div><div class='input_m showapply' style='width:auto' onclick='getAppicationById("+data.data[i].id+")'>详细</div><div class='input_r'></div></td>")
		                    
		                }  
  
		            }  
		        }
		    })
		}
		
		
		function isEmpty(id) {

			var name = $("#" + id + "").val();

			if (name == null || name == undefined || name == "" || name == NaN) {
				return true;
			}
			return false;
		}
		
		
		
		//删除裁判员
		function deleteJudges() {
	    var s = '';
	    $('input[name="items"]:checked').each(function () {
	        s += $(this).val() + ',';
	    });
	    if (s.length == 0) {
	    	ds.dialog({
				title : '消息提示',
				content : "请选择至少一条记录进行删除！",
				onyes : true,
				icon : "../images/info.png"
			});

	        return;
	    }

	    $.ajax({
	        async: false,
	        cache: false,
	        type: 'POST',
	        data: {
	        	judge_id: s
	        },
	        dataType: "json",
	        url: "<%=basePath%>judgemanagement/deletejudge.html",
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
					if (data.returnCode == 200) {
						ds.dialog({
							title : '消息提示',
							content : data.returnMessage,
							onyes : true,
							icon : "../images/info.png"
						});
						getJudges();

					} else {
						ds.dialog({
							title : '消息提示',
							content : data.returnMessage,
							onyes : true,
							icon : "../images/socceralert.png"
						});
					}
				}
			})
		}
		function searchJudge(){
			$("#pageIndex").val("1");
			  getJudges();
			  $("#caipan_xinxi").css("display", "block");
				$("#caipan_list").css("display", "none");
				$("#caipan_search").css("display", "none");
				 $("#xscp").css('border-bottom','3px solid #127419');
				 $("#cxcp").css('border','none');
				$("#delete_button").css("display", "block");  
				 $("#paging").css("display", "block");
		}
	 function getJudgeById(judgeId){
		
		 getJobsAndDistricts();
		 $.ajax({
		        async: false,
		        cache: false,
		        type: 'POST',
		        data: {
		        	judgeId: judgeId
		        },
		        dataType: "json",
		        url: "<%=basePath%>judgemanagement/getjudge.html",
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
							 $("#levels").empty();
							 $("#detail_judgeid").val(data.judgeId);
							 $("#detail_name").val(data.name);
							 $("#detail_gender").val(data.gender);
							 $("#detail_id").val(data.id);
							 $("#detail_birthday").val(data.birthday);
							 $("#detail_nationality").val(data.nationality);
							 $("#detail_mobile").val(data.mobile);
							 $("#detail_job").val(data.jobId);
							 $("#detail_level").val(data.judgeLevel);
							 $("#detail_district").val(data.districtId);
							 $("#detail_jobaddress").val(data.jobAddress);
							 $("#detail_homeaddress").val(data.address);
							 levelIds=data.levels;
			                	if(levelIds.indexOf(1)!=-1){
			                		$("#levels").append("<span id='xlevel1' class='lev1 judgelevel1'>校<div></div></span>");
			                	}else{
			                		$("#levels").append("<span id='xlevel1' class='lev1 lev4 judgelevel1'>校<div></div></span>");
			                	}
			                	if(levelIds.indexOf(2)!=-1){
			                		$("#levels").append(" <span id='xlevel2' class='lev2 judgelevel2'>区<div></div></span> ");
			                	}else{
			                		$("#levels").append(" <span id='xlevel2' class='lev2 lev4 judgelevel2'>区<div></div></span> ");
			                	}
			                	if(levelIds.indexOf(3)!=-1){
			                		$("#levels").append("<span id='xlevel3' class='lev3 judgelevel3'>主<div></div></span>");
			                	}else{
			                		$("#levels").append("<span id='xlevel3' class='lev3 lev4 judgelevel3'>主<div></div></span>");
			                	}
			                	if(levelIds.indexOf(4)!=-1){
			                		$("#levels").append("<span id='xlevel4' class='lev3 judgelevel4'>助<div></div></span>");
			                	}else{
			                		$("#levels").append("<span id='xlevel4' class='lev3 lev4 judgelevel4'>助<div></div></span>");
			                	}
			                	if(levelIds.indexOf(5)!=-1){
			                		$("#levels").append("<span id='xlevel5' class='lev3 judgelevel5'>四<div></div></span> ");
			                	}else{
			                		$("#levels").append("<span id='xlevel5' class='lev3 lev4 judgelevel5'>四<div></div></span> ");
			                	}
			                	if(levelIds.indexOf(6)!=-1){
			                		$("#levels").append("<span id='xlevel6' class='lev3 judgelevel6'>裁<div></div></span>");
			                	}else{
			                		$("#levels").append("<span id='xlevel6' class='lev3 lev4 judgelevel6'>裁<div></div></span>");
			                	}
			                	if(levelIds.indexOf(7)!=-1){
			                		$("#levels").append("<span id='xlevel7' class='lev3 judgelevel7'>赛<div></div></span>");
			                	}else{
			                		$("#levels").append("<span id='xlevel7' class='lev3 lev4 judgelevel7'>赛<div></div></span>");
			                	}
			                	if(levelIds.indexOf(8)!=-1){
			                		$("#levels").append("<span id='xlevel8' class='lev3 judgelevel8'>统<div></div></span>");
			                	}else{
			                		$("#levels").append("<span id='xlevel8' class='lev3 lev4 judgelevel8'>统<div></div></span>");
			                	}
			                	
			                	$("#levels span").click(function(){
			                		$(this).toggleClass("lev4");
			                	});
						 }
					}
				})
		 $('.caipan_detailed').show();
		 $("#fade").show();
	 }
	 
	 
	 function getAppicationById(appId){
		 $.ajax({
		        async: false,
		        cache: false,
		        type: 'POST',
		        data: {
		        	judgeId: appId
		        },
		        dataType: "json",
		        url: "<%=basePath%>judgemanagement/getjudge.html",
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
							  $("#app_id").html(data.judgeId);
							  $("#name_detail").html(data.name);
							
							  if(data.gender==1){
								  $("#gender_detail").html("男");
							  }else if(data.gender==0){
								  $("#gender_detail").html("女");
							  }
							  
							  $("#nationality_detail").html(data.nationality);
							  $("#birthday_detail").html(data.birthday);
							  $("#id_detail").html(data.id+"<div class='icon_fj' onclick='showAtt(0)'></div>");
							  $("#mobile_detail").html(data.mobile);
							  $("#job_detail").html(data.jobName);
							  $("#district_detail").html(data.districtName);
							  $("#jobaddress_detail").html(data.jobAddress);
							  var level="";
							  if(data.judgeLevel==1){
								  level="三级裁判员<div class='icon_fj' onclick='showAtt(1)'></div>";
							  }else if(data.judgeLevel==2){
								  level="二级裁判员<div class='icon_fj' onclick='showAtt(1)'></div>";
							  }else if(data.judgeLevel==3){
								  level="一级裁判员<div class='icon_fj' onclick='showAtt(1)'></div>";
							  }else if(data.judgeLevel==4){
								  level="国家级裁判员<div class='icon_fj' onclick='showAtt(1)'></div>";
							  }else if(data.judgeLevel==5){
								  level="国际级裁判员<div class='icon_fj' onclick='showAtt(1)'></div>";
							  }
							  $("#level_detail").html(level);
							  $("#homeaddress_detail").html(data.address);
						 }  
					}
				})
				$('.caipan_apply').show();
			    $("#fade").show();
	 }
	 
	 
	 function getJobsAndDistricts(){
		 $.ajax({
		        async: false,
		        cache: false,
		        type: 'POST',
		        dataType: "json",
		        url: "<%=basePath%>judgemanagement/getjobsanddistrict.html",
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
							 $("#detail_job").empty();
							 $("#detail_district").empty();
							 for(var i=0;i<data.job.length;i++){
								 $("#detail_job").append("<option value='"+data.job[i].jobId+"'>"+data.job[i].jobName+"</option>")
							 }
							 for(var j=0;j<data.district.length;j++){
								 $("#detail_district").append("<option value='"+data.district[j].districtId+"'>"+data.district[j].districtName+"</option>")
							 } 
						 }
					}
				})
	 }
	 
	 
		function nextPage() {
		    var index = $("#pageIndex").val();
		    $("#pageIndex").val(parseInt(index) + 1)
		    getJudges() ;
		}

		function prePage() {
		    var index = $("#pageIndex").val();
		    $("#pageIndex").val(parseInt(index) - 1)
		    getJudges() ;
		}
		
		
		function isPassed(status){
			 
			 $.ajax({
			        async: false,
			        cache: false,
			        type: 'POST',
			        data:{
			        	judgeId:$("#app_id").html(),
			        	judgeStatus:status
			        },
			        dataType: "json",
			        url: "<%=basePath%>judgemanagement/ispassed.html",
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
							ds.dialog({
								title : '消息提示',
								content : data.returnMessage,
								onyes : true,
								icon : "../images/info.png"
							});
							  if(data.returnCode==200){
								  $('.caipan_apply').hide();
								  $("#fade").hide();
								  getApplications();
							  }
						}
					})
			
		}
		
		function showAtt(id){
			 $.ajax({
			        async: false,
			        cache: false,
			        type: 'POST',
			        data:{
			        	judgeId:$("#app_id").html(),
			        	attType:id
			        },
			        dataType: "json",
			        url: "<%=basePath%>judgemanagement/getatts.html",
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
							  if(data.returnCode==200){
								  $("#atts").empty();
								  if(data.returnMessage[0].att_name!=""){
									  $("#atts").append("<li><img src='"+data.returnMessage[0].att_name+"'  width='550px' height='360px'/></li>");
								  }
								  
								   
							  }
							 
						}
			})
			$(".fujian").show();
		}
		
		
		function update(){
			var judgeId=$("#detail_judgeid").val();
			var gender = $("#detail_gender").val();
			var identifiedId = $("#detail_id").val();
			var nationality = $("#detail_nationality").val();
			var judgeContact=$("#detail_mobile").val();
			var jobId=$("#detail_job").val();
			var level = $("#detail_level").val();
			var districtId=$("#detail_district").val();
			var jobAddress=$("#detail_jobaddress").val();
			var identifiedAddress= $("#detail_homeaddress").val();
			var birthday = $("#detail_birthday").val();
			var judgeLevel="";
			if($("#xlevel1").attr("class")=="lev1 judgelevel1"){
				judgeLevel+=1+",";
			}
			if($("#xlevel2").attr("class")=="lev2 judgelevel2"){
				judgeLevel+=2+",";
			}
			if($("#xlevel3").attr("class")=="lev3 judgelevel3"){
				judgeLevel+=3+",";
			}
			if($("#xlevel4").attr("class")=="lev3 judgelevel4"){
				judgeLevel+=4+",";
			}
			if($("#xlevel5").attr("class")=="lev3 judgelevel5"){
				judgeLevel+=5+",";
			}
			if($("#xlevel6").attr("class")=="lev3 judgelevel6"){
				judgeLevel+=6+",";
			}
			if($("#xlevel7").attr("class")=="lev3 judgelevel7"){
				judgeLevel+=7+",";
			}
			if($("#xlevel8").attr("class")=="lev3 judgelevel8"){
				judgeLevel+=8+",";
			}
			$.ajax( {
				async : false,
				cache : false,
				type : 'POST',
			  	data : {
			  		judgeId:judgeId,
			  		jobId:jobId,
			  		districtId:districtId,
			  		identifiedAddress:identifiedAddress,
			  		judgeContact:judgeContact,
			  		jobAddress:jobAddress,
			  		judgeLevel:judgeLevel,
			  		level : level,
			  		nationality: nationality,
			  		birthday :birthday,
			  		identifiedId : identifiedId,
			  		gender : gender
			  		
				},  
				dataType : "json",
				url : "<%=basePath%>judgemanagement/updatejudge.html",
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
					if (data.returnCode == 200) {
						ds.dialog({
							title : '消息提示',
							content : data.returnMessage,
							onyes : true,
							icon : "../images/socceralert.png"
						});
						$('.caipan_detailed').hide();
						$("#fade").hide();
						getJudges();
					} else {
						ds.dialog({
							title : '消息提示',
							content : data.returnMessage,
							onyes : true,
							icon : "../images/info.png"
						});
					}
				}
			})
		}
	</script>
</body>
</html>