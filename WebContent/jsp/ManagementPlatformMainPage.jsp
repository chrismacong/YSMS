<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	List<Integer> list=(List<Integer>)session.getAttribute("userFunction");
	String  userName=(String)session.getAttribute("userName");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>南京市青少年足球管理平台</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dialog.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/league.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui-1.8.16.custom.css">

<script language="javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ui.datepicker-zh-CN.js"></script>
<script type="text/javascript" src="js/md5.js"></script>
<script type="text/javascript">
	$(function() {
		$('.list').hide();
		path = "${pageContext.request.contextPath}";
		load();
		$(".sea_l").click(function() {
			var searchStr = $("#search").val();
			window.open("http://cn.bing.com/search?q=" + searchStr);
		})
		$("#setting_btn").click(function(event) {
			if ($("#setting_content").css("display") == "none") {
				$("#setting_content").css("display", "block");
				event.stopPropagation();
			} else {
				$("#setting_content").css("display", "none");
			}
		})
		$('body').click(function() {
			$('#setting_content').hide();
		})
		$("#changepwd_btn").click(function() {
			$("#change_pwd_block").css("display", "block");
		});
		$('.close').click(function() {
			$('.list').hide();
			$('.change_pwd').hide();
		})
		$("#logout_btn")
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath}/login/logout.html";
						})
		$(".listchange").click(function() {
			$('.list').show();
		})
		$(".home")
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath}/management.html";
						})
		$("#modify_btn")
				.click(
						function() {
							var oldpwd = $("#old_pwd").val();
							var newpwd = $("#new_pwd").val();
							var newpwdagain = $("#new_pwd_again").val();
							if (newpwd != newpwdagain) {
								ds.dialog({
									title : '消息提示',
									content : "两次新密码输入不一致！",
									onyes : true,
									icon : "../images/info.png"
								});
							} else {
								$
										.ajax({
											type : 'POST',
											url : "${pageContext.request.contextPath}/usermanagement/changepwd.html",
											data : {
												oldpwd : hex_md5(oldpwd),
												newpwd : hex_md5(newpwd)
											},
											dataType : "json",
											success : function(data) {
												if (data.success) {
													ds
															.dialog({
																title : '消息提示',
																content : "修改密码成功！请重新登录！",
																onyes : true,
																icon : "../images/socceralert.png",
															});
													window.location.href = "${pageContext.request.contextPath}/login/logout.html";
												} else {
													ds
															.dialog({
																title : '消息提示',
																content : "原密码输入错误！",
																onyes : true,
																icon : "../images/info.png"
															});
												}
											},
											error : function() {
												ds.dialog({
													title : '消息提示',
													content : "修改失败！请检查网络连接！",
													onyes : true,
													icon : "../images/info.png"
												});
											}
										});
							}
						})
	});
	//加载初始化信息
	function load() {
		$("#league_left_menu").click(
				function() {
					$('.list').hide();
					$("#main_content").attr("src",
							"${pageContext.request.contextPath}/league.html");
					$("#main_content").css("background", "#FFFFFF");
				});
		$("#school_left_menu")
				.click(
						function() {
							$('.list').hide();
							$("#main_content")
									.attr("src",
											"${pageContext.request.contextPath}/schoolmanagement.html");
							$("#main_content").css("background", "#FFFFFF");
						});
		$("#athlete_left_menu")
				.click(
						function() {
							$('.list').hide();
							$("#main_content")
									.attr("src",
											"${pageContext.request.contextPath}/athletemanagement.html");
							$("#main_content").css("background", "#FFFFFF");
						});
		$("#coach_left_menu")
				.click(
						function() {
							$('.list').hide();
							$("#main_content")
									.attr("src",
											"${pageContext.request.contextPath}/coachmanagement.html")
							$("#main_content").css("background", "#FFFFFF");
						})
		$("#user_left_menu")
				.click(
						function() {
							$('.list').hide();
							$("#main_content")
									.attr("src",
											"${pageContext.request.contextPath}/usermanagement.html")
							$("#main_content").css("background", "#FFFFFF");
						})
		$("#judege_left_menu")
				.click(
						function() {
							$('.list').hide();
							$("#main_content")
									.attr("src",
											"${pageContext.request.contextPath}/judgemanagement.html")
							$("#main_content").css("background", "#FFFFFF");
						})
		$("#signup_left_menu").click(
				function() {
					$('.list').hide();
					$("#main_content").attr("src",
							"${pageContext.request.contextPath}/signup.html")
					$("#main_content").css("background", "#FFFFFF");
				})
		$("#game_left_menu")
				.click(
						function() {
							$('.list').hide();
							$("#main_content")
									.attr("src",
											"${pageContext.request.contextPath}/gamemanagement.html")
							$("#main_content").css("background", "#FFFFFF");
						})
		$("#admin_athlete_left_menu")
				.click(
						function() {
							$('.list').hide();
							$("#main_content")
									.attr("src",
											"${pageContext.request.contextPath}/athletemanagement/adminathletemanagement.html");
							$("#main_content").css("background", "#FFFFFF");
						});
		$("#admin_coach_left_menu")
				.click(
						function() {
							$('.list').hide();
							$("#main_content")
									.attr("src",
											"${pageContext.request.contextPath}/coachmanagement/admincoachmanagement.html");
							$("#main_content").css("background", "#FFFFFF");
						});
		$("#news_left_menu")
				.click(
						function() {
							$('.list').hide();
							$("#main_content")
									.attr("src",
											"${pageContext.request.contextPath}/newsmanagement.html");
							$("#main_content").css("background", "#FFFFFF");
						});
		$("#service_news_left_menu")
				.click(
						function() {
							$('.list').hide();
							$("#main_content")
									.attr("src",
											"${pageContext.request.contextPath}/newsmanagement/servicenews.html");
							$("#main_content").css("background", "#FFFFFF");
						});
		$("#newsverify_left_menu")
				.click(
						function() {
							$('.list').hide();
							$("#main_content")
									.attr("src",
											"${pageContext.request.contextPath}/newsmanagement/verifymanagement.html");
							$("#main_content").css("background", "#FFFFFF");
						});
		$("#authoritymatrix_left_menu")
				.click(
						function() {
							$('.list').hide();
							$("#main_content")
									.attr("src",
											"${pageContext.request.contextPath}/authoritymatrix.html");
							$("#main_content").css("background", "#FFFFFF");
						});
	}
</script>
</head>
<body>
	<div class="mainbody">
		<div class="nav_left">
			<div class="project_mark">
				<p>
					<img src="${pageContext.request.contextPath}/images/logo.png">
				</p>
				<p>
					<img
						src="${pageContext.request.contextPath}/images/project_name.png"
						alt="南京市青少年足球管理平台">
				</p>
			</div>
			<div class="userheader">
				<div class="header_img">
					<img src="${pageContext.request.contextPath}/images/headerimg.png" />
				</div>
				<p>${username}</p>
			</div>
			<div class="nav">
				<ul>
					<%
						if (list.contains(3)) {
					%>
					<li id="user_left_menu">
						<div class="fous"></div>
						<div class="icon">
							<img src="${pageContext.request.contextPath}/images/user_m.png">
						</div>
						<div class='miaoshu'>用户管理</div>
					</li>
					<%
						}
					%>
					<%
						if (list.contains(13)) {
					%>
					<li id="authoritymatrix_left_menu">
						<div class="fous"></div>
						<div class="icon">
							<img src="${pageContext.request.contextPath}/images/signup_m.png">
						</div>
						<div class='miaoshu'>权限矩阵</div>
					</li>
					<%
						}
					%>
					<%
						if (list.contains(1)) {
					%>
					<li id="league_left_menu">
						<div class="fous"></div>
						<div class="icon">
							<img
								src="${pageContext.request.contextPath}/images/liansai_m.png">
						</div>
						<div class='miaoshu'>联赛管理</div>
					</li>

					<%
						}
					%>
					<%
						if (list.contains(8)) {
					%>
					<li id="game_left_menu">
						<div class="fous"></div>
						<div class="icon">
							<img src="${pageContext.request.contextPath}/images/bisai_m.png">
						</div>
						<div class='miaoshu'>比赛管理</div>
					</li>
					<%
						}
					%>
					<%
						if (list.contains(2)) {
					%>
					<li id="school_left_menu">
						<div class="fous"></div>
						<div class="icon">
							<img src="${pageContext.request.contextPath}/images/school_m.png">
						</div>
						<div class='miaoshu'>学校管理</div>
					</li>
					<%
						}
					%>
					<!-- 为方便开发暂时注释掉的菜单 -->
					<!-- 
					<li><div class="nav_click_red"></div>
						<div class="icon_nav">训</div>培训管理</li>
						 -->
					<!-- 为方便开发暂时注释掉的菜单 -->
					<!-- 
					<li><div class="nav_click_red"></div>
						<div class="icon_nav">事</div>新闻管理</li>
					 -->
					<%
						if (list.contains(4)) {
					%>
					<li id="judege_left_menu">
						<div class="fous"></div>
						<div class="icon">
							<img src="${pageContext.request.contextPath}/images/caipan_m.png">
						</div>
						<div class='miaoshu'>裁判管理</div>
					</li>
					<%
						}
					%>
					<%
						if (list.contains(5)) {
					%>
					<li id="athlete_left_menu">
						<div class="fous"></div>
						<div class="icon">
							<img
								src="${pageContext.request.contextPath}/images/athlete_m.png">
						</div>
						<div class='miaoshu'>运 动 员</div>
					</li>
					<%
						}
					%>
					<%
						if (list.contains(6)) {
					%>
					<li id="coach_left_menu">
						<div class="fous"></div>
						<div class="icon">
							<img src="${pageContext.request.contextPath}/images/coach_m.png">
						</div>
						<div class='miaoshu'>教 练 员</div>
					</li>
					<%
						}
					%>
					<%
						if (list.contains(7)) {
					%>
					<li id="signup_left_menu">
						<div class="fous"></div>
						<div class="icon">
							<img src="${pageContext.request.contextPath}/images/signup_m.png">
						</div>
						<div class='miaoshu'>联赛报名</div>
					</li>
					<%
						}
					%>
					<%
						if (list.contains(9)) {
					%>
					<li id="admin_athlete_left_menu">
						<div class="fous"></div>
						<div class="icon">
							<img
								src="${pageContext.request.contextPath}/images/athlete_m.png">
						</div>
						<div class='miaoshu'>运动员管理</div>
					</li>
					<%
						}
					%>
					<%
						if (list.contains(10)) {
					%>
					<li id="admin_coach_left_menu">
						<div class="fous"></div>
						<div class="icon">
							<img src="${pageContext.request.contextPath}/images/coach_m.png">
						</div>
						<div class='miaoshu'>教练员管理</div>
					</li>
					<%
						}
					%>
					<%
						if (list.contains(11)) {
					%>
					<li id="news_left_menu">
						<div class="fous"></div>
						<div class="icon">
							<img src="${pageContext.request.contextPath}/images/signup_m.png">
						</div>
						<div class='miaoshu'>订阅号新闻</div>
					</li>
					<%
						}
					%>
					<%
						if (list.contains(12)) {
					%>
					<li id="service_news_left_menu">
						<div class="fous"></div>
						<div class="icon">
							<img src="${pageContext.request.contextPath}/images/signup_m.png">
						</div>
						<div class='miaoshu'>服务号新闻</div>
					</li>
					<%
						}
					%>
					<%
						if (list.contains(13)) {
					%>
					<li id="newsverify_left_menu">
						<div class="fous"></div>
						<div class="icon">
							<img src="${pageContext.request.contextPath}/images/signup_m.png">
						</div>
						<div class='miaoshu'>新闻审核</div>
					</li>
					<%
						}
					%>
				</ul>
			</div>
			<div class="nav_left_bottom"></div>
		</div>
		<div class="content_right">
			<div class="content_top">
				<div class="waikuang_h_s">
					<div class="home"></div>
					<div class="search_wai">
						<div class="sea_l"></div>
						<div class="sea_m">
							<form>
								<input type="text" id="search">
							</form>
						</div>
						<div class="sea_r"></div>
					</div>
					<div class="listchange"></div>
					<div id="setting_btn" class="setting">
						<div id="setting_content" style="display: none;">
							<p id="changepwd_btn" class="re unselectable">修改密码</p>
							<p id="logout_btn" class="unselectable">退出</p>
						</div>
					</div>

					<!-- <div class="message"></div> -->
				</div>
			</div>

			<!--main_content-->
			<div class="main_content">
				<div class="list">
					<div class="neirong">
						<div class="close"></div>
						<h1>Welcome to using Nanjing YouthFootball Management
							Platform</h1>
						<div>欢迎南京市青少年足球管理平台</div>
						<h1>VERSION 0.8.4.0</h1>
						<div>版本更新说明</div>
						<br />
						<h2>0.8.3.2 (2015-08-13 10:34)</h2>
						<div>修改微信获取的最新赛况和最近比赛为多场，最多10场</div>
						<div>修改球衣颜色深浅为任意填写的代表颜色的字符，不多于5个汉字字符</div>
						<br />
						<h2>0.8.4.0 (2015-08-26 14:54)</h2>
						<div>增加了红黄牌停赛信息查看功能</div>
						<div>可以直接从比赛中下载比赛双方的人员名单</div>
						<div>开启了裁判管理功能</div>
						<div>现在可以在登陆界面右下角进入裁判注册绿色通道了</div>
						<br />
						<!-- <h1>相关文件下载</h1> -->
						<!-- <a href="${pageContext.request.contextPath}/YSMSRepo/file/league_regulation.doc">联赛规程（Word）</a> -->
						<!-- <a href="${pageContext.request.contextPath}/YSMSRepo/file/league_regulation.pdf">南京市创建校园足球特色学校名单</a><br/> -->
						<!-- <a href="${pageContext.request.contextPath}/YSMSRepo/file/competition_schedule.doc">联赛日程表</a><br/> -->
						<!-- <a href="${pageContext.request.contextPath}/YSMSRepo/file/meeting_0706.doc">7月6日会议通知</a><br/> -->
					</div>
				</div>
				<iframe class="main_content" id="main_content" frameborder="0"
					scrolling="no" src="${pageContext.request.contextPath}/management/calendar.html">
				</iframe>
			</div>
			<!--main_content END-->

			<div id="change_pwd_block" class="change_pwd" style="display: none;">
				<div class="neirong">
					<div class="close" style="top: -34px; right: -34px;"></div>
					<table style="margin-left: 20px;">
						<tr height="20px">
							<td height="20px"></td>
						</tr>
						<tr>
							<td>原密码：</td>
							<td>
								<div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<input id="old_pwd" type="password" class="input_text"
											name="default">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>新密码：</td>
							<td><div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<input id="new_pwd" type="password" class="input_text"
											name="default">
									</div>
									<div class="input_r"></div>
								</div></td>
						</tr>
						<tr>
							<td>再次输入新密码：</td>
							<td><div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<input id="new_pwd_again" type="password" class="input_text"
											name="default">
									</div>
									<div class="input_r"></div>
								</div></td>
						</tr>
						<tr>
							<td colspan="2">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="2"><a id="modify_btn"></a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>

	</div>
</body>
</html>