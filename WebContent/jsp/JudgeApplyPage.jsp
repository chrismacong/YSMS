<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>裁判员资格申请</title>
<link type="text/css"
	href="${pageContext.request.contextPath}/css/dialog.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=basePath%>css/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/style.css" rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/league.css"
	rel="stylesheet" />
<link type="text/css" href="<%=basePath%>css/ajaxfileupload.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/applyforcp.css">
<script src="<%=basePath%>js/jquery.min.js"></script>
<script src="<%=basePath%>js/jquery-ui.min.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=basePath%>js/Duang.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=basePath%>js/jquery.ui.datepicker-zh-CN.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=basePath%>js/ajaxfileupload.js"></script>

<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
</head>
<body>
	<div class="header">
		<div class="home"></div>
		<!--头部可以根据首页再修改-->
	</div>
	<div class="title">裁判员资格申请</div>
	<div class="main">
		<table width='100%'>
			<tr>
				<td width='120px'>姓 &nbsp; &nbsp; &nbsp; 名：</td>
				<td><input id="name" type="text" class="inputtext"
					onblur="blura(this)"></td>
			</tr>
			<tr>
				<td>性 &nbsp; &nbsp; &nbsp; 别：</td>
				<td><input type="radio" name="sex" id="gender" value="1"
					class="radio_" checked="checked" onblur="blura(this)"> <label
					for="Y">男</label> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					&nbsp; &nbsp; <input type="radio" name="sex" id="X" class="radio_"
					value="0"><label for="X">女</label></td>
			</tr>
			<tr>
				<td>民 &nbsp; &nbsp; &nbsp; 族：</td>
				<td><input id="nationality" type="text" class="inputtext"
					onblur="blura(this)"></td>
			</tr>

			<tr>
				<td>身&nbsp; 份&nbsp; 证：</td>
				<td><input id="identifiedCard" type="text" class="inputtext"
					onblur="blura(this)"></td>
			</tr>
			<tr>
				<td>家庭住址：</td>
				<td><input id="homeAddress" type="text" class="inputtext"
					onblur="blura(this)"></td>
			</tr>
			<tr>
				<td>职 &nbsp; &nbsp; &nbsp; 业：</td>
				<td><select id="job" class="inputselect" onblur="blura(this)">

				</select></td>
			</tr>
			<tr>
				<td>工作所在区：</td>
				<td><select id="district" class="inputselect"
					onblur="blura(this)">

				</select></td>
			</tr>
			<tr>
				<td>工作地点：</td>
				<td><input id="jobAddress" type="text" class="inputtext"
					onblur="blura(this)"></td>
			</tr>
			<tr>
				<td>证书等级：</td>
				<td><select id="level" class="inputselect"
					onchange="showTips()" onblur="blura(this)">
						<option value="">－－－请选择－－－</option>
						<option value="0">无</option>
						<option value="1">三级裁判员</option>
						<option value="2">二级裁判员</option>
						<option value="3">一级裁判员</option>
						<option value="4">国家级裁判员</option>
						<option value="5">国际级裁判员</option>
				</select></td>
			</tr>
			<tr id="tr_level" style="display: none;">
				<td>证书上传：</td>
				<td><input id="att_level" name="att_level" type="file"
					class="inputtext"></td>
			</tr>
			<tr id="textarea" style="display: none;">
				<td>自我介绍：</td>
				<td><textarea id="tips" rows="6" cols="43" style="resize: none"
						onblur="blura(this)"></textarea></td>
			</tr>
			<tr>
				<td>手机号码：</td>
				<td><input id="mobile" type="text" class="inputtext"
					onblur="blura(this)"></td>
			</tr>
			<tr>
				<td>身份证上传：</td>
				<td><input id="att_id" name="att_id" type="file"
					class="inputtext"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input id="ok" type="button"
					class="inputbtn" value="提交申请" onclick="apply();"></td>
			</tr>
		</table>
	</div>
	<div id="mobanerror" style="display: none">
		<div class="error">
			<div class="error_left"></div>
			<div class="error_middle">请输入正确的名字</div>
			<div class="error_right"></div>
		</div>
	</div>
	<div id="mobanok" style="display: none">
		<div class="shuruok">
			<div></div>
		</div>
	</div>
</body>
<script type="text/javascript">
function blura(obj){
		if($(obj).val()=='')
		{
			$('.error_middle').html('必填项！');
			errorfun_(obj);
		}
		else{
			okfun_(obj);
		}
	}

function errorfun_(obj){
	$(obj).css('border','1px solid #f00');
	$(obj).next().remove();
	$(obj).parent("td").append($('#mobanerror').html());
}
function okfun_(obj){
	$(obj).css('border','1px solid #5abb3c');
	$(obj).next().remove();
	$(obj).parent("td").append($('#mobanok').html());
}

$(function(){
	path="${pageContext.request.contextPath}";
	getJobsAndDistricts();
})

function getJobsAndDistricts(){
	 $.ajax({
	        async: false,
	        cache: false,
	        type: 'POST',
	        dataType: "json",
	        url: "<%=basePath%>judgemanagement/getjobsanddistrict.html",
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
					 if(data!=null){
						 $("#job").empty();
						 $("#district").empty();
						 $("#job").append("<option value=''>－－－请选择－－－</option>");
						 $("#district").append("<option value=''>－－－请选择－－－</option>");
						 for(var i=0;i<data.job.length;i++){
							 $("#job").append("<option value='"+data.job[i].jobId+"'>"+data.job[i].jobName+"</option>")
						 }
						 for(var j=0;j<data.district.length;j++){
							 $("#district").append("<option value='"+data.district[j].districtId+"'>"+data.district[j].districtName+"</option>")
						 } 
					 }
				}
			})
}


function showTips(){
	  
	if($("#level").val()==""){
		$("#textarea").css("display","none");
		$("#tr_level").css("display","none");
		$("#att_level").val("");
		$("#tips").val("");
	}else if($("#level").val()!=0){
		$("#textarea").css("display","none");
		$("#tr_level").css("display","table-row");
		$("#tips").val("");
	} else{
		$("#textarea").css("display","table-row");
		$("#tr_level").css("display","none");
		$("#att_level").val("");
	}
	
}

function apply(){
	ds.dialog({
		title : '消息提示',
		content : "请选择职业！",
		onyes : true,
		icon : "../../images/info.png"
	});
	var name=$("#name").val();
	var gender=$("#gender").val();
	var nationality=$("#nationality").val();
	var identifiedCard=$("#identifiedCard").val();
	var homeAddress=$("#homeAddress").val();
	var job=$("#job").val();
	var district=$("#district").val();
	var jobAddress=$("#jobAddress").val();
	var level=$("#level").val();
	var mobile=$("#mobile").val();
	var tips=$("#tips").val();
	if (isEmpty("name")) {
		ds.dialog({
			title : '消息提示',
			content : "请填写姓名！",
			onyes : true,
			icon : "../../images/info.png"
		});
		$("#name").focus();
		return;
	}
	if (isEmpty("gender")) {
		ds.dialog({
			title : '消息提示',
			content : "请选择性别！",
			onyes : true,
			icon : "../../images/info.png"
		});
		$("#gender").focus();
		return;
	}
	if (isEmpty("nationality")) {
		ds.dialog({
			title : '消息提示',
			content : "请填写民族！",
			onyes : true,
			icon : "../../images/info.png"
		});
		$("#nationality").focus();
		return;
	}
	if (isEmpty("identifiedCard")) {
		ds.dialog({
			title : '消息提示',
			content : "请填写身份证号！",
			onyes : true,
			icon : "../../images/info.png"
		});
		$("#identifiedCard").focus();
		return;
	}
	if (isEmpty("homeAddress")) {
		ds.dialog({
			title : '消息提示',
			content : "请填写家庭住址！",
			onyes : true,
			icon : "../../images/info.png"
		});
		$("#homeAddress").focus();
		return;
	}
	if (isEmpty("job")) {
		ds.dialog({
			title : '消息提示',
			content : "请选择职业！",
			onyes : true,
			icon : "../../images/info.png"
		});
		$("#job").focus();
		return;
	}
	if (isEmpty("district")) {
		ds.dialog({
			title : '消息提示',
			content : "请选择工作区！",
			onyes : true,
			icon : "../../images/info.png"
		});
		$("#district").focus();
		return;
	}
	if (isEmpty("jobAddress")) {
		ds.dialog({
			title : '消息提示',
			content : "请填写工作地址！",
			onyes : true,
			icon : "../../images/info.png"
		});
		$("#jobAddress").focus();
		return;
	}
	if (isEmpty("level")) {
		ds.dialog({
			title : '消息提示',
			content : "请选择证书等级！",
			onyes : true,
			icon : "../../images/info.png"
		});
		$("#level").focus();
		return;
	}
	if($("#level").val()==0){
		if (isEmpty("tips")) {
			ds.dialog({
				title : '消息提示',
				content : "请填写自我介绍！",
				onyes : true,
				icon : "../../images/info.png"
			});
			$("#tips").focus();
			return;
		}
	}
	if (isEmpty("mobile")) {
		ds.dialog({
			title : '消息提示',
			content : "请填写手机号码！",
			onyes : true,
			icon : "../../images/info.png"
		});
		$("#mobile").focus();
		return;
	}
	 $.ajaxFileUpload({  
		 type: 'POST',
         url:"<%=basePath%>judgemanagement/judegapply.html",  
         secureuri:false,  
         data:{
         	identifiedId:identifiedCard,
         	identifiedName:name,
         	identifiedGender:gender,
         	identifiedAddress:homeAddress,
         	identifiedNationality:nationality,
         	judgeMobile:mobile,
         	jobId:job,
         	districtId:district,
         	jobAddress:jobAddress,
         	judgeLevel:level,
         	judgeTips:tips
         },
         fileElementId:["att_level","att_id"],   //file的id  
         dataType:"json",                  //返回数据类型为文本  
         success:function(data){  
        	 ds.dialog({
     			title : '消息提示',
     			content : data.returnMessage,
     			onyes : true,
     			icon : "../../images/info.png"
     		});
			 if(data.returnCode==200){
				 	
					name=$("#name").val("");
					gender=$("#gender").val("");
					nationality=$("#nationality").val("");
					identifiedCard=$("#identifiedCard").val("");
					homeAddress=$("#homeAddress").val("");
					job=$("#job").val("");
					district=$("#district").val("");
					jobAddress=$("#jobAddress").val("");
					level=$("#level").val("");
					mobile=$("#mobile").val("");
					tips=$("#tips").val("");
				  
					location.reload();
			 }
         }  
     })  
	
<%-- 	$.ajax({
        async: false,
        cache: false,
        
       
        dataType: "json",
        url: "<%=basePath%>judgemanagement/judegapply.html",
			//请求的action路径
			error : function() { //请求失败处理函数
				alert("请求失败，请联系管理员！");
			},
			success : function(data) { //请求成功后处理函数。  
				 alert(data.returnMessage)
				 if(data.returnCode==200){
					 	
						name=$("#name").val("");
						gender=$("#gender").val("");
						nationality=$("#nationality").val("");
						identifiedCard=$("#identifiedCard").val("");
						homeAddress=$("#homeAddress").val("");
						job=$("#job").val("");
						district=$("#district").val("");
						jobAddress=$("#jobAddress").val("");
						level=$("#level").val("");
						mobile=$("#mobile").val("");
						tips=$("#tips").val("");
						location.reload();
				 }
			}
		}) --%>
}


function isEmpty(id) {

	var name = $("#" + id + "").val();

	if (name == null || name == undefined || name == "" || name == NaN) {
		return true;
	}
	return false;
}
</script>
</body>
</html>