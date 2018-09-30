/**
 * 用户添加.js
 */
$(function(){
	var main_div = $("#kytc_system_title_update_main_div");
	var parent_main_div = $("#kytc_system_title_main_div");
	var parent_main_div_list = $("#kytc_system_title_main_div_list");
	$("#kytc_system_title_update_parent_main_div").title();
	main_div.off().on("click","a[name='close']",function(){
		$.EasyUI.Window.close(main_div);
	}).on("click","a[name='save']",function(){
		var jsonData = main_div.toJSON();
		var parentId = $("#kytc_system_title_update_parent_main_div").combobox("getValue");
		var id = $("input[name='id']",main_div).val();
		if(parentId==id){
			$.EasyUI.message("不能以自己作为上级","s",null);
			return;
		}
		$.ajax({
			url:$.system.url+"title/update",
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