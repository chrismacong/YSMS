<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>校园足球新闻</title>
    <link type="text/css" href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
    <link type="text/css" href="${pageContext.request.contextPath}/css/news_edit.css" rel="stylesheet" /><link type="text/css"
	href="${pageContext.request.contextPath}/css/dialog.css"
	rel="stylesheet" />
	<script type="text/javascript">
		var selected_obj;	 
	</script>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/Duang.js"></script>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/new_moban.js"></script>
    <script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/upload_img.js"></script>
    <script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
	<script type="text/javascript">
	var num=0;
	$(function(){
		$("#submit_vote_btn").click(function(){
			var open_id = "${openid}";
			var news_id = "${news.getNid()}";
			var paths = "";
			$(":checkbox").each(function(){
				if($(this)[0].checked) {
					var image_path = $(this).parent().parent().parent().attr("id").substring(10);
					paths = paths + image_path + ",";
				}
			});
			//这里有很奇怪的问题，美元符号找不到网址。所以使用全域名方式去解决
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath}/newsmanagement/vote.html',
				data : {
					news_id : news_id,
					paths : paths,
					open_id : open_id
				},
				dataType : "json",
				success : function(data) {
					if (data.success) {
						window.location.reload();
						//刷新页面，此处应该显示已投票页面
					} else {
						ds.dialog({
							title : '消息提示',
							content : "投票失败！失败原因：错误码3401",
							onyes : true,
							icon : "../../images/info.png"
						});
					}
				},
				error : function() {
					ds.dialog({
						title : '消息提示',
						content : "投票失败！失败原因：错误码3402",
						onyes : true,
						icon : "../../images/info.png"
					});
				}
			});
		})
	})
	//多选框最大选择数量为3 多余3则其他变灰
	function checkCount(obj){
		if($(obj)[0].checked) {
			++num;
			if(num == 3) {
				//alert("最多选择 三项 的上限已满, 其他选项将会变为不可选.");
				$(":checkbox").each(function(){
					if(!$(this)[0].checked) {
						$(this).attr("disabled", "disabled");
					}
				});
			}
		} else {
			--num;
			if(num <= 2) {
				$(":checkbox").each(function(){
					if(!$(this)[0].checked) {
						$(this).removeAttr("disabled");
					}
				});
			}
		}
    }
	</script>
<body>
	<div class="main_content">
		<br/>
		<h1 style="text-align:center; font-size:22px;">${news.getTitle()}</h1>
		<br/>
		<h2 style="text-align:center; font-size:14px; color:#CCCC00;">${news.getDateStr()} &nbsp;&nbsp;${news.getAuthor()}</h2>
		<br/>
		<div id="news_content">
		${newsattr.getContent()}
		</div>
	</div>
</body>
</html>