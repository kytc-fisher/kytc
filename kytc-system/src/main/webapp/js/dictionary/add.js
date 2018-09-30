/**
 * 用户添加.js
 */
$(function(){
	var main_div = $("#kytc_system_dictionary_add_main_div");
	var parent_main_div = $("#kytc_system_dictionary_main_div");
	var parent_main_div_list = $("#kytc_system_dictionary_main_div_list");
	$("#kytc_system_dictionary_add_main_div_type").dicType();
	$("#kytc_system_dictionary_add_main_div_parent_type").dicType();
	$("#kytc_system_dictionary_add_main_div_parent_code").dic({
		parentDicType:$("#kytc_system_dictionary_add_main_div_parent_type")
	});
	main_div.off().on("click","a[name='save']",function(){
		if(main_div.form('validate')){
			var jsonData = main_div.toJSON();
			if(jsonData.type==jsonData.parentType){
				$.EasyUI.message("不能选择自己作为上级字典类型","e");
				return;
			}
			$.ajax({
				url:$.system.url+"dictionary/add",
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