/**
 * 用户添加.js
 */
$(function(){
	var main_div = $("#kytc_system_premission_update_main_div");
	var parent_main_div = $("#kytc_system_premission_main_div");
	var parent_main_div_list = $("#kytc_system_premission_main_div_list");
	$("#kytc_system_premission_update_main_div_project").dic({
		type:"KYTC_PROJECT"
	});
	$("#kytc_system_premission_update_main_div_moudle").dic({
		parentType:"KYTC_PROJECT",
		type:"KYTC_MODULE",
		parentDic:$("#kytc_system_premission_update_main_div_project")
	});
	$("#kytc_system_premission_update_main_div_menu").dic({
		parentType:"KYTC_MODULE",
		type:"KYTC_MENU",
		parentDic:$("#kytc_system_premission_update_main_div_moudle")
	});
	$("#kytc_system_premission_update_main_div_operator").dic({
		type:"KYTC_OPERATOR"
	});
	main_div.off().on("click","a[name='save']",function(){
		if(main_div.form('validate')){
			var jsonData = main_div.toJSON();
			$.ajax({
				url:$.system.url+"premission/update",
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
})