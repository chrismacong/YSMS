<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联赛分组</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dialog.css">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui-1.8.16.custom.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/league.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ui.datepicker-zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<style type="text/css">
.neirong_wk {
	height: 655px;
}

.tbody_sroll {
	height: 598px;
}

.table_head_left {
	cursor: pointer;
	background: #127419;
}

.add_liansai {
	position: absolute;
	top: 70px;
	left: 250px;
	padding: 20px;
	background: #fff;
	border: 1px solid #0fd46c;
	border-radius: 10px;
}
</style>
</head>
<body>
	<div class="neirong_wk">

		<table class="unselectable" id="league_list" cellpadding="0"
			cellspacing="0">
			<thead>
				<tr>
					<td width='90px'><div class="table_head_left">组别</div></td>
					<td width='150px'>组别名称</td>
					<td width='680px'>可报名组别等级</td>
					<td width='128px'></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="8">
						<div class="tbody_sroll">
							<table id="league_details" cellpadding="0" cellspacing="0"
								width='100%'>
								<c:set var="count_zone" value="0"></c:set>
								<c:forEach items="${zone_list}" var="xx" varStatus="loop">
									<tr id="zone_${xx.getZoneId()}">
										<c:set var="count_zone" value="${count_zone+1}"></c:set>
										<td width='90px'>${count_zone}</td>
										<td width='150px'>${xx.getZoneName()}</td>
										<td style='position:relative' width='680px'>
											<div style='display:none'>${xx.getLevelStr()}</div>
											<div style='position:absolute;left:2px;top:1px;width:718px;height:46px;'>
												<div style='position:absolute;left:0px;top:0px;width:108px;height:46px;background:url(${pageContext.request.contextPath}/images/primary.png) no-repeat left center;'></div>
												<div style='position:absolute;left:100px;top:0px;width:23px;height:23px;background:url(${pageContext.request.contextPath}/images/primary_male.png) no-repeat left center;'></div>
												<div style='left:125px;top:0px;' class=<c:if test="${xx.getLevelArray()[0]==true}">'include_primary_grade'</c:if><c:if test="${xx.getLevelArray()[0]==false}">'disclude_grade'</c:if>>2</div>
												<div style='left:150px;top:0px;' class=<c:if test="${xx.getLevelArray()[2]==true}">'include_primary_grade'</c:if><c:if test="${xx.getLevelArray()[2]==false}">'disclude_grade'</c:if>>3</div>
												<div style='left:175px;top:0px;' class=<c:if test="${xx.getLevelArray()[4]==true}">'include_primary_grade'</c:if><c:if test="${xx.getLevelArray()[4]==false}">'disclude_grade'</c:if>>4</div>
												<div style='left:200px;top:0px;' class=<c:if test="${xx.getLevelArray()[6]==true}">'include_primary_grade'</c:if><c:if test="${xx.getLevelArray()[6]==false}">'disclude_grade'</c:if>>5</div>
												<div style='left:225px;top:0px;' class=<c:if test="${xx.getLevelArray()[8]==true}">'include_primary_grade'</c:if><c:if test="${xx.getLevelArray()[8]==false}">'disclude_grade'</c:if>>6</div>
												<div style='position:absolute;left:90px;top:23px;width:23px;height:23px;background:url(${pageContext.request.contextPath}/images/primary_female.png) no-repeat left center;'></div>
												<div style='left:115px;top:23px;' class=<c:if test="${xx.getLevelArray()[1]==true}">'include_primary_grade'</c:if><c:if test="${xx.getLevelArray()[1]==false}">'disclude_grade'</c:if>>2</div>
												<div style='left:140px;top:23px;' class=<c:if test="${xx.getLevelArray()[3]==true}">'include_primary_grade'</c:if><c:if test="${xx.getLevelArray()[3]==false}">'disclude_grade'</c:if>>3</div>
												<div style='left:165px;top:23px;' class=<c:if test="${xx.getLevelArray()[5]==true}">'include_primary_grade'</c:if><c:if test="${xx.getLevelArray()[5]==false}">'disclude_grade'</c:if>>4</div>
												<div style='left:190px;top:23px;' class=<c:if test="${xx.getLevelArray()[7]==true}">'include_primary_grade'</c:if><c:if test="${xx.getLevelArray()[7]==false}">'disclude_grade'</c:if>>5</div>
												<div style='left:215px;top:23px;' class=<c:if test="${xx.getLevelArray()[9]==true}">'include_primary_grade'</c:if><c:if test="${xx.getLevelArray()[9]==false}">'disclude_grade'</c:if>>6</div>
												<div style='position:absolute;left:260px;top:0px;width:108px;height:46px;background:url(${pageContext.request.contextPath}/images/junior.png) no-repeat left center;'></div>
												<div style='position:absolute;left:360px;top:0px;width:23px;height:23px;background:url(${pageContext.request.contextPath}/images/junior_male.png) no-repeat left center;'></div>
												<div style='left:385px;top:0px;' class=<c:if test="${xx.getLevelArray()[10]==true}">'include_junior_grade'</c:if><c:if test="${xx.getLevelArray()[10]==false}">'disclude_grade'</c:if>>7</div>
												<div style='left:410px;top:0px;' class=<c:if test="${xx.getLevelArray()[12]==true}">'include_junior_grade'</c:if><c:if test="${xx.getLevelArray()[12]==false}">'disclude_grade'</c:if>>8</div>
												<div style='left:435px;top:0px;' class=<c:if test="${xx.getLevelArray()[14]==true}">'include_junior_grade'</c:if><c:if test="${xx.getLevelArray()[14]==false}">'disclude_grade'</c:if>>9</div>
												<div style='position:absolute;left:350px;top:23px;width:23px;height:23px;background:url(${pageContext.request.contextPath}/images/junior_female.png) no-repeat left center;'></div>
												<div style='left:375px;top:23px;' class=<c:if test="${xx.getLevelArray()[11]==true}">'include_junior_grade'</c:if><c:if test="${xx.getLevelArray()[11]==false}">'disclude_grade'</c:if>>7</div>
												<div style='left:400px;top:23px;' class=<c:if test="${xx.getLevelArray()[13]==true}">'include_junior_grade'</c:if><c:if test="${xx.getLevelArray()[13]==false}">'disclude_grade'</c:if>>8</div>
												<div style='left:425px;top:23px;' class=<c:if test="${xx.getLevelArray()[15]==true}">'include_junior_grade'</c:if><c:if test="${xx.getLevelArray()[15]==false}">'disclude_grade'</c:if>>9</div>
												<div style='position:absolute;left:470px;top:0px;width:108px;height:46px;background:url(${pageContext.request.contextPath}/images/senior.png) no-repeat left center;'></div>
												<div style='position:absolute;left:570px;top:0px;width:23px;height:23px;background:url(${pageContext.request.contextPath}/images/senior_male.png) no-repeat left center;'></div>
												<div style='left:595px;top:0px;' class=<c:if test="${xx.getLevelArray()[16]==true}">'include_senior_grade'</c:if><c:if test="${xx.getLevelArray()[16]==false}">'disclude_grade'</c:if>>1</div>
												<div style='left:620px;top:0px;' class=<c:if test="${xx.getLevelArray()[18]==true}">'include_senior_grade'</c:if><c:if test="${xx.getLevelArray()[18]==false}">'disclude_grade'</c:if>>2</div>
												<div style='left:645px;top:0px;' class=<c:if test="${xx.getLevelArray()[20]==true}">'include_senior_grade'</c:if><c:if test="${xx.getLevelArray()[20]==false}">'disclude_grade'</c:if>>3</div>
												<div style='position:absolute;left:560px;top:23px;width:23px;height:23px;background:url(${pageContext.request.contextPath}/images/senior_female.png) no-repeat left center;'></div>
												<div style='left:585px;top:23px;' class=<c:if test="${xx.getLevelArray()[17]==true}">'include_senior_grade'</c:if><c:if test="${xx.getLevelArray()[17]==false}">'disclude_grade'</c:if>>1</div>
												<div style='left:610px;top:23px;' class=<c:if test="${xx.getLevelArray()[19]==true}">'include_senior_grade'</c:if><c:if test="${xx.getLevelArray()[19]==false}">'disclude_grade'</c:if>>2</div>
												<div style='left:635px;top:23px;' class=<c:if test="${xx.getLevelArray()[21]==true}">'include_senior_grade'</c:if><c:if test="${xx.getLevelArray()[21]==false}">'disclude_grade'</c:if>>3</div>
												
											</div>
										</td>
										<td width='128px' style="align:center;">
											<c:if test="${is_signup_start == true}">
												<a href="javascript:alertmesg('联赛报名未开始!');">未开始</a>
											</c:if>
											<c:if test="${is_signup_start == false}">
												<c:if test="${is_signup_end == true&&xx.getZoneStatus() != 2}">
													<a href="javascript:alertmesg('联赛报名已截止!');">已截止</a>
												</c:if>
												<c:if test="${is_signup_end == true&&xx.getZoneStatus() == 2}">
													<a href="javascript:signup(${xx.getZoneId()},${xx.getZoneStatus()})">已报名</a>
												</c:if>
												<c:if test="${is_signup_end == false}">
													<c:if test="${xx.getZoneStatus()== 0}">
														<a href="javascript:signup(${xx.getZoneId()},${xx.getZoneStatus()})">报名</a>
													</c:if>
													<c:if test="${xx.getZoneStatus() == 1}">
														<a href="javascript:alertmesg('没有权限报名该联赛!');">无权限</a>
													</c:if>
													<c:if test="${xx.getZoneStatus() == 2}">
														<a href="javascript:signup(${xx.getZoneId()},${xx.getZoneStatus()})">已报名</a>
													</c:if>
												</c:if>
											</c:if>
											
										</td>
									</tr>
								</c:forEach>
							</table>
							
							<a href="${pageContext.request.contextPath}/signup.html" style="text-align: right;height:50px;line-height:50px;
																							vertical-align: middle;margin-right: 30px;">《返回联赛列表</a>
						
						</div>
					</td>
				</tr>

			</tbody>
		</table>
		<!--联赛查看-->

	</div>
	<script type="text/javascript">
		$(function(){path="${pageContext.request.contextPath}";})
		function signup(zone_id, status){
			if(zone_id != null && zone_id != ""){
				$.ajax({
					type : 'POST',
					url : "${pageContext.request.contextPath}/team/simplyaddteam.html",
					data : {
						zone_id : zone_id
					},
					dataType : "json",
					success : function(data) {
						if (data != null && data.success) {
							if(status == 0){
								window.location.href = "${pageContext.request.contextPath}/team.html?zone_id=" + zone_id;
							}
							else if(status == 2){
								window.location.href = "${pageContext.request.contextPath}/team/signedup.html?zone_id=" + zone_id;
							}
							
						}
					},
					error : function() {}
				});
				
			}
		}
		
		function alertmesg(mesg){
			ds.dialog({
				title : '消息提示',
				content : mesg,
				onyes : true,
				icon : "../../images/info.png",
			});
		}
	</script>
</body>
</html>