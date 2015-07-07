<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui-1.8.16.custom.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dialog.css">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/school.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<script type="text/javascript">
	$(function() {
		path="${pageContext.request.contextPath}";
		getSchools();
		$("#button_filter").click(function() {
			getSchools();
		})
		
		$('.list_info td:first-child').css('border-right','1px solid #a7a7a7')
	})
	function edit(obj) {
		var tr = $(obj).parent().parent();

		/*按钮切换*/
		tr.find('.edit').hide();
		tr.find('.ok').show();
		tr.find('.delete').hide();
		tr.find('.reset').show();
		var td2 = tr.find("td").eq(1)
		var div = td2.find("div").eq(0);
		var val = div.text();
		div.hide();
		createInput("text", val, 'test', 'test', td2);
	}

	function createInput(ty, value, name, id, obj) {
		$('<input />', {
			type : ty,
			val : value,
			name : name,
			id : id,
		}).appendTo(obj);
	}

	function de(obj) {
		var school_id = parseInt($(obj).parent().parent().attr("id").substr(10));
		ds.dialog({
			title : '消息提示',
			content : "将删除该学校的所有信息，确定删除？",
			yesText : "确定",
			onyes : function() {
				$.ajax({
					type : 'POST',
					url : "${pageContext.request.contextPath}/schoolmanagement/deleteschool.html",
					data : {
						school_id : school_id
					},
					dataType : "json",
					success : function(data) {
						if (data.success) {
							window.location.reload();
						} else {
							ds.dialog({
								title : '消息提示',
								content : "删除学校失败！",
								onyes : true,
								icon : "../../images/info.png"
							});
						}
					},
					error : function() {
						ds.dialog({
							title : '消息提示',
							content : "删除学校失败！",
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
	function ok(obj) {
		var school_id = parseInt($(obj).parent().parent().attr("id").substr(10));
		var tr = $(obj).parent().parent();

		/*按钮切换*/
		tr.find('.edit').show();
		tr.find('.ok').hide();
		tr.find('.delete').show();
		tr.find('.reset').hide();

		var td2 = tr.find("td").eq(1);
		var div = td2.find("div").eq(0);
		var value = $("#test").val();
		$
				.ajax({
					type : 'POST',
					url : "${pageContext.request.contextPath}/schoolmanagement/modifyschool.html",
					data : {
						school_id : school_id,
						school_name : value
					},
					dataType : "json",
					success : function(data) {
						if (data.success) {
							$(div).html(value);
						} else {
							ds.dialog({
								title : '消息提示',
								content : "修改学校失败！",
								onyes : true,
								icon : "../../images/info.png"
							});
						}
					},
					error : function() {
						ds.dialog({
							title : '消息提示',
							content : "修改学校失败！",
							onyes : true,
							icon : "../../images/info.png"
						});
					}
				});

		$("#test").remove();
		div.show();
	}
	function re(obj) {
		var tr = $(obj).parent().parent();
		var td2 = tr.find("td").eq(1);
		var div = td2.find("div").eq(0);
		var tr = $(obj).parent().parent();
		tr.find('.edit').show();
		tr.find('.ok').hide();
		tr.find('.delete').show();
		tr.find('.reset').hide();
		$("#test").remove();
		div.show();
	}
	function nextPage() {
		var index = $("#pageIndex").val();
		$("#pageIndex").val(parseInt(index) + 1)
		getSchools();
	}

	function prePage() {
		var index = $("#pageIndex").val();
		$("#pageIndex").val(parseInt(index) - 1)
		getSchools();
	}
	function getSchools() {
		$("#list_schools").empty();
		var current_page = $("#pageIndex").val();
		var r = /^\+?[1-9][0-9]*$/;
		if (!r.test(current_page)) {
			current_page = "1";
		}
		var school_name = $("#search_schoolname").val();
		var category = $("#category_select")[0].selectedIndex;
		if (category == 0) { //若全部则为null
			category = null;
		}
		loading_juggle_empty();
		$
				.ajax({
					type : 'POST',
					data : {
						current_page : current_page,
						school_name : school_name,
						category : category
					},
					dataType : "json",
					url : "${pageContext.request.contextPath}/schoolmanagement/getschools.html",
					//请求的action路径
					error : function() { //请求失败处理函数
						ds.dialog({
							title : '消息提示',
							content : "请求失败，请联系管理员！",
							onyes : true,
							icon : "../../images/info.png"
						});
						cancel_loading();
					},
					success : function(data) { //请求成功后处理函数。 
						if (data != null) {
							$("#page_setting").empty();

							if (data.page.hasPrePage == true) {
								$("#page_setting")
										.append(
												" <label onclick='prePage()'>上一页</label>");
							}
							if (data.page.hasNextPage == true) {
								$("#page_setting")
										.append(
												" <label onclick='nextPage()'>下一页</label>");
							}
							$("#page_setting")
									.append(
											"<span>第</span><input id='pageIndex' type='text' width='10px' value='"
													+ data.page.currentPage
													+ "'>/<span id='pageCount'></span>页 <button id='page_ok' onclick='getSchools()'>跳转</button>");
							$("#pageCount").text(data.page.totalPage)
							for (var i = 0; i < data.data.length; i++) {
								$("#list_schools")
										.append(
												"<tr id='school_td_" + data.data[i].schoolId + "'>"
														+ "<td width='90px'>"
														+ data.page.currentPage * 10 + (i + 1) - 10
														+ "</td>"
														+ "<td width='350px'><div>"
														+ data.data[i].schoolName
														+ "</div></td>"
														+ "<td width='350px'>"
														+ data.data[i].username
														+ "</td>"
														+ "<td width='100px'>"
														+ data.data[i].schoolCategory
														+ "</td>"
														+ "<td width='40px'>&nbsp;</td>"
														+ "<td width='44px'><img class='edit'"
														+ "src='${pageContext.request.contextPath}/images/list_modify_btn.png'"
														+ "alt='修改' onclick='edit(this);' onmouseover='mouseover_obj(this)'  onmouseout='mouseout_obj(this)'/> <img class='ok'"
														+ "src='${pageContext.request.contextPath}/images/list_ok_btn.png'"
														+ "alt='确定' style='display: none' onclick='ok(this);'  onmouseover='mouseover_obj(this)'  onmouseout='mouseout_obj(this)' /></td>"
														+ "<td width='44px'><img class='delete'"
														+ "src='${pageContext.request.contextPath}/images/list_delete_btn.png'"
														+ "alt='删除' onclick='de(this)'  onmouseover='mouseover_obj(this)'  onmouseout='mouseout_obj(this)';/> <img class='reset'"
														+ "src='${pageContext.request.contextPath}/images/list_reset_btn.png'"
														+ "alt='取消' style='display: none' onclick='re(this)'  onmouseover='mouseover_obj(this)'  onmouseout='mouseout_obj(this)';/></td>"
														+ "<td width='40px'>&nbsp;</td></tr>");
								}
						
							}

						cancel_loading();
						}
					/*$("img[src*='list_modify_btn']").hover(
							function(){alert(1);$(this).attr('src','images/list_modify_btn2.png')},
							function(){$(this).attr('src','/YSMS/images/list_modify_btn.png')}
							)*/
				})
	}
</script>
<title>学校列表</title>
</head>
<body>
	<div class="neirong_wk" style="height: 555px;">
		<table align="center" style="margin: 0 auto;">
			<tr>
				<td>学校名称</td>
				<td>
					<div class="input_wk" style="width: 200px">
						<div class="input_l"></div>
						<div class="input_m" style="width: 160px">
							<input id="search_schoolname" type="text" class="input_text">
						</div>
						<div class="input_r"></div>
					</div>
				</td>
				<td>学校分类</td>
				<td><div class="input_wk" style="width: 160px">
						<div class="input_l"></div>
						<div class="input_m" style="width: 120px">
							<div class="select_wk">
								<select id="category_select" style="height: 36px;">
									<option value="0">全部</option>
									<option value="1">小学</option>
									<option value="2">初中</option>
									<option value="3">高中</option>
								</select>
								<div class="select_icon"></div>
							</div>
						</div>
						<div class="input_r"></div>
					</div></td>
				<td><input type="button" id="button_filter"
					style="width: 150px; border-width: 0px;" /></td>
			</tr>
		</table>



		<!--学校查看-->
		<table class="unselectable" id="school_list" cellpadding="0"
			cellspacing="0">
			<thead>
				<tr>
					<td width='90px'><div class="table_head_left">编号</div></td>
					<td width='350px'><div>学校名称</div></td>
					<td width='350px'>用户名</td>
					<td width='100px'>分类</td>
					<td width='40px'></td>
					<td width='44px'></td>
					<td width='44px'></td>
					<td width='40px'></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="10">
						<div class="tbody_sroll" style="height: 450px;overflow: auto;">
							<table id="list_schools" cellpadding="0" cellspacing="0"
								width='100%'>
							</table>
						</div>
					</td>
				</tr>

			</tbody>
		</table>
	</div>
	<!--分页跳转，-->
	<div id="paging" class="choose_bottom">
		<div class="choose_btn_delete">
			<p style="" id="page_setting" class="choose_kuai">
				<input id='pageIndex' type='text' width='10px' value='1'>
			</p>
		</div>
	</div>
	
	
	
	<!--分页跳转，-->
</body>
</html>