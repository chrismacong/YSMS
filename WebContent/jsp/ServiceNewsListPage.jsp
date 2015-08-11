<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻列表</title>
<link type="text/css"
	href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/new_list.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui-1.8.16.custom.css"
	rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath}/css/dialog.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.ui.datepicker-zh-CN.js"
	type="text/javascript"></script>
    <script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<script type="text/javascript">
	$(function() {
		// 时间设置
		$("#time").datepicker();
		$("#time").datepicker('option', {
			dateFormat : 'yy年mm月dd日'
		});
		$("input:disabled").css('color', '#b0b5a0;')
		//获取当前日期
		var myDate = new Date();
		var year = myDate.getFullYear();    //获取完整的年份(4位,1970-????)
		var month = myDate.getMonth() + 1;
		var date = myDate.getDate();
		month = (month+"").length>1 ? month : "0"+month;
		date = (date+"").length>1 ? date : "0"+date;
		var now = year + "年" + month + "月" + date + "日";
		$("#time").val(now);
		loadNews();
		
		$("#button_filter").click(function(){
			loadNews();
		})
	});

	function loadNews(){
		$("#news_table").empty();
		var date = $("#time").val();
		loading_juggle_empty();
		$.ajax({
			type : 'POST',
			data : {
				date : date
			},
			dataType : "json",
			url : "${pageContext.request.contextPath}/newsmanagement/getservicenews.html",
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
					for (var i = 0; i < data.news.length; i++) {
						var index = i+1;
						if(index>10)
							index = "#";
						var verified="审核";
						if(data.news[i].verified == 1)
							verified="通过";
						else if(data.news[i].verified == 2)
							verified="拒绝";
						$("#news_table").append(
										"<tr id='news_" + data.news[i].nid + "'>"
												+ "<td width='60px'><input type='checkbox'>" + index + "</td>"
												+ "<td><p class='title_wenzi'>" + data.news[i].title + "</p></td>"
												+ "<td width='130px' class='suluetu'><img src='${pageContext.request.contextPath}/YSMSRepo/news/cover/" + data.news[i].picurl + "'></td>"
												+ "<td width='160px'><i class='up'></i><i class='down'></i></td>"
												+ "<td width='80px'><p>" + verified +  "</p></td>"
												+ "<td width='60px' class='look_newinfo'><img src='../images/see_info.png' /></td>"
												+ "<td width='60px' class='deletd_new'><img src='../images/error_info.png' /></td>"
												+ "</tr>");
						}
				
					}

				cancel_loading();
				$('.up').click(function() {
					//需要移动的这条新闻(tr)
					var this_new = $(this).parent().parent();
					if (this_new.index() !== 0) {
						//$(this_new).prev().before($(this_new));
						var news_up2down = $(this_new).prev().attr("id").substring(5);
						var news_down2up = $(this_new).attr("id").substring(5);
						loading_juggle_empty();
						$.ajax({
							type : 'POST',
							url : "${pageContext.request.contextPath}/newsmanagement/switchnews.html",
							data : {
								news_up2down : news_up2down,
								news_down2up : news_down2up
							},
							dataType : "json",
							success : function(data) {
								if (data.success) {
									loadNews();
								} else {
									ds.dialog({
										title : '消息提示',
										content : "排序失败！",
										onyes : true,
										icon : "../../images/info.png"
									});
								}
							},
							error : function() {
								ds.dialog({
									title : '消息提示',
									content : "排序失败！",
									onyes : true,
									icon : "../../images/info.png"
								});
							}
						});
						cancel_loading();
					}

				})
				$('.down').click(function() {
					//需要移动的这条新闻(tr)
					var this_new = $(this).parent().parent();
					if (this_new.index() !== -1) {
						//$(this_new).next().after($(this_new));
						var news_down2up = $(this_new).next().attr("id").substring(5);
						var news_up2down = $(this_new).attr("id").substring(5);
						loading_juggle_empty();
						$.ajax({
							type : 'POST',
							url : "${pageContext.request.contextPath}/newsmanagement/switchnews.html",
							data : {
								news_up2down : news_up2down,
								news_down2up : news_down2up
							},
							dataType : "json",
							success : function(data) {
								if (data.success) {
									loadNews();
								} else {
									ds.dialog({
										title : '消息提示',
										content : "排序失败！",
										onyes : true,
										icon : "../../images/info.png"
									});
								}
							},
							error : function() {
								ds.dialog({
									title : '消息提示',
									content : "排序失败！",
									onyes : true,
									icon : "../../images/info.png"
								});
							}
						});
						cancel_loading();
					}
				})
				$('.look_newinfo').click(function() {
					var this_new = $(this).parent();
					var news = this_new.attr("id").substring(5);
					$('.new_page').show();
					$('.new_page_neirong').load("${pageContext.request.contextPath}/newsmanagement/news.html?nid=" + news);
				})
				$('.close').click(function() {
					$('.new_page').hide();
				})
				$('#new_creat_service').click(function(){
					loading_juggle_empty();	
					$('#new_creat_service').disabled = true;
					$('#new_creat_service').css({'opacity':'0.4'});
					var checked = "";
					$(":checkbox").each(function(){
						if($(this)[0].checked) {
							var id = $(this).parent().parent().attr("id").substring(5);
							checked = checked + id + ",";
						}
					});
					loading_juggle_empty();	
					ds.dialog({
						title : '消息提示',
						content : "每月至多推送4条服务号新闻，确认推送？",
						yesText : "确认",
						onyes : function() {
							loading_juggle_empty();
							$.ajax({
								type : 'POST',
								url : "${pageContext.request.contextPath}/newsmanagement/broadcastservice.html",
								data : {
									checked : checked
								},
								dataType : "json",
								success : function(data) {
									if (data.success) {
										ds.dialog({
											title : '消息提示',
											content : "群发成功！",
											onyes : true,
											icon : "../../images/info.png"
										});
										loadNews();
									} else {
										ds.dialog({
											title : '消息提示',
											content : "群发失败！",
											onyes : true,
											icon : "../../images/info.png"
										});
									}
								},
								error : function() {
									ds.dialog({
										title : '消息提示',
										content : "群发失败！",
										onyes : true,
										icon : "../../images/info.png"
									});
								}
							});
							cancel_loading();
							$('#new_creat_service').disabled = false;
							$('#new_creat_service').css({'opacity':'1.0'});
						},
						noText : "取消",
						onno : function() {
							cancel_loading();
							$('#new_creat_service').disabled = false;
							$('#new_creat_service').css({'opacity':'1.0'});
						},
						icon : "../../images/socceralert.png"
					});
				})
				$('.deletd_new').click(function() {
					var this_new = $(this).parent();
					var news = this_new.attr("id").substring(5);
					ds.dialog({
						title : '消息提示',
						content : "确认删除新闻？",
						yesText : "确认",
						onyes : function() {
							loading_juggle_empty();
							$.ajax({
								type : 'POST',
								url : "${pageContext.request.contextPath}/newsmanagement/deletenews.html",
								data : {
									news : news,
								},
								dataType : "json",
								success : function(data) {
									if (data.success) {
										loadNews();
									} else {
										ds.dialog({
											title : '消息提示',
											content : "删除失败！",
											onyes : true,
											icon : "../../images/info.png"
										});
									}
								},
								error : function() {
									ds.dialog({
										title : '消息提示',
										content : "删除失败！",
										onyes : true,
										icon : "../../images/info.png"
									});
								}
							});
							cancel_loading();
						},
						noText : "取消",
						onno : function() {
						},
						icon : "../../images/info.png"
					});
				})

				//一个小样式
				$('.list_info tr').find('td:first-child').css('border-right', 'none');

				$('.up').hover(function() {
					$(this).css('background-image', 'url(../images/upup2.png)')
				}, function() {
					$(this).css('background-image', 'url(../images/upup.png)')
				})
				$('.down').hover(function() {
					$(this).css('background-image', 'url(../images/downdown2.png)')
				}, function() {
					$(this).css('background-image', 'url(../images/downdown.png)')
				})
				}
		})
	}
</script>
<body>
	<div class="neirong_wk">
		<table id="top_table">
			<tr>
				<td>
					<div class="input_wk">
						<div class="input_l"></div>
						<div class="input_m">
							<input type="text" id='time' class="input_text"
								readonly="readonly">
						</div>
						<div class="input_r"></div>
					</div>
				</td>
				<td>
				<input type="button" id="button_filter" style="width: 150px; height:37px;border-width: 0px; cursor:pointer;background: url(http://localhost:8080/YSMS/images/btn_filter.png);">
				</td>
			</tr>
		</table>
		<!--新闻查看-->
		<table id="news_list" class="list_info" cellpadding="0"
			cellspacing="0">
			<thead>
				<tr>
					<td width='60px'><div class="table_head_left green">编号</div></td>
					<td colspan="">标题</td>
					<td width='130px'>缩略封面图</td>
					<td width='160px'>排序</td>
					<td width='80px'>审核</td>
					<td width='60px'>查看</td>
					<td width='60px'>删除</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="10">
						<div class="tbody_sroll">
							<table id="news_table" cellpadding="0" cellspacing="0" width='100%'>
							</table>
						</div>
					</td>
				</tr>
			</tbody>
		</table>

		<div class="btn_wk_broadcast">
			<table id="operation_tb">
				<tr>
					<td>
						<div class="btn_l btn_l_a_green"></div>
						<div class="btn_m btn_m_a_green">
							<input type="button" class="input_btn" id="new_creat_service"
							style="background: none" value="服务号新闻">
						</div>
						<div class="btn_r btn_r_a_green"></div>
					</td>
				</tr>
			</table>
		</div>
		<!--新闻查看 END-->

		<!--新闻查看详细 -->
		<div class="new_page" style="display: none">
			<div class="new_page_neirong"></div>
			<div class="close"></div>
		</div>
		<!--新闻查看详细 END-->
	</div>
</body>
</html>