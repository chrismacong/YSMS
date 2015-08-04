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
	href="${pageContext.request.contextPath}/css/zone.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script type="text/javascript">
	$(function() {
		path = "${pageContext.request.contextPath}";
		 getList();
	})
	function download_excel(team_id){
		window.location.href="${pageContext.request.contextPath}/team/exportexcel.html?team_id=" + team_id;
	}
	function download_word(team_id){
		window.location.href="${pageContext.request.contextPath}/team/exportword.html?team_id=" + team_id;
	}
	function download_pdf(team_id){
		window.location.href="${pageContext.request.contextPath}/team/exportpdf.html?team_id=" + team_id;
	}
	
	
	function getList(){
		 
		 var pageIndex = $("#pageIndex").val();
		  $.ajax({
		        async: false,
		        cache: false,
		        type: 'POST',
		        data:	{currentPage: pageIndex},
		        dataType: "json",
		        url: ""+path+"/league/getteamlistbyzoneid.html",
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
		            
		                $("#page_setting").empty();
	
		                if (data.page.hasPrePage == true) {
		                    $("#page_setting").append(" <label onclick='prePage()'>上一页</label>");
		                }
		                if (data.page.hasNextPage == true) {
		                    $("#page_setting").append(" <label onclick='nextPage()'>下一页</label>");
		                }
		                $("#page_setting").append("<span>第</span><input id='pageIndex' type='text' width='5px' value='" + data.page.currentPage + "'>/<span id='pageCount'></span>页 <button id='page_ok' onclick='getList()'>跳转</button>");
		                $("#pageCount").text(data.page.totalPage)
		                  $("#list_teams").empty();
		                for (var i = 0; i < data.team_list.length; i++) {
		                	 $("#list_teams").append("<tr id='tr_"+i+"'></tr>");
		                	 $("#tr_"+i+"").append("<td width='90px'>"+(i+1)+"</td>");
		                	 $("#tr_"+i+"").append("<td width='300px'>"+data.team_list[i].teamName+"</td>");
		                	 $("#tr_"+i+"").append("<td width='300px'>"+data.team_list[i].schoolName+"</td>");
		                	 if(data.team_list[i].schoolCategory==1){
		                		 $("#tr_"+i+"").append("<td width='100px'>小学</td>");
		                	 }else if(data.team_list[i].schoolCategory==2){
		                		 $("#tr_"+i+"").append("<td width='100px'>初中</td>");
		                	 }else if(data.team_list[i].schoolCategory==3){
		                		 $("#tr_"+i+"").append("<td width='100px'>高中</td>");
		                	 }else{
		                		 $("#tr_"+i+"").append("<td width='100px'>其他</td>");
		                	 }
		                	
		                	 $("#tr_"+i+"").append("<td width='53px'></td>");
		                	 $("#tr_"+i+"").append("<td width='54px'><a id='export_excel' onclick='download_excel("+data.team_list[i].teamId+")'></a></td>");
		                	 $("#tr_"+i+"").append("<td width='54px'><a id='export_word' onclick='download_word("+data.team_list[i].teamId+")'></a></td>");
		                	 $("#tr_"+i+"").append("<td width='54px'><a id='export_pdf' onclick='download_pdf("+data.team_list[i].teamId+")'></a></td>");
		                	 $("#tr_"+i+"").append("<td width='53px'></td>");
		                }  
		               
		            }  
		        }
		    })
	}
	
	
	function nextPage() {
	    var index = $("#pageIndex").val();
	    $("#pageIndex").val(parseInt(index) + 1)
	   getList();
	}

	function prePage() {
	    var index = $("#pageIndex").val();
	    $("#pageIndex").val(parseInt(index) - 1)
	    getList();
	}
</script>
<title>已报名列表</title>
</head>
<body>
	<div class="neirong_wk">
		<table class="unselectable" id="team_list" cellpadding="0"
			cellspacing="0">
			<thead>
				<tr>
					<td width='90px'><div class="table_head_left">编号</div></td>
					<td width='300px'><div>球队名称</div></td>
					<td width='300px'>所属学校</td>
					<td width='100px'>学校分类</td>
					<td width='53px'></td>
					<td width='54px'></td>
					<td width='54px'></td>
					<td width='54px'></td>
					<td width='53px'></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="10">
						<div class="tbody_sroll" style="height:470px;">
							<table id="list_teams" cellpadding="0" cellspacing="0"
								width='100%'>
								<%-- <c:set var="count_team" value="0"></c:set>
								<c:forEach items="${team_list}" var="xx" varStatus="loop">
									<c:set var="count_team" value="${count_team+1}"></c:set>
									<tr id="tr_${xx.getTeamId()}">
										<td width="90px">${count_team}</td>
										<td width="300px">${xx.getTeamName()}</td>
										<td width="300px">${xx.getSchoolName()}</td>
										<c:if test="${xx.getSchoolCategory()==0}">
											<td width="100px">小学</td>
										</c:if>
										<c:if test="${xx.getSchoolCategory()==1}">
											<td width="100px">初中</td>
										</c:if>
										<c:if test="${xx.getSchoolCategory()==2}">
											<td width="100px">高中</td>
										</c:if>
										<td width='80px'></td>
										<td style="position:relative;" width='54px'><a id="export_word" onclick="download_word(${xx.getTeamId()})"></a></td>
										<td style="position:relative;" width='54px'><a id="export_pdf" onclick="download_pdf(${xx.getTeamId()})"></a></td>
										<td width='80px'></td>
									</tr>
								</c:forEach> --%>
							</table>
						</div>
					</td>
				</tr>

			</tbody>
		</table>
	</div>
	
		<div id="paging">
				<!--   <div class="choose_kuai">
					<p>
						选择：<label id="checkall">全选</label><label id="check_revsern">反选</label>
					</p>
				</div>  -->
				<div class="choose_btn_delete">

					<!-- <button onclick="deleteUser()">删除</button> -->
					<!-- 	<button>取消</button> -->
					<p style="" id="page_setting" class="choose_kuai">
						<input id='pageIndex' type='text' width='10px' value='1'>
					</p>
				</div>
		</div>
</body>
</html>