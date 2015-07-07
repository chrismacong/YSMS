<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>模板</title>
<script type="text/javascript">
	$(function() {
		$('#moban_s .editor_obj_waikuang').click(function() {
			$('#edit_new_edit').append($(this).html());
			$('#edit_new_edit .editor').each(function() {
				$(this).attr('contenteditable', 'true')
			});
		});
	});
</script>
</head>
<body>
	<div id="moban_textbody">
		<p class="gehang_p">
			<br>
		</p>


		<div class="editor_obj_waikuang">
			<fieldset data-id="141387" class="editor_obj">
				<section data-style="text-indent: 2em;"
					style="padding: 0px; line-height: 2em; color: rgb(62, 62, 62); font-size: 14px; margin: 15px; box-sizing: border-box;">
					<p class="editor" contenteditable='true'
						style="text-indent: 2em; color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">段落前空两格的简单文本.</p>
				</section>
			</fieldset>
		</div>

		<div class="editor_obj_waikuang">
			<fieldset data-id="141388" class="editor_obj">
				<section data-style="text-indent: 2em;"
					style="padding: 0px; line-height: 2em; color: rgb(62, 62, 62); font-size: 14px; margin: 15px; box-sizing: border-box;">
					<p class="editor" contenteditable='true'
						style="color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">段落前不空格的简单文本.</p>
				</section>
			</fieldset>
		</div>


		<div class="editor_obj_waikuang">
			<fieldset data-id="126" class="editor_obj">
				<fieldset
					style="border: 0px; margin: 5px 0px; box-sizing: border-box; padding: 0px;">
					<section
						style="height: 1em; box-sizing: border-box; padding: 0px; margin: 0px;">
						<section class='color_border' data-width="1.5em"
							style="height: 100%; width: 1.5em; float: left; border-top: 0.4em solid rgb(249, 110, 87); border-color: rgb(249, 110, 87); border-left: 0.4em solid rgb(249, 110, 87); box-sizing: border-box; padding: 0px; margin: 0px;"></section>
						<section class='color_border' data-width="1.5em"
							style="height: 100%; width: 1.5em; float: right; border-top: 0.4em solid rgb(249, 110, 87); border-right: 0.4em solid rgb(249, 110, 87); border-color: rgb(249, 110, 87); box-sizing: border-box; padding: 0px; margin: 0px;"></section>
						<section
							style="display: inline-block; color: transparent; clear: both; box-sizing: border-box; padding: 0px; margin: 0px;"></section>
					</section>
					<section class='color_border'
						style="margin: -0.8em 0.1em -0.8em 0.2em; padding: 0.8em; border: 1px solid rgb(249, 110, 87); border-radius: 0.3em; box-sizing: border-box;">
						<section placeholder="四角宽边框的样式"
							style="color: rgb(51, 51, 51); font-size: 1em; line-height: 1.4; word-break: break-all; word-wrap: break-word; box-sizing: border-box; padding: 0px; margin: 0px;"
							class="editor" contenteditable='false'>四角宽边框的样式</section>
					</section>
					<section
						style="height: 1em; box-sizing: border-box; padding: 0px; margin: 0px;">
						<section class='color_border' data-width="1.5em"
							style="height: 100%; width: 1.5em; float: left; border-bottom: 0.4em solid rgb(249, 110, 87); border-color: rgb(249, 110, 87); border-left: 0.4em solid rgb(249, 110, 87); box-sizing: border-box; padding: 0px; margin: 0px;"></section>
						<section class='color_border' data-width="1.5em"
							style="height: 100%; width: 1.5em; float: right; border-bottom: 0.4em solid rgb(249, 110, 87); border-color: rgb(249, 110, 87); border-right: 0.4em solid rgb(249, 110, 87); box-sizing: border-box; padding: 0px; margin: 0px;"></section>
					</section>
				</fieldset>
			</fieldset>

			<p class="gehang_p">
				<br>
			</p>
		</div>



		<div class="editor_obj_waikuang">
			<fieldset data-id="14" class="editor_obj">
				<blockquote class="not-right-border"
					style="border-width: 1px 1px 1px 5px; border-style: solid; border-color: rgb(238, 238, 238) rgb(238, 238, 238) rgb(238, 238, 238) rgb(159, 136, 127); border-radius: 3px; padding: 10px; margin: 10px 0px; box-sizing: border-box;">
					<h4 class="editor color_wenzi" contenteditable='false'
						style="color: rgb(159, 136, 127); font-weight: bold; font-size: 18px; margin: 5px 0px; border-color: rgb(159, 136, 127); box-sizing: border-box; padding: 0px;">标题文字</h4>
					<section class="editor" contenteditable='false'
						data-style="color:inherit;font-size:14px;"
						style="color: inherit; font-size: 14px; box-sizing: border-box; padding: 0px; margin: 0px;">
						<p class="editor" contenteditable='false'
							style="box-sizing: border-box; padding: 0px; margin: 0px;">内容描述.</p>
					</section>
				</blockquote>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>



		<div class="editor_obj_waikuang">
			<fieldset data-id="2185" class="editor_obj">
				<section
					style="color: inherit; font-size: 16px; padding: 5px 10px 0px 35px; margin-left: 27px; border-left: 2px dotted rgb(228, 228, 228); box-sizing: border-box;">
					<section data-width="32px" title="" data-original-title=""
						class="editor color_bg" contenteditable='false'
						style="width: 32px; height: 32px; margin-left: -53px; margin-top: 23px; color: rgb(202, 251, 215); text-align: center; line-height: 32px; border-radius: 16px; background: none repeat scroll 0% 0% rgb(14, 184, 58); box-sizing: border-box; padding: 0px;">1</section>
					<section class="135brush"
						style="margin-top: -30px; padding-bottom: 10px; color: inherit; box-sizing: border-box;">
						<p
							style="clear: both; line-height: 1.5em; font-size: 14px; color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">
							<span
								style="color: inherit; font-size: 16px; box-sizing: border-box; padding: 0px; margin: 0px;"><strong
								class="editor" contenteditable='false'
								style="color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">如何进入【编辑器】？</strong></span>
						</p>
						<p class="editor" contenteditable='false'
							style="clear: both; line-height: 1.5em; font-size: 14px; color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">网页搜索“135编辑器”，点击第一条搜索结果即可进入编辑器页面</p>
					</section>
				</section>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>



		<div class="editor_obj_waikuang">
			<fieldset data-id="29735" class="editor_obj">
				<section data-width="92px"
					style="width: 92px; margin-bottom: 0px; box-sizing: border-box; padding: 0px;">
					<p
						style="text-align: center; color: inherit; line-height: 2em; box-sizing: border-box; padding: 0px; margin: 0px;">
						<span
							style="border-color: rgb(255, 129, 36); color: rgb(255, 129, 36); font-size: 16px; box-sizing: border-box; padding: 0px; margin: 0px;"><strong
							class="editor color_wenzi" contenteditable='false'
							style="border-color: rgb(255, 129, 36); color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">编辑器</strong></span>
					</p>
				</section>
				<fieldset class="color_border"
					style="margin-top: 0px; padding: 0px 5px; line-height: 10px; color: inherit; border: 1px solid rgb(255, 129, 36); box-sizing: border-box;">
					<section data-width="50%"
						style="padding: 0px; font-size: 16px; color: inherit; height: 8px; margin: -8px 0px 0px 140px; width: 50%; background-color: rgb(254, 254, 254); box-sizing: border-box;">
						<section class="color_bg" data-width="8px"
							style="width: 8px; height: 8px; border-radius: 100%; line-height: 1; box-sizing: border-box; font-size: 18px; text-decoration: inherit; border-color: rgb(255, 129, 36); display: inline-block; margin: 0px; color: inherit; background-color: rgb(255, 129, 36); padding: 0px;"></section>
					</section>
					<section data-style="text-indent: 2em;"
						style="padding: 0px; line-height: 2em; color: rgb(62, 62, 62); font-size: 14px; margin: 15px; box-sizing: border-box;">
						<p class="editor" contenteditable='false'
							style="text-indent: 2em; color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">编辑器是一个在线图文编辑工具，大量节省您排版的时间，让工作更轻松高效。</p>
					</section>
					<section data-width="65%"
						style="padding: 0px; background-color: rgb(254, 254, 254); font-size: 16px; color: inherit; text-align: right; height: 10px; margin: 0px 0px -4px 25px; width: 65%; box-sizing: border-box;">
						<section class="color_bg" data-width="8px"
							style="margin: 0px auto 1px; border-radius: 100%; line-height: 1; box-sizing: border-box; text-decoration: inherit; background-color: rgb(255, 129, 36); border-color: rgb(255, 129, 36); display: inline-block; height: 8px; width: 8px; color: inherit; padding: 0px;"></section>
					</section>
				</fieldset>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>



		<div class="editor_obj_waikuang">
			<fieldset data-id="391" class="editor_obj">
				<fieldset
					style="margin: 2em 1em 1em; padding: 0px; border: 0px rgb(255, 179, 167); border-image-source: none; max-width: 100%; box-sizing: border-box; color: rgb(62, 62, 62); font-size: 16px; line-height: 25px; word-wrap: break-word !important;">
					<section
						style="max-width: 100%; word-wrap: break-word ! important; box-sizing: border-box; line-height: 1.4; margin-left: -0.5em; padding: 0px;">
						<section class="color_bg"
							style="max-width: 100%; box-sizing: border-box; border-color: rgb(0, 0, 0); padding: 3px 8px; border-radius: 4px; color: rgb(167, 23, 0); font-size: 1em; display: inline-block; transform: rotate(-10deg); transform-origin: left center 0px; word-wrap: break-word ! important; background-color: rgb(255, 179, 167); margin: 0px;">
							<span class="editor" contenteditable='false'
								data-brushtype="text"
								style="color: rgb(255, 255, 255); box-sizing: border-box; padding: 0px; margin: 0px;">编辑器</span>
						</section>
					</section>
					<section class="color_border"
						data-style="line-height:24px;color:rgb(89, 89, 89); font-size:14px"
						style="max-width: 100%; box-sizing: border-box; padding: 22px 16px 16px; border: 1px solid rgb(255, 179, 167); color: rgb(0, 0, 0); font-size: 14px; margin-top: -24px;">
						<p
							style="line-height: 24px; box-sizing: border-box; padding: 0px; margin: 0px;">
							<span class="editor" contenteditable='false'
								style="color: rgb(89, 89, 89); font-size: 14px; box-sizing: border-box; padding: 0px; margin: 0px;">135编辑器提供非常好用的微信图文编辑器。可以随心所欲的变换颜色调整格式，更有神奇的自动配色方案。</span>
						</p>
					</section>
				</fieldset>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>



		<div class="editor_obj_waikuang">
			<fieldset data-id="30" class="editor_obj">
				<fieldset
					style="margin: 0px; padding: 5px; border: 1px solid rgb(204, 204, 204); max-width: 100%; color: rgb(62, 62, 62); line-height: 24px; text-align: justify; box-shadow: 5px 5px 2px rgb(165, 165, 165); background-color: rgb(250, 250, 250); box-sizing: border-box;">
					<legend data-width="auto"
						style="margin: 0px 0px 0px 20px; padding: 0px; text-align: left; width: auto; border: medium none; box-sizing: border-box;">
						<strong style="box-sizing: border-box; padding: 0px; margin: 0px;"><strong
							style="background-color: rgb(255, 255, 245); color: rgb(102, 102, 102); line-height: 20px; box-sizing: border-box; padding: 0px; margin: 0px;"><span
								class="editor color_bg" contenteditable='false'
								data-brushtype="text"
								style="background-color: red; border-radius: 0.5em 3em/4em 1em 2em; box-shadow: 4px 4px 2px rgb(165, 165, 165); color: white; max-width: 100%; padding: 4px 10px; text-align: justify; box-sizing: border-box; margin: 0px;">公告通知</span></strong></strong>
					</legend>
					<section style="box-sizing: border-box; padding: 0px; margin: 0px;"
						class="135brush"
						data-style="margin-top: 2px; margin-bottom: 0px; padding: 0px; max-width: 100%; min-height: 1.5em; line-height: 2em;font-weight:bold;">
						<p class="editor" contenteditable='false'
							style="margin-top: 0px; margin-bottom: 0px; padding: 0px; max-width: 100%; min-height: 1.5em; line-height: 2em; box-sizing: border-box;">各位小伙伴们，微信图文美化编辑器正式上线了，欢迎大家多使用多提供反馈意见。使用可获得与手机端一致的显示效果。ie内核的低版本浏览器可能有不兼容的情况</p>
					</section>
				</fieldset>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>



		<div class="editor_obj_waikuang">
			<fieldset data-id="3" class="editor_obj">
				<section
					style="max-width: 100%; margin: 2px; padding: 0px; box-sizing: border-box;">
					<section
						style="max-width: 100%; margin-left: 1em; line-height: 1.4em; box-sizing: border-box; padding: 0px;">
						<span
							style="font-size: 14px; box-sizing: border-box; padding: 0px; margin: 0px;">
							<strong
							style="color: rgb(62, 62, 62); line-height: 32px; white-space: pre-wrap; box-sizing: border-box; padding: 0px; margin: 0px;">
								<span class="editor color_bg" contenteditable='false'
								data-brushtype="text" data-mce-style="color: #a5a5a5;"
								placeholder="关于编辑器"
								style="background-color: rgb(86, 159, 8); border-radius: 5px; color: rgb(255, 255, 255); padding: 4px 10px; box-sizing: border-box; margin: 0px;">关于编辑器</span>
						</strong>
						</span>
					</section>
					<section class="135brush"
						data-style="color:rgb(89, 89, 89); font-size:14px; line-height:28px"
						style="font-size: 1em; max-width: 100%; margin-top: -0.7em; padding: 10px 1em; border: 1px solid rgb(192, 200, 209); border-radius: 0.4em; color: rgb(51, 51, 51); background-color: rgb(239, 239, 239); box-sizing: border-box;">
						<p style="box-sizing: border-box; padding: 0px; margin: 0px;">
							<span class="editor" contenteditable='false'
								style="box-sizing: border-box; padding: 0px; margin: 0px;"
								placeholder="提供非常好用的微信文章编辑工具。">非常好用的在线图文编辑工具，欢迎将推荐给您的朋友，将他/她从痛苦的编辑中解脱出来。</span>
						</p>
						<p style="box-sizing: border-box; padding: 0px; margin: 0px;">
							<br style="box-sizing: border-box; padding: 0px; margin: 0px;">
						</p>
						<p
							style="text-align: center; box-sizing: border-box; padding: 0px; margin: 0px;">
							<img style="box-sizing: border-box; padding: 0px; margin: 0px;"
								alt=""
								src="http://mmbiz.qlogo.cn/mmbiz/yqVAqoZvDibHUYL1W4jVtKs2cuj8licOibPXibhFokJEACsh91ZicQd2CyFpMkwjX0S2zJLqiaqOgtDRCibEPI9dq6ic2A/0">
						</p>
					</section>
				</section>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>



		<div class="editor_obj_waikuang">
			<fieldset data-id="50638" class="editor_obj">
				<section data-width="100%"
					style="width: 100%; text-align: center; box-sizing: border-box; padding: 0px; margin: 0px;">
					<section class="color_border" data-width="100%"
						style="width: 100%; background-color: rgb(255, 255, 255); padding: 0px; border-top: 2px solid rgb(172, 29, 16); border-bottom: 2px solid rgb(172, 29, 16); color: inherit; font-size: 14px; margin: 15px 0px; display: inline-block; box-sizing: border-box;">
						<section class="color_border"
							data-style="line-height:24px;color:rgb(89, 89, 89); font-size:20px;"
							style="padding: 30px; margin: -15px 15px; border-right: 2px solid rgb(172, 29, 16); border-left: 2px solid rgb(172, 29, 16); color: inherit; box-sizing: border-box;">
							<p
								style="line-height: 24px; text-align: center; color: rgb(172, 29, 16); border-color: rgb(172, 29, 16); box-sizing: border-box; padding: 0px; margin: 0px;">
								<span
									style="color: rgb(12, 12, 12); font-size: 16px; box-sizing: border-box; padding: 0px; margin: 0px;">
									<strong class="editor" contenteditable='false'
									style="color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">请输入内容</strong>
								</span>
							</p>
						</section>
					</section>
				</section>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>



		<div class="editor_obj_waikuang">
			<fieldset data-id="53787" class="editor_obj">
				<fieldset
					style="border: medium none; margin: 0.8em 5% 0.3em; box-sizing: border-box; padding: 0px;">
					<section class="editor color_border color_wenzi"
						contenteditable='false' data-brushtype="text"
						style="color: rgb(255, 100, 80); font-size: 20px; letter-spacing: 3px; padding: 9px 4px 14px; text-align: center; margin: 0px auto; border: 4px solid rgb(255, 100, 80); border-radius: 8px; box-sizing: border-box;">
						理念<span class="editor" contenteditable='false'
							data-brushtype="text"
							style="display: block; font-size: 10px; line-height: 12px; box-sizing: border-box; padding: 0px; margin: 0px;">PHILOSOPHY</span>
					</section>
					<section class="not-right-border" data-width="0px"
						style="width: 0px; margin-right: auto; margin-left: auto; border-top: 0.6em solid rgb(255, 100, 80); border-bottom-color: rgb(255, 100, 80); height: 10px; border-left: 0.7em solid transparent ! important; border-right: 0.7em solid transparent ! important; box-sizing: border-box; padding: 0px;"></section>
				</fieldset>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>



		<div class="editor_obj_waikuang">
			<fieldset data-id="23" class="editor_obj">
				<blockquote class="editor" contenteditable='false'
					style="orphans: 2; white-space: normal; widows: 2; font-size: 14px; line-height: 22.39px; margin: 10px 0px; padding: 15px 20px 15px 45px; outline: 0px none; border: 0px none currentcolor; color: rgb(62, 62, 62); vertical-align: baseline; background-image: url(&quot;http://www.wx135.com/img/bg/left_quote.jpg&quot;); background-color: rgb(241, 241, 241); background-position: 1% 5px; background-repeat: no-repeat no-repeat; box-sizing: border-box;">这里插入分号引用样式的内容。</blockquote>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>



		<div class="editor_obj_waikuang">
			<fieldset data-id="4012" class="editor_obj">
				<fieldset
					style="margin: 0.5em 0px; padding: 0px; max-width: 100%; box-sizing: border-box; color: rgb(62, 62, 62); line-height: 25px; white-space: normal; border: 0px rgb(238, 222, 176); word-wrap: break-word !important;">
					<section data-width="100%"
						style="margin: 0px; padding: 0px; width: 100%; box-sizing: border-box; display: inline-block; text-align: center; word-wrap: break-word !important;">
						<img data-width="60px" src=""
							style="box-sizing: border-box; color: inherit; height: 65px; margin: 0px auto; padding: 0px; visibility: visible !important; width: 60px; word-wrap: break-word !important">
					</section>
					<section class="color_bg color_wenzi"
						style="margin: -2.3em 0px 0px; padding: 2em 0px 0px; max-width: 100%; box-sizing: border-box; min-height: 15em; font-size: 1em; font-weight: inherit; text-decoration: inherit; color: rgb(131, 104, 28); border-color: rgb(238, 222, 176); word-wrap: break-word !important; background-color: rgb(238, 222, 176); background-repeat: repeat;">
						<section data-width="7em"
							style="margin: 0.3em auto; padding: 0.5em; max-width: 100%; box-sizing: border-box; width: 7em; height: 3.5em; line-height: 2em; overflow: hidden; -webkit-transform: rotate(-5deg); font-size: 32px; font-weight: inherit; text-align: center; text-decoration: inherit; color: inherit; word-wrap: break-word !important; background-repeat: no-repeat; background-size: contain;">
							<section
								style="margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box; word-wrap: break-word !important;">
								<span class="editor" contenteditable='false'
									data-brushtype="text"
									style="box-sizing: border-box; color: inherit; margin: 0px; max-width: 100%; padding: 0px; word-wrap: break-word !important">公告</span>
							</section>
						</section>
						<section
							style="margin: 0px; padding: 1em; max-width: 100%; box-sizing: border-box; word-wrap: break-word !important;">
							<section class="editor" contenteditable='false'
								style="margin: 0px; padding: 0px; max-width: 100%; box-sizing: border-box; word-wrap: break-word !important; color: inherit;">
								<p style="box-sizing: border-box; padding: 0px; margin: 0px;">本背景可以换色哦~</p>
							</section>
						</section>
					</section>
				</fieldset>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>



		<div class="editor_obj_waikuang">
			<fieldset data-id="704" class="editor_obj">
				<section class="color_bg"
					style="margin: 10px 0px; border-radius: 4px; padding: 50px 0px; color: rgb(255, 255, 255); text-align: center; border-color: rgb(255, 129, 36); background-color: rgb(255, 129, 36); box-sizing: border-box;">
					<span class="editor" contenteditable='false' data-brushtype="text"
						style="border-radius: 4px; border: 1px solid rgb(251, 251, 251); color: inherit; font-size: 18px; line-height: 42px; padding: 10px 15px; box-sizing: border-box; margin: 0px;">编辑器</span>
					<section class="editor" contenteditable='false'
						style="margin-top: 30px; color: inherit; box-sizing: border-box; padding: 0px;">
						<p
							style="color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">秒刷，最易用的图文排版工具</p>
						<p
							style="color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">
							<span class="editor" contenteditable='false'
								style="color: rgb(255, 255, 255); font-family: 微软雅黑; font-size: 14px; line-height: 22.4px; text-align: center; box-sizing: border-box; padding: 0px; margin: 0px;">http://www.baidu.com</span>
						</p>
					</section>
				</section>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>



		<div class="editor_obj_waikuang">
			<fieldset data-id="31" class="editor_obj">
				<fieldset
					style="padding: 5px; border: 1px solid rgb(204, 204, 204); line-height: 24px; color: inherit; box-sizing: border-box; margin: 0px;">
					<legend data-width="auto"
						style="margin: 0px 0px 0px 15px; padding: 0px; width: auto; font-size: 16px; color: inherit; box-sizing: border-box;">
						<span
							style="color: inherit; margin: 0px; padding: 0px; box-sizing: border-box;">
							<strong
							style="color: rgb(102, 102, 102); margin: 15px 8px 0px 0px; box-sizing: border-box; padding: 0px;">
								<span class="editor color_bg" contenteditable='false'
								data-brushtype="text"
								style="background-color: rgb(145, 168, 252); border-color: rgb(145, 168, 252); border-radius: 5px; color: rgb(255, 255, 255); padding: 4px 10px; box-sizing: border-box; margin: 0px;">135编辑器</span>&nbsp;&nbsp;
						</strong> <span class="editor color_wenzi" contenteditable='false'
							data-brushtype="text"
							style="border-color: rgb(145, 168, 252); color: rgb(145, 168, 252); margin: 0px; padding: 0px; box-sizing: border-box;">ID:editor135&nbsp;&nbsp;</span>
						</span>
					</legend>
					<section class="editor" contenteditable='false'
						data-style="text-indent: 2em;;"
						style="padding: 0px; line-height: 2em; color: rgb(62, 62, 62); font-size: 14px; margin: 15px; box-sizing: border-box;">
						<p class="editor" contenteditable='false'
							style="text-indent: 2em; color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">编辑器是一个在线图文编辑工具，大量节省您排版的时间，让工作更轻松高效。</p>
					</section>
				</fieldset>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>



		<div class="editor_obj_waikuang">
			<fieldset data-id="2446" class="editor_obj">
				<section
					style="padding: 0px 8px; border-left: 3px solid rgba(163, 163, 163, 0.843); border-color: rgba(163, 163, 163, 0.843); font-size: 22px; font-weight: inherit; text-align: inherit; text-decoration: inherit; box-sizing: border-box; margin: 0px;">
					<section
						style="line-height: 1.4; box-sizing: border-box; color: inherit; padding: 0px; margin: 0px;">
						<section class="editor color_wenzi" contenteditable='false'
							data-brushtype="text"
							style="border-color: rgb(117, 117, 118); color: rgb(117, 117, 118); font-size: 20px; box-sizing: border-box; padding: 0px; margin: 0px;">标题</section>
					</section>
					<section class="135brush"
						data-style="border-color: rgb(117, 117, 118); color: inherit; font-size: 12px;"
						style="color: rgb(117, 117, 118); line-height: 1.4; margin-top: 5px; padding-left: 3px; font-size: 14px; font-weight: inherit; text-align: inherit; text-decoration: inherit; box-sizing: border-box; border-color: rgb(117, 117, 118);">
						<p class="editor color_wenzi" contenteditable='false'
							style="border-color: rgb(117, 117, 118); color: inherit; font-size: 12px; box-sizing: border-box; padding: 0px; margin: 0px;">内容描述</p>
					</section>
				</section>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>



		<div class="editor_obj_waikuang">
			<fieldset data-id="28" class="editor_obj">
				<p class="editor color_bg" contenteditable='false'
					style="margin-top: 0px; margin-bottom: 0px; font-size: 15.5556px; padding: 0px; max-width: 100%; min-height: 1.5em; line-height: 2em; word-wrap: break-word; word-break: normal; border-radius: 5px; color: rgb(255, 255, 255); text-align: center; background-color: rgb(89, 150, 235); box-sizing: border-box;">↓↓↓
					点击"阅读原文" 【查看更多信息】 &nbsp;</p>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>




		<div class="editor_obj_waikuang">
			<fieldset data-id="7282" class="editor_obj">
				<section
					style="margin-top: 5px; box-sizing: border-box; padding: 0px;">
					<section data-width="50%"
						style="width: 50%; display: inline-block; float: left; padding-right: 10px; box-sizing: border-box; margin: 0px;">
						<section
							style="padding: 20px 25px; border: 1px solid rgb(231, 231, 231); text-align: center; box-sizing: border-box; margin: 0px;">
							<p style="box-sizing: border-box; padding: 0px; margin: 0px;">
								<img src="http://img.wx135.com/135editor/logo-135-web.png"
									style="height: 50px; margin-bottom: 15px; box-sizing: border-box; padding: 0px;">
							</p>
							<h3 class="editor" contenteditable='false' data-brushtype="text"
								style="font-size: 16px; font-weight: bold; margin: 0px 0px 10px; box-sizing: border-box; padding: 0px;">编辑器</h3>
							<section
								style="box-sizing: border-box; padding: 0px; margin: 0px;"
								class="editor" contenteditable='false' data-style="clear:none;">
								<p
									style="clear: none; margin: 0px; line-height: 1.5em; box-sizing: border-box; padding: 0px;">生而排版</p>
								<p
									style="clear: none; margin: 0px; line-height: 1.5em; box-sizing: border-box; padding: 0px;">
									<span class="editor" contenteditable='false'
										style="text-align: center; box-sizing: border-box; padding: 0px; margin: 0px;">为你而美</span>
								</p>
							</section>
						</section>
					</section>
					<section data-width="50%"
						style="width: 50%; display: inline-block; float: left; padding-right: 10px; box-sizing: border-box; margin: 0px;">
						<section
							style="padding: 20px 25px; border: 1px solid rgb(231, 231, 231); text-align: center; box-sizing: border-box; margin: 0px;">
							<p style="box-sizing: border-box; padding: 0px; margin: 0px;">
								<img
									src="https://mmbiz.qlogo.cn/mmbiz/cZV2hRpuAPiazjsibqzMEbFXfnLK8n31vao2YXGwz6wxT8wBGG0FRkuzvGvIztzq8Re1R50omeH8KoicjL2HBx7gQ/0"
									style="height: 50px; margin-bottom: 15px; box-sizing: border-box; padding: 0px;">
							</p>
							<h3 class="editor" contenteditable='false' data-brushtype="text"
								style="font-size: 16px; font-weight: bold; margin: 0px 0px 10px; box-sizing: border-box; padding: 0px;">编辑器</h3>
							<section
								style="box-sizing: border-box; padding: 0px; margin: 0px;"
								class="editor" contenteditable='false' data-style="clear:none;">
								<p
									style="clear: none; margin: 0px; line-height: 1.5em; box-sizing: border-box; padding: 0px;">生而排版</p>
								<p
									style="clear: none; margin: 0px; line-height: 1.5em; box-sizing: border-box; padding: 0px;">
									<span class="editor" contenteditable='false'
										style="text-align: center; box-sizing: border-box; padding: 0px; margin: 0px;">为你而美</span>
								</p>
							</section>
						</section>
					</section>
				</section>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>




		<div class="editor_obj_waikuang">
			<fieldset data-id="34" class="editor_obj">
				<section
					style="border: 1px solid rgb(226, 226, 226); box-shadow: 0em 1em 0.1em -0.6em rgb(226, 226, 226); line-height: 1.6em; box-sizing: border-box; padding: 0px; margin: 0px;">
					<section class="color_bg"
						style="padding: 1em; color: rgb(255, 255, 255); text-align: center; font-size: 1.4em; font-weight: bold; line-height: 1.4em; box-shadow: 0em 0.2em 0.2em rgb(221, 221, 221); background-color: rgb(249, 110, 87); box-sizing: border-box; margin: 0px;">
						<span class="editor" contenteditable='false' data-brushtype="text"
							style="font-size: 1.4em; font-style: normal; box-sizing: border-box; padding: 0px; margin: 0px;">活动名称</span>
					</section>
					<section
						style="margin-top: 1.5em; text-align: left; box-sizing: border-box; padding: 0px;">
						<img data-width="30px"
							src="https://mmbiz.qlogo.cn/mmbiz/yqVAqoZvDibG89wj0CAra1LNI661MRyL7bg1eNNgx5vWHguwBSrpyJnpaokVhqkzbhPAh2ft2NDeibGUuibGqnfnQ/0?wx_fmt=png"
							style="margin-left: 1em; vertical-align: top; width: 30px; box-sizing: border-box; padding: 0px;">
						<section data-width="60%" class="editor" contenteditable='false'
							data-brushtype="text"
							style="display: inline-block; width: 60%; padding: 0.2em; margin-left: 0.5em; font-size: 1em; font-style: normal; color: inherit; box-sizing: border-box;">活动时间</section>
					</section>
					<section
						style="margin-top: 1em; text-align: left; box-sizing: border-box; padding: 0px;">
						<img data-width="30px"
							src="https://mmbiz.qlogo.cn/mmbiz/yqVAqoZvDibG89wj0CAra1LNI661MRyL7AAIicWvZTWLHlviaiboqI9UI5bicxlYghflp2821icfFib3jxwmDbosicxIOQ/0?wx_fmt=png"
							style="margin-left: 1em; vertical-align: top; width: 30px; box-sizing: border-box; padding: 0px;">
						<section data-width="60%" class="editor" contenteditable='false'
							data-brushtype="text"
							style="display: inline-block; width: 60%; padding: 0.2em; margin-left: 0.5em; font-size: 1em; color: inherit; box-sizing: border-box;">活动地点</section>
					</section>
					<section class="color_bg"
						style="display: inline-block; background-color: rgb(249, 110, 87); height: 2em; max-width: 100%; margin-top: 1.5em; line-height: 1em; box-sizing: border-box; padding: 0px;">
						<section class="editor" contenteditable='false'
							data-brushtype="text"
							style="height: 2em; max-width: 100%; padding: 0.5em 1em; color: rgb(255, 255, 255); white-space: nowrap; text-overflow: ellipsis; font-size: 1em; box-sizing: border-box; margin: 0px;">活动介绍</section>
					</section>
					<section class="editor" contenteditable='false'
						style="padding: 1em; font-size: 1em; color: inherit; box-sizing: border-box; margin: 0px;">
						请输入活动内容<br
							style="box-sizing: border-box; padding: 0px; margin: 0px;">请输入活动内容<br
							style="box-sizing: border-box; padding: 0px; margin: 0px;">请输入活动内容<br
							style="box-sizing: border-box; padding: 0px; margin: 0px;">......
					</section>
				</section>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>




		<div class="editor_obj_waikuang">
			<fieldset data-id="2497" class="editor_obj">
				<section
					style="float: left; margin: 0px 15px 10px; color: inherit; box-sizing: border-box; padding: 0px;">
					<p
						style="color: inherit; line-height: 72px; box-sizing: border-box; padding: 0px; margin: 0px;">
						<span class="editor color_wenzi" contenteditable='false'
							style="color: rgb(95, 156, 239); font-size: 72px; box-sizing: border-box; padding: 0px; margin: 0px;">08</span>
					</p>
					<p
						style="color: rgb(153, 153, 153); box-sizing: border-box; padding: 0px; margin: 0px;">
						<span class="editor" contenteditable='false'
							style="color: inherit; font-size: 24px; box-sizing: border-box; padding: 0px; margin: 0px;">Jan,2015</span>
					</p>
				</section>
				<section class="not-right-border" data-width="5px"
					style="margin: 24px 5px -20px -8px; padding: 0px; border-right: 5px solid rgb(95, 156, 239); border-left-width: 0px; border-left-color: rgb(95, 156, 239); display: inline-block; max-width: 100%; height: 5px; width: 5px; vertical-align: top; float: left; border-bottom: 5px solid transparent ! important; border-top-style: solid ! important; border-top-color: transparent ! important; word-wrap: break-word ! important; box-sizing: border-box;"></section>
				<section class="editor color_bg" contenteditable='false'
					data-brushtype="text"
					style="margin-left: 125px; line-height: 1.75em; color: rgb(255, 255, 255); padding: 15px; border-radius: 5px; background: none repeat scroll 0% 0% rgb(95, 156, 239); box-sizing: border-box;">
					<span class="editor " contenteditable='false'
						style="font-size: 14px; box-sizing: border-box; padding: 0px; margin: 0px;">平台是一个互联网运营平台，为运营者提供图文编辑工具，运营经验，收录公众号，定制开发微网站等服务，让运营更轻松高效。</span>
				</section>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>




		<div class="editor_obj_waikuang">
			<fieldset data-id="31080" class="editor_obj">
				<fieldset data-width="100%"
					style="border: 0px none; box-sizing: border-box; width: 100%; clear: both; overflow: hidden; padding: 0px; margin: 0px;">
					<section data-width="30%"
						style="box-sizing: border-box; width: 30%; float: right; text-align: right; color: inherit; vertical-align: bottom; padding: 0px; margin: 0px;">
						<img data-width="100%"
							src="http://cdnq.duitang.com/uploads/people/201410/27/20141027132457_VkETA.thumb.180_180_c.jpeg"
							style="color: inherit; display: inline-block; margin-bottom: 0px; margin-left: 10px; padding: 70px 0px 0px 10px; width: 100%; box-sizing: border-box;">
					</section>
					<section data-width="70%"
						style="box-sizing: border-box; width: 70%; float: left; padding: 0px 0px 0px 0.1em; color: inherit; margin: 0px;">
						<section class="color_bg" data-brushtype="text"
							style="margin: 0px; line-height: 1.5em; color: rgb(255, 255, 255); padding: 18px; border-radius: 50%; background: none repeat scroll 0% 0% rgb(117, 117, 118); box-sizing: border-box;">
							<section
								style="border: 0px none; padding: 0px; box-sizing: border-box; margin: 0px; font-size: 14px; font-family: 微软雅黑;"
								class="135editor" data-id="4503">
								<section
									style="margin: 14px; padding: 0px; color: rgb(117, 117, 118); box-sizing: border-box;">
									<p style="box-sizing: border-box; padding: 0px; margin: 0px;">
										<img data-width="10px"
											src="http://gtms01.alicdn.com/tps/i1/TB1VMruGpXXXXabXpXXM7dYGFXX-38-36.png"
											style="color: inherit; height: 10px; width: 10px; box-sizing: border-box; padding: 0px; margin: 0px;">
									</p>
									<section
										style="box-sizing: border-box; padding: 0px; margin: 0px;"
										class="135brush"
										data-style="background-color:rgb(117,117,118); color:rgb(255,255,255); font-size:14px; line-height:1">
										<p
											style="color: rgb(255, 255, 255); font-size: 14px; line-height: 1; text-align: left; box-sizing: border-box; padding: 0px; margin: 0px;">
											<span class="editor" contenteditable='false'
												style="font-size: 16px; box-sizing: border-box; padding: 0px; margin: 0px;">你年轻么？</span>
										</p>
										<p
											style="color: rgb(255, 255, 255); font-size: 14px; line-height: 1; text-align: center; box-sizing: border-box; padding: 0px; margin: 0px;">
											<span class="editor" contenteditable='false'
												style="font-size: 16px; box-sizing: border-box; padding: 0px; margin: 0px;">不要紧，</span>
										</p>
										<p
											style="color: rgb(255, 255, 255); font-size: 14px; line-height: 1; text-align: right; box-sizing: border-box; padding: 0px; margin: 0px;">
											<span class="editor" contenteditable='false'
												style="font-size: 16px; box-sizing: border-box; padding: 0px; margin: 0px;">过两年就老了。</span>
										</p>
									</section>
									<p
										style="color: rgb(255, 255, 255); font-size: 14px; line-height: 1; text-align: right; box-sizing: border-box; padding: 0px; margin: 0px;">
										<img data-width="10px"
											src="http://gtms02.alicdn.com/tps/i2/TB1zQbsGpXXXXX1XFXXM7dYGFXX-38-36.png"
											style="color: inherit; height: 10px; line-height: 1.6em; text-align: right; width: 10px; box-sizing: border-box; padding: 0px; margin: 0px;">
									</p>
								</section>
							</section>
						</section>
						<section class="not-right-border" data-width="73px"
							style="margin: 0px; padding: 0px; border-right: 25px solid rgb(117, 117, 118); border-left-width: 0px; border-left-color: rgb(117, 117, 118); display: inline-block; max-width: 100%; height: 15px; width: 73px; vertical-align: top; float: right; border-bottom: 12px solid transparent ! important; border-top-style: solid ! important; border-top-color: transparent ! important; word-wrap: break-word ! important; box-sizing: border-box; color: inherit; transform: rotate(230deg);"></section>
					</section>
				</fieldset>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>




		<div class="editor_obj_waikuang">
			<fieldset data-id="84185" class="editor_obj">
				<section class="color_border"
					style="border-top: 4px solid rgb(33, 33, 34); box-sizing: border-box; padding: 0px; margin: 0px;">
					<section data-width="115px" class="color_bg"
						data-style="margin: 5px 10px 0px 10px; box-sizing: border-box; padding: 0px;font-size:24px; line-height:normal; color:rgb(255, 255, 255);"
						style="float: left; display: inline-block; width: 115px; height: 95px; border-radius: 0px 0px 120px; box-sizing: border-box; padding: 10px; margin: 0px; background-color: rgb(33, 33, 34); line-height: 1em;">
						<p
							style="margin: 5px 10px 0px 10px; box-sizing: border-box; padding: 0px; letter-spacing: 4px;">
							<span class="editor" contenteditable='false'
								style="box-sizing: border-box; color: rgb(255, 255, 255); font-size: 24px; line-height: normal; margin: 0px; padding: 0px">精品</span>
						</p>
						<p
							style="margin: 0 10px; box-sizing: border-box; padding: 0px; letter-spacing: 1px;">
							<span class="editor" contenteditable='false'
								style="box-sizing: border-box; color: rgb(255, 255, 255); font-size: 14px; margin: 0px; padding: 0px">Best</span>
						</p>
					</section>
					<section data-width="55%" class="color_wenzi"
						data-style="box-sizing: border-box; padding:10px; margin: 0px;line-height:2em;font-size:24px"
						style="width: 55%; margin: 15px 0px 10px; display: inline-block; float: right; box-sizing: border-box; padding: 0px; text-align: right;">
						<p
							style="box-sizing: border-box; padding: 10px; margin: 0px; line-height: 2em; color: rgb(33, 33, 34);">
							<span
								style="font-size: 24px; box-sizing: border-box; padding: 0px; margin: 0px;"><strong
								class="editor color_wenzi" contenteditable='false'
								style="font-size: 24px; box-sizing: border-box; padding: 0px; margin: 0px;">编辑器微信排版</strong></span>
						</p>
					</section>
				</section>
				<section class="135brush"
					data-style="box-sizing: border-box; padding: 0px; margin: 0px; line-height: 1.75em;font-size: 14px; color: rgb(12, 12, 12);"
					style="margin: 5px 0px; box-sizing: border-box; padding: 0px;">
					<p
						style="box-sizing: border-box; padding: 0px; margin: 0px; line-height: 1.75em;">
						<span class="editor" contenteditable='false'
							style="color: rgb(12, 12, 12); font-size: 14px; box-sizing: border-box; padding: 0px; margin: 0px;">微信图文美化编辑器提供美化微信图文消息的功能,有非常多漂亮的样式,可直接插入编辑区域然后修改文字即可,轻松编辑非常美观的微信图文消息。</span>
					</p>
				</section>
				<fieldset
					style="clear: both; padding: 0px; border: 0px none; margin: 10px 0px; box-sizing: border-box;">
					<section
						style="font-size: 1em; font-weight: inherit; text-decoration: inherit; color: rgb(255, 255, 255); box-sizing: border-box; padding: 0px; margin: 0px;">
						<fieldset
							style="text-align: right; border: 0px rgb(33, 33, 34); margin: 2px 0px 0px; padding: 0px; color: inherit; box-sizing: border-box;">
							<section class="not-right-border" data-width="0px"
								style="display: inline-block; vertical-align: top; font-size: 16px; width: 0px; height: 0px; border-style: solid; border-width: 0px 0px 32px 20px; border-color: transparent transparent rgb(33, 33, 34); z-index: 3; color: inherit; padding: 0px; margin-right: -4px; box-sizing: border-box;"></section>
							<section
								style="display: inline-block; font-size: 14px; font-family: inherit; font-weight: inherit; text-align: inherit; text-decoration: inherit; color: inherit; border-color: rgb(33, 33, 34); box-sizing: border-box; padding: 0px; margin: 0px; background-color: transparent;">
								<section class="color_bg"
									style="display: inline-block; line-height: 1.4em; padding: 5px 10px; height: 32px; vertical-align: top; font-size: 14px; font-family: inherit; font-weight: bold; float: right; color: inherit; border-color: rgb(85, 85, 85); margin: 0px; box-sizing: border-box; background-color: rgb(33, 33, 34);">
									<p style="box-sizing: border-box; padding: 0px; margin: 0px;">
										<span class="editor" contenteditable='false'
											data-brushtype="text"
											style="font-family: 微软雅黑; box-sizing: border-box; padding: 0px; margin: 0px;">查看更多精彩内容&gt;&gt;</span>
									</p>
								</section>
							</section>
						</fieldset>
					</section>
				</fieldset>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>




		<div class="editor_obj_waikuang">
			<fieldset data-id="85537" class="editor_obj">
				<fieldset
					style="border: 0px none; padding: 0px; text-align: center; box-sizing: border-box; margin: 0px;">
					<fieldset class="color_border"
						style="margin-top: 20px; padding: 0px 5px; line-height: 10px; border: 1px solid rgb(30, 155, 232); margin-bottom: -10px; box-sizing: border-box;">
						<section data-width="20%"
							style="color: inherit; padding: 0px; font-size: 16px; height: 8px; margin: -5px 0px 0px 40%; width: 20%; text-align: center; background-color: rgb(254, 254, 254); box-sizing: border-box;">
							<section class="color_bg" data-width="8px"
								style="width: 8px; height: 8px; border-radius: 100%; line-height: 1; box-sizing: border-box; font-size: 18px; text-decoration: inherit; border-color: rgb(138, 193, 226); display: inline-block; margin: 0px; color: rgb(255, 255, 255); background-color: rgb(30, 155, 232); float: left; padding: 0px;"></section>
							<section class="color_bg" data-width="2.5em"
								style="width: 2.5em; height: 2.5em; border-radius: 50%; background-color: rgb(30, 155, 232); display: inline-block; line-height: 40px; margin-top: -15px; color: rgb(255, 255, 255); border-color: rgb(138, 193, 226); box-sizing: border-box; padding: 0px;">
								<strong title="" data-original-title="" class="editor"
									contenteditable='false'
									style="color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">2</strong>
							</section>
							<section class="color_bg" data-width="8px"
								style="width: 8px; height: 8px; border-radius: 100%; line-height: 1; box-sizing: border-box; font-size: 18px; text-decoration: inherit; border-color: rgb(138, 193, 226); display: inline-block; margin: 0px; color: rgb(255, 255, 255); background-color: rgb(30, 155, 232); float: right; padding: 0px;"></section>
						</section>
						<section
							style="padding: 15px 10px 30px; font-size: 14px; margin: 15px 0px 0px; display: inline-block; box-sizing: border-box;">
							<p
								style="color: inherit; text-align: center; line-height: 1.75em; box-sizing: border-box; padding: 0px; margin: 0px;">
								<strong
									style="color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;"><span
									class="editor color_wenzi" contenteditable='false'
									data-brushtype="text"
									style="border-color: rgb(30, 155, 232); color: rgb(30, 155, 232); font-size: 28px; box-sizing: border-box; padding: 0px; margin: 0px;">ONEPAGE</span></strong>
							</p>
							<section
								style="box-sizing: border-box; padding: 0px; margin: 0px;"
								class="135brush">
								<p
									style="text-indent: 0em; line-height: 1.75em; text-align: left; box-sizing: border-box; padding: 0px; margin: 0px;">
									<span class="editor" contenteditable='false'
										style="color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">用户们请注意，自动回复功能已经上线。微信自带的三种回复模式都可以使用，请大家根据自己的需求，重新设置自动回复。当然，您也可以将微信的自动回复设置直接下载即可生效。</span>
								</p>
							</section>
						</section>
					</fieldset>
					<section class="color_bg"
						style="padding: 10px; background-color: rgb(30, 155, 232); font-size: 16px; color: rgb(255, 255, 255); text-align: center; margin: -15px auto 0px; display: inline-block; border-color: rgb(138, 193, 226); border-radius: 5px; box-sizing: border-box;">
						<p class="editor " contenteditable='false'
							style="color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">
							<strong class="editor " contenteditable='false'
								style="color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">SEE
								MORE →</strong>
						</p>
					</section>
				</fieldset>
			</fieldset>
			<p class="gehang_p">
				<br>
			</p>
		</div>




		<div class="editor_obj_waikuang">
			<fieldset data-id="85514" class="editor_obj">
				<section class="color_border"
					style="margin: 3px; padding: 10px; color: rgb(62, 62, 62); line-height: 24px; border: 3px solid rgb(30, 155, 232); border-radius: 8px; box-sizing: border-box;">
					<fieldset
						style="border: 0px none rgb(30, 155, 232); margin: 0px; clear: both; box-sizing: border-box; padding: 0px; color: inherit;">
						<section class="color_bg" data-width="6px"
							style="color: rgb(255, 255, 255); float: right; width: 6px; border-radius: 50%; margin-bottom: -3px; height: 6px ! important; box-shadow: 0px 0px 5px rgb(117, 117, 117); border-color: rgb(138, 193, 226); background-color: rgb(30, 155, 232); box-sizing: border-box; padding: 0px;"></section>
						<section class="color_bg" data-width="6px"
							style="color: rgb(255, 255, 255); text-align: left; width: 6px; border-radius: 50%; margin-bottom: -2px; height: 6px ! important; box-shadow: 0px 0px 5px rgb(117, 117, 117); border-color: rgb(138, 193, 226); background-color: rgb(30, 155, 232); box-sizing: border-box; padding: 0px;"></section>
					</fieldset>

					<section class="135brush"
						data-style="color:rgb(33,33,33);text-align:center;"
						style="margin: 0px; padding: 10px; box-sizing: border-box;">
						<p
							style="color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">
							<br style="box-sizing: border-box; padding: 0px; margin: 0px;">
						</p>
						<p
							style="color: inherit; text-align: center; box-sizing: border-box; padding: 0px; margin: 0px;">
							<span class="editor" contenteditable='false'
								style="color: rgb(0, 0, 0); box-sizing: border-box; padding: 0px; margin: 0px;">输入正文内容</span>
						</p>
						<p
							style="color: inherit; box-sizing: border-box; padding: 0px; margin: 0px;">
							<br style="box-sizing: border-box; padding: 0px; margin: 0px;">
						</p>
					</section>
					<fieldset
						style="border: 0px none rgb(30, 155, 232); margin: 0px; clear: both; box-sizing: border-box; padding: 0px; color: inherit;">
						<section class="color_bg" data-width="6px"
							style="color: rgb(255, 255, 255); float: right; width: 6px; border-radius: 50%; margin-bottom: -3px; height: 6px ! important; box-shadow: 0px 0px 5px rgb(117, 117, 117); border-color: rgb(138, 193, 226); background-color: rgb(30, 155, 232); box-sizing: border-box; padding: 0px;"></section>
						<section class="color_bg" data-width="6px"
							style="color: rgb(255, 255, 255); text-align: left; width: 6px; border-radius: 50%; margin-bottom: -2px; height: 6px ! important; box-shadow: 0px 0px 5px rgb(117, 117, 117); border-color: rgb(138, 193, 226); background-color: rgb(30, 155, 232); box-sizing: border-box; padding: 0px;"></section>
					</fieldset>
				</section>
				<p style="box-sizing: border-box; padding: 0px; margin: 0px;">
					<br style="box-sizing: border-box; padding: 0px; margin: 0px;">
				</p>
			</fieldset>


			<p class="gehang_p">
				<br>
			</p>
		</div>


	</div>
</body>

</html>