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
	function readFile(obj) {
		var file = obj.files[0];
		//判断类型是不是图片  
		if (!/image\/\w+/.test(file.type)) {
			ds.dialog({
				title : '消息提示',
				content : "请确保为图像类型！",
				onyes : true,
				icon : "../../images/info.png"
			});
			return false;
		}
		var reader = new FileReader();
		reader.readAsDataURL(file);
		reader.onload = function(e) {
			var _result = this.result;
			if (_result.length > 65535) {
				ds.dialog({
					title : '消息提示',
					content : "图片过大，请选择小于64KB的封面图片！",
					onyes : true,
					icon : "../../images/info.png"
				});
				var file = $("#coverimg_upload") 
				file.after(file.clone().val("")); 
				file.remove(); 
			}
		}
	}
	$(function() {
		$('.option_li li')
				.click(
						function() {
							$(this).css('background', '#4C4342').siblings()
									.css('background', '#c1aea1');
							switch ($(this).index()) {
							case 0:
								$('#moban_s')
										.load(
												"${pageContext.request.contextPath}/jsp/moban_title.jsp");
								break;
							case 1:
								$('#moban_s')
										.load(
												"${pageContext.request.contextPath}/jsp/moban_textbody.jsp");
								break;
							case 2:
								$('#moban_s')
										.load(
												"${pageContext.request.contextPath}/jsp/moban_img.jsp");
								break;
							case 3:
								$('#moban_s')
										.load(
												"${pageContext.request.contextPath}/jsp/moban_vote.jsp");
								break;
							}
						})

		$('.color-swatch').click(function() {
			var color_now = $(this).css('background-color')
			$('#custom-color-text').val(color_now);
			$('#custom-color-text').css('background-color', color_now);

		})

		$('#editor_cover_image').click(function() {
			$('.upload_out').show();
		})

		$("#submit_pic")
				.click(
						function() {
							$("#imgform")
									.ajaxSubmit(
											{
												type : "POST",
												url : "${pageContext.request.contextPath}/newsmanagement/uploadimage.html",
												dataType : "json",
												success : function(data) {
													if (data.success) {
														$(selected_obj)
																.attr(
																		"src",
																		"${pageContext.request.contextPath}/YSMSRepo/news/attachment/"
																				+ data.dir);
														if ($(selected_obj)
																.attr("name") == "checkbox_img") {
															$(selected_obj)
																	.parent()
																	.parent()
																	.attr(
																			"id",
																			"voteimage_"
																					+ data.dir);
														}
														$('.upload_out').hide();
														$("#dd").empty();
													} else {
														ds
																.dialog({
																	title : '消息提示',
																	content : "图片上传失败！",
																	onyes : true,
																	icon : "../../images/info.png"
																});
													}
												},
												error : function() {
													ds
															.dialog({
																title : '消息提示',
																content : "网络连接异常！",
																onyes : true,
																icon : "../../images/info.png"
															});
												}
											});
						})
	})
</script>
<body>
	<div class="main_content">
		<br />
		<h1 style="text-align: center; font-size: 22px;">${news.getTitle()}</h1>
		<br />
		<h2 style="text-align: center; font-size: 14px; color: #CCCC00;">${news.getDateStr()}
			&nbsp;&nbsp;${news.getAuthor()}</h2>
		<br />
		<div id="modify_news_content">${newsattr.getContent()}</div>
		<!--图片上传-->
		<div class="upload_out">
			<div class="div_out">
				<div id="dd"></div>
				<div style="height: 200px; width: 140px; float: right;">
					<form id="imgform" method="post" enctype="multipart/form-data">
						<a href="javascript:void(0);" class="btn_addPic "><span><em>+</em>添加图片</span>
							<input type="file" name="file" id="doc" multiple="multiple"
							tabindex="3" title="支持jpg、jpeg、gif、png格式，文件小于5M" size="3"
							name="pic" class="filePrew"
							onchange="javascript:setImagePreviews();" accept="image/*">
						</a> <a class="btn_addPic" id="submit_pic">确
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;认</a>
						<a href="javascript:closeupload();" class="btn_addPic ">取
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;消</a>
					</form>
				</div>
			</div>
		</div>
		<!--图片上传 END-->
	</div>
</body>
</html>