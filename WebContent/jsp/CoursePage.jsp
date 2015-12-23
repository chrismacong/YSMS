<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/jindu/default.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/jindu/normalize.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/course.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.progress.js"></script>
<title>课程列表</title>
</head>
<body>
	<a class="addbutton"></a>
	<br/>
	<table class="course_table">
		<tr>
			<td>
				<div class="course_content">
					<img class="course_image" src="${pageContext.request.contextPath}/images/course_img1.jpg"/>
					<h1 class="course_title">足球战术与理论学习</h1>
					<table class="subcourse_table">
						<tr>
							<td>进度：<span style='color:red;'>2</span>/10课时</td>
							<td><svg id="container1"></svg></td>
						</tr>
						<tr>
							<td>课程教练或讲师：</td>
							<td>熊磊，徐小平</td>
						</tr>
					</table>
				</div>
			</td>
			<td>
				<div class="course_content">
					<img class="course_image" src="${pageContext.request.contextPath}/images/course_img2.jpg"/>
					<h1 class="course_title">力量与身体素质训练</h1>
					<table class="subcourse_table">
						<tr>
							<td>进度：<span style='color:green;'>8</span>/8课时</td>
							<td><svg id="container2"></svg></td>
						</tr>
						<tr>
							<td>课程教练或讲师：</td>
							<td>马青山</td>
						</tr>
					</table>
				</div>
			</td>
			<td>
				<div class="course_content">
					<img class="course_image" src="${pageContext.request.contextPath}/images/course_img3.jpg"/>
					<h1 class="course_title">分组对抗训练</h1>
					<table class="subcourse_table">
						<tr>
							<td>进度：<span style='color:red;'>7</span>/10课时</td>
							<td><svg id="container3"></svg></td>
						</tr>
						<tr>
							<td>课程教练或讲师：</td>
							<td>安迪·戈尔蒙（西），徐瑞</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>

		<tr>
			<td>
				<div class="course_content">
					<img class="course_image" src="${pageContext.request.contextPath}/images/course_img4.jpg"/>
					<h1 class="course_title">门将训练</h1>
					<table class="subcourse_table">
						<tr>
							<td>进度：<span style='color:red;'>4</span>/10课时</td>
							<td><svg id="container4"></svg></td>
						</tr>
						<tr>
							<td>课程教练或讲师：</td>
							<td>姜洋</td>
						</tr>
					</table>
				</div>
			</td>
			<td>
				<div class="course_content">
					<img class="course_image" src="${pageContext.request.contextPath}/images/course_img5.jpg"/>
					<h1 class="course_title">盘带训练</h1>
					<table class="subcourse_table">
						<tr>
							<td>进度：<span style='color:red;'>2</span>/5课时</td>
							<td><svg id="container5"></svg></td>
						</tr>
						<tr>
							<td>课程教练或讲师：</td>
							<td>安迪·戈尔蒙（西），徐瑞</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
      var progress1 = $("#container1").Progress({
        percent: 20,
        width: 180,
        height: 20,
        fontSize: 12
      });
      var progress2 = $("#container2").Progress({
        percent: 100,
        width: 180,
        height: 20,
        fontSize: 12
      });
      var progress3 = $("#container3").Progress({
        percent: 70,
        width: 180,
        height: 20,
        fontSize: 12
      });
      var progress4 = $("#container4").Progress({
        percent: 40,
        width: 180,
        height: 20,
        fontSize: 12
      });
      var progress5 = $("#container5").Progress({
        percent: 40,
        width: 180,
        height: 20,
        fontSize: 12
      });
	</script>
</body>
</html>