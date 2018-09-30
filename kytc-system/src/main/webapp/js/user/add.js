/**
 * 用户添加.js
 */
$(function(){
	var main_div = $("#kytc_system_user_add_main_div");
	var parent_main_div = $("#kytc_system_user_main_div");
	var parent_main_div_list = $("#kytc_system_user_main_div_list");
	$("#kytc_system_user_add_title_main_div").title();
	$("#kytc_system_user_add_dept_main_div").department();
	main_div.off().on("click","a[name='save']",function(){
		if(main_div.form('validate')){
			var jsonData = main_div.toJSON();
			$.ajax({
				url:$.system.url+"user/add",
				type:"post",
				data:jsonData,
				dataType:"json",
				success:function(data){
					if(data.state){
						parent_main_div_list.datagrid('reload',$("form[name='search_form']",parent_main_div).toJSON());
						$.EasyUI.Window.close(main_div);
					}else{
						$.EasyUI.message(data.reason,"s",null);
						return;
					}
				}
			})
		}
	}).on("click","a[name='close']",function(){
		$.EasyUI.Window.close(main_div);
	});
	$.common.uploadImg({
		uploadId:$("a[name='upload']",main_div),
		formId:$("form[name='file']",main_div),
		fileId:$("input[name='file']",main_div),
		previewId:$("img[name='preview']",main_div),
		hiddenId:$("input[name='headPicture']",main_div),
		before:function(){return true;},
		success:function(){}
	});
})