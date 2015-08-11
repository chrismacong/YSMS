<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新闻编辑</title>
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
<body>
		<div class="main_content">
			<div class="news_edit_left">
				<div class="option_li">
					<div class="news_title" style="background:#3A3332">分类</div>
					<ul>
						<li>标题</li>
						<li>正文</li>
						<li>图片</li>
						<li>投票</li>
					</ul>
				</div>
				<div class="moban_waikuang">
					<div class="news_title" style="background:#D8654A">样式展示区</div>
					<div id="moban_s"></div>
				</div>
			</div>
			<div class="news_edit_right">
				<div class="news_title" style="background:#FCDEBD">功能区
					<div id="refresh"><img src="../images/qinkong_all.png" /><p>清空</p></div>
				</div>
				<div class="edit_new_edit_waikuang">
					<div id="edit_new_edit">
					
					</div>
					<!--图片上传-->
					<div class="upload_out">
						<div class="div_out">
								<div id="dd" ></div>
								<div style="height:200px;width:140px;float: right;">
									<form id="imgform" method="post" enctype="multipart/form-data">
									<a href="javascript:void(0);" class="btn_addPic "><span><em>+</em>添加图片</span>
									 <input type="file"  name="file" id="doc" multiple="multiple" tabindex="3" title="支持jpg、jpeg、gif、png格式，文件小于5M" size="3" name="pic"  class="filePrew" onchange="javascript:setImagePreviews();" accept="image/*" >
	 								</a>
	 								<a class="btn_addPic" id="submit_pic">确  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;认</a>
	 								<a href="javascript:closeupload();" class="btn_addPic ">取  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;消</a>
	 								</form>
	 							</div>
						</div>
					</div>
					<!--图片上传 END-->
				</div>
				<form id="news_form" method="POST" enctype="multipart/form-data">
				<div class="editor_title">
					<label>主标题：</label>
					<input type="text" style="width:200px" id="news_title_text" name="news_title">
					<label>&nbsp;作者：</label>
					<input type="text" style="width:70px" id="news_author_text" name="news_author">
				</div>
				<div class="editor_person">
					<input type="checkbox" id="zhiding" name="zhiding"><label for="zhiding">&nbsp;新闻置顶&nbsp;&nbsp;</label>	
					<label>&nbsp;&nbsp;封面：</label>
					<input type="file" id="coverimg_upload" onchange="readFile(this)" name="coverimg" accept="image/*">
					<input type="text" id="news_html" name="news_html" style="display:none;">
				</div>
				</form>
			</div>
			<!--换颜色的面板-->
			<div id="color_bankuai">
				<div role="tabpanel" class="tab-pane active" id="color-choosen">
			  	 <div class="show_color_val" >
		        	<input id="custom-color-text" class="colorPicker form-control" value="#EF7060">
		        </div>
		        
			 	<hr style="margin:2px 20px;border-color:#ddd;">
			    <ul class="clearfix" style="list-style:none;padding:0 10px 10px;margin:0 0;">
		            <li class="color-swatch" style="background-color: #ac1d10"></li>
		            <li class="color-swatch" style="background-color: #d82821;"></li>
		            <li class="color-swatch default-color" style="background-color: #ef7060;"></li>
		            <li class="color-swatch" style="background-color: #fde2d8;"></li>
		            
		            <li class="color-swatch" style="background-color: #d32a63;"></li>
		            <li class="color-swatch" style="background-color: #eb6794;"></li>
		            <li class="color-swatch" style="background-color: #f5bdd1;"></li>            
		            <li class="color-swatch" style="background-color: #ffebf0;"></li>
		            
		            
		            
		            <li class="color-swatch" style="clear:left;background-color: #e2561b;"></li>
		            <li class="color-swatch" style="background-color: #ff8124;"></li>
		            <li class="color-swatch" style="background-color: #fcb42b;"></li>
		            <li class="color-swatch" style="background-color: #feecaf;"></li>
		            
		            <li class="color-swatch" style="clear:left;background-color: #0c8918;"></li>
		            <li class="color-swatch" style="background-color: #80b135;"></li>
		            <li class="color-swatch" style="background-color:#c2c92a;"></li>
		            <li class="color-swatch" style="background-color:#e5f3d0;"></li>
		            
		            <!-- <li class="color-swatch" style="clear:left;background-color: #1f877a;"></li>
		            <li class="color-swatch" style="background-color: #27abc1;"></li>
		            <li class="color-swatch" style="background-color: #5acfe1;"></li>
		            <li class="color-swatch" style="background-color: #b6f2ea;"></li> -->
		            
		            <li class="color-swatch" style="clear:left;background-color:#374aae;"></li>
		            <li class="color-swatch" style="background-color:#1e9be8;"></li>
		            <li class="color-swatch" style="background-color:#59c3f9;"></li>
		            <li class="color-swatch" style="background-color:#b6e4fd;"></li>
		
		            <li class="color-swatch" style="clear:left;background-color:#5b39b4;"></li>
		            <li class="color-swatch" style="background-color: #4c6ff3;"></li>
		            <li class="color-swatch" style="background-color:#91a8fc;"></li>
		            <li class="color-swatch" style="background-color:#d0dafe;"></li>
		            
		            <!-- 紫色 -->
		            <li class="color-swatch" style="clear:left;background-color:#8d4bbb;"></li>
		            <li class="color-swatch" style="background-color: rgb(166, 91, 203);"></li>
		            <li class="color-swatch" style="background-color:#cca4e3;"></li>
		            <li class="color-swatch" style="background-color: rgb(190, 119, 99);"></li>
		            
		            <li class="color-swatch" data-color="#efefef" style="clear:left;background-color:#3c2822;"></li>
		            <li class="color-swatch" style="background-color:#6b4d40;"></li>
		            <li class="color-swatch" style="background-color:#9f887f;"></li>
		            <li class="color-swatch" style="background-color:#d7ccc8;"></li>
		            
		        	<li class="color-swatch" style="background-color: #212122;"></li>
		        	<li class="color-swatch" style="background-color: #757576;"></li>
		        	<li class="color-swatch" style="background-color: #c6c6c7"></li>
		        	<li class="color-swatch" style="background-color: #f5f5f4"></li>
		        	
		        </ul>
		     </div>
			</div>

			<!--提交按钮-->
			<div class="btn_wk">
				<div class="btn_l btn_l_a_green"></div>
					<div class="btn_m btn_m_a_green">
						<input type="button" class="input_btn" id="new_creat" style="background:none" value="生成新闻">
					</div>
					<div class="btn_r btn_r_a_green"></div>
				</div>
			</div>
</body>
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

		$('#refresh').click(function() {
			$('#edit_new_edit').html('');
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
		$('.input_btn')
				.click(
						function() {
							var news_title = $("#news_title_text").val();
							if (news_title == "") {
								ds.dialog({
									title : '消息提示',
									content : "新闻标题不能为空！",
									onyes : true,
									icon : "../../images/info.png"
								});
								return;
							}
							var news_author = $("#news_author_text").val();
							if (news_author == "") {
								ds.dialog({
									title : '消息提示',
									content : "新闻作者不能为空！",
									onyes : true,
									icon : "../../images/info.png"
								});
								return;
							}
							var isTop = $("#zhiding").is(':checked');
							var coverFileName = $("#coverimg_upload").val();
							if (coverFileName == null || coverFileName == "") {
							} else {
								if (!coverFileName
										.match(/.jpg|.gif|.png|.bmp/i)) {
									ds
											.dialog({
												title : '消息提示',
												content : "封面图片附件格式不符合！(仅支持.jpg|.gif|.png|.bmp文件)",
												onyes : true,
												icon : "../../images/info.png"
											});
									return false;
								}
							}
							var htmlContent = $("#edit_new_edit").html();
							if (htmlContent.length > 65535) {
								ds.dialog({
									title : '消息提示',
									content : "新闻过长！请控制字数！",
									onyes : true,
									icon : "../../images/info.png"
								});
								return false;
							}
							$("#news_html").val($("#edit_new_edit").html());
							$("#news_form")
									.ajaxSubmit(
											{
												type : "POST",
												url : "${pageContext.request.contextPath}/newsmanagement/uploadservicenews.html",
												dataType : "json",
												success : function(data) {
													if (data.success) {
														ds
																.dialog({
																	title : '消息提示',
																	content : "新闻已发布！",
																	yesText : "回到列表",
																	onyes : function() {
																		window.parent.location.href = "${pageContext.request.contextPath}/newsmanagement/servicenews.html";
																	},
																	noText : "再写一篇",
																	onno : function() {
																		location
																				.reload();
																	},
																	icon : "../../images/socceralert.png"
																});
													} else {
														ds
																.dialog({
																	title : '消息提示',
																	content : "新闻发布失败！",
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
</html>