<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui-1.8.16.custom.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/dialog.css"
	rel="stylesheet" />
<link type="text/css"
	href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/coach.css">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/Duang.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ui.datepicker-zh-CN.js"></script>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/js/ds.dialog.js"></script>
<head>
<title>身份证阅读器</title>

<style type="text/css">

td.title1 {
	width: 15%;
	text-align: center;
}

td.textbox1 {
	width: 35%;
	text-align: left;
}
</style>
<script language="javascript" type="text/javascript">
	$(function() {
		path="${pageContext.request.contextPath}";
		$("#fileupload1").change(function(){
			var str = $(this).val();
			if(str != null && str != ""){
				var strArray = str.split("\\");
				if(strArray != null && strArray.length > 0){
					var filename = strArray[strArray.length - 1];
					$("#lbfilename1").html(filename);
					$("#image_tcffilename").val(filename);
				}
			}
			
		});
		
		$("#btnupload1").click(function(){
			$("#fileupload1").click();
		});
		
		$("#fileupload2").change(function(){
			var str = $(this).val();
			if(str != null && str != ""){
				var strArray = str.split("\\");
				if(strArray != null && strArray.length > 0){
					var filename = strArray[strArray.length - 1];
					$("#lbfilename2").html(filename);
					$("#image_cfafilename").val(filename);
				}
			}
		});
		
		$("#btnupload2").click(function(){
			$("#fileupload2").click();
		});
		
		$("#sltTCFCertificate").change(function(){
			var value = $(this).val();
			if(value == 1){
				$("#btnupload1").css("display", "block");
				$("#lbfilename1").css("display", "block");
			}
			else if(value == 2){
				$("#btnupload1").css("display", "none");
				$("#lbfilename1").css("display", "none");
			}
		});
		
		$("#sltCFACertificate").change(function(){
			var value = $(this).val();
			if(value > 0 && value < 5){
				$("#btnupload2").css("display", "block");
				$("#lbfilename2").css("display", "block");
			}
			else if(value == 5){
				$("#btnupload2").css("display", "none");
				$("#lbfilename2").css("display", "none");
			}
		});
		
		
		$("#CardReader1").css("visibility", "hidden");
		$("#birthday_input").datepicker();
		$("#birthday_input").datepicker('option', {
			dateFormat : 'yy年mm月dd日'
		});
		
		$("#default_photo_img").css("position", "absolute");
		$("#default_photo_img").css("left", $("#CardReader1").offset().left);
		$("#default_photo_img").css("top", "5px");
		$("#button_reset").click(function() {
			$("#name_input").val("");
	   		$("#gender_input").val("");
	   		$("#nation_input").val("");
	   		$("#birthday_input").val("");
	   		$("#identity_input").val("");
	   		$("#address_input").val("");
	   		$("#phonenum_input").val("");
	   		$("#sltTCFCertificate").val(2);
	   		$("#fileupload1").val(null);
	   		$("#sltCFACertificate").val(5);
	   		$("#fileupload2").val(null);
	   		$("#lbfilename1").html("请选择附件文件");
	   		$("#lbfilename2").html("请选择附件文件");
	   		$("#image_tcffilename").val("");
	   		$("#image_cfafilename").val("");
			$("select option").eq(0).attr('selected', 'true');
			$("#CardReader1").css("visibility", "hidden");
			$("#default_photo_img").css("visibility", "visible");
			$("#btnupload1").css("display", "none");
			$("#lbfilename1").css("display", "none");
			$("#btnupload2").css("display", "none");
			$("#lbfilename2").css("display", "none");
			$("#default_photo_img").attr("src", "../images/defaultuser.png")
		});
		$("#button_register").click(function() {
			var name = $("#name_input").val();
			if (name == "") {
				ds.dialog({
					title : '消息提示',
					content : "姓名不能为空！",
					onyes : true,
					icon : "../../images/info.png"
				});
				return false;
			}
			var gender = $("#gender_input").val();
			if (gender == "男") {
				gender = "1";
			} else if (gender == "女") {
				gender = "2";
			} else {
				ds.dialog({
					title : '消息提示',
					content : "性别格式不符！",
					onyes : true,
					icon : "../../images/info.png"
				});
				return false;
			}
			var nation = $("#nation_input").val();
			if (nation == "") {
				ds.dialog({
					title : '消息提示',
					content : "民族不能为空！",
					onyes : true,
					icon : "../../images/info.png"
				});
				return false;
			}
			var birthday = $("#birthday_input").val();
			if (birthday == "") {
				ds.dialog({
					title : '消息提示',
					content : "生日不能为空！",
					onyes : true,
					icon : "../../images/info.png"
				});
				return false;
			}
			var identity = $("#identity_input").val();
			if (identity == "" || identity.length != 18) {
				ds.dialog({
					title : '消息提示',
					content : "身份证格式不符！",
					onyes : true,
					icon : "../../images/info.png"
				});
				return false;
			}
			
			var tcfcertificate = $("#sltTCFCertificate").val();
			if(tcfcertificate == 1){
				var filename = null;
				filename = $("#fileupload1").val();
				if(filename == null || filename == ""){
					ds.dialog({
						title : '消息提示',
						content : "请选择校园足球教练员证书图片附件！",
						onyes : true,
						icon : "../../images/info.png"
					});
					return false;
				}
				else{
					if(!filename.match(/.jpg|.gif|.png|.bmp/i)){
						ds.dialog({
							title : '消息提示',
							content : "附件格式不符合！(仅支持.jpg|.gif|.png|.bmp文件)",
							onyes : true,
							icon : "../../images/info.png"
						});
						return false;
					}
				}
			}
			
			var cfacertificate = $("#sltCFACertificate").val();
			if(cfacertificate > 0 && cfacertificate < 5){
				var filename = null;
				filename = $("#fileupload2").val();
				if(filename == null || filename == ""){
					ds.dialog({
						title : '消息提示',
						content : "请选择中国足协教练员证书图片附件！",
						onyes : true,
						icon : "../../images/info.png"
					});
					return false;
				}
				else{
					if(!filename.match(/.jpg|.gif|.png|.bmp/i)){
						ds.dialog({
							title : '消息提示',
							content : "附件格式不符合！(仅支持.jpg|.gif|.png|.bmp文件)",
							onyes : true,
							icon : "../../images/info.png"
						});
						return false;
					}
				}
			} 
			var schoolusername = $("#schoolusername_input").val();
			if(schoolusername == ""){
				ds.dialog({
					title : '消息提示',
					content : "学校用户名不能为空！",
					onyes : true,
					icon : "../../images/info.png"
				});
				return false;
			}
			$.ajax({
				type : 'POST',
				url : "${pageContext.request.contextPath}/coachmanagement/getschoolid.html",
				data : {
					schoolusername : schoolusername
				},
				dataType : "json",
				success : function(data) {
					if (data.schoolid == 0) {
						//不存在该学校用户
						ds.dialog({
							title : '消息提示',
							content : "不存在该学校用户,请检查用户名",
							onyes : true,
							icon : "../../images/info.png"
						});
						return false;
					}
					else{
						$("#schoolid_input").val(data.schoolid);
						$("#formCard").ajaxSubmit({
							 type: "POST",
						     url: "${pageContext.request.contextPath}/coachmanagement/adminaddcoach.html",
						     dataType: "json",
						     success: function(data){
						    	 if(data.success){
						    		 ds.dialog({
											title : '消息提示',
											content : data.mesg,
											onyes : true,
											icon : "../../images/socceralert.png"
										});
						    		 $("#name_input").val("");
						    		 $("#gender_input").val("");
						    		 $("#nation_input").val("");
						    		 $("#birthday_input").val("");
						    		 $("#identity_input").val("");
						    		 $("#address_input").val("");
						    		 $("#phonenum_input").val("");
						    		 $("#sltTCFCertificate").val(2);
						    		 $("#fileupload1").val(null);
						    		 $("#sltCFACertificate").val(5);
						    		 $("#fileupload2").val(null);
						    		 $("#lbfilename1").html("请选择附件文件");
						    		 $("#lbfilename2").html("请选择附件文件");
						    		 $("#image_tcffilename").val("");
						 	   		 $("#image_cfafilename").val("");
						    		 $("#CardReader1").css("visibility", "hidden");
						 			 $("#default_photo_img").css("visibility", "visible");
						 			 $("#btnupload1").css("display", "none");
									 $("#lbfilename1").css("display", "none");
									 $("#btnupload2").css("display", "none");
									 $("#lbfilename2").css("display", "none");
									 $("#default_photo_img").attr("src", "../images/defaultuser.png");
						    	 }
						    	 else{
						    		 ds.dialog({
											title : '消息提示',
											content : data.mesg,
											onyes : true,
											icon : "../../images/info.png"
										});
						    	 }
						     },
						     error:function(){
						    	 ds.dialog({
										title : '消息提示',
										content : "添加教练员信息异常！",
										onyes : true,
										icon : "../../images/info.png"
									});
						     }
						}); 
					}
				},
				error : function() {
					ds.dialog({
						title : '消息提示',
						content : "检查学校用户名失败，请修复网络",
						onyes : true,
						icon : "../../images/info.png"
					});
					return false;
				}
			});
		})
});
function byId(id) {
	return document.getElementById(id);
}

var isInit = false;

function readFile(obj){   
    var file = obj.files[0];      
    //判断类型是不是图片  
    if(!/image\/\w+/.test(file.type)){     
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
    reader.onload = function(e){ 
    	var form = byId("formCard");
    	var _result = this.result;
    	form.base64Image.value = _result.substring(_result.indexOf("base64")+7);
		$("#default_photo_img").attr("src",_result);
    }   
}   

function readCard() {
	var obj = byId("CardReader1");
	var form = byId("formCard");
	if (false == isInit) {
		//设置端口号，1表示串口1，2表示串口2，依此类推；1001表示USB。0表示自动选择
		obj.setPortNum(0);
		isInit = true;
	}
	//使用重复读卡功能
	obj.Flag = 0;
	//obj.BaudRate=115200;
	//读卡
	var rst = obj.ReadCard();
	//获取各项信息
	if (0x90 == rst) {
		form.name.value = obj.NameL();
		form.gender.value = obj.SexL();
		form.nation.value = obj.NationL();
		form.birthday.value = obj.BornL();
		form.identity.value = obj.CardNo();
		form.address.value = obj.Address();
		form.base64Image.value = obj.GetImage();
	} else {
		form.name.value = "";
		form.gender.value = "";
		form.nation.value = "";
		form.birthday.value = "";
		form.identity.value = "";
		form.address.value = "";
		form.base64Image.value = "";
	}

	$("#CardReader1").css("visibility", "visible");
	$("#default_photo_img").css("visibility", "hidden");
}

function GetState() {
	var obj = byId("CardReader1");
	obj.GetState();
}
</script>
</head>

<body>
	<div class="neirong_wk">
		<form id="formCard" method="POST" enctype="multipart/form-data">
			<table class="center_table" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="120px">姓名(<font style="color:red;">*</font>)：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<input id="name_input" type="text" class="input_text"
									name="name">
							</div>
							<div class="input_r"></div>
						</div>
					</td>
					<td align="center" rowspan="7" colspan="2" width="325px"><object id="CardReader1"
							codebase="<%=basePath%>jsp/FirstActivex.cab#version=1,3,1,1"
							classid="CLSID:F225795B-A882-4FBA-934C-805E1B2FBD1B"
							width="150px" height="180px">
							<param name="_Version" value="65536" />
							<param name="_ExtentX" value="2646" />
							<param name="_ExtentY" value="1323" />
							<param name="_StockProps" value="0" />

						</object> <img id="default_photo_img" name="image" width="150px" height="180px"
						src="../images/defaultuser.png" style="position: relative; left: -20px; top: 5px;"></td>
						<td style="vertical-align: bottom;" rowspan=5 width="175px"><input type="file" accept="image/*" id="picFile" style="width:175px;" onchange="readFile(this)"/></td>
				</tr>
				<tr>
					<td>性别(<font style="color:red;">*</font>)：</td>
					<td>
						<div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<input id="gender_input" type="text" class="input_text"
									name="gender">
							</div>
							<div class="input_r"></div>
						</div>
					</td>
				</tr>
				<tr>
					<td>民族(<font style="color:red;">*</font>)：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<input id="nation_input" type="text" class="input_text"
									name="nation">
							</div>
							<div class="input_r" ></div>
						</div></td>
				</tr>
				<tr>
					<td>生日(<font style="color:red;">*</font>)：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<input id="birthday_input" type="text" class="input_text" 
									name="birthday">
							</div>
							<div class="input_r"></div>
						</div></td>
				</tr>
				<tr>
					<td>身份证号(<font style="color:red;">*</font>)：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<input id="identity_input" type="text" class="input_text"
									name="identity">
							</div>
							<div class="input_r"></div>
						</div></td>
				</tr>
				<tr>
					<td>户籍地址(<font style="color:red;">*</font>)：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<input id="address_input" type="text" class="input_text"
									name="address">
							</div>
							<div class="input_r"></div>
						</div></td>
				</tr>
				<tr>
					<td>学校用户名(<font style="color:red;">*</font>)：</td>
					<td>
						<div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<input id="schoolusername_input" type="text" class="input_text"
									name="schoolusername">
							</div>
							<div class="input_r"></div>
						</div>
					</td>
				</tr>
				<tr>
					<td>手机号码：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<input id="phonenum_input" type="text" class="input_text"
									name="phonenum">
							</div>
							<div class="input_r"></div>
						</div></td>
				</tr>
				<tr>
					<td>固定电话：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<input id="landphonenum_input" type="text" class="input_text"
									name="landphonenum">
							</div>
							<div class="input_r"></div>
						</div></td>
				</tr>
				<tr>
					<td>职业：</td>
					<td>
						<div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<select id="job_select" name="job_select" style="width:100%;margin-top:2px;">
									<c:forEach items="${jobs_list}" var="xx" varStatus="loop">
											<option value="${xx.getJobId()}">${xx.getJobName()}</option>
									</c:forEach>
								</select>
							</div>
							<div class="input_r"></div>
						</div> 
					</td>
				</tr>
				<tr>
					<td>校园足球证书：</td>
					<td>
						<div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<select id="sltTCFCertificate" name="tcfcertificate" style="width:100%;margin-top:2px;">
									<option value="1">已获取</option>
									<option value="2" selected="selected">未获取</option>
								</select>
								<!-- <div class="select_icon">
								</div> -->
							</div>
							<div class="input_r"></div>
						</div> 
					</td>
					<td>
						<input id="fileupload1" name="filetcfcertificate" type="file" style="display:none;">
						<input id="btnupload1" type="button" value="附 件..." class="btn_upload" style="display:none;">
					</td>
					<td style="max-width:250px;padding-left:20px;text-align: left;padding-top:3px;">
						<p id="lbfilename1" class="p_filename" style="display:none;">请选择附件文件</p>
					</td>
				</tr>
				<tr>
					<td>中国足协证书：</td>
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<select id="sltCFACertificate" name="cfacertificate" style="width:100%;margin-top:2px;">
									<option value="5" selected="selected">无证书</option>
									<option value="4">中国足协A级教练员证书</option>
									<option value="3">中国足协B级教练员证书</option>
									<option value="2">中国足协C级教练员证书</option>
									<option value="1">中国足协D级教练员证书</option>
								</select>
								<!-- <div class="select_icon"></div> -->
							</div>
							<div class="input_r"></div>
						</div>
					</td>
					<td>
						<input id="fileupload2" name="filecfacertificate" type="file" style="display:none;">
						<input id="btnupload2" type="button" value="附 件..." class="btn_upload" style="display:none;">
					</td>
					<td style="max-width:250px;padding-left:20px;text-align: left;padding-top:3px;">
						<p id="lbfilename2" class="p_filename" style="display:none;">请选择附件文件</p>
					</td>
				</tr>
				<tr style="display:none;">
					<td><div class="input_wk">
							<div class="input_l"></div>
							<div class="input_m">
								<input id="schoolid_input" type="text" class="input_text"
									name="schoolid">
							</div>
							<div class="input_r"></div>
						</div></td>
				</tr>
			</table>
			<input id="image_input" type="text" class="input_text"
									name="base64Image" style="display:none;">
			<input id="image_tcffilename" type="text" class="input_text"
									name="tcffilename" style="display:none;">
			<input id="image_cfafilename" type="text" class="input_text"
									name="cfafilename" style="display:none;">
			 <div id="btn_table" style="width:75%;margin: 10px auto">
				<input id="button_read" type="button"
						name="btnRead" onclick="readCard()" style="float:left;width:137px;height:41px" />
				
				<input id="button_reset" type="reset"
						name="btnReset" value="" style="float:right;width:102px;height:41px"/>
				
				<input id="button_register" type="button"
						name="btnRegister" style="float:right;width:100px;height:41px;margin-right:10px;"/>
			</div> 
		</form>
	</div>
</body>
</html>
