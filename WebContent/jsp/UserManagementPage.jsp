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
<link rel="stylesheet" 
	type="text/css" href="${pageContext.request.contextPath}/css/dialog.css">
<link type="text/css"
	href="<%=basePath%>css/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/style.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/league.css"
	rel="stylesheet" />
<script src="<%=basePath%>js/jquery.min.js"></script>
<script src="<%=basePath%>js/jquery-ui.min.js"></script>
<script src="<%=basePath%>js/md5.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=basePath%>js/Duang.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=basePath%>js/jquery.ui.datepicker-zh-CN.js"></script>
	<script src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<style type="text/css">
.input_wk {
	width: 280px;
}

.input_m {
	width: 240px;
	cursor: pointer;
}

.input_m .re_button {
	background: #fff;
	color: #333333;
	font-size: 1em
}

.neirong_wk {
	padding-top: 0;
}

textarea {
	font-size: 1.0em;
	font-family: 'Microsoft YaHei', 'SimHei', 'SimSun';
	color: #160b2d;
}

.caipan_detailed {
	position: absolute;
	top: 0;
	left: 250px;
	padding: 20px;
	background: #fff;
	border: 1px solid #0fd46c;
	border-radius: 10px;
	width: 544px;
	z-index: 2;
}

.caipan_apply {
	position: absolute;
	top: 0;
	left: 250px;
	padding: 20px;
	background: #fff;
	border: 1px solid #0fd46c;
	border-radius: 10px;
	width: 544px;
}

.add_info td {
	height: 50px;
}

.name_checkbox {
	height: 20px !important;
}

.black_overlay {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: white;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity = 80);
}
</style>

</head>
<body>
	<div class="main_content">
		<div class="operation">
			<ul class="a_caipan">
				<li id="xsyh" onclick="show(1)"><div>
						<img src="<%=basePath%>images/a_revise.png" />
					</div>
					<p>显示用户</p></li>
				<li id="cxyh" onclick="show(3)"><div>
						<img src="<%=basePath%>images/a_number.png" />
					</div>
					<p>查询用户</p></li>
				<li onclick="show(2)"><div>
						<img src="<%=basePath%>images/a_add.png" />
					</div>
					<p>添加用户</p></li>
				<li id="delete_button" onclick="deleteUsers()"><div>
						<img src="<%=basePath%>images/a_delete.png" />
					</div>
					<p>删除用户</p></li>

			</ul>
		</div>
		<div class="neirong_wk">



			<table id="user_list" class="list_info" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>

						<td width='300px' style="height: 50px">

							<div class="table_head_left" style="width: 310px">账号</div>

						</td>
						<td width='150px' style="height: 50px">密码</td>
						<td width='305px' style="height: 50px">邮箱</td>
						<td width="150px" style="height: 50px">用户组</td>
						<td width='152px' style="height: 50px"></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="5">
							<div class="tbody_sroll" style="height: 480px">
								<table id="list_user" cellpadding="0" cellspacing="0"
									width='100%'>


								</table>
							</div>
						</td>
					</tr>
				</tbody>
			</table>

			<div id="caipan_detailed" class="caipan_detailed "
				style="display: none">
				<div class="neirong">
					<div class="close"></div>
					<table class="add_info" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<td>用户名：</td>
								<td>
									<div class="input_wk">
										<div class="input_l"></div>
										<div class="input_m">
											<input id="userId_detail" type="text" style="display: none;"
												class="input_text"> <input id="userName_detail"
												type="text" class="input_text">
										</div>
										<div class="input_r"></div>
									</div>
								</td>
							</tr>
							<tr>
								<td>邮箱：</td>
								<td>
									<div class="input_wk">
										<div class="input_l"></div>
										<div class="input_m">
											<input id="userEmail_detail" type="text" class="input_text" >
										</div>
										<div class="input_r"></div>
									</div>
								</td>
							</tr>
							<tr>
								<td>输入密码：</td>
								<td>
									<div class="input_wk">
										<div class="input_l"></div>
										<div class="input_m">
											<input id="userPassword_detail" type="password"
												class="input_text" onchange="md5()">
										</div>
										<div class="input_r"></div>
									</div>
								</td>
							</tr>

							<tr>
								<td>用户组：</td>
								<td>
									<div class="input_wk">
										<div class="input_l"></div>
										<div class="input_m">
											<div class="select_wk">
												<select id="userGroup_detail">
													<option value="">--请选择--</option>
												</select>
												<div class="select_icon"></div>
											</div>
										</div>
										<div class="input_r"></div>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<div class="btn_wk"  style="width: 350px">
										<div class="btn_l btn_l_a_green"></div>
										<div class="btn_m btn_m_a_green" style="width: 312px">
											<input type="button" class="input_btn"
												style="background: none" onclick="updateUser();"
												value="点击修改">
										</div>
										<div class="btn_r btn_r_a_green"></div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>


			<!--分页跳转，裁判信息和申请消息都需要-->
			<div id="paging">
				<div class="choose_btn_delete">
					<p style="" id="page_setting" class="choose_kuai">
						<input id='pageIndex' type='text' width='10px' value='1'>
					</p>
				</div>
			</div>
			<!--分页跳转，裁判信息和申请消息都需要-->






			<!--注册弹框-->
			<div id="user_add" style="display: none">
				<table class="add_info" cellpadding="0" cellspacing="0">
					<tbody>

						<tr>
							<td>用户名(<font style="color:red;">*</font>)：</td>
							<td>
								<div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<input id="userName" type="text" class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>邮箱(<font style="color:red;">*</font>)：</td>
							<td>
								<div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<input id="userEmail" type="text" class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>密码(<font style="color:red;">*</font>)：</td>
							<td>
								<div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<input id="userPassword" type="password" class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>确认密码(<font style="color:red;">*</font>)：</td>
							<td>
								<div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<input id="userComfirnPassword" type="password"
											class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>用户组(<font style="color:red;">*</font>)：</td>
							<td>
								<div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<div class="select_wk">
											<select id="userGroup"  >
												<option value="">--请选择--</option>
											</select>
											<div class="select_icon"></div>
										</div>
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>

						<tr>
							<td colspan="2">
								<div class="btn_wk" style="width: 350px">
									<div class="btn_l btn_l_a_green"></div>
									<div class="btn_m btn_m_a_green" style="width: 312px">
										<input type="button" class="input_btn"
											style="background: none" value="添加用户" onclick="addUser()">
									</div>
									<div class="btn_r btn_r_a_green"></div>
								</div>
							</td>
						</tr>

					</tbody>
				</table>

			</div>


			<div id="user_search" style="display: none">

				<table class="add_info" cellpadding="0" cellspacing="0">
					<tbody>
						<tr>
							<td>用户名：</td>
							<td>
								<div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<input id="userName_search" type="text" class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>

						<tr>
							<td>邮箱：</td>
							<td>
								<div class="input_wk">
									<div class="input_l"></div>
									<div class="input_m">
										<input id="userEmail_search" type="text" class="input_text">
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>

						<tr>
							<td>用户组：</td>
							<td>
								<div class="input_wk" >
									<div class="input_l"></div>
									<div class="input_m" >
										<div class="select_wk">
											<select id="userGroup_search" >
												<option value="">--请选择--</option>
												 
											</select>
											<div class="select_icon"></div>
										</div>
									</div>
									<div class="input_r"></div>
								</div>
							</td>
						</tr>

						<tr>
							<td colspan="2">
								<div class="btn_wk" style="width: 350px">
									<div class="btn_l btn_l_a_green"></div>
									<div class="btn_m btn_m_a_green" style="width: 312px">
										<input type="button" class="input_btn"
											style="background: none" value="查询用户"
											onclick="searchUser()">
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

	<!--弹出层时背景层DIV-->
	<div id="fade" class="black_overlay"></div>
	<script type="text/javascript">
	$(function () {
		path="${pageContext.request.contextPath}";
		$("#xsyh").css('border-bottom','3px solid rgb(18, 116, 25)');
	    getUsers();
	     
			 
			$('.close').click(function() {
				$('.caipan_detailed').hide();
				$('#fade').hide();
				$('.caipan_apply').hide();
			})
			$('#riqi').datepicker();
		  
			
	})

	function getGroups(id,flag) {
		var data="";
		if(flag==false){
			data="1,3,4,6,7,8"; //可以被添加的用户组ID，奇怪的写法
		}
	    $("#"+id+"").empty();
	    $.ajax({
	        async: false,
	        cache: false,
	        type: 'POST',
	        data:{args:data},
	        dataType: "json",
	        url: "<%=basePath%>usermanagement/getGroups.html",
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
	            	 $("#"+id+"").append("<option value=''>--请选择--</option>");
	                for (var i = 0; i < data.length; i++) {
	                    $("#"+id+"").append("<option value='" + data[i].group_id + "'>" + data[i].group_name + "</option>");
	                }

	            }
	        }
	    })
	}
	
 

	function getUsers() {


	    $("#list_user").empty();
	    var pageIndex = $("#pageIndex").val();
	    var groupId=$("#userGroup_search").val();
		var userName=$("#userName_search").val();
		var userEmail=$("#userEmail_search").val();
		loading_juggle_empty();
	    $.ajax({
	        async: false,
	        cache: false,
	        type: 'POST',
	        data: {
	        	group_id: groupId,
	        	user_email:userEmail,
	        	user_name:userName,
	            current_page: pageIndex
	        },
	        dataType: "json",
	        url: "<%=basePath%>usermanagement/listUser.html",
	        //请求的action路径
	        error: function () { //请求失败处理函数
	        	ds.dialog({
					title : '消息提示',
					content : "请求失败，请联系管理员！",
					onyes : true,
					icon : "../images/info.png"
				});
	        	cancel_loading();
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
	                $("#page_setting").append("<span>第</span><input id='pageIndex' type='text' width='5px' value='" + data.page.currentPage + "'>/<span id='pageCount'></span>页<button id='page_ok' onclick='getUsers()'>跳转</button>");
	                $("#pageCount").text(data.page.totalPage)
	                for (var i = 0; i < data.data.length; i++) {
	                    $("#list_user").append("<tr><td width='50px' style='border-right: 1px solid rgb(167, 167, 167);'><input name='items' class='name_checkbox' type='checkbox' value='" + data.data[i].user_id + "'></td><td width='250px'>" + data.data[i].user_name + "</td><td width='149px'>*******</td><td width='298px'>" + data.data[i].user_email + "</td><td width='149px'>" + data.data[i].group_name + "</td><td width='149px'><div class='input_l'></div><div class='input_m detailed' style='width: auto;' onclick='getUserById(" + data.data[i].user_id + ")'>详细</div><div class='input_r'></div></td></tr>");
	                }
		        	cancel_loading();
	        		 

	            }
	        }
	    })
	}

	function clearInput(){
		$("#pageIndex").val("1");
		$("#userGroup_search").val("");
		$("#userName_search").val("");
		$("#userEmail_search").val("");
		$("#userName").val("");
	    $("#userEmail").val("");
	    $("#userPassword").val("");
	    $("#userComfirnPassword").val("");
	}
	
	//切换菜单显示

	function show(id) {

	    if (id == 1) {
	    	clearInput()
 	        userGroup = $("#userGroup").val();
	        getUsers()
	        $("#user_list").css("display", "block");
	        $("#paging").css("display", "block");
	        $("#user_add").css("display", "none");
	        $("#user_search").css("display", "none");  
	        $("#delete_button").css("display", "block");  
	        
	    } else if (id == 2) {
	    	clearInput()
	        getGroups("userGroup",false)
	        $("#user_list").css("display", "none");
	        $("#paging").css("display", "none");
	        $("#user_search").css("display", "none");  
	        $("#user_add").css("display", "block");
	        $("#delete_button").css("display", "none");  
	    }
	    else if (id == 3) {
	    	clearInput()
	         getGroups("userGroup_search")
	         $("#user_search").css("display", "block");  
	        $("#user_list").css("display", "none");
	        $("#paging").css("display", "none");
	        $("#user_add").css("display", "none");
	        $("#delete_button").css("display", "none");  

	    }
	}


	function addUser() {

	    var userName = $("#userName").val();

	    var userEmail = $("#userEmail").val();
	    var userPassword = $("#userPassword").val();
	    var userComfirnPassword = $("#userComfirnPassword").val();

	    var userGroup = $("#userGroup").val();

	    if (isEmpty("userName")) {
	    	ds.dialog({
				title : '消息提示',
				content : "请设置用户名！",
				onyes : true,
				icon : "../images/info.png"
			});
	        $("#userName").focus();
	        return;
	    }
	    if (isEmpty("userEmail")) {
	    	ds.dialog({
				title : '消息提示',
				content : "请设置邮箱！",
				onyes : true,
				icon : "../images/info.png"
			});
	        $("#userEmail").focus();
	        return;
	    }
	    if (isEmpty("userPassword")) {
	    	ds.dialog({
				title : '消息提示',
				content : "请设置登录密码！",
				onyes : true,
				icon : "../images/info.png"
			});
	        $("#userPassword").focus();
	        return;
	    }
	    if (isEmpty("userComfirnPassword")) {
	    	ds.dialog({
				title : '消息提示',
				content : "请确认登录密码！",
				onyes : true,
				icon : "../images/info.png"
			});
	        $("#userComfirnPassword").focus();
	        return;
	    }

	    if (userPassword != userComfirnPassword) {
	    	ds.dialog({
				title : '消息提示',
				content : "两次输入的密码不一致，请重新输入！",
				onyes : true,
				icon : "../images/info.png"
			});
	        $("#userPassword").val("");
	        $("#userComfirnPassword").val("");
	        $("#userPassword").focus();
	        return;
	    }
	    if (userPassword.length<6 ) {
	    	ds.dialog({
				title : '消息提示',
				content : "密码长度不能少于6位！",
				onyes : true,
				icon : "../images/info.png"
			});
	        $("#userPassword").val("");
	        $("#userComfirnPassword").val("");
	        $("#userPassword").focus();
	        return;
	    }
	    if (isEmpty("userGroup")) {
	    	ds.dialog({
				title : '消息提示',
				content : "请选择用户组！",
				onyes : true,
				icon : "../images/info.png"
			});
	        $("#userGroup").focus();
	        return;
	    }
	    $.ajax({
	        async: false,
	        cache: false,
	        type: 'POST',
	        data: {
	            userName: userName,
	            userEmail: userEmail,
	            userPassword: hex_md5(userPassword),
	            userGroup: userGroup
	        },
	        dataType: "json",
	        url: "<%=basePath%>usermanagement/adduser.html",
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
	            if (data.returnCode == 200) {
	            	ds.dialog({
						title : '消息提示',
						content : data.returnMessage,
						onyes : true,
						icon : "../images/socceralert.png",
					});
	                $("#userName").val("");
	        	    $("#userEmail").val("");
	        	    $("#userPassword").val("");
	        	    $("#userComfirnPassword").val("");
	        	    $("#userGroup").val("");
	        	    var userGroup = $("#userGroup").val();
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

	function isEmpty(id) {

	    var name = $("#" + id + "").val();

	    if (name == null || name == undefined || name == "" || name == NaN) {
	        return true;
	    }
	    return false;
	}


	function nextPage() {
	    var index = $("#pageIndex").val();
	    $("#pageIndex").val(parseInt(index) + 1)
	    getUsers();
	}

	function prePage() {
	    var index = $("#pageIndex").val();
	    $("#pageIndex").val(parseInt(index) - 1)
	    getUsers();
	}

	$("#checkall").click(function () {
	    $("input[name='items']").each(function () {
	        this.checked = true;
	    });
	});

	$("#check_revsern").click(function () {
	    $("input[name='items']").each(function () {
	        if (this.checked) {
	            this.checked = false;
	        }
	        else {
	            this.checked = true;
	        }
	    });
	});


	function deleteUsers() {
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
	    }else{
	        ds.dialog({
				title : '消息提示',
				content : "该操作不可逆，确定删除？",
				onyes : function(){
					 $.ajax({
					        async: false,
					        cache: false,
					        type: 'POST',
					        data: {
					            user_id: s
					        },
					        dataType: "json",
					        url: "<%=basePath%>usermanagement/deleteuser.html",
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
								/* 		ds.dialog({
											title : '消息提示',
											content : data.returnMessage,
											onyes : true,
											icon : "../images/socceralert.png",
										}); */
										getUsers();

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
				},
				noText : "取消",
				onno : function() {
					this.close();
				},
				icon : "../images/confirm.png"
			});
	    	
	    }

	   
		}
	
	function getUserById(id){
		////ShowDiv("caipan_detailed" ,"fade")
		$('.caipan_detailed').show();
		$("#fade").show();
		getGroups("userGroup_detail");
		 $.ajax({
		        async: false,
		        cache: false,
		        type: 'POST',
		        data: {
		            user_id: id
		        },
		        dataType: "json",
		        url: "<%=basePath%>usermanagement/getuser.html",
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
					if (data != null) {
						$("#userId_detail").val(data[0].user_id);
						$("#userName_detail").val(data[0].user_name);
						$("#userPassword_detail").val(data[0].user_password);
						$("#userEmail_detail").val(data[0].user_email);
						$("#userGroup_detail").val(data[0].group_id);
					}
				}
			})
		}
	
	function searchUser(){
		$("#pageIndex").val("1");
		  getUsers();
		  $("#xsyh").css('border-bottom','3px solid #127419');
		  $("#delete_button").css("display", "block"); 
			 $("#cxyh").css('border','none');
		  $("#user_list").css("display", "block");
	        $("#paging").css("display", "block");
	        $("#user_add").css("display", "none");
	        $("#user_search").css("display", "none");  
	}
	 
	
	function updateUser(){
		 
		var userId=$("#userId_detail").val(); 
		var userName=$("#userName_detail").val();
		var userEmail=$("#userEmail_detail").val();
		var userPassword=$("#userPassword_detail").val();
		var userGroup=$("#userGroup_detail").val();
		 if (isEmpty("userName_detail")) {
			 	ds.dialog({
					title : '消息提示',
					content : "请设置用户名！",
					onyes : true,
					icon : "../images/info.png"
				});
		        $("#userName_detail").focus();
		        return;
		    }
		    if (isEmpty("userEmail_detail")) {
		    	ds.dialog({
					title : '消息提示',
					content : "请设置邮箱！",
					onyes : true,
					icon : "../images/info.png"
				});
		        $("#userEmail_detail").focus();
		        return;
		    }
		    if (isEmpty("userPassword_detail")) {
		    	ds.dialog({
					title : '消息提示',
					content : "设置登录密码！",
					onyes : true,
					icon : "../images/info.png"
				});
		        $("#userPassword_detail").focus();
		        return;
		    }
		    
		    if (isEmpty("userGroup_detail")) {
		    	ds.dialog({
					title : '消息提示',
					content : "请选择用户组！",
					onyes : true,
					icon : "../images/info.png"
				});
		        $("#userGroup_detail").focus();
		        return;
		    }
		 $.ajax({
		        async: false,
		        cache: false,
		        type: 'POST',
		        data: {
		            user_id: userId,
		            user_email:userEmail,
		            user_name:userName,
		            user_password:userPassword,
		            group_id:userGroup
		        },
		        dataType: "json",
		        url: "<%=basePath%>usermanagement/updateuser.html",
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
							icon : "../images/socceralert.png",
						});
						$('.caipan_detailed').hide();
						$('#fade').hide();
						getUsers();
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
	
 	function md5(){
 	     
 		$("#userPassword_detail").val(hex_md5($("#userPassword_detail").val()));
 	}
	 
	</script>

</body>
</html>