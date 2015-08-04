<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dialog.css">
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
<script src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
<script language="javascript" type="text/javascript">
//set the list selector
var setSelector = "#list1";
//set the cookie name
var setCookieName = "listOrder";
//set the cookie expiry time (days):
var setCookieExpiry = 7;
//function that writes the list order to a cookie
$(function(){
	// here, we allow the user to sort the items
	$(setSelector).sortable({
		axis: "y",
		cursor: "move",
		update: function() { getOrder(); }
	});
	
	// here, we reload the saved order
	restoreOrder();
	
	getRules();
	getRank();
	
	$("#rule_btn").click(function(){
		$(".rulesconfig").css("display", "block");
	})
	
	$("#rule_save_btn").click(function(){
		var ruleOrder = "";
		$('input:checkbox:checked').each(function(obj){
			ruleOrder = $(this).attr("id").split("-")[1] + "," + ruleOrder; //注意这里是反着排的
		});
		if(ruleOrder.indexOf(",")>0)
			ruleOrder = ruleOrder.substring(0, ruleOrder.lastIndexOf(","));
		$.ajax({
			type:'POST',
			url:"${pageContext.request.contextPath}/league/setrules.html",
			data:{
				rule_order : ruleOrder
			},
			dataType: "json",
			success:function(data){
				if (data.success) {	
					$(".rulesconfig").css("display", "none");
					getRank();
				}
				else{
					ds.dialog({
						title : '消息提示',
						content : "修改排序规则失败！",
						onyes : true,
						icon : "../images/info.png"
					});
				}
			},
			error:function(){
				ds.dialog({
					title : '消息提示',
					content : "修改排序规则失败！请检查网络！",
					onyes : true,
					icon : "../images/info.png"
				});
			}
		});
	})
	
	$(".close").click(function() {
		$(".rulesconfig").css("display", "none");
	})
})
function getOrder() {
	// save custom order to cookie
	$.cookie(setCookieName, $(setSelector).sortable("toArray"), { expires: setCookieExpiry, path: "/" });
}

// function that restores the list order from a cookie
function restoreOrder() {
	var list = $(setSelector);
	if (list == null) return
	
	// fetch the cookie value (saved order)
	var cookie = $.cookie(setCookieName);
	if (!cookie) return;
	
	// make array from saved order
	var IDs = cookie.split(",");
	
	// fetch current order
	var items = list.sortable("toArray");
	
	// make array from current order
	var rebuild = new Array();
	for ( var v=0, len=items.length; v<len; v++ ){
		rebuild[items[v]] = items[v];
	}
	
	for (var i = 0, n = IDs.length; i < n; i++) {
		
		// item id from saved order
		var itemID = IDs[i];
		
		if (itemID in rebuild) {
		
			// select item id from current order
			var item = rebuild[itemID];
			
			// select the item according to current order
			var child = $("ul.ui-sortable").children("#" + item);
			
			// select the item according to the saved order
			var savedOrd = $("ul.ui-sortable").children("#" + itemID);
			
			// remove all the items
			child.remove();
			
			// add the items in turn according to saved order
			// we need to filter here since the "ui-sortable"
			// class is applied to all ul elements and we
			// only want the very first!  You can modify this
			// to support multiple lists - not tested!
			$("ul.ui-sortable").filter(":first").append(savedOrd);
		}
	}
}
function getRules(){
	var ruleOrder = "${rule_order}";
	var rules = ruleOrder.split(",");
	var rulesIsIncluded = [false, false, false, false, false, false, false, false];
	$("#list1").empty();
	for(var i=rules.length-1;i>=0;i--){
		//HARD CODE
		if(rules[i] == '1'){
			$("#list1").append("<div class='sortable_item' id='item-1'><input id='checked-1' type='checkbox' value='净胜球' checked='checked' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;净胜球</a></div>");
			rulesIsIncluded[0] = true;
		}
		else if(rules[i] == '2'){
			$("#list1").append("<div class='sortable_item' id='item-2'><input id='checked-2' type='checkbox' value='积分' checked='checked' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;积分</a></div>");
			rulesIsIncluded[1] = true;
		}
		else if(rules[i] == '3'){
			$("#list1").append("<div class='sortable_item' id='item-3'><input id='checked-3' type='checkbox' value='进球数' checked='checked' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;进球数</a></div>");
			rulesIsIncluded[2] = true;
		}
		else if(rules[i] == '4'){
			$("#list1").append("<div class='sortable_item' id='item-4'><input id='checked-4' type='checkbox' value='黄牌总数' checked='checked' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;黄牌总数</a></div>");
			rulesIsIncluded[3] = true;
		}
		else if(rules[i] == '5'){
			$("#list1").append("<div class='sortable_item' id='item-5'><input id='checked-5' type='checkbox' value='红牌总数' checked='checked' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;红牌总数</a></div>");
			rulesIsIncluded[4] = true;
		}
		else if(rules[i] == '6'){
			$("#list1").append("<div class='sortable_item' id='item-6'><input id='checked-6' type='checkbox' value='相互间比赛胜负关系' checked='checked' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;相互间比赛胜负关系</a></div>");
			rulesIsIncluded[5] = true;
		}
		else if(rules[i] == '7'){
			$("#list1").append("<div class='sortable_item' id='item-7'><input id='checked-7' type='checkbox' value='相互间比赛净胜球' checked='checked' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;相互间比赛净胜球</a></div>");
			rulesIsIncluded[6] = true;
		}
		else if(rules[i] == '8'){
			$("#list1").append("<div class='sortable_item' id='item-8'><input id='checked-8' type='checkbox' value='相互间比赛进球数' checked='checked' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;相互间比赛进球数</a></div>");
			rulesIsIncluded[7] = true;
		}
	}
	for(var i=0;i<rulesIsIncluded.length;i++){
		if(rulesIsIncluded[i] == false){
			if(i == 0){
				$("#list1").append("<div class='sortable_item' id='item-1'><input id='checked-1' type='checkbox' value='净胜球' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;净胜球</a></div>");
			}
			else if(i == 1){
				$("#list1").append("<div class='sortable_item' id='item-2'><input id='checked-2' type='checkbox' value='积分' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;积分</a></div>");
			}
			else if(i == 2){
				$("#list1").append("<div class='sortable_item' id='item-3'><input id='checked-3' type='checkbox' value='进球数' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;进球数</a></div>");
			}
			else if(i == 3){
				$("#list1").append("<div class='sortable_item' id='item-4'><input id='checked-4' type='checkbox' value='黄牌总数' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;黄牌总数</a></div>");
			}
			else if(i == 4){
				$("#list1").append("<div class='sortable_item' id='item-5'><input id='checked-5' type='checkbox' value='红牌总数' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;红牌总数</a></div>");
			}
			else if(i == 5){
				$("#list1").append("<div class='sortable_item' id='item-6'><input id='checked-6' type='checkbox' value='相互间比赛胜负关系' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;相互间比赛胜负关系</a></div>");
			}
			else if(i == 6){
				$("#list1").append("<div class='sortable_item' id='item-7'><input id='checked-7' type='checkbox' value='相互间比赛净胜球' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;相互间比赛净胜球</a></div>");
			}
			else if(i == 7){
				$("#list1").append("<div class='sortable_item' id='item-8'><input id='checked-8' type='checkbox' value='相互间比赛进球数' style='vertical-align: middle;'/><a>&nbsp;&nbsp;&nbsp;相互间比赛进球数</a></div>");
			}
		}
	}
}

function getRank(){
	
	loading_juggle_empty();
	$("#main").empty();
	$.ajax({
		type:'POST',
		url:"${pageContext.request.contextPath}/league/rank.html",
		dataType: "json",
		success:function(data){
			if (data != null) {	
				$.each(data.marks, function(i, mark){
					var html = "<table class='unselectable' id='league_list' cellpadding='0' cellspacing='0'>" + 
							"<thead><tr><td width='90px' style='border-right-width: 1px; border-right-style: solid; border-right-color: rgb(167, 167, 167);'><div class='table_head_left green'>" + data.groups[i] + "组</div></td>" +
							"<td width='328px'>球队</td>" + 
							"<td width='80px'>胜</td>" + 
							"<td width='80px'>平</td>" + 
							"<td width='80px'>负</td>" + 
							"<td width='100px'>进球</td>" + 
							"<td width='100px'>失球</td>" + 
							"<td width='100px'>净胜球</td>" + 
							"<td width='100px'>积分</td>" + 
							"</tr></thead><tbody>";
					$.each(mark, function(i, markitem){
						html += "<tr>" + 
								"<td width='90px'>" + (i+1) + "</td>" + 
								"<td width='328px'>" + markitem.teamName + "</td>" + 
								"<td width='80px'>" + markitem.winCount + "</td>" + 
								"<td width='80px'>" + markitem.drawCount + "</td>" + 
								"<td width='80px'>" + markitem.loseCount + "</td>" + 
								"<td width='100px'>" + markitem.goalNum + "</td>" + 
								"<td width='100px'>" + markitem.fumbleNum + "</td>" + 
								"<td width='100px'>" + markitem.GD + "</td>" + 
								"<td width='100px'>" + markitem.mark + "</td>" + 
								"</tr>";
						if(i==mark.length-1){
							html += "</tbody></table><br/>";
							$("#main").append(html);
						}
					});
				});
			}
			cancel_loading();
		},
		error:function(){
			cancel_loading();
		}
	});
}
</script>
<title>积分排名</title>
</head>
<body>
	<div class="btn_wk">
		<div class="btn_l btn_l_a_green"></div>
		<div class="btn_m btn_m_a_green">
			<input type="button" class="input_btn" id="rule_btn"
				style="background: none" value="排名规则">
		</div>
		<div class="btn_r btn_r_a_green"></div>
	</div>
	<div id="main" class="main_content" style="height: 575px;"></div>

	<div class="rulesconfig" style="display: none;">
		<div class="neirong">
			<div class="close"></div>
			<h1 id="configtitle">小组赛排名规则</h1>
			<table>
				<tr>
					<td>
						<div id="list1"></div>
					</td>
					<td><img style="width: 250px;"
						src="${pageContext.request.contextPath}/images/rule.png"></td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="btn_wk">
							<div class="btn_l btn_l_a_green"></div>
							<div class="btn_m btn_m_a_green">
								<input type="button" class="input_btn" id="rule_save_btn"
									style="background: none" value="保存修改">
							</div>
							<div class="btn_r btn_r_a_green"></div>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>