<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限矩阵</title>
<link type="text/css"
	href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/autho_matrix.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dialog.css">
<script language="javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<script type="text/javascript">
	$(function() {
		/* For zebra striping */
		$("table tr:nth-child(odd)").addClass("odd-row");
		/* For cell text alignment */
		$("table td:first-child, table th:first-child").addClass("first");
		/* For removing the last border */
		$("table td:last-child, table th:last-child").addClass("last");
		loadGroups();
		$("#add_group").click(function(){
			ds.dialog.prompt("请输入新用户组名称!",function(){
				var groupName = $("#input_in_dialog").val();
				$.ajax({
					type : 'POST',
					data : {
						group_name : groupName
					},
					dataType : "json",
					url : "${pageContext.request.contextPath}/authoritymatrix/addgroup.html",
					//请求的action路径
					error : function() { //请求失败处理函数
						ds.dialog({
							title : '消息提示',
							content : "请求失败，请联系管理员！",
							onyes : true,
							icon : "../../images/info.png"
						});
					},
					success : function(data) { //请求成功后处理函数。 
						if (data.success) {
							loadGroups();
						}
						else{
							ds.dialog({
								title : '消息提示',
								content : "操作失败，请联系管理员！",
								onyes : true,
								icon : "../../images/info.png"
							});
						}
					}
				})
			},"新用户组");
		})
		
	});

	function delete_group(obj){
		ds.dialog({
			title : '消息提示',
			content : "删除用户组会不可逆地删除组中的所有用户相关信息，确认删除？",
			yesText : "确定",
			onyes : function() {

				var objId = $(obj).attr("id");
				var objIds = objId.split("_");
				var groupId = objIds[2];
				$.ajax({
					type : 'POST',
					data : {
						group_id : groupId
					},
					dataType : "json",
					url : "${pageContext.request.contextPath}/authoritymatrix/removegroup.html",
					//请求的action路径
					error : function() { //请求失败处理函数
						ds.dialog({
							title : '消息提示',
							content : "请求失败，请联系管理员！",
							onyes : true,
							icon : "../../images/info.png"
						});
					},
					success : function(data) { //请求成功后处理函数。 
						if (data.success) {
							loadGroups();
						}
						else{
							ds.dialog({
								title : '消息提示',
								content : "操作失败，请联系管理员！",
								onyes : true,
								icon : "../../images/info.png"
							});
						}
					}
				})
			},
			noText : "取消",
			onno : function() {
				this.close();
			},
			icon : "../../images/confirm.png"
		});
	}
	
	function add_authority_to_group(obj){
		var objId = $(obj).attr("id");
		var objIds = objId.split("_");
		var functionId = objIds[1];
		var groupId = objIds[2];
		$.ajax({
			type : 'POST',
			data : {
				function_id : functionId,
				group_id : groupId
			},
			dataType : "json",
			url : "${pageContext.request.contextPath}/authoritymatrix/addauthority.html",
			//请求的action路径
			error : function() { //请求失败处理函数
				ds.dialog({
					title : '消息提示',
					content : "请求失败，请联系管理员！",
					onyes : true,
					icon : "../../images/info.png"
				});
			},
			success : function(data) { //请求成功后处理函数。 
				if (data.success) {
					loadGroups();
				}
				else{
					ds.dialog({
						title : '消息提示',
						content : "操作失败，请联系管理员！",
						onyes : true,
						icon : "../../images/info.png"
					});
				}
			}
		})
	}
	
	function remove_authority_to_group(obj){
		var objId = $(obj).attr("id");
		var objIds = objId.split("_");
		var functionId = objIds[1];
		var groupId = objIds[2];
		$.ajax({
			type : 'POST',
			data : {
				function_id : functionId,
				group_id : groupId
			},
			dataType : "json",
			url : "${pageContext.request.contextPath}/authoritymatrix/removeauthority.html",
			//请求的action路径
			error : function() { //请求失败处理函数
				ds.dialog({
					title : '消息提示',
					content : "请求失败，请联系管理员！",
					onyes : true,
					icon : "../../images/info.png"
				});
			},
			success : function(data) { //请求成功后处理函数。 
				if (data.success) {
					loadGroups();
				}
				else{
					ds.dialog({
						title : '消息提示',
						content : "操作失败，请联系管理员！",
						onyes : true,
						icon : "../../images/info.png"
					});
				}
			}
		})
	}
	
	function loadGroups() {
		loading_juggle_empty();
		$.ajax({
					type : 'POST',
					data : {},
					dataType : "json",
					url : "${pageContext.request.contextPath}/authoritymatrix/getgroups.html",
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
							$("#matrix tr:not(:first)").remove();
							var func_count = data.func_count;
							for (var i = 0; i < data.groups.length; i++) {
								var functions = data.groups[i].functionStr.split(",");
								var content = "<tr id='group_" + data.groups[i].groupId + "'>";
								content += "<td>" + data.groups[i].groupName + "</td>";
								for(var m = 1; m<=func_count; m++){
									var isIncluded = false;
									for(var n=0; n<functions.length; n++){
										if(parseInt(functions[n])==m)//此处保证function表ID连续
										{
											content += "<td><img onclick = 'remove_authority_to_group(this)' class='authority_include' style='cursor:pointer;' class='authority' id='authority_"
												+ m + "_" + data.groups[i].groupId + "' src='${pageContext.request.contextPath}/images/authority_yes.png'></td>";
											isIncluded = true;
										}
									}
									if(!isIncluded){
										content += "<td><img onclick = 'add_authority_to_group(this)' class='authority_exclude' style='cursor:pointer;' id='authority_"
											+ m + "_" + data.groups[i].groupId + "' src='${pageContext.request.contextPath}/images/authority_no.png'></td>";
									}
								}
								content += "<td><img onclick = 'delete_group(this)' id='delete_group_" + data.groups[i].groupId + 
									"' style='cursor:pointer;' src='${pageContext.request.contextPath}/images/authority_del.png'></td>";
								content += "</tr>";
								$("#matrix").append(content);
							}
						}
						cancel_loading();
					}
				})
	}
</script>

</head>
<body>
	<div id="content">

		<table id="matrix" cellspacing="0">
			<tr>
				<th>&nbsp;用户组&nbsp;[<a style="cursor:pointer;" id="add_group">添加</a>]</th>
				<c:forEach items="${functions}" var="xx" varStatus="loop">
					<th>${xx.getFunctionName()}</th>
				</c:forEach>
				<th>&nbsp;操作&nbsp;</th>
			</tr>
		</table>

	</div>


</body>
</html>