/**
 * 用户添加.js
 */
$(function(){
	var main_div = $("#kytc_system_title_add_main_div");
	var parent_main_div = $("#kytc_system_title_main_div");
	var parent_main_div_list = $("#kytc_system_title_main_div_list");
	$("input[name='parentId']",main_div).combobox({     
	    url:$.system.url+"title/dropdown",     
	    valueField:'value',     
	    textField:'text',
	    method:"get"
	});  
	main_div.off().on("click","a[name='close']",function(){
		$.EasyUI.Window.close(main_div);
	}).on("click","a[name='save']",function(){
		var jsonData = main_div.toJSON();
		$.ajax({
			url:$.system.url+"title/add",
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
	});
})