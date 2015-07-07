$(function(){
	    var obj=null;
		$('#edit_new_edit').on("click",".editor_obj",function(){
				obj = $(this);
				$('.delete_obj').remove();
				$(this).addClass('border_').siblings().removeClass('border_');
				$(this).append('<div class="delete_obj"><img src="../images/qinkong.png"><p>删除</p></div>');	

				//删除该元素
				$('.delete_obj').click(function(event){
					$(this).parents('.editor_obj').next().remove();
					$(this).parents('.editor_obj').remove();
					 event.stopPropagation();
				})
		});
		$('#edit_new_edit').on("click",".upload",function(){
			$('.upload_out').show();
			selected_obj = $(this);
		});



		$('.color-swatch').click(function(){
			var color_now=$(this).css('background-color');
			//显示选择的颜色值
			$('#custom-color-text').val(color_now);
			$('#custom-color-text').css('background-color',color_now);


			obj.find('.color_bg').css('background-color',color_now);
			obj.find('.color_border').css('border-color',color_now);
			obj.find('.color_wenzi').css('color',color_now);
			//特别的标题
			if(obj.attr('data-id')=='32290'){
				obj.find('.not-right-border').css('border-right-color','#fff');
			}else if(obj.attr('data-id')=='27'){
				obj.find('.not-right-border').css({'border-color': 'transparent transparent '+color_now});
			}
			else if(obj.attr('data-id')=='25'){
				obj.find('.not-right-border').css({'border-color': color_now+' transparent '});
			}
			else if(obj.attr('data-id')=='49'){
				obj.find('.not-right-border').css({'text-shadow': '1px 0px 4px '+ color_now + ', 0px 1px 4px ' + color_now + ', 0px -1px 4px ' +color_now+', -1px 0px 4px '+color_now});
			}
			else if(obj.attr('data-id')=='85511'){
				obj.find('.not-right-border').css('border-color',color_now +' transparent '+ color_now +' transparent' );
			}
			//特别的正文
			else if(obj.attr('data-id')=='14'){
				obj.find('.not-right-border').css('border-color','#eee #eee #eee '+color_now);
			}
			else if(obj.attr('data-id')=='53787'){
				obj.find('.not-right-border').css('border-color',color_now+' transparent '+color_now+' transparent ');
			}
			else if(obj.attr('data-id')=='4012'){
				obj.find('.color_wenzi').css('color','#fff');
			}
			else if(obj.attr('data-id')=='2497'){
				obj.find('.not-right-border').css('border-color',' transparent '+color_now);
			}
			else if(obj.attr('data-id')=='31080'){
				obj.find('.not-right-border').css('border-color',' transparent '+color_now);
			}
			else if(obj.attr('data-id')=='84185'){
				obj.find('.not-right-border').css('border-color',' transparent transparent  '+color_now);
			}
		})
	});
	//取消上传文件
	function closeupload(){
		$('.upload_out').hide();
	}