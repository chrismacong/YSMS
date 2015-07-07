<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>模板</title>
	<script type="text/javascript">
    var num = 0;
	$(function(){
	    $('#moban_s .editor_obj_waikuang').click(function(){
			$('#edit_new_edit').append($(this).html());
			$('#edit_new_edit .editor').each(function(){$(this).attr('contenteditable','true')});	
		});
	}); 
	</script>
</head>
<body>
	<div id="moban_img">
		<p class="gehang_p" >
			<br >
		</p>
		
		<div class="editor_obj_waikuang">
			<fieldset data-id="7987" id="voteimage_default_vote.png" class="editor_obj"><section style="background-color: rgb(255, 255, 255); border: 1px solid rgb(219, 219, 219); margin: 0px 0px 2px 4px; box-sizing: border-box; padding: 0px;"><img name="checkbox_img" class="upload" data-width="100%" alt="" src="../images/default_vote.png" style="width: 100%; box-sizing: border-box; padding: 0px; margin: 0px;" title="" border="0" vspace="0"><label style="float:right;"><input name="praise" disabled="disabled" type="checkbox" value="" onclick="checkCount(this)"/>点个赞</label> </section>
			</fieldset>
			<p class="gehang_p" >
				<br >
			</p>
		</div>
		
		<div class="editor_obj_waikuang">
			<fieldset data-id="7986" class="editor_obj"><section style="background-color: rgb(255, 255, 255); border: 1px solid rgb(219, 219, 219); margin: 0px 0px 2px 4px; box-sizing: border-box; padding: 0px;"><div id="submit_vote_btn" style="width:100%; background-color:#0EE407; -moz-border-radius: 5px; -webkit-border-radius: 5px; border:1px solid #000; padding:10px 0px 10px 0px; text-align:center; font-size:20px;">提&nbsp;交&nbsp;投&nbsp;票</div></section>
			</fieldset>
			<p class="gehang_p" >
				<br >
			</p>
		</div>
	</div>
</body>
</html>