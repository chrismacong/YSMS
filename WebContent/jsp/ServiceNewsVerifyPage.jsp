<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻审核列表</title>
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
	var selected_news;
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
	function changeVerifySta(obj){
		var newsId = $(obj).parent().parent().attr("id").substring(5);
		var verified = $(obj).val() - 1;
		$.ajax({
			type : 'POST',
			data : {
				newsId : newsId,
				verified : verified
			},
			dataType : "json",
			url : "${pageContext.request.contextPath}/newsmanagement/verify.html",
			//请求的action路径
			error : function() { //请求失败处理函数
				ds.dialog({
					title : '消息提示',
					content : "提交审核结果失败，请联系管理员！",
					onyes : true,
					icon : "../../images/info.png"
				});
				cancel_loading();
			},
			success : function(data) { //请求成功后处理函数。 
				loadNews();
				cancel_loading();
			}
		})
	}
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
			url : "${pageContext.request.contextPath}/newsmanagement/getservicenewsforverify.html",
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
						var verified="<select onchange='changeVerifySta(this)'><option value='1' selected = 'selected'>审核</option><option value='2'>通过</option><option value='3'>拒绝</option></select>";
						if(data.news[i].verified == 1)
							verified="<select onchange='changeVerifySta(this)'><option value='1'>审核</option><option value='2' selected = 'selected'>通过</option><option value='3'>拒绝</option></select>";
						else if(data.news[i].verified == 2)
							verified="<select onchange='changeVerifySta(this)'><option value='1'>审核</option><option value='2'>通过</option><option value='3' selected = 'selected'>拒绝</option></select>";
						$("#news_table").append(
										"<tr id='news_" + data.news[i].nid + "'>"
												+ "<td width='60px'>" + index + "</td>"
												+ "<td><p class='title_wenzi'>" + data.news[i].title + "</p></td>"
												+ "<td width='130px' class='suluetu'><img src='${pageContext.request.contextPath}/YSMSRepo/news/cover/" + data.news[i].picurl + "'></td>"
												+ "<td width='100px'>" + verified +  "</td>"
												+ "<td width='100px' class='look_newinfo'><img src='../images/see_info.png' /></td>"
								+ "</tr>");
						}
						
				
					}

				cancel_loading();
				$('.look_newinfo').click(function() {
					var this_new = $(this).parent();
					var news = this_new.attr("id").substring(5);
					selected_news = news;
					$('.new_page').show();
					$('.new_page_neirong').load("${pageContext.request.contextPath}/newsmanagement/newsformodify.html?nid=" + news);
				})
				$('.close').click(function() {
					$('.new_page').hide();
				})
				$('.saveok').click(function() {
					var content = $('#modify_news_content').html();
					$.ajax({
						type : 'POST',
						data : {
							news_id : selected_news,
							content : content
						},
						dataType : "json",
						url : "${pageContext.request.contextPath}/newsmanagement/newsmodify.html",
						//请求的action路径
						error : function() { //请求失败处理函数
							ds.dialog({
								title : '消息提示',
								content : "修改新闻失败!",
								onyes : true,
								icon : "../../images/info.png"
							});
							cancel_loading();
						},
						success : function(data) { //请求成功后处理函数。 
							if(data.success){
								ds.dialog({
									title : '消息提示',
									content : "修改新闻成功!",
									onyes : true,
									icon : "../../images/socceralert.png"
								});
							}
							else{
								ds.dialog({
									title : '消息提示',
									content : "修改新闻失败!",
									onyes : true,
									icon : "../../images/info.png"
								});
							}
							cancel_loading();
						}
					})
				})

				//一个小样式
				$('.list_info tr').find('td:first-child').css('border-right', 'none');
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
					<td width='100px'>审核</td>
					<td width='100px'>查看</td>
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
		<!--新闻查看 END-->

		<!--新闻查看详细 -->
		<div class="new_page" style="display: none">
			<div class="new_page_neirong"></div>
			<div class="close"></div>
			<div class="saveok"></div>
		</div>
		<!--新闻查看详细 END-->
	</div>
</body>
</html>