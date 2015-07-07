<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>投票结果</title>
<link type="text/css"
	href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/news_edit.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/dialog.css"
	rel="stylesheet" />
<script type="text/javascript">
	var selected_obj;
</script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/new_moban.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/upload_img.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<body>
	<div class="main_content">
		<br />
		<h1 style="text-align: center; font-size: 22px;">${news.getTitle()}</h1>
		<br />
		<h2 style="text-align: center; font-size: 14px; color: #CCCC00;">${news.getDateStr()}
			&nbsp;&nbsp;${news.getAuthor()}</h2>
		<br />
		<c:set var="count_index" value="0"></c:set>
		<c:forEach items="${results}" var="xx" varStatus="loop">
			<c:set var="count_index" value="${count_index+1}"></c:set>
			<div class="editor_obj_waikuang">
				<fieldset data-id="131" class="editor_obj">
					<section style="margin: 0.3em 0px; padding-bottom: 1.5em; font-size: 14px; font-weight: bold; text-align: center; text-decoration: inherit; box-sizing: border-box;">
						<img data-width="112px" src="${pageContext.request.contextPath}/YSMSRepo/news/attachment/${xx.getImagePath()}" style="border-radius: 50%; color: inherit; height: 112px ! important; margin-right: 10px; vertical-align: middle; width: 112px; box-sizing: border-box; padding: 0px;">
						<section style="border-left: 1px solid rgb(211, 172, 156); border-color: rgb(211, 172, 156); padding-left: 1em; text-align: left; display: inline-block; height: 6em; vertical-align: top; color: rgb(211, 172, 156); margin-top: 1em; box-sizing: border-box;">
							<h2 data-width="100%" class="editor" contenteditable='false' data-brushtype="text" style="width: 100%; overflow: hidden; height: 50%; font-size: 1.5em; margin-top: -0.15em; border-color: rgb(211, 172, 156); color: inherit; margin-bottom: 0.5em; box-sizing: border-box; padding: 0px;">第${count_index}名</h2>
							<section class="editor" contenteditable='false' data-style="font-size: 16px;" style="font-size: 16px; border-color: rgb(211, 172, 156); color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">
								<p style="box-sizing: border-box; padding: 0px; margin: 0px;">${xx.getVoteNum()}票</p>
							</section>
						</section>
					</section>
				</fieldset>
				<p class="gehang_p" >
					<br >
				</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>